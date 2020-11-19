package com.algo.dnc;

import java.util.Arrays;

public class BookAllocation {

    public static void main(String[] args) {
        //int[] books = {10, 20, 30, 40};
        int[] books = {12, 34, 67, 90};
        int totalStudents = 2;
        System.out.println("Minimum number of pages to read = " + getMinimumPages(books, totalStudents));
    }

    private static int getMinimumPages(int[] books, int totalStudents) {
        int start = books[books.length - 1];
        int totalPages = Arrays.stream(books).sum();
        int pagesToRead = 0;
        while (start <= totalPages) {
            int mid = start + (totalPages - start) / 2;
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
