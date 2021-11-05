package com.arolland.utils;

import com.arolland.exception.InvalidUuidException;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class UUIDValidatorTest {

    @Test
    public void testValidateFrom_invalidUUID_failBadRequest(){
        String invalidUUID = "thisisinvaliduuid";
        InvalidUuidException e = Assertions.assertThrows(InvalidUuidException.class, () -> {
            UUIDValidator.validateFrom(invalidUUID);
        });

        Assertions.assertEquals(invalidUUID, e.getUuid());
    }
}
