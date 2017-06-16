package br.ufsc.ine5605.trab1.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import br.ufsc.ine5605.trab1.objects.Veiculo;

public class VeiculoDAO {

	private HashMap<String, Veiculo> cacheVeiculo;
	private String filename = "veiculos.cla";
	private static VeiculoDAO veicDAO;

	public VeiculoDAO() {
		super();
		cacheVeiculo = new HashMap<>();
		load();
	}

	private void load() {
		try {
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream oi = new ObjectInputStream(fin);

			this.cacheVeiculo = (HashMap<String, Veiculo>) oi.readObject();

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

	public void put(Veiculo veiculo) {
		if (veiculo != null) {
			cacheVeiculo.put(veiculo.getPlaca(), veiculo);
			persist();
		}
	}

	public void persist() {
		try {
			FileOutputStream fout = new FileOutputStream(filename);

			ObjectOutputStream oo = new ObjectOutputStream(fout);
			oo.writeObject(cacheVeiculo);

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

	public Veiculo get(String placa) {

		if (placa != null) {
			return cacheVeiculo.get(placa);
		}

		return null;

	}

	public void remove(String placa) {
		cacheVeiculo.remove(placa);
		persist();
	}

	public Collection<Veiculo> getList() {
		return cacheVeiculo.values();
	}

	public static VeiculoDAO getVeicDAO() {
		if (veicDAO == null) {
			veicDAO = new VeiculoDAO();
		}

		return veicDAO;
	}

	public static void setVeicDAO(VeiculoDAO veicDAO) {
		VeiculoDAO.veicDAO = veicDAO;
	}

}
