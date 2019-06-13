package modelo;
import java.util.*;
import java.time.*;

public class Lectura {
	private int idLectura;
	private LocalDate fecha;
	private MedidorAlta medidorAlta;
	private Inspector inspector;
	private Consumo consumo;
	public Lectura(int idLectura, LocalDate fecha, MedidorAlta medidorAlta, Inspector inspector, Consumo consumo) {
		super();
		this.idLectura = idLectura;
		this.fecha = fecha;
		this.medidorAlta = medidorAlta;
		this.inspector = inspector;
		this.consumo = consumo;
	}
	public int getIdLectura() {
		return idLectura;
	}
	public void setIdLectura(int idLectura) {
		this.idLectura = idLectura;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public MedidorAlta getMedidorAlta() {
		return medidorAlta;
	}
	public void setMedidorAlta(MedidorAlta medidorAlta) {
		this.medidorAlta = medidorAlta;
	}
	public Inspector getInspector() {
		return inspector;
	}
	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}
	public Consumo getConsumo() {
		return consumo;
	}
	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
	}
	@Override
	public String toString() {
		return "Lectura [idLectura=" + idLectura + ", fecha=" + fecha + ", medidorAlta=" + medidorAlta + ", inspector="
				+ inspector + ", consumo=" + consumo + "]\n";
	}
	
	
	

}
