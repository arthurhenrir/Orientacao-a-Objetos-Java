package controller;

import java.util.ArrayList;

import model.*;
/**
 * Armazena todos os dados utilizados no sistema
 * @author Arthur Henrique, Alex Gabriel
 *
 */
public class Dados {
	/**
	 * ArrayList para armazenamento das bebidas
	 */
    public ArrayList<Bebida> Bebidas = new ArrayList<Bebida>();  
    /**
     * ArrayList para armazenamento dos pasteis
     */
    public ArrayList<Pastel> Pasteis = new ArrayList<Pastel>();
    /**
     * ArrayList para armazenamento dos nomes dos clientes
     */
    public ArrayList<String> nomeClientes = new ArrayList<String>();  
    /**
     * ArrayList para armazenamento dos CPFs dos clientes
     */
    public ArrayList<String> cpfClientes = new ArrayList<String>();      
    /**
     * ArrayList para armazenamento dos dados de fidelidades dos clientes
     */
    public ArrayList<Fidelidade> Fidelidade = new ArrayList<Fidelidade>();
    /**
     * ArrayList para armazenamento da quantidade de pasteis vendidos ao cliente
     */
    public ArrayList<Integer> vendaPasteis = new ArrayList<Integer>();  
    /**
     * ArrayList para armazenamento da quantidade de refris vendidos ao cliente
     */
    public ArrayList<Integer> vendaRefri = new ArrayList<Integer>(); 
    /**
     * ArrayList para armazenamento da quantidade de sucos vendidos ao cliente
     */
    public ArrayList<Integer> vendaSuco = new ArrayList<Integer>();           
    /**
     * Classe para povoamento dos dados aleatorios
     */
    public Dados() {//dados pre cadastrados 
    	Fidelidade fidelidade = new Fidelidade();
    	Pastel pastel1 = new Pastel("Frangostain", "Frango com catupiry", "Peito de frango, catupiry", 7.9f);
    	Pasteis.add(pastel1);
        Pastel pastel2 = new Pastel("Po sem do", "peixe", "peixe com catupiry", 9.9f);
        Pasteis.add(pastel2);
        Bebida bebida1 = new Bebida("Refri", "uva", "fanta", 3.55f, 350f);
        Bebidas.add(bebida1);
        Bebida bebida2 = new Bebida("Suco", "Laranja", "Heroes", 2.00f, 250f);
        Bebidas.add(bebida2);
        nomeClientes.add("Cliente1");
     	nomeClientes.add("Cliente2");
     	cpfClientes.add("40028922");
     	cpfClientes.add("33213030");
     	vendaPasteis.add(5);
     	vendaRefri.add(2);
     	vendaSuco.add(40);
     	vendaPasteis.add(3);
     	vendaRefri.add(4);
     	vendaSuco.add(1);
     	for(int i=2; i<50; i++) {
    		vendaPasteis.add(0);
    		vendaRefri.add(0);
    		vendaSuco.add(0);
    	}
     	for(int i=0; i<50; i++) {
     		fidelidade.setPontos(0);
    		Fidelidade.add(fidelidade);
    	}
    }
}
