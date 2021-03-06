package com.qsoft.banking.bussiness;

import com.qsoft.banking.bussiness.impl.BankAccountImpl;
import com.qsoft.banking.persistence.dao.impl.BankAccountDAOImpl;
import com.qsoft.banking.persistence.model.impl.BankAccountDTO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.sql.SQLException;
import java.util.Calendar;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 6/24/13
 * Time: 9:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestServiceAccount {
    public BankAccountDAOImpl mockDao= mock(BankAccountDAOImpl.class);
    public Calendar calendar = mock(Calendar.class);
    public String accountNumber = "123456";
    BankAccountImpl bankAccount = new BankAccountImpl();
    @Before
    public void setUp()
    {
        reset(mockDao);
        reset(calendar);
        BankAccountDTO.setCalendar(calendar);
        bankAccount.setBankAccountDAO(mockDao);
    }
    @Test
    public void testOpenAccount()
    {
        ArgumentCaptor<BankAccountDTO> ac = ArgumentCaptor.forClass(BankAccountDTO.class);
        BankAccountDTO bankAccount1 = bankAccount.openAccount(accountNumber);
        verify(mockDao).save(ac.capture());
        assertEquals(accountNumber, ac.getValue().getAccountNumber());
        assertEquals(0.0, ac.getValue().getBalance());
    }
    @Test
    public void testGetAccount() throws SQLException {
        BankAccountDTO account = new BankAccountDTO(accountNumber);
        when(mockDao.getAccount(accountNumber)).thenReturn(account);
        BankAccountDTO accountResult = bankAccount.getAccount(accountNumber);
        assertEquals(account, accountResult);
    }
    @Test
    public void testCheckTimeStamp()
    {
        ArgumentCaptor<BankAccountDTO> ac = ArgumentCaptor.forClass(BankAccountDTO.class);
        when(calendar.getTimeInMillis()).thenReturn(1000l);
        bankAccount.openAccount(accountNumber);
        verify(mockDao).save(ac.capture());
        assertEquals(ac.getValue().getAccountNumber(), accountNumber);
        assertEquals(ac.getValue().getBalance(), 0.0);
        assertEquals(ac.getValue().getTimeStamp(), 1000l);;
    }
}
