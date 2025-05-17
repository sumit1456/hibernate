package com.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetConnection {
	

	public static EntityManager creatConn() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		return emf.createEntityManager();
	}

}
