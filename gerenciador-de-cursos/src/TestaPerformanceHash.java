import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformanceHash {

    public static void main(String[] args) {

        Collection<Integer> numeros = new ArrayList<Integer>();

        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= 50000; i++) {
            numeros.add(i);
        }

        long fim = System.currentTimeMillis();

        long tempoDeExecucao = fim - inicio;

        System.out.println("Array Tempo gasto for: " + tempoDeExecucao);

        long inicio1 = System.currentTimeMillis();

        for (Integer numero : numeros) {
            numeros.contains(numero);
        }

        long fim1 = System.currentTimeMillis();

        long tempoDeExecucao1 = fim1 - inicio1;

        System.out.println("Array Tempo gasto contains: " + tempoDeExecucao1);

        Collection<Integer> numerosHash = new HashSet<Integer>();

        long inicioHash = System.currentTimeMillis();

        for (int i = 1; i <= 50000; i++) {
            numerosHash.add(i);
        }

        long fimHash = System.currentTimeMillis();

        long tempoDeExecucaoHash = fimHash - inicioHash;

        System.out.println("Hash Tempo gasto for: " + tempoDeExecucaoHash);

        long inicio1Hash = System.currentTimeMillis();

        for (Integer numero : numeros) {
            numerosHash.contains(numero);
        }

        long fim1Hash = System.currentTimeMillis();

        long tempoDeExecucao1Hash = fim1Hash - inicio1Hash;

        System.out.println("Hash Tempo gasto contains: " + tempoDeExecucao1Hash);

    }

}