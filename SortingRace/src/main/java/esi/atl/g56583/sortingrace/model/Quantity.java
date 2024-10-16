package esi.atl.g56583.sortingrace.model;

public enum Quantity {
    VERY_EASY(100, "Très facile : 100 (par 10)"),
    EASY(1_000, "Facile : 1 000 (par 100)"),
    NORMAL(10_000, "Normal : 10 000 (par 1 000)"),
    HARD(100_000, "Difficile : 100 000 (par 10 000)"),
    ULTRA_HARD(1_000_000, "Très difficile : 1 000 000 (par 100 000)");

    private final int nbRepeat;
    private final String frenchTranslate;

    Quantity(int nbRepeat, String frenchTranslate) {
        this.nbRepeat = nbRepeat;
        this.frenchTranslate = frenchTranslate;
    }

    public static Quantity fromString(String frenchTranslate) {
        for (var qt : Quantity.values()) {
            if (qt.toString().equalsIgnoreCase(frenchTranslate)) {
                return qt;
            }
        }
        return null;
    }

    public int getNbRepeat() {
        return nbRepeat;
    }

    @Override
    public String toString() {
        return frenchTranslate;
    }
}
