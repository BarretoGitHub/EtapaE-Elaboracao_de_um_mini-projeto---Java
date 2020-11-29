package entelgy.poo.janelasInternas;

import entelgy.poo.classes.Banda;
import entelgy.poo.listas.ListaBandas;
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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class JanelaInternaCadastroBandas extends JInternalFrame implements ActionListener {

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;

    private JLabel labelNomeEstiloMusical;

    private JLabel labelNomeBanda;
    private JTextField fieldNomeBanda;

    private JLabel labelTelefone;
    private JTextField fieldTelefone;

    private JLabel labelEndereco;
    private JTextField fieldEndereco;

    private JButton buttonInserir;
    private JButton buttonLimparCampos;
    private JButton buttonFechar;

    private JanelaAbstrata abstrata;
    private JanelaAbstrata abstrata2;
    private JanelaAbstrata abstrata3;
    private JanelaPrincipal pai;

    private JComboBox<String> comboEstilosMusicais;
    private DefaultComboBoxModel<String> comboModelEstilosMusicais;

    private GridBagLayout layout; //responsavel pelo gerenciamento do Layout
    private GridBagConstraints constraints; //responsavel pela definição das propriedades de Layout

    private JTable tableProdutos;
    private DefaultTableModel modelProdutos;
    private JScrollPane scrollProdutos;

    private ListaBandas lista;

    public JanelaInternaCadastroBandas(JanelaPrincipal pai) {
        super("Inserção de Bandas", false, true, true, true);
        abstrata = new JanelaAbstrata();
        this.pai = pai;
        lista = new ListaBandas();

        criarComponentes();

        ajustarPropriedadesJanela();
    }

    public void criarComboEstilosMusicais() {
        comboModelEstilosMusicais = new DefaultComboBoxModel<>();

        comboModelEstilosMusicais.addElement("ROCK");
        comboModelEstilosMusicais.addElement("BLUES");
        comboModelEstilosMusicais.addElement("JAZZ");
        comboModelEstilosMusicais.addElement("COUNTRY");
        comboModelEstilosMusicais.addElement("ELETRÔNICO");
        comboModelEstilosMusicais.addElement("CLASSIC/ERODITO");
        comboModelEstilosMusicais.addElement("SERTANEJO");
        comboModelEstilosMusicais.addElement("SAMBA");
        comboModelEstilosMusicais.addElement("CHORINHO");
        comboModelEstilosMusicais.addElement("PAGODE");
        comboModelEstilosMusicais.addElement("FUNK");
        comboModelEstilosMusicais.addElement("AXÉ");

        comboEstilosMusicais = new JComboBox<>();
        comboEstilosMusicais.setModel(comboModelEstilosMusicais);
        comboEstilosMusicais.setPreferredSize(new Dimension(136, comboEstilosMusicais.getPreferredSize().height));

    }

    private void definirFonte(JComponent component, String nome, int estilo, int tamanho) {
        component.setFont(new Font(nome, estilo, tamanho));
    }

    private void criarComponentes() {
        modelProdutos = new DefaultTableModel();
        modelProdutos.addColumn("NOME BANDA");
        modelProdutos.addColumn("ESTILO MUSICAL");
        modelProdutos.addColumn("TELEFONE - ARTISTA");
        modelProdutos.addColumn("ENDERECO - ARTISTA");

        tableProdutos = new JTable();
        tableProdutos.setModel(modelProdutos);
        tableProdutos.setFillsViewportHeight(true);
        scrollProdutos = new JScrollPane(tableProdutos);
        scrollProdutos.setPreferredSize(new Dimension(scrollProdutos.getPreferredSize().width, 117));

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

        definirFonte(labelNomeBanda, "arial", Font.PLAIN, 13);
        definirFonte(fieldNomeBanda, "arial", Font.PLAIN, 13);
        definirFonte(labelNomeEstiloMusical, "arial", Font.PLAIN, 13);
        definirFonte(labelTelefone, "arial", Font.PLAIN, 13);
        definirFonte(labelEndereco, "arial", Font.PLAIN, 13);
        definirFonte(fieldEndereco, "arial", Font.PLAIN, 13);

        abstrata.add(panel1, labelNomeBanda, 0, 0, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, fieldNomeBanda, 1, 0, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel1, labelNomeEstiloMusical, 0, 1, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, comboEstilosMusicais, 1, 1, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel1, labelTelefone, 0, 2, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, fieldTelefone, 1, 2, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel1, labelEndereco, 0, 3, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, fieldEndereco, 1, 3, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel2, buttonInserir, 0, 0, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel2, buttonFechar, 1, 0, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel2, buttonLimparCampos, 3, 0, GridBagConstraints.WEST, 0, 1, GridBagConstraints.NONE);
        abstrata.add(panel3, scrollProdutos, 5, 5, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.NONE);

        abstrata.add(this, panel1, 0, 0, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.EAST);
        abstrata.add(this, panel2, 0, 1, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.WEST);
        abstrata.add(this, panel3, 1, 0, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.HORIZONTAL);

    }

    private void criaLabels() {
        labelNomeBanda = new JLabel("NOME BANDA: ");
        fieldNomeBanda = new JTextField(12);

        labelNomeEstiloMusical = new JLabel("ESTILO MUSICAL: ");
        criarComboEstilosMusicais();

        labelTelefone = new JLabel("TELEFONE: ");
        fieldTelefone = new JTextField(12);

        labelEndereco = new JLabel("ENDERECO: ");
        fieldEndereco = new JTextField(12);

        buttonInserir = new JButton("Inserir");
        buttonInserir.addActionListener(this);

        buttonLimparCampos = new JButton("Limpar Campos");
        buttonLimparCampos.addActionListener(this);

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
            fieldNomeBanda.requestFocusInWindow();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonInserir) {
            try {
                inserirBanda();
            } catch (IOException ex) {
                Logger.getLogger(JanelaInternaCadastroBandas.class.getName()).log(Level.SEVERE, null, ex);
            }
            limparCampos(fieldNomeBanda, fieldTelefone, fieldEndereco);

        } else if (e.getSource() == buttonLimparCampos) {
            limparCampos(fieldNomeBanda, fieldTelefone, fieldEndereco);
        } else {
            fechar();
        }
    }

    private void inserirBanda() throws IOException {
        String nomeBanda = fieldNomeBanda.getText();

        int index = comboEstilosMusicais.getSelectedIndex();
        String estiloMusical = comboModelEstilosMusicais.getElementAt(index);
        String telefone = fieldTelefone.getText();
        String endereco = fieldEndereco.getText();

        Banda b = new Banda(nomeBanda, estiloMusical, telefone, endereco);
        
        gerarArquivoTxtJanelaInternaBandas(b);

        if (lista.addBandas(b)) {
            modelProdutos.addRow(b.getObjetcBanda());
            limparCampos(fieldNomeBanda, fieldTelefone, fieldEndereco);
        }
    }

    //Desenvolver
    private void validarDadosBandas() {
    }

    private void gerarArquivoTxtJanelaInternaBandas(Banda b) throws IOException {
        
        FileWriter arq = new FileWriter("D:\\bandas.txt", true);
        PrintWriter gravarArq = new PrintWriter(arq);
 
        gravarArq.printf("+--BANDAS--+%n");
        gravarArq.printf(b.getNomeBanda() + "," + b.getEstiloMusicalBanda() + "," + b.getTelefoneBanda() + "," + b.getEnderecoBanda());
        arq.close();
    }

}
