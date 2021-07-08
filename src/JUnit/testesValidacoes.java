package JUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import model.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import view.*;
import org.junit.jupiter.api.Test;

/**
 * Parte que ira receber dados para fazer 3 testes unitarios.
 * 
 * @version 1.0 [Nov 2020]
 * @author Pedro Lucas Siqueira Fernandes
 */

public class testesValidacoes {

	/**
	 * Separei em 2 grupos 1º - Cadastro de Funcionario 2º - Criacao de
	 * itens(Ingredientes,Receita,Livro) Escolhi 1 entre os grupose fiz o teste
	 * unitário do construtor do escolhido.
	 * 
	 * @version 1.0 [Nov 2020]
	 * @author Pedro Lucas Siqueira Fernandes
	 */

	// Variaveis do teste de funcionario - cozinheiro

	private Cozinheiro cozinheiro;
	private int matricula = 0;
	private int rg = 0;
	private String nome = "Pedro";
	private String sexo = "Masculino";
	private String dataDeIngresso = "25/05/2001";
	private double salarioRecebido = 2000;
	private String nomeFantasia = "D'Luca";
	private String restaurantesTrabalhadosAntigamente = "Pedro Lanches";
	private String receitasPublicadas = "Lasanha";

	// Variaveis do teste de Ingrediente

	private Ingrediente ingrediente;
	private String nomeIng = "Acucar";
	private String dataDeFabricacao = "20/10/2001";
	private String dataDeVencimento = "20/12/2001";
	private int quantidadeDeIngrediente = 2;
	private String quantidadeMedida = "Colheres";
	private String descricao = "Para adocar sua vida";

	// Variaveis do teste de Editor

	private Editor editor;
	private int matriculaEditor = 0;
	private int rgEditor = 0;
	private String nomeEditor = "Pedro";
	private String sexoEditor = "Masculino";
	private String dataDeIngressoEditor = "25/05/2001";
	private double salarioRecebidoEditor = 2000;

	@BeforeEach
	public void prepararTesteCozinheiro() {
		cozinheiro = new Cozinheiro(matricula, rg, nome, sexo, dataDeIngresso, salarioRecebido, nomeFantasia,
				restaurantesTrabalhadosAntigamente, receitasPublicadas);
	}

	@BeforeEach
	public void prepararTesteIngrediente() {
		ingrediente = new Ingrediente(nomeIng, dataDeFabricacao, dataDeVencimento, quantidadeDeIngrediente,
				quantidadeMedida, descricao);
	}

	@BeforeEach
	public void prepararTesteEditor() {
		editor = new Editor(matriculaEditor, rgEditor, nomeEditor, sexoEditor, dataDeIngressoEditor, salarioRecebidoEditor);
	}

	@Test
	public void testConstrutorCozinheiro() {
		assertEquals(nome, cozinheiro.getNome());
	}

	@Test
	public void testConstrutorIngrediente() {
		assertEquals(descricao, ingrediente.getDescricao());
	}

	@Test
	public void testConstrutorEditor() {
		assertEquals(rgEditor, editor.getRg());
	}

}
