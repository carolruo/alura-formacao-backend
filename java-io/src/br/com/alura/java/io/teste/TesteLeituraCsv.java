package br.com.alura.java.io.teste;
//pattern = regex
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TesteLeituraCsv {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("contas.csv"));

//        boolean tem = sc.hasNextLine(); n da pra usar ref no loop, pq a ref recebe true e n muda

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();

            Scanner linhaSc = new Scanner(linha);
            linhaSc.useLocale(Locale.US);
            linhaSc.useDelimiter(",");
            String tipoConta = linhaSc.next();
            int agencia = linhaSc.nextInt();
            int numero = linhaSc.nextInt();
            String titular = linhaSc.next();
            double saldo = linhaSc.nextDouble();

            System.out.format(new Locale("pt", "BR"),
                    "%s - %04d-%08d %20s: %010.2f \n",
                    tipoConta, agencia, numero, titular, saldo);


//            String[] valores = linha.split(",");
//            System.out.println(Arrays.toString(valores));
        }
        sc.close();
    }
}
