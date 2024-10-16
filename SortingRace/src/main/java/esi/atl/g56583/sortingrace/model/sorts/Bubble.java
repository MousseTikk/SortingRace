package esi.atl.g56583.sortingrace.model.sorts;

public class Bubble implements Sort {
    // https://www.baeldung.com/java-bubble-sort
    @Override
    public long sort(int[] arr) {
        int i = 0, n = arr.length;
        boolean swapNeeded = true;
        long countOperation = 3;

        while (i < n - 1 && swapNeeded) {
            swapNeeded = false;
            countOperation++;
            for (int j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    swapNeeded = true;
                    countOperation += 4;
                }
            }
            if (!swapNeeded) {
                break;
            }
            i++;
            countOperation++;
        }
        return countOperation;
    }
}
