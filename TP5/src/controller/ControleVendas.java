package controller;
/**
 * Manipula os dados de vendas dos clientes
 * @author Arthur Henrique
 * 
 */
public class ControleVendas {
	public Dados dados;
	/**
	 * Construtor ControleVendas com os dados que serão manipulados 
	 * @param dados Dados a serem manipulados 
	 */
	public ControleVendas(Dados dados) {
		this.dados = dados;
	}
	/**
	 * Classe para pegar os dados de vendas dos clientes
	 * @return vetor da quantidade de cada produto vendido
	 */
	public String[] getVendas() {
		String[] nomes = new String[dados.nomeClientes.size()];
		for(int i = 0; i < dados.nomeClientes.size(); i++) {
			nomes[i] = dados.nomeClientes.get(i) + " - " + dados.cpfClientes.get(i) + " - " + dados.vendaPasteis.get(i) + " Pasteis - " + dados.vendaRefri.get(i) + " Refris - "
					+ dados.vendaSuco.get(i) + " Sucos";
		}
		return nomes;
	}

	/**
	 * Classe para adicionar uma nova venda
	 * @param index posição do arraylist correspondente ao usuario selecionado
	 * @param numPastel quantidade de pasteis que o usuario deseja adicionar
	 * @param numRefri quantidade de refris que o usuario deseja adicionar
	 * @param numSuco quantidade de sucos que o usuario deseja adicionar
	 */
	public void setVenda(int index, int numPastel, int numRefri, int numSuco) {
		dados.vendaPasteis.set(index, dados.vendaPasteis.get(index) + numPastel);
		dados.vendaRefri.set(index,  dados.vendaRefri.get(index) + numRefri);
		dados.vendaSuco.set(index, dados.vendaSuco.get(index) + numSuco);
	}

	/**
	 * Classe para remover produtos vendidos
	 * @param index posição do arraylist correspondente ao usuario selecionado
	 * @param numPastel quantidade de pasteis que o usuario deseja remover
	 * @param numRefri quantidade de refris que o usuario deseja remover
	 * @param numSuco quantidade de sucos que o usuario deseja remover
	 */
	public void remVenda(int index, int numPastel, int numRefri, int numSuco) {
		dados.vendaPasteis.set(index, dados.vendaPasteis.get(index) - numPastel);
		dados.vendaRefri.set(index,  dados.vendaRefri.get(index) - numRefri);
		dados.vendaSuco.set(index, dados.vendaSuco.get(index) - numSuco);
	}
	
	/**
	 * Classe para editar o numero de produtos vendidos
	 * @param index posição do arraylist correspondente ao usuario selecionado
	 * @param numPastel a quantidade de pasteis que o usuario deseja colocar no lugar do valor de antes
	 * @param numRefri a quantidade de refris que o usuario deseja colocar no lugar do valor de antes
	 * @param numSuco a quantidade de sucos que o usuario deseja colocar no lugar do valor de antes
	 */
	public void editVenda(int index, int numPastel, int numRefri, int numSuco) {
		dados.vendaPasteis.set(index, numPastel);
		dados.vendaRefri.set(index,  numRefri);
		dados.vendaSuco.set(index, numSuco);
	}
	
	/**
	 * Obtem o numero de pasteis comprados pelo cliente
	 * @param index posição do arraylist correspondente ao usuario selecionado
	 * @return int do valor de pasteis vendidos
	 */
	public String getPastel(int index){
		String valor = ("" + dados.vendaPasteis.get(index));
		return valor;
	}

	/**
	 * Obtem o numero de refris comprados pelo cliente
	 * @param index posição do arraylist correspondente ao usuario selecionado
	 * @return int do valor de refris vendidos
	 */
	public String getRefri(int index){
		String valor = ("" + dados.vendaRefri.get(index));
		return valor;
	}

	/**
	 * Obtem o numero de sucos comprados pelo cliente
	 * @param index posição do arraylist correspondente ao usuario selecionado
	 * @return int do valor de sucos vendidos
	 */
	public String getSuco(int index){
		String valor = ("" + dados.vendaSuco.get(index));
		return valor;
	}
}
