package entelgy.poo.classes;

public class Artista {

    private String nomeArtista;
    private String estiloMusical;
    private String registroOMB;
    private String telefoneArtista;
    private String enderecoArtista;

    public Artista() {
        //construtor default
    }

    public Artista(String nomeArtista, String estiloMusical, String registroOMB, String telefoneArtista, String enderecoArtista) {
        this.nomeArtista = nomeArtista.toUpperCase();
        this.estiloMusical = estiloMusical.toUpperCase();
        this.registroOMB = registroOMB.toUpperCase();
        this.telefoneArtista = telefoneArtista.toUpperCase();
        this.enderecoArtista = enderecoArtista.toUpperCase();
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public String getRegistroOMB() {
        return registroOMB;
    }

    public String getEstiloMusical() {
        return estiloMusical;
    }

    public String getTelefoneArtista() {
        return telefoneArtista;
    }

    public String getEnderecoArtista() {
        return enderecoArtista;
    }

    @Override
    public String toString() {
        String flag = String.format("Nome: %s\nEstilo Musical: %s\nRegistro OMB: %s\nTelefone: %s\nEndereço: %s", nomeArtista, estiloMusical, registroOMB, telefoneArtista, enderecoArtista);

        return flag;
    }

    public Object[] getObjetcArtista() {
        return new Object[]{nomeArtista, estiloMusical, registroOMB, telefoneArtista, enderecoArtista};
    }
}
