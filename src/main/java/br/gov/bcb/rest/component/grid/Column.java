package br.gov.bcb.rest.component.grid;

/**
 * Created by deinf.osvaldo on 26/08/2015.
 */
public interface Column<T> {

    String getId();

    String getName();

    String getDescription();

    boolean isSorteable();

    String getValue(T data);
}
