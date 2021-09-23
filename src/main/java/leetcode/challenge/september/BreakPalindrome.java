package leetcode.challenge.september;

public class BreakPalindrome {

    public String breakPalindrome(String palindrome) {
        String brokenPalindrome = "";

        // edgeCase, palindrome word length < 2 -> Can't be broken
        if (palindrome == null || palindrome.length() < 2) {
            return brokenPalindrome;
        }

        // regularCase, replace first not 'a' with a 'b'.
        // If there's more than one not 'a' then break.
        int countNonA = 0;
        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (palindrome.charAt(i) != 'a') {
                countNonA++;
                if (countNonA > 1) {
                    break;
                }
                brokenPalindrome = replaceCharPosition(palindrome, i, 'a');
            }

        }

        // If there's 1 or less non-'a' chars on word -> replace last with b
        if (countNonA <= 1) {
            return replaceCharPosition(palindrome, palindrome.length() - 1, 'b');
        }

        return brokenPalindrome;

    }

    public String breakPalindromeV2(String palindrome) {
        // edgeCase, palindrome is null or length < 2 -> Can't be broken
        if (palindrome == null || palindrome.length() < 2) {
            return "";
        }

        // regularCase, replace first not 'a' with a 'b'.
        // If there's more than one not 'a' then break.
        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (palindrome.charAt(i) != 'a') {
                return replaceCharPosition(palindrome, i, 'a');
            }

        }

        // default, replace last char with b
        return replaceCharPosition(palindrome, palindrome.length() - 1, 'b');
    }

    private String replaceCharPosition(String palindrome, int index, char newValue) {
        StringBuilder palindromeBuffer = new StringBuilder(palindrome);
        palindromeBuffer.setCharAt(index, newValue);
        return palindromeBuffer.toString();
    }

}
