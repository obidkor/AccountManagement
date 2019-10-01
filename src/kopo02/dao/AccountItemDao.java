package kopo02.dao;

import java.util.Date;
import java.util.List;

import kopo02.domain.Account;
import kopo02.domain.AccountItem;

public interface AccountItemDao extends GenericDao<AccountItem>{
	//C
//	AccountItem create(AccountItem accountitem);
	//여기에 account에는 타이틀만 가져오면된다.
	//id는 DB에서 가져오면 되고 date는 그냥 현재시간으로 넣으면 됨
	
	//R
//	AccountItem selectOne(AccountItem accountItem);//id만 들고옴
//	List<AccountItem> selectAll();//selectAll은 리스트 / 조건없이 다가지고옴
	List<AccountItem> selectAllContainAccount(AccountItem accountItem);//selectAll은 리스트 / 조건없이 다가지고옴
//	List<AccountItem> selectAllContainTitle(AccountItem accountItem);//조건을 주어 특정 여러개만 가지고 올 수 있다.
	List<AccountItem> selectAllOverPrice(AccountItem accountItem);//조건을 주어 특정 여러개만 가지고 올 수 있다.
	List<AccountItem> selectAllUnderPrice(AccountItem accountItem);//조건을 주어 특정 여러개만 가지고 올 수 있다.
	List<AccountItem> selectAllOverCreated(AccountItem accountItem);//조건을 주어 특정 여러개만 가지고 올 수 있다.
	List<AccountItem> selectAllUnderCreated(AccountItem accountItem);//조건을 주어 특정 여러개만 가지고 올 수 있다.
	List<AccountItem> selectAllBetweenCreated(Date created1,Date created2);//조건을 주어 특정 여러개만 가지고 올 수 있다.
	List<AccountItem> selectAllContainType(AccountItem accountItem);//조건을 주어 특정 여러개만 가지고 올 수 있다.
	
	
	
	//U
//	AccountItem updateOne(int id, AccountItem accountItem);
	
	
	//D
//	AccountItem deleteOne(AccountItem accountItem);
	AccountItem deleteContainType(AccountItem accountItem);
//	AccountItem deleteAll();
	
	
		
	
}
