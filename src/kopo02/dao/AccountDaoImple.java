package kopo02.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kopo02.domain.Account;

public class AccountDaoImple extends GenericDaoImple<Account> implements AccountDao {


	public AccountDaoImple() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account create_Overriding(Statement stmt, Account account) {
		String sql =String.format("insert into Account(title) values('%s');",account.getTitle()); 
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return account;
		
	}

	public Account selectOne_Overriding(Statement stmt,int id){
		// TODO Auto-generated method stub
		Account account = new Account();
		String sql =String.format("select * from Account where id = %d",id);
//		System.out.println(sql);
		try {
			stmt.execute(sql);
			ResultSet rset = stmt.executeQuery(sql);
//			System.out.println("id title created");
			while (rset.next()) {
				account.setId(rset.getInt(1));
				account.setTitle(rset.getString(2));
				account.setCreated(rset.getDate(3));
//				System.out.printf("%3s %4s %10s\n",rset.getString(1),rset.getString(2),rset.getString(3));
			}
			rset.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
//			System.out.println("selected");
		return account;
	}

	
	public List<Account> selectAll_Overriding(Statement stmt) {
		List<Account> list = new ArrayList<Account>();
			try {
			String sql =String.format("select * from Account"); 
			stmt.execute(sql);
			ResultSet rset = stmt.executeQuery(sql);
//			System.out.println("id title created");
			
			while (rset.next()) {
				Account account = new Account();
				account.setId(rset.getInt(1));
				account.setTitle(rset.getString(2));
				account.setCreated(rset.getDate(3));
				list.add(account);
//				System.out.printf("%3s %4s %10s\n",rset.getString(1),rset.getString(2),rset.getString(3));
			}

			}catch(SQLException e) {
				
			}
//			System.out.println("selected");
			return list;
	}

	
	public List<Account> selectAllContainTitle_Overriding(Statement stmt,String title) {
			List<Account> list = new ArrayList<Account>();

			try {
			String sql =String.format("select * from Account where title like '%%%s%%'",title); 
			stmt.execute(sql);
			
			ResultSet rset = stmt.executeQuery(sql);
//			System.out.println("id title created");
			while (rset.next()) {
				Account account = new Account();
				account.setId(rset.getInt(1));
				account.setTitle(rset.getString(2));
				account.setCreated(rset.getDate(3));
				list.add(account);
//				System.out.printf("%3s %4s %10s\n",rset.getString(1),rset.getString(2),rset.getString(3));
			}
			}catch(SQLException e) {
				
			}
//			System.out.println("selected");
			return list;
	}

	public Account update_Overriding(Statement stmt,int id, Account account) {
		try {
			String sql =String.format("update Account set title = '%s' where id = %d",account.getTitle(),id); 
			stmt.execute(sql);
			
			ResultSet rset = stmt.executeQuery(sql);
			while (rset.next()) {
				account.setId(rset.getInt(1));
				account.setTitle(rset.getString(2));
				account.setCreated(rset.getDate(3));
			}
			}catch(SQLException e) {
				
			}
//			System.out.println("updated");
			return account;
		
	}


	@Override
	public Account deleteOne_Overriding(Statement stmt, Account account) {
			try {
			String sql =String.format("delete from Account where id = %d", account.getId());
			System.out.println(sql);
			stmt.execute(sql);
			}catch(SQLException e) {
				
			}
//			System.out.println("deleted");
			return account;
	}

	
	public Account deleteAllContainTitle_Overriding(Statement stmt, Account account) {
			try {
			String sql =String.format("delete from Account where title like '%%%s%%'", account.getTitle()); 
			stmt.execute(sql);
			}catch(SQLException e) {
				
			}
//			System.out.println("deleted");
			return account;
	}
	
	@Override
	public Account deleteAll_Overriding(Statement stmt,Account account) {
			try {
			String sql =String.format("delete from Account"); 
			stmt.execute(sql);
			}catch(SQLException e) {
				
			}
//			System.out.println("deleted");
			return account;
	}
	//select는 select 하나 와 select all로 나눔
	//select 하나는 변수에 담고 select all은 리스트이다.




}
