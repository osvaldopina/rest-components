package br.gov.bcb.rest.component.grid;

/**
 * Created by deinf.osvaldo on 31/08/2015.
 */
public class Cell {

    private String id;

    private String value;


    public Cell(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public Cell(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
