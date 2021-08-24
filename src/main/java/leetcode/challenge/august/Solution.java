package leetcode.challenge.august;

public class Solution {

    public String complexNumberMultiply(String num1, String num2) {
        String[] splitNum1 = num1.split("\\+");
        String[] splitNum2 = num2.split("\\+");

        int realNum1 = Integer.parseInt(splitNum1[0]);
        int realNum2 = Integer.parseInt(splitNum2[0]);
        int complexNum1 = Integer.parseInt(splitNum1[1].split("i")[0]);
        int complexNum2 = Integer.parseInt(splitNum2[1].split("i")[0]);

        String realMultiple = String.valueOf(realNum1 * realNum2 - complexNum2 * complexNum1);
        String complexMultiple = realNum1 * complexNum2 + realNum2 * complexNum1 + "i";

        return String.join("+", realMultiple, complexMultiple);
    }
}
