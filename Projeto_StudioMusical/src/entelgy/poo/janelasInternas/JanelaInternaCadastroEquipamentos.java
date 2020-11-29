package entelgy.poo.janelasInternas;

import entelgy.poo.classes.Equipamento;
import entelgy.poo.listas.ListaEquipamentos;
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
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class JanelaInternaCadastroEquipamentos extends JInternalFrame implements ActionListener {

    //private JPanel panelCadastroEquipamento;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;

    private JLabel labelNomeSala;
    private JLabel labelNomeEquipamento;
    private JLabel labelQuantidadeEquipamentos;
    private JLabel labelValoresEquipamentos;
    private JButton buttonInserir;
    private JButton buttonFechar;
    private JanelaAbstrata abstrata;
    private JanelaAbstrata abstrata2;
    private JanelaAbstrata abstrata3;
    private JanelaPrincipal pai;

    private JComboBox<String> comboNomeSalas;
    private DefaultComboBoxModel<String> comboModelNomeSalas;

    private JComboBox<String> comboEquipamentos;
    private DefaultComboBoxModel<String> comboModelEquipamentos;

    private JComboBox<String> comboquantidade;
    private DefaultComboBoxModel<String> comboModelQuantidade;

    private JComboBox<String> comboValoresEquipamentos;
    private DefaultComboBoxModel<String> comboModelValoresEquipamentos;

    private GridBagLayout layout; //responsavel pelo gerenciamento do Layout
    private GridBagConstraints constraints; //responsavel pela definição das propriedades de Layout

    private JTable tableProdutos;
    private DefaultTableModel modelProdutos;
    private JScrollPane scrollProdutos;

    private ListaEquipamentos lista;

    public JanelaInternaCadastroEquipamentos(JanelaPrincipal pai) {
        super("Inserção de Equipamentos", false, true, true, true);
        abstrata = new JanelaAbstrata();
        this.pai = pai;
        lista = new ListaEquipamentos();

        criarComponentes();
        ajustarPropriedadesJanela();
    }

    public void criarValoresEquipamentos() {
        comboModelValoresEquipamentos = new DefaultComboBoxModel<>();

        comboModelValoresEquipamentos.addElement("R$ 100.00");
        comboModelValoresEquipamentos.addElement("R$ 150.00 ");
        comboModelValoresEquipamentos.addElement("R$ 300.00");

        comboValoresEquipamentos = new JComboBox<>();
        comboValoresEquipamentos.setModel(comboModelValoresEquipamentos);
        comboValoresEquipamentos.setPreferredSize(new Dimension(200, comboValoresEquipamentos.getPreferredSize().height));

    }

    public void criarComboEquipamentos() {
        comboModelEquipamentos = new DefaultComboBoxModel<>();

        comboModelEquipamentos.addElement("Amplificador");
        comboModelEquipamentos.addElement("Mesa de Som");
        comboModelEquipamentos.addElement("Microfone");
        comboModelEquipamentos.addElement("Contra - Baixo");
        comboModelEquipamentos.addElement("Bateria");
        comboModelEquipamentos.addElement("Piano");
        comboModelEquipamentos.addElement("Clarinet");
        comboModelEquipamentos.addElement("Violino");
        comboModelEquipamentos.addElement("Viola");
        comboModelEquipamentos.addElement("Violão Chiello");
        comboModelEquipamentos.addElement("Oboé");
        comboModelEquipamentos.addElement("Sax-Fone");
        comboModelEquipamentos.addElement("Trompete");
        comboModelEquipamentos.addElement("Flauta Transversal");
        comboModelEquipamentos.addElement("Pícolo");
        comboModelEquipamentos.addElement("Trombone");
        comboModelEquipamentos.addElement("Pandeiro");
        comboModelEquipamentos.addElement("Triângulo");
        comboModelEquipamentos.addElement("Violão - Naylon");
        comboModelEquipamentos.addElement("Violão - Aço");
        comboModelEquipamentos.addElement("Guitarra - Lespaul");
        comboModelEquipamentos.addElement("Guitarra - Semi-Acústica");
        comboModelEquipamentos.addElement("Guitarra - StratusCaster");
        comboModelEquipamentos.addElement("Guitarra - TeleCaster");

        comboEquipamentos = new JComboBox<>();
        comboEquipamentos.setModel(comboModelEquipamentos);
        comboEquipamentos.setPreferredSize(new Dimension(200, comboEquipamentos.getPreferredSize().height));

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
        comboNomeSalas.setPreferredSize(new Dimension(100, comboNomeSalas.getPreferredSize().height));
    }

    private void definirFonte(JComponent component, String nome, int estilo, int tamanho) {
        component.setFont(new Font(nome, estilo, tamanho));
    }

    private void criarComponentes() {

        modelProdutos = new DefaultTableModel();
        modelProdutos.addColumn("NOME EQUIPAMENTO");
        modelProdutos.addColumn("TIPO EQUIPAMENTO");
        modelProdutos.addColumn("VALOR - LOCAÇÃO");

        tableProdutos = new JTable();
        tableProdutos.setModel(modelProdutos);
        tableProdutos.setFillsViewportHeight(true);
        scrollProdutos = new JScrollPane(tableProdutos);
        scrollProdutos.setPreferredSize(new Dimension(scrollProdutos.getPreferredSize().width, 95));

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

        definirFonte(labelNomeSala, "arial", Font.PLAIN, 13);
        definirFonte(comboNomeSalas, "arial", Font.PLAIN, 13);
        definirFonte(labelNomeEquipamento, "arial", Font.PLAIN, 13);
        definirFonte(comboEquipamentos, "arial", Font.PLAIN, 13);
        definirFonte(labelValoresEquipamentos, "arial", Font.PLAIN, 13);
        definirFonte(comboValoresEquipamentos, "arial", Font.PLAIN, 13);

        // adicionarComponentes();
        abstrata.add(panel1, labelNomeSala, 0, 0, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, comboNomeSalas, 1, 0, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel1, labelNomeEquipamento, 0, 1, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, comboEquipamentos, 1, 1, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel1, labelValoresEquipamentos, 0, 3, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, comboValoresEquipamentos, 1, 3, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel2, buttonInserir, 0, 0, GridBagConstraints.EAST, 1, 1, GridBagConstraints.HORIZONTAL);
        abstrata.add(panel2, buttonFechar, 1, 0, GridBagConstraints.WEST, 0, 1, GridBagConstraints.HORIZONTAL);
        abstrata.add(panel3, scrollProdutos, 5, 5, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.HORIZONTAL);

        abstrata.add(this, panel1, 0, 0, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.EAST);
        abstrata.add(this, panel2, 0, 1, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.WEST);
        abstrata.add(this, panel3, 1, 0, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.HORIZONTAL);
    }

    private void criaLabels() {
        labelNomeSala = new JLabel("SELECIONE A SALA: ");
        criarComboNomeSalas();

        labelNomeEquipamento = new JLabel("SELECIONE O EQUIPAMENTO: ");
        criarComboEquipamentos();

        labelValoresEquipamentos = new JLabel("VALORES EQUIPAMENTOS: ");
        criarValoresEquipamentos();

        buttonInserir = new JButton("Inserir");
        buttonInserir.addActionListener(this);

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

    private void inserirEquipamento() throws IOException {

        int index1 = comboNomeSalas.getSelectedIndex();
        String nomeSala = comboModelNomeSalas.getElementAt(index1);

        int index2 = comboEquipamentos.getSelectedIndex();
        String nomeEquipamento = comboModelEquipamentos.getElementAt(index2);

        int index4 = comboValoresEquipamentos.getSelectedIndex();
        String valorEquipamento = comboModelValoresEquipamentos.getElementAt(index4);

        Equipamento e = new Equipamento(nomeSala, nomeEquipamento, valorEquipamento);
        
        gerarArquivoTxtJanelaInternaEquipamento(e);
        
        if (lista.addSala(e)) {
            modelProdutos.addRow(e.getObjetcEquipamento());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonInserir) {
            try {
                inserirEquipamento();
            } catch (IOException ex) {
                Logger.getLogger(JanelaInternaCadastroEquipamentos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            fechar();
        }
    }

    private void gerarArquivoTxtJanelaInternaEquipamento(Equipamento e) throws IOException {
        
        FileWriter arq = new FileWriter("D:\\equipamentos.txt", true);
        PrintWriter gravarArq = new PrintWriter(arq);
 
        gravarArq.printf("+--EQUIPAMENTOS--+%n");
        
        gravarArq.printf(e.getNomeEquipamento() + "," + e.getNomeSala() + "," + e.getQuantidade() + "," + e.getTipoEquipamento() + "," +
                e.getValorCompra());
        arq.close();
    }
}
