package com.gmail.andreyzarazka.publicbid.repository;

import com.gmail.andreyzarazka.publicbid.model.Contract;
import org.springframework.data.repository.CrudRepository;

/**
 * @author <a href="mailto:andreyzarazka@gmail.com">Andrew Zarazka.</a>
 * We are expanding our interface, gaining access to standard СRUD operations.
 */
public interface ContractRepository extends CrudRepository<Contract, String> {
}