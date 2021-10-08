package controller;
import model.*;
/**
 * Manipula os dados de produto, pastel e bebida
 * @author Alex Gabriel
 *
 */
public class ControleProdutos {
	Dados dados;
	/**
	 * Construtor ControleProdutos com os dados que serão manipulados 
	 * @param dados Dados a serem manipulados 
	 */
	public ControleProdutos(Dados dados) {
		this.dados = dados;
	}
	
	/**
	 * Obtém os dados de todos os pasteis cadastrados 
	 * @return String[] com os cados
	 */
	public String[] getNamesPastel() {	
		String[] nomes = new String[dados.Pasteis.size()];
			for(int i = 0; i < dados.Pasteis.size(); i++) {
				nomes[i] = dados.Pasteis.get(i).getNome() +" - "+ dados.Pasteis.get(i).getSabor() + " - R$" + dados.Pasteis.get(i).getPreco();
			}
		return nomes;
		
	}
	/**
	 * Obtém os dados de todas as bebidas cadastrados 
	 * @return String[] com os cados
	 */
	public String[] getNamesBebida() {	
		String[] nomes = new String[dados.Bebidas.size()];
		for(int i = 0; i < dados.Bebidas.size(); i++) {
			nomes[i] = dados.Bebidas.get(i).getNome() +" "+ dados.Bebidas.get(i).getVolume()+"ml - Sabor: " + dados.Bebidas.get(i).getSabor() + " - R$" + dados.Bebidas.get(i).getPreco();
		}
		return nomes;
		
	}
	
	 /**
	  * Obtém os dados do pastel especifico a partir do nome pesquisado
	  * @param nome String com o nome a ser pesquisado 
	  * @return int com o indice do produto encontrado ou -1 para produto não encontrado
	  */
	public int pesquisarNomesPastel(String nome) {	
		int index =-1;
			for(int i = 0; i < dados.Pasteis.size(); i++) {
				if(nome.equalsIgnoreCase(dados.Pasteis.get(i).getNome())) {
					index = i;
					break;
				}
			}
		return index;
	}
	/**
	  * Obtém os dados da bebida especifica a partir do nome pesquisado
	  * @param nome String com o nome a ser pesquisado 
	  * @return int com o indice do produto encontrado ou -1 para produto não encontrado
	  */
	public int pesquisarNomesBebida(String nome) {	
		int index =-1;
			for(int i = 0; i < dados.Bebidas.size(); i++) {
				if(nome.equalsIgnoreCase(dados.Bebidas.get(i).getNome())) {
					index = i;
					break;
				}
			}
		return index;
	}
	/**
	 * Obtém o nome do produto
	 * @param index indice que indica o local do produto na arraylist
	 * @param op opção 1 para pastel e 2 para bebida
	 * @return String que especifica o nome 
	 */
	public String getNome(int index, int op) {
		String nome;
		if(op == 1) {
			nome = dados.Pasteis.get(index).getNome();
		}else {
			nome = dados.Bebidas.get(index).getNome();
		}
		
		return nome;
	}
	/**
	 * Obtém o sabor do produto
	 * @param index indice que indica o local do produto na arraylist
	 * @param op opção 1 para pastel e 2 para bebida
	 * @return String que especifica o sabor 
	 */
	public String getSabor(int index, int op) {
		String sabor;
		if(op == 1) {
			sabor = dados.Pasteis.get(index).getSabor();
		}else {
			sabor = dados.Bebidas.get(index).getSabor();
		}
		return sabor;
	}
	/**
	 * Obtém o preco do produto
	 * @param index indice que indica o local do produto na arraylist
	 * @param op opção 1 para pastel e 2 para bebida
	 * @return Float que especifica o preco 
	 */
	public Float getPreco(int index, int op) {
		Float preco;
		if(op == 1) {
			preco = dados.Pasteis.get(index).getPreco();
		}else {
			preco = dados.Bebidas.get(index).getPreco();
		}
		return preco;
	}
	/**
	 * obtém o volume da bebida
	 * @param index indice que indica o local do produto na arraylist
	 * @return Float que especifica o volume 
	 */
	public Float getVolume(int index) {
		Float volume;
		volume = dados.Bebidas.get(index).getVolume();
		return volume;
	}
	/**
	 * Obtém a marca
	 * @param index indice que indica o local do produto na arraylist 
	 * @return um String especificando o nome da marca
	 */
	public String getMarca(int index) {
		String marca;
		marca = dados.Bebidas.get(index).getMarca();
		return marca;
	}
	 /**
 	  * Obtém os ingredientes 
 	  * @param index indice que indica o local do produto na arraylist
 	  * @return String que espercifica os ingrediemntes; 
 	  */
	public String getDesc(int index) {
		String desc;
		desc = dados.Pasteis.get(index).getIngredientes();
		return desc;
	}
	
	/**
	 * Configura o pastel 
	 * @param p Pastel com os dados a ser configurado
	 * @param i indice que indica o local do produto na arraylist
	 */
	public void editarPastel(Pastel p, int i){
		dados.Pasteis.set(i, p);
	}
	/**
	 * Configura a Bebida 
	 * @param b Bebida com os dados a ser configurado
	 * @param i indice que indica o local do produto na arraylist
	 */
	public void editarBebida(Bebida b, int i){
		dados.Bebidas.set(i, b);
	}
	
	/**
	 * Adiciona um novo pastel na arraylist
	 * @param p pastel a ser adicionado 
	 */
	public void criarPastel(Pastel p) {
		dados.Pasteis.add(p);
	}
	/**
	 * Adiciona uma nova bebida na arraylist
	 * @param b bebida a ser adicionada 
	 */
	public void criarBebida(Bebida b) {
		dados.Bebidas.add(b);
	}
	/**
	 * Exclui o pastel da arraylist 
	 * @param index indice que indica o local do produto na arraylist
	 */
	public void excluirPastel(int index) {
		dados.Pasteis.remove(index);
	}
	/**
	 * Exclui a bebida da arraylist 
	 * @param index indice que indica o local do produto na arraylist
	 */
	public void excluirBebida(int index) {
		dados.Bebidas.remove(index);
	}
}
