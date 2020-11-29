package entelgy.poo.listas;

import entelgy.poo.classes.Gravacao;
import java.util.ArrayList;

public class ListaGravacoes {

    private ArrayList<Gravacao> gravacoes;

    public ListaGravacoes() {
        gravacoes = new ArrayList<>();
    }

    public boolean addReservaGravacao(Gravacao gravacao) {
        return gravacoes.add(gravacao);
    }

    public int getTamanho() {
        return gravacoes.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Gravacao gravacao : gravacoes) {
            builder.append(gravacoes);
            builder.append("\n");
            builder.append("\n");
        }
        return builder.toString();
    }
}
