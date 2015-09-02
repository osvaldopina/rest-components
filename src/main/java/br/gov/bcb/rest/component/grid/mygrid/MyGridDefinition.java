package br.gov.bcb.rest.component.grid.mygrid;

import br.gov.bcb.rest.component.grid.Column;
import br.gov.bcb.rest.component.grid.GridDefinition;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by deinf.osvaldo on 27/08/2015.
 */
@Component
public class MyGridDefinition implements GridDefinition {



    private Map<String,Column> columns = new HashMap<>();

    private Column identifier;

    public MyGridDefinition() {
        identifier = new Column("id", "id", "Identificador Conta", true, true);
        columns.put("id",  identifier);
        columns.put("codigo", new Column("codigo", "Codigo", "Codigo Conta", true));
        columns.put("nome", new Column("nome", "Nome", "Nome Conta", true));
        columns.put("descricao", new Column("descricao", "Descricao", "Descricao Conta", true));
        columns.put("baseNormativa", new Column("baseNormativa", "Base Normativa", "Base Normativa", true));
    }


    @Override
    public Collection<Column> getColumns() {
        return columns.values();
    }

    @Override
    public Column getColumn(String id) {
        return columns.get(id);
    }

    @Override
    public Column getIdentifier() {
        return identifier;
    }
}
