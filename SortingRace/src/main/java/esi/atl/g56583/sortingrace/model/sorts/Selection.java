package esi.atl.g56583.sortingrace.model.sorts;

public class Selection implements Sort {
    // https://www.baeldung.com/java-selection-sort
    @Override
    public long sort(int[] arr) {
        long countOperation = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            countOperation++;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minElementIndex] > arr[j]) {
                    minElementIndex = j;
                    countOperation++;
                }
            }

            if (minElementIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minElementIndex];
                arr[minElementIndex] = temp;
                countOperation += 3;
            }
        }
        return countOperation;
    }
}
