package model;
public class Venda {
	private Cliente cliente = new Cliente();

	public Venda(){
		
	}
	public Cliente getCliente() {
		return this.cliente;
	}
    public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
