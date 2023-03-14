package org.parthvnp.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval}; //empty interval set, only newInterval will be present
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1]; //note how start and end are assigned
        int i = 0;
        while (i < intervals.length) {
            if (start <= intervals[i][1]) { //once we have start <= intervals[i][1], we have overlap
                start = Math.min(start, intervals[i][0]); //so we set our interval start to the min between start and intervals[i][0]
                while (i < intervals.length && end >= intervals[i][0]) { //then we find the max interval end point
                    end = Math.max(end, intervals[i][1]);
                    i++;
                }
                //the above while loop is only broken once we no longer have overlap, so we have our new start & end interval to add
                break; //so we break the outer loop
            } else {
                res.add(intervals[i]); //adding all intervals before we have any overlap with newInterval
                i++;
            }
        }

        res.add(new int[]{start, end}); //we add the calculated interval [start, end]
        while (i < intervals.length) res.add(intervals[i++]); //and then all remaining non-overlapping intervals

        return res.toArray(int[][]::new);

    }

    public static void main(String[] args) {
        var ii = new InsertInterval();
        // intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        System.out.println(Arrays.deepToString(ii.insert(new int[][]{new int[]{3, 5}, new int[]{12,15}}, new int[]{6,6})));


    }
}
