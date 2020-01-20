package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cuenta")
public class Cuenta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "numero_cuenta")
	private int numero_cuenta;
	
	@Column(name = "cedula_cuenta")
	private String cedula_cuenta;
	
	@Column(name = "nombres_persona_cuenta")
	private String nombres_persona_cuenta;
	
	@Column(name = "apellidos_persona_cuenta")
	private String apellidos_persona_cuenta;
	
	@Column(name = "saldo_cuenta")
	private double saldo_cuenta;

	@Column(name = "fecha_apertura_cuenta")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_apertura_cuenta;

	public int getNumero_cuenta() {
		return numero_cuenta;
	}

	public void setNumero_cuenta(int numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}

	public String getCedula_cuenta() {
		return cedula_cuenta;
	}

	public void setCedula_cuenta(String cedula_cuenta) {
		this.cedula_cuenta = cedula_cuenta;
	}

	public String getNombres_persona_cuenta() {
		return nombres_persona_cuenta;
	}

	public void setNombres_persona_cuenta(String nombres_persona_cuenta) {
		this.nombres_persona_cuenta = nombres_persona_cuenta;
	}

	public String getApellidos_persona_cuenta() {
		return apellidos_persona_cuenta;
	}

	public void setApellidos_persona_cuenta(String apellidos_persona_cuenta) {
		this.apellidos_persona_cuenta = apellidos_persona_cuenta;
	}

	public double getSaldo_cuenta() {
		return saldo_cuenta;
	}

	public void setSaldo_cuenta(double saldo_cuenta) {
		this.saldo_cuenta = saldo_cuenta;
	}

	public Date getFecha_apertura_cuenta() {
		return fecha_apertura_cuenta;
	}

	public void setFecha_apertura_cuenta(Date fecha_apertura_cuenta) {
		this.fecha_apertura_cuenta = fecha_apertura_cuenta;
	}

	@Override
	public String toString() {
		return "Cuenta [numero_cuenta=" + numero_cuenta + ", cedula_cuenta=" + cedula_cuenta
				+ ", nombres_persona_cuenta=" + nombres_persona_cuenta + ", apellidos_persona_cuenta="
				+ apellidos_persona_cuenta + ", saldo_cuenta=" + saldo_cuenta + ", fecha_apertura_cuenta="
				+ fecha_apertura_cuenta + "]";
	}
	
}
