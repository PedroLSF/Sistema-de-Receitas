package model;

import java.util.Date;

/**
 * Parte que ira receber dados para cadastrar degustador.
 * 
 * @version 1.0 [Nov 2020]
 * @author Pedro Lucas Siqueira Fernandes
 */

public final class Degustador extends Funcionario {

	// Declaração

	/**
	 * Esse atributo ira receber a quantidade de testes que o degustador realizou, e
	 * alem disso ira receber dados de Funcionario.
	 * 
	 * @version 1.0 [Nov 2020]
	 * @author Pedro Lucas Siqueira Fernandes
	 */
	private int testesRealizados;

	// Criação de métodos

	public int getTestesRealizados() {
		return testesRealizados;
	}

	public void setTestesRealizados(int testesRealizados) {
		this.testesRealizados = testesRealizados;
	}

	// Construtor

	public Degustador() {
		super();
	}

	public Degustador(int matricula, int rg, String nome, String sexo, String dataDeIngresso, double salarioRecebido,
			int testesRealizados) {
		super(matricula, rg, nome, sexo, dataDeIngresso, salarioRecebido);
		this.testesRealizados = testesRealizados;
	}

	// Implementação dos métodos abstratos

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
