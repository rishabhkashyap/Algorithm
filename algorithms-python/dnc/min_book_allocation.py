from typing import List


class Book:
    def find_min_books(self, books: List[int], students: int) -> int:
        if students > len(books):
            return -1
        low = books[0];
        high = 0;
        result = float('inf')
        for book in books:
            low = max(low, book)
            high += book
        while low <= high:
            mid = low + (high - low) // 2
            if self._valid_distribution(books, mid, students):
                result = min(result, mid)
                high = mid - 1
            else:
                low = mid + 1
        return result

    def _valid_distribution(self, books, mid, students):
        total = 0;
        count = 0;
        for book in books:
            if total + book > mid:
                count += 1;
                total = book
                if count >= students:
                    return False
            else:
                total += book
        return True


def main() -> None:
    book = Book()
    books = [12, 34, 67, 90]
    students = 2
    print(book.find_min_books(books, students))


if __name__ == '__main__':
    main()
