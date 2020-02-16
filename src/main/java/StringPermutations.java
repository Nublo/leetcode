public class StringPermutations {

    public boolean checkInclusion(String s2, String s1) {
        int[] count = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            count[s2.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = 0;

        while (right < s1.length()) {
            char addC = s1.charAt(right);
            count[addC - 'a']--;
            right++;

            if (count[addC - 'a'] < 0) {
                while (s1.charAt(left) != addC) {
                    count[s1.charAt(left) - 'a']++;
                    left++;
                }
                count[s1.charAt(left) - 'a']++;
                left++;
            } else {
                if (right - left == s2.length()) {
                    return true;
                }
            }
        }

        return false;
    }

}
