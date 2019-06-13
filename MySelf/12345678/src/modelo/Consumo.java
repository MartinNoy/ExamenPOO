package modelo;

public class Consumo {
	private int horasValle;
	private int horasPico;
	private int horasResto;
	public Consumo(int horasValle, int horasPico, int horasResto) {
		super();
		this.horasValle = horasValle;
		this.horasPico = horasPico;
		this.horasResto = horasResto;
	}
	public int getHorasValle() {
		return horasValle;
	}
	public void setHorasValle(int horasValle) {
		this.horasValle = horasValle;
	}
	public int getHorasPico() {
		return horasPico;
	}
	public void setHorasPico(int horasPico) {
		this.horasPico = horasPico;
	}
	public int getHorasResto() {
		return horasResto;
	}
	public void setHorasResto(int horasResto) {
		this.horasResto = horasResto;
	}
	@Override
	public String toString() {
		return "Consumo [horasValle=" + horasValle + ", horasPico=" + horasPico + ", horasResto=" + horasResto + "]\n";
	}
	
	
	

}
