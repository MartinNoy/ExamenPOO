package test;
import java.time.LocalDate;

import modelo.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoopElectrica ce=new CoopElectrica(); 
		
		//--------------------------------agregar Personas--------------------------------
		ce.agregarCliente("Perez", "Ana", 11111111, "111111");
		ce.agregarCliente("Rodriguez", "Pablo", 22222222, "222222");
		ce.agregarCliente("Siciliano", "Gustavo", 44444444, "444444");
		ce.agregarCliente("Vranic", "Alejandra", 66666666, "666666");
		ce.agregarInspector("Rios", "Leandro", 33333333, 1);
		ce.agregarInspector("Mansilla", "Romina", 55555555, 2);
		
		
		
		//--------------------------------traer Personas--------------------------------
		
		System.out.println("--------------------------------Personas--------------------------------");
		System.out.println(ce.traerPersonas());
		
		
		
		//--------------------------------traer Cliente--------------------------------
		System.out.println("--------------------------------Cliente--------------------------------");
		System.out.println(ce.traerCliente(4));
		
		
		
		//--------------------------------traer Inspector--------------------------------
		System.out.println("--------------------------------Inspector--------------------------------");
		System.out.println(ce.traerInspector(5));
		
		
		
		//--------------------------------agregar Medidores--------------------------------
		try {
		ce.agregarMedidorAlta(438823, "29 Septiembre 3500 R.Escalada", ce.traerCliente(1), 1);
		ce.agregarMedidorAlta(934152, "29 Septiembre 3520 R.Escalada", ce.traerCliente(2), 1);
		ce.agregarMedidorAlta(439821, "29 Septiembre 3540 R.Escalada", ce.traerCliente(4), 2);
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		//--------------------------------traer Medidores--------------------------------
		System.out.println("--------------------------------Medidores--------------------------------");
		System.out.println(ce.traerMedidoresAlta());
		
		
		
		//--------------------------------traer Medidor--------------------------------
		System.out.println("--------------------------------Medidor 438823--------------------------------");
		System.out.println(ce.traerMedidorAlta(438823));
		
		
		
		//--------------------------------agregar Medidor repetido--------------------------------
		try {
			ce.agregarMedidorAlta(934152, "29 Septiembre 3520 R.Escalada", ce.traerCliente(2), 1);
		
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		//--------------------------------agregar Medidor numero incorrecto--------------------------------
		System.out.println("medidor con verificador incorrecto");
		
		try {
		ce.agregarMedidorAlta(352692, "29 Septiembre 3520 R.Escalada ", ce.traerCliente(6), 1);
	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		//--------------------------------agregar Lecturas--------------------------------
		
		ce.agregarLectura(LocalDate.of(2019, 01, 01), ce.traerMedidorAlta(438823), ce.traerInspector(3),new Consumo(1520, 1200, 1400));
		ce.agregarLectura(LocalDate.of(2019, 01, 02), ce.traerMedidorAlta(934152), ce.traerInspector(3),new Consumo(1120, 1450, 900));
		ce.agregarLectura(LocalDate.of(2019, 01, 04), ce.traerMedidorAlta(439821), ce.traerInspector(5),new Consumo(920, 850, 750));
		ce.agregarLectura(LocalDate.of(2019, 02, 01), ce.traerMedidorAlta(438823), ce.traerInspector(3),new Consumo(2032, 1570, 1620));
		ce.agregarLectura(LocalDate.of(2019, 02, 03), ce.traerMedidorAlta(934152), ce.traerInspector(3),new Consumo(1540, 2600, 2120));
		ce.agregarLectura(LocalDate.of(2019, 02, 05), ce.traerMedidorAlta(439821), ce.traerInspector(5),new Consumo(1431, 1220, 1125));
		
		//--------------------------------traer Lecturas--------------------------------
		
		System.out.println(ce.traerLectura());
		
		System.out.println("--------------------------------Lecturas del medidor 934152--------------------------------");
		
		System.out.println(ce.traerLectura(ce.traerMedidorAlta(934152)));
		
		System.out.println("--------------------------------Lecturas del medidor 934152 en mes 2 año 2019--------------------------------");
		
		System.out.println(ce.traerLectura(ce.traerMedidorAlta(934152), 2, 2019));
		
		
		
	}

}
