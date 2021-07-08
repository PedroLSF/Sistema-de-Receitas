package model;

import java.io.Serializable;
import java.util.*;

/**
 * Parte que ira receber dados para fazer um teste.
 * 
 * @version 1.0 [Nov 2020]
 * @author Pedro Lucas Siqueira Fernandes
 */

public class Teste implements Serializable {

	// Declaração

	/**
	 * Essas variaveis irao receber um degustador que ira avaliar uma receita e dar
	 * uma nota em uma determinada data.
	 * 
	 * @version 1.0 [Nov 2020]
	 * @author Pedro Lucas Siqueira Fernandes
	 */

	private String dataParaDegustar;
	private double nota;
	private Receita receitaParaDegustar;
	private Degustador degustador;

	public String toString() {
		return this.receitaParaDegustar.getNome();
	}

	public String getDataParaDegustar() {
		return dataParaDegustar;
	}

	public void setDataParaDegustar(String dataParaDegustar) {
		this.dataParaDegustar = dataParaDegustar;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Receita getReceitaParaDegustar() {
		return receitaParaDegustar;
	}

	public void setReceitaParaDegustar(Receita receitaParaDegustar) {
		this.receitaParaDegustar = receitaParaDegustar;
	}

	public Degustador getDegustador() {
		return degustador;
	}

	public void setDegustador(Degustador degustador) {
		this.degustador = degustador;
	}

	// Construtor

	public Teste(String dataParaDegustar, double nota, Receita receitaParaDegustar, Degustador degustador) {
		super();
		this.dataParaDegustar = dataParaDegustar;
		this.nota = nota;
		this.receitaParaDegustar = receitaParaDegustar;
		this.degustador = degustador;
	}

	public Teste() {
	}
}
