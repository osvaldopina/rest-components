package br.gov.bcb.rest.component.grid;

import br.gov.bcb.rest.component.PageInfo;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;

/**
 * Created by deinf.osvaldo on 26/08/2015.
 */
public class GridData {

    private List<Row> rows;

    private PageInfo pageInfo;

    public GridData(List<Row> rows, PageInfo pageInfo) {
        this.rows = rows;
        this.pageInfo = pageInfo;
    }

    @JsonProperty("values")
    public List<Row> getRows() {
        return rows;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }
}
