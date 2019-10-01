package kopo02.ui;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kopo02.dao.AccountItemDao;
import kopo02.dao.AccountItemDaoImple;
import kopo02.domain.AccountItem;

public class AccountItemSelect {
	public void selectTitle(int id ) {
		AccountFuction.sc.nextLine();
		System.out.println("�˻�� �Է����ּ���");
		String title =  AccountFuction.sc.nextLine();
		AccountItemDao dao2 = null;
		try {
			dao2 = new AccountItemDaoImple();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<AccountItem> itemlist = dao2.selectAll();
		DecimalFormat df = new DecimalFormat("###,###,###,###");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("�Ϸù�ȣ   �����ڵ�   ������     �Ͻ�                  �ݾ�     ����    ��������");
		for(int i = 0;i<itemlist.size();i++) {
			if(itemlist.get(i).getAccount().getId()==id &&
					itemlist.get(i).getTitle().trim().contains(title)) {
				System.out.printf("%3d  %5d %8s %s %10s %5s %5s\n",
									itemlist.get(i).getId(),itemlist.get(i).getAccount().getId(),itemlist.get(i).getTitle(),
									sdf.format((Date)(itemlist.get(i).getCreated())),df.format(itemlist.get(i).getPrice()),
									itemlist.get(i).getType(),itemlist.get(i).getPayment());
			}
		}
		
		System.out.println("��� �˻� �Ͻðڽ��ϱ�? 1.�� 2.�����޴���");
		int choose = AccountFuction.sc.nextInt();
		if(choose==1) {
			AccountItemFuction aif = new AccountItemFuction();
			aif.AccountItemSelect(id);
		}else if (choose==2) {
			AccountFuction af = new AccountFuction();
			af.AccountPurpose(id);
		}
	}
public void selectCreated(int id) {
	AccountFuction.sc.nextLine();
	System.out.println("�ð� 2���� �Է����ּ���.(�� �ð������� ����� �����ݴϴ�. ��� : yyyy-mm-dd)");
	System.out.print("�Ⱓ1 : ");
	String from = AccountFuction.sc.nextLine();
	System.out.print("�Ⱓ2 : ");
	String to = AccountFuction.sc.nextLine();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date fromD= null;
	Date toD= null;
	try {
		fromD=sdf.parse(from);
		toD=sdf.parse(to);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	Timestamp fromT = new Timestamp(fromD.getTime());
	Timestamp toT = new Timestamp(toD.getTime());
	AccountItemDao dao2 = null;
	try {
		dao2 = new AccountItemDaoImple();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	List<AccountItem> itemlist = dao2.selectAll();
	DecimalFormat df = new DecimalFormat("###,###,###,###");
	
	System.out.println("�Ϸù�ȣ    �����ڵ�    ������         �Ͻ�              �ݾ�        ����         ��������");
	for(int i = 0;i<itemlist.size();i++) {
		if(itemlist.get(i).getAccount().getId()==id &&
				fromD.compareTo(itemlist.get(i).getCreated())==-1 &&
				toD.compareTo(itemlist.get(i).getCreated())==1) {
			System.out.printf("%3d    %3d   %-8.8s   %-10s %10s %5s %5s\n",
								itemlist.get(i).getId(),itemlist.get(i).getAccount().getId(),itemlist.get(i).getTitle(),
								sdf.format((Date)(itemlist.get(i).getCreated())),df.format(itemlist.get(i).getPrice()),
								itemlist.get(i).getType(),itemlist.get(i).getPayment());
		}
	}
	
	System.out.println("��� �˻� �Ͻðڽ��ϱ�? 1.�� 2.�����޴���");
	int choose = AccountFuction.sc.nextInt();
	if(choose==1) {
		AccountItemFuction aif = new AccountItemFuction();
		aif.AccountItemSelect(id);
	}else if (choose==2) {
		AccountFuction af = new AccountFuction();
		af.AccountPurpose(id);
	}
	}
public void selectPrice(int id) {
	System.out.println("�ݾ� �ΰ��� �Է����ּ���.(�� �ݾ׻����� ������ �����ݴϴ�.)");
	System.out.print("�ݾ�1 : ");
	int fromprice = AccountFuction.sc.nextInt();
	System.out.print("�ݾ�2 : ");
	int toprice = AccountFuction.sc.nextInt();
	AccountItemDao dao2 = null;
	try {
		dao2 = new AccountItemDaoImple();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	List<AccountItem> itemlist = dao2.selectAll();
	DecimalFormat df = new DecimalFormat("###,###,###,###");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	System.out.println("�Ϸù�ȣ    �����ڵ�    ������         �Ͻ�              �ݾ�        ����         ��������");
	for(int i = 0;i<itemlist.size();i++) {
		if(itemlist.get(i).getAccount().getId()==id &&
				itemlist.get(i).getPrice()>=fromprice && itemlist.get(i).getPrice()<=toprice) {
			System.out.printf("%3d    %3d   %-8.8s   %-10s %10s %5s %5s\n",
								itemlist.get(i).getId(),itemlist.get(i).getAccount().getId(),itemlist.get(i).getTitle(),
								sdf.format((Date)(itemlist.get(i).getCreated())),df.format(itemlist.get(i).getPrice()),
								itemlist.get(i).getType(),itemlist.get(i).getPayment());
		}
	}
	
	System.out.println("��� �˻� �Ͻðڽ��ϱ�? 1.�� 2.�����޴���");
	int choose = AccountFuction.sc.nextInt();
	if(choose==1) {
		AccountItemFuction aif = new AccountItemFuction();
		aif.AccountItemSelect(id);
	}else if (choose==2) {
		AccountFuction af = new AccountFuction();
		af.AccountPurpose(id);
	}
}
public void selectType(int id) {
	AccountFuction.sc.nextLine();
	System.out.println("�˻�� �Է����ּ���");
	String type =  AccountFuction.sc.nextLine();
	AccountItemDao dao2 = null;
	try {
		dao2 = new AccountItemDaoImple();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	List<AccountItem> itemlist = dao2.selectAll();
	DecimalFormat df = new DecimalFormat("###,###,###,###");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	System.out.println("�Ϸù�ȣ    �����ڵ�    ������     �Ͻ�             �ݾ�        ����         ��������");
	for(int i = 0;i<itemlist.size();i++) {
		if(itemlist.get(i).getAccount().getId()==id &&
				itemlist.get(i).getType().contains(type)) {
			System.out.printf("%3d     %3d %8s %s %10s %5s %5s\n",
								itemlist.get(i).getId(),itemlist.get(i).getAccount().getId(),itemlist.get(i).getTitle(),
								sdf.format((Date)(itemlist.get(i).getCreated())),df.format(itemlist.get(i).getPrice()),
								itemlist.get(i).getType(),itemlist.get(i).getPayment());
		}
	}
	
	System.out.println("��� �˻� �Ͻðڽ��ϱ�? 1.�� 2.�����޴���");
	int choose = AccountFuction.sc.nextInt();
	if(choose==1) {
		AccountItemFuction aif = new AccountItemFuction();
		aif.AccountItemSelect(id);
	}else if (choose==2) {
		AccountFuction af = new AccountFuction();
		af.AccountPurpose(id);
	}
}
public void selectPayment(int id) {
	AccountFuction.sc.nextLine();
	System.out.println("�˻�� �Է����ּ���");
	String payment =  AccountFuction.sc.nextLine();
	AccountItemDao dao2 = null;
	try {
		dao2 = new AccountItemDaoImple();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	List<AccountItem> itemlist = dao2.selectAll();
	DecimalFormat df = new DecimalFormat("###,###,###,###");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	System.out.println("�Ϸù�ȣ    �����ڵ�    ������     �Ͻ�             �ݾ�        ����         ��������");
	for(int i = 0;i<itemlist.size();i++) {
		if(itemlist.get(i).getAccount().getId()==id &&
				itemlist.get(i).getPayment().contains(payment)) {
			System.out.printf("%3d   %3d %8s %s %10s %5s %5s\n",
								itemlist.get(i).getId(),itemlist.get(i).getAccount().getId(),itemlist.get(i).getTitle(),
								sdf.format((Date)(itemlist.get(i).getCreated())),df.format(itemlist.get(i).getPrice()),
								itemlist.get(i).getType(),itemlist.get(i).getPayment());
		}
	}
	
	System.out.println("��� �˻� �Ͻðڽ��ϱ�? 1.�� 2.�����޴���");
	int choose = AccountFuction.sc.nextInt();
	if(choose==1) {
		AccountItemFuction aif = new AccountItemFuction();
		aif.AccountItemSelect(id);
	}else if (choose==2) {
		AccountFuction af = new AccountFuction();
		af.AccountPurpose(id);
	}
}

public void selectAll(int id) {
	AccountItemDao dao2 = null;
	try {
		dao2 = new AccountItemDaoImple();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	List<AccountItem> itemlist = dao2.selectAll();
	DecimalFormat df = new DecimalFormat("###,###,###,###");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	System.out.println("�Ϸù�ȣ    �����ڵ�    ������     �Ͻ�             �ݾ�        ����         ��������");
	for(int i = 0;i<itemlist.size();i++) {
			System.out.printf("%3d   %3d %8s %s %10s %5s %5s\n",
								itemlist.get(i).getId(),itemlist.get(i).getAccount().getId(),itemlist.get(i).getTitle(),
								sdf.format((Date)(itemlist.get(i).getCreated())),df.format(itemlist.get(i).getPrice()),
								itemlist.get(i).getType(),itemlist.get(i).getPayment());
		
	}
	
	System.out.println("��� �˻� �Ͻðڽ��ϱ�? 1.�� 2.�����޴���");
	int choose = AccountFuction.sc.nextInt();
	if(choose==1) {
		AccountItemFuction aif = new AccountItemFuction();
		aif.AccountItemSelect(id);
	}else if (choose==2) {
		AccountFuction af = new AccountFuction();
		af.AccountPurpose(id);
	}
}
}
