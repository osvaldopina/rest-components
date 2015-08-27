package br.gov.bcb.rest.component.grid;

/**
 * Created by deinf.osvaldo on 26/08/2015.
 */
public class Column {

    private String id;

    private String name;

    private String description;

    private boolean sorteable;

    public Column(String id, String name, String description, boolean sorteable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sorteable = sorteable;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isSorteable() {
        return sorteable;
    }
}
