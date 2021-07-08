package model;

import java.util.Date;

/**
 * Parte que ira receber dados
 * 
 * @version 1.0 [Nov 2020]
 * @author Pedro Lucas Siqueira Fernandes
 */

public final class Editor extends Funcionario {

	/**
	 * Nao ha atributos aqui, apenas ira receber os de funcionario
	 * 
	 * @version 1.0 [Nov 2020]
	 * @author Pedro Lucas Siqueira Fernandes
	 */

	// Construtor

	public Editor(int matricula, int rg, String nome, String sexo, String dataDeIngresso, double salarioRecebido) {
		super(matricula, rg, nome, sexo, dataDeIngresso, salarioRecebido);
	}

	public Editor() {
	}

	// Implementação de métodos abstratos

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
