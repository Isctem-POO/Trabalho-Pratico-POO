import java.io.*;
import java.text.DecimalFormat;

public class TrabalhoPratico1 {

	public static void main(String[] args) throws IOException {
		menu();

	}

	public static void menu() throws IOException {
		char tiposeguro = 0, tipoCobertura = 0;
		boolean voltar = false;
		int opcao = 0, nviaturas = 0, ndependentes = 0, ncolaboradores = 0, telefone = 870022033;
		float contA = 0, contSaude = 0, vp = 0, contV = 0, vtA = 0, vtSaude = 0, vtV = 0, vtrecebido = 0, contT = 0,
				contR = 0, contC = 0, contS = 0, vtT = 0, vtR = 0, vtC = 0, vtS = 0;

		do {
			opcao = opcoesMenu();

			switch (opcao) {
			case 1:
				tiposeguro = tipodeseguro();
				System.out.println(tiposeguro);
				tipoCobertura = submenu(tiposeguro);
				if (tipoCobertura == 'V')
					voltar = true;

				switch (tiposeguro) {
				case 'A':

					if (voltar == false) {
						telefone = telefone();
						System.out.println("Introduza o numero de  viaturas");
						nviaturas = validarInt(10000000);

					} // do if
					break;
				case 'V':
					if (voltar == false) {
						System.out.println("Introduza o numero de dependentes");
						ndependentes = validarInt(10);

					} // do if
					break;
				case 'S':
					if (voltar == false) {

						switch (tipoCobertura) {
						case 'C':
							contC++;
							vtC += vp;
							break;
						case 'S':
							contS++;
							vtS += vp;
							break;
						}
					} // do if
					break;
				}// primeiro switch
				break;
			case 2:
				switch (tiposeguro) {
				case 'A':
					vp = valorpagar(tiposeguro, tipoCobertura, nviaturas, ndependentes, ncolaboradores);
					contA++;
					vtA += vp;

					switch (tipoCobertura) {
					case 'T':
						contT++;
						vtT += vp;
						break;
					case 'R':
						contR++;
						vtR += vp;
						break;
					}
					visualizacaoTabelaViatura(telefone, tiposeguro, nviaturas, tipoCobertura, vp);
					break;
				case 'V':
					vp = valorpagar(tiposeguro, tipoCobertura, nviaturas, ndependentes, ncolaboradores);
					vtV += vp;
					contV++;
					visualizacaoTabelaVida(telefone, tiposeguro, ndependentes, vp);
					break;
				case 'S':
					vp = valorpagar(tiposeguro, tipoCobertura, nviaturas, ndependentes, ncolaboradores);

					switch (tipoCobertura) {
					case 'C':
						contC++;
						vtC += vp;
						break;
					case 'S':
						contS++;
						vtS += vp;
						break;
					}
					visualizacaoTabelaSaude(telefone, tiposeguro, ncolaboradores, tipoCobertura, vp);

					break;
				}

			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				System.out.println(
						"Hasbion Adamgee, estudante do 1o ano do curso de Engenharia Informatica, turma B.  \nLuana Wanga, estudante do 1o ano do curso de Engenharia Informatica, turma B"
								+ " \nSuely Buque, estudante do 1o ano do curso de Engenharia Informatica, turma B");
				break;
			case 8:
				System.out.println("Obrigado! Volte sempre. ");
				break;
			}
		} while (opcao != 8);

	}// do metodo

	public static char submenu(char tiposeguro) throws IOException {

		char op = 0;

		switch (tiposeguro) {
		case 'A':
			System.out.println(
					"Introduza o tipo de cobertura \n[T] - Contra terceiros e ocupantes \n[R] - Contra todos os riscos \n[V]- Voltar ao menu principal ");
			op = validarChar1('T', 'R', 'V');
			break;
		case 'V':
			System.out.println("[I]-Introduzir o numero de dependentes \n[V]- Voltar ao menu principal");
			op = validarChar('I', 'V');
			break;
		case 'S':
			System.out.println(
					"Introduza o tipo de cobertura \n[C] - Com cobertura de evacuacao   \n[S] - Sem cobertura de evacuacao \n[V]- Voltar ao menu principal");
			op = validarChar1('C', 'S', 'V');
			break;
		}
		return op;
	}

	public static char validarChar1(char a, char b, char c) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char tipoCobertura;
		do {
			tipoCobertura = Character.toUpperCase(br.readLine().charAt(0));
			if (tipoCobertura != a && tipoCobertura != b && tipoCobertura != c)
				System.out.println("Tipo invalido! Tente novamente.");
		} while (tipoCobertura != a && tipoCobertura != b && tipoCobertura != c);

