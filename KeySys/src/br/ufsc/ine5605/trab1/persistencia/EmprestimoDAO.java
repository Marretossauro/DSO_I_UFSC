package br.ufsc.ine5605.trab1.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import br.ufsc.ine5605.trab1.objects.Emprestimo;

public class EmprestimoDAO {

	private HashMap<Integer, Emprestimo> cacheEmprestimo;
	private String filename = "emprestimos.cla";
	private static EmprestimoDAO empDAO;
	
	public EmprestimoDAO() {
		super();
		cacheEmprestimo = new HashMap<>();
		load();
	}

	private void load() {
		try {
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream oi = new ObjectInputStream(fin);
			
			this.cacheEmprestimo = (HashMap<Integer, Emprestimo>) oi.readObject();
			
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
	
	public void put(Emprestimo emprestimo) {
		if(emprestimo != null) {
			cacheEmprestimo.put(emprestimo.getCodigo(), emprestimo);
			persist();
		}
	}
	
	public void persist() {
		try {
			FileOutputStream fout = new FileOutputStream(filename);

			ObjectOutputStream oo = new ObjectOutputStream(fout);
			oo.writeObject(cacheEmprestimo);

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

	public Emprestimo get(Integer codigo) {

		if (codigo != null) {
			return cacheEmprestimo.get(codigo);
		}

		return null;

	}

	public void remove(Integer codigo) {
		cacheEmprestimo.remove(codigo);
		persist();
	}

	public Collection<Emprestimo> getList() {
		return cacheEmprestimo.values();
	}

	public static EmprestimoDAO getEmpDAO() {
		if (empDAO == null) {
			empDAO = new EmprestimoDAO();
		}

		return empDAO;

	}

	public static void setEmpDAO(EmprestimoDAO empDAO) {
		EmprestimoDAO.empDAO = empDAO;
	}
	
}
