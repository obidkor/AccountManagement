package kopo02.dao;

import java.sql.SQLException;
import java.util.List;

import kopo02.domain.Account;

public interface AccountDao extends GenericDao<Account> {
	
	//C
//	Account create(Account account);
	//���⿡ account���� Ÿ��Ʋ�� ��������ȴ�.
	//id�� DB���� �������� �ǰ� date�� �׳� ����ð����� ������ ��
	
	
	//R
//	Account selectOne(Account account);//id�� ����
//	List<Account> selectAll();//selectAll�� ����Ʈ / ���Ǿ��� �ٰ������
//	List<Account> selectAllContainTitle(Account  account);//������ �־� Ư�� �������� ������ �� �� �ִ�.
	
	//U
//	Account update(int id, Account account);
	
	
	//D
//	Account deleteOne(Account account);
//	List<Account> deleteAllContainTitle(Account account);
//	List<Account> deleteAll();
	
	
		
	
}
