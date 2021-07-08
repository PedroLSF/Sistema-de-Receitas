package model;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;

import java.io.*;

/**
 * Parte que ira receber dados para cadastrar um cozinheiro
 * 
 * @version 1.0 [Nov 2020]
 * @author Pedro Lucas Siqueira Fernandes
 */

public final class Cozinheiro extends Funcionario implements Serializable {

	// Declaração

	/**
	 * Esses atributos receberao dados de Funcionario e além deles receberao
	 * nomeFantasia, restaurantes que ja trabalharam e tambem receitas publicadas.
	 * 
	 * @version 1.0 [Nov 2020]
	 * @author Pedro Lucas Siqueira Fernandes
	 */

	private String nomeFantasia;
	private String restaurantesTrabalhadosAntigamente;
	private String receitasPublicadas;

	// Criação de Métodos

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRestaurantesTrabalhadosAntigamente() {
		return restaurantesTrabalhadosAntigamente;
	}

	public String getReceitasPublicadas() {
		return receitasPublicadas;
	}

	public void setReceitasPublicadas(String receitasPublicadas) {
		this.receitasPublicadas = receitasPublicadas;
	}

	public void setRestaurantesTrabalhadosAntigamente(String restaurantesTrabalhadosAntigamente) {
		this.restaurantesTrabalhadosAntigamente = restaurantesTrabalhadosAntigamente;
	}

	// Construtor

	public Cozinheiro(int matricula, int rg, String nome, String sexo, String dataDeIngresso, double salarioRecebido,
			String nomeFantasia, String restaurantesTrabalhadosAntigamente, String receitasPublicadas) {
		super(matricula, rg, nome, sexo, dataDeIngresso, salarioRecebido);
		this.nomeFantasia = nomeFantasia;
		this.restaurantesTrabalhadosAntigamente = restaurantesTrabalhadosAntigamente;
		this.receitasPublicadas = receitasPublicadas;
	}

	public Cozinheiro() {
		super();
	}

	// Implementando os métodos abstratos

	public int getMatricula() {
		return matricula;
	}

	void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getRg() {
		return rg;
	}

	void setRg(int rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return this.getNome();
	}

	public String getSexo() {
		return sexo;
	}

	void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataDeIngresso() {
		return dataDeIngresso;
	}

	void setDataDeIngresso(String dataDeIngresso) {
		this.dataDeIngresso = dataDeIngresso;
	}

	public double getSalarioRecebido() {
		return salarioRecebido;
	}

	void setSalarioRecebido(double salarioRecebido) {
		this.salarioRecebido = salarioRecebido;
	}

}