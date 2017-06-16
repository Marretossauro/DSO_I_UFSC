package br.ufsc.ine5605.enumgenericos;

import be.ufsc.ine5605.modelo.Cliente;
import be.ufsc.ine5605.modelo.TipoCliente;

public class ControladorPrincipal {

	private static ControladorPrincipal ctrlPrinc = new ControladorPrincipal();

	private ControladorPrincipal() {

	}

	public void inicia() {

		Cliente cliente = new Cliente();
		cliente.setTipoCliente(TipoCliente.ESPECIAL);

		if (cliente.getTipoCliente().equals(TipoCliente.ESPECIAL)) {
			System.out.println("Cliente Especial");
			System.out.println("Motivo: " + cliente.getTipoCliente().detalhes);
		}

	}

	public static ControladorPrincipal getCtrlPrinc() {
		if (ctrlPrinc == null) {
			ctrlPrinc = new ControladorPrincipal();
		}
		return ctrlPrinc;
	}

	public void setCtrlPrinc(ControladorPrincipal ctrlPrinc) {
		ControladorPrincipal.ctrlPrinc = ctrlPrinc;
	}

}
