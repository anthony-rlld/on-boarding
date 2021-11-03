package com.arolland.entity;

import com.arolland.object.DotTinFactoryCode;
import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.UUID;

@MongoEntity(collection = "refFactories")
public class Factory extends ReactivePanacheMongoEntity {

    @Id
    @Column(name = "_id")
    private UUID id;

    private String description;
    private String ct2Code;
    private String ragCode;
    private String activity;
    private DotTinFactoryCode dotTinFactoryCode;
    private String countryCode;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCt2Code() {
        return ct2Code;
    }

    public void setCt2Code(String ct2Code) {
        this.ct2Code = ct2Code;
    }

    public String getRagCode() {
        return ragCode;
    }

    public void setRagCode(String ragCode) {
        this.ragCode = ragCode;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public DotTinFactoryCode getDotTinFactoryCode() {
        return dotTinFactoryCode;
    }

    public void setDotTinFactoryCode(DotTinFactoryCode dotTinFactoryCode) {
        this.dotTinFactoryCode = dotTinFactoryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
