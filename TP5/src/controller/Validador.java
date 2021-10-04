package controller;

public class Validador {

	public boolean validaCliente(String nome, String cpf) {
		if(nome.length() < 3 || cpf.length() != 11) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean validaVenda(int numPastel, int numRefri, int numSuco) {
		if(numPastel < 0 || numRefri < 0 || numSuco < 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean validaBebida(float preco, float volume) {
		if(preco < 0 || volume < 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean validaPastel(float preco) {
		if(preco < 0) {
			return false;
		}else {
			return true;
		}
	}
}
