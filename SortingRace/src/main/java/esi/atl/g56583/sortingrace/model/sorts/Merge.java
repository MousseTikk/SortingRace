package esi.atl.g56583.sortingrace.model.sorts;

public class Merge implements Sort {

    // https://www.baeldung.com/java-merge-sort
    @Override
    public long sort(int[] a) {
        int n = a.length;
        long countOperation = 1;
        if (n < 2) {
            return countOperation;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        countOperation += 3;
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
            countOperation++;
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
            countOperation++;
        }
        countOperation += sort(l);
        countOperation += sort(r);
        countOperation += merge(a, l, r, mid, n - mid);
        return countOperation;
    }

    private long merge(
            int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        long countOperation = 3;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
                countOperation++;
            } else {
                a[k++] = r[j++];
                countOperation++;
            }
        }
        while (i < left) {
            a[k++] = l[i++];
            countOperation++;
        }
        while (j < right) {
            a[k++] = r[j++];
            countOperation++;
        }
        return countOperation;
    }
}
