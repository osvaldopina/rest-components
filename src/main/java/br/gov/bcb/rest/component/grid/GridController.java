package br.gov.bcb.rest.component.grid;

import br.gov.bcb.rest.component.grid.domain.Conta;
import br.gov.bcb.rest.component.grid.domain.ContaRepository;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by deinf.osvaldo on 26/08/2015.
 */
@Controller
public class GridController {

    @Autowired
    private GridDefinition gridDefinition;

    @Autowired
    private ContaRepository contaRepository;

    @RequestMapping("/grid")
    @ResponseBody
    public ResponseEntity<GridInstance>  grid(@RequestParam("columns")List<String> columns) {

        Iterable<Conta>  contas = contaRepository.findAll();

        List<Row> rows = new ArrayList<>();
        for(Conta conta:contas) {
            rows.add(new Row(conta.getId().toString(), conta.getCodigo(), conta.getNome(), conta.getDescricao(), conta.getBaseNormativa()));
        }

        return  new ResponseEntity<GridInstance>(new GridInstance(gridDefinition,new GridData(rows)), HttpStatus.OK);
    }
}
