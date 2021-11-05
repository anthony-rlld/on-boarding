package com.arolland.exception;

public class InvalidUuidException extends RuntimeException {

    public final String uuid;

    public InvalidUuidException(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
