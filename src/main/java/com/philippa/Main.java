package com.philippa;

import domain.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra Darwin";

        // split string data
        String[] data = stringData.split(" ");

        // create new item with value set to the string 's'
        for (String s : data) {
            linkedList.addNode(s);
        }

        linkedList.printList();

        linkedList.deleteNode("Perth");
        System.out.println("\n");
        linkedList.printList();
    }
}
