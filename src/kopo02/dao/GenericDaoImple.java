package kopo02.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public abstract class GenericDaoImple<T> implements GenericDao<T>{
	
	private String address = "jdbc:mysql://192.168.56.102:3306/kopoctc";
	private String id = "root";
	private String pwd = "rlarldbs21";
	private Connection conn = DriverManager.getConnection(address,id,pwd);
	private Statement stmt = conn.createStatement();	
	
	
	public <T> GenericDaoImple() throws SQLException{

	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		conn.close();
		stmt.close();
	}

	@Override
	public T create(T t)  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		T ret = create_Overriding(stmt, t);
//		try {
//		conn.close();
//		stmt.close();
//		}catch(SQLException E) {
//			E.printStackTrace();
//			}
		System.out.println("create");
		return ret;
	}


	@Override
	public T selectOne(int id){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//		String address = "jdbc:mysql://192.168.56.102:3306/kopoctc";
//		String id = "root";
//		String pwd = "rlarldbs21";
//		Connection conn = DriverManager.getConnection(address,id,pwd);
//		Statement stmt = conn.createStatement();
		T ret = selectOne_Overriding(stmt, id);
//		try {
//		conn.close();
//		stmt.close();
//		}catch(SQLException E) {
//			E.printStackTrace();
//			}
//		System.out.println(ret);
		
		return ret;
	}


	
	@Override
	public List<T> selectAll() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//		String address = "jdbc:mysql://192.168.56.102:3306/kopoctc";
//		String id = "root";
//		String pwd = "rlarldbs21";
//		Connection conn = DriverManager.getConnection(address,id,pwd);
//		Statement stmt = conn.createStatement();
		List<T> ret = selectAll_Overriding(stmt);
//		System.out.println("selected");
//		try {
//		conn.close();
//		stmt.close();
//		}catch(SQLException E) {
//			E.printStackTrace();
//		}
		return ret;
	}

@Override
public List<T> selectAllContainTitle(String title) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//		String address = "jdbc:mysql://192.168.56.102:3306/kopoctc";
//		String id = "root";
//		String pwd = "rlarldbs21";
//		Connection conn = DriverManager.getConnection(address,id,pwd);
//		Statement stmt = conn.createStatement();
		List<T> ret = selectAllContainTitle_Overriding(stmt,title);
//		try {
//		conn.close();
//		stmt.close();
//		}catch(SQLException E) {
//			E.printStackTrace();
//		}
//		System.out.println("selected");
		return ret;
}
@Override
public T update(int id, T t) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	//	String address = "jdbc:mysql://192.168.56.102:3306/kopoctc";
//	String id1 = "root";
//	String pwd = "rlarldbs21";
//	Connection conn = DriverManager.getConnection(address,id1,pwd);
//	Statement stmt = conn.createStatement();
	T ret = update_Overriding(stmt,id,t);
//	try {
//	conn.close();
//	stmt.close();
//	}catch(SQLException E) {
//		E.printStackTrace();
//	}
//	System.out.println("selected");
	return ret;
}


@Override
public T deleteOne(T t) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	//		String address = "jdbc:mysql://192.168.56.102:3306/kopoctc";
//	String id = "root";
//	String pwd = "rlarldbs21";
//	Connection conn = DriverManager.getConnection(address,id,pwd);
//	Statement stmt = conn.createStatement();
	T ret = deleteOne_Overriding(stmt,t);
//	try {
//	conn.close();
//	stmt.close();
//	}catch(SQLException E) {
//		E.printStackTrace();
//	}
//	System.out.println("selected");
	return ret;
}


@Override
public T deleteAll(T t) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	//		String address = "jdbc:mysql://192.168.56.102:3306/kopoctc";
//	String id = "root";
//	String pwd = "rlarldbs21";
//	Connection conn = DriverManager.getConnection(address,id,pwd);
//	Statement stmt = conn.createStatement();
	T ret = deleteAll_Overriding(stmt,t);
//	try {
//	conn.close();
//	stmt.close();
//	}catch(SQLException E) {
//		E.printStackTrace();
//	}
//	System.out.println("selected");
	return ret;
}
//@Override
//public T create_Overriding(Statement stmt ,T t) {
//	// TODO Auto-generated method stub
//	return null;
//}
//@Override
//public T selectOne_Overriding(Statement stmt, T t) {
//	// TODO Auto-generated method stub
//	return null;
//}
//
//@Override
//public T selectAll_Overriding(Statement stmt) {
//	// TODO Auto-generated method stub
//	return null;
//}
//
//@Override
//public List<T> selectAllContainTitle_Overriding(Statement stmt, T t) {
//	// TODO Auto-generated method stub
//	return null;
//}
//@Override
//public T deleteAll_Overriding(Statement stmt) {
//	// TODO Auto-generated method stub
//	return null;
//}
//@Override
//public T update_Overriding(Statement stmt, int id, T t) {
//	// TODO Auto-generated method stub
//	return null;
//}
//@Override
//public T deleteOne_Overriding(Statement stmt, T t) {
//	// TODO Auto-generated method stub
//	return null;
//}



}
