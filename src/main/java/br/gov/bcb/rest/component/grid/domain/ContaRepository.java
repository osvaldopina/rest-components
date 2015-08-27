package br.gov.bcb.rest.component.grid.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

/**
 * Created by deinf.osvaldo on 26/08/2015.
 */
public interface ContaRepository extends PagingAndSortingRepository<Conta, Integer> {
}
