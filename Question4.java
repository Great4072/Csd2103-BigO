import java.util.Arrays;

public class Question4 {
    static void rearrangeRecursive(int[] a, int left, int right) {
        if (left >= right) return;

        if (a[left] % 2 == 0) {
            rearrangeRecursive(a, left + 1, right);
        } else if (a[right] % 2 != 0) {
            rearrangeRecursive(a, left, right - 1);
        } else {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            rearrangeRecursive(a, left + 1, right - 1);
        }
    }

    static void rearrangeTwoPointer(int[] a) {
        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            while (left < right && a[left] % 2 == 0) left++;
            while (left < right && a[right] % 2 != 0) right--;

            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
    }

    static int[] rearrangeExtraArray(int[] a) {
        int[] result = new int[a.length];
        int index = 0;

        for (int number : a) {
            if (number % 2 == 0) result[index++] = number;
        }

        for (int number : a) {
            if (number % 2 != 0) result[index++] = number;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a1 = {7, 2, 9, 4, 1, 6, 3, 8};
        rearrangeRecursive(a1, 0, a1.length - 1);
        System.out.println("Recursive: " + Arrays.toString(a1));

        int[] a2 = {7, 2, 9, 4, 1, 6, 3, 8};
        rearrangeTwoPointer(a2);
        System.out.println("Iterative: " + Arrays.toString(a2));

        int[] a3 = {7, 2, 9, 4, 1, 6, 3, 8};
        System.out.println("Extra Array: "
                + Arrays.toString(rearrangeExtraArray(a3)));
    }
}