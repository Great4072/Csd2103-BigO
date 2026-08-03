public class Question1 {
    static String reverseRecursive(String s) {
        if (s == null || s.length() <= 1) return s;
        return s.charAt(s.length() - 1)
                + reverseRecursive(s.substring(0, s.length() - 1));
    }

    static String reverseIterative(String s) {
        if (s == null) return null;
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String text = "pots&pans";
        System.out.println("Input: " + text);
        System.out.println("Recursive: " + reverseRecursive(text));
        System.out.println("Iterative: " + reverseIterative(text));
    }
}