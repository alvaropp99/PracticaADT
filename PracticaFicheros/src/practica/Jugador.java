package practica;

public class Jugador {
	String nombre;
	String apellidos;
	Integer dorsal;
	String posicion;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	public void mostrarInfo() {
		System.out.println("Nombre: "+getNombre()+
				"\nApellidos: "+getApellidos()+
				"\nDorsal: "+getDorsal()+
				"\nPosición: "+getPosicion());
		
	}
}
