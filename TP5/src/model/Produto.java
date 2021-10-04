package model;
public abstract class Produto {
    
    protected String nome, sabor;
    protected Float preco;
    
    //----------Gets and Sets--------------
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
}