package com.example.demo.CollectionsSamples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

public class ArrayListDemo {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");

       //accessing the element
        System.out.println("Returning element: "+arrayList.get(1));
        //changing the element
        arrayList.set(1,"X");

        Iterator itr = arrayList.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

         System.out.println("Java 8 operation On ArrayList") ;
        //Java 8 operation On ArrayList
        arrayList.stream().forEach(System.out::println);

  //------------------------------ operation On Book class ------------------------------------------//

  ArrayList<Book> bookArrayList = new ArrayList<>();
  bookArrayList.add(new Book(1,"java","james","xyz",9));
  bookArrayList.add(new Book(1,"Spring Boot","james","xyz",9));
  bookArrayList.add(new Book(1,"GraphQl","james","xyz",9));

        for(Book b:bookArrayList){
            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
        }
      //java 8 using print the value of book
        bookArrayList.stream().map(x -> x.name).forEach(System.out::println);

   }
}


class Book {
    int id;
    String name,author,publisher;
    int quantity;
    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }
}