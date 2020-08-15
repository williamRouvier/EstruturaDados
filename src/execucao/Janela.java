package execucao;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import tipos.Compra;

public class Janela extends JFrame{
	private JLabel lblItem, lblCodigo, lblQtde, lblUnidade, lblDescricao , lblVlUnitario, lblVlTotal;
	private JTextField txtItem, txtCodigo, txtQtde,  txtDescricao,txtVlUnitario, txtVlTotal;
	private JComboBox<String> cmbUnidade;
	private JButton btnSalvar, btnInserir, btnRemover;
	
	//Necessarios para criar uma tabela
	private JScrollPane scroll;
	private JTable tabela;
	private DefaultTableModel dadosTabela;
	
	java.util.List<String> h;
	private ArrayList<Compra> ListaProdutos;
	
	
	
	
	//Construtor
	public Janela(ArrayList<Compra> lista) {
		
		//Recebendo a lista de livros, que estï¿½ na classe Principal
		ListaProdutos = lista;
		
		
		//Definiar algumas opï¿½ï¿½es da janela
		setTitle("Lista de Produtos"); //NOME DA JANELA
		setSize(800,500); //TAMANHO, LARGURA, ALTURA
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null); //sem layout automï¿½tico
		
		
		
		criaComponentes();
		criaAcoes();
		
