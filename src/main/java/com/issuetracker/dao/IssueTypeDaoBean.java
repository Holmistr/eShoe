package com.issuetracker.dao;

import com.issuetracker.dao.api.IssueTypeDao;
import com.issuetracker.model.IssueType;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mgottval
 */
@Stateless
public class IssueTypeDaoBean implements IssueTypeDao {

    @PersistenceContext
    private EntityManager em;
     private CriteriaBuilder qb;
     
    @Override
    public void insert(IssueType issueType) {
        em.persist(issueType);
    }

    @Override
    public List<IssueType> getIssueTypes() {     
        
        qb = em.getCriteriaBuilder();
        CriteriaQuery<IssueType> c = qb.createQuery(IssueType.class);
        Root<IssueType> i = c.from(IssueType.class);
        TypedQuery<IssueType> q = em.createQuery(c);
        List<IssueType> results =  q.getResultList();
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return new ArrayList<IssueType>();
    }
}
