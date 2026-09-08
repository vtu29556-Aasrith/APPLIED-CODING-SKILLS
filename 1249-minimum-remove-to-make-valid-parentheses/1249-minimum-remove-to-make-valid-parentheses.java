class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder temp = new StringBuilder();
        int balance = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
                temp.append(ch);
            } else if (ch == ')') {
                if (balance > 0) {
                    balance--;
                    temp.append(ch);
                }
            } else {
                temp.append(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = temp.length() - 1; i >= 0; i--) {
            char ch = temp.charAt(i);

            if (ch == '(' && balance > 0) {
                balance--;
            } else {
                result.append(ch);
            }
        }
        return result.reverse().toString();
    }
}
