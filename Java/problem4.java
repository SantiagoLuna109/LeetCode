class Solution {
    public String shortestPalindrome(String s) {
        long backward_hash = 0;
        long forward_hash = 0;
        int longest_palindrome_end = -1;
        final int hash_base = 26;
        long current_power = 1;
        final int mod = (int)1e9 + 7;

        for (int i = 0; i < s.length(); i++) {
            int char_value = s.charAt(i) - 'a' + 1;
            forward_hash = (forward_hash * hash_base + char_value) % mod;
            backward_hash = (backward_hash + char_value * current_power) % mod;
            current_power = (current_power * hash_base) % mod;

            if (forward_hash == backward_hash) {
                longest_palindrome_end = i;
            }

        }

        String non_palindromic_suffix = s.substring(longest_palindrome_end + 1);
        return new StringBuilder(non_palindromic_suffix).reverse().toString() + s;

    }
}