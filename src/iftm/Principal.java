package iftm;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import execucao.Janela;
import tipos.Compra;


public class Principal {

	
		private ArrayList<Compra>ListaProdutos;
		
		
		
		
		//Construtor
		public Principal() {
			ListaProdutos = new ArrayList();
			
			
			Janela janProduto = new Janela(ListaProdutos);

		}
		//Todo o sistema vai ser inicializado a partir deste metodo
		public static void main (String[] args) {
			Principal app = new Principal();
			
			
			
				
		}			
}		
