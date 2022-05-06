package api_datas;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Datas {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println("Hoje: " + hoje);

        System.out.println("---------------------------------");

        LocalDate olimpiadas = LocalDate.of(2023, Month.FEBRUARY, 20);

        Period periodoEntreDatas = Period.between(hoje, olimpiadas);
        System.out.println("faltam " + periodoEntreDatas.getMonths() + " meses e " + periodoEntreDatas.getDays() + " dias");

        System.out.println("---------------------------------");

        LocalDate novasOlimpiadas = olimpiadas.plusYears(4);
        novasOlimpiadas.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Proxima Olimpiada: " + novasOlimpiadas);

        System.out.println("---------------------------------");

        LocalDateTime agora = LocalDateTime.now();
        System.out.println("Hoje e hora: " + agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));

        System.out.println("---------------------------------");

        LocalTime intervalo = LocalTime.of(15, 30);
        System.out.println("Hora do intervalo: " + intervalo);
    }
}
