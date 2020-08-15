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
		System.out.println("O g�nero � :" + this.genero);
		System.out.println(" A dura��o � :" + this.getDuracao());
		System.out.println("O n�mero de faixas � :" + this.getNumFaixas());
		System.out.println("A gravadora � :" + this.getGravadora());
		
	}
	
	

}
