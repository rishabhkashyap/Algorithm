from typing import List


class BinarySearch:

    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

    def search_recursive(self, nums: List[int], target: int, low: int, high: int) -> int:
        if low > high:
            return -1
        mid = low + (high - low) // 2
        if nums[mid] == target:
            return mid
        if target > nums[mid]:
            return self.search_recursive(nums, target, mid + 1, high)
        else:
            return self.search_recursive(nums, target, low, mid - 1)


def main() -> None:
    nums = [-1, 0, 3, 5, 9, 12]
    binary_search = BinarySearch()
    print(binary_search.search(nums, 9))
    print(binary_search.search_recursive(nums, 12, 0, len(nums) - 1))



if __name__ == '__main__':
    main()
