package servicios;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import negocio.GestionMovimientos;

@WebService
public class MovimientoServiceSOAP {

	@Inject
	private GestionMovimientos gm;
	
	@WebMethod
	public Respuesta realizarTransferencia(String cuentaOrigen, String cuentaDestino, double monto, String descripcion) {
		Respuesta respuesta = new Respuesta();
		try {
			if(gm.insertarTransferencia(cuentaOrigen, cuentaDestino, monto, descripcion)) {
				respuesta.setCodigo(1);
				respuesta.setMensaje("Transferencia realizada");	
			} else {
				respuesta.setCodigo(99);
				respuesta.setMensaje("ERROR Cuenta no encontrada");
			}
		} catch (Exception e) {
			respuesta.setCodigo(99);
			respuesta.setMensaje("ERROR");
		}
		return respuesta;
	}
}
