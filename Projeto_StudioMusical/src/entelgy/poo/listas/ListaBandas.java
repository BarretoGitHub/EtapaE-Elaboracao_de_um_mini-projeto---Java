package entelgy.poo.listas;

import entelgy.poo.classes.Banda;
import java.util.ArrayList;

public class ListaBandas {

    private ArrayList<Banda> bandas;

    public ListaBandas() {
        bandas = new ArrayList<>();
    }

    public boolean addBandas(Banda b) {
        return bandas.add(b);
    }

    public int getTamanho() {
        return bandas.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Banda banda : bandas) {
            builder.append(bandas);
            builder.append("\n");
        }
        return builder.toString();
    }
}
