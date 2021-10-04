package model;

public class Pastel extends Produto {
    
  private String ingredientes;

  public Pastel(String nome, String sabor, String ingredientes, Float preco){
      this.nome = nome;
      this.sabor = sabor;
      this.preco = preco;
      this.ingredientes = ingredientes;

  }
  public Pastel(){
    
  }

    //----------Gets and Sets------------
    public String getIngredientes() {
		return this.ingredientes;
	}
    public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

  public String getNome() {
		return this.nome;
	}
    public void setNome(String nome) {
		this.nome = nome;
	}

   public String getSabor() {
		return this.sabor;
	}
    public void setSabor(String sabor) {
		this.sabor = sabor;
	}

     public Float getPreco() {
		return this.preco;
	}

    public void setPreco(Float preco) {
		this.preco = preco;
	}
  
    public String toString() {
		return "Pastel " + nome + ", Sabor " +sabor + "\nFeito com "+ ingredientes + "\nPreco: " + preco + " Reais\n";
	}

}
