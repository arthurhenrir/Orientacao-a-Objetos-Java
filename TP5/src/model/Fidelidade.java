package model;

public class Fidelidade {
    private int pontos, nivel;
    private String recompensa;
    
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
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
	
	public void setNivel(int niveis) {
		this.nivel = niveis;
	}
	public void setRecompensa(int lvl) {
		String recon;
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
	public String getRecompensa() {
		return recompensa;
	}
}