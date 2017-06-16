package br.ufsc.ine5605.enumgenericos;

public class EnumGenericos {

	public static void main(String[] args) {
		ControladorPrincipal ctrl = ControladorPrincipal.getCtrlPrinc();
		ctrl.inicia();

		ControladorPrincipal ctrl2 = ControladorPrincipal.getCtrlPrinc();
		ctrl2.inicia();
	}

}
