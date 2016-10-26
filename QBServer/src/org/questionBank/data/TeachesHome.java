package org.questionBank.data;
// Generated Oct 9, 2016 11:50:10 PM by Hibernate Tools 5.2.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Teaches.
 * @see org.questionBank.data.Teaches
 * @author Hibernate Tools
 */
@Stateless
public class TeachesHome {

	private static final Log log = LogFactory.getLog(TeachesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Teaches transientInstance) {
		log.debug("persisting Teaches instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Teaches persistentInstance) {
		log.debug("removing Teaches instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Teaches merge(Teaches detachedInstance) {
		log.debug("merging Teaches instance");
		try {
			Teaches result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Teaches findById(TeachesId id) {
		log.debug("getting Teaches instance with id: " + id);
		try {
			Teaches instance = entityManager.find(Teaches.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
