package com.qsoft.banking.bussiness.impl;

import com.qsoft.banking.bussiness.BankAccount;
import com.qsoft.banking.persistence.dao.impl.BankAccountDAOImpl;
import com.qsoft.banking.persistence.model.impl.BankAccountDTOImpl;
import com.qsoft.banking.persistence.model.impl.TransactionDTOImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 6/24/13
 * Time: 9:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountImpl implements BankAccount {
    @Autowired
    BankAccountDAOImpl bankAccountDAO;

    public void setBankAccountDAO(BankAccountDAOImpl mockDao) {
        bankAccountDAO = mockDao;
        //To change body of created methods use File | Settings | File Templates.
    }

    public BankAccountDTOImpl openAccount(String accountNumber) {
        BankAccountDTOImpl account = new BankAccountDTOImpl(accountNumber);
        bankAccountDAO.save(account);
        return account;
        //To change body of created methods use File | Settings | File Templates.
    }


    public BankAccountDTOImpl getAccount(String accountNumber) throws SQLException {
        return bankAccountDAO.getAccount(accountNumber);  //To change body of created methods use File | Settings | File Templates.
    }


    public void doDeposit(String accountNumber, double amount, String des) throws SQLException {
        BankAccountDTOImpl account = bankAccountDAO.getAccount(accountNumber);
        TransactionImpl transactionImpl = new TransactionImpl();
        transactionImpl.createTransaction(accountNumber, amount, des, true);
        account.setBalance(amount);
        bankAccountDAO.save(account);
        //To change body of created methods use File | Settings | File Templates.
    }

    public void doWithDraw(String accountNumber, double amount, String des) throws SQLException {
        BankAccountDTOImpl account = bankAccountDAO.getAccount(accountNumber);
        TransactionImpl transactionImpl = new TransactionImpl();
        transactionImpl.createTransaction(accountNumber, amount, des, false);
        account.setBalance(-amount);
        bankAccountDAO.save(account);
        //To change body of created methods use File | Settings | File Templates.
    }

    public List<TransactionDTOImpl> getAllTransaction(String accountNumber) {
        TransactionImpl transactionImpl = new TransactionImpl();
        return transactionImpl.getAllTransaction(accountNumber);
        //To change body of created methods use File | Settings | File Templates.
    }

    public List<TransactionDTOImpl> getAllTransaction(String accountNumber, long start, long end) {
        TransactionImpl transactionImpl = new TransactionImpl();
        return transactionImpl.getAllTransaction(accountNumber, start, end);
        //To change body of created methods use File | Settings | File Templates.
    }

    public List<TransactionDTOImpl> getAllTransaction(String accountNumber, int count) {
        TransactionImpl transactionImpl = new TransactionImpl();
        return transactionImpl.getAllTransaction(accountNumber, count);
        //To change body of created methods use File | Settings | File Templates.
    }
}
