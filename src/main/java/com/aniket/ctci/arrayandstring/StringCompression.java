package com.aniket.ctci.arrayandstring;

/**
 * Created by AnGupta on 2/13/17.
 * problem 1.6
 */
public class StringCompression {

    public static void main(String[] args) {

        System.out.println(new StringCompression().compressString("aabcccccaaa"));
        System.out.println(new StringCompression().compressString("aabccccca"));
        System.out.println(new StringCompression().compressString("a"));
        System.out.println(new StringCompression().compressString("abcc"));
        System.out.println(new StringCompression().compressString(null));
    }

    public String compressString(String str) {

        if(str == null) {
            return null;
        }

        StringBuffer stringBuffer = new StringBuffer();
        char c = str.charAt(0);
        int count = 1;
        stringBuffer.append(c);

        for (int i = 1; i < str.length(); i++) {
            if(c  == str.charAt(i)) {
                count++;
            } else {
                stringBuffer.append(count);
                count = 1;
                c  = str.charAt(i);
                stringBuffer.append(c);
            }
        }

        stringBuffer.append(count);
        if(str.length() <= stringBuffer.length()) return str;
        else return stringBuffer.toString();


    }
}
