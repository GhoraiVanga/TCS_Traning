package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

@Test
 void t1()
{
    List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
    Set<String> result = listWithDuplicates.stream().collect(toSet());


}


}
