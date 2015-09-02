package br.gov.bcb.rest.component.grid;

/**
 * Created by deinf.osvaldo on 26/08/2015.
 */
public class Column {

    private String id;

    private String name;

    private String description;

    private boolean sorteable;

    private boolean identificator;


    public Column(String id, String name, String description, boolean sorteable) {
        this(id, name, description, sorteable, false);
    }

    public Column(String id, String name, String description, boolean sorteable, boolean identificator) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sorteable = sorteable;
        this.identificator = identificator;
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

    public boolean isIdentificator() {
        return identificator;
    }
}
