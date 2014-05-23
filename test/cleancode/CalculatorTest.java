/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cleancode;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jerome
 */
public class CalculatorTest {
    
    public CalculatorTest() {
    }

    @Test
    public void shouldAddTwoNumbers() {
        
        givenANewCalculator();
        
        int sum = whenIAdd(1, 2);
        
        thenTheSumShouldBe(3, sum);
    }

    private void thenTheSumShouldBe(final int expectedSum, int sum) {
        // Then
        assertEquals(expectedSum, sum);
    }
    
    private Calculator calculator;

    private int whenIAdd(int a, int b) {
        // When
        int sum = this.calculator.add(a, b);
        return sum;
    }

    private void givenANewCalculator() {
        // Given
        this.calculator = new Calculator();
    }
}
