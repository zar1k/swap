package com.gmail.andreyzarazka.publicbid.controler;

import com.gmail.andreyzarazka.publicbid.controler.responce.Error;
import com.gmail.andreyzarazka.publicbid.controler.responce.Result;
import com.gmail.andreyzarazka.publicbid.controler.responce.Success;
import com.gmail.andreyzarazka.publicbid.service.ContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <a href="mailto:andreyzarazka@gmail.com">Andrew Zarazka.</a>
 */
@RestController
public class OpenProcurementController {
    private final ContractsService service;

    @Autowired
    public OpenProcurementController(final ContractsService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public Result uploadToDB() {
        final Result result;
        if (this.service.uploadFromRESTIntoDatabase()) {
            result = new Success("The data is loaded into the database");
        } else {
            result = new Error("No data to load into the database");
        }
        return result;
    }
}