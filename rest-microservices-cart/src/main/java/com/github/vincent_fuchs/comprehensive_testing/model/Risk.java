package com.github.vincent_fuchs.comprehensive_testing.model;


public enum Risk {
    HIGH("HIGH"),
    MEDIUM("MEDIUM"),
    LOW("LOW");

    private String value;

    Risk(String value) {
        this.value = value;
    }

    public static Risk getEnum(String risk) {
        Risk[] values = Risk.values();
        for (Risk value : values) {
            if (risk.equals(value.toString())) {
                return value;
            }
        }
        throw new UnsupportedOperationException("Could not find Risk enum for " + risk);
    }

    @Override
    public String toString() {
        return value;
    }
}
