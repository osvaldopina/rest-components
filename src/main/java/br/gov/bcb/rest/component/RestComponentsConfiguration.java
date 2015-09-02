package br.gov.bcb.rest.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by deinf.osvaldo on 31/08/2015.
 */
@Component
@ConfigurationProperties(prefix = "rest-components")
public class RestComponentsConfiguration {

    private int gridDefaultPageSize = 20;


    public int getGridDefaultPageSize() {
        return gridDefaultPageSize;
    }

    public void setGridDefaultPageSize(int gridDefaultPageSize) {
        this.gridDefaultPageSize = gridDefaultPageSize;
    }
}
