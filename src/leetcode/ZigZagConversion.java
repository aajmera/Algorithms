package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        Map<Integer, StringBuffer> map = new HashMap<>();

        int cycle = numRows + (numRows - 2);

        for(int i=0; i<s.length(); i++) {
            int index = 0;
            int currentCycleVal = i%cycle;

            if(currentCycleVal < numRows) index = currentCycleVal;
            else index = cycle-currentCycleVal;

            if(map.get(index) == null) {
                map.put(index, new StringBuffer(String.valueOf(s.charAt(i))));
            } else {
                map.get(index).append(s.charAt(i));
            }
        }

        StringBuffer result = new StringBuffer();
        for(int i=0; i<numRows; i++) {
            if(map.get(i) != null) result.append(map.get(i));
        }
        return result.toString();
    }
}
