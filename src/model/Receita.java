package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Parte que ira receber dados para fazer uma receita.
 * 
 * @version 1.0 [Nov 2020]
 * @author Pedro Lucas Siqueira Fernandes
 */

public class Receita implements Serializable {

	// Declaração

	/**
	 * Esses atributos recebe dados da receita como codigo,nome,data,categoria,
	 * entre outros e depois disso recebe um Cozinheiro e um ArrayList de
	 * ingredientes.
	 * 
	 * @version 1.0 [Nov 2020]
	 * @author Pedro Lucas Siqueira Fernandes
	 */

	private int codigo;
	private String nome;
	private String data;
	private String categoria;
	private ArrayList<Ingrediente> ingredientes;
	private String modoDePreparo;
	private double porcoesQueRende;
	private Cozinheiro cozinheiro;
	private String jaPublicado;
	private String testeFeito;

	// Criação de métodos

	public String toString() {
		return this.getNome();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPorcoesQueRende() {
		return porcoesQueRende;
	}

	public void setPorcoesQueRende(double porcoesQueRende) {
		this.porcoesQueRende = porcoesQueRende;
	}

	public String getModoDePreparo() {
		return modoDePreparo;
	}

	public void setModoDePreparo(String modoDePreparo) {
		this.modoDePreparo = modoDePreparo;
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Cozinheiro getCozinheiro() {
		return cozinheiro;
	}

	public void setCozinheiro(Cozinheiro cozinheiro) {
		this.cozinheiro = cozinheiro;
	}

	public String getJaPublicado() {
		return jaPublicado;
	}

	public void setJaPublicado(String jaPublicado) {
		this.jaPublicado = jaPublicado;
	}

	public String getTesteFeito() {
		return testeFeito;
	}

	public void setTesteFeito(String testeFeito) {
		this.testeFeito = testeFeito;
	}

	// Construtor

	public Receita(int codigo, String nome, String data, String categoria, ArrayList<Ingrediente> ingredientes,
			String modoDePreparo, double pocoesQueRende, Cozinheiro cozinheiro, String jaPublicado, String testeFeito) {
		this.codigo = codigo;
		this.nome = nome;
		this.data = data;
		this.categoria = categoria;
		this.ingredientes = ingredientes;
		this.modoDePreparo = modoDePreparo;
		this.porcoesQueRende = pocoesQueRende;
		this.cozinheiro = cozinheiro;
		this.jaPublicado = jaPublicado;
		this.testeFeito = testeFeito;
	}

	public Receita() {
	}

}
