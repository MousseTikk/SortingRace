package esi.atl.g56583.sortingrace.model;

public enum SortType {
    BUBBLE("Tri à bulles"),
    MERGE("Tri fusion"),
    SELECTION("Tri selection"),
    INSERTION("Tri insertion"),
    QUICK("Tri rapide");

    private final String frenchType;

    SortType(String frenchType) {
        this.frenchType = frenchType;
    }

    public static SortType fromString(String frenchType) {
        for (var sort : SortType.values()) {
            if (sort.toString().equalsIgnoreCase(frenchType)) {
                return sort;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return frenchType;
    }
}
