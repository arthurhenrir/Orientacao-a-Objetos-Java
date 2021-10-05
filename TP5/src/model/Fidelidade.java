package model;
/**
 * Classe modelo do objeto fidelidade 
 * @author Arthut Henrique
 *
 */
public class Fidelidade {
    private int pontos, nivel;
    private String recompensa;
    
    /**
     * Obtém os pontos
     * @return int que especifica os pontos
     */
	public int getPontos() {
		return pontos;
	}
	/**
	 * Configura os pontos
	 * @param pontos int com os pontos a ser configurado
	 */
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	/**
	 * Obtém o nivel a partir dos pontos
	 * @return nivel int com o nivel de fidelidade
	 */
	public int getNivel() {
		 if(pontos < 21){
			 nivel = 1;    
         }else {
        	 if(pontos < 41){
        		 nivel =  2;   
        	 }else {
        		 if(pontos < 61){
                	 nivel = 3;
        		 }else {
        			 if(pontos < 81) {
        	        	 nivel = 4;
        			 }else {
        				 nivel = 5;
        			 }
        		 }
        	 }
         }
 
		return nivel;
	}
	/**
	 * Configura o nivel 
	 * @param niveis int com o nivel a ser configurado
	 */
	public void setNivel(int niveis) {
		this.nivel = niveis;
	}
	/**
	 * configura a recompensa a partor do nivel de fidelidade
	 * @param lvl int com o nivel a ser utilizado para configurar a recompensa
	 */
	public void setRecompensa(int lvl) {
		String recon;//variavel interna que armazena a recompensa a partir do nivel
		switch (lvl) {
			case 1:
				recon = "5% de desconto";
				break;
			case 2:
				recon = "10% de desconto";
				break;
			case 3:
				recon = "10% de desconto e cupom 5R$";
				break;
			case 4:
				recon = "15% de desconto";
				break;
			case 5:
				recon = "15% de desconto e cupom 20R$ ";
				break;
			default:
				recon = null;		
		}
		this.recompensa = recon;
	}
	/**
	 * Obtém a recompensa
	 * @return String que especifica a recompensa 
	 */
	public String getRecompensa() {
		return recompensa;
	}
}