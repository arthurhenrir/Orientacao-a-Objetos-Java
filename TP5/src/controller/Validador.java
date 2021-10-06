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
	 * Valida a quantidade de produtos inseridos nas vendas, deve ser inserido valores não negativos
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
	 * valida o valor e volume da bebida, deve ser inserido valores não negativos
	 * @param preco Int do preço da bebida inserido
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
	 * valida o valor do pastel, deve ser inserido valores não negativos
	 * @param preco Int do preço do pastel inserido
	 * @return boolean true para dados correto e false para dados incorretos 
	 */
	public boolean validaPastel(float preco) {
		if(preco < 0) {
			return false;
		}else {
			return true;
		}
	}
}
