package kopo02.dao;



import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface GenericDao<T>{//T�� account�� ���� ���� �ְ� accountitem�� ���� ���� �ִ�.
	//generic�����ؼ��� Ÿ���� �־��� ���� �ִ�.
	//C
	T create(T t);
	T create_Overriding(Statement stmt, T t);
	
	//R
	T selectOne(int id);
	T selectOne_Overriding(Statement stmt, int id);
	List<T> selectAll();
	List<T> selectAll_Overriding(Statement stmt);
	List<T> selectAllContainTitle(String title);
	List<T> selectAllContainTitle_Overriding(Statement stmt,String title);

	
	//U
	T update(int id, T t);
	T update_Overriding(Statement stmt,int id, T t);
	
	
	//D
	T deleteOne(T t);
	T deleteOne_Overriding(Statement stmt,T t);
	T deleteAll(T t);
	T deleteAll_Overriding(Statement stmt,T t);

	
	
	
}
