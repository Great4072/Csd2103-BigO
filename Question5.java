import java.util.Arrays;

public class Question5 {
    static void partitionRecursive(int[] a, int k,
                                   int left, int right) {
        if (left >= right) return;

        if (a[left] <= k) {
            partitionRecursive(a, k, left + 1, right);
        } else if (a[right] > k) {
            partitionRecursive(a, k, left, right - 1);
        } else {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            partitionRecursive(a, k, left + 1, right - 1);
        }
    }

    static void partitionIterative(int[] a, int k) {
        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            while (left < right && a[left] <= k) left++;
            while (left < right && a[right] > k) right--;

            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
    }

    static void partitionBySorting(int[] a, int k) {
        Arrays.sort(a);
    }

    public static void main(String[] args) {
        int k = 8;

        int[] a1 = {12, 4, 7, 15, 3, 10, 8};
        partitionRecursive(a1, k, 0, a1.length - 1);
        System.out.println("Recursive: " + Arrays.toString(a1));

        int[] a2 = {12, 4, 7, 15, 3, 10, 8};
        partitionIterative(a2, k);
        System.out.println("Iterative: " + Arrays.toString(a2));

        int[] a3 = {12, 4, 7, 15, 3, 10, 8};
        partitionBySorting(a3, k);
        System.out.println("Sorting: " + Arrays.toString(a3));
    }
}