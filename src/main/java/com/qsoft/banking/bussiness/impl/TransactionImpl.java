package com.qsoft.banking.bussiness.impl;

import com.qsoft.banking.bussiness.Transaction;
import com.qsoft.banking.persistence.dao.impl.TransactionDAOImpl;
import com.qsoft.banking.persistence.model.impl.TransactionDTOImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 6/24/13
 * Time: 9:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionImpl implements Transaction {
    @Autowired
    static TransactionDAOImpl transactionDAO;

    public void setTransactionDAO(TransactionDAOImpl mockTDao) {
        transactionDAO = mockTDao;
        //To change body of created methods use File | Settings | File Templates.
    }

    public void createTransaction(String accountNumber, double amount, String des, boolean state) {
        TransactionDTOImpl transactionDTO = new TransactionDTOImpl(accountNumber, amount, des, state);
        transactionDAO.save(transactionDTO);
        //To change body of created methods use File | Settings | File Templates.
    }

    public List<TransactionDTOImpl> getAllTransaction(String accountNumber) {
        return transactionDAO.getAllTransacion(accountNumber);  //To change body of created methods use File | Settings | File Templates.
    }

    public List<TransactionDTOImpl> getAllTransaction(String accountNumber, long start, long end) {
        return transactionDAO.getAllTransacion(accountNumber, start, end);  //To change body of created methods use File | Settings | File Templates.
    }

    public List<TransactionDTOImpl> getAllTransaction(String accountNumber, int count) {
        return transactionDAO.getAllTransacion(accountNumber, count);
    }
}
