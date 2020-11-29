package entelgy.poo.classes;

public class Equipamento {

    private String nomeSala;
    private String nomeEquipamento;
    private String quantidade;
    private String valorCompra;

    public Equipamento() {
    }

    public Equipamento(String nomeSala, String nomeEquipamento, String valorCompra) {
        this.nomeSala = nomeSala;
        this.nomeEquipamento = nomeEquipamento;
        this.quantidade = quantidade;
        this.valorCompra = valorCompra;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public String getTipoEquipamento() {
        return nomeEquipamento;
    }

    public String getValorCompra() {
        return valorCompra;
    }

    public Object[] getObjetcEquipamento() {
        return new Object[]{nomeSala, nomeEquipamento, valorCompra};
    }
}
