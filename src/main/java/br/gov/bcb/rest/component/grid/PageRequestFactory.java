package br.gov.bcb.rest.component.grid;

import br.gov.bcb.rest.component.RestComponentsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deinf.osvaldo on 31/08/2015.
 */
@Component
public class PageRequestFactory {

    @Autowired
    private RestComponentsConfiguration restComponentsConfiguration;


    public PageRequest create(Integer page, Integer size, List<String> sort, GridDefinition gridDefinition) {
        if (page == null && (sort == null || sort.size() == 0)) {
            return new PageRequest(0, getPageSize(size));
        }
        List<Sort.Order> sortOrders = new ArrayList<>();
        Sort sortValue= null;

        if (sort != null) {
            for (String sortColumnName : sort) {
                sortOrders.add(createSort(sortColumnName, gridDefinition));
            }
            if (sortOrders.size() > 0) {
                sortValue = new Sort(sortOrders);
            }
        }

        return new PageRequest(getPage(page), getPageSize(size), sortValue);
    }

    public boolean isDefault(PageRequest pageRequest) {
        return pageRequest.getPageNumber() == 0 &&
                pageRequest.getPageSize() == 0 &&
                pageRequest.getSort() == null;
    }

    private Sort.Order createSort(String sort, GridDefinition gridDefinition) {
        String columnName;
        if (sort.startsWith("-")) {
            return new Sort.Order(Sort.Direction.DESC,  validateColumnName(sort.substring(1), gridDefinition));
        } else if (sort.startsWith("+")) {
            return new Sort.Order(Sort.Direction.ASC, validateColumnName(sort.substring(1), gridDefinition));
        } else {
            return new Sort.Order(Sort.Direction.ASC, validateColumnName(sort, gridDefinition));
        }
    }

    private String validateColumnName(String columnName, GridDefinition gridDefinition) {
        if (gridDefinition.getColumn(columnName) == null) {
            throw new IllegalStateException("Trying to sort a non existing column ");
        }
        else {
            return columnName;
        }
    }

    private int getPageSize(Integer size) {
        if (size == null) {
            return restComponentsConfiguration.getGridDefaultPageSize();
        } else {
            return size;
        }
    }

    private int getPage(Integer page) {
        if (page == null) {
            return 0;
        }
        else {
            return page;
        }
    }
}
