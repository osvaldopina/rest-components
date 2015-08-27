package br.gov.bcb.rest.component.grid;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;

/**
 * Created by deinf.osvaldo on 26/08/2015.
 */
public class GridData {

    private List<Row> rows;


    public GridData(List<Row> rows) {
        this.rows = rows;
    }

    @JsonValue
    public List<Row> getRows() {
        return rows;
    }
}
