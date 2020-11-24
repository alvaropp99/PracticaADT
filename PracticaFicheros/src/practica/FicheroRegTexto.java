package practica;

import java.io.*;
import java.util.Scanner;

public class FicheroRegTexto extends FicheroReg{
	
	PrintWriter fichEscr;
	FileWriter fichEscrWr;
	FileReader fichLect;
	BufferedReader fichLectBr;
	File fichero =new File("E:\\FicheroReg.txt");
	
	public FicheroRegTexto() {
		this.fichEscr=null;
		this.fichEscrWr=null;
		this.fichLect=null;
		this.fichLectBr=null;
	}
	
	public FicheroRegTexto(String fich) {
		super(fich);
		this.fichEscr=null;
		this.fichEscrWr=null;
		this.fichLect=null;
		this.fichLectBr=null;
	}
	
	@Override
	public boolean abrirFicheroR() {
		// TODO Auto-generated method stub
		try {
			fichLect=new FileReader(fichero);
			fichLectBr=new BufferedReader(fichLect);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean cerrarFicheroR() {
		// TODO Auto-generated method stub
		try {
			fichLect.close();
			fichLectBr.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		fichLect=null;
		fichLectBr=null;
		
		return true;
	}
	
	@Override
	public boolean abrirFicheroW(boolean append) {
		try {
			fichEscrWr=new FileWriter(fichero,append);
			fichEscr=new PrintWriter(fichEscrWr,append);
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean cerrarFicheroW() {
		// TODO Auto-generated method stub
		try {
			fichEscr.close();
			fichEscrWr.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean isOpenR() {
		// TODO Auto-generated method stub
		if(fichLect!=null)
			return true;
		
		return false;
	}
	
	@Override
	public boolean isOpenW() {
		if(fichEscr!=null)
			return true;
		
		return false;
	}
	
	@Override
	public boolean leerRegistro(Jugador jugador) {
		// TODO Auto-generated method stub
		abrirFicheroR();
		String nombre=null;
		String apellidos=null;
		Integer dorsal=null;
		String posicion=null;
		
		try {
			nombre=jugador.nombre=fichLectBr.readLine();
			apellidos=jugador.apellidos=fichLectBr.readLine();
			dorsal=Integer.parseInt(fichLectBr.readLine());
			posicion=fichLectBr.readLine();
		}catch(IOException e) {
			e.printStackTrace();
		}
		cerrarFicheroR();
		
		if((nombre.equals(null)||apellidos.equals(null)||dorsal==null||posicion.equals(null))) {
			return false;
		}
		jugador.setNombre(nombre);
		jugador.setApellidos(apellidos);
		jugador.setDorsal(dorsal);
		jugador.setPosicion(posicion);
		
		return true;
	}
	
	@Override
	public boolean escribirRegistro(Jugador jugador) {
		// TODO Auto-generated method stub
		abrirFicheroW(true);
		int dorsal=jugador.getDorsal();
		try {
			fichEscrWr.write(jugador.getNombre());
			fichEscrWr.write(jugador.getApellidos());
			fichEscrWr.write(jugador.getDorsal());
			fichEscrWr.write(jugador.getPosicion());
		}catch(IOException e) {
			e.printStackTrace();
		}
		cerrarFicheroW();
		
		if(jugador.getNombre()!=null && jugador.getApellidos()!=null && jugador.getDorsal()!=0 && jugador.getPosicion()!=null) {
			return false;
		}
		
		
		return true;
	}
	
	@Override
	public void mostrarRegistros() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(fichLectBr);
		abrirFicheroR();
		try {
			while(sc.hasNextLine()) {
				System.out.println(fichLectBr.readLine());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int numeroDeRegistros() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(fichLectBr);
		int i=0;
		abrirFicheroR();
		try {
			while(sc.hasNextLine()) {
				i++;
				System.out.println(fichLectBr.readLine());
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}
	
}
