package kopo02.dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import kopo02.domain.Account;
import kopo02.domain.AccountItem;

//패키지이름과 클래스이름이 일치하는 src테스트하는 폴더i

public class AccountDaoTest {

	public static void main(String[] args) throws SQLException, ParseException {
		// TODO Auto-generated method stub	
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String da = "2017-05-04";
		Date date = df.parse(da);        
        Timestamp ts=new Timestamp(date.getTime());  
  
        System.out.println(ts.getMonth()+1);
        System.out.println(date);
        System.out.println(da);                
		
		
		
//		AccountDao dao = new AccountDaoImple();
//		AccountItemDao dao2 = new AccountItemDaoImple();
//		AccountItem accountItem = new AccountItem();
//		Account account = new Account();
//		account.setTitle("우리은행");
//		dao.create(account);
//		account = dao.selectOne(account);
//		accountItem.setAccount(account);
//		accountItem.setTitle("감자탕");
//		accountItem.setPrice(60000);
//		accountItem.setType("식비");
//		dao2.create(accountItem);
	}
	
//	@Test
//	public void testSelectOne() throws SQLException  {
//		AccountDao dao = new AccountDaoImple();
////		Account account = new Account();
////		account.setId(1);
//		Account account = dao.selectOne(1);
//		assertEquals(account.getTitle(),"개인용");
//	}

//	@Test
//	public void testSelectAll() throws SQLException{
//		AccountDaoImple dao = new AccountDaoImple();
//		Account account = new Account();
//		List<Account> account1 = dao.selectAll();
//		assertEquals(account1.size(),4);
//	}
//	
//	@Test
//	public void testSelectAllTitle() throws SQLException {
//		AccountDaoImple dao = new AccountDaoImple();
//		List<Account> account1 = dao.selectAllContainTitle("은행");
//		assertEquals(account1.size(),2);
//	}
	
//	@Test
//	public void testupdate() throws SQLException {
//		AccountDaoImple dao = new AccountDaoImple();
//		Account account = new Account();
//		account.setTitle("법인용");
//		dao.update(2, account);
//		account.setId(2);
//		dao.selectOne(account);
//		assertEquals(account.getTitle(),"법인용");
//	}
//
//	@Test
//	public void testdeleteone() throws SQLException {
//		AccountDaoImple dao = new AccountDaoImple();
//		Account account = new Account();
//		account.setId(1);
//		dao.deleteOne(account);
//		List<Account> account1 = dao.selectAll(account);
//		assertEquals(account1.size(),2); //foreign key라 안지워짐
//	}
//	@Test
//	public void testItemselectone() throws SQLException {
//		AccountItemDaoImple dao2 = new AccountItemDaoImple();
////		AccountItem accountItem = new AccountItem();
////		accountItem.setId(2);
//		AccountItem accountItem = dao2.selectOne(2);
//		assertEquals(accountItem.getTitle(),"부대찌개2"); 
//	}
//	@Test
//	public void testItemselectall() throws SQLException {
//		AccountItemDaoImple dao2 = new AccountItemDaoImple();	
//		List<AccountItem> account1 = dao2.selectAll();
//		assertEquals(account1.size(),8); 
//	}
//	@Test
//	public void testItemselectaccount() throws SQLException {
//		AccountItemDao dao2 = new AccountItemDaoImple();
//		AccountItem accountItem = new AccountItem();
//		Account account = new Account();
//		account.setId(1);
//		accountItem.setAccount(account);
//		List<AccountItem> account1 = dao2.selectAllContainAccount(accountItem);
//		assertEquals(account1.size(),5); 
//	}
//	@Test
//	public void testItemselectalltitle() throws SQLException {
//		AccountItemDaoImple dao2 = new AccountItemDaoImple();
//		List<AccountItem> account1 = dao2.selectAllContainTitle("감자");
//		assertEquals(account1.size(),7); 
//	}
//	@Test
//	public void testItemselectoverprice() throws SQLException {
//		AccountItemDaoImple dao2 = new AccountItemDaoImple();
//		AccountItem accountItem = new AccountItem();
//		accountItem.setPrice(6100);		
//		List<AccountItem> account1 = dao2.selectAllOverPrice(accountItem);
//		assertEquals(account1.size(),3); 
//	}
//	@Test
//	public void testItemselectunderprice() throws SQLException {
//		AccountItemDaoImple dao2 = new AccountItemDaoImple();
//		AccountItem accountItem = new AccountItem();
//		accountItem.setPrice(6100);		
//		List<AccountItem> account1 = dao2.selectAllUnderPrice(accountItem);
//		assertEquals(account1.size(),5); 
//	}
//	@Test
//	public void testItemselectovercreated() throws SQLException {
//		Calendar cl = Calendar.getInstance();
//		AccountItemDaoImple dao2 = new AccountItemDaoImple();
//		AccountItem accountItem = new AccountItem();
//		accountItem.setCreated(cl.getTime());		
//		List<AccountItem> account1 = dao2.selectAllOverCreated(accountItem);
//		assertEquals(account1.size(),0); 
//	}
//	@Test
//	public void testItemselectundercreated() throws SQLException {
//		Calendar cl = Calendar.getInstance();
//		AccountItemDaoImple dao2 = new AccountItemDaoImple();
//		AccountItem accountItem = new AccountItem();
//		accountItem.setCreated(cl.getTime());		
//		List<AccountItem> account1 = dao2.selectAllUnderCreated(accountItem);
//		assertEquals(account1.size(),8); 
//	}
//	@Test
//	public void testItemselectallbetweencreated() throws ParseException, SQLException {
//		AccountItemDaoImple dao2 = new AccountItemDaoImple();
//		String from1 = "2013-01-01";
//		String from2 = "2023-01-01";
//		
//		SimpleDateFormat sd = new SimpleDateFormat("YYYY-MM-DD");
//		Date to1 = sd.parse(from1);
//		Date to2 = sd.parse(from2);
//		System.out.println(to1);
//		List<AccountItem> account1 = dao2.selectAllBetweenCreated(to1,to2);
//		assertEquals(account1.size(),4); 
//	}
//	@Test
//	public void testItemselectcontaintype() throws SQLException {
//		AccountItemDaoImple dao2 = new AccountItemDaoImple();
//		AccountItem accountItem = new AccountItem();
//		accountItem.setType("식비");		
//		List<AccountItem> account1 = dao2.selectAllContainType(accountItem);
//		assertEquals(account1.size(),8); 
//	}
//	@Test
//	public void testItemupdateone() throws SQLException {
//		AccountItemDaoImple dao2 = new AccountItemDaoImple();
//		AccountItem accountItem = new AccountItem();
//		accountItem.setTitle("부대찌개");	
//		accountItem.setId(1);
//		dao2.update(1, accountItem);
//		dao2.selectOne(accountItem);
//		assertEquals(accountItem.getTitle(),"부대찌개"); 
//	}
//	@Test
//	public void testItemudeleteone() throws SQLException {
//		AccountItemDao dao2 = new AccountItemDaoImple();
//		AccountItem accountItem = new AccountItem();
//		accountItem.setId(1);
//		dao2.deleteOne(accountItem);
//		assertEquals(dao2.selectAll(accountItem).size(),8); 
//	}
	
	
	
	

//	public void testItemCreate() {
//		AccountDaoImple dao = new AccountDaoImple();
//		AccountItemDaoImple dao2 = new AccountItemDaoImple();
//		AccountItem accountItem = new AccountItem();
//		Account account = new Account();
//		account.setId(2);
//		account = dao.selectOne(account);
//		accountItem.setAccount(account);
//		accountItem.setTitle("감자탕");
//		accountItem.setPrice(6000);
//		accountItem.setType("식비");
////		dao2.create(accountItem);
//	}
}
