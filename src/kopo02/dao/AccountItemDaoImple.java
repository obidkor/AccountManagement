package kopo02.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kopo02.domain.Account;
import kopo02.domain.AccountItem;

public class AccountItemDaoImple extends GenericDaoImple<AccountItem> implements AccountItemDao {


	public AccountItemDaoImple() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountItem create_Overriding(Statement stmt, AccountItem accountItem) {
		String sql =String.format("insert into AccountItem(account_id,title,price,type,payment) values(%d,'%s','%s','%s','%s')",
				accountItem.getAccount().getId(),accountItem.getTitle(),accountItem.getPrice(),
				accountItem.getType(),accountItem.getPayment()); 
		try {
		stmt.execute(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("create_Overriding");
		return accountItem;
	}

	public AccountItem selectOne_Overriding(Statement stmt,int id) {
		AccountItem accountItem = new AccountItem();
		DecimalFormat df = new DecimalFormat("###,###,###");
			String sql =String.format("select * from AccountItem where id = %d",id); 
			try {
			stmt.execute(sql);
			ResultSet rset = stmt.executeQuery(sql);
//			ResultSet rset2 = stmt.executeQuery(sql);
//			System.out.println("id account_id title created    price type");
			while (rset.next()) {
				AccountDao dao = new AccountDaoImple();
				Account account = new Account();
				account = dao.selectOne(rset.getInt(2));
//				account.setId(rset.getInt(2));
				accountItem.setId(rset.getInt(1));
				accountItem.setAccount(account);
				accountItem.setTitle(rset.getString(3));
				accountItem.setCreated(rset.getTimestamp(4));
				accountItem.setPrice(rset.getInt(5));
				accountItem.setType(rset.getString(6));
				accountItem.setPayment(rset.getString(7));
//				System.out.printf("%3s %4s %5s %10s %4s %5s\n",rset.getString(1),rset.getString(2),rset.getString(3)
//						  						,rset.getString(4),df.format(rset.getInt(5)),rset.getString(6));
			} 
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
//			System.out.println("selected");
		return accountItem;
	}


	public List<AccountItem> selectAll_Overriding(Statement stmt) {

		List<AccountItem> list = new ArrayList<AccountItem>();
		DecimalFormat df = new DecimalFormat("###,###,###");
			
			try {
			String sql =String.format("select * from AccountItem"); 
			stmt.execute(sql);
			
			ResultSet rset = stmt.executeQuery(sql);
//			System.out.println("id account_id title created    price type");
			while (rset.next()) {
				AccountDao dao = new AccountDaoImple();
				Account account = new Account();
				AccountItem accountItem = new AccountItem();
				account = dao.selectOne(rset.getInt(2));
				accountItem.setId(rset.getInt(1));
				accountItem.setAccount(account);
				accountItem.setTitle(rset.getString(3));
				accountItem.setCreated(rset.getTimestamp(4));
				accountItem.setPrice(rset.getInt(5));
				accountItem.setType(rset.getString(6));
				accountItem.setPayment(rset.getString(7));
				list.add(accountItem);

			} 
			}catch(SQLException e) {
				
			}
//			System.out.println("selected");
			return list;
	}
	
	
	
	@Override
	public List<AccountItem> selectAllContainAccount(AccountItem accountItem) {
		DecimalFormat df = new DecimalFormat("###,###,###");
		List<AccountItem> list = new ArrayList<AccountItem>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				
			}
			try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/kopoctc","root","rlarldbs21");
			java.sql.Statement stmt = conn.createStatement();

			String sql =String.format("select * from AccountItem where account_id = %d",accountItem.getAccount().getId()); 
			stmt.execute(sql);
			
			ResultSet rset = stmt.executeQuery(sql);
			System.out.println("id account_id title created    price type");
			while (rset.next()) {
				AccountDao dao = new AccountDaoImple();
				Account account = new Account();
				account = dao.selectOne(rset.getInt(2));
				accountItem.setId(rset.getInt(1));
				accountItem.setAccount(account);
				accountItem.setTitle(rset.getString(3));
				accountItem.setCreated(rset.getTimestamp(4));
				accountItem.setPrice(rset.getInt(5));
				accountItem.setType(rset.getString(6));
				accountItem.setPayment(rset.getString(7));
				list.add(accountItem);
				System.out.printf("%3s %4s %5s %10s %4s %5s\n",rset.getString(1),rset.getString(2),rset.getString(3)
						  						,rset.getString(4),df.format(rset.getInt(5)),rset.getString(6));
			} 
			stmt.close();
			conn.close();
			}catch(SQLException e) {
				
			}
			System.out.println("selected");
		return list;
	}
	
	
	@Override
	public List<AccountItem> selectAllContainTitle_Overriding(Statement stmt,String title) {
		AccountItem accountItem = new AccountItem();
		DecimalFormat df = new DecimalFormat("###,###,###");
		List<AccountItem> list = new ArrayList<AccountItem>();
			try {
			String sql =String.format("select * from AccountItem where title like '%%%s%%'",title); 
			stmt.execute(sql);

			ResultSet rset = stmt.executeQuery(sql);
			System.out.println("id account_id title created    price type");
			while (rset.next()) {
				AccountDao dao = new AccountDaoImple();
				Account account = new Account();
				account = dao.selectOne(rset.getInt(2));
				accountItem.setId(rset.getInt(1));
				accountItem.setAccount(account);
				accountItem.setTitle(rset.getString(3));
				accountItem.setCreated(rset.getTimestamp(4));
				accountItem.setPrice(rset.getInt(5));
				accountItem.setType(rset.getString(6));
				accountItem.setPayment(rset.getString(7));
				list.add(accountItem);
				System.out.printf("%3s %4s %5s %10s %4s %5s\n",rset.getString(1),rset.getString(2),rset.getString(3)
						  						,rset.getString(4),df.format(rset.getInt(5)),rset.getString(6));
			} 
			}catch(SQLException e) {
				
			}
			System.out.println("selected");
		return list;
	}

	@Override
	public List<AccountItem> selectAllOverPrice(AccountItem accountItem) {
		DecimalFormat df = new DecimalFormat("###,###,###");
		List<AccountItem> list = new ArrayList<AccountItem>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				
			}
			try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/kopoctc","root","rlarldbs21");
			java.sql.Statement stmt = conn.createStatement();

			String sql =String.format("select * from AccountItem where price >= %d",accountItem.getPrice()); 
			stmt.execute(sql);
			
			ResultSet rset = stmt.executeQuery(sql);
			System.out.println("id account_id title created    price type");
			while (rset.next()) {
				Account account = new Account();
				accountItem.setId(rset.getInt(1));
				accountItem.setAccount(account);
				accountItem.setTitle(rset.getString(3));
				accountItem.setCreated(rset.getTimestamp(4));
				accountItem.setPrice(rset.getInt(5));
				accountItem.setType(rset.getString(6));
				accountItem.setPayment(rset.getString(7));
				list.add(accountItem);
				System.out.printf("%3s %4s %5s %10s %4s %5s\n",rset.getString(1),rset.getString(2),rset.getString(3)
						  						,rset.getString(4),df.format(rset.getInt(5)),rset.getString(6));
			} 
			stmt.close();
			conn.close();
			}catch(SQLException e) {
				
			}
			System.out.println("selected");
		return list;
	}
	
	@Override
	public List<AccountItem> selectAllUnderPrice(AccountItem accountItem) {
		DecimalFormat df = new DecimalFormat("###,###,###");
		List<AccountItem> list = new ArrayList<AccountItem>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				
			}
			try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/kopoctc","root","rlarldbs21");
			java.sql.Statement stmt = conn.createStatement();

			String sql =String.format("select * from AccountItem where price <= %d",accountItem.getPrice()); 
			stmt.execute(sql);
			
			ResultSet rset = stmt.executeQuery(sql);
			System.out.println("id account_id title created    price type");
			while (rset.next()) {
				Account account = new Account();
				accountItem.setId(rset.getInt(1));
				accountItem.setAccount(account);
				accountItem.setTitle(rset.getString(3));
				accountItem.setCreated(rset.getTimestamp(4));
				accountItem.setPrice(rset.getInt(5));
				accountItem.setType(rset.getString(6));
				accountItem.setPayment(rset.getString(7));
				list.add(accountItem);
				System.out.printf("%3s %4s %5s %10s %4s %5s\n",rset.getString(1),rset.getString(2),rset.getString(3)
						  						,rset.getString(4),df.format(rset.getInt(5)),rset.getString(6));
			} 
			stmt.close();
			conn.close();
			}catch(SQLException e) {
				
			}
			System.out.println("selected");
		return list;
	}

	@Override
	public List<AccountItem> selectAllOverCreated(AccountItem accountItem) {
		DecimalFormat df = new DecimalFormat("###,###,###");
		List<AccountItem> list = new ArrayList<AccountItem>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				
			}
			try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/kopoctc","root","rlarldbs21");
			java.sql.Statement stmt = conn.createStatement();

			String sql =String.format("select * from AccountItem where created >= '%s';",accountItem.getCreated()); 
			stmt.execute(sql);
			
			ResultSet rset = stmt.executeQuery(sql);
			System.out.println("id account_id title created    price type");
			while (rset.next()) {
				Account account = new Account();
				accountItem.setId(rset.getInt(1));
				accountItem.setAccount(account);
				accountItem.setTitle(rset.getString(3));
				accountItem.setCreated(rset.getTimestamp(4));
				accountItem.setPrice(rset.getInt(5));
				accountItem.setType(rset.getString(6));
				accountItem.setPayment(rset.getString(7));
				list.add(accountItem);
				System.out.printf("%3s %4s %5s %10s %4s %5s\n",rset.getString(1),rset.getString(2),rset.getString(3)
						  						,rset.getString(4),df.format(rset.getInt(5)),rset.getString(6));
			} 
			stmt.close();
			conn.close();
			}catch(SQLException e) {
				
			}
			System.out.println("selected");
		return list;
	}

	@Override
	public List<AccountItem> selectAllUnderCreated(AccountItem accountItem) {
		DecimalFormat df = new DecimalFormat("###,###,###");
		List<AccountItem> list = new ArrayList<AccountItem>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				
			}
			try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/kopoctc","root","rlarldbs21");
			java.sql.Statement stmt = conn.createStatement();

			String sql =String.format("select * from AccountItem where created <= '%s';",accountItem.getCreated()); 
			stmt.execute(sql);
			System.out.println(sql);
			ResultSet rset = stmt.executeQuery(sql);
			System.out.println("id account_id title created    price type");
			while (rset.next()) {
				Account account = new Account();
				accountItem.setId(rset.getInt(1));
				accountItem.setAccount(account);
				accountItem.setTitle(rset.getString(3));
				accountItem.setCreated(rset.getTimestamp(4));
				accountItem.setPrice(rset.getInt(5));
				accountItem.setType(rset.getString(6));
				accountItem.setPayment(rset.getString(7));
				list.add(accountItem);
				System.out.printf("%3s %4s %5s %10s %4s %5s\n",rset.getString(1),rset.getString(2),rset.getString(3)
						  						,rset.getString(4),df.format(rset.getInt(5)),rset.getString(6));
			} 
			stmt.close();
			conn.close();
			}catch(SQLException e) {
				
			}
			System.out.println("selected");
		return list;
	}

	@Override
	public List<AccountItem> selectAllBetweenCreated(Date created1, Date created2) {
		DecimalFormat df = new DecimalFormat("###,###,###");
		List<AccountItem> list = new ArrayList<AccountItem>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				
			}
			try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/kopoctc","root","rlarldbs21");
			java.sql.Statement stmt = conn.createStatement();

			String sql =String.format("select * from AccountItem where created >= DATE_FORMAT('%s', '%Y-%m-%d') AND created <= DATE_FORMAT('%s', '%Y-%m-%d')",created1,created2); 
			stmt.execute(sql);
			System.out.println(sql);
			ResultSet rset = stmt.executeQuery(sql);
			System.out.println("id account_id title created    price type");
			while (rset.next()) {
				AccountItem accountItem = new AccountItem();
				Account account = new Account();
				accountItem.setId(rset.getInt(1));
				accountItem.setAccount(account);
				accountItem.setTitle(rset.getString(3));
				accountItem.setCreated(rset.getTimestamp(4));
				accountItem.setPrice(rset.getInt(5));
				accountItem.setType(rset.getString(6));
				accountItem.setPayment(rset.getString(7));
				list.add(accountItem);
				System.out.printf("%3s %4s %5s %10s %4s %5s\n",rset.getString(1),rset.getString(2),rset.getString(3)
						  						,rset.getString(4),df.format(rset.getInt(5)),rset.getString(6));
			} 
			stmt.close();
			conn.close();
			}catch(SQLException e) {
				
			}
			System.out.println("selected");
		return list;
	}
	
	
	@Override
	public List<AccountItem> selectAllContainType(AccountItem accountItem) {
		DecimalFormat df = new DecimalFormat("###,###,###");
		List<AccountItem> list = new ArrayList<AccountItem>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				
			}
			try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/kopoctc","root","rlarldbs21");
			java.sql.Statement stmt = conn.createStatement();

			String sql =String.format("select * from AccountItem where type = '%s'",accountItem.getType()); 
			stmt.execute(sql);
			
			ResultSet rset = stmt.executeQuery(sql);
			System.out.println("id account_id title created    price type");
			while (rset.next()) {
				Account account = new Account();
				accountItem.setId(rset.getInt(1));
				accountItem.setAccount(account);
				accountItem.setTitle(rset.getString(3));
				accountItem.setCreated(rset.getTimestamp(4));
				accountItem.setPrice(rset.getInt(5));
				accountItem.setType(rset.getString(6));
				accountItem.setPayment(rset.getString(7));
				list.add(accountItem);
				System.out.printf("%3s %4s %5s %10s %4s %5s\n",rset.getString(1),rset.getString(2),rset.getString(3)
						  						,rset.getString(4),df.format(rset.getInt(5)),rset.getString(6));
			} 
			stmt.close();
			conn.close();
			}catch(SQLException e) {
				
			}
			System.out.println("selected");
		return list;
	}


	public AccountItem update_Overriding(Statement stmt,int id, AccountItem accountItem) {
		DecimalFormat df = new DecimalFormat("###,###,###");
		String filter = "";
		String sql = "";
		if(accountItem.getTitle() != null) {
			filter = "title";
			sql =String.format("update AccountItem set " + filter + " = '%s' where id = %d",accountItem.getTitle(), id); 
		}else if(accountItem.getPrice() != 0) {
			filter = "price";
			sql =String.format("update AccountItem set " + filter + " = %d where id = %d",accountItem.getPrice(), id); 
		}else if(accountItem.getType() != null) {
			filter = "type";
			sql =String.format("update AccountItem set " + filter + " = '%s' where id = %d",accountItem.getType(), id); 
		}else if(accountItem.getPayment() != null) {
			filter = "payment";
			sql =String.format("update AccountItem set " + filter + " = '%s' where id = %d",accountItem.getPayment(), id);
		}
		try {

		stmt.execute(sql);

		}catch(SQLException e) {
			
		}
		System.out.println("updated");
		return accountItem;

	}

	@Override
	public AccountItem deleteOne_Overriding(Statement stmt,AccountItem accountItem) {
			try {
			String sql =String.format("delete from AccountItem where id = %d", accountItem.getId()); 
			stmt.execute(sql);
			}catch(SQLException e) {
				
			}
			System.out.println("deleted");
			return null;
	}


	@Override
	public AccountItem deleteContainType(AccountItem accountItem) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				
			}
			try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/kopoctc","root","rlarldbs21");
			Statement stmt = conn.createStatement();

			String sql =String.format("delete from AccountItem where type = '%s'", accountItem.getType()); 
			stmt.execute(sql);
			
//			ResultSet rset = stmt.executeQuery(sql);
			
			stmt.close();
			conn.close();
			}catch(SQLException e) {
				
			}
			System.out.println("deleted");
			return accountItem;
	}


	public AccountItem deleteAll_Overriding(Statement stmt,AccountItem accountItem) {
			try {
			String sql =String.format("delete from AccountItem"); 
			stmt.execute(sql);
			}catch(SQLException e) {
				
			}
			System.out.println("deleted");
			return accountItem;
	}






}
