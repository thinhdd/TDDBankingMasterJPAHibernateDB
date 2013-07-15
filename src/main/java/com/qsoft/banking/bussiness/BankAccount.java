package com.qsoft.banking.bussiness;

import com.qsoft.banking.persistence.dao.impl.BankAccountDAOImpl;
import com.qsoft.banking.persistence.model.impl.BankAccountDTO;
import com.qsoft.banking.persistence.model.impl.TransactionDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 7/6/13
 * Time: 2:27 PM
 * To change this template use File | Settings | File Templates.
 */
public interface BankAccount {
    public void setBankAccountDAO(BankAccountDAOImpl mockDao);

    public BankAccountDTO openAccount(String accountNumber);

    public BankAccountDTO getAccount(String accountNumber) throws SQLException;

    public void doDeposit(String accountNumber, double amount, String des) throws SQLException;

    public void doWithDraw(String accountNumber, double amount, String des) throws SQLException;

    public List<TransactionDTO> getAllTransaction(String accountNumber);

    public List<TransactionDTO> getAllTransaction(String accountNumber, long start, long end);

    public List<TransactionDTO> getAllTransaction(String accountNumber, int count);
}
