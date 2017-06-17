package br.ufsc.ine5605.trab1;

import br.ufsc.ine5605.trab1.controllers.ControladorFuncionario;
import br.ufsc.ine5605.trab1.controllers.ControladorVeiculo;
import br.ufsc.ine5605.trab1.objects.Funcionario;
import br.ufsc.ine5605.trab1.objects.Veiculo;

public class Injection {

	private static Injection injector;

	// Injection method

	public void injetarCadastros() {

		Veiculo v = new Veiculo("abc-0123", "Gol", "Volkswagen", 1990, 10);
		Funcionario f = new Funcionario("1620", "Marcelo Brosowicz de Paulo", "19/10/1998", "(48) 9 8832-2655");
		Veiculo v2 = new Veiculo("abc-1234", "Golf", "Volkswagen", 2000, 10);
		Funcionario f2 = new Funcionario("1621", "Jona", "01/07/1990", "8585-8585");
		Veiculo v3 = new Veiculo("abc-2345", "Fox", "Volkswagen", 2005, 10);
		Funcionario f3 = new Funcionario("1622", "Noas", "01/07/1991", "8585-8185");
		Veiculo v4 = new Veiculo("mar-0123", "Focus", "Ford", 2010, 10);
		Funcionario f4 = new Funcionario("1623", "Johnson", "11/07/1992", "8595-8585");
		Veiculo v5 = new Veiculo("mar-1234", "Ecosport", "Ford", 2015, 10);
		Funcionario f5 = new Funcionario("1624", "Bronto", "15/09/1993", "8525-8585");
		Veiculo v6 = new Veiculo("mar-2345", "Fiesta", "Ford", 2017, 10);
		Funcionario f6 = new Funcionario("1625", "Michael", "17/05/1995", "8185-8585");

		ControladorFuncionario.getCtrlFuncionario().cadastrar(f);
		ControladorFuncionario.getCtrlFuncionario().cadastrar(f2);
		ControladorFuncionario.getCtrlFuncionario().cadastrar(f3);
		ControladorFuncionario.getCtrlFuncionario().cadastrar(f4);
		ControladorFuncionario.getCtrlFuncionario().cadastrar(f5);
		ControladorFuncionario.getCtrlFuncionario().cadastrar(f6);

		ControladorFuncionario.getCtrlFuncionario().cadastraCargo(1, f);
		ControladorFuncionario.getCtrlFuncionario().cadastraCargo(2, f2);
		ControladorFuncionario.getCtrlFuncionario().cadastraCargo(3, f3);
		ControladorFuncionario.getCtrlFuncionario().cadastraCargo(4, f4);
		ControladorFuncionario.getCtrlFuncionario().cadastraCargo(5, f5);
		ControladorFuncionario.getCtrlFuncionario().cadastraCargo(6, f6);

		ControladorVeiculo.getCtrlVeiculo().cadastrar(v);
		ControladorVeiculo.getCtrlVeiculo().cadastrar(v2);
		ControladorVeiculo.getCtrlVeiculo().cadastrar(v3);
		ControladorVeiculo.getCtrlVeiculo().cadastrar(v4);
		ControladorVeiculo.getCtrlVeiculo().cadastrar(v5);
		ControladorVeiculo.getCtrlVeiculo().cadastrar(v6);

		try {
			ControladorFuncionario.getCtrlFuncionario().addPermVeic(f.getNumeroMatricula(), v.getPlaca());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ControladorFuncionario.getCtrlFuncionario().addPermVeic(f.getNumeroMatricula(), v2.getPlaca());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ControladorFuncionario.getCtrlFuncionario().addPermVeic(f.getNumeroMatricula(), v3.getPlaca());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ControladorFuncionario.getCtrlFuncionario().addPermVeic(f.getNumeroMatricula(), v4.getPlaca());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ControladorFuncionario.getCtrlFuncionario().addPermVeic(f.getNumeroMatricula(), v5.getPlaca());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ControladorFuncionario.getCtrlFuncionario().addPermVeic(f.getNumeroMatricula(), v6.getPlaca());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			ControladorFuncionario.getCtrlFuncionario().addPermVeic(f2.getNumeroMatricula(), v.getPlaca());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ControladorFuncionario.getCtrlFuncionario().addPermVeic(f2.getNumeroMatricula(), v2.getPlaca());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ControladorFuncionario.getCtrlFuncionario().addPermVeic(f2.getNumeroMatricula(), v3.getPlaca());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ControladorFuncionario.getCtrlFuncionario().addPermVeic(f3.getNumeroMatricula(), v.getPlaca());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ControladorFuncionario.getCtrlFuncionario().addPermVeic(f3.getNumeroMatricula(), v2.getPlaca());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ControladorFuncionario.getCtrlFuncionario().addPermVeic(f4.getNumeroMatricula(), v4.getPlaca());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ControladorFuncionario.getCtrlFuncionario().addPermVeic(f5.getNumeroMatricula(), v6.getPlaca());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ControladorFuncionario.getCtrlFuncionario().addPermVeic(f6.getNumeroMatricula(), v5.getPlaca());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ControladorFuncionario.getCtrlFuncionario().addPermVeic(f6.getNumeroMatricula(), v6.getPlaca());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Getter & Setter

	public static Injection getInjector() {
		if (injector == null) {
			injector = new Injection();
		}
		return injector;
	}

	public static void setInjector(Injection injector) {
		Injection.injector = injector;
	}

}
