package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetConnection {
	
	
	public static EntityManager getConn() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		return emf.createEntityManager();
	}

}
