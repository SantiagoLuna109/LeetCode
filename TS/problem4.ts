function shortestPalindrome(s: string): string {
    let backward_hash = 0;
    let forward_hash = 0;
    let longest_palindrome_end = -1;
    const hash_base = 26;
    let current_power = 1;
    const mod = 10**9 + 7;

    for (let i = 0; i < s.length; i++) {
        const char_value = s.charCodeAt(i) - 'a'.charCodeAt(0) + 1;
        forward_hash = (forward_hash * hash_base + char_value) % mod;
        backward_hash = (backward_hash + char_value * current_power) % mod;
        current_power = (current_power * hash_base) % mod;

        if (forward_hash === backward_hash) {
            longest_palindrome_end = i;
        }

    }

    const non_palindrome_suffix = s.substring(longest_palindrome_end + 1);
    return non_palindrome_suffix.split('').reverse().join('') + s;

};