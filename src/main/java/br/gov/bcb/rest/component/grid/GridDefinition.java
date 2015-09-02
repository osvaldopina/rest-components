package br.gov.bcb.rest.component.grid;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;
import java.util.List;

/**
 * Created by deinf.osvaldo on 26/08/2015.
 */
public interface GridDefinition {

    Collection<Column> getColumns();

    Column getColumn(String id);

    @JsonIgnore
    Column getIdentifier();

}
