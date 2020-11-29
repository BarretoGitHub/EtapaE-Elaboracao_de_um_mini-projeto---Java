package entelgy.poo.classes;

public class Sala {

    private String nomeSala;
    private String valorHora;
    private String tamanhoSala;
    private String precoFinal;

    public Sala() {
    }

    public Sala(String nomeSala, String valorHora, String tamanhoSala, String precoFinal) {
        this.nomeSala = nomeSala;
        this.valorHora = valorHora;
        this.tamanhoSala = tamanhoSala;
        this.precoFinal = precoFinal;
    }


    public String getNomeSala() {
        return nomeSala;
    }

    public String getValorHora() {
        return valorHora;
    }

    public String getTamanhoSala() {
        return tamanhoSala;
    }

    public String getPrecoFinal() {
        return precoFinal;
    }

    public Object[] getObjetc() {
        return new Object[]{nomeSala, valorHora, tamanhoSala, precoFinal};
    }
}
