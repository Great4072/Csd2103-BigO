public class Question3 {
    static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i'
                || c == 'o' || c == 'u';
    }

    static boolean hasMoreVowelsRecursive(String s) {
        if (s == null) return false;
        return countRecursive(s, 0, 0, 0);
    }

    static boolean countRecursive(String s, int index,
                                  int vowels, int consonants) {
        if (index == s.length()) {
            return vowels > consonants;
        }

        char c = s.charAt(index);
        if (Character.isLetter(c)) {
            if (isVowel(c)) vowels++;
            else consonants++;
        }

        return countRecursive(s, index + 1, vowels, consonants);
    }

    static boolean hasMoreVowelsIterative(String s) {
        if (s == null) return false;

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                if (isVowel(c)) vowels++;
                else consonants++;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        return vowels > consonants;
    }

    public static void main(String[] args) {
        String text = "education";

        System.out.println("Input: " + text);
        System.out.println("Recursive: "
                + hasMoreVowelsRecursive(text));
        System.out.println("Iterative: "
                + hasMoreVowelsIterative(text));
    }
}