import java.util.*;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int number = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } 
            else if (ch == '[') {
                countStack.push(number);
                stringStack.push(current);

                number = 0;
                current = new StringBuilder();
            } 
            else if (ch == ']') {
                int count = countStack.pop();
                StringBuilder previous = stringStack.pop();

                for (int i = 0; i < count; i++) {
                    previous.append(current);
                }

                current = previous;
            } 
            else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}