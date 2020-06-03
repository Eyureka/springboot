package springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springboot.entity.Employee;

@Repository
public class EmployeeDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDao(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
		
	@Transactional
	public List<Employee> findAll(){
		
		//using hibernate api
//		Session currentSession = entityManager.unwrap(Session.class);
//		
//		Query<Employee> theQuery = currentSession.createQuery("from Employee",Employee.class); // table name should be caps
//		
//		List<Employee> employee = theQuery.getResultList();
//		
//		return employee;
		
		
		//using jpa api		
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class); // table name should be caps
		
		List<Employee> employee = theQuery.getResultList();
		
		return employee;
	}

}

