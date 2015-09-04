package br.gov.bcb.rest.component.grid;

import br.gov.bcb.rest.component.PageInfo;
import br.gov.bcb.rest.component.grid.domain.Conta;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by deinf.osvaldo on 26/08/2015.
 */
@Controller
public class GridController {

    @Autowired
    private GridDefinition gridDefinition;

    @Autowired
    private CrudRepository<?,?> repository;

    @Autowired
    private PageRequestFactory pageRequestFactory;

    @RequestMapping("/grid")
    @ResponseBody
    public ResponseEntity<Resource<GridInstance>> grid(
            @RequestParam("columns") List<String> columns,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer pageSize,
            @RequestParam(value = "sort", required = false) List<String> sort) {


        PageRequest pageRequest = pageRequestFactory.create(page, pageSize, sort, gridDefinition);
        Iterable<?> dataset;
        PageInfo pageInfo = null;
        if (repository instanceof PagingAndSortingRepository<?,?>) {
            Page dataPage  = ((PagingAndSortingRepository<?, ?>) repository).findAll(pageRequest);
            dataset = dataPage;
            pageInfo = new PageInfo(dataPage.getSize(), dataPage.getNumberOfElements(), dataPage.getTotalPages(), dataPage.getNumber());
        }
        else {
            dataset = repository.findAll();
        }

        List<Column> usedColumns = getUsedColuns(gridDefinition, columns);

        List<Row> rows = new ArrayList<>();
        List<Cell> cells;
        int totalElements = 0;

        for(Object dataValue:dataset) {
            cells = new ArrayList<>();
            Column identifier = gridDefinition.getIdentifier();
            String identifierValue;

            PropertyDescriptor identifierProperty = BeanUtils.getPropertyDescriptor(Conta.class, identifier.getId());

            if (identifierProperty == null) {
                identifierValue = null;
            }
            else {
                Object identifierObjectValue = ReflectionUtils.invokeMethod(identifierProperty.getReadMethod(), dataValue);
                identifierValue = identifierObjectValue == null?"":identifierObjectValue.toString();
            }

            for (Column usedColumn : usedColumns) {

                PropertyDescriptor usedProperty = BeanUtils.getPropertyDescriptor(Conta.class, usedColumn.getId());

                if (usedProperty == null) {
                    throw new IllegalStateException("Could not find column '" + usedColumn.getId() + "'  as a property in type " + Conta.class);
                }

                Object propertyValue = ReflectionUtils.invokeMethod(usedProperty.getReadMethod(), dataValue);

                cells.add(new Cell(identifierValue, propertyValue == null?"":propertyValue.toString()));

            }
            rows.add(new Row(cells));
            totalElements ++;
        }
        if (pageInfo == null) {
            pageInfo = new PageInfo(totalElements, totalElements, 1, 0);
        }
        GridInstance gridInstance = new GridInstance(gridDefinition, new GridData(rows, pageInfo));

        Resource<GridInstance> resource = new Resource<>(gridInstance);

         Link self  = ControllerLinkBuilder.linkTo(GridController.class).slash('/').withSelfRel();

        resource.add(self);


        return new ResponseEntity<Resource<GridInstance>>(resource , HttpStatus.OK);

    }

    private List<Column> getUsedColuns(GridDefinition gridDefinition, List<String> columns) {
        List<Column> usedColumns = new ArrayList<>();
        for(String usedColum: columns) {
            usedColumns.add(gridDefinition.getColumn(usedColum));
        }
        return usedColumns;
    }
}
