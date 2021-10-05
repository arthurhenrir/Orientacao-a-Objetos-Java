package controller;

import model.Fidelidade;
/**
 * Manipula os dados de fidelidade, venda e cliente
 * @author Alex Gabriel
 *
 */
public class ControleFidelidade {
	private  Dados dados;
	/**
	 * Contrutor ControleFidelidade com os dados a ser manipulados
	 * @param dados Dados que serão manipulados 
	 */
	public ControleFidelidade(Dados dados) {
		this.dados = dados;
		
	}
	/**
	 * Obtém os dados de fidelidade e cliente, como nome e cpf do cliente, nivel, pontos e recompensa de fidelidade
	 * @return String[] com os dados de fidelidade e cliente
	 */
	public String[] getFidelidade() {
		String[] fidelidade = new String[dados.nomeClientes.size()];
		int pontos;
		int lvl;
		for(int i = 0; i < dados.nomeClientes.size(); i++) {
			pontos = (dados.vendaPasteis.get(i) * 5) + (dados.vendaRefri.get(i)* 3)+(dados.vendaSuco.get(i)*2); //Calcula 0os pontos do cliente
			dados.Fidelidade.get(i).setPontos(pontos);
			lvl = dados.Fidelidade.get(i).getNivel();
			dados.Fidelidade.get(i).setRecompensa(lvl);//define a recompensa do cliente a partir do nivel 
			fidelidade[i] = (dados.nomeClientes.get(i) + " - " + dados.cpfClientes.get(i) + " Lvl " + dados.Fidelidade.get(i).getNivel() +"("+dados.Fidelidade.get(i).getPontos() 
							+ ") - " + dados.Fidelidade.get(i).getRecompensa());
		}
		return fidelidade;
	}

}
