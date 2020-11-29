package entelgy.poo.classes;

public class Banda {

    private String nomeBanda;
    private String estiloMusicalBanda;
    private String telefoneBanda;
    private String enderecoBanda;

    public Banda() {
        //Construtor default
    }

    public Banda(String nomeBanda, String estiloMusicalBanda, String telefoneBanda, String enderecoBanda) {
        this.nomeBanda = nomeBanda.toUpperCase();
        this.estiloMusicalBanda = estiloMusicalBanda.toUpperCase();
        this.telefoneBanda = telefoneBanda;
        this.enderecoBanda = enderecoBanda.toUpperCase();
    }

    public String getNomeBanda() {
        return nomeBanda;
    }

    public String getEstiloMusicalBanda() {
        return estiloMusicalBanda;
    }

    public String getTelefoneBanda() {
        return telefoneBanda;
    }

    public String getEnderecoBanda() {
        return enderecoBanda;
    }

    public Object[] getObjetcBanda() {
        return new Object[]{nomeBanda, estiloMusicalBanda, telefoneBanda, enderecoBanda};
    }

    @Override
    public String toString() {
        System.out.println("\n----BANDA----\n");
        String flag = String.format("Nome: %sEstilo Musical: %s\nTelefone: %s\nEndereco: %s", nomeBanda, estiloMusicalBanda, telefoneBanda, enderecoBanda);
        return flag;
    }

}
