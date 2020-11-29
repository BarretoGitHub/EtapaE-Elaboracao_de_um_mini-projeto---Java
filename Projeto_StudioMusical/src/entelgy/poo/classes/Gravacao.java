package entelgy.poo.classes;

public class Gravacao {

    private String nomeSala;
    private String diaSemana;
    private String periodoDia;
    private String quantidadeHoras;

    public Gravacao() {
        //construtor default
    }

    public Gravacao(String nomeSala, String diaSemana, String periodoDia, String quantidadeHoras) {
        this.nomeSala = nomeSala;
        this.diaSemana = diaSemana;
        this.periodoDia = periodoDia;
        this.quantidadeHoras = quantidadeHoras;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public String getPeriodoDia() {
        return periodoDia;
    }

    public String getQuantidadeHoras() {
        return quantidadeHoras;
    }

    @Override
    public String toString() {
        return "Gravacao{" + "nomeSala=" + nomeSala + ", diaSemana=" + diaSemana + ", periodoDia=" + periodoDia + ", quantidadeHoras=" + quantidadeHoras + '}';
    }

    public Object[] getObjetcReservaGravacao() {
        return new Object[]{nomeSala, diaSemana, periodoDia, quantidadeHoras};
    }
}
