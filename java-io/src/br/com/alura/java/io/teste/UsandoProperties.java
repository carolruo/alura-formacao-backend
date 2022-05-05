package br.com.alura.java.io.teste;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class UsandoProperties {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.setProperty("login","alura");
        props.setProperty("senha", "alurapass");
        props.setProperty("endereco", "www.alura.com.br");

        //Escrita de properties
        props.store(new FileWriter("conf.properties"), "algum comentario");

    }
}
