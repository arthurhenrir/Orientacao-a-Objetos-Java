package view;


import java.awt.*;
import javax.swing.*;
import controller.ControleProdutos;
/**
 * Modela a janela que mostra os produtos e as opções
 * @author Alex Gabriel
 *
 */
public class TelaProdutos {
	private  JFrame menuProdutos = new JFrame("Produtos");
	private  JLabel titulo = new JLabel ("Produtos");
	private  JButton pastel =  new JButton("Pastel");
	private  JButton bebida = new JButton("Bebida");
	private  ControleProdutos cprodutos;
	/**
	 * construtor TelaProdutos, constroi a janela de produtos
	 * @param cprodutos classe de conttrole que manipula os dados de controle 
	 */
	public TelaProdutos(ControleProdutos cprodutos) {
		this.cprodutos = cprodutos;

		menuProdutos.setSize(400, 350);
		menuProdutos.setResizable(false);
		menuProdutos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		menuProdutos.setLocationRelativeTo(null);
		menuProdutos.setVisible(true);
		menuProdutos.setLayout(null);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(155, 10, 150, 30);
		pastel.setBounds(125, 50, 140, 30);
		pastel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		bebida.setBounds(125, 100, 140, 30);
		bebida.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		menuProdutos.add(titulo);
		menuProdutos.add(bebida);
		menuProdutos.add(pastel);

		pastel.addActionListener(f->{			
			JanelaPastel();					
		});
		bebida.addActionListener(e->{
			JanelaBebida();
		});
	}
	/**
	 * Configura o JFrame 
	 * @param f JFrame a ser configurado
	 */
	public void sets(JFrame f) {//configuraÃƒÂ§ÃƒÂµes padrao da janela
		f.setSize(400, 350);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setLayout(null);
		f.setLayout(new BorderLayout());
	}
	/**
	 * Constroi a janela de pasteis, com informações e opções
	 */
	public void JanelaPastel() {
		JPanel legenda = new JPanel();
		legenda.setLayout(new BorderLayout());
		JLabel legendaTexto = new JLabel("Nome/Sabor");
		legenda.add(legendaTexto, BorderLayout.WEST);
		JFrame detalheProduto = new JFrame();
		sets(detalheProduto);
		JList<Object> listaPastel = new JList<Object>(cprodutos.getNamesPastel());//chama a funÃƒÂ§ÃƒÂ£o que passa os nomes dos pasteis
		JScrollPane scrollPastel = new JScrollPane(listaPastel);
		listaPastel.setFixedCellHeight(30);
		listaPastel.setFixedCellWidth(385);//define o tamanho da lista
		detalheProduto.add(scrollPastel, BorderLayout.WEST);
		detalheProduto.add(legenda, BorderLayout.NORTH);
		JButton novo = new JButton("Novo");
		JButton pesquisar = new JButton("Pesquisar");
		JPanel panelBaixo = new JPanel();
		
		panelBaixo.setLayout(new FlowLayout());
		panelBaixo.add(novo);
		panelBaixo.add(pesquisar);
		detalheProduto.add(panelBaixo, BorderLayout.SOUTH);

		novo.addActionListener(g->{
			detalheProduto.dispose();
			new TelaDetalheProduto().criarPastel(cprodutos);
			menuProdutos.dispose();
		});
		pesquisar.addActionListener(g->{
			JanelaPesquisaPastel();
		});
		listaPastel.addListSelectionListener( g ->{
			if(!g.getValueIsAdjusting()) {//evita que o evento ocorra varias vezes
				detalheProduto.dispose();
				menuProdutos.dispose();
				new TelaDetalheProduto(cprodutos, 1, listaPastel.getSelectedIndex());
				
			}
		});
	}
	/**
	 * Constroi a janela de bebidas, com informações e opções
	 */
	public void JanelaBebida() {
		JPanel legenda2 = new JPanel();
		legenda2.setLayout(new BorderLayout());
		JLabel legendaTexto2 = new JLabel("Nome/Sabor");
		legenda2.add(legendaTexto2, BorderLayout.WEST);
		JFrame detalheBebida = new JFrame();
		sets(detalheBebida);
		JList<Object> listaBebida = new JList<Object>(cprodutos.getNamesBebida());//chama a funÃƒÂ§ÃƒÂ£o que passa os nomes das bebidas
		JScrollPane scrollBebida = new JScrollPane(listaBebida);
		listaBebida.setFixedCellHeight(30);
		listaBebida.setFixedCellWidth(385);
		JButton novo = new JButton("Novo");
		JButton pesquisar = new JButton("Pesquisar");
		JPanel panelBaixo = new JPanel();
		panelBaixo.setLayout(new FlowLayout());
		
		panelBaixo.add(novo);
		panelBaixo.add(pesquisar);
		detalheBebida.add(panelBaixo, BorderLayout.SOUTH);
		detalheBebida.add(scrollBebida, BorderLayout.WEST);
		detalheBebida.add(legenda2, BorderLayout.NORTH);
		

		novo.addActionListener(g->{
			detalheBebida.dispose();
			new TelaDetalheProduto().criarBebida(cprodutos);
			menuProdutos.dispose();
		});
		pesquisar.addActionListener(g->{
			JanelaPesquisaBebida();
		});
		listaBebida.addListSelectionListener( g ->{
			if(!g.getValueIsAdjusting()) {//evita que o evento ocorra varias vezes
				detalheBebida.dispose();
				menuProdutos.dispose();
				new TelaDetalheProduto(cprodutos, 2, listaBebida.getSelectedIndex());
			}
		});
	}
	/**
	 * controi a janela da função de pesquisa sobre pasteis
	 */
	public void JanelaPesquisaPastel() {
		JFrame janelaPesquisa = new JFrame();
		JTextField nomePesquisa = new JTextField("");
		JLabel nome = new JLabel("Nome: ");
		sets(janelaPesquisa);
		janelaPesquisa.setLayout(null);
		JLabel legenda = new JLabel("Escreva o nome do pastel que deseja pesquisar: ");
		legenda.setFont(new Font("Arial", Font.BOLD, 15));
		JButton ok = new JButton("Ok");
		legenda.setBounds(0, 0, 350, 30);
		nomePesquisa.setBounds(100, 70, 200, 30);
		nome.setBounds(30, 70, 200, 30);
		ok.setBounds(310, 70, 50, 30);
		janelaPesquisa.add(legenda);
		janelaPesquisa.add(nomePesquisa);
		janelaPesquisa.add(nome);
		janelaPesquisa.add(ok);
		ok.addActionListener(j ->{
			if(cprodutos.pesquisarNomesPastel(nomePesquisa.getText()) != -1) {
				new TelaDetalheProduto(cprodutos, 1, cprodutos.pesquisarNomesPastel(nomePesquisa.getText()));
				janelaPesquisa.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "O Pastel nÃ£o foi encontrado", "Pesquisa", JOptionPane.CLOSED_OPTION);
				janelaPesquisa.dispose();
			}	
		});
	}
	/**
	 * controi a janela da função de pesquisa sobre bebidas
	 */
	public void JanelaPesquisaBebida() {
		JFrame janelaPesquisa = new JFrame();
		JTextField nomePesquisa = new JTextField("");
		JLabel nome = new JLabel("Nome: ");
		sets(janelaPesquisa);
		janelaPesquisa.setLayout(null);
		JLabel legenda = new JLabel("Escreva o nome da Bebida que deseja pesquisar: ");
		legenda.setFont(new Font("Arial", Font.BOLD, 15));
		JButton ok = new JButton("Ok");
		legenda.setBounds(0, 0, 350, 30);
		nomePesquisa.setBounds(100, 70, 200, 30);
		nome.setBounds(30, 70, 200, 30);
		ok.setBounds(310, 70, 50, 30);
		janelaPesquisa.add(legenda);
		janelaPesquisa.add(nomePesquisa);
		janelaPesquisa.add(nome);
		janelaPesquisa.add(ok);
		ok.addActionListener(j ->{
			if(cprodutos.pesquisarNomesBebida(nomePesquisa.getText()) != -1) {
				new TelaDetalheProduto(cprodutos, 2, cprodutos.pesquisarNomesBebida(nomePesquisa.getText()));
				janelaPesquisa.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "A Bebida nÃ£o foi encontrado", "Pesquisa", JOptionPane.CLOSED_OPTION);
				janelaPesquisa.dispose();
			}	
		});
	}
}

