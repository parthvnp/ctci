from typing import List


class InsertInterval:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        start, end = newInterval[0], newInterval[1]
        left, right = [], []
        for i in intervals:
            if i[1] < start:
                left.append([i[0], i[1]])
            elif i[0] > end:
                right.append([i[0], i[1]])
            else:
                start = min(start, i[0])
                end = max(end, i[1])
        return left + [[start, end]] + right

    def insert_three_parts(self, intervals: List[List[int]], new_interval: List[int]) -> List[int]:
        res = []
        i = 0
        start = new_interval[0]
        end = new_interval[1]
        while i < len(intervals) and intervals[i][1] < start:
            res.append([intervals[i][0], intervals[i][1]])
            i += 1
        while i < len(intervals) and intervals[i][0] <= end:
            start = min(start, intervals[i][0])
            end = max(end, intervals[i][1])
            i += 1
        res.append([start, end])
        while i < len(intervals):
            res.append([intervals[i][0], intervals[i][1]])
            i += 1
        return res


insert_interval = InsertInterval()
print(insert_interval.insert_three_parts([[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]], [4, 8]))
