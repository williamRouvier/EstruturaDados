package tipos;

public class Compra {
	protected String item;
	protected String unidade;
	protected String codigo;
	protected String qtde;
	protected String descricao;
	protected String vlunitario;
	protected String vltotal;
	
	
	public Compra(String item, String codigo, String descricao, String unidade, String qtde, String vlunitario, String vltotal) {
		
		this.item = item;
		this.codigo = codigo;
		this.descricao = descricao;
		this.unidade = unidade;
		this.qtde = qtde;
		this.vlunitario = vlunitario;
		this.vltotal = vltotal;
		
	}

	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getQtde() {
		return qtde;
	}
	public void setQtde(String qtde) {
		this.qtde = qtde;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getVlunitario() {
		return vlunitario;
	}
	public void setVlunitario(String vlunitario) {
		this.vlunitario = vlunitario;
	}
	public String getVltotal() {
		return vltotal;
	}
	public void setVltotal(String vltotal) {
		this.vltotal = vltotal;
	}
	public void  info() {
		System.out.println("Item: " + this.getItem());
		System.out.println("Código: " + this.getCodigo());
		System.out.println("Descrição: " + this.getDescricao());
		System.out.println("Unidade: " + this.getUnidade());
		System.out.println("Qtde: " + this.getQtde());
		System.out.println("Vl.Unit: " + this.getVlunitario());
		System.out.println("Vl.Total: " + this.getVltotal());
		System.out.println("*************************************");
	}
	
	public String toString() {
		String a = this.getItem() + "/"+this.getCodigo()+ "/"+this.getDescricao() +"/"+this.getUnidade()+"/"+ this.getQtde()+ "/"+this.getVlunitario()+"/" +this.getVltotal()+"/";
		
		return a;
		
	}
	
}
