package kumari.shweta.productservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


public class RnadomTest {

    @Test
    void testSum() {
        int i = 1 + 1;//Arange+Act
        //Assert -> Check against the expected value

       //  assert i == 2;
       // assert i == 3;


       // assertEquals();
        assertEquals(2,i,"1+1 should be 2");

        assertTrue(2==2);
        String str=null;
        assertNull(str);


    }
}

/**
 * Test case is nothing but a method that test a particular functionality
 * Arrange Data
 * Act on Data
 * Asset Data
 *
 * In one test case we can have mutiple assert statements and the test case will pass
 * Iff all the assert statements will pass ,even if one assert statement fails the test case fail
 *
 * In some of the test cases we might need to check if function is throwing an exception or not
 * Scenario :If we want to test the time taken by a particular  function to get executed .
 *
 * */