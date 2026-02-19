from typing import List

#Problem: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
# when nums[low] is equal to nums[mid] we increment low by 1, so for checking whether
#left part is sorted or righ part is sorted compare nums[low] and nums[mid]
class Search:
    def find(self, nums: List[int], target: int) -> bool:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if target == nums[mid]:
                return True
            if nums[low] > nums[mid]:
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
            elif nums[low] < nums[mid]:
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                low += 1
        return False


def main():
    search = Search()
    nums = [1, 1, 1, 1, 1, 1, 1, 1, 1, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
    target = 13
    print(search.find(nums, target))


if __name__ == '__main__':
    main()