		return tipoCobertura;
	}

	public static void visualizacaoTabelaViatura(int telefone, char tiposeguro, int nviaturas, char tipoCobertura, float valorpagar) {
		DecimalFormat mt = new DecimalFormat("###,###,###,###.00 Mts");
		System.out.println("=========================================================================================");
		System.out.printf("%-15s %-10s %-15s %-15s %-15s%n", "Telefone |", "Tipo de Seguro |", "No. Viaturas |",
				"Tipo de Cobertura |", "Valor a pagar (mt) |");
		System.out.printf("%-15s %16s %14s %20s %20s%n", telefone + "|", tiposeguro + "|", nviaturas + "|",
				tipoCobertura + "|", mt.format(valorpagar) + "|");
		System.out.println("=========================================================================================");
	}

	public static void visualizacaoTabelaVida(int telefone, char tiposeguro, int ndependentes, float valorpagar) {
		DecimalFormat mt = new DecimalFormat("###,###,###,###.00 Mts");
		System.out.println("=========================================================================================");
		System.out.printf("%-15s %-10s %-15s  %-15s%n", "Telefone |", "Tipo de Seguro |", "No. Viaturas |",
				"Valor a pagar (mt) |");
		System.out.printf("%-15s %16s %14s  %20s%n", telefone + "|", tiposeguro + "|", ndependentes + "|",
				mt.format(valorpagar) + "|");
		System.out.println("=========================================================================================");
	}
	
	public static void visualizacaoTabelaSaude(int telefone, char tiposeguro, int ncolaboradores, char tipoCobertura, float valorpagar) {
		DecimalFormat mt = new DecimalFormat("###,###,###,###.00 Mts");
		System.out.println("=========================================================================================");
		System.out.printf("%-15s %-10s %-15s %-15s %-15s%n", "Telefone |", "Tipo de Seguro |", "No. Viaturas |",
				"Tipo de Cobertura |", "Valor a pagar (mt) |");
		System.out.printf("%-15s %16s %14s %20s %20s%n", telefone + "|", tiposeguro + "|", ncolaboradores + "|",
				tipoCobertura + "|", mt.format(valorpagar) + "|");
		System.out.println("=========================================================================================");
	}

	public static int opcoesMenu() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int opcao;

		do {
			System.out.println(
					"  Bem vindo/a a Global Aliance Seguros \n***MENU*** \nSelecione uma opcao para prosseguir");
			System.out.println(
					"1)Introduzir dados e visualizar o valor a pagar \n2) Visualizar a quantidade de assegurados feitos por cada tipo de seguro."
							+ "\n3) Visualizar o valor total obtido por cada tipo de seguro. \n4) Visualizar o tipo de cobertura mais aderido, inclusive o valor total que arrecadou. \n5) Visualizar o tipo de seguro que menos facturou."
							+ "\n6) Visualizar o valor total recebido pela Global Aliance Seguros. \n7) Visualizar os dados do programador.\n8) Sair do programa");
			opcao = Integer.parseInt(br.readLine());
			if (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5 && opcao != 6 && opcao != 7
					&& opcao != 8)
				System.out.println("Opcao invalida! Tente novamente.");
		} while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5 && opcao != 6 && opcao != 7
				&& opcao != 8);

		return opcao;
	}

	public static char tipodeseguro() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char tp;

		do {
			System.out.println(
					"Introduza o tipo de seguro  \n[A]- Seguro Automovel \n[V]- Seguro de vida \n[S]- Seguro de Acidente de Trabalho");
			tp = Character.toUpperCase(br.readLine().charAt(0));

			if (tp != 'A' && tp != 'V' && tp != 'S')
				System.out.println("Tipo invalido! Por favor,  tente novamente.");
		} while (tp != 'A' && tp != 'V' && tp != 'S');

		return tp;
	}

	public static int telefone() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int telefone;

		do {
			System.out.println("Introduza o contacto telefonico (9 digitos)");
			telefone = Integer.parseInt(br.readLine());

			if (telefone < 820000000 || telefone > 880000000)
				System.out.println("Contacto Invalido! Por favor, tente novamente.");

		} while (telefone < 820000000 || telefone > 880000000);

		return telefone;
	}

	public static char validarChar(char a, char b) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char tipoCobertura;
		do {
			tipoCobertura = Character.toUpperCase(br.readLine().charAt(0));
			if (tipoCobertura != a && tipoCobertura != b)
				System.out.println("Tipo invalido! Tente novamente.");
		} while (tipoCobertura != a && tipoCobertura != b);

		return tipoCobertura;
	}

	public static float valorpagar(char tipodeseguro, char tipoCobertura, int nviaturas, int ndependentes,
			int ncolaboradores) {
		float vp = 0, desconto = 0, imposto = 0, cob = 0;
		final float SAUDE = 15 / 100f, SVIDA = 1 / 100f, AUTO_DESCONTO = 10 / 100f, VIDA_DESCONTO = 15 / 100f,
				DESCONTO_SAUDE = 10 / 100f, IMPOSTO = 10 / 100f;
		final int TERCEIROS = 4000, RISCOS = 10000, VIDA = 50000000, C_EVACUACAO = 2000000000, S_EVACUACAO = 80000000;

		switch (tipodeseguro) {
		case 'A':
			switch (tipoCobertura) {
			case 'T':
				vp = nviaturas * TERCEIROS;
				break;
			case 'R':
				vp = nviaturas * RISCOS;
				break;
			}

			if (nviaturas > 10) {
				desconto = vp * AUTO_DESCONTO;
			}
			break;
		case 'V':
			cob = VIDA * SVIDA;
			vp = cob / ndependentes;

			if (ndependentes > 5) {
				desconto = vp * VIDA_DESCONTO;
			}
			break;

		case 'S':
			switch (tipoCobertura) {
			case 'C':
				vp = C_EVACUACAO / ncolaboradores;
				break;
			case 'S':
				vp = S_EVACUACAO / ncolaboradores;
				break;
			}

			if (ncolaboradores > 600) {
				desconto = vp * DESCONTO_SAUDE;
			}
			break;
		}

		vp -= desconto;
		imposto = vp * IMPOSTO;
		vp += imposto;

		return vp;
	}

	public static int validarInt(int a) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int val;

		do {
			val = Integer.parseInt(br.readLine());

			if (val <= 0 || val > a)
				System.out.println("Numero invalido! Tente novamente.");
		} while (val <= 0 || val > a);

		return val;
	}

}
