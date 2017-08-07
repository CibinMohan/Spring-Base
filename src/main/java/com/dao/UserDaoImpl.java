package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "dao")
@Transactional
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager em;
	
	public void persist(Object obj) {
		em.persist(obj);	
	}

	public <T> List<T> getAll(Class<T> clazz) {
		
		TypedQuery<T> query = em.createQuery(" from "+ clazz.getName(),clazz);
		
		return query.getResultList();
	}

}
