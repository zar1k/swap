package com.gmail.andreyzarazka.publicbid.service;

import com.gmail.andreyzarazka.publicbid.model.Contract;

import java.util.List;

/**
 * <a href="mailto:andreyzarazka@gmail.com">Andrew Zarazka.</a>
 */
public interface ContractsService {
    List<Contract> getAllContracts();

    boolean uploadFromRESTIntoDatabase();
}