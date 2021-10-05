package model;
/**
 * Implementa o modelo do objeto pastel, herda atributos e metodos da classe pai Produto
 * @author Alex Gabriel
 *
 */
public class Pastel extends Produto {
	private String ingredientes;
	
	/**
	 * Construtor Pastel
	 * @param nome nome do pastel
	 * @param sabor sabor do pastel
	 * @param ingredientes ingredientes do pastel
	 * @param preco preco do pastel
	 */
	 public Pastel(String nome, String sabor, String ingredientes, Float preco){
		 this.nome = nome;
	     this.sabor = sabor;
	     this.preco = preco;
	     this.ingredientes = ingredientes;
	
	 }
	 /**
	  * Construtor Pastel sem argumentos
	  */
	 public Pastel(){
	   
	 }
	
     //----------Gets and Sets------------
  
  	 /**
  	  * Obtém os ingredientes 
  	  * @return String que espercifica os ingrediemntes; 
  	  */
     public String getIngredientes() {
		 return this.ingredientes;
	 }
     /**
      * Configura a String ingredientes 
      * @param ingredientes string com os ingredientes a ser configurado 
      */
     public void setIngredientes(String ingredientes) {
	 	this.ingredientes = ingredientes;
	 }
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
