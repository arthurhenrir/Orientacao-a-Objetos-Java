package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controller.*;
/**
 * Modela a janela principal com todas as opções relacionadas a pastelaria
 * @author Alex e Arthur
 *
 */
public class TelaMenu implements ActionListener{
    
    private static JFrame menu = new JFrame("Pastelaria Heroes");
    private static JLabel titulo = new JLabel("Menu Principal");
    private static JButton produto = new JButton("Area de Produto");
    private static JButton cliente = new JButton("Area de Cliente");
    private static JButton venda = new JButton("Area de Vendas");
    private static JButton fidelidade = new JButton("Area de fidelidade");
    private static JButton sair = new JButton("Sair");
    public static Dados dados = new Dados();
    private ControleProdutos cprodutos = new ControleProdutos(dados);
    private ControleClientes cclientes = new ControleClientes(dados);
    private ControleVendas cvendas = new ControleVendas(dados);
    private ControleFidelidade cfidelidade = new ControleFidelidade(dados);
    /**
     * Construtor TelaMenu constroi a tela de menu
     */
    public TelaMenu(){
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(125, 10, 150, 30);
		produto.setBounds(125, 50, 140, 30);
        produto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		cliente.setBounds(125, 100, 140, 30);
        cliente.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		venda.setBounds(125, 150, 140, 30);	
        venda.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        fidelidade.setBounds(125, 200, 140, 30);
        fidelidade.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        sair.setBounds(125, 250, 140, 30);	
        sair.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		menu.add(titulo);
        menu.add(produto);
        menu.add(cliente);
        menu.add(venda);
        menu.add(fidelidade);
        menu.add(sair);
		menu.setLayout(null);
		menu.setSize(400, 350);
        menu.setLocationRelativeTo(null);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setVisible(true);
		menu.setResizable(false);
    }
    public static void main(String[] args) {
        TelaMenu menu = new TelaMenu();
        cliente.addActionListener(menu);
        sair.addActionListener(menu);
        produto.addActionListener(menu);
        venda.addActionListener(menu);
        fidelidade.addActionListener(menu);
    }

    
    public void actionPerformed(ActionEvent e){
        Object src = e.getSource();
        int resposta;

        if(src == produto){
        	new TelaProdutos(cprodutos);//chama a tela de produtos
        }

        if(src == cliente){
        	new TelaCliente(cclientes);//chama a tela de clientes 
        }

        if(src == venda){
        	new TelaVenda(cvendas, cclientes);//chama a tela de vendas
        }

        if(src == fidelidade){
        	new TelaFidelidade(cfidelidade, cvendas, cclientes);//chama a tela de fidelidade
        }

        if(src == sair){
            resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?");
            if(resposta == JOptionPane.YES_OPTION){
                menu.dispose();
                JOptionPane.showMessageDialog(null, "Saindo!\nObrigado por fazer parte da Pastelaria Heroes");
            }
        }
    }
}
