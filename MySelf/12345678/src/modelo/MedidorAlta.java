package modelo;

public class MedidorAlta {
	private int idMedidorAlta;
	private Cliente cliente;
	private int nroSerie;
	private String domicilioMedidor;
	private int zona;
	public MedidorAlta(int idMedidorAlta, Cliente cliente, int nroSerie, String domicilioMedidor, int zona) {
		super();
		this.idMedidorAlta = idMedidorAlta;
		this.cliente = cliente;
		this.nroSerie = nroSerie;
		this.domicilioMedidor = domicilioMedidor;
		this.zona = zona;
	}
	public int getIdMedidorAlta() {
		return idMedidorAlta;
	}
	public void setIdMedidorAlta(int idMedidorAlta) {
		this.idMedidorAlta = idMedidorAlta;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getNroSerie() {
		return nroSerie;
	}
	public void setNroSerie(int nroSerie)throws Exception {
		int digitoVerificar = nroSerie-((nroSerie/10)*100000);
		if(clacularDigitoVerificado(nroSerie)!=digitoVerificar)throw new Exception("numero Verificador no es correcto");
		this.nroSerie = nroSerie;
	}
	public String getDomicilioMedidor() {
		return domicilioMedidor;
	}
	public void setDomicilioMedidor(String domicilioMedidor) {
		this.domicilioMedidor = domicilioMedidor;
	}
	public int getZona() {
		return zona;
	}
	public void setZona(int zona) {
		this.zona = zona;
	}
	
	public int clacularDigitoVerificado(int nroSerie) {
		int verificado = 0;
		int sexto = Math.round(nroSerie/10);
		int primero = Math.round(sexto / 10000);
		int primeroAux = primero*10000;
		int segundo = Math.round((sexto-(primeroAux))/1000);
		int segundoAux = segundo*1000;
		int tercero = Math.round((sexto-(primeroAux+segundoAux))/100);
		int terceroAux = tercero*100;
		int cuarto = Math.round((sexto-(primeroAux+segundoAux+terceroAux))/10);
		int cuartoAux = cuarto * 10;
		int quinto = Math.round((sexto-(primeroAux+segundoAux+terceroAux+cuartoAux))/1);
		int producto1 = primero*9 ;
		int producto2 = segundo*8;
		int producto3 = tercero*7;
		int producto4 = cuarto*6;
		int producto5 = quinto*5;
		verificado = (producto1+producto2+producto3+producto4+producto5)%9;
		return verificado;
	}
	@Override
	public String toString() {
		return "MedidorAlta [idMedidorAlta=" + idMedidorAlta + ", cliente=" + cliente + ", nroSerie=" + nroSerie
				+ ", domicilioMedidor=" + domicilioMedidor + ", zona=" + zona + "]\n";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((domicilioMedidor == null) ? 0 : domicilioMedidor.hashCode());
		result = prime * result + idMedidorAlta;
		result = prime * result + nroSerie;
		result = prime * result + zona;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedidorAlta other = (MedidorAlta) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (domicilioMedidor == null) {
			if (other.domicilioMedidor != null)
				return false;
		} else if (!domicilioMedidor.equals(other.domicilioMedidor))
			return false;
		if (idMedidorAlta != other.idMedidorAlta)
			return false;
		if (nroSerie != other.nroSerie)
			return false;
		if (zona != other.zona)
			return false;
		return true;
	}
	
	
	
	

}
