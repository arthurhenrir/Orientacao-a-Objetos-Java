package controller;

public class ControleClientes {
	public Dados dados;
	
	public ControleClientes(Dados dados) {
		this.dados = dados;
	}
	
	public String[] getNomesClientes() {	
		String[] nomes = new String[dados.nomeClientes.size()];
			for(int i = 0; i < dados.nomeClientes.size(); i++) {
				nomes[i] = dados.nomeClientes.get(i) + " - " + dados.cpfClientes.get(i);
			}
		return nomes;		
	}
	
	public void delCliente(int i) {
		dados.nomeClientes.remove(i);
		dados.cpfClientes.remove(i);
	}
	
	public void addCliente(String name, String cpf) {
		dados.nomeClientes.add(name);
		dados.cpfClientes.add(cpf);
	}
	
	public String getNome(int i) {		
		return dados.nomeClientes.get(i);
	}
	
	public String getCpf(int i) {
		return dados.cpfClientes.get(i);
	}
	
	public void setCliente(int i, String name, String cpf) {
		dados.nomeClientes.set(i, name);
		dados.cpfClientes.set(i, cpf);
	}
}
