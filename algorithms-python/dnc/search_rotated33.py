from typing import List

#Problem: https://leetcode.com/problems/search-in-rotated-sorted-array/description/
class Search:
    def search_element(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] <= nums[high]:
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid -1
            else:
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
        return -1


def main():
    nums = [4, 5, 6, 7, 0, 1, 2]
    target = 0
    search = Search()
    print(search.search_element(nums, target))


if __name__ == '__main__':
    main()
