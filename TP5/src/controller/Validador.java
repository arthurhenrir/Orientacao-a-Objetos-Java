package controller;

/**
 * Classe para validar os dados inseridos na interface
 * @author Arthur Henrique
 *
 */
public class Validador {

	/**
	 * Valida o nome e cpf do cliente, nome deve conter no minimo 3 letras e cpf deve conter 11 digitos
	 * @param nome String do nome do cliente inserido
	 * @param cpf String do CPF do cliente inserido
	 * @return boolean true para dados correto e false para dados incorretos 
	 */
	public boolean validaCliente(String nome, String cpf) {
		if(nome.length() < 3 || cpf.length() != 11) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * Valida a quantidade de produtos inseridos nas vendas, deve ser inserido valores n�o negativos
	 * @param numPastel Int do valor de pastel vendido
	 * @param numRefri Int do valor de refri vendido
	 * @param numSuco Int do valor de suco vendido
	 * @return boolean true para dados correto e false para dados incorretos 
	 */
	public boolean validaVenda(int numPastel, int numRefri, int numSuco) {
		if(numPastel < 0 || numRefri < 0 || numSuco < 0) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * valida o valor e volume da bebida, deve ser inserido valores n�o negativos
	 * @param preco Int do pre�o da bebida inserido
	 * @param volume Int do volume de bebidas inserido
	 * @return boolean true para dados correto e false para dados incorretos 
	 */
	public boolean validaBebida(float preco, float volume) {
		if(preco < 0 || volume < 0) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * valida o valor do pastel, deve ser inserido valores n�o negativos
	 * @param preco Int do pre�o do pastel inserido
	 * @return boolean true para dados correto e false para dados incorretos 
	 */
	public boolean validaPastel(float preco) {
		if(preco < 0) {
			return false;
		}else {
			return true;
		}
	}

	/**
	 * valida o campo de valores, impedindo que seja inserido valores diferentes de 0 a 9 e o sinal de '.'
	 * @param preco String do JTextField que for inserido nos campos de valores
	 * @return boolean true caso não tenha nenhuma letra ou sinal e false caso tenha
	 */
	public boolean validaFloat(String preco){
		char[] a = preco.toCharArray();
		int verifica = 1;
		if(a[0] == '.'){
				return false;
		}
		for(int i=0; i < preco.length(); i++){
			if(a[i] != '.' && a[i] != '0' && a[i] != '1' && a[i] != '2' && a[i] != '3' && a[i] != '4' && a[i] != '5' && a[i] != '6' && a[i] != '7' && a[i] != '8' && a[i] != '9'){
				verifica = 0;
			}
		}
		if(verifica == 1){
			return true;
		}else{
			return false;
		}
	}
}
