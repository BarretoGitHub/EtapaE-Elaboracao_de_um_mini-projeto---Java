package entelgy.poo.janelasInternas;

import entelgy.poo.classes.Funcionario;
import entelgy.poo.listas.ListaFuncionarios;
import entelgy.poo.view.principal.JanelaAbstrata;
import entelgy.poo.view.principal.JanelaPrincipal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class JanelaInternaFuncionario extends JInternalFrame implements ActionListener {

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;

    private JLabel labelNomeSala;
    private JLabel labelNomeFuncionario;
    private JTextField fieldNomeFuncionario;

    private JLabel labelTelefoneFuncionario;
    private JTextField fieldTelefoneFuncionario;

    private JLabel labelEspecialidadeFuncionario;
    private JLabel labelEnderecoFuncionario;
    private JTextField fieldEnderecoFuncionario;

    private JComboBox<String> comboNomeSalas;
    private DefaultComboBoxModel<String> comboModelNomeSalas;

    private JComboBox<String> comboEspecialidade;
    private DefaultComboBoxModel<String> comboModelEspecialidade;

    private JButton buttonCadastrar;
    private JButton buttonLimpar;
    private JButton buttonFechar;

    private JanelaAbstrata abstrata;
    private JanelaAbstrata abstrata2;
    private JanelaAbstrata abstrata3;
    private JanelaPrincipal pai;
    private GridBagLayout layout; //responsavel pelo gerenciamento do Layout
    private GridBagConstraints constraints; //responsavel pela definição das propriedades de Layout

    private JTable tableProdutos;
    private DefaultTableModel modelProdutos;
    private JScrollPane scrollProdutos;

    private ListaFuncionarios lista;

    public JanelaInternaFuncionario(JanelaPrincipal pai) {
        super("Inserção de Funcionários", false, true, true, true);
        abstrata = new JanelaAbstrata();
        this.pai = pai;
        lista = new ListaFuncionarios();

        criarComponentes();
        ajustarPropriedadesJanela();
    }

    private void definirFonte(JComponent component, String nome, int estilo, int tamanho) {
        component.setFont(new Font(nome, estilo, tamanho));
    }

    public void criarComboNomeSalas() {
        comboModelNomeSalas = new DefaultComboBoxModel<>();
        comboModelNomeSalas.addElement("Sala A");
        comboModelNomeSalas.addElement("Sala B");
        comboModelNomeSalas.addElement("Sala C");
        comboModelNomeSalas.addElement("Sala D");
        comboModelNomeSalas.addElement("Sala E");
        comboModelNomeSalas.addElement("Sala F");
        comboModelNomeSalas.addElement("Sala G");

        comboNomeSalas = new JComboBox<>();
        comboNomeSalas.setModel(comboModelNomeSalas);
        comboNomeSalas.setPreferredSize(new Dimension(90, comboNomeSalas.getPreferredSize().height));

    }

    private void criarComboEspecialidade() {
        comboModelEspecialidade = new DefaultComboBoxModel<>();
        comboModelEspecialidade.addElement("TÉCNICO DE SOM");
        comboModelEspecialidade.addElement("ENGENHEIRO DE MIXAGEM");
        comboModelEspecialidade.addElement("ENGENHEIRO DE GRAVAÇÃO");

        comboEspecialidade = new JComboBox<>();
        comboEspecialidade.setModel(comboModelEspecialidade);
        comboEspecialidade.setPreferredSize(new Dimension(200, comboEspecialidade.getPreferredSize().height));

    }

    private void criarComponentes() {

        modelProdutos = new DefaultTableModel();
        modelProdutos.addColumn("NOME SALA");
        modelProdutos.addColumn("NOME FUNCIONÁRIO");
        modelProdutos.addColumn("ESPECIALIDADE");
        modelProdutos.addColumn("TELEFONE");
        modelProdutos.addColumn("ENDERECO");

        tableProdutos = new JTable();
        tableProdutos.setModel(modelProdutos);
        tableProdutos.setFillsViewportHeight(true);
        scrollProdutos = new JScrollPane(tableProdutos);
        scrollProdutos.setPreferredSize(new Dimension(scrollProdutos.getPreferredSize().width, 160));

        layout = new GridBagLayout(); //construtor default
        constraints = new GridBagConstraints();
        setLayout(layout); //Especificamos o gerenciador de leiaute

        //adiciona os componentes do layout
        panel1 = new JPanel(layout);//Gerenciador de leiaute default: FlowLayout
        panel2 = new JPanel(layout);//Gerenciador de leiaute default: FlowLayout
        panel3 = new JPanel(layout);//Gerenciador de leiaute default: FlowLayout

        Border bordaComCor = BorderFactory.createLineBorder(Color.BLACK);

        panel1.setBorder(bordaComCor);
        panel2.setBorder(bordaComCor);
        panel3.setBorder(bordaComCor);

        criaLabels();

        abstrata.add(panel1, labelNomeSala, 0, 0, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, comboNomeSalas, 1, 0, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel1, labelNomeFuncionario, 0, 1, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, fieldNomeFuncionario, 1, 1, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel1, labelEspecialidadeFuncionario, 0, 2, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, comboEspecialidade, 1, 2, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel1, labelTelefoneFuncionario, 0, 3, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, fieldTelefoneFuncionario, 1, 3, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel1, labelEnderecoFuncionario, 0, 4, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, fieldEnderecoFuncionario, 1, 4, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel2, buttonCadastrar, 0, 0, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel2, buttonFechar, 1, 0, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel2, buttonLimpar, 3, 0, GridBagConstraints.WEST, 0, 1, GridBagConstraints.NONE);
        abstrata.add(panel3, scrollProdutos, 5, 5, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.NONE);

        abstrata.add(this, panel1, 0, 0, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.EAST);
        abstrata.add(this, panel2, 0, 1, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.WEST);
        abstrata.add(this, panel3, 1, 0, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.HORIZONTAL);

    }

    public void criaLabels() {
        labelNomeSala = new JLabel("NOME SALA: ");
        criarComboNomeSalas();

        labelNomeFuncionario = new JLabel("NOME: ");
        fieldNomeFuncionario = new JTextField(18);

        labelEspecialidadeFuncionario = new JLabel("ESPECIALIDADE: ");
        criarComboEspecialidade();

        labelTelefoneFuncionario = new JLabel("TELEFONE: ");
        fieldTelefoneFuncionario = new JTextField(18);

        labelEnderecoFuncionario = new JLabel("ENDEREÇO: ");
        fieldEnderecoFuncionario = new JTextField(18);

        buttonCadastrar = new JButton("Cadastrar");
        buttonCadastrar.addActionListener(this);

        buttonLimpar = new JButton("Limpar");
        buttonLimpar.addActionListener(this);

        buttonFechar = new JButton("Fechar");
        buttonFechar.addActionListener(this);
    }

    private void fechar() {
        dispose(); //fechando janela interna
    }

    private void limparCampos(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText(null);
            fieldNomeFuncionario.requestFocusInWindow();
        }
    }

    private void ajustarPropriedadesJanela() {
        setVisible(true);
        pack();
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
    }

    private void inserirFuncionario() throws IOException {
        int index1 = comboNomeSalas.getSelectedIndex();
        String nomeSala = comboModelNomeSalas.getElementAt(index1);

        int index2 = comboEspecialidade.getSelectedIndex();
        String especialidadeFuncionario = comboModelEspecialidade.getElementAt(index2);

        String nomeFuncionario = fieldNomeFuncionario.getText();
        String telefone = fieldTelefoneFuncionario.getText();
        String endereco = fieldEnderecoFuncionario.getText();

        Funcionario f = new Funcionario(nomeSala, nomeFuncionario, especialidadeFuncionario, telefone, endereco);
        
        gerarArquivoTxtJanelaInternaFuncionario(f);
        
        if (lista.addFuncionario(f)) {
            modelProdutos.addRow(f.getObjetcFuncionario());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonCadastrar) {
            try {
                inserirFuncionario();
            } catch (IOException ex) {
                Logger.getLogger(JanelaInternaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
            limparCampos(fieldNomeFuncionario, fieldTelefoneFuncionario, fieldEnderecoFuncionario);

        } else if (e.getSource() == buttonLimpar) {
            limparCampos(fieldNomeFuncionario, fieldTelefoneFuncionario, fieldEnderecoFuncionario);
        } else {
            fechar();
        }
    }

    //Desenvolver
    private void validarDadosFuncionario() {
    }

    private void gerarArquivoTxtJanelaInternaFuncionario(Funcionario f) throws IOException {
        FileWriter arq = new FileWriter("D:\\funcionario.txt", true);
        PrintWriter gravarArq = new PrintWriter(arq);
 
        gravarArq.printf("+--FUNCIONÁRIOS--+%n");
        
        gravarArq.printf(f.getNomeFuncionario() + "," + f.getEnderecoCompleto() + "," + f.getEspecialidadeFuncionario() + "," + f.getNomeSala() + "," +
                f.getTelefoneFuncionario());
 
        arq.close();
    }
}
