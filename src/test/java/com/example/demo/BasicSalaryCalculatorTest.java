package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BasicSalaryCalculatorTest {
    private BasicSalaryCalculator basicSalaryCalculator;

    @BeforeEach
    void init() {
        basicSalaryCalculator = new BasicSalaryCalculator();

    }

    @Test
    void testBasicSalaryWithValidSalary() {
        double basicSalary = 4000;
        basicSalaryCalculator.setBasicSalary(basicSalary);

        double expectedSocialInsurance = basicSalary * 0.25;
        assertEquals(expectedSocialInsurance, basicSalaryCalculator.getSocialInsurance());

        double expectedAddionalBonus = basicSalary * 0.1;
        assertEquals(expectedAddionalBonus, basicSalaryCalculator.getAdditionalBonus());

        double expectedGross = basicSalary + expectedSocialInsurance + expectedAddionalBonus;
        assertEquals(expectedGross, basicSalaryCalculator.getGrossSalary());

    }

    @Test
    void testBasicSalaryWithInValidSalary() {

         double basicSalary = -100;
        assertThrows(IllegalArgumentException.class, () -> {
            basicSalaryCalculator.setBasicSalary(basicSalary);
        });
    }

    @Test
    void getsalaryTset()
    {
        double basicSalary = 1000;
        basicSalaryCalculator.setBasicSalary(basicSalary);
        assertEquals(basicSalary,basicSalaryCalculator.getBasicSalary());

    }


}