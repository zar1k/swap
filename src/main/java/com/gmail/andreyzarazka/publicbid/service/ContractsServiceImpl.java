package com.gmail.andreyzarazka.publicbid.service;

import com.gmail.andreyzarazka.publicbid.model.Contract;
import com.gmail.andreyzarazka.publicbid.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <a href="mailto:andreyzarazka@gmail.com">Andrew Zarazka.</a>
 */
@Service
public class ContractsServiceImpl implements ContractsService {
    @Autowired
    private final ContractRepository repository;
    @Autowired
    private final OpenProcurementClient client;

    public ContractsServiceImpl(final OpenProcurementClient client, final ContractRepository repository) {
        this.client = client;
        this.repository = repository;
    }

    @Override
    public List<Contract> getAllContracts() {
        return client.getContracts();
    }

    @Override
    public boolean uploadFromRESTIntoDatabase() {
        List<Contract> contracts = getAllContracts();
        boolean result = false;
        if (!contracts.isEmpty()) {
            repository.saveAll(contracts);
            result = true;
        }
        return result;
    }
}