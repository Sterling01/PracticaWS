package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Cuenta;

@Stateless
public class CuentaDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Cuenta cuenta) {
		long millis=System.currentTimeMillis();  
		java.util.Date fecha=new java.util.Date(millis);
		cuenta.setFecha_apertura_cuenta(fecha);
		em.persist(cuenta);
	}
	
	public void update(Cuenta cuenta) {
		em.merge(cuenta);
	}
	
	public void remove(int codigo) {
		Cuenta cuenta  = this.read(codigo);
		em.remove(cuenta);
	}
	public Cuenta read(int codigo) {
		return em.find(Cuenta.class, codigo);
	}
	
	public List<Cuenta> getCuentas(){
		String jpql = "SELECT c FROM Cuenta c";
		return em.createQuery(jpql, Cuenta.class).getResultList();
	}
	
	public Cuenta getCuentaNumero(String numeroCuenta){
		String jpql = "SELECT c FROM Cuenta c WHERE numero_cuenta LIKE ?1";
		Query q = em.createQuery(jpql,Cuenta.class);
		q.setParameter(1, "%" + numeroCuenta + "%");
		return (Cuenta) q.getSingleResult();
	}

}
