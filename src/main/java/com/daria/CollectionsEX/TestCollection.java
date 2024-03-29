package com.daria.Collections;

import com.daria.Exception.EmptyCollection;
import com.daria.Exception.NullElement;

public class TestCollection {
    public static void main(String[] args) throws NullElement {
        testAddandGet();
        testRemove();
        testIndexOfAndSize();
        testMaxAndMinAndAvg();
    }

    private static void testAddandGet() throws NullElement{
        SimpleCollectionNumbers<Integer> collection = new SimpleCollectionNumbers<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);
        int a = collection.get(4);

        if (a == 5) {
            System.out.println("TestAddandGet passed");
            printCollectionAndTestIterator(collection);
        }
    }

    private static void testRemove() throws NullElement{
        SimpleCollectionNumbers<Integer> collection = new SimpleCollectionNumbers<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);
        int sizeBefore = collection.size();
        collection.remove(0);
        int a = collection.get(0);
        int sizeAfter = collection.size();

        if (a == 2) {
            System.out.println("TestRemove passed. Size Collection before remove - " + sizeBefore + ". Size Collection " +
                    "after remove - " + sizeAfter);
            printCollectionAndTestIterator(collection);
        }
    }

    private static void testIndexOfAndSize() {
        SimpleCollectionNumbers<Integer> collection = new SimpleCollectionNumbers<>();
        int a = 0;
        int size = collection.size();

        try {
//        collection.add(1);
//        collection.add(2);
//        collection.add(3);
//        collection.add(4);
//        collection.add(5);
            a = collection.indexOf(1);
        } catch (EmptyCollection e) {
            System.out.print(e.getMessage());
            System.out.println(e.getSize());
        }

        if (a == 3) {
            System.out.println("TestIndexOf passed");
        }


        if (size == 5) {
            System.out.println("TestSize passed. Size - " + size);
        }
    }

    private static void testMaxAndMinAndAvg() {
        SimpleCollectionNumbers<Integer> collection = new SimpleCollectionNumbers<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);
        int max = collection.max();
        int min = collection.min();
        double avg = collection.avg();
        printCollectionAndTestIterator(collection);

        if (max == 5) {
            System.out.println("TestMax passed. Max - " + max);
        }
        if (min == 1) {
            System.out.println("TestMin passed. Min - " + min);
        }
        if (avg == 3.0) {
            System.out.println("TestAvg passed. Avg - " + avg);
        }
    }

    private static void printCollectionAndTestIterator(SimpleCollectionNumbers<Integer> collection) {
        SimpleIterator<Integer> iterator = (SimpleIterator<Integer>) collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
