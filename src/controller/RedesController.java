package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
	}
	
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}

	public void IP() {
		String sis;
		String adaptador="";
		String comando;
		sis = os();
		if (sis.contains("Windows")) {
			comando = "IPCONFIG";
		} else {
			comando = "IFCONFIG";
		}
		try {
			Process p = Runtime.getRuntime().exec(comando);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha!= null) {
				if (linha.contains("IPv4")) {
					System.out.println(adaptador);
					System.out.println(linha);
				}
				if (linha.contains("Adaptador")) {
					adaptador=linha;
				}
				linha = buffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ping() {
		String sis;
		String comando;
		sis = os();
		if (sis.contains("Windows")) {
			comando = "PING -4 -n 10 www.google.com.br";
		} else {
			comando = "PING -4 -c 10 www.google.com.br";
		}
		try {
			Process p = Runtime.getRuntime().exec(comando);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha!= null) {
				if (linha.contains("dia")) {
					String vetor [] = linha.split(",");
					System.out.println(vetor[2]);
				}
				linha = buffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
