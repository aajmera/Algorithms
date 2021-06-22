package leetcode;

public class StringToIntegerAtoi {
    public int myAtoi(String s) {
        boolean isNegative = false;
        boolean validCharRead = false;
        long number = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            try {
                number = (number * 10) + Integer.parseInt(String.valueOf(currentChar));
                if(number>Integer.MAX_VALUE) {
                    if(isNegative) return Integer.MIN_VALUE;
                    else return Integer.MAX_VALUE;
                }
                validCharRead = true;
            } catch (NumberFormatException ex) {
                if(validCharRead) break;
                else {
                    if(currentChar == ' ') continue;
                    else if(currentChar == '-' || currentChar == '+'){
                        validCharRead = true;
                        if(currentChar == '-') isNegative = true;
                    } else break;
                }
            }
        }

        if (isNegative) {
            number *= -1;
        }

        return (int) number;
    }
}
