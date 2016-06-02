package com.github.vincent_fuchs.comprehensive_testing.model;

public enum VolatilityIndex {

    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E");

    private String value;

    VolatilityIndex(String value) {
        this.value = value;
    }

    public static VolatilityIndex getEnum(String index) {
        VolatilityIndex[] values = VolatilityIndex.values();
        for (VolatilityIndex value : values) {
            if (index.equals(value.toString())) {
                return value;
            }
        }
        throw new UnsupportedOperationException("Could not find VolatilityIndex enum for " + index);
    }

    @Override
    public String toString() {
        return value;
    }
}
