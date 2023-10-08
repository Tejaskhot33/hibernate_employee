package hibernate_employee;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Employee_Dao {

	public EntityManager getEntityManager() {

		return Persistence.createEntityManagerFactory("tejas").createEntityManager();

	}

	public void createUser(Employee employee) {

		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();

		System.out.println("created successfully ");

	}

	public void updateEmployee(Employee employee, int id) {
		EntityManager entityManager = getEntityManager();
		Employee dbemployee = entityManager.find(Employee.class, id);

		if (dbemployee != null) {
			employee.setId(id);
			EntityTransaction entityTransaction = entityManager.getTransaction();

			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();

			System.out.println("updated successfulyy");

		}

	}

	public void deleteAddress(Employee employee, int id) {
		EntityManager entityManager = getEntityManager();
		Employee dbemployee = entityManager.find(Employee.class, id);

		if (dbemployee != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();

			entityTransaction.begin();
			entityManager.remove(dbemployee);
			entityTransaction.commit();

			System.out.println("Deleted successfully");
		} else {
			System.out.println(id + " id not found to delete");
		}
	}

	public void findById(int id) {
		EntityManager entityManager = getEntityManager();
		Employee dbemployee = entityManager.find(Employee.class, id);

		if (dbemployee != null) {
			System.out.println(dbemployee.toString());
		} else {
			System.out.println(id + "id not found ");
		}

	}

	public void findByPhone(long phone) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE PHONE=?1");
		query.setParameter(1, phone);
		try {
			Employee employee = (Employee) query.getSingleResult();
			System.out.println(employee.toString());

		} catch (Exception e) {
			System.out.println(phone + "phone not found");
		}

	}

	public void updatePhone(int id, long phone) {
		EntityManager entityManager = getEntityManager();
		Employee dbemployee = entityManager.find(Employee.class, id);

		if (dbemployee != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();

			dbemployee.setPhone(phone);
			entityTransaction.begin();
			entityManager.merge(dbemployee);
			entityTransaction.commit();

			System.out.println("phone updated ");

		} else {
			System.out.println(id + "id not found");
		}

	}

	public void updateAddress(int id, String address) {
		EntityManager entityManager = getEntityManager();
		Employee dbemployee = entityManager.find(Employee.class, id);

		if (dbemployee != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();

			dbemployee.setAddress(address);
			entityTransaction.begin();
			entityManager.merge(dbemployee);
			entityTransaction.commit();

			System.out.println("address updated ");

		} else {
			System.out.println(address + "id not found");
		}
	}

	public void updateName(int id, String name) {
		EntityManager entityManager = getEntityManager();
		Employee dbemployee = entityManager.find(Employee.class, id);

		if (dbemployee != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();

			dbemployee.setName(name);
			entityTransaction.begin();
			entityManager.merge(dbemployee);
			entityTransaction.commit();

			System.out.println("name updated");
		} else {
			System.out.println(id + "id not found");
		}

	}

	public void deletePhone(long phone) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE phone=?1");
		query.setParameter(1, phone);

		try {
			Employee employee = (Employee) query.getSingleResult();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();

			System.out.println("deleted successfully");
		} catch (Exception e) {
			System.out.println("phone not found");
		}

	}

	public void deleteAddress(String address) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE address=?1");
		query.setParameter(1, address);

		try {
			List<Employee> employee = query.getResultList();
			for (Employee e : employee) {
				EntityTransaction entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.remove(employee);
				entityTransaction.commit();

				System.out.println("deleted address");
			}

		} catch (Exception e) {
			System.out.println("address not found");
		}

	}

}
