package hackerearth;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SumAsPerFrequency {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int noOfElements = sc.nextInt();
        int[] arr = new int[noOfElements];

        Map<Integer, Integer> numMap = new HashMap<>();

        for(int i=0; i<noOfElements; i++) {
            int num = sc.nextInt();

            if(numMap.containsKey(num)) numMap.put(num, numMap.get(num) + 1);
            else numMap.put(num, 1);
        }

        Map<Integer, Long> freqSumMap = new HashMap<>();
        for(Map.Entry<Integer, Integer> curr : numMap.entrySet()) {
            long val = curr.getKey() * curr.getValue();
            if(freqSumMap.containsKey(curr.getValue())) freqSumMap.put(curr.getValue(), freqSumMap.get(curr.getValue()) + val);
            else freqSumMap.put(curr.getValue(), val);
        }

        int noOfTestCases = sc.nextInt();
        StringBuffer result = new StringBuffer("");

        for(int i=0; i<noOfTestCases; i++) {
            int min = sc.nextInt();
            int max = sc.nextInt();
            int sum = 0;

            for(int j=min; j<=max; j++) if(freqSumMap.containsKey(j)) sum += freqSumMap.get(j);
            result.append(sum + "\n");
        }

        System.out.print(result.toString());
    }
}
