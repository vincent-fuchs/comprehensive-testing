package com.github.vincent_fuchs.comprehensive_testing.model;


import lombok.Getter;

public enum Risk {
    HIGH("HIGH"),
    MEDIUM("MEDIUM"),
    LOW("LOW");

    @Getter
    private String risk;

    Risk(String risk) {
        this.risk = risk;
    }

    public static Risk getEnum(String risk) {
        Risk[] values = Risk.values();
        for (Risk value : values) {
            if (risk.equals(value.getRisk())) {
                return value;
            }
        }
        throw new UnsupportedOperationException("Could not find Risk enum for " + risk);
    }
}
