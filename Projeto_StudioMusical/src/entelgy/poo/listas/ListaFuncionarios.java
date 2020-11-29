package entelgy.poo.listas;

import entelgy.poo.classes.Funcionario;
import java.util.ArrayList;

public class ListaFuncionarios {

    private ArrayList<Funcionario> funcionarios;

    public ListaFuncionarios() {
        funcionarios = new ArrayList<>();
    }

    public boolean addFuncionario(Funcionario funcionario) {
        return funcionarios.add(funcionario);
    }

    public int getTamanho() {
        return funcionarios.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Funcionario funcionario : funcionarios) {
            builder.append(funcionarios);
            builder.append("\n");
            builder.append("\n");
        }
        return builder.toString();
    }
}
