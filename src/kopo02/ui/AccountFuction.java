package kopo02.ui;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import kopo02.dao.AccountDao;
import kopo02.dao.AccountDaoImple;
import kopo02.dao.AccountItemDao;
import kopo02.dao.AccountItemDaoImple;
import kopo02.domain.Account;
import kopo02.service.Service;
import kopo02.service.ServiceImple;

public class AccountFuction {
	
	public static Scanner sc = new Scanner(System.in);
	
	
	public void AccountChoose() {
		int id =0;
		AccountDao dao1 = null;
		System.out.println("����� ���¸� ������ �ּ���.");
		try {
			dao1 = new AccountDaoImple();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("DB�� �����ϼ���");
			e.printStackTrace();
		}
		List<Account> accList = dao1.selectAll();
		System.out.println("ID   TITLE    CREATED");
		for(int i=0 ; i<accList.size();i++)
		System.out.printf("%3d %5s %s\n",accList.get(i).getId(),
									   accList.get(i).getTitle(),
									   accList.get(i).getCreated());
		
		System.out.println("���¿� �´� ID�� �Է����ּ���.(����� 99�Է�)");
		id = sc.nextInt();
		if(id == 99) {
			System.out.println("���α׷�����");
			sc.close();	
			System.exit(0);
		}else {
			try{
			Account acc = dao1.selectOne(id);
			acc.getTitle().equals(null);
			}
			catch(NullPointerException e) {
				System.out.println("���¸� �߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");
				AccountChoose();
			}
			AccountPurpose(id);
		}
		}
	
	public void AccountPurpose(int id) {
		int purpose = 0;
		
		AccountItemFuction aif = new AccountItemFuction();
		System.out.println("�뵵�� �Է����ּ���.");
		System.out.println("1.���������Է�");
		System.out.println("2.�����˻�");
		System.out.println("3.��������");
		System.out.println("4.��������");
		System.out.println("5.���ºм�");
		System.out.println("6.���´ٽü���(����ȭ������)");
		purpose = sc.nextInt();
		
		if(purpose ==1) {
			aif.AccountItemCreate(id);
		}else if(purpose == 2) {
			aif.AccountItemSelect(id);
		}else if(purpose == 3) {
			aif.AccountItemDelete(id);
		}else if(purpose == 4) {
			aif.AccountItemUpdate(id);
		}else if(purpose == 5) {
			Service ser = new ServiceImple();
			ser.ServiceIntro(id);
		}else if(purpose==6) {
			AccountChoose();
		}else {
			System.out.println("�ٽ� �Է��ϼ���");
			AccountPurpose(id);
		}
		
	}
	
}

	
