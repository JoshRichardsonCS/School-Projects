//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] left = {1, 5, 6, 8, 20};
        int[] right = {7, 9, 10, 30};
        int totalSize = left.length+right.length;
        int[] a = new int[totalSize];

        int leftCur = 0;
        int rightCur = 0;
        for(int i = 0; i < totalSize; i++) {
            if(left[leftCur] < right[rightCur]) {
                a[i] = left[leftCur];
                leftCur++;
            } else {
                a[i] = right[rightCur];
                rightCur++;
            }

        }

        for(int i = 0; i < totalSize; i++) {
            System.out.print(a[i] + ", ");
        }
    }
}