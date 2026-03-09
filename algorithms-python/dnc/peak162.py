from typing import List


class Peak:
    def find_peak(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        if nums[0] > nums[1]:
            return 0
        if nums[len(nums) - 1] > nums[len(nums) - 2]:
            return len(nums) - 1
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if (mid + 1 < len(nums)) and (mid - 1 >= 0) and (nums[mid - 1] < nums[mid]) and (nums[mid] > nums[mid + 1]):
                return mid
            if (mid + 1 < len(nums)) and (nums[mid + 1] > nums[mid]):
                low = mid + 1
            else:
                high = mid - 1
        return -1            

def main() -> None:
    peak = Peak()
    nums = [1,2,3,1]
    print(peak.find_peak(nums=nums))


if __name__ == "__main__":
    main()
