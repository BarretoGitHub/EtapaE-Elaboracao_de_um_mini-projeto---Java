package entelgy.poo.listas;

import entelgy.poo.classes.Artista;
import java.util.ArrayList;

public class ListaArtistas {

    private ArrayList<Artista> artistas;

    public ListaArtistas() {
        artistas = new ArrayList<>();
    }

    public boolean addArtista(Artista artista) {
        return artistas.add(artista);
    }

    public int getTamanho() {
        return artistas.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Artista artista : artistas) {
            builder.append(artistas);
            builder.append("\n");
            builder.append("\n");
        }
        return builder.toString();
    }
}
