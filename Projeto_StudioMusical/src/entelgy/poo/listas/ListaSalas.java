package entelgy.poo.listas;

import entelgy.poo.classes.Sala;
import java.util.ArrayList;

public class ListaSalas {

    private ArrayList<Sala> salas;

    public ListaSalas() {
        salas = new ArrayList<>();
    }

    public boolean addSala(Sala s) {
        return salas.add(s);
    }

    public int getTamanho() {
        return salas.size();
    }
    
    public ArrayList<Sala> getSalas() {
        
        return salas;
    }

    /*@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Sala sala : salas) {
            builder.append(salas);
            builder.append("\n");
        }
        return builder.toString();
    }*/

}
