package entelgy.poo.view.principal;

import entelgy.poo.janelasInternas.JanelaCadastroReservaGravacoes;
import entelgy.poo.janelasInternas.JanelaInternaCadastroArtistas;
import entelgy.poo.janelasInternas.JanelaInternaCadastroBandas;
import entelgy.poo.janelasInternas.JanelaInternaCadastroEquipamentos;
import entelgy.poo.janelasInternas.JanelaInternaCadastroSala;
import entelgy.poo.janelasInternas.JanelaInternaFuncionario;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

public class JanelaPrincipal extends JFrame implements ActionListener {

    private JMenu menu;
    private JMenu menuSobre;
    private JMenu menuVersao;
    private JMenuBar menubar;
    private JTabbedPane pane;

    private JMenu itemEscolher1;
    private JMenuItem itemInserirSalas;
    private JMenuItem itemInserirArtistas;
    private JMenuItem itemInserirBandas;
    private JMenuItem itemInserirGravacoes;
    private JMenuItem itemInserirEquipamentos;
    private JMenuItem itemInserirFuncionario;

    private JMenu itemEscolher2;
    private JMenuItem itemTabelaTOTAL; //IRÁ EXIBIR TODOS OS DADOS RELACIONADOS referente ao  ALUGUEL

    private JMenuItem itemSair;

    private JMenuItem itemSobre;
    private JMenu item1;
    private JMenuItem itemInternoA;

    private JMenu item2;
    private JMenuItem itemInternoC;
    private JMenuItem itemInternoD;
    private JMenuItem itemInternoE;

    private JMenuItem itemVersao;
    //private JDesktopPane desktop;
    private Desktop desktop;

    private JMenuItem comboMenuItem;
    private ImageIcon wallPaper;

    //Janelas internas
    private JanelaInternaCadastroSala j1;
    private JanelaInternaCadastroArtistas j2;
    private JanelaCadastroReservaGravacoes j3;
    private JanelaInternaCadastroEquipamentos j4;
    private JanelaInternaCadastroBandas j5;
    private JanelaInternaFuncionario j6;

    public JanelaPrincipal() {
        super("Studio Musical - Venha ser um Entelger");

        criarComponentes();
        ajustarJanela();
    }

