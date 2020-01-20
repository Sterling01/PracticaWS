package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Cuenta;
import modelo.Movimiento;

@Stateless
public class MovimientoDAO {

	@Inject
	private EntityManager em;
	 	
	public boolean insertarTransferenciaOrigen(Movimiento movimiento, Cuenta cuentaOrigen) {
		movimiento.setTipo_movimiento("Transferencia Retiro");
		movimiento.setNumero_cuenta(cuentaOrigen);
		em.persist(movimiento);
		return true;
	}
	
	public boolean insertarTransferenciaDestino(Movimiento movimiento, Cuenta cuentaDestino) {
		movimiento.setTipo_movimiento("Transferencia Deposito");
		movimiento.setNumero_cuenta(cuentaDestino);
		em.persist(movimiento);
		return true;
	}
	
	public void realizarTransferencia(String cuentaOrigen, String cuentaDestino, double monto) {	
		Query origen = em.createQuery("UPDATE Cuenta c SET saldo_cuenta = saldo_cuenta + ?1 WHERE numero_cuenta = ?2");
		Query destino = em.createQuery("UPDATE Cuenta c SET saldo_cuenta = saldo_cuenta - ?1 WHERE numero_cuenta = ?2");
		origen.setParameter(1, monto);
		origen.setParameter(2, Integer.parseInt(cuentaDestino));
		destino.setParameter(1, monto);
		destino.setParameter(2, Integer.parseInt(cuentaOrigen));
		origen.executeUpdate();
		destino.executeUpdate();
	}
	
	public Cuenta getCuenta(String numeroCuenta) {
		try {
			String jpql = "SELECT c FROM Cuenta c WHERE numero_cuenta = ?1";
			Query q = em.createQuery(jpql, Cuenta.class);
			q.setParameter(1, Integer.parseInt(numeroCuenta));
			Cuenta cuenta = (Cuenta) q.getSingleResult();
			return cuenta;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Movimiento> getMovimientosCuenta(String numeroCuenta){
		//String jpql = "SELECT m.tipo_movimiento, m.fecha_movimiento, m.valor_movimiento, m.descripcion_movimiento FROM Movimiento m WHERE numero_cuenta = ?1";
		String jpql = "SELECT m FROM Movimiento m WHERE numero_cuenta = ?1";
		Query q = em.createQuery(jpql);
		Cuenta c = getCuenta(numeroCuenta);
		q.setParameter(1, c);
		return q.getResultList();
	}
}
