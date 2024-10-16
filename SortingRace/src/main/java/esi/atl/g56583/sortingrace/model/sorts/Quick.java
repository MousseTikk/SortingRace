package esi.atl.g56583.sortingrace.model.sorts;

public class Quick implements Sort {
    // https://www.baeldung.com/java-quicksort
    @Override
    public long sort(int[] array) {
        return quickSort(array, 0, array.length - 1);
    }

    private long quickSort(int[] arr, int begin, int end) {
        long countOperation = 0;
        if (begin < end) {
            long[] partitionIndex = partition(arr, begin, end);
            countOperation++;
            countOperation += partitionIndex[0];
            countOperation += quickSort(arr, begin, (int) partitionIndex[1] - 1);
            countOperation += quickSort(arr, (int) partitionIndex[1] + 1, end);
        }
        return countOperation;
    }

    private long[] partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);
        long countOperation = 2;

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
                countOperation += 4;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;
        countOperation += 3;
        return new long[]{countOperation, i + 1};
    }
}
