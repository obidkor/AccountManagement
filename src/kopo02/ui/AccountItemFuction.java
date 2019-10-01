package kopo02.ui;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import kopo02.dao.AccountItemDao;
import kopo02.dao.AccountItemDaoImple;
import kopo02.domain.Account;
import kopo02.domain.AccountItem;

public class AccountItemFuction {
	
	public void AccountItemCreate(int id) {
		System.out.println("�������� ������ �Է��� �ּ���");
		System.out.println("1.�ĺ�/2.�ְź�/3.�Ǻ��̿��/4.���������/5.��ȭ��Ȱ��/6.�������" + 
				"7.��Ÿ/8.����/9.�����޴�(�����Է�)");
		int typetmp = AccountFuction.sc.nextInt();
		if (typetmp==9) {
			AccountFuction af = new AccountFuction();
			af.AccountPurpose(id);
		}else if(typetmp >= 10) {
			System.out.println("�ٽ� �Է��ϼ���");
		}
		String typeList[] = new String[8];
		typeList = "�ĺ�/�ְź�/�Ǻ��̿��/���������/��ȭ��Ȱ��/�������/��Ÿ/����".split("/"); 
		AccountItemDao dao2 = null;
		try {
			dao2 = new AccountItemDaoImple();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�ݾ��� ���ּ���");
		int price = AccountFuction.sc.nextInt();
		AccountFuction.sc.nextLine();
		System.out.println("����� �����ּ���");
		String title = AccountFuction.sc.nextLine();
		if(typetmp !=8 && typetmp !=9 ) {
			System.out.println("�������¸� �����ּ���. 1.ī��2.����3.����  (�ѱ۷��Է�)");
			String payment = AccountFuction.sc.nextLine();
			AccountItem accitem = new AccountItem();
			Account acc= new Account();
			acc.setId(id);
			accitem.setAccount(acc);
			accitem.setPayment(payment);
			accitem.setPrice(price);
			accitem.setTitle(title);
			accitem.setType(typeList[typetmp-1]);
			dao2.create(accitem);
			System.out.println("�Է¿Ϸ�Ǿ����ϴ�.");
			AccountItem accitem1 = dao2.selectOne(dao2.selectAll().get(dao2.selectAll().size()-1).getId());//select id�� ������ �������� �ؾ��ϴ°�?
			DecimalFormat df = new DecimalFormat("###,###,###,###");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("�Ϸù�ȣ   �����ڵ�   ������     �Ͻ�                  �ݾ�     ����    ��������");
			System.out.printf("%3d %6d %8s %s %10s %5s %5s\n",accitem1.getId(),accitem1.getAccount().getId(),accitem1.getTitle(),
					sdf.format((Date)(accitem1.getCreated())),df.format(accitem1.getPrice()),
					accitem1.getType(),accitem1.getPayment());
			System.out.println("����Է��Ͻðڽ��ϱ�?");
			System.out.println("1.��� 2.�����޴���");
			int choose = AccountFuction.sc.nextInt();
			if(choose ==1) {
				AccountItemCreate(id);
			}else if(choose ==2){
				AccountFuction af = new AccountFuction();
				af.AccountPurpose(id);
			}else {
				System.out.println("�ٽ� �Է��ϼ���");
			}
			
			}
		
	}

	public void AccountItemSelect(int id) {
		System.out.println("�˻������� �������ּ���.");
		System.out.println("1.������ 2.�Ͻ� 3.�ݾ�  4.�������� 5.�������� 6.��ü���� 7.�����޴���");
		int choose = AccountFuction.sc.nextInt();
		if(choose==1) {
			AccountItemSelect itemsel = new AccountItemSelect();
			itemsel.selectTitle(id);
		}else if(choose==2) {
			AccountItemSelect itemsel = new AccountItemSelect();
			itemsel.selectCreated(id);
		}else if(choose==3) {
			AccountItemSelect itemsel = new AccountItemSelect();
			itemsel.selectPrice(id);
		}else if(choose==4) {
			AccountItemSelect itemsel = new AccountItemSelect();
			itemsel.selectType(id);
		}else if(choose==5) {
			AccountItemSelect itemsel = new AccountItemSelect();
			itemsel.selectPayment(id);
		}else if(choose==6) {
			AccountItemSelect itemsel = new AccountItemSelect();
			itemsel.selectAll(id);
		}else if(choose==7) {
			AccountFuction af = new AccountFuction();
			af.AccountPurpose(id);
		}else {
			System.out.println("�ٽ� �Է��ϼ���");
			AccountItemSelect(id);
		}
	}
	
	public void AccountItemUpdate(int id) {
		System.out.println("������ ������ �Ϸù�ȣ�� �Է����ּ���. �����޴���  ���ư��÷��� 0���� �Է��ϼ���");
		int itemid = AccountFuction.sc.nextInt();
		AccountItem accitem = new AccountItem();
		String title;int price;String type;String payment;
		if(itemid == 0) {
			AccountFuction af = new AccountFuction();
			af.AccountPurpose(id);
		}else {
			AccountItemDao dao2 = null;
			AccountItemDao dao2test =null;
			try {
				 dao2test = new AccountItemDaoImple();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			AccountItem accitemtest= dao2test.selectOne(itemid);
			try{
			if(accitemtest.getAccount().getId()!=id){
			System.out.println("�Է��Ͻ� �Ϸù�ȣ�� �ش���¿��� ���� �Ϸù�ȣ�Դϴ�.");
			AccountItemUpdate(id);
			}
			}catch(NullPointerException e) {
				System.out.println("�Է��Ͻ� �Ϸù�ȣ�� ���� �Ϸù�ȣ�Դϴ�.");
				AccountItemUpdate(id);
			}
			try {
				dao2 = new AccountItemDaoImple();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("�ٲܳ����� �������ּ���. 1.������ 2.�ݾ� 3.���� 4.��������");
			int choose = AccountFuction.sc.nextInt();
			if(choose==1) {
				AccountFuction.sc.nextLine();
				System.out.println("�ٲ� �����󼼸� �Է��ϼ���");
				title = AccountFuction.sc.nextLine();
//				AccountItem accitem = dao2.selectOne(itemid);
				accitem.setTitle(title);
				dao2.update(itemid, accitem);
			}else if(choose ==2){
				System.out.println("�ٲ� �ݾ��� �Է��ϼ���");
				price = AccountFuction.sc.nextInt();
				accitem.setPrice(price);
				dao2.update(itemid, accitem);
			}else if(choose ==3){
				AccountFuction.sc.nextLine();
				System.out.println("�ٲ� ������ �Է��ϼ���\n�ĺ�/�ְź�/�Ǻ��̿��/���������/��ȭ��Ȱ��/�������/��Ÿ/����");
				type = AccountFuction.sc.nextLine();
				accitem.setType(type);
				dao2.update(itemid, accitem);
			}else if(choose ==4){
				AccountFuction.sc.nextLine();
				System.out.println("�ٲ� �������¸� �Է��ϼ���\nī��/����/������ü");
				payment = AccountFuction.sc.nextLine();
				accitem.setPayment(payment);
				dao2.update(itemid, accitem);
			}
			DecimalFormat df = new DecimalFormat("###,###,###,###");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("�����Ǿ����ϴ�.");
			accitem = dao2.selectOne(itemid);
			System.out.println("�Ϸù�ȣ    �����ڵ�    ������    �Ͻ�             �ݾ�            ����   ��������");
			System.out.printf("%3d %3d %8s %s %10s %5s %5s\n",accitem.getId(),accitem.getAccount().getId(),accitem.getTitle(),
															sdf.format((Date)(accitem.getCreated())),df.format(accitem.getPrice()),
															accitem.getType(),accitem.getPayment());
			System.out.println("��� �����Ͻðڽ��ϱ�? 1.�� 2.�����޴���");
			int choose2 = AccountFuction.sc.nextInt();
			if (choose2 == 1) {
				AccountItemUpdate(id);
			}else if(choose2 ==2) {
				AccountFuction af = new AccountFuction();
				af.AccountPurpose(id);
			}else {
				System.out.println("�ٽ��Է��ϼ���");
				AccountItemUpdate(id);
			}
		}
	}
	
	
	public void AccountItemDelete(int id) {
		System.out.println("������ ������ �Ϸù�ȣ�� �Է����ּ���.(0���� �����޴���)");
		int itemid = AccountFuction.sc.nextInt();
		AccountItemDao dao2 = null;
		try {
			dao2 = new AccountItemDaoImple();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AccountItem accitem = new AccountItem();
		accitem.setId(itemid);
		dao2.deleteOne(accitem);
		System.out.println("�����Ǿ����ϴ�.");
		System.out.println("��� �����Ͻðڽ��ϱ�? 1.��  2.�����޴���");
		int choose = AccountFuction.sc.nextInt();
		if(choose == 1) {
			AccountItemDelete(id);
		}else if(choose ==2) {
			AccountFuction af = new AccountFuction();
			af.AccountPurpose(id);
		}
		
		
	}
	
	

}
