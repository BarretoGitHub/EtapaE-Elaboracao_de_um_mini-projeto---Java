package entelgy.poo.janelasInternas;

import entelgy.poo.classes.Gravacao;
import entelgy.poo.listas.ListaGravacoes;
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
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.Border;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JanelaCadastroReservaGravacoes extends JInternalFrame implements ActionListener {

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;

    private JLabel labelSala;
    private JLabel labelDiaSemana;
    private JLabel labelPeriodoDia;
    private JLabel labelQuantidadeHoras;

    //Para selecionar um dia da semana
    private JComboBox<String> comboDias;
    private DefaultComboBoxModel<String> comboModelDias;

    private JComboBox<String> comboNomeSalas;
    private DefaultComboBoxModel<String> comboModelNomeSalas;

    private JComboBox<String> comboPeriodoDia;
    private DefaultComboBoxModel<String> comboModelPeriodoDia;

    private JComboBox<String> comboQuantidadeHoras;
    private DefaultComboBoxModel<String> comboModelQuantidadeHoras;

    private JButton buttonAtribuir;
    private JButton buttonFechar;

    private JanelaAbstrata abstrata;
    private JanelaAbstrata abstrata2;
    private JanelaPrincipal pai;

    private GridBagLayout layout; //responsavel pelo gerenciamento do Layout
    private GridBagConstraints constraints; //responsavel pela definição das propriedades de Layout

    private JTable tableProdutos;
    private DefaultTableModel modelProdutos;
    private JScrollPane scrollProdutos;

    private ListaGravacoes lista;

    public JanelaCadastroReservaGravacoes(JanelaPrincipal pai) {
        super("Organização de horários", false, true, true, true);
        abstrata = new JanelaAbstrata();
        this.pai = pai;
        lista = new ListaGravacoes();

        criaComponentes();
        ajustaPropriedadesJanela();
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
        comboModelNomeSalas.addElement("Sala H");
        comboModelNomeSalas.addElement("Sala I");
        comboModelNomeSalas.addElement("Sala J");
        comboModelNomeSalas.addElement("Sala K");
        comboModelNomeSalas.addElement("Sala L");
        comboModelNomeSalas.addElement("Sala M");
        comboModelNomeSalas.addElement("Sala N");
        comboModelNomeSalas.addElement("Sala O");
        comboModelNomeSalas.addElement("Sala P");
        comboModelNomeSalas.addElement("Sala R");
        comboModelNomeSalas.addElement("Sala S");

        comboNomeSalas = new JComboBox<>();
        comboNomeSalas.setModel(comboModelNomeSalas);
        comboNomeSalas.setPreferredSize(new Dimension(100, comboNomeSalas.getPreferredSize().height));

    }

    public void criarComboPeriodoDia() {
        comboModelPeriodoDia = new DefaultComboBoxModel<>();
        comboModelPeriodoDia.addElement("Manhã - 06:00 AM ás 12:00 PM");
        comboModelPeriodoDia.addElement("Tarde - 12:00 PM  ás 06:00 PM");
        comboModelPeriodoDia.addElement("Noite - 06:00 PM ás 00:00 AM");
        comboModelPeriodoDia.addElement("Madrugada - 00:00 AM ás 06:00 AM");

        comboPeriodoDia = new JComboBox<>();
        comboPeriodoDia.setModel(comboModelPeriodoDia);
        comboPeriodoDia.setPreferredSize(new Dimension(200, comboPeriodoDia.getPreferredSize().height));

    }

    public void criarComboQuantidadeHorasLocacao() {
        comboModelQuantidadeHoras = new DefaultComboBoxModel<>();
        comboModelQuantidadeHoras.addElement("6 HORAS");
        comboModelQuantidadeHoras.addElement("8 HORAS");
        comboModelQuantidadeHoras.addElement("10 HORAS");
        comboModelQuantidadeHoras.addElement("12 HORAS");
        comboModelQuantidadeHoras.addElement("24 HORAS");

        comboQuantidadeHoras = new JComboBox<>();
        comboQuantidadeHoras.setModel(comboModelQuantidadeHoras);
        comboQuantidadeHoras.setPreferredSize(new Dimension(100, comboQuantidadeHoras.getPreferredSize().height));
    }

    private void definirFonte(JComponent component, String nome, int estilo, int tamanho) {
        component.setFont(new Font(nome, estilo, tamanho));
    }

    private void criaComponentes() {
        modelProdutos = new DefaultTableModel();
        modelProdutos.addColumn("NOME SALA");
        modelProdutos.addColumn("DIA");
        modelProdutos.addColumn("PERÍODO");
        modelProdutos.addColumn("QUANTIDADE DE HORAS");

        tableProdutos = new JTable();
        tableProdutos.setModel(modelProdutos);
        tableProdutos.setFillsViewportHeight(true);
        scrollProdutos = new JScrollPane(tableProdutos);
        scrollProdutos.setPreferredSize(new Dimension(scrollProdutos.getPreferredSize().width, 125));

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
        criaBotoes();

        definirFonte(labelSala, "arial", Font.PLAIN, 12);
        definirFonte(comboNomeSalas, "arial", Font.PLAIN, 12);
        definirFonte(labelDiaSemana, "arial", Font.PLAIN, 12);
        definirFonte(comboDias, "arial", Font.PLAIN, 12);
        definirFonte(labelPeriodoDia, "arial", Font.PLAIN, 12);
        definirFonte(comboPeriodoDia, "arial", Font.PLAIN, 12);
        definirFonte(labelQuantidadeHoras, "arial", Font.PLAIN, 12);
        definirFonte(comboQuantidadeHoras, "arial", Font.PLAIN, 12);

        abstrata.add(panel1, labelSala, 0, 0, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, comboNomeSalas, 1, 0, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel1, labelDiaSemana, 0, 1, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, comboDias, 1, 1, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel1, labelPeriodoDia, 0, 2, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, comboPeriodoDia, 1, 2, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel1, labelQuantidadeHoras, 0, 3, GridBagConstraints.EAST, 1, 1, GridBagConstraints.NONE);
        abstrata.add(panel1, comboQuantidadeHoras, 1, 3, GridBagConstraints.WEST, 1, 1, GridBagConstraints.NONE);

        abstrata.add(panel2, buttonAtribuir, 0, 0, GridBagConstraints.EAST, 1, 1, GridBagConstraints.HORIZONTAL);
        abstrata.add(panel2, buttonFechar, 1, 0, GridBagConstraints.WEST, 0, 1, GridBagConstraints.HORIZONTAL);
        abstrata.add(panel3, scrollProdutos, 5, 5, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.HORIZONTAL);

        abstrata.add(this, panel1, 0, 0, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.EAST);
        abstrata.add(this, panel2, 0, 1, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.WEST);
        abstrata.add(this, panel3, 1, 0, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.HORIZONTAL);

    }

    private void criaLabels() {
        labelSala = new JLabel("SELECIONE UMA SALA:");
        criarComboNomeSalas();

        labelDiaSemana = new JLabel("SELECIONE UM DIA DA SEMANA:");
        criaComboDias();

        labelPeriodoDia = new JLabel("SELECIONE UM PERIODO:");
        criarComboPeriodoDia();

        labelQuantidadeHoras = new JLabel("DURAÇÃO DE LOCAÇÃO:");
        criarComboQuantidadeHorasLocacao();
    }

    private void criaComboDias() {

        comboModelDias = new DefaultComboBoxModel<>();

        comboModelDias.addElement(DayOfWeek.MONDAY.getDisplayName(TextStyle.FULL, Locale.getDefault()));
        comboModelDias.addElement(DayOfWeek.TUESDAY.getDisplayName(TextStyle.FULL, Locale.getDefault()));
        comboModelDias.addElement(DayOfWeek.WEDNESDAY.getDisplayName(TextStyle.FULL, Locale.getDefault()));
        comboModelDias.addElement(DayOfWeek.THURSDAY.getDisplayName(TextStyle.FULL, Locale.getDefault()));
        comboModelDias.addElement(DayOfWeek.FRIDAY.getDisplayName(TextStyle.FULL, Locale.getDefault()));
        comboModelDias.addElement(DayOfWeek.SATURDAY.getDisplayName(TextStyle.FULL, Locale.getDefault()));
        comboModelDias.addElement(DayOfWeek.SUNDAY.getDisplayName(TextStyle.FULL, Locale.getDefault()));

        comboDias = new JComboBox<>();
        comboDias.setModel(comboModelDias);
        comboDias.setPreferredSize(new Dimension(200, comboDias.getPreferredSize().height));

    }

    private void criaBotoes() {
        buttonAtribuir = new JButton("Atribuir");
        buttonAtribuir.addActionListener(this);

        buttonFechar = new JButton("Fechar");
        buttonFechar.addActionListener(this);
    }

    private void ajustaPropriedadesJanela() {
        setVisible(true);
        pack();
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
    }

    private void inserirReserva() throws IOException {
        int index1 = comboNomeSalas.getSelectedIndex();
        String nomeSala = comboModelNomeSalas.getElementAt(index1);

        int index2 = comboDias.getSelectedIndex();
        String dia = comboModelDias.getElementAt(index2);

        int index3 = comboPeriodoDia.getSelectedIndex();
        String periodoDia = comboModelPeriodoDia.getElementAt(index3);

        int index4 = comboQuantidadeHoras.getSelectedIndex();
        String quantasHoras = comboModelQuantidadeHoras.getElementAt(index4);

        Gravacao g = new Gravacao(nomeSala, dia, periodoDia, quantasHoras);

        if (lista.addReservaGravacao(g)) {
            modelProdutos.addRow(g.getObjetcReservaGravacao());
        }
        
        gerarArquivoTxtJanelaInternaGravacoes(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonAtribuir) {
            try {
                inserirReserva();
            } catch (IOException ex) {
                Logger.getLogger(JanelaCadastroReservaGravacoes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            dispose();
        }
    }

    //Desenvolver
    private void validarDadosGravacoes() {
    }

    private void gerarArquivoTxtJanelaInternaGravacoes(Gravacao g) throws IOException {
       
        FileWriter arq = new FileWriter("D:\\gravacoes.txt", true);
        PrintWriter gravarArq = new PrintWriter(arq);
 
        gravarArq.printf("+--GRAVAÇÕES--+%n");
        
        gravarArq.printf(g.toString());
 
        arq.close();
    }
}