		//ULTIMA COISA DENTRO DO CONSTRUTOR
		setVisible(true); //EXIBIR A JANELA
	}
	private void criaComponentes() {
		// NOME
		
		lblItem = new JLabel ("SEJA BEM VINDO, É UM PRAZER TELO CONOSCO."
				+ " BOAS COMPRAS E VOLTE SEMPRE !!!");
		lblItem.setBounds(50, 10, 500, 25);
		add(lblItem);		
		
		
		lblItem = new JLabel ("Item");
		lblItem.setBounds(10, 30, 50, 25);
		add(lblItem);

		txtItem= new JTextField();
		txtItem.setBounds(10, 50, 50, 25);
		add(txtItem);
		
		
		lblCodigo = new JLabel ("Código");
		lblCodigo.setBounds(60, 30, 100, 25);
		add(lblCodigo);

		txtCodigo= new JTextField();
		txtCodigo.setBounds(60, 50, 100, 25);
		add(txtCodigo);
		
		
		lblDescricao = new JLabel ("Descrição");
		lblDescricao.setBounds(160, 30, 100, 25);
		add(lblDescricao);
		
		txtDescricao= new JTextField();
		txtDescricao.setBounds(160, 50, 200, 25);
		add(txtDescricao);

		lblUnidade = new JLabel ("Unidade");
		lblUnidade.setBounds(360, 30, 100, 25);
		add(lblUnidade);
		
		cmbUnidade = new JComboBox();
		cmbUnidade.setBounds(360, 50, 150, 25);
		cmbUnidade.addItem("UN");
		cmbUnidade.addItem("KG");
		cmbUnidade.addItem("LT");
		cmbUnidade.addItem("MT");
		cmbUnidade.addItem("M2");
		cmbUnidade.addItem("M3");
		cmbUnidade.addItem("CM");
		cmbUnidade.addItem("PÇA");
		cmbUnidade.addItem("PCTE");
		cmbUnidade.addItem("FD");
		cmbUnidade.addItem("CX");
		cmbUnidade.addItem("ROLO");
		cmbUnidade.addItem("FL");
		
		add(cmbUnidade);

		
		lblQtde = new JLabel ("Qtde");
		lblQtde.setBounds(512, 30, 50, 25);
		add(lblQtde);
		
		txtQtde= new JTextField();
		txtQtde.setBounds(512, 50, 50, 25);
		add(txtQtde);

		
		lblVlUnitario = new JLabel ("Vl.Unitário");
		lblVlUnitario.setBounds(563, 30, 100, 25);
		add(lblVlUnitario);
		
		txtVlUnitario= new JTextField();
		txtVlUnitario.setBounds(563, 50, 100, 25);
		add(txtVlUnitario);
		
		lblVlTotal = new JLabel ("Vl.Total");
		lblVlTotal.setBounds(664, 30, 100, 25);
		add(lblVlTotal);
		
		txtVlTotal= new JTextField();
		txtVlTotal.setBounds(664, 50, 100, 25);
		add(txtVlTotal);
		
		
		//INSERIR
		
		btnInserir = new JButton("Inserir Item");
		btnInserir.setBounds(50, 90, 200, 25);
		add(btnInserir);
		
		//REMOVER
		btnRemover = new JButton("Remover Item");
		btnRemover.setBounds(280, 90, 200, 25);
		add(btnRemover);
		
		
		//Salvar
		btnSalvar = new JButton("Salvar Lista de Compras");
		btnSalvar.setBounds(500, 90, 200, 25);
		add(btnSalvar);
		
		
		
		//TABELA
		
		dadosTabela = new DefaultTableModel();
		dadosTabela.addColumn("Item");
		dadosTabela.addColumn("Código");
		dadosTabela.addColumn("Descrição");
		dadosTabela.addColumn("Unidade");
		dadosTabela.addColumn("Qtde");
		dadosTabela.addColumn("Vl.Unitario");
		dadosTabela.addColumn("Vl.Total");
		
		
		tabela = new JTable(dadosTabela);
		
		scroll = new JScrollPane(tabela);
		scroll.setBounds(10, 120, 765, 300);
		add(scroll);
		
		encheLista();
		
		
		
		
		
	}
	private void criaAcoes() {
		//Salvar um novo Produto na lista
		btnInserir.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("LISTA DE PRODUTOS");
				System.out.println("Item/Código/Descrição/Unidade/Qtde/Vl.Unit./Vl.Total");
				String item = txtItem.getText();
				String codigo = txtCodigo.getText();
				String descricao = txtDescricao.getText();
				String unidade = cmbUnidade.getSelectedItem().toString();
				String qtde = txtQtde.getText();
				String vlunitario = txtVlUnitario.getText();
				String vltotal = txtVlTotal.getText();
				
				
				//Criar um novo Objeto Produto
				Compra novoProduto = new Compra(item, codigo, descricao, unidade,
						qtde, vlunitario, vltotal);
				
				//Adicionar este novo Produto na lista de Produtos
				ListaProdutos.add(novoProduto);
				
				//listarTodosLivros();
				listaParaTabela();
				
								
			}

				
			
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				BufferedWriter bw = null;
				try {
					bw = new BufferedWriter(new FileWriter("produtos.txt"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int i = 0; i < ListaProdutos.size(); i++) {
					Compra itemtabela = ListaProdutos.get(i);
					 //itemtabela.info();
					 String c = itemtabela.toString();
					 System.out.println(c);
					 
					
					 
					 

				        try {
				            
				            bw.write(c);
				            bw.newLine();
				            bw.flush();
				        } catch (IOException ioe) {
				            ioe.printStackTrace();
				        } finally { // always close the file
				            if (bw != null) {
				            }

				}

					
			        
				}
				
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		//Remove um PRODUTO
		btnRemover.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Pega a linha selecionada
				
				int posicao = tabela.getSelectedRow();
				
				if (posicao > -1) {
					ListaProdutos.remove(posicao);
					listaParaTabela();
				}
				
			}
		});
		
	
	}
	public void listaParaTabela() {
		
		//Limpar a tabela antes
		
		for (int i = dadosTabela.getRowCount() - 1; i >=0; i --) {
			dadosTabela.removeRow(i);
		}
		
		for (int i = 0; i < ListaProdutos.size(); i++){
			//Pega o livro atual da lista
			Compra itemtabela = ListaProdutos.get(i);
			
			String[] linha = new String[7];
			linha[0] = itemtabela.getItem();
			linha[1] = itemtabela.getCodigo();
			linha[2] = itemtabela.getDescricao();
			linha[3] = itemtabela.getUnidade();
			linha[4] = itemtabela.getQtde();
			linha[5] = itemtabela.getVlunitario();
			linha[6] = itemtabela.getVltotal();
			
			
			//Adiciona uma nova linha na tabela
			dadosTabela.addRow(linha);
			System.out.println(ListaProdutos.get(i));
			
		}
	}
	
	public void listarTodosLivros() {
			System.out.println("********** PRODUTOS **********");
			for (int i = 0; i < ListaProdutos.size(); i++) {
				Compra itemtabela = ListaProdutos.get(i);
				 itemtabela.info();
				
			}
	
			
		}
	private void encheLista()  {
		ArrayList<String> arrStr = new ArrayList<String>();
		String g ;
		String path = null;
		try {
					
		                                           
		            FileReader fr = new FileReader("produtos.txt");

					BufferedReader br = new BufferedReader(fr);
					String linha = br.readLine();
					while (linha != null) {
						
						String[] array = linha.split("/");
						Compra prod1 = new Compra(array[0], array[1], array[2], array[3], array[4], array[5], array[6]);
						ListaProdutos.add(prod1);
						
						linha = br.readLine();
						
					
					}
					br.close();	
					listaParaTabela();
					
					return;
	
				    
				} catch (FileNotFoundException e1) {

		            System.out.println("O ARQUIVO NÃO FOI ENCONTRADO"+path);
					e1.printStackTrace();
					return;
				} catch (IOException e) {
					System.out.println("ERRO"+path);
					e.printStackTrace();
					return;
				} catch(Exception e){
					System.out.println("ERRO NO ARQUIVO (CAMPOS SEM PREENCHIMENTO: "+path);
					e.printStackTrace();
					return;
				}
	}
}

