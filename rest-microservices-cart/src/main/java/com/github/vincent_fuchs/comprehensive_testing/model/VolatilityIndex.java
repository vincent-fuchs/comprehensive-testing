package com.github.vincent_fuchs.comprehensive_testing.model;

import lombok.Getter;

public enum VolatilityIndex {

    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E");

    @Getter
    private String index;

    VolatilityIndex(String index) {
        this.index = index;
    }

    public static VolatilityIndex getEnum(String index) {
        VolatilityIndex[] values = VolatilityIndex.values();
        for (VolatilityIndex value : values) {
            if (index.equals(value.getIndex())) {
                return value;
            }
        }
        throw new UnsupportedOperationException("Could not find VolatilityIndex enum for " + index);
    }
}
