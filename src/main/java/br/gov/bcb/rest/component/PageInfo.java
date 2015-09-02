package br.gov.bcb.rest.component;

/**
 * Created by deinf.osvaldo on 01/09/2015.
 */
public class PageInfo {

    private int size;

    private int totalElements;

    private int totalPages;

    private int number;

    public PageInfo(int size, int totalElements, int totalPages, int number) {
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getNumber() {
        return number;
    }
}
