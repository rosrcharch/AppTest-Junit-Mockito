package com.duque.dev.testeunitario;

import android.content.Context;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


public class ExampleUnitTest {

    @Mock
    public String TEST_STRING = "HELLO!";

    @Mock
    Context mMockContext;

    ClassUnderTest test;


    @Before
    public void setup(){
        System.out.println("Before");
        test = new ClassUnderTest(mMockContext);
    }


    @Test
    public void readStringFromContext(){


        when(mMockContext.getString(R.string.text_hello_word)).thenReturn(TEST_STRING);

        String result = test.getHelloWordString();

        assertThat(result, is(TEST_STRING));


    }

    @Test
    public void testMockMethod(){
        List mockList = Mockito.mock(ArrayList.class);
        mockList.add("hello world");
        Mockito.verify(mockList).add("hello world");
        assertEquals(0, mockList.size());
    }

    @Test
    public void testSpyMethod(){
        List spyList = Mockito.spy(new ArrayList());
        spyList.add("hello world");
        Mockito.verify(spyList).add("hello world");
        assertEquals(1, spyList.size());
    }

    @Test
    public void testTruncarANas2PrimeirasPosicoes(){
        assertEquals("BC", test.trocarValorAEMostrarValorResultante("AABC"));
        assertEquals("CD", test.trocarValorAEMostrarValorResultante("ACD"));
        assertEquals("CDEF", test.trocarValorAEMostrarValorResultante("CDEF"));
        assertEquals("CDAA", test.trocarValorAEMostrarValorResultante("CDAA"));

    }

    @Test
    public void testSaoOsPrimeirosEOsUltimos2CaractersIguais(){

        assertFalse( test.saoOsPrimeirosEOsUltimos2CaractersIguais("ABCD"));
        assertTrue( test.saoOsPrimeirosEOsUltimos2CaractersIguais("ABAB"));

    }

    @Test
    public void testArraySort_RandomArray(){
        int[] numbers = {12,3,4,1};
        int[] expected = {1,3,4,12};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
        System.out.println(numbers);
    }

}