from typing import List
from shared.test import test

class HighestAltitude:
    def largestAltitude(self, gain: List[int]) -> int:
        current_altitude = 0
        # Highest altitude currently is 0.
        highest_point = current_altitude

        for altitude_gain in gain:
            # Adding the gain in altitude to the current altitude.
            current_altitude += altitude_gain
            # Update the highest altitude.
            highest_point = max(highest_point, current_altitude)

        return highest_point


if __name__ == '__main__':
    s = HighestAltitude()
    test(1, s.largestAltitude([-5, 1, 5, 0, -7]))
    test(0, s.largestAltitude([-4, -3, -2, -1, 4, 3, 2]))
    test(15, s.largestAltitude([1, 2, 3, 4, 5]))
