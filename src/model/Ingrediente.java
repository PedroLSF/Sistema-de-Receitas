package model;

import java.io.*;
import java.util.Date;

/**
 * Parte que ira receber dados para cadastrar ingrediente.
 * 
 * @version 1.0 [Nov 2020]
 * @author Pedro Lucas Siqueira Fernandes
 */

public class Ingrediente implements Serializable {

	// Declaração

	/**
	 * Esses atributos recebem os dados de um ingrediente como seu nome, descricao,
	 * data de vencimento e outros dados.
	 * 
	 * @version 1.0 [Nov 2020]
	 * @author Pedro Lucas Siqueira Fernandes
	 */
	private String Nome;
	private String dataDeFabricacao;
	private String dataDeVencimento;
	private int quantidadeDeIngrediente;
	private String quantidadeMedida;
	private String descricao;

	// Criação de métodos

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String toString() {
		return this.getNome();
	}

	public String getDataDeFabricacao() {
		return dataDeFabricacao;
	}

	public void setDataDeFabricacao(String dataDeFabricacao) {
		this.dataDeFabricacao = dataDeFabricacao;
	}

	public String getDataDeVencimento() {
		return dataDeVencimento;
	}

	public void setDataDeVencimento(String dataDeVencimento) {
		this.dataDeVencimento = dataDeVencimento;
	}

	public int getQuantidadeDeIngrediente() {
		return quantidadeDeIngrediente;
	}

	public void setQuantidadeDeIngrediente(int quantidadeDeIngrediente) {
		this.quantidadeDeIngrediente = quantidadeDeIngrediente;
	}

	public String getQuantidadeMedida() {
		return quantidadeMedida;
	}

	public void setQuantidadeMedida(String quantidadeMedida) {
		this.quantidadeMedida = quantidadeMedida;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	// Construtor

	public Ingrediente(String nome, String dataDeFabricacao, String dataDeVencimento, int quantidadeDeIngrediente,
			String quantidadeMedida, String descricao) {
		Nome = nome;
		this.dataDeFabricacao = dataDeFabricacao;
		this.dataDeVencimento = dataDeVencimento;
		this.quantidadeDeIngrediente = quantidadeDeIngrediente;
		this.quantidadeMedida = quantidadeMedida;
		this.descricao = descricao;
	}

	public Ingrediente() {
	}

}
