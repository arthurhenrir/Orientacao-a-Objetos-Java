package model;

public class Bebida extends Produto{

    private String marca;
    private Float volume;

	public Bebida (String nome, String sabor, String marca, Float preco, Float volume){
		this.nome = nome;
		this.sabor = sabor;
		this.marca = marca;
		this.preco = preco;
		this.volume = volume;
	}
	public Bebida(){

	}

	public String toString() {
		return  nome  +" "+ marca + " " +sabor + " "+ volume + "Ml " + ", Preco: "
				+ preco + " Reais";
	}

    //----------Gets and Sets------------
    public String getMarca() {
		return this.marca;
	}
    public void setMarca(String marca) {
		this.marca = marca;
	}

    public Float getVolume() {
		return this.volume;
	}
    public void setVolume(Float volume) {
		this.volume = volume;
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