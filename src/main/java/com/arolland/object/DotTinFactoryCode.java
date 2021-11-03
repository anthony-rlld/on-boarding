package com.arolland.object;

import java.util.Objects;

public class DotTinFactoryCode {

    private String shortCode;
    private String longCode;

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getLongCode() {
        return longCode;
    }

    public void setLongCode(String longCode) {
        this.longCode = longCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DotTinFactoryCode that = (DotTinFactoryCode) o;
        return Objects.equals(shortCode, that.shortCode) && Objects.equals(longCode, that.longCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortCode, longCode);
    }
}
