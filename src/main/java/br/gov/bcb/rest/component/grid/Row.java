package br.gov.bcb.rest.component.grid;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by deinf.osvaldo on 26/08/2015.
 */
public class Row {

    private List<String> cells = new ArrayList<>();

    public Row(List<String> cells) {
        this.cells.addAll(cells);
    }

    public Row(Object ... values) {

        for(Object value:values) {
            cells.add(value.toString());
        }
    }

    @JsonValue
    public List<String> getCells() {
        return cells;
    }
}
