package controller;

/** Parte relacionada a arquivos, aqui sera escrito e lido o que o usuario informou
	 * @version 1.0 [Nov 2020]
	 * @author Pedro Lucas Siqueira Fernandes
	 */

import java.awt.GridLayout;
import java.io.*;
import java.text.*;
import java.util.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.html.FormView;

import model.Cozinheiro;
import model.Degustador;
import model.Editor;
import model.Ingrediente;
import model.Livro;
import model.Receita;
import model.Teste;
import view.main;

/**
 * Classe responsavel pelos arquivos, aqui sera escrito e salvo o que o usuario
 * digitar.
 * 
 * @author Pedro Lucas Siqueira Fernandes
 * @version 1.0 [Nov 2020]
 */

public class lerEscrever {

	/**
	 * Este metodo sera responsavel por ver se existe ou esta vazio o file
	 * "CadastroDegustador", e logo em seguida criar caso esteja e escrever.
	 * 
	 * @param degustador para escrever em um arquivo
	 * @author Pedro Lucas Siqueira Fernandes
	 */

	public static void escreverDegustador(Degustador degustador) {
		File fileParaEscrever = new File("CadastroDegustador.ser");
		try {
			if (!fileParaEscrever.exists() || fileParaEscrever.length() == 0) {
				fileParaEscrever.createNewFile();
				FileOutputStream fileDegustador = new FileOutputStream(fileParaEscrever);
				ObjectOutputStream paraEscrever = new ObjectOutputStream(fileDegustador);
				Vector<Degustador> vectorDegustador = new <Degustador>Vector();
				vectorDegustador.add(degustador);
				paraEscrever.writeObject(vectorDegustador);
				paraEscrever.close();
			} else {

				FileInputStream ler = new FileInputStream(fileParaEscrever);
				ObjectInputStream paraLer = new ObjectInputStream(ler);
				Vector<Degustador> vectorLer = (Vector<Degustador>) paraLer.readObject();
				paraLer.close();
				FileOutputStream fileDegustador = new FileOutputStream(fileParaEscrever);
				ObjectOutputStream paraEscrever = new ObjectOutputStream(fileDegustador);
				vectorLer.add(degustador);
				paraEscrever.writeObject(vectorLer);
				paraEscrever.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Este método sera responsavel apenas por ler o Degustador que foi escrito no
	 * método anterior.
	 * 
	 * @author Pedro Lucas Siqueira Fernandes
	 * @return degustador
	 */
	public static Degustador lerDegustador() {
		Degustador degustadorEscolhido = null;
		
		File fileParaLer = new File("CadastroDegustador.ser");
		if (!fileParaLer.exists() || fileParaLer.length() == 0) {
			Vector<Degustador> vectorLer = null;
			JOptionPane.showConfirmDialog(null, "Não há degustador cadastrado", "Erro",
					JOptionPane.OK_CANCEL_OPTION);
		} else {
			try {
				FileInputStream ler = new FileInputStream(fileParaLer);
				ObjectInputStream paraLer = new ObjectInputStream(ler);
				Vector<Degustador> vectorLer = (Vector<Degustador>) paraLer.readObject();
				paraLer.close();
				int tamanho = vectorLer.size();
				Degustador[] listaDeDegustadores = new Degustador[tamanho + 1];
				int i = 0;
				for (Degustador degustador : vectorLer) {
					listaDeDegustadores[i++] = degustador;
				}

				degustadorEscolhido = (Degustador) JOptionPane.showInputDialog(null, "Escolha um Degustador",
						"Lista de Degustadores", JOptionPane.WARNING_MESSAGE, null, listaDeDegustadores, listaDeDegustadores[0]);
				if (degustadorEscolhido == null) {
					main.cadastro();
				}

				else {

					int matricula = degustadorEscolhido.getMatricula();
					int rg = degustadorEscolhido.getRg();
					String nome = degustadorEscolhido.getNome();
					String sexo = degustadorEscolhido.getSexo();
					String dataDeIngresso = degustadorEscolhido.getDataDeIngresso();
					double salarioRecebido = degustadorEscolhido.getSalarioRecebido();
					int testesRealizados = degustadorEscolhido.getTestesRealizados();

					JOptionPane.showConfirmDialog(null,
							"Matricula: " + matricula + "\n" + "RG: " + rg + "\n" + "Nome: " + nome + "\n" + "Sexo: "
									+ sexo + "\n" + "Data de ingresso: " + dataDeIngresso + "\n" + "Salario recebido: "
									+ salarioRecebido + "\n" + "Testes Realizados: " + testesRealizados + "\n",
							"Faça seu cadastro", JOptionPane.OK_CANCEL_OPTION);
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return degustadorEscolhido;
	}

	/**
	 * Este metodo sera responsavel por ver se existe ou esta vazio o file
	 * "CadastroCozinheiro", e logo em seguida criar caso esteja e escrever.
	 * 
	 * @param cozinheiro - para escrever cozinheiro em um arquivo.
	 * @author Pedro Lucas Siqueira Fernandes
	 */

	public static void escreverCozinheiro(Cozinheiro cozinheiro) {
		File fileParaEscrever = new File("CadastroCozinheiro.ser");
		try {
			if (!fileParaEscrever.exists() || fileParaEscrever.length() == 0) {
				fileParaEscrever.createNewFile();
				FileOutputStream fileCozinheiro = new FileOutputStream(fileParaEscrever);
				ObjectOutputStream paraEscrever = new ObjectOutputStream(fileCozinheiro);
				Vector<Cozinheiro> vectorCozinheiro = new <Cozinheiro>Vector();
				vectorCozinheiro.add(cozinheiro);
				paraEscrever.writeObject(vectorCozinheiro);
				paraEscrever.close();
			} else {

				FileInputStream ler = new FileInputStream(fileParaEscrever);
				ObjectInputStream paraLer = new ObjectInputStream(ler);
				Vector<Cozinheiro> vecotrLer = (Vector<Cozinheiro>) paraLer.readObject();
				paraLer.close();
				FileOutputStream fileCozinheiro = new FileOutputStream(fileParaEscrever);
				ObjectOutputStream paraEscrever = new ObjectOutputStream(fileCozinheiro);
				vecotrLer.add(cozinheiro);
				paraEscrever.writeObject(vecotrLer);
				paraEscrever.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Responsavel por mostrar o que o usuario escreveu em CadastroCozinheiro.
	 * 
	 * @author Pedro Lucas Siqueira Fernandes
	 * @return cozinheiro
	 */

	public static Cozinheiro lerCozinheiro() {
		Cozinheiro cozinheiroEscolhido = null;
		File fileParaLer = new File("CadastroCozinheiro.ser");
		if (!fileParaLer.exists() || fileParaLer.length() == 0) {
			Vector<Degustador> vectorLer = null;
			JOptionPane.showConfirmDialog(null, "Não há cozinheiro cadastrado", "Erro",
					JOptionPane.OK_CANCEL_OPTION);
		} else {
			try {
				FileInputStream ler = new FileInputStream(fileParaLer);
				ObjectInputStream paraLer = new ObjectInputStream(ler);
				Vector<Cozinheiro> vectorLer = (Vector<Cozinheiro>) paraLer.readObject();
				paraLer.close();
				int tamanho = vectorLer.size();
				Cozinheiro[] listaDeCozinheiro = new Cozinheiro[tamanho];
				int i = 0;
				for (Cozinheiro cozinheiro : vectorLer) {
					listaDeCozinheiro[i++] = cozinheiro;
				}

				cozinheiroEscolhido = (Cozinheiro) JOptionPane.showInputDialog(null, "Escolha um Cozinheiro",
						"Lista de Cozinheiros", JOptionPane.WARNING_MESSAGE, null, listaDeCozinheiro, listaDeCozinheiro[0]);
				if (cozinheiroEscolhido == null) {
					main.cadastro();
				}

				else {

					int matricula = cozinheiroEscolhido.getMatricula();
					int rg = cozinheiroEscolhido.getRg();
					String nome = cozinheiroEscolhido.getNome();
					String sexo = cozinheiroEscolhido.getSexo();
					String dataDeIngresso = cozinheiroEscolhido.getDataDeIngresso();
					double salarioRecebido = cozinheiroEscolhido.getSalarioRecebido();
					String nomeFantasia = cozinheiroEscolhido.getNomeFantasia();
					String restaurantesTrabalhadosAntigamentes = cozinheiroEscolhido.getRestaurantesTrabalhadosAntigamente();
					String receitasPublicadas = cozinheiroEscolhido.getReceitasPublicadas();
					JOptionPane.showConfirmDialog(null,
							"Matricula: " + matricula + "\n" + "RG: " + rg + "\n" + "Nome: " + nome + "\n" + "Sexo: "
									+ sexo + "\n" + "Data de ingresso: " + dataDeIngresso + "\n" + "Salario recebido: "
									+ salarioRecebido + "\n" + "Nome fantasia: " + nomeFantasia + "\n"
									+ "Restaurantes trabalhados antigamentes: " + restaurantesTrabalhadosAntigamentes
									+ "\n" + "Receitas Publicadas: " + receitasPublicadas,
							"Faça seu cadastro", JOptionPane.OK_CANCEL_OPTION);
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cozinheiroEscolhido;
	}

	/**
	 * Este metodo sera responsavel por ver se existe ou esta vazio o file
	 * "CadastroEditor", e logo em seguida criar caso esteja e escrever.
	 * 
	 * @param editor - para escrever editor em um arquivo
	 * @author Pedro Lucas Siqueira Fernandes
	 */

	public static void escreverEditor(Editor editor) {
		File fileParaEscrever = new File("CadastroEditor.ser");
		try {
			if (!fileParaEscrever.exists() || fileParaEscrever.length() == 0) {
				fileParaEscrever.createNewFile();
				FileOutputStream fileEditor = new FileOutputStream(fileParaEscrever);
				ObjectOutputStream paraEscrever = new ObjectOutputStream(fileEditor);
				Vector<Editor> vectorEditor = new <Editor>Vector();
				vectorEditor.add(editor);
				paraEscrever.writeObject(vectorEditor);
				paraEscrever.close();
			} else {

				FileInputStream ler = new FileInputStream(fileParaEscrever);
				ObjectInputStream paraLer = new ObjectInputStream(ler);
				Vector<Editor> vectorLer = (Vector<Editor>) paraLer.readObject();
				paraLer.close();
				FileOutputStream fileEditor = new FileOutputStream(fileParaEscrever);
				ObjectOutputStream paraEscrever = new ObjectOutputStream(fileEditor);
				vectorLer.add(editor);
				paraEscrever.writeObject(vectorLer);
				paraEscrever.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Responsavel por mostrar na tela o que o usuario escreveu.
	 * 
	 * @author Pedro Lucas Siqueira Fernandes
	 * @return editor
	 */
	
	public static Editor lerEditor() {
		Editor editorEscolhido = null;
		File fileParaLer = new File("CadastroEditor.ser");
		if (!fileParaLer.exists() || fileParaLer.length() == 0) {
			Vector<Cozinheiro> vectorLer = null;
			JOptionPane.showConfirmDialog(null, "Não há editor cadastrado", "Erro",
					JOptionPane.OK_CANCEL_OPTION);
		} else {
			try {

				FileInputStream ler = new FileInputStream(fileParaLer);
				ObjectInputStream paraLer = new ObjectInputStream(ler);
				Vector<Editor> vectorLer = (Vector<Editor>) paraLer.readObject();
				paraLer.close();
				int tamanho = vectorLer.size();
				Editor[] listaDeEditor = new Editor[tamanho + 1];
				int i = 0;
				for (Editor editor : vectorLer) {
					listaDeEditor[i++] = editor;
				}

				editorEscolhido = (Editor) JOptionPane.showInputDialog(null, "Escolha um Editor", "Lista de Editores",
						JOptionPane.WARNING_MESSAGE, null, listaDeEditor, listaDeEditor[0]);

				if (editorEscolhido == null) {
					main.cadastro();
				}

				else {

					int matricula = editorEscolhido.getMatricula();
					int rg = editorEscolhido.getRg();
					String nome = editorEscolhido.getNome();
					String sexo = editorEscolhido.getSexo();
					String dataDeIngresso = editorEscolhido.getDataDeIngresso();
					double salarioRecebido = editorEscolhido.getSalarioRecebido();

					JOptionPane.showConfirmDialog(null,
							"Matricula: " + matricula + "\n" + "RG: " + rg + "\n" + "Nome: " + nome + "\n" + "Sexo: "
									+ sexo + "\n" + "Data de ingresso: " + dataDeIngresso + "\n" + "Salario recebido: "
									+ salarioRecebido + "\n" + "\n",
							"Faça seu cadastro", JOptionPane.OK_CANCEL_OPTION);
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return editorEscolhido;
	}

	/**
	 * Este metodo sera responsavel por ver se existe ou esta vazio o file
	 * "CadastroIngrediente", e logo em seguida criar caso esteja e escrever.
	 * 
	 * @param ingrediente - para escrever ingrediente em um arquivo
	 * @author Pedro Lucas Siqueira Fernandes
	 */

	public static void escreverIngrediente(Ingrediente ingrediente) {
		File fileParaEscrever = new File("CadastroIngrediente.ser");
		try {

			if (!fileParaEscrever.exists() || fileParaEscrever.length() == 0) {
				fileParaEscrever.createNewFile();
				FileOutputStream fileIngrediente = new FileOutputStream(fileParaEscrever);
				ObjectOutputStream paraEscrever = new ObjectOutputStream(fileIngrediente);
				Vector<Ingrediente> vectorIngrediente = new <Ingrediente>Vector();
				vectorIngrediente.add(ingrediente);
				paraEscrever.writeObject(vectorIngrediente);
				paraEscrever.close();
			}

			else {
				FileInputStream ler = new FileInputStream(fileParaEscrever);
				ObjectInputStream paraLer = new ObjectInputStream(ler);
				Vector<Ingrediente> vectorLer = (Vector<Ingrediente>) paraLer.readObject();
				paraLer.close();
				FileOutputStream fileIngrediente = new FileOutputStream(fileParaEscrever);
				ObjectOutputStream paraEscrever = new ObjectOutputStream(fileIngrediente);
				vectorLer.add(ingrediente);
				paraEscrever.writeObject(vectorLer);
				paraEscrever.close();
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Responsavel por mostrar na tela o que o usuario escreveu.
	 * 
	 * @author Pedro Lucas Siqueira Fernandes
	 * @return int
	 */

	public static void lerIngrediente() {
		File fileParaLer = new File("CadastroIngrediente.ser");
		if (!fileParaLer.exists() || fileParaLer.length() == 0) {
			Vector<Ingrediente> vectorLer = null;
			JOptionPane.showConfirmDialog(null, "Não há ingrediente cadastrado", "Erro", JOptionPane.OK_CANCEL_OPTION);
		} else {
			try {

				FileInputStream ler = new FileInputStream(fileParaLer);
				ObjectInputStream paraLer = new ObjectInputStream(ler);
				Vector<Ingrediente> vectorLer = (Vector<Ingrediente>) paraLer.readObject();
				paraLer.close();
				int tamanho = vectorLer.size();
				Ingrediente[] listaDeIngredientes = new Ingrediente[tamanho];
				int i = 0;
				for (Ingrediente ingrediente : vectorLer) {
					listaDeIngredientes[i++] = ingrediente;
				}

				Ingrediente resultado = (Ingrediente) JOptionPane.showInputDialog(null, "Escolha um ingrediente",
						"Lista de Ingredientes", JOptionPane.WARNING_MESSAGE, null, listaDeIngredientes, listaDeIngredientes[0]);
				if (resultado == null) {
					main.criarReceita();
				}

				else {

					String nome = resultado.getNome();
					String dataDeFabricacao = resultado.getDataDeFabricacao();
					String dataDeVencimento = resultado.getDataDeVencimento();
					int quantidadeDeIngrediente = resultado.getQuantidadeDeIngrediente();
					String quantidadeDeMedida = resultado.getQuantidadeMedida();
					String descricao = resultado.getDescricao();
					JOptionPane.showConfirmDialog(null,
							"Nome: " + nome + "\n" + "Data de Fabricacao: " + dataDeFabricacao + "\n"
									+ "Data de Vencimento: " + dataDeVencimento + "\n" + "Quantidade do ingrediente: "
									+ quantidadeDeIngrediente + "\n" + "Quantidade da medida: " + quantidadeDeMedida
									+ "\n" + "Descricao: " + descricao + "\n",
							"Faça seu cadastro", JOptionPane.OK_CANCEL_OPTION);
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Este metodo sera responsavel por ver se existe ou esta vazio o file
	 * "CadastroReceita", e logo em seguida criar caso esteja e escrever.
	 * 
	 * @param receita - para escrever receita em um arquivo
	 * @author Pedro Lucas Siqueira Fernandes
	 */

	public static void escreverReceita(Receita receita) {
		File fileParaEscrever = new File("CadastroReceita.ser");
		try {
			if (!fileParaEscrever.exists() || fileParaEscrever.length() == 0) {
				fileParaEscrever.createNewFile();
				FileOutputStream fileReceita = new FileOutputStream(fileParaEscrever);
				ObjectOutputStream paraEscrever = new ObjectOutputStream(fileReceita);
				Vector<Receita> vectorReceita = new <Receita>Vector();
				vectorReceita.add(receita);
				paraEscrever.writeObject(vectorReceita);
				paraEscrever.close();
			} else {
				FileInputStream ler = new FileInputStream(fileParaEscrever);
				ObjectInputStream paraLer = new ObjectInputStream(ler);
				Vector<Receita> vectorLer = (Vector<Receita>) paraLer.readObject();
				paraLer.close();
				FileOutputStream fileReceita = new FileOutputStream(fileParaEscrever);
				ObjectOutputStream paraEscrever = new ObjectOutputStream(fileReceita);
				vectorLer.add(receita);
				paraEscrever.writeObject(vectorLer);
				paraEscrever.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Responsavel por mostrar a receita escrita.
	 * 
	 * @author Pedro Lucas Siqueira Fernandes
	 * @return resultado
	 */

	public static Receita lerReceita() {
		Receita receitaEscolhida = null;
		File f = new File("CadastroReceita.ser");
		if (!f.exists() || f.length() == 0) {
			Vector<Receita> vectorLer = null;
			JOptionPane.showConfirmDialog(null, "Não há receita cadastrada", "Erro", JOptionPane.OK_CANCEL_OPTION);
		} else {
			try {
				FileInputStream ler = new FileInputStream(f);
				ObjectInputStream paraLer = new ObjectInputStream(ler);
				Vector<Receita> vectorLer = (Vector<Receita>) paraLer.readObject();
				paraLer.close();
				int tamanho = vectorLer.size();
				Receita[] listaDeReceitas = new Receita[tamanho];
				int i = 0;
				for (Receita receitas : vectorLer) {
					listaDeReceitas[i++] = receitas;
				}

				receitaEscolhida = (Receita) JOptionPane.showInputDialog(null, "Escolha uma Receita", "Lista de Receitas",
						JOptionPane.WARNING_MESSAGE, null, listaDeReceitas, listaDeReceitas[0]);
					int codigo = receitaEscolhida.getCodigo();
					String nome = receitaEscolhida.getNome();
					String data = receitaEscolhida.getData();
					String categoria = receitaEscolhida.getCategoria();
					String listaDeIngredientesDaReceita = "";
					ArrayList<Ingrediente> ingredienteEscolhido = receitaEscolhida.getIngredientes();
					for (Ingrediente ingrediente : ingredienteEscolhido) {

						listaDeIngredientesDaReceita = listaDeIngredientesDaReceita + ingrediente.getQuantidadeDeIngrediente() + " ";
						listaDeIngredientesDaReceita = listaDeIngredientesDaReceita + ingrediente.getQuantidadeMedida() + " de ";
						listaDeIngredientesDaReceita = listaDeIngredientesDaReceita + ingrediente.getNome() + "\n";
					}
					String modoDePreparo = receitaEscolhida.getModoDePreparo();
					double porcoesQueRende = receitaEscolhida.getPorcoesQueRende();
					String jaPublicado = receitaEscolhida.getJaPublicado();
					String testeFeito = receitaEscolhida.getTesteFeito();
					Cozinheiro cozinheiro = receitaEscolhida.getCozinheiro();
					JOptionPane.showConfirmDialog(null,
							"Nome: " + nome + "\n" + "Codigo: " + codigo + "\n" + "Data: " + data + "\n" + "Categoria: "
									+ categoria + "\n" + "Porcoes que rende: " + porcoesQueRende + "\n"
									+ "Ja foi publicada: " + jaPublicado + "\n" + "Testes feitos: " + testeFeito + "\n"
									+ "Cozinheiro que fez a receita: " + cozinheiro + "\n" + "Ingredientes: " + "\n"
									+ listaDeIngredientesDaReceita + "\n" + "Modo de Preparo: " + modoDePreparo + "\n",
							"Receita", JOptionPane.OK_CANCEL_OPTION);
				}

			catch (Exception e) {
				e.printStackTrace();
			}
		}

		return receitaEscolhida;
	}

	/**
	 * Este metodo sera responsavel por ver se existe ou esta vazio o file
	 * "CadastroLivro", e logo em seguida criar caso esteja e escrever.
	 * 
	 * @param livro - para escrever livro em um arquivo
	 * @author Pedro Lucas Siqueira Fernandes
	 */

	public static void escreverLivro(Livro livro) {
		File fileParaEscrever = new File("CadastroLivro.ser");
		try {
			if (!fileParaEscrever.exists() || fileParaEscrever.length() == 0) {
				fileParaEscrever.createNewFile();
				FileOutputStream fileLivro = new FileOutputStream(fileParaEscrever);
				ObjectOutputStream paraEscrever = new ObjectOutputStream(fileLivro);
				Vector<Livro> vectorLivro = new <Livro>Vector();
				vectorLivro.add(livro);
				paraEscrever.writeObject(vectorLivro);
				paraEscrever.close();
			}

			else {
				FileInputStream ler = new FileInputStream(fileParaEscrever);
				ObjectInputStream paraLer = new ObjectInputStream(ler);
				Vector<Livro> vler = (Vector<Livro>) paraLer.readObject();
				paraLer.close();
				FileOutputStream fileLivro = new FileOutputStream(fileParaEscrever);
				ObjectOutputStream paraEscrever = new ObjectOutputStream(fileLivro);
				vler.add(livro);
				paraEscrever.writeObject(vler);
				paraEscrever.close();
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Responsavel por mostrar o livro escrito.
	 * 
	 * @author Pedro Lucas Siqueira Fernandes
	 * @return int
	 */
	
	public static void lerLivro() {
		ArrayList<Ingrediente> ingredienteEscolhido = new <Ingrediente>ArrayList();
		File filedParaLer = new File("CadastroLivro.ser");
		if (!filedParaLer.exists() || filedParaLer.length() == 0) {
			Vector<Livro> vectorLer = null;
			JOptionPane.showConfirmDialog(null, "Não há livro cadastrado", "Erro", JOptionPane.OK_CANCEL_OPTION);
		}

		else {
			try {
				FileInputStream ler = new FileInputStream(filedParaLer);
				ObjectInputStream paraEscrever = new ObjectInputStream(ler);
				Vector<Livro> vectorLer = (Vector<Livro>) paraEscrever.readObject();
				paraEscrever.close();
				int tamanho = vectorLer.size();
				Livro[] listaDeLivros = new Livro[tamanho];
				int i = 0;
				for (Livro livro : vectorLer) {
					listaDeLivros[i++] = livro;
				}
				Livro livroEscolhido = (Livro) JOptionPane.showInputDialog(null, "Escolha um Livro", "Lista de Livros",
						JOptionPane.WARNING_MESSAGE, null, listaDeLivros, listaDeLivros[0]);

				if (livroEscolhido == null) {
					main.rodarMenu();
				}

				else {
					int codigo = livroEscolhido.getCodigo();
					String titulo = livroEscolhido.getTitulo();
					Editor editor = livroEscolhido.getEditorDoLivro();
					String listaDeReceitasDoLivro = "";
					ArrayList<Receita> rec = livroEscolhido.getReceita();
					int sair = 1;
					int j = -1;
					int escolha = 0;
					Receita receita = null;
					while (sair != 0) {
						if (j == -1) {
							Object[] options = { "Sair do livro", "Passar uma página" };
							escolha = JOptionPane.showOptionDialog(null,
									"Titulo: " + titulo + "\n" + "Codigo: " + codigo + "\n" + "Editor: " + "\n" + editor
											+ "\n",
									"Livro de Receitas", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
									options, options[0]);
						} else {

							ingredienteEscolhido = receita.getIngredientes();

							for (Ingrediente ingrediente : ingredienteEscolhido) {
								listaDeReceitasDoLivro = listaDeReceitasDoLivro + ingrediente.getQuantidadeDeIngrediente() + " ";
								listaDeReceitasDoLivro = listaDeReceitasDoLivro + ingrediente.getQuantidadeMedida() + " de ";
								listaDeReceitasDoLivro = listaDeReceitasDoLivro + ingrediente.getNome() + "\n";
							}

							listaDeReceitasDoLivro = "Ingredientes: " + "\n" + listaDeReceitasDoLivro + "\n" + "Nome: " + receita.getNome() + "\n"
									+ "Codigo: " + receita.getCodigo() + "\n" + "Data: " + receita.getData() + "\n"
									+ "Categoria: " + receita.getCategoria() + "\n" + "Modo De Preparo: "
									+ receita.getModoDePreparo() + "\n" + "Porcoes que Rende: "
									+ receita.getPorcoesQueRende() + "\n" + "Ja foi Publicado? "
									+ receita.getJaPublicado() + "\n" + "Testes Feitos: " + receita.getTesteFeito()
									+ "\n" + "Cozinheiro: " + receita.getCozinheiro();

							Object[] options = { "Voltar uma página", "Passar uma página" };
							escolha = JOptionPane.showOptionDialog(null, "Receita: " + "\n" + listaDeReceitasDoLivro,
									"Livro de Receitas", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
									options, options[0]);
						}
						if (escolha == 0) {
							j--;
							if (j != -1)
							receita = rec.get(j);
							listaDeReceitasDoLivro = "";
						} else if (escolha == 1) {
							j++;
							rec.size();
							if (j > rec.size() - 1) {
								JOptionPane.showConfirmDialog(null, "Fim do livro", "Livro",
										JOptionPane.OK_CANCEL_OPTION);
								j--;
							}
							receita = rec.get(j);
							listaDeReceitasDoLivro = "";
						} else {
							sair = 0;
						}
					}
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Este metodo sera responsavel por ver se existe ou esta vazio o file
	 * "CadastroTeste", e logo em seguida criar caso esteja e fazer o teste.
	 * 
	 * @param teste - para escrever teste em um arquivo
	 * @author Pedro Lucas Siqueira Fernandes
	 */
	public static void escreverAvaliacao(Teste teste) {
		File fileParaEscrever = new File("CadastroTeste.ser");
		try {
			if (!fileParaEscrever.exists() || fileParaEscrever.length() == 0) {
				fileParaEscrever.createNewFile();
				FileOutputStream fileTeste = new FileOutputStream(fileParaEscrever);
				ObjectOutputStream paraEscrever = new ObjectOutputStream(fileTeste);
				Vector<Teste> vectorTeste = new <Teste>Vector();
				vectorTeste.add(teste);
				paraEscrever.writeObject(vectorTeste);
				paraEscrever.close();
			} else {

				FileInputStream ler = new FileInputStream(fileParaEscrever);
				ObjectInputStream paraLer = new ObjectInputStream(ler);
				Vector<Teste> vectorLer = (Vector<Teste>) paraLer.readObject();
				paraLer.close();
				FileOutputStream fileTeste = new FileOutputStream(fileParaEscrever);
				ObjectOutputStream paraEscrever = new ObjectOutputStream(fileTeste);
				vectorLer.add(teste);
				paraEscrever.writeObject(vectorLer);
				paraEscrever.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Responsavel por mostrar o resultado do teste
	 * 
	 * @author Pedro Lucas Siqueira Fernandes
	 * @return int
	 */

	public static void lerAvaliacao() {
		File fileParaLer = new File("CadastroTeste.ser");
		if (!fileParaLer.exists() || fileParaLer.length() == 0) {
			Vector<Teste> vectorLer = null;
			JOptionPane.showConfirmDialog(null, "Não há Teste cadastrado", "Erro",
					JOptionPane.OK_CANCEL_OPTION);
		} else {
			try {
				FileInputStream ler = new FileInputStream(fileParaLer);
				ObjectInputStream paraLer = new ObjectInputStream(ler);
				Vector<Teste> vectorLer = (Vector<Teste>) paraLer.readObject();
				paraLer.close();
				int tamanho = vectorLer.size();
				Teste[] listaDeTestes = new Teste[tamanho];
				int i = 0;
				for (Teste teste : vectorLer) {
					listaDeTestes[i++] = teste;
				}

				Teste testeEscolhido = (Teste) JOptionPane.showInputDialog(null, "Escolha um teste", "Lista de Testes",
						JOptionPane.WARNING_MESSAGE, null, listaDeTestes, listaDeTestes[0]);
				if (testeEscolhido == null) {
				}

				else {

					Double nota = testeEscolhido.getNota();
					String dataParaDegustar = testeEscolhido.getDataParaDegustar();
					Degustador degustador = testeEscolhido.getDegustador();
					Receita receita = testeEscolhido.getReceitaParaDegustar();
					JOptionPane.showConfirmDialog(null,
							"Degustador: " + degustador + "\n" + "Data Para Degustar: " + dataParaDegustar + "\n"
									+ "Nome da Receita: " + receita + "\n" + "Nota: " + nota + "\n",
							"Teste", JOptionPane.OK_CANCEL_OPTION);
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
