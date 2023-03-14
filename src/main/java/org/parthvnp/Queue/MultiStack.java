package org.parthvnp.Queue;

public class MultiStack {
    private class StackInfo{
        public int start, size, capacity;
        private StackInfo[] info;
        private int[] values;
        public StackInfo(int start, int capacity){
            this.start = start;
            this.size = capacity;
        }

        public boolean isWithinStackCapacity(int index){
            if(index < 0 || index >= values.length){
                return false;
            }
            int contiguousIndex = index < start ? index + values.length: index;
            int end = start + capacity;
            return start <= contiguousIndex && contiguousIndex < end;
        }


    }

}
