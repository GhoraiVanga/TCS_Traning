package com.example.demo.CollectionsSamples;

import java.util.HashSet;
import java.util.Iterator;

public class HasSetDemo {

    public static void main(String[] args) {

      HashSet<String> set=new HashSet();
        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");
        set.add("Five");
        Iterator<String> i=set.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }


        HashSet<Book_1> hashSet=new HashSet<Book_1>();
        //Creating Books
        Book_1 b1=new Book_1(101,"Let us C","Yashwant Kanetkar","BPB",8);
        Book_1 b2=new Book_1(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
        Book_1 b3=new Book_1(103,"Operating System","Galvin","Wiley",6);
        //Adding Books to HashSet
        hashSet.add(b1);
        hashSet.add(b2);
        hashSet.add(b3);
        //Traversing HashSet
        for(Book_1 b:hashSet){
            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
        }




    }
}
class Book_1 {
    int id;
    String name,author,publisher;
    int quantity;
    public Book_1(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }
}