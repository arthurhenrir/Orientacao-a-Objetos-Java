package model;
/**
 * classe modelo para o objeto venda
 * @author Arthur Henrique
 *
 */
public class Venda {
	private Cliente cliente = new Cliente();
	/**
	 * Contrutor Venda sem argumentos
	 */
	public Venda(){
		
	}
	/**
	 * Obtém o cliente 
	 * @return Cliente o cliente
	 */
	public Cliente getCliente() {
		return this.cliente;
	}
	/**
	 * Configura o cliente 
	 * @param cliente cliente com o cliente a ser configurado 
	 */
    public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
