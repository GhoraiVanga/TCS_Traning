package com.example.demo.CollectionsSamples;

import java.util.HashMap;
import java.util.Map;

public class HasMapDemo {
    public static void main(String[] args) {


        HashMap<Integer,String> map=new HashMap<Integer,String>();
        map.put(1,"Mango");
        map.put(2,"Apple");
        map.put(3,"Banana");
        map.put(4,"Grapes");

        System.out.println("Iterating Hashmap...");
        for(Map.Entry m : map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }



    }
}
