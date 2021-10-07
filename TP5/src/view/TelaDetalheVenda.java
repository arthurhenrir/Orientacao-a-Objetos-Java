package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.*;
/**
 * Modela a janela de detalhes do objeto venda
 * @author Arthur Henrique
 *
 */
public class TelaDetalheVenda {
	private static ControleClientes cclientes;
	private static ControleVendas cvendas;
	private static Validador valida = new Validador();
	/**
	 * Construtor TelaDetalheVenda, recebe como argumento os objetos de manipula��o de dados 
	 * @param cvendas
	 * @param cclientes
	 */
	public TelaDetalheVenda(ControleVendas cvendas, ControleClientes cclientes) {
		this.cvendas = cvendas;
		this.cclientes = cclientes;
	}
	/**
	 * modela a janela que mostra todos os dados dos clientes
	 */
	public void listarClientes() { //Função para listar os clientes e suas vendas na aba de Listar Vendas
		//Definiçao dos elementos graficos
		JFrame janela = new JFrame("Lista de Clientes");
		JLabel legenda = new JLabel("Nome / CPF (Selecione o cliente desejado)");
		JList<Object> lista = new JList<Object>(cvendas.getVendas());
		JPanel botoes = new JPanel();
		JPanel subPanel = new JPanel();
		JButton voltar = new JButton("Voltar");
		JButton refresh = new JButton("Refresh");
		
		//Estilização dos elementos
		botoes.setLayout(new BorderLayout());
		subPanel.add(voltar);
		subPanel.add(refresh);		
		botoes.add(subPanel, BorderLayout.EAST);
		janela.add(legenda, BorderLayout.NORTH);
		janela.add(lista, BorderLayout.CENTER);
		janela.add(botoes, BorderLayout.SOUTH);
		sets(janela);
		
		//Adicionar eventos aos botoes
		voltar.addActionListener(a -> janela.dispose());
		refresh.addActionListener(b -> {
			janela.dispose();
			listarClientes();
		});
		
		//Evento ao clicar na opçao da lista
		lista.addListSelectionListener(c -> {
			if(!c.getValueIsAdjusting()) {
				editaVenda(lista.getSelectedIndex());
			}
		});
	}
	/**
	 * Modela a janela que implementa a funcionalidade de endi��o de clientes
	 * @param index indice que indica o cliente a ser editado
	 */
	public void editaVenda(int index) { //Função de editar/excluir os dados de uma venda
		//Criar os elementos graficos
		JFrame menu = new JFrame("Cadastrar Venda");
		JLabel pastel = new JLabel("Num Pastel: ");
		JLabel refri = new JLabel("Num Refri: ");
		JLabel suco = new JLabel("Num Suco: ");
		JTextField textPastel = new JTextField(cvendas.getPastel(index));
		JTextField textRefri = new JTextField(cvendas.getRefri(index));
		JTextField textSuco = new JTextField(cvendas.getSuco(index));
		JButton save = new JButton("Salvar");
		JButton excluir = new JButton("Excluir");
		
		//Estilizar elementos
		textPastel.setBounds(130,5,165,30);
		textRefri.setBounds(130,40,165,30);
		textSuco.setBounds(130,75,165,30);
		pastel.setFont(new Font("Arial", Font.BOLD, 20));
		pastel.setBounds(10, 5, 165, 30);
		refri.setFont(new Font("Arial", Font.BOLD, 20));
		refri.setBounds(10, 40, 165, 30);
		suco.setFont(new Font("Arial", Font.BOLD, 20));
		suco.setBounds(10, 75, 165, 30);
		save.setBounds(40, 115, 80, 20);
		excluir.setBounds(180, 115, 80, 20);

		//Adicionar tudo ao JFrame
		menu.add(save);
		menu.add(excluir);
		menu.add(textPastel);
		menu.add(textRefri);
		menu.add(textSuco);
		menu.add(pastel);
		menu.add(refri);
		menu.add(suco);
		menu.setLayout(null);
		menu.setSize(320, 180);
		menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        menu.setResizable(false);
        
		//Eventos dos botoes
        save.addActionListener(a -> {
        	if(textPastel.getText().isEmpty() || textRefri.getText().isEmpty() || textSuco.getText().isEmpty()) {
        		JOptionPane.showMessageDialog(null, "Os campos nao podem estar vazios");
        	}else{
				if(valida.validaFloat(textPastel.getText()) || valida.validaFloat(textRefri.getText()) || valida.validaFloat(textSuco.getText())){
					if(valida.validaVenda(Integer.parseInt(textPastel.getText()), Integer.parseInt(textRefri.getText()), Integer.parseInt(textSuco.getText()))) {
						cvendas.editVenda(index, Integer.parseInt(textPastel.getText()), Integer.parseInt(textRefri.getText()), Integer.parseInt(textSuco.getText()));
						menu.dispose();
						JOptionPane.showMessageDialog(null, "Venda Editada");
					}else {
						JOptionPane.showMessageDialog(null, "Dados de venda invalidos \n Coloque valores positivos");
					} 
				}else{
					JOptionPane.showMessageDialog(null, "Dados invalidos, insira numeros");
				}
        		     
        	}
        });

		excluir.addActionListener(a -> {
			cvendas.remVenda(index, Integer.parseInt(textPastel.getText()), Integer.parseInt(textRefri.getText()), Integer.parseInt(textSuco.getText()));
			menu.dispose();
			JOptionPane.showMessageDialog(null, "Venda Excluída");
		});
	}
	/**
	 * Modela a janela para listar clientes para cadastrar uma nova venda
	 */
	public void cadastroVenda() { //Função para listar clientes para cadastrar uma nova venda
		//Criar elementos
		JFrame janela = new JFrame("Lista de Clientes");
		JLabel legenda = new JLabel("Nome / CPF (Selecione o cliente desejado)");
		JList<Object> lista = new JList<Object>(cclientes.getNomesClientes());
		JPanel botoes = new JPanel();
		JPanel subPanel = new JPanel();
		JButton voltar = new JButton("Voltar");
		JButton refresh = new JButton("Refresh");
		
		//Estilizar elementos
		botoes.setLayout(new BorderLayout());
		subPanel.add(voltar);
		subPanel.add(refresh);		
		botoes.add(subPanel, BorderLayout.EAST);
		janela.add(legenda, BorderLayout.NORTH);
		janela.add(lista, BorderLayout.CENTER);
		janela.add(botoes, BorderLayout.SOUTH);
		sets(janela);
		
		//Eventos dos botoes
		voltar.addActionListener(a -> janela.dispose());
		refresh.addActionListener(b -> {
			janela.dispose();
			cadastroVenda();
		});
		
		lista.addListSelectionListener(c -> {
			if(!c.getValueIsAdjusting()) {
				janelaCadastro(lista.getSelectedIndex());
			}
		});
	}
	/**
	 * Modela a Janela de cadastro de cliente
	 * @param index indice
	 */
	public void janelaCadastro(int index) { //Janela de cadastro de cliente
		//Criar elementos novos
		JFrame menu = new JFrame("Cadastrar Venda");
		JLabel pastel = new JLabel("Num Pastel: ");
		JLabel refri = new JLabel("Num Refri: ");
		JLabel suco = new JLabel("Num Suco: ");
		JTextField textPastel = new JTextField();
		JTextField textRefri = new JTextField();
		JTextField textSuco = new JTextField();
		JButton save = new JButton("Salvar");
		
		//Estilizar Elementos
		textPastel.setBounds(130,5,165,30);
		textRefri.setBounds(130,40,165,30);
		textSuco.setBounds(130,75,165,30);
		pastel.setFont(new Font("Arial", Font.BOLD, 20));
		pastel.setBounds(10, 5, 165, 30);
		refri.setFont(new Font("Arial", Font.BOLD, 20));
		refri.setBounds(10, 40, 165, 30);
		suco.setFont(new Font("Arial", Font.BOLD, 20));
		suco.setBounds(10, 75, 165, 30);
		save.setBounds(110, 115, 80, 20);

		//Adicionar tudo ao JFrame
		menu.add(save);
		menu.add(textPastel);
		menu.add(textRefri);
		menu.add(textSuco);
		menu.add(pastel);
		menu.add(refri);
		menu.add(suco);
		menu.setLayout(null);
		menu.setSize(320, 180);
		menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        menu.setResizable(false);
        
		//Evento aos botões
        save.addActionListener(a -> {
        	if(textPastel.getText().isEmpty() || textRefri.getText().isEmpty() || textSuco.getText().isEmpty()) {
        		JOptionPane.showMessageDialog(null, "Os campos nao podem estar vazios");
        	}else{
				if(valida.validaFloat(textPastel.getText()) || valida.validaFloat(textRefri.getText()) || valida.validaFloat(textSuco.getText())){
					if(valida.validaVenda(Integer.parseInt(textPastel.getText()), Integer.parseInt(textRefri.getText()), Integer.parseInt(textSuco.getText()))) {
						cvendas.setVenda(index, Integer.parseInt(textPastel.getText()), Integer.parseInt(textRefri.getText()), Integer.parseInt(textSuco.getText()));
						menu.dispose();
						JOptionPane.showMessageDialog(null, "Venda Cadastrada");
					} else {
						JOptionPane.showMessageDialog(null, "Dados de venda invalidos \n Coloque valores positivos");
					} 
				}else{
					JOptionPane.showMessageDialog(null, "Dados invalidos, insira numeros");
				}
        		
        	}
        });
	}
	/**
	 * Configura o JFrame 
	 * @param f JFrame a ser configurado
	 */
	public void sets(JFrame f) { //Padronizar o estilo dos JFrames primarios
		f.setSize(400, 350);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
	} 
}
