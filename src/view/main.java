package view;

/** Pacote de interação com o usuario
 * @author Pedro Lucas Siqueira Fernandes
 * @version 1.0 [Nov 2020]
 */

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.lerEscrever;
import model.Cozinheiro;
import model.Degustador;
import model.Editor;
import model.Ingrediente;
import model.Livro;
import model.Receita;
import model.Teste;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * Classe responsável pela interface gráfica e o contato com o usuário
 * 
 * @version 1.0 [Nov 2020]
 * @author sique
 * 
 */

public class main {

	/**
	 * Sera usado apenas 1 método que ira criar ramos para outros metodos
	 */

	public static void main(String[] args) {
		rodarMenu();
	}

	// Criação de métodos

	/**
	 * Neste metodo sera criado a interface para que o usuario cadastre o
	 * Cozinheiro, converta as variaveis, inicialize cozinheiro e chame os metodos
	 * escreverCozinheiro e lerCozinheiro.
	 * 
	 * @author Pedro Lucas Siqueira Fernandes
	 * @return cozinheiro
	 */

	public static Cozinheiro cadastroCozinheiro() {

		// Inicializações

		JTextField campoMatricula = new JTextField(5);
		JTextField campoRg = new JTextField(5);
		JTextField campoNome = new JTextField(5);
		JTextField campoSexo = new JTextField(5);
		JTextField campoDataDeIngresso = new JTextField(5);
		JTextField campoSalarioRecebido = new JTextField(5);
		JTextField campoNomeFantasia = new JTextField(5);
		JTextField campoRestaurantesTrabalhadosAntigamente = new JTextField(5);
		JTextField campoReceitasPublicadas = new JTextField(5);
		Cozinheiro cozinheiro = new Cozinheiro();
		JPanel myPanel = new JPanel();

		int valorDoBotao = 0;
		Object[] funcoes = { "Sim", "Nao" };
		int tipoDoCozinheiro = JOptionPane.showOptionDialog(null, "Voce e um cozinheiro chefe?", "Cadastro",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, funcoes, funcoes[0]);

		if (tipoDoCozinheiro == 0) {
			if (valorDoBotao == 0) {

				myPanel.setLayout(new GridLayout(9, 2));
				myPanel.add(new JLabel("Matricula: "));
				myPanel.add(campoMatricula);
				myPanel.add(new JLabel("RG: "));
				myPanel.add(campoRg);
				myPanel.add(new JLabel("Nome: "));
				myPanel.add(campoNome);
				myPanel.add(new JLabel("Sexo: "));
				myPanel.add(campoSexo);
				myPanel.add(new JLabel("Data de ingresso (dd/mm/yyyy): "));
				myPanel.add(campoDataDeIngresso);
				myPanel.add(new JLabel("Salario Recebido: "));
				myPanel.add(campoSalarioRecebido);
				myPanel.add(new JLabel("Nome Fantasia: "));
				myPanel.add(campoNomeFantasia);
				myPanel.add(new JLabel("Restaurantes Trabalhados Antigamente: "));
				myPanel.add(campoRestaurantesTrabalhadosAntigamente);
				myPanel.add(new JLabel("Receitas Publicadas: "));
				myPanel.add(campoReceitasPublicadas);

				valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Faca seu cadastro",
						JOptionPane.OK_CANCEL_OPTION);

				// Validacao

				int sair = 1;
				while (sair != 0) {

					if (valorDoBotao == 2 || valorDoBotao == -1) {
						sair = 0;
					} else if (campoMatricula.getText().isEmpty() || campoRg.getText().isEmpty()
							|| campoNome.getText().isEmpty() || campoSexo.getText().isEmpty()
							|| campoDataDeIngresso.getText().isEmpty() || campoSalarioRecebido.getText().isEmpty()
							|| campoNomeFantasia.getText().isEmpty() || campoReceitasPublicadas.getText().isEmpty()
							|| campoRestaurantesTrabalhadosAntigamente.getText().isEmpty()) {

						valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Faca seu cadastro",
								JOptionPane.OK_CANCEL_OPTION);
					} else if (valorDoBotao == 0) {
						sair = 0;
					}

				}

				// Conversao

				if (valorDoBotao == 0) {

					int matricula = Integer.parseInt(campoMatricula.getText());
					int rg = Integer.parseInt(campoRg.getText());
					String nome = campoNome.getText();
					String sexo = campoSexo.getText();
					String dataDeIngresso = campoDataDeIngresso.getText();
					Double salarioRecebido = Double.parseDouble(campoSalarioRecebido.getText());
					String nomeFantasia = campoNomeFantasia.getText();
					String receitasPublicadas = campoReceitasPublicadas.getText();
					String restaurantesTrabalhadosAntigamente = campoRestaurantesTrabalhadosAntigamente.getText();
					cozinheiro = new Cozinheiro(matricula, rg, nome, sexo, dataDeIngresso, salarioRecebido,
							nomeFantasia, restaurantesTrabalhadosAntigamente, receitasPublicadas);
					// Arquivos

					lerEscrever.escreverCozinheiro(cozinheiro);

				}
			}
		} else if (tipoDoCozinheiro == 1) {
			if (valorDoBotao == 0) {

				myPanel.setLayout(new GridLayout(8, 2));
				myPanel.add(new JLabel("Matricula: "));
				myPanel.add(campoMatricula);
				myPanel.add(new JLabel("RG: "));
				myPanel.add(campoRg);
				myPanel.add(new JLabel("Nome: "));
				myPanel.add(campoNome);
				myPanel.add(new JLabel("Sexo: "));
				myPanel.add(campoSexo);
				myPanel.add(new JLabel("Data de ingresso (dd/mm/yyyy): "));
				myPanel.add(campoDataDeIngresso);
				myPanel.add(new JLabel("Salario Recebido: "));
				myPanel.add(campoSalarioRecebido);
				myPanel.add(new JLabel("Receitas Publicadas: "));
				myPanel.add(campoReceitasPublicadas);

				valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Faca seu cadastro",
						JOptionPane.OK_CANCEL_OPTION);

				// Validacao

				int sair = 1;

				while (sair != 0) {
					if (valorDoBotao == 2 || valorDoBotao == -1) {
						sair = 0;
					} else if (campoMatricula.getText().isEmpty() || campoRg.getText().isEmpty()
							|| campoNome.getText().isEmpty() || campoSexo.getText().isEmpty()
							|| campoDataDeIngresso.getText().isEmpty() || campoSalarioRecebido.getText().isEmpty()) {

						valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Faca seu cadastro",
								JOptionPane.OK_CANCEL_OPTION);
						System.out.println(valorDoBotao);
					} else if (valorDoBotao == 0) {
						sair = 0;
					}
				}

				// Conversao

				if (valorDoBotao == 0) {

					int matricula = Integer.parseInt(campoMatricula.getText());
					int rg = Integer.parseInt(campoRg.getText());
					String nome = campoNome.getText();
					String sexo = campoSexo.getText();
					String dataDeIngresso = campoDataDeIngresso.getText();
					Double salarioRecebido = Double.parseDouble(campoSalarioRecebido.getText());
					cozinheiro = new Cozinheiro(matricula, rg, nome, sexo, dataDeIngresso, salarioRecebido, null, null,
							null);

					// Arquivos

					lerEscrever.escreverCozinheiro(cozinheiro);

				}
			}
		}
		return cozinheiro;
	}

	/**
	 * Neste metodo sera criado a interface para que o usuario cadastre o
	 * Degustador, converta as variaveis, inicialize degustador e chame os metodos
	 * escreverDegustador e lerDegustador.
	 * 
	 * @author Pedro Lucas Siqueira Fernandes
	 * @return degustador
	 */

	public static Degustador cadastroDegustador() {

		// Inicializações

		JTextField campoMatricula = new JTextField(5);
		JTextField campoRg = new JTextField(5);
		JTextField campoNome = new JTextField(5);
		JTextField campoSexo = new JTextField(5);
		JTextField campoDataDeIngresso = new JTextField(5);
		JTextField campoSalarioRecebido = new JTextField(5);
		JTextField campoTestesRealizados = new JTextField(5);
		JPanel myPanel = new JPanel();

		myPanel.setLayout(new GridLayout(7, 2));
		myPanel.add(new JLabel("Matricula: "));
		myPanel.add(campoMatricula);
		myPanel.add(new JLabel("RG: "));
		myPanel.add(campoRg);
		myPanel.add(new JLabel("Nome: "));
		myPanel.add(campoNome);
		myPanel.add(new JLabel("Sexo: "));
		myPanel.add(campoSexo);
		myPanel.add(new JLabel("Data de ingresso(dd/mm/yyyy): "));
		myPanel.add(campoDataDeIngresso);
		myPanel.add(new JLabel("Salario Recebido: "));
		myPanel.add(campoSalarioRecebido);
		myPanel.add(new JLabel("Testes Realizados: "));
		myPanel.add(campoTestesRealizados);
		int valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Faca seu cadastro",
				JOptionPane.OK_CANCEL_OPTION);

		// Validacao

		int sair = 1;
		while (sair != 0) {

			if (valorDoBotao == 2 || valorDoBotao == -1) {
				sair = 0;
			} else if (campoMatricula.getText().isEmpty() || campoRg.getText().isEmpty()
					|| campoNome.getText().isEmpty() || campoSexo.getText().isEmpty()
					|| campoDataDeIngresso.getText().isEmpty() || campoSalarioRecebido.getText().isEmpty()
					|| campoTestesRealizados.getText().isEmpty()) {

				valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Faca seu cadastro",
						JOptionPane.OK_CANCEL_OPTION);

			} else if (valorDoBotao == 0) {
				sair = 0;
			}

		}

		Degustador degustador = new Degustador();

		// Conversao

		if (valorDoBotao == 0) {

			int matricula = Integer.parseInt(campoMatricula.getText());
			int rg = Integer.parseInt(campoRg.getText());
			String nome = campoNome.getText();
			String sexo = campoSexo.getText();
			String dataDeIngresso = campoDataDeIngresso.getText();
			Double salarioRecebido = Double.parseDouble(campoSalarioRecebido.getText());
			int testesRealizados = Integer.parseInt(campoTestesRealizados.getText());
			degustador = new Degustador(matricula, rg, nome, sexo, dataDeIngresso, salarioRecebido, testesRealizados);

			// Arquivos

			lerEscrever.escreverDegustador(degustador);

		}

		return degustador;
	}

	/**
	 * Neste metodo sera criado a interface para que o usuario cadastre o Editor,
	 * converta as variaveis, inicialize editor e chame os metodos escreverEditor e
	 * lerEditor.
	 * 
	 * @author Pedro Lucas Siqueira Fernandes
	 * @return editor
	 */

	public static Editor cadastroEditor() {

		// Inicializações

		JTextField campoMatricula = new JTextField(5);
		JTextField campoRg = new JTextField(5);
		JTextField campoNome = new JTextField(5);
		JTextField campoSexo = new JTextField(5);
		JTextField campoDataDeIngresso = new JTextField(5);
		JTextField campoSalarioRecebido = new JTextField(5);
		JPanel myPanel = new JPanel();

		myPanel.setLayout(new GridLayout(6, 2));
		myPanel.add(new JLabel("Matricula: "));
		myPanel.add(campoMatricula);
		myPanel.add(new JLabel("RG: "));
		myPanel.add(campoRg);
		myPanel.add(new JLabel("Nome: "));
		myPanel.add(campoNome);
		myPanel.add(new JLabel("Sexo: "));
		myPanel.add(campoSexo);
		myPanel.add(new JLabel("Data de ingresso(dd/mm/yyyy): "));
		myPanel.add(campoDataDeIngresso);
		myPanel.add(new JLabel("Salario Recebido: "));
		myPanel.add(campoSalarioRecebido);

		int valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Faca seu cadastro",
				JOptionPane.OK_CANCEL_OPTION);

		// Validacao

		int sair = 1;

		while (sair != 0) {

			if (valorDoBotao == 2 || valorDoBotao == -1) {
				sair = 0;
			} else if (campoMatricula.getText().isEmpty() || campoRg.getText().isEmpty()
					|| campoNome.getText().isEmpty() || campoSexo.getText().isEmpty()
					|| campoDataDeIngresso.getText().isEmpty() || campoSalarioRecebido.getText().isEmpty()) {

				valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Faça seu cadastro",
						JOptionPane.OK_CANCEL_OPTION);

			} else if (valorDoBotao == 0) {
				sair = 0;
			}

		}

		Editor editor = new Editor();

		// Conversao

		if (valorDoBotao == 0) {

			int matricula = Integer.parseInt(campoMatricula.getText());
			int rg = Integer.parseInt(campoRg.getText());
			String nome = campoNome.getText();
			String sexo = campoSexo.getText();
			String dataDeIngresso = campoDataDeIngresso.getText();
			Double salarioRecebido = Double.parseDouble(campoSalarioRecebido.getText());

			editor = new Editor(matricula, rg, nome, sexo, dataDeIngresso, salarioRecebido);

			// Arquivos

			lerEscrever.escreverEditor(editor);

		}

		return editor;
	}

	/**
	 * Aqui o usuario tera opcoes de escolha entre realizar cadastro de funcionario
	 * ou mostrar a lista dos funcionarios, e para fazer isso sera necessario chamar
	 * outros metodos como por exemplo: mostrarDegustador, cadastroDegustador, entre
	 * outros.
	 * 
	 * @author Pedro Lucas Siqueira Fernandes
	 * @return int
	 */

	public static int cadastro() {
		int valorDoBotao = 0;
		Object[] options = { "Cozinheiro", "Degustador", "Editor", "Mostrar lista de Cozinheiro",
				"Mostrar lista de Degustadores", "Mostrar lista de Editor", "Cancelar" };
		int escolha = JOptionPane.showOptionDialog(null, "Escolha apenas uma opcao", "Qual seu cargo na empresa?",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

		if (escolha == 0) {

			cadastroCozinheiro();
		}

		else if (escolha == 1) {
			cadastroDegustador();
		}

		else if (escolha == 2) {
			cadastroEditor();
		}

		else if (escolha == 3) {
			mostrarCozinheiro();
		}

		else if (escolha == 4) {
			mostrarDegustador();
		}

		else if (escolha == 5) {
			mostrarEditor();
		}

		return valorDoBotao;
	}

	/**
	 * Neste metodo sera responsavel pela primeira tela, para saber a intecao do que
	 * o usuario ira fazer no programa e logo em seguida chamar os metodos
	 * responsaveis pela execucao do desejo do usuario
	 * 
	 * @author Pedro Lucas Siqueira Fernandes
	 * @return int
	 */

	public static int menu() {
		// O que vai querer fazer?
		int valorDoBotao = 0;
		Object[] funcoes = { "Cadastro", "Criar Receita", "Mostrar Livro", "Criar Livro" };
		int funcao = JOptionPane.showOptionDialog(null, "Escolha apenas uma opção", "O que deseja fazer?",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, funcoes, funcoes[0]);

		// Cadastro

		if (funcao == 0) {
			cadastro();
		}

		// Criar Receita

		else if (funcao == 1) {
			criarReceita();
		}

		// Mostrar Livro

		else if (funcao == 2) {
			mostrarLivro();
		}

		// Criar Livro

		else if (funcao == 3) {
			criarLivro();
		}

		// Cancelar operação

		else if (funcao == -1) {
			valorDoBotao = -1;
		}

		return valorDoBotao;
	}

	/**
	 * Responsavel por fazer o menu ficar funcionando ate que se clique no X da
	 * interface grafica.
	 * 
	 * @author Pedro Lucas Siqueira Fernandes
	 */

	public static void rodarMenu() {
		int condicao = menu();
		while (condicao >= 0) {
			condicao = menu();
		}
	}

	/**
	 * Responsavel por criar o ingrediente, o usuario informar os dados do
	 * ingrediente para o livro, converter os atributos, inicializar ingrediente, e
	 * chamar os metodos escreverIngrediente e lerIngrediente
	 * 
	 * @author Pedro Lucas Siqueira Fernandes
	 * @return ingrediente
	 */

	public static Ingrediente criarIngrediente() {

		JTextField campoNomeDoIngrediente = new JTextField(5);
		JTextField campoDataDeFabricacao = new JTextField(5);
		JTextField campoDataDeVencimento = new JTextField(5);
		JTextField campoQuantidadeIngrediente = new JTextField(5);
		JTextField campoQuantidadeMedida = new JTextField(5);
		JTextField campoDescricao = new JTextField(5);
		JPanel myPanel = new JPanel();

		// Criando Ingrediente

		myPanel.setLayout(new GridLayout(6, 2));
		myPanel.add(new JLabel("Nome: "));
		myPanel.add(campoNomeDoIngrediente);
		myPanel.add(new JLabel("Data de Fabricacao(dd/mm/yyyy): "));
		myPanel.add(campoDataDeFabricacao);
		myPanel.add(new JLabel("Data de Vencimento(dd/mm/yyyy): "));
		myPanel.add(campoDataDeVencimento);
		myPanel.add(new JLabel("Quantidade de Ingrediente: "));
		myPanel.add(campoQuantidadeIngrediente);
		myPanel.add(new JLabel("Descreva seu Ingrediente: "));
		myPanel.add(campoDescricao);
		myPanel.add(new JLabel("Medida(Opcional): "));
		myPanel.add(campoQuantidadeMedida);

		int valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Crie seu ingrediente",
				JOptionPane.OK_CANCEL_OPTION);

		// Validacao

		int sair = 1;

		while (sair != 0) {

			if (valorDoBotao == 2 || valorDoBotao == -1) {
				sair = 0;
			} else if (campoNomeDoIngrediente.getText().isEmpty() || campoDataDeFabricacao.getText().isEmpty()
					|| campoDataDeVencimento.getText().isEmpty() || campoQuantidadeIngrediente.getText().isEmpty()
					|| campoDescricao.getText().isEmpty()) {

				valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Crie seu Ingrediente",
						JOptionPane.OK_CANCEL_OPTION);

			} else if (valorDoBotao == 0) {
				sair = 0;
			}

		}

		Ingrediente ingrediente = new Ingrediente();

		// Conversao

		if (valorDoBotao == 0) {
			String nome = campoNomeDoIngrediente.getText();
			String dataDeFabricacao = campoDataDeFabricacao.getText();
			String dataDeVencimento = campoDataDeFabricacao.getText();
			int quantidadeDeIngrediente = Integer.parseInt(campoQuantidadeIngrediente.getText());
			String usaMedida = campoQuantidadeMedida.getText();
			String descricao = campoDescricao.getText();
			ingrediente = new Ingrediente(nome, dataDeFabricacao, dataDeVencimento, quantidadeDeIngrediente, usaMedida,
					descricao);

			// Arquivos

			lerEscrever.escreverIngrediente(ingrediente);

		}

		return ingrediente;
	}

	/**
	 * Responsavel por criar a Receita, o usuario informar os dados da receita para
	 * o livro, converter os atributos, inicializar receita, e chamar os metodos
	 * escreverReceita e lerReceita, tambem sera disponibilizado para a empresa ver
	 * a relacao de ingredientes, fazer avaliacoes e ver relacoes de avaliacoes
	 * 
	 * @author Pedro Lucas Siqueira Fernandes
	 * @return receita
	 */

	public static Receita criarReceita() {

		// Variável

		Receita receita = new Receita();
		Cozinheiro cozinheiro = null;
		int cancelar = 1;
		int valorDoBotao = 0;
		int tipoDeCozinheiro = 0;
		Ingrediente ingrediente;
		ArrayList<Ingrediente> ingredientes = new ArrayList();

		// Inicializações

		JTextField campoCodigo = new JTextField(5);
		JTextField campoNome = new JTextField(5);
		JTextField campoData = new JTextField(5);
		JTextField campoCategoria = new JTextField(5);
		JTextArea campoModoDePreparo = new JTextArea(3, 3);
		JTextField campoPorcoesQueRende = new JTextField(5);
		JTextField campoTesteRealizado = new JTextField(5);
		JPanel myPanel = new JPanel();
		campoModoDePreparo.setLineWrap(true);
		campoModoDePreparo.setWrapStyleWord(true);

		// Criando Receita

		myPanel.setLayout(new GridLayout(0, 1));
		myPanel.add(new JLabel("Código: "));
		myPanel.add(campoCodigo);
		myPanel.add(new JLabel("Nome: "));
		myPanel.add(campoNome);
		myPanel.add(new JLabel("Data: "));
		myPanel.add(campoData);
		myPanel.add(new JLabel("Categoria: "));
		myPanel.add(campoCategoria);
		myPanel.add(new JLabel("Porções que Rende: "));
		myPanel.add(campoPorcoesQueRende);
		myPanel.add(new JLabel("Teste Realizado: "));
		myPanel.add(campoTesteRealizado);
		myPanel.add(new JLabel("Modo de Preparo: "));
		JScrollPane scrollPane = new JScrollPane(campoModoDePreparo, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		myPanel.add(scrollPane);
		scrollPane.setPreferredSize(new Dimension(30, 30));
		while (cancelar != 0) {
			Object[] funcoes = { "Cancelar", "Adicionar Ingrediente", "Mostrar lista de ingredientes",
					"Avaliar Receita", "Mostrar Avaliacao", "Adicionar Cozinheiro", "Criar Receita" };
			valorDoBotao = JOptionPane.showOptionDialog(null, myPanel, "Crie a receita", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE, null, funcoes, funcoes[0]);

			// Validacao

			int sair = 1;
			while (sair != 0) {

				if (valorDoBotao == 0 || valorDoBotao == -1) {
					sair = 0;
					cancelar = 0;
				} else if (valorDoBotao == 1) {
					ingrediente = criarIngrediente();
					ingredientes.add(ingrediente);
					sair = 0;
				} else if (valorDoBotao == 2) {
					mostrarIngrediente();
					sair = 0;
				} else if (valorDoBotao == 3) {
					avaliarReceita();
					sair = 0;
				} else if (valorDoBotao == 4) {
					mostrarAvaliacao();
					sair = 0;
				} else if (valorDoBotao == 5) {
					Object[] f = { "Cadastrar um novo cozinheiro", "Adicionar um existente" };
					tipoDeCozinheiro = JOptionPane.showOptionDialog(null, "Opções", "Escolha uma opção",
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, f, f[0]);
					if (tipoDeCozinheiro == 0) {
						cozinheiro = cadastroCozinheiro();
						sair = 0;
					} else if (tipoDeCozinheiro == 1) {
						cozinheiro = lerEscrever.lerCozinheiro();
						sair = 0;
					}
				} else if (campoCodigo.getText().isEmpty() || campoNome.getText().isEmpty()
						|| campoData.getText().isEmpty() || campoCategoria.getText().isEmpty()
						|| campoPorcoesQueRende.getText().isEmpty() || campoModoDePreparo.getText().isEmpty()
						|| campoTesteRealizado.getText().isEmpty()) {

					valorDoBotao = JOptionPane.showOptionDialog(null, myPanel, "Crie a receita",
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, funcoes, funcoes[0]);

				} else if (valorDoBotao == 6) {
					int codigo = Integer.parseInt(campoCodigo.getText());
					String nome = campoNome.getText();
					String data = campoData.getText();
					String categoria = campoCategoria.getText();
					String modoDePreparo = campoModoDePreparo.getText();
					double porcoesQueRende = Double.parseDouble(campoPorcoesQueRende.getText());
					String testeRealizado = campoTesteRealizado.getText();
					receita = new Receita(codigo, nome, data, categoria, ingredientes, modoDePreparo, porcoesQueRende,
							cozinheiro, null, testeRealizado);

					lerEscrever.escreverReceita(receita);
					sair = 0;
					cancelar = 0;
				}
			}
		}
		return receita;
	}

	/**
	 * Responsavel por criar o Livro, o usuario digita os dados do livro, adicona
	 * receitas, converte as variaveis, mostra as relacoes das receitas e por fim
	 * chama os metodos escreverLivro e lerLivro
	 * 
	 * @author Pedro Lucas Siqueira Fernandes
	 * @return int
	 */

	public static int criarLivro() {

		// Variaveis

		int tipoDeReceita = 0;
		int cancelar = 1;
		int valorDoBotao = 0;
		Receita receita;
		ArrayList<Receita> receitas = new ArrayList();
		Editor editor = null;

		// Inicializações

		JTextField campoTitulo = new JTextField(5);
		JTextField campoCodigo = new JTextField(5);
		JPanel myPanel = new JPanel();

		// Criando Livro

		myPanel.setLayout(new GridLayout(0, 1));
		myPanel.add(new JLabel("Titulo: "));
		myPanel.add(campoTitulo);
		myPanel.add(new JLabel("Codigo: "));
		myPanel.add(campoCodigo);

		while (cancelar != 0) {
			Object[] funcoes = { "Cancelar", "Mostrar lista de receitas", "Adicionar Receita", "Adicionar Editor",
					"Criar" };
			valorDoBotao = JOptionPane.showOptionDialog(null, myPanel, "Crie o Livro", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE, null, funcoes, funcoes[0]);

			// Validacao

			int sair = 1;

			while (sair != 0) {

				if (valorDoBotao == 0 || valorDoBotao == -1) {
					sair = 0;
					cancelar = 0;
				} else if (valorDoBotao == 1) {
					mostrarReceita();
					sair = 0;
				} else if (valorDoBotao == 2) {
					Object[] f = { "Cadastrar uma nova receita", "Adicionar uma existente" };
					tipoDeReceita = JOptionPane.showOptionDialog(null, "Opções", "Escolha uma opção",
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, f, f[0]);
					if (tipoDeReceita == 0) {
						receita = criarReceita();
						receita.setJaPublicado("Nao");
						receitas.add(receita);
						sair = 0;
					} else if (tipoDeReceita == 1) {
						receita = lerEscrever.lerReceita();
						receita.setJaPublicado("Sim");
						receitas.add(receita);
						sair = 0;
					} else {
						sair = 0;
					}
				} else if (valorDoBotao == 3) {
					Object[] f = { "Cadastrar um novo editor", "Adicionar um existente" };
					tipoDeReceita = JOptionPane.showOptionDialog(null, "Opcoes", "Escolha uma opcao",
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, f, f[0]);
					if (tipoDeReceita == 0) {
						editor = cadastroEditor();
						sair = 0;
						cancelar = 1;
					} else if (tipoDeReceita == 1) {
						editor = lerEscrever.lerEditor();
						sair = 0;
						cancelar = 1;
					} else {
						sair = 0;
					}
				} else if (campoCodigo.getText().isEmpty() || campoTitulo.getText().isEmpty()) {

					valorDoBotao = JOptionPane.showOptionDialog(null, myPanel, "Crie a receita",
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, funcoes, funcoes[0]);

				} else if (valorDoBotao == 4) {

					// Conversões

					String titulo = campoTitulo.getText();
					int codigo = Integer.parseInt(campoCodigo.getText());
					Livro livro = new Livro(titulo, codigo, editor, receitas);

					// arquivos

					lerEscrever.escreverLivro(livro);

					sair = 0;
					cancelar = 0;
				}

			}
		}

		return valorDoBotao;
	}

	/**
	 * Responsavel por fazer a avaliacao de Receita, porem nao pode ser realizada
	 * sem ser feita uma receita antes
	 * 
	 * @author Pedro Lucas Siqueira Fernandes
	 * @return int
	 */

	public static void avaliarReceita() {
		Receita receita = null;
		Degustador degustador = null;

		int valorDoBotao = 0;

		// Inicializações

		JTextField campoNota = new JTextField(5);
		JTextField campoDataParaDegustar = new JTextField(5);
		JPanel myPanel = new JPanel();

		myPanel.setLayout(new GridLayout(3, 2));
		myPanel.add(new JLabel("Data Para Degustar: "));
		myPanel.add(campoDataParaDegustar);
		myPanel.add(new JLabel("Nota: "));
		myPanel.add(campoNota);

		int cancelar = 1;
		while (cancelar != 0) {

			Object[] funcoes = { "Cadastrar Degustador", "Adicionar degustador existente", "Adicionar Receita",
					"Avaliar" };
			valorDoBotao = JOptionPane.showOptionDialog(null, myPanel, "Avalie", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE, null, funcoes, funcoes[0]);

			if (valorDoBotao == 0) {
				degustador = cadastroDegustador();
			} else if (valorDoBotao == 1) {
				degustador = lerEscrever.lerDegustador();
			} else if (valorDoBotao == 2) {
				receita = lerEscrever.lerReceita();
			} else if (valorDoBotao == -1) {
				cancelar = 0;
			} else if (valorDoBotao == 3) {

				// Validacao

				int sair = 1;
				while (sair != 0) {

					if (valorDoBotao == -1) {
						sair = 0;
						cancelar = 0;

					} else if (campoDataParaDegustar.getText().isEmpty() || campoNota.getText().isEmpty()) {

						valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Faca a avaliacao",
								JOptionPane.OK_CANCEL_OPTION);

					} else if (valorDoBotao == 3) {
						sair = 0;
						cancelar = 0;
					}
				}

				Teste teste = new Teste();

				if (valorDoBotao == 3) {

					// Conversao

					double nota = Double.parseDouble(campoNota.getText());
					String dataParaDegustar = campoDataParaDegustar.getText();
					teste = new Teste(dataParaDegustar, nota, receita, degustador);

					// Arquivo

					lerEscrever.escreverAvaliacao(teste);

				}
			}
		}
	}

	/**
	 * todos os métodos abaixos são responsáveis por chamarem seus métodos que
	 * mostram tela em lerEscrever, e mostrar suas relacoes.
	 * 
	 * @author Pedro Lucas Siqueira Fernandes
	 */

	public static void mostrarDegustador() {
		lerEscrever.lerDegustador();
	}

	public static void mostrarEditor() {
		lerEscrever.lerEditor();
	}

	public static void mostrarCozinheiro() {
		lerEscrever.lerCozinheiro();
	}

	public static void mostrarIngrediente() {
		lerEscrever.lerIngrediente();
	}

	public static void mostrarReceita() {
		lerEscrever.lerReceita();
	}

	public static void mostrarLivro() {
		lerEscrever.lerLivro();
	}

	public static void mostrarAvaliacao() {
		lerEscrever.lerAvaliacao();
	}
}
