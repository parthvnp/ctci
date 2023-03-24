from typing import *


class CourseSchedule:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        def construct():
            adj = {k:[] for k in range(numCourses)}
            for required, course in prerequisites: adj[course].append(required)
            return adj

        graph = construct()
        visited = [0] * numCourses
        def has_cycle(index):
            if visited[index] == 1: return False
            if visited[index] == -1: return True
            visited[index] = - 1
            for n in graph[index]:
                if has_cycle(n): return True
            visited[index] = 1

        for i in range(numCourses):
            if has_cycle(i):
                return False
        return True


if __name__ == '__main__':
    s = CourseSchedule()
    r = s.canFinish(20, [[0, 10], [3, 18], [5, 5], [6, 11], [11, 14], [13, 1], [15, 1], [17, 4]])
    print(r)
