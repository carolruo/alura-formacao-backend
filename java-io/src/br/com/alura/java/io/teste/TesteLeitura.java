package br.com.alura.java.io.teste;

import java.io.*;

public class TesteLeitura {
    public static void main(String[] args) throws IOException {
        InputStream fis = new FileInputStream("lorem.txt"); //somente lê os bytes
        Reader isr = new InputStreamReader(fis); //transformar os bytes em caracteres
        BufferedReader br = new BufferedReader(isr); //para poder ler uma linha inteira do arquivo

        String linha = br.readLine();

        while (linha != null) {
            System.out.println(linha);
            linha = br.readLine();
        }

        br.close();

    }
}
