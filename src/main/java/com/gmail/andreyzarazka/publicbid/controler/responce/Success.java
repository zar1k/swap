package com.gmail.andreyzarazka.publicbid.controler.responce;

public class Success extends Result {
    private final String success;

    public Success(String value) {
        this.success = value;
    }

    public String getSuccess() {
        return success;
    }
}