    private void criarComponentes() {
        wallPaper = new ImageIcon(getClass().getResource("imagemFundo.jpg"));
        menu = new JMenu("Arquivo");
        menuSobre = new JMenu("Sobre");
        menuVersao = new JMenu("Versão");

        menubar = new JMenuBar();
        //desktop = new JDesktopPane();
        desktop = new Desktop();

        itemEscolher1 = new JMenu("Inserir Dados");
        itemEscolher1.setIcon(criarIcone("imagens/inserir.png"));

        itemEscolher2 = new JMenu("Exibir Histórico");
        itemEscolher2.setIcon(criarIcone("imagens/listar.png"));

        itemInserirSalas = new JMenuItem("Inserir Sala");
        itemInserirSalas.setMnemonic('S');
        itemInserirSalas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
        itemInserirSalas.addActionListener(this);

        itemInserirArtistas = new JMenuItem("Inserir Artista");
        itemInserirArtistas.setMnemonic('A');
        itemInserirArtistas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
        itemInserirArtistas.addActionListener(this);

        itemInserirBandas = new JMenuItem("Inserir Banda");
        itemInserirBandas.setMnemonic('B');
        itemInserirBandas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_MASK));
        itemInserirBandas.addActionListener(this);

        itemInserirGravacoes = new JMenuItem("Inserir Gravação");
        itemInserirGravacoes.setMnemonic('G');
        itemInserirGravacoes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_MASK));
        itemInserirGravacoes.addActionListener(this);

        itemInserirEquipamentos = new JMenuItem("Inserir Equipamentos");
        itemInserirEquipamentos.setMnemonic('E');
        itemInserirEquipamentos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
        itemInserirEquipamentos.addActionListener(this);

        itemInserirFuncionario = new JMenuItem("Inserir Funcionário");
        itemInserirFuncionario.setMnemonic('F');
        itemInserirFuncionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_MASK));
        itemInserirFuncionario.addActionListener(this);

        itemTabelaTOTAL = new JMenuItem("Tabela Sistema");
        itemTabelaTOTAL.setMnemonic('T');
        itemTabelaTOTAL.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_MASK));
        itemTabelaTOTAL.addActionListener(this);

        itemSair = new JMenuItem("Sair");
        itemSair.setMnemonic('S');
        itemSair.setIcon(criarIcone("imagens/sair.png"));
        itemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_MASK));
        itemSair.addActionListener(this);

        item1 = new JMenu("Orientadores do projeto");
        itemInternoA = new JMenuItem("Entelgy - Brasil");
        itemInternoA.setIcon(criarIcone("imagens/logo.png"));
        itemInternoA.addActionListener(this);

        item2 = new JMenu("Desenvolvedores do projeto");

        itemInternoE = new JMenuItem("Wesley Gabriel");
        itemInternoE.setIcon(criarIcone("imagens/wesleyGabriel.jpg"));
        itemInternoE.addActionListener(this);

        itemVersao = new JMenuItem("Versão 1.0");
        itemVersao.addActionListener(this);

        definirFonte(itemInserirSalas, "arial", Font.ITALIC, 13);
        definirFonte(itemInserirArtistas, "arial", Font.ITALIC, 13);
        definirFonte(itemInserirBandas, "arial", Font.ITALIC, 13);
        definirFonte(itemInserirGravacoes, "arial", Font.ITALIC, 13);
        definirFonte(itemInserirEquipamentos, "arial", Font.ITALIC, 13);
        definirFonte(itemInserirSalas, "arial", Font.ITALIC, 13);
        definirFonte(itemInserirArtistas, "arial", Font.ITALIC, 13);
        definirFonte(itemInserirFuncionario, "arial", Font.ITALIC, 13);
        definirFonte(itemInserirBandas, "arial", Font.ITALIC, 13);
        definirFonte(itemInserirGravacoes, "arial", Font.ITALIC, 13);
        definirFonte(itemTabelaTOTAL, "arial", Font.ITALIC, 13);
        definirFonte(itemInternoA, "arial", Font.ITALIC, 13);
        definirFonte(itemInternoE, "arial", Font.ITALIC, 13);
        definirFonte(itemVersao, "arial", Font.ITALIC, 13);

        menu.add(itemEscolher1);
        itemEscolher1.add(itemInserirSalas);
        itemEscolher1.add(itemInserirArtistas);
        itemEscolher1.add(itemInserirBandas);
        itemEscolher1.add(itemInserirGravacoes);
        itemEscolher1.add(itemInserirEquipamentos);
        itemEscolher1.add(itemInserirFuncionario);

        menu.add(itemEscolher2);
        itemEscolher2.add(itemTabelaTOTAL);

        menu.addSeparator();
        menu.add(itemSair);

        menuSobre.add(item1);
        item1.add(itemInternoA);

        menuSobre.add(item2);
        item2.add(itemInternoE);

        menuVersao.add(itemVersao);

        menubar.add(menu);
        menubar.add(menuSobre);
        menubar.add(menuVersao);

        setJMenuBar(menubar);
        add(desktop);

    }

    private void ajustarJanela() {
        setVisible(true);
        setSize(950, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //PARA DESABILITAR O SOM DE FUNDO DA APLICAÇÃO,COMENTE O CÓDIGO ABAIXO ----> "tocarSomFundo("Hot Mustard")"
        //tocarSomFundo("Hot Mustard");
    }

    private void definirFonte(JComponent component, String nome, int estilo, int tamanho) {
        component.setFont(new Font(nome, estilo, tamanho));
    }

    private ImageIcon criarIcone(String flag) {
        ImageIcon icone = new ImageIcon(flag);
        Image imagem = icone.getImage();
        Image imagemNova = imagem.getScaledInstance(29, 29, Image.SCALE_SMOOTH);
        icone.setImage(imagemNova);

        return icone;
    }

    public void encerrar() {
        int r = JOptionPane.showConfirmDialog(JanelaPrincipal.this, "Deseja encerrar ?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (r == JOptionPane.YES_OPTION) { //encerrando a aplicação
            System.exit(0);
        }
    }

    private void adicionarJanela(JInternalFrame janelaInterna) {
        desktop.add(janelaInterna);
        desktop.moveToFront(janelaInterna);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == itemInserirSalas) {
            j1 = new JanelaInternaCadastroSala(this);
            adicionarJanela(j1);

        } else if (e.getSource() == itemInserirArtistas) {
            j2 = new JanelaInternaCadastroArtistas(this);
            adicionarJanela(j2);

        } else if (e.getSource() == itemInserirBandas) {
            j5 = new JanelaInternaCadastroBandas(this);
            adicionarJanela(j5);

        } else if (e.getSource() == itemInserirGravacoes) {
            j3 = new JanelaCadastroReservaGravacoes(this);
            adicionarJanela(j3);

        } else if (e.getSource() == itemInserirEquipamentos) {
            j4 = new JanelaInternaCadastroEquipamentos(this);
            adicionarJanela(j4);

        } else if (e.getSource() == itemInserirFuncionario) {
            j6 = new JanelaInternaFuncionario(this);
            adicionarJanela(j6);

        } else if (e.getSource() == itemSair) {
            encerrar();
        }
    }

    public void tocarSomFundo(String nomeMusica) {
        URL url = getClass().getResource(nomeMusica + ".wav");
//        AudioClip audio = Applet.newAudioClip(url);
 //       audio.play();
    }

    private void initializeImagemFundo() {
        URL url = getClass().getResource("imagemFundo.jpg");
        Icon icon = new ImageIcon(url);
        add(new JLabel(icon), BorderLayout.CENTER);
    }

    private class Desktop extends JDesktopPane {

        public void paintComponent(Graphics g) {
            super.paintComponents(g);
            Image img = wallPaper.getImage();
            g.drawImage(img, 0, 0, this);
        }
    }
}
