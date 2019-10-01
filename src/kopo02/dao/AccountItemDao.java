package kopo02.dao;

import java.util.Date;
import java.util.List;

import kopo02.domain.Account;
import kopo02.domain.AccountItem;

public interface AccountItemDao extends GenericDao<AccountItem>{
	//C
//	AccountItem create(AccountItem accountitem);
	//���⿡ account���� Ÿ��Ʋ�� ��������ȴ�.
	//id�� DB���� �������� �ǰ� date�� �׳� ����ð����� ������ ��
	
	//R
//	AccountItem selectOne(AccountItem accountItem);//id�� ����
//	List<AccountItem> selectAll();//selectAll�� ����Ʈ / ���Ǿ��� �ٰ������
	List<AccountItem> selectAllContainAccount(AccountItem accountItem);//selectAll�� ����Ʈ / ���Ǿ��� �ٰ������
//	List<AccountItem> selectAllContainTitle(AccountItem accountItem);//������ �־� Ư�� �������� ������ �� �� �ִ�.
	List<AccountItem> selectAllOverPrice(AccountItem accountItem);//������ �־� Ư�� �������� ������ �� �� �ִ�.
	List<AccountItem> selectAllUnderPrice(AccountItem accountItem);//������ �־� Ư�� �������� ������ �� �� �ִ�.
	List<AccountItem> selectAllOverCreated(AccountItem accountItem);//������ �־� Ư�� �������� ������ �� �� �ִ�.
	List<AccountItem> selectAllUnderCreated(AccountItem accountItem);//������ �־� Ư�� �������� ������ �� �� �ִ�.
	List<AccountItem> selectAllBetweenCreated(Date created1,Date created2);//������ �־� Ư�� �������� ������ �� �� �ִ�.
	List<AccountItem> selectAllContainType(AccountItem accountItem);//������ �־� Ư�� �������� ������ �� �� �ִ�.
	
	
	
	//U
//	AccountItem updateOne(int id, AccountItem accountItem);
	
	
	//D
//	AccountItem deleteOne(AccountItem accountItem);
	AccountItem deleteContainType(AccountItem accountItem);
//	AccountItem deleteAll();
	
	
		
	
}
