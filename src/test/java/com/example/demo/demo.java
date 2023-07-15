package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.mock.web.server.MockServerWebExchange;
import org.springframework.web.reactive.function.server.RenderingResponse;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.ViewResolver;
import org.springframework.web.reactive.result.view.ViewResolverSupport;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class demo {

    Flux<String> source = Flux.just("John", "Monica");


    @Test
    public void filterWithInvalidMethodValue() {
        Flux<String> source = Flux.just("John", "Monica");

    }

    @Test
      void Test_Field()
    {
        //Create a Flux
        Flux <Integer> fluxToTest = Flux.just(1, 2, 3, 4, 5);

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
     void  test_condition()
    {
        Flux<String> error = source.concatWith(
                Mono.error(new IllegalArgumentException("Our message"))
        );
        StepVerifier.create(error)
//                .expectNext("John")
//                .expectNext("Monica")
                .expectNextCount(1 )
                .expectNext("Monica")
                .expectErrorMessage("Our message")
                .verify();
    }


    public void testExpected()
    {
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
    }






}
