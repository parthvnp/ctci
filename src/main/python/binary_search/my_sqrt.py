class MySqrt:
    def mySqrt(self, x: int) -> int:
        left, right = 0, x
        while left <= right:
            mid = left + (right - left) // 2
            if mid * mid == x: return mid
            if x > mid * mid: left = mid + 1
            else: right = mid - 1
        return left - 1

if __name__ == '__main__':
    s = MySqrt()
    e1 = s.mySqrt(4)
    print(e1 == 2)
    e2 = s.mySqrt(8)
    print(e2 == 2, e2)
    e3 = s.mySqrt(9)
    print(e3 == 3, e3)
    e4 = s.mySqrt(10)
    print(e4 == 3, e4)
