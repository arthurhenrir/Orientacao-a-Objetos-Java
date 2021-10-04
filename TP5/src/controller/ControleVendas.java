package controller;

public class ControleVendas {
	public Dados dados;
	
	public ControleVendas(Dados dados) {
		this.dados = dados;
	}
	
	public String[] getVendas() {
		String[] nomes = new String[dados.nomeClientes.size()];
		for(int i = 0; i < dados.nomeClientes.size(); i++) {
			nomes[i] = dados.nomeClientes.get(i) + " - " + dados.cpfClientes.get(i) + " - " + dados.vendaPasteis.get(i) + " Pasteis - " + dados.vendaRefri.get(i) + " Refris - "
					+ dados.vendaSuco.get(i) + " Sucos";
		}
		return nomes;
	}

	public void setVenda(int index, int numPastel, int numRefri, int numSuco) {
		dados.vendaPasteis.set(index, dados.vendaPasteis.get(index) + numPastel);
		dados.vendaRefri.set(index,  dados.vendaRefri.get(index) + numRefri);
		dados.vendaSuco.set(index, dados.vendaSuco.get(index) + numSuco);
	}

	public void remVenda(int index, int numPastel, int numRefri, int numSuco) {
		dados.vendaPasteis.set(index, dados.vendaPasteis.get(index) - numPastel);
		dados.vendaRefri.set(index,  dados.vendaRefri.get(index) - numRefri);
		dados.vendaSuco.set(index, dados.vendaSuco.get(index) - numSuco);
	}

	public void editVenda(int index, int numPastel, int numRefri, int numSuco) {
		dados.vendaPasteis.set(index, numPastel);
		dados.vendaRefri.set(index,  numRefri);
		dados.vendaSuco.set(index, numSuco);
	}
	
	public String getPastel(int index){
		String valor = ("" + dados.vendaPasteis.get(index));
		return valor;
	}

	public String getRefri(int index){
		String valor = ("" + dados.vendaRefri.get(index));
		return valor;
	}

	public String getSuco(int index){
		String valor = ("" + dados.vendaSuco.get(index));
		return valor;
	}
}
