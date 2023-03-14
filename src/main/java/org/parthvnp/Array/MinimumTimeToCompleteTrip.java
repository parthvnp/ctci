package org.parthvnp.Array;
import java.util.Arrays;
import java.util.Collections;

public class MinimumTimeToCompleteTrip {
    public long minimumTime(int[] time, int totalTrips) {
        // all buses should make at least once trip, so full traversal is required
        // need a count to track how many trips have been completed
        // at any given time t, if time is sorted then when ti trip is started, for tj where tj / ti == 0, we increment their trips by one.
        if(time.length == 1) return (long) totalTrips * time[0];
        Arrays.sort(time);
        long count = 0;
        int t = time[0], last = 1;
        while(count < totalTrips){
            for (int j : time) {
                if (j <= t) count += t / j;
                else break;
            }
            if(count > totalTrips) break;
            t += last == time.length - 1 ? time[time.length - 1] : time[last];
            last += 1;
        }
        return t;
    }

    public static void main(String[] args) {
        var s = new MinimumTimeToCompleteTrip();
        var r= s.minimumTime(new int[]{5,10,10}, 9);
        System.out.println(r);
    }
}
