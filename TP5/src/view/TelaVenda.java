package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controller.*;

public class TelaVenda implements ActionListener{
	
	private JFrame janela = new JFrame("");
	private JLabel titulo = new JLabel("Area de Vendas");
	private JButton cadastrar = new JButton("Cadastrar Venda");
	private JButton listar = new JButton("Listar Vendas");
	private JButton voltar = new JButton("Voltar");
	private static ControleClientes cclientes;
	private static ControleVendas cvendas;
	
	public TelaVenda(ControleVendas cvendas, ControleClientes cclientes) {
		this.cclientes = cclientes;
		this.cvendas = cvendas;
		
		//Estilização dos botões e labels
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(120, 10, 165, 30);
		cadastrar.setBounds(125, 50, 140, 30);
        cadastrar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        listar.setBounds(125, 100, 140, 30);
        listar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        voltar.setBounds(125, 250, 140, 30);	
        voltar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
		//Adicionar o evento aos botoes
        cadastrar.addActionListener(this);
        voltar.addActionListener(this);
        listar.addActionListener(this);
		

		//Adicionar tudo ao JFrame
        sets(janela);
        janela.add(titulo);
        janela.add(cadastrar);
        janela.add(listar);
        janela.add(voltar);		
	}
	
	public void sets(JFrame f) { //Função para definir o padrão dos JFrames
		f.setLayout(null);
		f.setSize(400, 350);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
	}   
	
	public void actionPerformed(ActionEvent e) { //Função para resposta aos eventos dos botoes
		Object src = e.getSource();
		
		if(src == cadastrar)
			new TelaDetalheVenda(cvendas, cclientes).cadastroVenda();
		if(src == voltar)
			janela.dispose();
		if(src == listar)
			new TelaDetalheVenda(cvendas, cclientes).listarClientes();
	}
}
