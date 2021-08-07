package word;

public class StringProblems {
    public int strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();

        if (needleLen > haystackLen) {
            return -1;
        }

        for (int i = 0; i < haystackLen - needleLen + 1; i++) {
            String substring = haystack.substring(i, i + needleLen);
            if (substring.equalsIgnoreCase(needle)) {
                return i;
            }
        }
        return -1;
    }
}
