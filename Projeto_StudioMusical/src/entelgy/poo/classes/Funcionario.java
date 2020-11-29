package entelgy.poo.classes;

public class Funcionario {

    private String nomeSala;
    private String nomeFuncionario;
    private String telefoneFuncionario;
    private String especialidadeFuncionario; //Exemplo:técnico de som, engenheiro de mixagem ou engenheiro de gravação
    private String enderecoCompleto;

    public Funcionario() {
        //Construtor default
    }

    public Funcionario(String nomeSala, String nomeFuncionario, String telefoneFuncionario, String especialidadeFuncionario, String enderecoCompleto) {
        this.nomeSala = nomeSala.toUpperCase();
        this.nomeFuncionario = nomeFuncionario.toUpperCase();
        this.telefoneFuncionario = telefoneFuncionario;
        setEspecialidadeFuncionario(especialidadeFuncionario);
        this.enderecoCompleto = enderecoCompleto.toUpperCase();
    }

    public void setEspecialidadeFuncionario(String especialidadeFuncionario) {

        if (especialidadeFuncionario.equalsIgnoreCase("técnico de som")) {
            especialidadeFuncionario = "TÉCNICO DE SOM";
        } else if (especialidadeFuncionario.equalsIgnoreCase("engenheiro de mixagem")) {
            especialidadeFuncionario = "ENGEGENHEIRO DE MIXAGEM";
        } else {
            this.especialidadeFuncionario = "ENGENHEIRO DE GRAVAÇÃO";
        }
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public String getEspecialidadeFuncionario() {
        return especialidadeFuncionario;
    }

    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    @Override
    public String toString() {
        System.out.println("\n-----FUNCIONÁRIO-----\n");
        String flag = String.format("Nome: %s\nTelefone:%s\nEspecialidade: %s\nEndereco: %s\n", nomeFuncionario, telefoneFuncionario, especialidadeFuncionario, enderecoCompleto);

        return flag;
    }

    public Object[] getObjetcFuncionario() {
        return new Object[]{nomeSala, nomeFuncionario, telefoneFuncionario, especialidadeFuncionario, enderecoCompleto};
    }
}
