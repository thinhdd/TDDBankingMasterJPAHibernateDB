package com.qsoft.banking.bussiness;

import com.qsoft.banking.persistence.dao.impl.TransactionDAOImpl;
import com.qsoft.banking.persistence.model.impl.TransactionDTOImpl;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 7/6/13
 * Time: 2:27 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Transaction {
    public void setTransactionDAO(TransactionDAOImpl mockTDao);

    public void createTransaction(String accountNumber, double amount, String des, boolean state);

    public List<TransactionDTOImpl> getAllTransaction(String accountNumber);

    public List<TransactionDTOImpl> getAllTransaction(String accountNumber, long start, long end);

    public List<TransactionDTOImpl> getAllTransaction(String accountNumber, int count);
}
