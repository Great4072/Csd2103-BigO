public class Question6 {
    static boolean findPairBruteForce(int[] a, int k) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == k) {
                    System.out.println("Pair found: "
                            + a[i] + " and " + a[j]);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean findPairRecursive(int[] a, int k,
                                     int left, int right) {
        if (left >= right) return false;

        int sum = a[left] + a[right];

        if (sum == k) {
            System.out.println("Pair found: "
                    + a[left] + " and " + a[right]);
            return true;
        } else if (sum < k) {
            return findPairRecursive(a, k, left + 1, right);
        } else {
            return findPairRecursive(a, k, left, right - 1);
        }
    }

    static boolean findPairBinarySearch(int[] a, int k) {
        for (int i = 0; i < a.length; i++) {
            int target = k - a[i];
            int left = i + 1;
            int right = a.length - 1;

            while (left <= right) {
                int middle = (left + right) / 2;

                if (a[middle] == target) {
                    System.out.println("Pair found: "
                            + a[i] + " and " + a[middle]);
                    return true;
                } else if (a[middle] < target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 7, 11, 15, 20};
        int k = 18;

        System.out.println("Brute Force");
        findPairBruteForce(a, k);

        System.out.println("\nRecursive Two-Pointer");
        findPairRecursive(a, k, 0, a.length - 1);

        System.out.println("\nBinary Search");
        findPairBinarySearch(a, k);
    }
}