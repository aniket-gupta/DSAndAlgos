package com.aniket.ctci.test.searching;

import com.aniket.ctci.searching.PatternMatching;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by AnGupta on 1/17/17.
 */
public class PatternMatchingTest {

    @Test
    public void testNaiveMethod(){
        String text = "THIS IS A TEST TEXT";
        String patt = "TEST";
        int expectedResult = 10;
        Assert.assertEquals(expectedResult, new PatternMatching().naiveMethod(text, patt));
        text = "THIS IS A TEST TEXT";
        patt = "TEXT";
        expectedResult = 15;
        assertEquals(expectedResult, new PatternMatching().naiveMethod(text, patt));
        text = "THIS IS A TEST TEXT";
        patt = "TEXTT";
        expectedResult = -1;
        assertEquals(expectedResult, new PatternMatching().naiveMethod(text, patt));
        text = "AABAACAADAABAABA";
        patt = "AABA";
        expectedResult = 0;
        assertEquals(expectedResult, new PatternMatching().naiveMethod(text, patt));

        text = genrateRandomString(10, "abc");
        patt = genrateRandomString(3, "abc");
        expectedResult = text.indexOf(patt);

        System.out.println("text " + text);
        System.out.println("patt " + patt);
        System.out.println("expectedResult " + expectedResult);

        assertEquals(expectedResult, new PatternMatching().naiveMethod(text, patt));

        text = genrateRandomString(10, "abc");
        patt = text.substring(7);
        expectedResult = text.indexOf(patt);

        System.out.println("text " + text);
        System.out.println("patt " + patt);
        System.out.println("expectedResult " + expectedResult);

        assertEquals(expectedResult, new PatternMatching().naiveMethod(text, patt));

        text = genrateRandomString(10, "abc");
        patt = text.substring(5);
        expectedResult = text.indexOf(patt);

        System.out.println("text " + text);
        System.out.println("patt " + patt);
        System.out.println("expectedResult " + expectedResult);

        assertEquals(expectedResult, new PatternMatching().naiveMethod(text, patt));

    }

    @Test
    public void testBuildLPSMethod() {
        assertArrayEquals(new int[]{0, 1, 2, 3}, new PatternMatching().buidLPSArray("AAAA"));
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, new PatternMatching().buidLPSArray("ABCDE"));
        assertArrayEquals(new int[]{0, 1, 0, 1, 2, 0, 1, 2, 3, 4, 5}, new PatternMatching().buidLPSArray("AABAACAABAA"));
        assertArrayEquals(new int[]{0, 1, 2, 0, 1, 2, 3, 3, 3, 4}, new PatternMatching().buidLPSArray("AAACAAAAAC"));
        assertArrayEquals(new int[]{0, 1, 2, 0, 1, 2, 3}, new PatternMatching().buidLPSArray("AAABAAA"));
    }

    @Test
    public void testKmpAlgo() {
        assertEquals(10, new PatternMatching().kmpAlgo("ABABDABACDABABCABAB", "ABABCABAB"));
        for(int i = 0; i< 100; i++) {
            String text = genrateRandomString(100, "ab");
            String patt = genrateRandomString(4, "ab");
            int exp = text.indexOf(patt);
            System.out.println("text " + text);
            System.out.println("patt " + patt);
            System.out.println( "exp " +exp);
            assertEquals(exp, new PatternMatching().kmpAlgo(text, patt));

            text = genrateRandomString(1000, "abcdef");
            patt = genrateRandomString(3, "abc");
            exp = text.indexOf(patt);
            System.out.println("text " + text);
            System.out.println("patt " + patt);
            System.out.println( "exp " +exp);
            assertEquals(exp, new PatternMatching().kmpAlgo(text, patt));

            text = genrateRandomString(10000, "abcd");
            patt = genrateRandomString(5, "abcd");
            exp = text.indexOf(patt);
            System.out.println("text " + text);
            System.out.println("patt " + patt);
            System.out.println( "exp " +exp);
            assertEquals(exp, new PatternMatching().kmpAlgo(text, patt));
        }

    }

    public static String genrateRandomString(int length, String chars) {

        char[] charset = chars.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < length; i++) {
            int offset =random.nextInt(charset.length);
            stringBuffer.append(charset[offset]);
        }

        return stringBuffer.toString();

    }
}
