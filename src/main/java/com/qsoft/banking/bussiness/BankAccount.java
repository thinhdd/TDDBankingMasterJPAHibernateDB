package com.qsoft.banking.bussiness;

import com.qsoft.banking.persistence.dao.impl.BankAccountDAOImpl;
import com.qsoft.banking.persistence.model.impl.BankAccountDTOImpl;
import com.qsoft.banking.persistence.model.impl.TransactionDTOImpl;

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

    public BankAccountDTOImpl openAccount(String accountNumber);

    public BankAccountDTOImpl getAccount(String accountNumber) throws SQLException;

    public void doDeposit(String accountNumber, double amount, String des) throws SQLException;

    public void doWithDraw(String accountNumber, double amount, String des) throws SQLException;

    public List<TransactionDTOImpl> getAllTransaction(String accountNumber);

    public List<TransactionDTOImpl> getAllTransaction(String accountNumber, long start, long end);

    public List<TransactionDTOImpl> getAllTransaction(String accountNumber, int count);
}
