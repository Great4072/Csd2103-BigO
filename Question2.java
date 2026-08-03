public class Question2 {
    static String cleanString(String s) {
        if (s == null) return "";
        return s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    static boolean isPalindromeByReverse(String s) {
        String clean = cleanString(s);
        StringBuilder reverse = new StringBuilder();
        for (int i = clean.length() - 1; i >= 0; i--) {
            reverse.append(clean.charAt(i));
        }
        return clean.equals(reverse.toString());
    }

    static boolean isPalindromeRecursive(String s, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return isPalindromeRecursive(s, left + 1, right - 1);
    }

    public static void main(String[] args) {
        String text = "A man, a plan, a canal: Panama";
        String clean = cleanString(text);

        System.out.println("Input: " + text);
        System.out.println("Reverse and Compare: " + isPalindromeByReverse(text));
        System.out.println("Recursive: "
                + isPalindromeRecursive(clean, 0, clean.length() - 1));
    }
}