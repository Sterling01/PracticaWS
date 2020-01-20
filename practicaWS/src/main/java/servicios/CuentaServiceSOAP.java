package servicios;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.Cuenta;
import negocio.GestionCuentas;

@WebService
public class CuentaServiceSOAP {

	@Inject
	private GestionCuentas gc;
	
	@WebMethod
	public Respuesta crearCuenta(Cuenta cuenta) {
		Respuesta respuesta = new Respuesta();
		try {
			gc.guardar(cuenta);
			respuesta.setCodigo(1);
			respuesta.setMensaje("OK");
		} catch (Exception e) {
			respuesta.setCodigo(99);
			respuesta.setMensaje("ERROR");
		}
		return respuesta;
	}
}
