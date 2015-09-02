package br.gov.bcb.rest.component.grid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by deinf.osvaldo on 31/08/2015.
 */
public interface RepositoryReader {

    Page read(CrudRepository<?,?> repository, PageRequest pageRequest);


}
