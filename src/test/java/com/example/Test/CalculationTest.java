package com.example.Test;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;



public class CalculationTest {
@Test
public void testFindMax(){
    assertEquals(4,Calculation.findMax(new int[]{1,3,4,2}));

}

}
