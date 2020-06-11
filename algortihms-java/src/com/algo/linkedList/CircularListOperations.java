package com.algo.linkedList;

public class CircularListOperations {

    public static void main(String[] args) {
        CircularList cList = new CircularList();
        cList.insertFront(1);
        cList.insertFront(2);
        cList.insertFront(3);
        cList.insertFront(4);
        cList.display();
        cList.insertEnd(34);
        cList.insertEnd(38);
        cList.display();
        System.out.println("\nElement deleted from beginning = " + cList.deleteFront());
        System.out.println("\nElement deleted from beginning = " + cList.deleteFront());
        cList.display();
        System.out.println("\nElement deleted from end = " + cList.deleteEnd());
        System.out.println("\nElement deleted from end = " + cList.deleteEnd());
        cList.display();
        System.out.println("\n\n*************************************************************\n");
        CircularList sortedCList = new CircularList();
        sortedCList.insertEnd(3);
        sortedCList.insertEnd(5);
        sortedCList.insertEnd(9);
        sortedCList.insertEnd(10);
        sortedCList.display();
        sortedCList.insertInOrder(1);
        sortedCList.display();
        sortedCList.insertInOrder(8);
        sortedCList.display();
        sortedCList.insertInOrder(29);
        sortedCList.display();

        CircularList oddEvenList = new CircularList();
        System.out.println("\n\n*************************************************************\n");
        oddEvenList.insertEnd(20);
        oddEvenList.insertEnd(1);
        oddEvenList.insertEnd(2);
        oddEvenList.insertEnd(3);
        oddEvenList.insertEnd(4);
        oddEvenList.insertEnd(5);
        oddEvenList.insertEnd(6);
        oddEvenList.insertEnd(6);
        oddEvenList.insertEnd(8);
        oddEvenList.display();
        oddEvenList.removeEvenNodes();
        oddEvenList.display();


    }



}
