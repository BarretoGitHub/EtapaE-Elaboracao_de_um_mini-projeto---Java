package entelgy.poo.classes;

import java.util.ArrayList;

public class EstiloMusical {

    private String nomeEstilo;

    public EstiloMusical(String nomeEstilo) {
        this.nomeEstilo = nomeEstilo;
    }

    public String getNomeEstilo() {
        return nomeEstilo;
    }

    private ArrayList<String> estilos = new ArrayList<>();

    public void setEstilos() {
        estilos.add("ROCK");
        estilos.add("BLUES");
        estilos.add("JAZZ");
        estilos.add("COUNTRY");
        estilos.add("ELETRÔNICO");
        estilos.add("CLASSIC/ERODITO");
        estilos.add("SERTANEJO");
        estilos.add("AXÉ");
        estilos.add("SAMBA");
        estilos.add("CHORINHO");
        estilos.add("PAGODE");
        estilos.add("FUNK");
    }
}
