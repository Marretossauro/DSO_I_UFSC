package br.ufsc.ine5605.trab1.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import br.ufsc.ine5605.trab1.objects.Log;

public class LogDAO {

	private HashMap<String, Log> cacheLog;
	private String filename = "logs.cla";
	private static LogDAO logDAO;
	
	
	public LogDAO() {
		super();
		cacheLog = new HashMap<>();
		load();
	}
	
	private void load() {
		try {
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream oi = new ObjectInputStream(fin);
			
			this.cacheLog = (HashMap<String, Log>) oi.readObject();
			
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
	
	public void put(Log Log) {
		if(Log != null) {
			cacheLog.put(Log.getNumeroMatricula(), Log);
			persist();
		}
	}
	
	public void persist() {
		try {
			FileOutputStream fout = new FileOutputStream(filename);

			ObjectOutputStream oo = new ObjectOutputStream(fout);
			oo.writeObject(cacheLog);

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

	public Log get(Integer codigo) {

		if (codigo != null) {
			return cacheLog.get(codigo);
		}

		return null;

	}

	public void remove(Integer codigo) {
		cacheLog.remove(codigo);
		persist();
	}

	public Collection<Log> getList() {
		return cacheLog.values();
	}

	public static LogDAO getlogDAO() {
		if (logDAO == null) {
			logDAO = new LogDAO();
		}

		return logDAO;

	}

	public static void setlogDAO(LogDAO logDAO) {
		LogDAO.logDAO = logDAO;
	}

}
