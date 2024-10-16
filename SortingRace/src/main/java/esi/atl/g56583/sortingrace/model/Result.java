package esi.atl.g56583.sortingrace.model;

public class Result {
    private final SortType name;
    private final long size;
    private final long swap;
    private final long duration;

    public Result(SortType name, long size, long swap, long duration) {
        this.name = name;
        this.size = size;
        this.swap = swap;
        this.duration = duration;
    }

    public SortType getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public long getSwap() {
        return swap;
    }

    public long getDuration() {
        return duration;
    }
}
