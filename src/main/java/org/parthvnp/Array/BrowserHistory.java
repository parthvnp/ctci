package org.parthvnp.Array;

import java.util.*;

class BrowserHistory {

    List<String> list = new ArrayList<>();
    int currIdx = -1;

    public BrowserHistory(String homepage) {
        list.add(homepage);
        currIdx++;
    }

    public void visit(String url) {
        // check if the forward idx is the final element
        if (currIdx == list.size() - 1) {
            list.add(url);
            currIdx++;
        }
        // if the forward idx is behind the final idx delete all element that are in between forwardIdx and final idx
        else {
            int idxToRemove = list.size() - 1;
            int totalIdxToRemove = list.size() - currIdx;
            for(int i = 1; i < totalIdxToRemove; i++){
                list.remove(idxToRemove);
                idxToRemove -= 1;
            }
            list.add(url);
            currIdx = list.size() - 1;
        }

    }

    public String back(int steps) {
        // max steps that can be moved back is the length of the list
        int maxSteps = Math.min(currIdx, steps);
        var retVal = list.get(currIdx - maxSteps);
        currIdx = currIdx - maxSteps;
        return retVal;
    }

    public String forward(int steps) {
        int maxForwardSteps = Math.min(steps, list.size() - currIdx - 1);
        var retVal = list.get(currIdx + maxForwardSteps);
        currIdx += maxForwardSteps;
        return retVal;
    }

    public static void main(String[] args) {
        var s = new BrowserHistory("leetcode.com");
        System.out.println(s.list);
        s.visit("google.com");
        s.visit("facebook.com");
        s.visit("youtube.com");
        System.out.println(s.list);
        System.out.println(s.back(1));
        System.out.println(s.back(1));
        System.out.println(s.forward(1));
        s.visit("linkedin.com");
        System.out.println(s.forward(2));
        System.out.println(s.back(2));
        System.out.println(s.back(7));
        System.out.println(s.list);
        s.visit("james.com");
        System.out.println(s.list);
    }
}