package com.qsoft.banking;

import com.qsoft.banking.persistence.dao.BankAccountDAO;
import com.qsoft.banking.persistence.model.impl.BankAccountDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 7/8/13
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class AppMain
{
    public static void main(String[] args) throws Exception {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        BankAccountDAO bankAccountDAO = (BankAccountDAO) appContext.getBean("bankAccountDAO");
        BankAccountDTO bankAccountDTO = new BankAccountDTO("acx", 100, 1000l);
        bankAccountDAO.save(bankAccountDTO);
        //BankAccountServiceImpl
    }
}
