package br.com.alura.java.io.teste;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class UsandoEncodingCharset {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Charset utf8 = StandardCharsets.UTF_8;
        String s1 = "13º Órgão Oficial";
        byte[] bytes = s1.getBytes(utf8);
        String s2 = new String(bytes, utf8);
        System.out.println(s2);

        String s3 = "13º Órgão Oficial";
        System.out.println(s3.codePointAt(0));
    }
}
