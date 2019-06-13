package modelo;
import java.util.*;
import java.time.*;

public class CoopElectrica {
	List<Persona> listaPersonas = new ArrayList<Persona>();
	List<MedidorAlta> listaMedidoresAlta = new ArrayList<MedidorAlta>();
	List<Lectura> listaLecturas = new ArrayList<Lectura>();
	public CoopElectrica() {
		super();
	}
	
	
	public int agregarCliente(String apellido, String nombre, long dni, String nroCliente) {
		int idPersona = 1;
		if(!listaPersonas.isEmpty())idPersona = listaPersonas.get(listaPersonas.size()-1).getIdPersona()+1;
		Persona cliente = new Cliente(idPersona, nombre, apellido, dni, nroCliente);
		listaPersonas.add(cliente);
		return idPersona;
	}
	
	public int agregarInspector(String apellido, String nombre, long dni, int zona) {
		int idPersona=1;
		if(!listaPersonas.isEmpty())idPersona = listaPersonas.get(listaPersonas.size()-1).getIdPersona()+1;
		Persona inspector = new Inspector(idPersona, nombre, apellido, dni, zona);
		listaPersonas.add(inspector);
		return idPersona;
	}
	
	public List<Persona> traerPersonas(){
		return listaPersonas;
	}
	
	public Cliente traerCliente(int id) {
		Cliente cliente = null;
		int i = 0;
		while(listaPersonas.size()>i&&cliente==null) {
			if((listaPersonas.get(i)instanceof Cliente)&&(listaPersonas.get(i).getIdPersona()==id)) {
				cliente = (Cliente) listaPersonas.get(i);
			}
			i++;
		}
		return cliente;
	}
	
	public Inspector traerInspector(int id) {
		Inspector inspector = null;
		int i = 0;
		while((listaPersonas.size()>i)&&(inspector==null)) {
			if((listaPersonas.get(i)instanceof Inspector)&&(listaPersonas.get(i).getIdPersona()==id)) {
				inspector = (Inspector) listaPersonas.get(i);
			}
			i++;
		}
		return inspector;
		
	}
	
	
	public int  agregarMedidorAlta(int nroSerie, String domicilioMedidor, Cliente cliente, int zona)throws Exception {
		int idMedidorAlta = 1;
		if (!listaMedidoresAlta.isEmpty())idMedidorAlta = listaMedidoresAlta.get(listaMedidoresAlta.size()-1).getIdMedidorAlta()+1;
		if (traerMedidorAlta(nroSerie)!=null)throw new Exception("El Medidor ya existe");
		MedidorAlta medidor = new MedidorAlta(idMedidorAlta, cliente, nroSerie, domicilioMedidor, zona);
		listaMedidoresAlta.add(medidor);
		return idMedidorAlta;
	}
	
	public List<MedidorAlta> traerMedidoresAlta(){
		return listaMedidoresAlta;
	}
	
	public MedidorAlta traerMedidorAlta(int nroSerie) {
		MedidorAlta medidor = null;
		int i = 0;
		while((listaMedidoresAlta.size()>i)&&(medidor==null)) {
			if (listaMedidoresAlta.get(i).getNroSerie()==nroSerie) {
				medidor = listaMedidoresAlta.get(i);
			}
				
			i++;
		}
		return medidor;
		
	}
	
	public int agregarLectura(LocalDate fecha, MedidorAlta medidorAlta, Inspector inspector, Consumo consumo) {
		int idLectura = 1;
		if(!listaLecturas.isEmpty())idLectura = listaLecturas.get(listaLecturas.size()-1).getIdLectura()+1;
		
		Lectura lectura = new Lectura(idLectura, fecha, medidorAlta, inspector, consumo);
		listaLecturas.add(lectura);
		return idLectura;
	}
	
	public List<Lectura> traerLectura(){
		return listaLecturas;
	}
	
	public List<Lectura> traerLectura(MedidorAlta ma){
		List<Lectura> lectura = new ArrayList<Lectura>();
		int i = 0;
		while(listaLecturas.size()>i) {
			if(listaLecturas.get(i).getMedidorAlta().equals(ma)) {
				lectura.add(listaLecturas.get(i));
			}
			i++;
		}
		return lectura;
	}
	
	public Lectura traerLectura(MedidorAlta ma, int mes, int anio) {
		Lectura lectura = null;
		int i = 0;
		while(listaLecturas.size()>i) {
			if((listaLecturas.get(i).getMedidorAlta().equals(ma))&&(listaLecturas.get(i).getFecha().getYear()==anio)&&(listaLecturas.get(i).getFecha().getMonthValue()==mes)) {
				lectura = listaLecturas.get(i);
			}
			i++;
		}
		
		return lectura;
		
	}
	
	
}