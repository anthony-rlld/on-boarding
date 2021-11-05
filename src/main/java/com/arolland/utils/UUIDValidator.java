package com.arolland.utils;

import com.arolland.exception.InvalidUuidException;

import java.util.UUID;

public class UUIDValidator {

    public static UUID validateFrom(String uuid) {
        UUID res;
        try {
            res = UUID.fromString(uuid);
        } catch (IllegalArgumentException e) {
            throw new InvalidUuidException(uuid);
        }
        return res;
    }
}
