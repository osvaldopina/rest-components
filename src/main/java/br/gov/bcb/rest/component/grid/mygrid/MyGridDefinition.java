package br.gov.bcb.rest.component.grid.mygrid;

import br.gov.bcb.rest.component.grid.Column;
import br.gov.bcb.rest.component.grid.GridDefinition;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by deinf.osvaldo on 27/08/2015.
 */
@Component
public class MyGridDefinition implements GridDefinition {

    private List<Column> columns = new ArrayList<>();

    public MyGridDefinition() {
        columns.add(new Column("codigo", "Codigo", "Codigo Conta", true));
        columns.add(new Column("nome", "Nome", "Nome Conta", true));
        columns.add(new Column("descricao", "Descricao", "Descricao Conta", true));
        columns.add(new Column("baseNormativa", "Base Normativa", "Base Normativa", true));
    }


    @Override
    public List<Column> getColumns() {
        return columns;
    }
}
