package view;

import controller.*;
import java.awt.*;
import javax.swing.*;
import controller.*;

public class TelaFidelidade {
	private static ControleClientes cclientes;
	private static ControleVendas cvendas;
	private static ControleFidelidade  cfidelidade;
	private JFrame telaFide = new JFrame();

	public TelaFidelidade(ControleFidelidade cfidelidade, ControleVendas cvendas, ControleClientes cclientes) {
		this.cclientes = cclientes;
		this.cvendas= cvendas;
		this.cfidelidade =cfidelidade;
		String[] cs = {"teste", "teste2"};
		sets(telaFide);
		telaFide.setLayout(new BorderLayout());
		JList<Object> listaFide = new JList<Object>(cfidelidade.getFidelidade());
		JScrollPane scrollFide = new JScrollPane(listaFide);
		JButton voltar = new JButton("Voltar");
		telaFide.add(scrollFide);
		telaFide.add(voltar, BorderLayout.SOUTH);
		voltar.addActionListener(a -> telaFide.dispose());
	}
	
	public void sets(JFrame f) {
		f.setLayout(null);
		f.setSize(400, 350);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
	} 
}
