package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.CuentaDAO;
import modelo.Cuenta;

@Stateless
public class GestionCuentas {

	@Inject
	private CuentaDAO cuentaDAO;
	
	public void guardar(Cuenta cuenta) {
		cuentaDAO.insert(cuenta);
	}
	
	public void actualizar(Cuenta cuenta) {
		cuentaDAO.update(cuenta);
	}
	
	public void eliminar(int codigo) {
		cuentaDAO.remove(codigo);
	}
	
	public List<Cuenta> getCuentas(){
		return cuentaDAO.getCuentas();
	}
	public Cuenta obtenerCuentaNumero(String numeroCuenta) {
		return cuentaDAO.getCuentaNumero(numeroCuenta);
	}
		
}

