public class Main {
    public static void mergeArrays(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int leftSize = left.length, rightSize = right.length;

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < leftSize) {
            array[k++] = left[i++];
        }
        while (j < rightSize) {
            array[k++] = right[j++];
        }
    }

    public static void mergeSort(int[] array) {
        if (array.length == 1) {
            return;
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        for (int i = 0; i < mid; i++ ){
            left[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        mergeSort(left);
        mergeSort(right);
        mergeArrays(array, left, right);
    }

    public static void main(String[] args) {
            int[] array = {1, 4, 8, 0, 3, 5, 7, 9};
            mergeSort(array);
            for(int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        }

}
