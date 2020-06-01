package com.algo.dnc;

public class BookAllocation {

    public static void main(String[] args) {
        int[] books = {10, 20, 30, 40};
        int totalStudents = 2;
        System.out.println("Minimum number of pages to read = " + getMinimumPages(books, totalStudents));
    }

    private static int getMinimumPages(int[] books, int totalStudents) {
        int start = Integer.MIN_VALUE;
        int totalPages = 0;
        int pagesToRead = 0;
        for (int book : books) {
            totalPages += book;
            start = Math.max(start, book);
        }
        while (start <= totalPages) {
            int mid = (start + totalPages) / 2;
            if (validDistribution(books, totalStudents, mid)) {
                pagesToRead = mid;
                totalPages = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return pagesToRead;
    }

    private static boolean validDistribution(int[] books, int totalStudents, int mid) {

        int student = 1;
        int currentPagesToRead = 0;
        for (int book : books) {
            if (currentPagesToRead + book > mid) {
                currentPagesToRead = book;
                ++student;
                if (student > totalStudents) {
                    return false;
                }
            } else {
                currentPagesToRead += book;
            }
        }
        return true;
    }
}
