package Map;

import java.util.*;
/**
 * Created by TomTa on 8/14/16.
 */
public class practiceMap {
    public static void main(String[] args) {
        int[] test = {1,2,3,4,4,4,4,4,4,2,2,2,1,1,1,1};

        Map<Integer, String> modMap = new HashMap<Integer, String>();
        modMap.put(1, "skinny");
        modMap.put(3, "fat");
        modMap.put(4, "cat");
        System.out.println(modMap);
        System.out.println("modMap's keyset: "+ modMap.keySet());
        System.out.println("modMap's values: "+modMap.values() +"\n   ");

        System.out.println(Arrays.toString(test));
        System.out.println("highest count in array: " + highestCountArray(test));
        System.out.println("'value=number of value':" + arrayCountMap(test));

    }

    /**
     *
     * @param input
     * @return a map that counts the occurrences of each item
     */
    public static Map<Integer, Integer> arrayCountMap(int[] input) {
        Map<Integer, Integer> counts = new HashMap<>();
        int maxCount = 0;
        int mod = 0;
        for (int i = 0; i < input.length; i++) {
            if (!counts.containsKey(input[i])) { // if the item is not in the map
                counts.put(input[i], 1); // appear for the first time
            } else {
                int currentCount = counts.get(input[i]); // current count
                counts.put(input[i], currentCount + 1); // update count
            }
            if (counts.get(input[i]) > maxCount) {
                maxCount = counts.get(input[i]);
                mod = input[i];
            }
        }
        System.out.println("mod: " + mod + " appears " + maxCount + " times.");
        return counts;
    }


    /**
     * Pretty good stuffs.
     * @param input
     * @return
     */
    public static Map<Integer, Integer> arrayCountMapV1(int[] input){ // returns map with value of array values, and keySet of its count
        Map<Integer, Integer> res = new HashMap<Integer, Integer>();
        for(int i = 0; i < input.length; i++){
           res.put(input[i], valueCountArray(input[i], input));
        }
        return res;
    }

    /**
     *
     * @param x
     * @param arr
     * @return the count of value X in array ARR
     */
    public static int valueCountArray(int x, int[] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == x) count ++;
        }
        return count;
    }

    /**
     *
     * @param arr
     * @return the item with highest count in array ARR
     */
    public static int highestCountArray(int[] arr){
        int count = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++){
            if(valueCountArray(arr[i], arr) > count){
                count = valueCountArray(arr[i], arr);
                res = arr[i];
            }
        }
        return res;
    }
}
