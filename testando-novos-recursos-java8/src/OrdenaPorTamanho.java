import java.util.Comparator;
//Interface que foi transformada em labda na Aula01
public class OrdenaPorTamanho implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        //Integer.compare(o1.length(), o2.length()):
        if (o1.length() < o2.length()) { //se o1 for menor, colocar ele primeiro
            return -1;
        }
        if (o1.length() > o2.length()) {
            return 1;
        }
        return 0;
    }
}
