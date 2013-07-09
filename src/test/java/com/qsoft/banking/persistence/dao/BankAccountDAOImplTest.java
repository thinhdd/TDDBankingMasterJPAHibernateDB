package com.qsoft.banking.persistence.dao;

import com.qsoft.banking.persistence.model.impl.BankAccountDTOImpl;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 7/8/13
 * Time: 10:26 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class BankAccountDAOImplTest {

    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    BankAccountDAO bankAccountDAO;
    @Autowired
    TransactionDAO transactionDAO;
    @Autowired
    DataSource dataSourcetest;
    IDatabaseTester iDatabaseTester;
    final String accountNumber="0123456789";
    final double balance = 100;
    @Before
    public void setup() throws Exception
    {
        IDataSet dataSet = readDataSet();
        cleanlyInsert(dataSet);
    }

    private IDataSet readDataSet() throws Exception
    {
        return new FlatXmlDataSetBuilder().build(System.class.getResource("/dataset.xml"));
    }

    private void cleanlyInsert(IDataSet dataSet) throws Exception
    {
        iDatabaseTester = new DataSourceDatabaseTester(dataSourcetest);
        iDatabaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        iDatabaseTester.setDataSet(dataSet);
        iDatabaseTester.onSetup();
    }

    @After
    public void tearDown() throws Exception
    {
        iDatabaseTester.onTearDown();
    }
    @Test
    public void testGetAccount() throws Exception {
        BankAccountDTOImpl bankAccountDTO = bankAccountDAO.getAccount(accountNumber);
        assertEquals(accountNumber, bankAccountDTO.getAccountNumber());
        assertEquals(100.0, bankAccountDTO.getBalance());
        assertEquals(12345678, bankAccountDTO.getTimeStamp());
    }
    @Test
    public void testGetAccountNonAxist() throws Exception {
        BankAccountDTOImpl bankAccountDTO = bankAccountDAO.getAccount("1234");
        assertTrue(bankAccountDTO==null);
    }
    @Test
    public void testSaveAccountNotAxist()
    {
        BankAccountDTOImpl accountDTO = new BankAccountDTOImpl("123456");
        bankAccountDAO.save(accountDTO);
        BankAccountDTOImpl accountDTO1 = bankAccountDAO.getAccount("123456");
        assertTrue(accountDTO1!=null);
    }


}
