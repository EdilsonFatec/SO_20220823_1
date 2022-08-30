package view;
import javax.swing.JOptionPane;

import controller.Controller;
import controller.RedesController;
public class Principal {

	public static void main(String[] args) {
		int opcao;

		RedesController process = new RedesController();
		
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção\n"+
		                                                         "1 - IPConfig\n"+
					                                             "2 - Ping\n"+
		                                                         "9 - Fim"));
			if (opcao==1) {
				process.IP();
			}
			if (opcao==2) {
				process.ping();
			}
		}
		while (opcao != 9);
	}

}
