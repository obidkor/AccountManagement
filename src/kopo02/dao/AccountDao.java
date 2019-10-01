package kopo02.dao;

import java.sql.SQLException;
import java.util.List;

import kopo02.domain.Account;

public interface AccountDao extends GenericDao<Account> {
	
	//C
//	Account create(Account account);
	//여기에 account에는 타이틀만 가져오면된다.
	//id는 DB에서 가져오면 되고 date는 그냥 현재시간으로 넣으면 됨
	
	
	//R
//	Account selectOne(Account account);//id만 들고옴
//	List<Account> selectAll();//selectAll은 리스트 / 조건없이 다가지고옴
//	List<Account> selectAllContainTitle(Account  account);//조건을 주어 특정 여러개만 가지고 올 수 있다.
	
	//U
//	Account update(int id, Account account);
	
	
	//D
//	Account deleteOne(Account account);
//	List<Account> deleteAllContainTitle(Account account);
//	List<Account> deleteAll();
	
	
		
	
}
