package tipos;

public class CD extends DVD {
	private  int numFaixas;
	private String gravadora;
	
	public CD(String genero, int duracao, int numFaixas, String gravadora) {
	
		this.genero = genero;
		this.duracao = duracao;
		this.numFaixas = numFaixas;
		this.gravadora = gravadora;
	}
	public int getNumFaixas() {
		return numFaixas;
	}
	public void setNumFaixas(int numFaixas) {
		this.numFaixas = numFaixas;
	}
	public String getGravadora() {
		return gravadora;
	}
	public void setGravadora(String gravadora) {
		this.gravadora = gravadora;
	}
	
	public void Info() {
		System.out.println("O gênero é :" + this.genero);
		System.out.println(" A duração é :" + this.getDuracao());
		System.out.println("O número de faixas é :" + this.getNumFaixas());
		System.out.println("A gravadora é :" + this.getGravadora());
		
	}
	
	

}
