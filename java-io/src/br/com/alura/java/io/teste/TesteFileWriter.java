package br.com.alura.java.io.teste;
// file writer -> buffered writer -> printstream
import java.io.*;

public class TesteFileWriter {
    public static void main(String[] args) throws IOException {
//        OutputStream fos = new FileOutputStream("lorem2.txt"); //somente lê os bytes
//        Writer osw = new OutputStreamWriter(fos); //transformar os bytes em caracteres
//        BufferedWriter bw = new BufferedWriter(osw); //para poder ler uma linha inteira do arquivo

//         bw.newLine(); //mais alto nivel pular linha com o buffered que com o fw (file writer)
////       fw.write(System.lineSeparator()); // \n universal sistemas operacionais

//        BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));

        PrintStream ps = new PrintStream("lorem2.txt");
        ps.println("lololos");
        ps.println();

        ps.close();

//        bw.write("lalala file writer");
//        bw.newLine();
//        bw.write("lorem lorem lorem");
//
//        bw.close();

    }
}
