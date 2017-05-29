package com.aniket.ctci.test.arrayandstring;

import com.aniket.ctci.arrayandstring.UniqueString;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by AnGupta on 2/6/17.
 */
public class UniqueStringTest {

    @Test
    public void testUniqueString() {
        UniqueString uniqueString = new UniqueString();

        String testData = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        assertTrue(uniqueString.isUnique("a"));
        assertTrue(uniqueString.isUnique(null));
        assertTrue(uniqueString.isUnique(testData));
        for(int i = 0; i < 100; i++) {
            assertFalse(uniqueString.isUnique(genrateRandomString(72, testData)));
        }


    }

    @Test
    public void testUniqueString1() {
        UniqueString uniqueString = new UniqueString();

        String testData = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        assertTrue(uniqueString.isUnique1("a"));
        assertTrue(uniqueString.isUnique1(null));
        assertTrue(uniqueString.isUnique1(testData));
        for(int i = 0; i < 100; i++) {
            assertFalse(uniqueString.isUnique1(genrateRandomString(72, testData)));
        }

    }

    @Test
    public void testUniqueString2() {
        UniqueString uniqueString = new UniqueString();

        String testData = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        assertTrue(uniqueString.isUnique2("a"));
        assertTrue(uniqueString.isUnique2(null));
        assertTrue(uniqueString.isUnique2(testData));
        for(int i = 0; i < 100; i++) {
            assertFalse(uniqueString.isUnique2(genrateRandomString(72, testData)));
        }

    }

    @Test
    public void testUniqueString3() {
        UniqueString uniqueString = new UniqueString();

        String testData = "abcdefghijklmnopqrstuvwxyz";

        assertTrue(uniqueString.isUnique2("a"));
        assertTrue(uniqueString.isUnique2(null));
        assertTrue(uniqueString.isUnique2(testData));
        for(int i = 27; i < 100; i++) {
            assertFalse(uniqueString.isUnique2(genrateRandomString(27, testData)));
        }

    }

    public String genrateRandomString(int length, String chars) {

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
