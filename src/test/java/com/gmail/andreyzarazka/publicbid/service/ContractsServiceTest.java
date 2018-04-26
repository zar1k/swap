package com.gmail.andreyzarazka.publicbid.service;

import com.gmail.andreyzarazka.publicbid.model.Contract;
import com.gmail.andreyzarazka.publicbid.repository.ContractRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractsServiceTest {
    @Autowired
    private ContractsService service;
    @Autowired
    private ContractRepository repository;

    @Test
    public void whenGetAllContracts() {
        Contract first = new Contract();
        first.setHash("md5:70d30a1c3a7c291e8f96bf34708863a8");
        first.setFormat("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        first.setUrl("https://public.docs-sandbox.openprocurement.org/get/a90c899ad7c5456294a619763161eb5b?KeyID=1331dc52&Signature=YTNKJhBhilMY3OjlOl5dJbkcvz8zVUnlq2%2Fk0lt63D8pBL5FzXseMgj6S2EavEXiFQ9VURfa7i4xJaQktqOxCg%253D%253D");
        first.setTitle("Документация по лоту 4.docx");
        first.setDocumentOf("tender");
        first.setDatePublished(LocalDateTime.from(ZonedDateTime.parse("2017-09-19T10:13:09.785229+03:00")));
        first.setDateModified(LocalDateTime.from(ZonedDateTime.parse("2017-09-19T10:13:09.785249+03:00")));
        first.setId("abecf7b014574c869a9eef0e9fe0163d");

        Contract second = new Contract();
        second.setHash("md5:ea939fcea77ce340ea35807f97daeb84");
        second.setFormat("application/pkcs7-signature");
        second.setUrl("https://public.docs-sandbox.openprocurement.org/get/5bdaa83e5472412ba23a35028e274ae8?KeyID=1331dc52&Signature=oO6MAN9xf4zBhebBxEOUbkBb71EU0tOkemRVJ9uIQ8rx3965J%252BsJiS%252B8AFr9l20aLpuj4xjH8c%252BT0r9yP5fBAw%253D%253D");
        second.setTitle("sign.p7s");
        second.setDocumentOf("tender");
        second.setDatePublished(LocalDateTime.from(ZonedDateTime.parse("2017-09-19T10:13:31.794670+03:00")));
        second.setDateModified(LocalDateTime.from(ZonedDateTime.parse("2017-09-19T10:13:31.794690+03:00")));
        second.setId("f35467d6693a4b369bff4302ea17f512");

        List<Contract> actual = new ArrayList<>();
        actual.add(first);
        actual.add(second);

        List<Contract> result = this.service.getAllContracts();
        assertThat(actual, is(result));
    }

    @Test
    public void whenUploadFromRESTIntoDatabase() {
        List<Contract> fromRESTService = service.getAllContracts();

        // Download JSON data from the HTTP REST server to the database.
        service.uploadFromRESTIntoDatabase();

        List<Contract> fromDB = (List<Contract>) repository.findAll();
        assertThat(fromRESTService, is(fromDB));
    }
}