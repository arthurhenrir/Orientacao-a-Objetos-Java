package model;
/**
 * Classe pai de bebida e pastel
 * @author Alex Gabriel
 *
 */
public abstract class Produto {
    
    protected String nome, sabor;
    protected Float preco;
    
    //----------Gets and Sets--------------
    /**
     * Obtém o nome
     * @return String que especifica o nome
     */
    public String getNome() {
		return this.nome;
	}
    /**
     * Configura a String nome 
     * @param nome string com o nome a ser configurado 
     */
    public void setNome(String nome) {
		this.nome = nome;
	}
    /**
     * Obtém o sabor
     * @return String que especifica o sabor
     */
    public String getSabor() {
		return this.sabor;
	}
    /**
     * Configura a String sabor 
     * @param sabor string com o sabor a ser configurado 
     */
    public void setSabor(String sabor) {
		this.sabor = sabor;
	}
    /**
     * Obtém o preco
     * @return Float que especifica o preco
     */
     public Float getPreco() {
		return this.preco;
	}
     /**
      * Configura o Float preco 
      * @param preco Float com o preco a ser configurado 
      */
    public void setPreco(Float preco) {
		this.preco = preco;
	}
}