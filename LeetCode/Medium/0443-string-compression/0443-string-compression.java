class Solution {
    public int compress(char[] chars) {
        /**
        이 배열 안에서 하라라..
        */
        int count = 0;

        for (int i = 0; i < chars.length; i++) {
            chars[count] = chars[i];
            count++;
            int ii = i;
            while (ii + 1 < chars.length && chars[ii] == chars[ii + 1]) {
                ii++;
            }
            String num = (ii - i + 1) + "";
            if (!num.equals("1")) {
                for (int iii = 0; iii < num.length(); iii++) {
                    chars[count + iii] = num.charAt(iii);
                }
                count += num.length();
            }
            i = ii;
        }

        return count;
    }
}