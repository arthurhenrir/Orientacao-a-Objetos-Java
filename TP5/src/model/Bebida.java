package model;


/**
 * Implementa o modelo do objeto bebida, herda atributos e metodos da classe pai Produto
 * @author Alex Gabriel
 *@version 2.0
 */
public class Bebida extends Produto{

    private String marca;
    private Float volume;
    
    /**
     * Construtor Bebida
     * @param nome o nome da bebida
     * @param sabor o sabor da bebida
     * @param marca a marca da bebida
     * @param preco o preço da bebida em reais
     * @param volume o volume da bebida em ml
     */
	public Bebida (String nome, String sabor, String marca, Float preco, Float volume){
		this.nome = nome;
		this.sabor = sabor;
		this.marca = marca;
		this.preco = preco;
		this.volume = volume;
	}
	/**
	 * Construtor Bebida sem argumentos
	 */
	public Bebida(){
		
	}
	
    //----------Gets and Sets------------
	/**
	 * Obtém a marca 
	 * @return um String especificando o nome da marca
	 */
    public String getMarca() {
		return this.marca;
	}
    /**
     * Configura a marca
     * @param marca nome da marca a ser configurada
     */
    public void setMarca(String marca) {
		this.marca = marca;
	}
    /**
     * Obtém o volume
     * @return um Float que especifica o volume
     */
    public Float getVolume() {
		return this.volume;
	}
   /**
    * Configura o volume
    * @param volume float com o volume a ser configurado
    */
    public void setVolume(Float volume) {
		this.volume = volume;
	}
    /**
     * Obtém o sabor
     * @return um String que especifica o sabor 
     */
	public String getSabor() {
		return this.sabor;
	}
	/**
	 * Configuta o sabor
	 * @param sabor String que recebe o sabor a ser configurado
	 */
    public void setSabor(String sabor) {
		this.sabor = sabor;
	}
    
    /**
     * Obtém o preco 
     * @return um Float que especifica o preco
     */
    public Float getPreco() {
		return this.preco;
	}
    /**
     * Configura o preco
     * @param preco Float que configura o preco
     */
    public void setPreco(Float preco) {
		this.preco = preco;
	}
}