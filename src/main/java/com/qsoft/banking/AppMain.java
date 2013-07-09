package com.qsoft.banking;

import com.qsoft.banking.persistence.dao.BankAccountDAO;
import com.qsoft.banking.persistence.model.impl.BankAccountDTOImpl;
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
    public static void main(String[] args)
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        BankAccountDAO bankAccountDAO = (BankAccountDAO) appContext.getBean("bankAccountDAO");
        BankAccountDTOImpl bankAccountDTO = new BankAccountDTOImpl("acx", 100, 1000l);
        bankAccountDAO.save(bankAccountDTO);
        //BankAccountServiceImpl
    }
}
