from typing import *


class ReducingDishes:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        satisfaction.sort(reverse=True)
        running_sum = 0
        result = 0
        for val in satisfaction:
            running_sum += val
            if running_sum < 0: break
            result += running_sum
        return result

