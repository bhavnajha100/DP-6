//TC = O(n^2)
//SC = O(1)

class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int startPoint = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        // when length of string is 1 - a =>(0,0); // i == j
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            maxLength = 1;
            startPoint = 0;
        }

        for (int L = 2; L <= n; L++) { // O(n^2)
            for (int i = 0; i+L-1 < n; i++) {
                int j = i + L - 1;
                if (s.charAt(i) == s.charAt(j) && L == 2) { // for length 2
                    dp[i][j] = true;
                    maxLength = 2;
                    startPoint = i;
                } else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) { // length > 2
                    dp[i][j] = true;
                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        startPoint = i;
                    }
                } else {
                    dp[i][j] = false;
                }

            }
        }
        return s.substring(startPoint, startPoint + maxLength);
    }
}