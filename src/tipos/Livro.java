package tipos;

public class Livro extends Produto { // extends liga uma classe na outra, colocando como classe filha
	private int paginas;
	private String editora;
	
	// Construtor (constroe a classe, � um passo a passo de uma receita, ou algo que deve ser seguido ou montados)
	// Uma das partes mais importantes
	public Livro(String pnome, String pautor, double ppreco, int ppaginas, String peditora) {
		nome 	= pnome;
		autor 	= pautor;
		preco 	= ppreco;
		paginas = ppaginas;
		editora = peditora;
				
	}
	// M�todos variados
	// Retornar todas as informa��esdo produto.
	public String info() {
		String s = "# LIVRO\t"; // \t d� uma TAB em cada tipo
		s += "# " + nome + " \t";
		s += "# " + autor + " \t";
		s += "# " + preco + " \t";
		s += "# " + paginas + " \t";
		
		return s;
						
		
	}
	
	
	
	
	// GET e SET
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int ppaginas) {
		paginas = ppaginas;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String peditora) {
		editora = peditora;
	}
	
	

}
