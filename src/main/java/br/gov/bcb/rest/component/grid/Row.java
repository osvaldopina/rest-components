package br.gov.bcb.rest.component.grid;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.List;

/**
 * Created by deinf.osvaldo on 26/08/2015.
 */
public class Row {

    private List<String> cells;

    public Row(List<String> cells) {
        this.cells = cells;
    }

    public Row(String ... cells) {
        this.cells = Arrays.asList(cells);
    }

    @JsonValue
    public List<String> getCells() {
        return cells;
    }
}
