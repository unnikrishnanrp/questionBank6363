package org.questionBank.data;
import java.util.List;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Home object for domain model class Question.
 * @see org.questionBank.data.Question
 * @author Hibernate Tools
 */

@Service
@Transactional
public class QuestionHome {
	private static final Log log = LogFactory.getLog(QuestionHome.class);
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Question> getQuestionsForCourse(Integer courseId){
		TypedQuery<Question> q = entityManager.createQuery("select q from Question q where courseId="+courseId, Question.class);
		List<Question> results = q.getResultList(); 
		return results;
	}

	@Transactional
	public void persist(Question transientInstance) {
		log.debug("persisting Question instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Transactional
	public void remove(Question persistentInstance) {
		log.debug("removing Question instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	@Transactional
	public Question merge(Question detachedInstance) {
		log.debug("merging Question instance");
		try {
			Question result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Question findById(Integer id) {
		log.debug("getting Question instance with id: " + id);
		try {
			Question instance = entityManager.find(Question.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List<Question> getQuestions(){
		TypedQuery<Question> q = entityManager.createQuery("select q from Question a", Question.class);
		List<Question> results = q.getResultList(); 
		return results;
	}
}