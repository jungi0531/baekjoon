class Solution {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] arr = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !vowels.contains(Character.toString(arr[left]))) left++;
            while (left < right && !vowels.contains(Character.toString(arr[right]))) right--;

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }

        return new String(arr);
    }
}