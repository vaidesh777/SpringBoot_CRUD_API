package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.trasaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entity manager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@override

	public List<Employee> findAll() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();

		// return the result
		return employees;

	}

	@Override
	public Employee findById(int theId) {
		Session currentSession = EntityManager.unwrap(Session.class);
		Employee theEmployee = currentSession.get(Employee.class, theId);

		// return the employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// get currrent hibernate session
		Session currentSession = EntityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theEmployee);

	}

	@Override
	public void deleteById(int theId) {
		// get current hibernate session
		
		Sesssion currentSession=EntityManager.unwrap(Session.class)
		Query theQuery=currrentSession.createQuery("delete from Employee where id=employeeId");	
		theQuery.setParameter("employeeId",theId);
		theQuery.executeUpdate();
		
				
				

	}

}
