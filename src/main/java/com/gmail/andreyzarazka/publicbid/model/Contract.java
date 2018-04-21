package com.gmail.andreyzarazka.publicbid.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * <a href="mailto:andreyzarazka@gmail.com">Andrew Zarazka.</a>
 * This class represents the model of the procurement contract.
 */
@Entity(name = "contract")
public class Contract {
    private String hash;
    private String format;
    private String url;
    private String title;
    private String documentOf;
    private String datePublished;
    private String dateModified;
    @Id
    private String id;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDocumentOf() {
        return documentOf;
    }

    public void setDocumentOf(String documentOf) {
        this.documentOf = documentOf;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contract)) return false;
        Contract contract = (Contract) o;
        return Objects.equals(hash, contract.hash) &&
                Objects.equals(format, contract.format) &&
                Objects.equals(url, contract.url) &&
                Objects.equals(title, contract.title) &&
                Objects.equals(documentOf, contract.documentOf) &&
                Objects.equals(datePublished, contract.datePublished) &&
                Objects.equals(dateModified, contract.dateModified) &&
                Objects.equals(id, contract.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash, format, url, title, documentOf, datePublished, dateModified, id);
    }
}