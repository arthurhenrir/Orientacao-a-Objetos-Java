package view;


import java.awt.*;
import javax.swing.*;
import controller.ControleProdutos;

public class TelaProdutos {
	private  JFrame menuProdutos = new JFrame("Produtos");
	private  JLabel titulo = new JLabel ("Produtos");
	private  JButton pastel =  new JButton("Pastel");
	private  JButton bebida = new JButton("Bebida");
	private  ControleProdutos cprodutos;
	
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

	public void sets(JFrame f) {//configurações padrao da janela
		f.setSize(400, 350);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setLayout(null);
		f.setLayout(new BorderLayout());
	}

	public void JanelaPastel() {
		JPanel legenda = new JPanel();
		legenda.setLayout(new BorderLayout());
		JLabel legendaTexto = new JLabel("Nome/Sabor");
		legenda.add(legendaTexto, BorderLayout.WEST);
		JFrame detalheProduto = new JFrame();
		sets(detalheProduto);
		JList<Object> listaPastel = new JList<Object>(cprodutos.getNamesPastel());//chama a função que passa os nomes dos pasteis
		JScrollPane scrollPastel = new JScrollPane(listaPastel);
		listaPastel.setFixedCellHeight(30);
		listaPastel.setFixedCellWidth(385);//define o tamanho da lista
		detalheProduto.add(scrollPastel, BorderLayout.WEST);
		detalheProduto.add(legenda, BorderLayout.NORTH);
		JButton novo = new JButton("Novo");
		detalheProduto.add(novo, BorderLayout.SOUTH);

		novo.addActionListener(g->{
			detalheProduto.dispose();
			new TelaDetalheProduto().criarPastel(cprodutos);
			menuProdutos.dispose();
		});
		listaPastel.addListSelectionListener( g ->{
			if(!g.getValueIsAdjusting()) {//evita que o evento ocorra varias vezes
				detalheProduto.dispose();
				menuProdutos.dispose();
				new TelaDetalheProduto(cprodutos, 1, listaPastel.getSelectedIndex());
				
			}
			
		});
	}
	public void JanelaBebida() {
		JPanel legenda2 = new JPanel();
		legenda2.setLayout(new BorderLayout());
		JLabel legendaTexto2 = new JLabel("Nome/Sabor");
		legenda2.add(legendaTexto2, BorderLayout.WEST);
		JFrame detalheBebida = new JFrame();
		sets(detalheBebida);
		JList<Object> listaBebida = new JList<Object>(cprodutos.getNamesBebida());//chama a função que passa os nomes das bebidas
		JScrollPane scrollBebida = new JScrollPane(listaBebida);
		listaBebida.setFixedCellHeight(30);
		listaBebida.setFixedCellWidth(385);
		JButton novo = new JButton("Novo");

		detalheBebida.add(novo, BorderLayout.SOUTH);
		detalheBebida.add(scrollBebida, BorderLayout.WEST);
		detalheBebida.add(legenda2, BorderLayout.NORTH);

		novo.addActionListener(g->{
			detalheBebida.dispose();
			new TelaDetalheProduto().criarBebida(cprodutos);
			menuProdutos.dispose();
		});
		listaBebida.addListSelectionListener( g ->{
			if(!g.getValueIsAdjusting()) {//evita que o evento ocorra varias vezes
				detalheBebida.dispose();
				menuProdutos.dispose();
				new TelaDetalheProduto(cprodutos, 2, listaBebida.getSelectedIndex());
			}
		});
	}
}

