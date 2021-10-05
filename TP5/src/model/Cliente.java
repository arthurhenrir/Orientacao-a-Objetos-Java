package model;
/**
 * Classe modelo para o objeto cliente
 * @author Arthur Henrique 
 *
 */
public class Cliente {
    protected String nome, cpf, qnt;
    /**
     * Contrutor Cliente sem argumentos
     */
	public Cliente(){

	}
	/**
     * Obtém o nome
     * @return String que especifica o nome
     */
	public String getNome() {
		return nome;
	}
	 /**
     * Configura a String nome 
     * @param nome string com o nome a ser configurado 
     */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Obtém o cpf
	 * @return String que especifica o cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * Configura o CPF
	 * @param cpf String com o CPF a ser configurado
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * Obtém quantidade de clientes
	 * @return String Quantidade de clientes 
	 */
	public String getQnt() {
		return qnt;
	}
	/**
	 * Configura a quantidade 
	 * @param qnt String com a quantidade de clientes 
	 */
	public void setQnt(String qnt) {
		this.qnt = qnt;
	}
}
