package br.ufsc.ine5605.trab1.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;

import br.ufsc.ine5605.trab1.objects.Funcionario;

public class FuncionarioDAO {

	private HashMap<String, Funcionario> cacheFuncionario;
	private String filename = "funcionarios.cla";
	private static FuncionarioDAO funcDAO;

	public FuncionarioDAO() {
		super();
		cacheFuncionario = new HashMap<>();
		load();
	}

	private void load() {
		try {
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream oi = new ObjectInputStream(fin);

			this.cacheFuncionario = (HashMap<String, Funcionario>) oi.readObject();

			oi.close();
			fin.close();

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void put(Funcionario funcionario) {
		if (funcionario != null) {
			cacheFuncionario.put(funcionario.getNumeroMatricula(), funcionario);
			persist();
		}
	}

	public void persist() {
		try {
			FileOutputStream fout = new FileOutputStream(filename);

			ObjectOutputStream oo = new ObjectOutputStream(fout);
			oo.writeObject(cacheFuncionario);

			oo.flush();
			fout.flush();

			oo.close();
			fout.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public Funcionario get(String numeroMatricula) {

		if (numeroMatricula != null) {
			return cacheFuncionario.get(numeroMatricula);
		}

		return null;

	}

	public void remove(String numeroMatricula) {
		cacheFuncionario.remove(numeroMatricula);
		persist();
	}

	public Collection<Funcionario> getList() {
		return cacheFuncionario.values();
	}

	public static FuncionarioDAO getFuncDAO() {
		if (funcDAO == null) {
			funcDAO = new FuncionarioDAO();
		}

		return funcDAO;

	}

	public static void setFuncDAO(FuncionarioDAO funcDAO) {
		FuncionarioDAO.funcDAO = funcDAO;
	}

}
