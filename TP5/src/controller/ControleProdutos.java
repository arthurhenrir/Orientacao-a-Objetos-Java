package controller;
import model.*;

public class ControleProdutos {
	Dados dados;
	public ControleProdutos(Dados dados) {
		this.dados = dados;
	}
	
	public String[] getNamesPastel() {	
		String[] nomes = new String[dados.Pasteis.size()];
			for(int i = 0; i < dados.Pasteis.size(); i++) {
				nomes[i] = dados.Pasteis.get(i).getNome() +" - "+ dados.Pasteis.get(i).getSabor() + " - R$" + dados.Pasteis.get(i).getPreco();
			}
		return nomes;
		
	}
	
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
	
	
	public String[] getNamesBebida() {	
		String[] nomes = new String[dados.Bebidas.size()];
		for(int i = 0; i < dados.Bebidas.size(); i++) {
			nomes[i] = dados.Bebidas.get(i).getNome();
		}
		return nomes;
		
	}
	
	public String getNome(int index, int op) {
		String nome;
		if(op == 1) {
			nome = dados.Pasteis.get(index).getNome();
		}else {
			nome = dados.Bebidas.get(index).getNome();
		}
		
		return nome;
	}
	
	public String getSabor(int index, int op) {
		String sabor;
		if(op == 1) {
			sabor = dados.Pasteis.get(index).getSabor();
		}else {
			sabor = dados.Bebidas.get(index).getSabor();
		}
		return sabor;
	}
	
	public Float getPreco(int index, int op) {
		Float preco;
		if(op == 1) {
			preco = dados.Pasteis.get(index).getPreco();
		}else {
			preco = dados.Bebidas.get(index).getPreco();
		}
		return preco;
	}
	
	public Float getVolume(int index) {
		Float volume;
		volume = dados.Bebidas.get(index).getVolume();
		return volume;
	}
	
	public String getMarca(int index) {
		String marca;
		marca = dados.Bebidas.get(index).getMarca();
		return marca;
	}
	
	public String getDesc(int index) {
		String desc;
		desc = dados.Pasteis.get(index).getIngredientes();
		return desc;
	}
	
	public void editarPastel(Pastel p, int i){
		dados.Pasteis.set(i, p);
	}
	
	public void editarCriarBebida(Bebida b, int i){
		dados.Bebidas.set(i, b);
	}
	
	public void criarPastel(Pastel p) {
		dados.Pasteis.add(p);
	}
	
	public void criarBebida(Bebida b) {
		dados.Bebidas.add(b);
	}
	
	public void excluirPastel(int index) {
		dados.Pasteis.remove(index);
	}
	
	public void excluirBebida(int index) {
		dados.Bebidas.remove(index);
	}
}
