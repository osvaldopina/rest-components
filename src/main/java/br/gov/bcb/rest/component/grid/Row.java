package br.gov.bcb.rest.component.grid;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by deinf.osvaldo on 26/08/2015.
 */
public class Row {

    private List<Cell> cells = new ArrayList<>();

    public Row(List<Cell> cells) {
        this.cells.addAll(cells);
    }

    @JsonValue
    public List<Cell> getCells() {
        return cells;
    }
}
