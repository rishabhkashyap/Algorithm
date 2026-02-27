package com.algo.heaps;

//Problem: https://leetcode.com/problems/longest-happy-string/description/

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HappyString1405 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = 7;
        System.out.println(createLongestString(a, b, c));
    }

    private static String createLongestString(int a, int b, int c) {
        Queue<Letter> queue = new PriorityQueue<>(Comparator.comparing(Letter::count).reversed());
        insert(queue, new Letter('a', a));
        insert(queue, new Letter('b', b));
        insert(queue, new Letter('c', c));
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            var firstLetter = queue.remove();
            if(canAdd(sb, firstLetter.ch)){
                sb.append(firstLetter.ch());
                firstLetter = new Letter(firstLetter.ch(), firstLetter.count - 1);
            }else{
                if(queue.isEmpty()){
                    break;
                }
                var secondLetter = queue.remove();
                sb.append(secondLetter.ch());
                if(secondLetter.count - 1 > 0){
                    queue.add(new Letter(secondLetter.ch(), secondLetter.count - 1));
                }
            }
            if(firstLetter.count > 0){
                queue.add(firstLetter);
            }
        }
        return sb.toString();
    }
    private static void insert(Queue<Letter> queue, Letter letter){
        if(letter.count != 0){
            queue.add(letter);
        }
    }

    private static boolean canAdd(StringBuilder sb, char ch){
        return sb.length() < 2 ||(sb.charAt(sb.length() -1) != ch)
                || (sb.charAt(sb.length() - 2) != ch);
    }
    private record Letter(char ch, Integer count){}
}
