package servicios;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import modelo.Movimiento;
import negocio.GestionMovimientos;

@Path("/movimientos")
public class MovimientoServiceREST {
	
	@Inject
	private GestionMovimientos gm;
	
	@GET
	@Produces("application/json")//Formato de la respuesta
	public List<Movimiento> getMovimientos(@QueryParam("cuenta") String numeroCuenta) {
		List<Movimiento> listadoMovimientos = gm.getMovimientos(numeroCuenta);
		return listadoMovimientos;
	}

}
