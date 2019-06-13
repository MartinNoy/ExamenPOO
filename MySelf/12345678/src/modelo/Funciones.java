package modelo;
import java.time.LocalDate;
import java.time.LocalTime;


public class Funciones {
	
	public static boolean esBisiesto(int anio) {
		boolean respuesta = false;
		
		if ((anio%4==0 && anio%100!=0)||(anio%4 ==0 && anio%100 ==0 && anio%400 ==0)) {
			respuesta = true;
		}
		
		return respuesta;
	}
	
	public static boolean esFechaValida (LocalDate fecha) {
		boolean respuesta = false;
		int anio = fecha.getYear();
		int mes = fecha.getMonthValue();
		int dia = fecha.getDayOfMonth();
		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			if(dia>=1 || 31>=dia) {
				respuesta = true;
			}
		}
		
		if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			if(dia>=1 || 30>=dia) {
				respuesta = true;
			}
		}
		
		if (mes == 2 && esBisiesto(anio)) {
			if(dia>=1 || 29>=dia) {
				respuesta = true;
			}else{
				if(dia>=1 || 28>=dia) {
					respuesta = true;
				}
			}
		}
		return respuesta;
	}
	
	public static String traerFechaCorta(LocalDate fecha) {
		
		return "la fecha es"+fecha.getDayOfMonth()+"/"+fecha.getMonthValue()+"/"+fecha.getYear();
	}
	
	public static String traerHoraCorta(LocalTime hora) {
		return hora.getHour()+":"+hora.getMinute();
	}
	
	public static boolean esDiaHabil(LocalDate fecha) {
		boolean respuesta = true;
		
		if (fecha.getDayOfWeek().name() == "saturday" || fecha.getDayOfWeek().name() == "sunday" ) {
			respuesta = false;
		}
		
		return respuesta;
	}
	
	public static String traerDiaDeLaSemana(LocalDate fecha) {
		
		return fecha.getDayOfWeek().name();
		
	}
	
	
	public static String traerMesEnLetras(LocalDate fecha) {
		
		return fecha.getMonth().name();
				
	}
	
	public static String traerFechaLarga(LocalDate fecha) {
		return traerDiaDeLaSemana(fecha)+fecha.getDayOfMonth()+"de"+traerMesEnLetras(fecha)+"del"+fecha.getYear();
		//return fecha.getDayOfWeek().name()+fecha.getDayOfMonth()+fecha.getMonth().name()+fecha.getYear();
	}
	
	public static int traerCantDiasDeUnMes(int anio, int mes) {
		int dias ;
		
		if (esBisiesto(anio)&& mes == 2) {
			dias = 29;
		}else {
			dias = 28;
		}
		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			dias = 31;
		}
		if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			dias = 30;
		}
		
		
		return dias;
	}
	
	
	public static double aproximar2Decimal (double valor) {

		return Math.round(valor * 100d);
		
	}
	
	
	

}
