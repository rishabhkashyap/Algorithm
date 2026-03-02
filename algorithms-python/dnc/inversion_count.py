from typing import List


class InversionCount:
    def count_inversion(self, arr: List[int]) ->int:
        return self._count_inversion(arr, 0, len(arr) - 1)
    def _count_inversion(self, arr: List[int], start: int, end: int)->int:
        if start >= end:
            return 0
        count = 0
        mid = (start + end) // 2
        count += self._count_inversion(arr, start, mid)
        count += self._count_inversion(arr, mid + 1, end)
        count += self._merge(arr, start, mid, end)
        return count
    
    def _merge(self, arr: List[int], start: int, mid: int, end: int) -> int:
        temp: List[int] = []
        i = start
        j = mid + 1        
        count = 0
        while (i <= mid) and (j <= end):
            if arr[i] <= arr[j]:
                temp.append(arr[i])
                i += 1
            else:
                temp.append(arr[j])
                count = count + (mid - i + 1)    
                j += 1
        while i <= mid:
            temp.append(arr[i])
            i += 1
        while j <= end:
            temp.append(arr[j])
            j += 1
        for i in range(len(temp)):
            arr[i + start] = temp[i]
        return count


def main() -> None:
    nums = [5,4,3,2,1]
    inversion_count = InversionCount()
    print(f"Inverson count = {inversion_count.count_inversion(nums)}")


if __name__ == "__main__":
    main()

               
