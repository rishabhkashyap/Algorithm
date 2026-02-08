from typing import List


class Search:
    def _find_first_loc(self, nums: List[int], target: int) -> int:
        loc = -1
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                loc = mid
                high = mid - 1
            elif target > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return loc

    def _find_last_loc(self, nums: List[int], target: int) -> int:
        loc = -1
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                loc = mid
                low = mid + 1
            elif target > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return loc

    def find_locs(self, nums: List[int], target: int) -> List[int]:
        return [self._find_first_loc(nums, target), self._find_last_loc(nums, target)]



def main()->None:
    search = Search()
    nums = [5,7,7,8,8,10]
    target = 8
    print(search.find_locs(nums, target))


if __name__ == '__main__':
    main()
