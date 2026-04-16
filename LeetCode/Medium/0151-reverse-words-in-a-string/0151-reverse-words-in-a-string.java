class Solution {
    public String reverseWords(String s) {
        String[] temp = s.split(" ");
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < temp.length; i++) {
            if (temp[temp.length - (i + 1)].length() == 0) continue;
            sb.append(temp[temp.length - (i + 1)] + " ");
        }

        return sb.toString().trim();
    }
}