package entelgy.poo.janelasInternas;

import entelgy.poo.classes.Artista;
import entelgy.poo.listas.ListaArtistas;
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

public class JanelaInternaCadastroArtistas extends JInternalFrame implements ActionListener {

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;

    private JLabel labelNomeArtista;
    private JTextField fieldNomeArtista;

    private JLabel labelNomeEstiloMusical;

    private JLabel labelRegistorOMB;
    private JTextField fieldRegistorOMB;

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

    private ListaArtistas artista;

    public JanelaInternaCadastroArtistas(JanelaPrincipal pai) {
        super("Inserção de Artistas", false, true, true, true);
        abstrata = new JanelaAbstrata();
        this.pai = pai;

        artista = new ListaArtistas();

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
        comboModelEstilosMusicais.addElement("AXÉ");
        comboModelEstilosMusicais.addElement("SAMBA");
        comboModelEstilosMusicais.addElement("CHORINHO");
        comboModelEstilosMusicais.addElement("PAGODE");
        comboModelEstilosMusicais.addElement("FUNK");

        comboEstilosMusicais = new JComboBox<>();
        comboEstilosMusicais.setModel(comboModelEstilosMusicais);
        comboEstilosMusicais.setPreferredSize(new Dimension(154, comboEstilosMusicais.getPreferredSize().height));
    }

    private void definirFonte(JComponent component, String nome, int estilo, int tamanho) {
        component.setFont(new Font(nome, estilo, tamanho));
    }

    private void criarComponentes() {

        modelProdutos = new DefaultTableModel();
        modelProdutos.addColumn("NOME ARTISTA");
        modelProdutos.addColumn("ESTILO MUSICAL");
        modelProdutos.addColumn("REGISTRO OMB");
        modelProdutos.addColumn("TELEFONE - ARTISTA");
        modelProdutos.addColumn("ENDERECO - ARTISTA");

        tableProdutos = new JTable();
        tableProdutos.setModel(modelProdutos);
        tableProdutos.setFillsViewportHeight(true);
        scrollProdutos = new JScrollPane(tableProdutos);
        scrollProdutos.setPreferredSize(new Dimension(scrollProdutos.getPreferredSize().width, 155));

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

        definirFonte(labelNomeArtista, "arial", Font.PLAIN, 12);
        definirFonte(labelNomeEstiloMusical, "arial", Font.PLAIN, 12);
        definirFonte(labelRegistorOMB, "arial", Font.PLAIN, 12);
        definirFonte(labelTelefone, "arial", Font.PLAIN, 12);
        definirFonte(labelEndereco, "arial", Font.PLAIN, 12);

        abstrata.add(panel1, labelNomeArtista, 0, 0, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, fieldNomeArtista, 1, 0, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel1, labelNomeEstiloMusical, 0, 1, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, comboEstilosMusicais, 1, 1, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel1, labelRegistorOMB, 0, 2, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, fieldRegistorOMB, 1, 2, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel1, labelTelefone, 0, 3, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, fieldTelefone, 1, 3, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel1, labelEndereco, 0, 4, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, fieldEndereco, 1, 4, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel2, buttonInserir, 0, 0, GridBagConstraints.EAST, 2, 1, GridBagConstraints.HORIZONTAL);
        abstrata.add(panel2, buttonLimparCampos, 2, 0, GridBagConstraints.WEST, 2, 1, GridBagConstraints.HORIZONTAL);
        abstrata.add(panel2, buttonFechar, 4, 0, GridBagConstraints.CENTER, 2, 1, GridBagConstraints.HORIZONTAL);
        abstrata.add(panel3, scrollProdutos, 4, 4, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.HORIZONTAL);

        abstrata.add(this, panel1, 0, 0, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.EAST);
        abstrata.add(this, panel2, 0, 1, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.WEST);
        abstrata.add(this, panel3, 1, 0, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.HORIZONTAL);
        //adicionarComponentes();
    }

    private void criaLabels() {
        labelNomeArtista = new JLabel("NOME DO ARTISTA: ");
        fieldNomeArtista = new JTextField(14);

        labelNomeEstiloMusical = new JLabel("ESTILO MUSICAL: ");
        criarComboEstilosMusicais();

        labelRegistorOMB = new JLabel("REGISTRO OMB: ");
        fieldRegistorOMB = new JTextField(14);

        labelTelefone = new JLabel("TELEFONE: ");
        fieldTelefone = new JTextField(14);

        labelEndereco = new JLabel("ENDERECO: ");
        fieldEndereco = new JTextField(14);

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
            fieldNomeArtista.requestFocusInWindow();
        }
    }

    private void inserirArtista() throws IOException {
        String nomeArtista = fieldNomeArtista.getText();

        int index = comboEstilosMusicais.getSelectedIndex();
        String estiloMusicalArtista = comboModelEstilosMusicais.getElementAt(index);

        String RegistorOMB = fieldRegistorOMB.getText();
        String Telefone = fieldTelefone.getText();
        String endereco = fieldEndereco.getText();

        Artista a = new Artista(nomeArtista, estiloMusicalArtista, RegistorOMB, Telefone, endereco);
        gerarArquivoTxtJanelaInternaArtistas(a);
        if (artista.addArtista(a)) {
            modelProdutos.addRow(a.getObjetcArtista());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonInserir) {
            try {
                inserirArtista();
            } catch (IOException ex) {
                Logger.getLogger(JanelaInternaCadastroArtistas.class.getName()).log(Level.SEVERE, null, ex);
            }
            limparCampos(fieldNomeArtista, fieldRegistorOMB, fieldTelefone, fieldEndereco);

        } else if (e.getSource() == buttonLimparCampos) {
            limparCampos(fieldNomeArtista, fieldRegistorOMB, fieldTelefone, fieldEndereco);
        } else {
            fechar();
        }
    }
    
    //Desenvolver
    private void validarDadosArtistas() {
    }

    private void gerarArquivoTxtJanelaInternaArtistas(Artista a) throws IOException {
        
        FileWriter arq = new FileWriter("D:\\artistas.txt", true);
        PrintWriter gravarArq = new PrintWriter(arq);
 
        gravarArq.printf("+--ARTISTAS--+%n");
        
        gravarArq.printf(a.getNomeArtista() + "," + a.getEstiloMusical() + "," + a.getTelefoneArtista() + "," + a.getEnderecoArtista() + "," + 
                a.getRegistroOMB());
 
        arq.close();
    }
}
