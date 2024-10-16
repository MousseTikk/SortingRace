package esi.atl.g56583.sortingrace.model.sorts;

public class Insertion implements Sort {
    // https://www.geeksforgeeks.org/insertion-sort/
    @Override
    public long sort(int[] input) {
        long countOperation = 1;
        int n = input.length;
        for (int i = 1; i < n; ++i) {
            int key = input[i];
            int j = i - 1;
            countOperation += 2;
            while (j >= 0 && input[j] > key) {
                input[j + 1] = input[j];
                j = j - 1;
                countOperation += 2;
            }
            input[j + 1] = key;
            countOperation++;
        }
        return countOperation;
    }
}
