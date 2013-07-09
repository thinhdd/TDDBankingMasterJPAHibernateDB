package com.qsoft.banking.persistence.dao.impl;

import com.qsoft.banking.persistence.dao.TransactionDAO;
import com.qsoft.banking.persistence.model.impl.TransactionDTOImpl;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 6/24/13
 * Time: 9:59 PM
 * To change this template use File | Settings | File Templates.
 */
@Transactional
@Component
public class TransactionDAOImpl implements TransactionDAO {

    public void save(TransactionDTOImpl capture) {
        //To change body of created methods use File | Settings | File Templates.
    }

    public List<TransactionDTOImpl> getAllTransacion(String accountNumber) {
        return null;
        //To change body of created methods use File | Settings | File Templates.
    }

    public List<TransactionDTOImpl> getAllTransacion(String accountNumber, long start, long end) {
        return null;
    }

    public List<TransactionDTOImpl> getAllTransacion(String accountNumber, int count) {
        return null;
        //To change body of created methods use File | Settings | File Templates.
    }
}
