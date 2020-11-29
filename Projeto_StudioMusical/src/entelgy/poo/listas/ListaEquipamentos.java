package entelgy.poo.listas;

import entelgy.poo.classes.Equipamento;
import java.util.ArrayList;

public class ListaEquipamentos {

    private ArrayList<Equipamento> equipamentos;

    public ListaEquipamentos() {
        equipamentos = new ArrayList<>();
    }

    public boolean addSala(Equipamento e) {
        return equipamentos.add(e);
    }

    public int getTamanho() {
        return equipamentos.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Equipamento equipamento : equipamentos) {
            builder.append(equipamentos);
            builder.append("\n");
            builder.append("\n");
        }
        return builder.toString();
    }
}
