package model;

import java.util.Date;
import java.io.*;
import javax.swing.JTextField;

/**
 * Parte que ira receber dados para repassar para cozinheiro/degustador/editor.
 * 
 * @version 1.0 [Nov 2020]
 * @author Pedro Lucas Siqueira Fernandes
 */

abstract class Funcionario implements Serializable {

	// Declaração

	/**
	 * Esses atributos irao receber dados e os dados serao enviados para
	 * Cozinheiro/Degustador/Editor.
	 * 
	 * @author Pedro Lucas Siqueira Fernandes
	 */
	protected int matricula;
	protected int rg;
	protected String nome;
	protected String sexo;
	protected String dataDeIngresso;
	protected double salarioRecebido;

	// Criação dos métodos

	abstract int getMatricula();

	abstract void setMatricula(int matricula);

	abstract int getRg();

	abstract void setRg(int rg);

	abstract String getNome();

	abstract void setNome(String nome);

	abstract String getSexo();

	abstract void setSexo(String sexo);

	abstract String getDataDeIngresso();

	abstract void setDataDeIngresso(String dataDeIngresso);

	abstract double getSalarioRecebido();

	abstract void setSalarioRecebido(double salarioRecebido);

	// Construtor

	public Funcionario(int matricula, int rg, String nome, String sexo, String dataDeIngresso, double salarioRecebido) {
		super();
		this.matricula = matricula;
		this.rg = rg;
		this.nome = nome;
		this.sexo = sexo;
		this.dataDeIngresso = dataDeIngresso;
		this.salarioRecebido = salarioRecebido;
	}

	public Funcionario() {

	}

}
