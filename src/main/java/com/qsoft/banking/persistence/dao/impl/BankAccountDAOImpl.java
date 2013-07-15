package com.qsoft.banking.persistence.dao.impl;

import com.qsoft.banking.persistence.dao.BankAccountDAO;
import com.qsoft.banking.persistence.model.impl.BankAccountDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 6/24/13
 * Time: 9:44 PM
 * To change this template use File | Settings | File Templates.
 */
@Transactional
@Component
public class BankAccountDAOImpl implements BankAccountDAO{
    @PersistenceContext
    private EntityManager entityManager;
    public BankAccountDAOImpl() {
    }

    public void save(BankAccountDTO account) {
    entityManager.persist(account);
    entityManager.flush();

        //To change body of created methods use File | Settings | File Templates.
    }

    public BankAccountDTO getAccount(String accountNumber) {

        Query query = entityManager.createQuery("select o from BankAccountDTO o where o.accountNumber = :qAccountNumber", BankAccountDTO.class);
        query.setParameter("qAccountNumber", accountNumber);
        List<BankAccountDTO> list = query.getResultList();
        if (list.size() == 0)
        {
            return null;
        }
        else
        {
            return list.get(0);
        }
    }
}
