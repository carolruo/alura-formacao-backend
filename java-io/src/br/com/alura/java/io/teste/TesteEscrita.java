package br.com.alura.java.io.teste;

import java.io.*;

public class TesteEscrita {
    public static void main(String[] args) throws IOException {
        OutputStream fos = new FileOutputStream("lorem2.txt"); //somente lê os bytes
        Writer osw = new OutputStreamWriter(fos); //transformar os bytes em caracteres
        BufferedWriter bw = new BufferedWriter(osw); //para poder ler uma linha inteira do arquivo

        bw.write("lorem lorem");
        bw.newLine();
        bw.newLine();
        bw.write("lorem lorem lorem");

        bw.close();

    }
}
