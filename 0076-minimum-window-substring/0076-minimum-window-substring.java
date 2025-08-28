class Solution {
    public String minWindow(String s, String t) {
        int l = 0;
        int r = 0;
        int minlen = Integer.MAX_VALUE;
        int count = 0;
        int start = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (r < s.length()) {
            char c = s.charAt(r);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);

                if (map.get(c) == 0) count++;

               
                while (count == map.size()) {
                    if (r - l + 1 < minlen) {
                        minlen = r - l + 1;
                        start = l;
                    }

                    char left = s.charAt(l);
                    if (map.containsKey(left)) {
                        map.put(left, map.get(left) + 1);
                        if (map.get(left) > 0) count--;
                    }
                    l++;
                }
            }
            r++;
        }

        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start + minlen);
    }
}
