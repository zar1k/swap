package com.gmail.andreyzarazka.publicbid.service;

import com.gmail.andreyzarazka.publicbid.model.Contract;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="mailto:andreyzarazka@gmail.com">Andrew Zarazka.</a>
 * We get the data from the REST server and return it as a list of contacts.
 */
@Component
public class OpenProcurementClient {
    private final OkHttpClient client = new OkHttpClient();
    private final String URL = "https://lb.api-sandbox.openprocurement.org/api/2.4/contracts/ffb2e977797440719208b510ed91548b/documents";
    private final String KEY = "data";

    List<Contract> getContracts() {
        Request request = new Request.Builder()
                .url(URL)
                .build();
        List<Contract> contracts = new ArrayList<>();
        try {
            Response response = client.newCall(request).execute();
            JSONObject obj = new JSONObject(response.body().string());
            JSONArray data = obj.getJSONArray(KEY);

            for (int i = 0; i < data.length(); i++) {
                JSONObject property = data.getJSONObject(i);

                Contract contract = new Contract();
                contract.setHash(property.getString("hash"));
                contract.setFormat(property.getString("format"));
                contract.setUrl(property.getString("url"));
                contract.setTitle(property.getString("title"));
                contract.setDocumentOf(property.getString("documentOf"));
                contract.setDatePublished(LocalDateTime.from(ZonedDateTime.parse(property.getString("datePublished"))));
                contract.setDateModified(LocalDateTime.from(ZonedDateTime.parse(property.getString("dateModified"))));
                contract.setId(property.getString("id"));
                contracts.add(contract);
            }
        } catch (IOException e) {
            contracts = Collections.emptyList();
        }
        return contracts;
    }
}