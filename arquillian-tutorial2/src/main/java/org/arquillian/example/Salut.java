package org.arquillian.example;

import java.io.PrintStream;

public class Salut {
	
	
	public void salutare(PrintStream out,String mesaj) {
		out.println(mesajDeSalutare(mesaj));
	}
	
	
	
	public String mesajDeSalutare(String mesaj) {
		return "salut "+ mesaj;
	}
	

}
