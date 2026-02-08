class SquareRoot:
    def get_square_root(self, num: int) -> int:
        low = 0
        high = num
        ans = 0;
        while low <= high:
            mid = low + (high - low) // 2
            if num == mid * mid:
                return mid;
            elif num > (mid * mid):
                low = mid + 1
                ans = mid
            else:
                high = mid - 1
        return ans



def main() -> None:
    sqrt = SquareRoot()
    print(sqrt.get_square_root(5))


if __name__ == '__main__':
    main()

