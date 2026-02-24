from typing import List


class Shipping:
    def get_min_weight(self, weights: List[int], days: int) -> int:
        low = max(weights)
        high = sum(weights)
        result = float("inf")
        while low <= high:
            mid = low + (high - low) // 2
            if self._valid(weights, mid, days):
                result = min(result, mid)
                high = mid - 1
            else:
                low = mid + 1
        return result

    def _valid(self, weights: List[int], mid: int, days: int):
        count = 0
        total = 0
        for weight in weights:
            if total + weight > mid:
                total = weight
                count += 1
                if count >= days:
                    return False
            else:
                total += weight
        return True

def main() -> None:
    weights = [1,2,3,4,5,6,7,8,9,10]
    days = 5
    shipping = Shipping()
    print(shipping.get_min_weight(weights, days))

if __name__ == "__main__":
    main()


