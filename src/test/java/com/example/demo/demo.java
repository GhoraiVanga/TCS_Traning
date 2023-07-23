package com.example.demo;


import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

public class demo {


    Flux<String> source = Flux.just("John", "Monica");


    @Test
    public void filterWithInvalidMethodValue() {
        Flux<String> source = Flux.just("John", "Monica");

    }

    @Test
    void Test_Field() {
        //Create a Flux
        Flux<Integer> fluxToTest = Flux.just(1, 2, 3, 4, 5);

        // Create a test
        StepVerifier.create(fluxToTest)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(4)
                .expectNext(5)
                .expectComplete() // we expect Flux to complete after sending the number 5 which is the last element
                .verify();

    }


    @Test
    void test_condition() {
        Flux<String> error = source.concatWith(
                Mono.error(new IllegalArgumentException("Our message"))
        );
        StepVerifier.create(error)
//                .expectNext("John")
//                .expectNext("Monica")
                .expectNextCount(1)
                .expectNext("Monica")
                .expectErrorMessage("Our message")
                .verify();
    }


    public void testExpected() {
        throw new IllegalArgumentException();
    }

    @Test
    public void discardLocalOrder() {
        List<String> discardOrder = Collections.synchronizedList(new ArrayList<>(2));
        StepVerifier.create(Mono.just(1)
                        .hide() //hide both avoid the fuseable AND tryOnNext usage
                        .filter(i -> i % 2 == 0)
                        .doOnDiscard(Number.class, i -> discardOrder.add("FIRST"))
                        .doOnDiscard(Integer.class, i -> discardOrder.add("SECOND"))
                )
                .expectComplete()
                .verify();
        Assertions.assertThat(discardOrder).containsExactly("FIRST", "SECOND");
        System.out.println("hello");
    }

    @Test
    public void testConvertToDoubleOK() {
        // Test case with the age is a numeric string
        String age = "1990";
        Double expAge = Double.valueOf(age);
        Double actual = StringUtils.convertToDouble(age);

        assertAll("Do many assertions.", () -> {
            assertNotNull(actual);
            assertEquals(expAge, actual);
        });

        // Or Java 8 Lambdas style

        assertAll("Do many assertions.Java 8 Lambdas style", () -> {
            assertNotNull(actual, () -> "The actual is NULL");
            assertEquals(expAge, actual,
                    () -> "The expected is: " + expAge + " while the actual is:" + actual);
        });

    }


    @Test
    public void testConvertToDoubleOKIS_NULL() {
        String age = null;

        Double actual = StringUtils.convertToDouble(age);
        assertNull(actual);


    }

    @Test
    public void isNullOrBlank_Test()
    {
        String st = null ;
        String st1 = " ";
        boolean check = StringUtils.isNullOrBlank(st);


        assertAll("Checking ", () -> {
            assertEquals(Boolean.TRUE ,check);

        });
    }

 @Test
    public void checkifitsnotnull()
 {
     String st = null ;
     String defaultSt = "hello";

      String check = StringUtils.getDefaultIfNull(st,defaultSt) ;


       assertEquals(defaultSt,check);

 }

 @Test
    public void checkConcat()
 {
     String str1 = "hello";
     String str2 = "by";

     String actual = str1 +str2 ;
     String expected = StringUtils.concat(actual);

     assertEquals(actual,expected);

 }

 @Test
    public void checkConcat_Null_ADD()
    {
        String str1 = "hello";
        String str2 = "by";
        String str3  = null ;

        String actual = str1 +str2+str3;
        String expected = StringUtils.concat(actual);

        assertEquals(actual,expected);
    }

    @Test
    public void checkConcatWithNull() {
        String expected = StringUtils.concat();
        assertNull(expected);
    }

    @Test

    public void exception_Test()
    {
        String str = null ;
        assertThrows( IllegalArgumentException.class, () -> {
            StringUtils.convertToInt(str);
        }) ;
    }

    @Test
    public void convertToIntNullParameterExpectThrows() {
        String st = null;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.convertToInt(st);
        });
        assertEquals("String must be not null or empty", exception.getMessage());
    }

    @Test
    public void convertToIntNullParameterTryCatchIdiom() {
        String st = null;
        try {
            StringUtils.convertToInt(st);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("String must be not null or empty", e.getMessage());
        }
    }





}