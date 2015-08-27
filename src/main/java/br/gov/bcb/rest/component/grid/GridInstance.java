package br.gov.bcb.rest.component.grid;

/**
 * Created by deinf.osvaldo on 26/08/2015.
 */
public class GridInstance {

    private GridDefinition gridDefinition;

    private GridData gridData;

    public GridInstance(GridDefinition gridDefinition, GridData gridData) {
        this.gridDefinition = gridDefinition;
        this.gridData = gridData;
    }

    public GridDefinition getGridDefinition() {
        return gridDefinition;
    }

    public GridData getGridData() {
        return gridData;
    }
}
