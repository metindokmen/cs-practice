// Longest Common Subsequence is used to find the longest subsequence that is common between two sequences (strings, arrays, etc.)

// Consider two sequences of characters, such as DNA sequence or sentences.
// The LCS algorithm can determine the longest sequence of characters that appears in both sequences.
// This can be useful in applications like plagiarism detection, where it's necessary to find similarities between two pieces of text.

public class LongestCommonSubsequence {

    public static String findLCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Create a 2D array to store lenghts of longest common subsequence
        int[][] dp = new int[m + 1][n + 1];

        // Build the dp array
        for (int i = 1; i <= m; i++) {
            for (j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Retrieve the longest common subseqnece using the dp array
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            })
        }

        // Reverse the string to get the actual longest common subsequence
        return lcs.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";

        String lcs = findLCS(s1, s2);
        System.out.println("Longest Common Subsequence: " + lcs);
    }
}
