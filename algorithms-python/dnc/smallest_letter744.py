from typing import List

#Problem: https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/

def nextGreatestLetter(letters: List[str], target: str) -> str:
        low = 0
        high = len(letters) - 1
        result = letters[0]
        while low <= high:
            mid = low +(high - low) // 2
            if target < letters[mid]:
                result = letters[mid]
                high = mid - 1  
            else:
                low = mid + 1
                 
        return result 

def main() -> None:
     letters = ["c","f","j"]
     target = "a"
     print(nextGreatestLetter(letters, target))
    
if __name__ == "__main__":
    main()