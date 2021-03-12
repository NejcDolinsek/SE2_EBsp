package com.example.se2_ebsp;

import android.widget.EditText;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    String Matrikelnummer;

    @Before
    public void setup(){
        Matrikelnummer ="11704726";
    }

    @After
    public void clear(){
        Matrikelnummer = null;
    }

    @Test
    public void TestIsPrime (){
        assertTrue(PrimeNumbers.isPrime(7));
    }
}