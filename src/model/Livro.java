package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Parte que ira receber dados para cadastrar um livro.
 * 
 * @version 1.0 [Nov 2020]
 * @author Pedro Lucas Siqueira Fernandes
 */

public class Livro implements Serializable {

	// Declaração

	/**
	 * Aqui vai entrar dados como titulo do livro, codigo do livro, quem e o editor
	 * do lviro e um ArrayList de receitas que irao para o livro.
	 * 
	 * @version 1.0 [Nov 2020]
	 * @author Pedro Lucas Siqueira Fernandes
	 */

	private String titulo;
	private int codigo;
	private Editor editorDoLivro;
	private ArrayList<Receita> receita;

	// Declaração de métodos

	public String toString() {
		return this.getTitulo();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Editor getEditorDoLivro() {
		return editorDoLivro;
	}

	public void setEditorDoLivro(Editor editorDoLivro) {
		this.editorDoLivro = editorDoLivro;
	}

	public void receita(Receita receita) {
		this.receita.add(receita);
	}

	public ArrayList<Receita> getReceita() {
		return receita;
	}

	public void setReceita(ArrayList<Receita> receita) {
		this.receita = receita;
	}

	public void impressaoLivro() {
	}

	// Construtor

	public Livro(String titulo, int codigo, Editor editorDoLivro, ArrayList<Receita> receita) {
		this.titulo = titulo;
		this.codigo = codigo;
		this.editorDoLivro = editorDoLivro;
		this.receita = receita;
	}

	public Livro() {
	}
}
