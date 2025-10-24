import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2]; // [position, speed]
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        int fleets = 0;
        double prevTime = 0; 
        for (int i = 0; i < n; i++) {
            double time = (double)(target - cars[i][0]) / cars[i][1];
            if (time > prevTime) { 
                fleets++;
                prevTime = time;
            }
        }
        return fleets;
    }

  
    /*
    Time Complexity: O(n log n) 
        - Sorting the cars by position: O(n log n)
        - Single pass to count fleets: O(n)
    Space Complexity: O(n) 
        - For storing cars array
    */
}
