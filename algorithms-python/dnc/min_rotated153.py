from typing import List

#Problem: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

class Search:
    def find_min1(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        result = nums[0];
        while low <= high:
            # This if statement servers 2 purpose
            # 1. if array is sorted but not rotated it will find the min element will be the first element
            # 2. In an rotated sorted array after updating low and high pointer there is a possibility
            #   that we stumble upon sub array(nums[low .... high]) which is sorted, in that case
            # nums[low] will be the min element
            if nums[low] < nums[high]:
                result = min(result, nums[low])
                break
            mid = low + (high - low) // 2
            result = min(result, nums[mid])
            if nums[mid] >= nums[high]:
                low = mid + 1
            else:
                high = mid - 1
        return result

    # Not very clear approach
    def find_min2(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while low < high:
            if nums[low] < nums[high]:
                return nums[low]
            mid = low + (high - low) // 2
            if nums[mid] > nums[high]:
                low = mid + 1
            else:
                high = mid
        return nums[low]

    def find_max(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        result = nums[0];
        while low <= high:
            if nums[low] < nums[high]:
                result = max(result, nums[high])
                break
            mid = low + (high - low) // 2
            result = max(result, nums[mid])
            if nums[mid] >= nums[high]:
                low = mid + 1
            else:
                high = mid - 1
        return result


def main():
    search = Search()
    nums = [4, 5, 6, 7, 0, 1, 2]
    print(f"Min element = {search.find_min1(nums)}")
    print(f"Min element = {search.find_min2(nums)}")
    print(f"Man element = {search.find_max(nums)}")


if __name__ == '__main__':
    main()
