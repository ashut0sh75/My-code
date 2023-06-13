class GFG:
    def longestPalindrome(self, s: str) -> str:
        def build_hash(s, p, m):
            h = [0]
            for i in range(len(s)):
                h.append(h[-1] + ord(s[i]) * p[i])
            return h
        
        def hash_equal(h1, i1, j1, h2, i2, j2, p, m):
            return (h1[j1 + 1] * p[i2 + 1] + h2[i2] * p[i1 + 1]) % m == (h2[j2 + 1] * p[i1 + 1] + h1[i1] * p[i2 + 1]) % m
        
        p = [1]
        m, prime = 1e5 + 7, 101
        for i in range(len(s) + 1):
            p.append((p[-1] * prime) % m)
        
        h1, h2 = build_hash(s, p, m), build_hash(s[::-1], p, m)
        pos, ans = 0, 1
        
        for i in range(len(s)):
            l, r = 1, min(i + 1, len(s) - i)
            while l != r:
                mid = (l + r + 1) // 2
                if hash_equal(h1, i - mid + 1, i, h2, len(s) - i - mid, len(s) - i - 1, p, m):
                    l = mid
                else:
                    r = mid - 1
        
            if ans < 2 * l - 1:
                ans = 2 * l - 1
                pos = i
        for i in range(len(s) - 1):
            if s[i] != s[i + 1]:
                continue
            l, r = 1, min(i + 1, len(s) - i - 1)
            while l != r:
                mid = (l + r + 1) // 2
                if hash_equal(h1, i - mid + 1, i, h2, len(s) - i - 1 - mid, len(s) - i - 2, p, m):
                    l = mid
                else:
                    r = mid - 1
            if ans < 2 * l:
                ans = 2 * l
                pos = i

        if ans % 2:
            ans = (ans + 1) // 2
            return s[pos - ans + 1: pos] + s[pos: pos + ans]
        else:
            ans = ans // 2
            return s[pos - ans + 1: pos + 1] + s[pos + 1: pos + 1 + ans]
if __name__ == "__main__":
    GFG().longestPalindrome("abababab")


  