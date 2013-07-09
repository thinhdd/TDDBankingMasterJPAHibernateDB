package com.qsoft.banking.persistence.dao;

import com.qsoft.banking.persistence.model.impl.TransactionDTOImpl;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 7/6/13
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
public interface TransactionDAO {
    public void save(TransactionDTOImpl capture);

    public List<TransactionDTOImpl> getAllTransacion(String accountNumber);

    public List<TransactionDTOImpl> getAllTransacion(String accountNumber, long start, long end);

    public List<TransactionDTOImpl> getAllTransacion(String accountNumber, int count);
}
