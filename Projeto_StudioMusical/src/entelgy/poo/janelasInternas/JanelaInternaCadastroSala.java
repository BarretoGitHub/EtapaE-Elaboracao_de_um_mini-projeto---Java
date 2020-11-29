package entelgy.poo.janelasInternas;

import entelgy.poo.listas.ListaSalas;
import entelgy.poo.classes.Sala;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class JanelaInternaCadastroSala extends JInternalFrame implements ActionListener {

    //private JPanel panelCadastroSala;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;

    private JLabel labelNomeSala;
    private JLabel labelTamanhoSala;

    //private JLabel labelQuantasHoras;
    private JLabel labelValorHora;

    private JButton buttonCadastrar;
    private JButton buttonFechar;

    private JComboBox<String> comboNomeSalas;
    private DefaultComboBoxModel<String> comboModelNomeSalas;

    private JComboBox<String> comboValoresReal;
    private DefaultComboBoxModel<String> comboModelValoresReal;

    private JComboBox<String> comboTamanhoM2;
    private DefaultComboBoxModel<String> comboModelTamanho;

    //private JComboBox<String> comboquantidade;
    //private DefaultComboBoxModel<String> comboModelQuantidade;
    private JanelaAbstrata abstrata;
    private JanelaAbstrata abstrata2;
    private JanelaAbstrata abstrata3;
    private JanelaPrincipal pai;
    private GridBagLayout layout; //responsavel pelo gerenciamento do Layout
    private GridBagConstraints constraints; //responsavel pela definição das propriedades de Layout

    private JTable tableProdutos;
    private DefaultTableModel modelProdutos;
    private JScrollPane scrollProdutos;

    private ListaSalas lista;

    public JanelaInternaCadastroSala(JanelaPrincipal pai) {
        super("Inserção de Salas", false, true, true, true);
        abstrata = new JanelaAbstrata();
        this.pai = pai;
        lista = new ListaSalas();

        criarComponentes();
        ajustarPropriedadesJanela();
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

    public void criarComboValores() {

        comboModelValoresReal = new DefaultComboBoxModel<>();
        comboModelValoresReal.addElement("150.00");
        comboModelValoresReal.addElement("300.00");
        comboModelValoresReal.addElement("600.00");
        comboModelValoresReal.addElement("1000.00");

        comboValoresReal = new JComboBox<>();
        comboValoresReal.setModel(comboModelValoresReal);
        comboValoresReal.setPreferredSize(new Dimension(106, comboValoresReal.getPreferredSize().height));

    }

    public void criarComboTamanhoM2() {

        comboModelTamanho = new DefaultComboBoxModel<>();

        comboModelTamanho.addElement("10");
        comboModelTamanho.addElement("15");
        comboModelTamanho.addElement("20");
        comboModelTamanho.addElement("35");

        comboTamanhoM2 = new JComboBox<>();
        comboTamanhoM2.setModel(comboModelTamanho);
        comboTamanhoM2.setPreferredSize(new Dimension(90, comboTamanhoM2.getPreferredSize().height));

    }

    private void definirFonte(JComponent component, String nome, int estilo, int tamanho) {
        component.setFont(new Font(nome, estilo, tamanho));
    }

    private void criarComponentes() {

        modelProdutos = new DefaultTableModel();
        modelProdutos.addColumn("NOME SALA");
        modelProdutos.addColumn("VALOR HORA");
        modelProdutos.addColumn("TAMANHO SALA");
        modelProdutos.addColumn("PRECO FINAL");

        tableProdutos = new JTable();
        tableProdutos.setModel(modelProdutos);
        tableProdutos.setFillsViewportHeight(true);
        scrollProdutos = new JScrollPane(tableProdutos);
        scrollProdutos.setPreferredSize(new Dimension(scrollProdutos.getPreferredSize().width, 130));

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

        abstrata.add(panel1, labelTamanhoSala, 0, 1, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, comboTamanhoM2, 1, 1, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel1, labelValorHora, 0, 3, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, comboValoresReal, 1, 3, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel2, buttonCadastrar, 0, 0, GridBagConstraints.EAST, 1, 1, GridBagConstraints.HORIZONTAL);
        abstrata.add(panel2, buttonFechar, 1, 0, GridBagConstraints.WEST, 0, 1, GridBagConstraints.HORIZONTAL);
        abstrata.add(panel3, scrollProdutos, 5, 5, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.HORIZONTAL);

        abstrata.add(this, panel1, 0, 0, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.EAST);
        abstrata.add(this, panel2, 0, 1, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.WEST);
        abstrata.add(this, panel3, 1, 0, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.HORIZONTAL);

    }

    private void criaLabels() {
        labelNomeSala = new JLabel("NOME SALA: ");
        criarComboNomeSalas();

        labelTamanhoSala = new JLabel("TAMANHO SALA(m²): ");
        criarComboTamanhoM2();

        labelValorHora = new JLabel("VALOR HORA: ");
        criarComboValores();

        buttonCadastrar = new JButton("Cadastrar");
        buttonCadastrar.addActionListener(this);

        buttonFechar = new JButton("Fechar");
        buttonFechar.addActionListener(this);

    }

    private void ajustarPropriedadesJanela() {
        setVisible(true);
        pack();
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
    }

    private void fechar() {
        dispose(); //fechando janela interna
    }

    private void limparCampos(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText(null);
        }
    }

    private void inserirSala() throws IOException {
        int index1 = comboNomeSalas.getSelectedIndex();
        String nomeSala = comboModelNomeSalas.getElementAt(index1);

        int index2 = comboValoresReal.getSelectedIndex();
        String valorHora = comboModelValoresReal.getElementAt(index2);

        int index4 = comboTamanhoM2.getSelectedIndex();
        String tamanhoM2 = comboModelTamanho.getElementAt(index4);

        double valor = Double.parseDouble(valorHora);
        double tamanho = Double.parseDouble(tamanhoM2);

        double flagValor = valor * tamanho;
        String precoFinal = "R$" + flagValor;

        Sala s = new Sala(nomeSala, "R$" + valorHora + " reais", tamanhoM2 + "m²", precoFinal + " reais");

        if (lista.addSala(s)) {
            modelProdutos.addRow(s.getObjetc());
            comboModelNomeSalas.removeElementAt(index1);
        }
        
        if(comboModelNomeSalas.getSize() == 0) {
            JOptionPane.showMessageDialog(null, "Não há mais salas disponíveis", "Erro", JOptionPane.ERROR_MESSAGE);
            buttonCadastrar.setEnabled(false);
        }
        
        gerarArquivoTxtJanelaInternaSala(s);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonCadastrar) {
            try {
                inserirSala();
            } catch (IOException ex) {
                Logger.getLogger(JanelaInternaCadastroSala.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            fechar();
        }
    }

    private void gerarArquivoTxtJanelaInternaSala(Sala s) throws IOException {
        
        FileWriter arq = new FileWriter("D:\\salas.txt", true);
        PrintWriter gravarArq = new PrintWriter(arq);
 
        gravarArq.printf("+--SALAS--+%n");
        gravarArq.printf(s.getNomeSala() + "," + s.getPrecoFinal() + "," + s.getTamanhoSala() + "," + s.getValorHora());
        arq.close();

    }

}
