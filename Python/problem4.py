class Solution(object):
    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        backward_hash = 0
        forward_hash = 0
        longest_palindrome_end = -1
        hash_base = 26
        current_power = 1
        mod = 10**9 + 7

        for i, c in enumerate(s):
            char_value = (ord(c) - ord('a') + 1)
            forward_hash = (forward_hash * hash_base + char_value) % mod
            backward_hash = (backward_hash + char_value * current_power) % mod
            current_power = (current_power * hash_base) % mod

            if forward_hash == backward_hash:
                longest_palindrome_end = i

        non_palindromic_suffix = s[longest_palindrome_end + 1:]
        return non_palindromic_suffix[::-1] + s