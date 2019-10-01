package kopo02.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
//import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kopo02.dao.AccountItemDao;
import kopo02.dao.AccountItemDaoImple;
import kopo02.domain.AccountItem;
import kopo02.ui.AccountFuction;



public class ServiceImple implements Service {
	@Override
	public void Service1(int id) throws SQLException {
		// TODO Auto-generated method stub
		AccountFuction.sc.nextLine();
		System.out.println("�Ⱓ�� �����ּ��� ���: yyyy-mm-dd");
		System.out.print("�Ⱓ1(from) : ");
		String from = AccountFuction.sc.nextLine();
		System.out.print("�Ⱓ2(to) : ");
		String to = AccountFuction.sc.nextLine();
		AccountItemDao dao2 = new AccountItemDaoImple();
		List<AccountItem> list = dao2.selectAll();
		ArrayList<Integer> al = new ArrayList<Integer>();
		int sumeat = 0;int sumliving=0;int sumcloth=0;int sumtransfer=0;int sumculture=0;int sumevent=0;
		int sumelse=0;int sumincome=0;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date fromD = null;
        Date toD=null;
		try {
			fromD = df.parse(from);
	        toD = df.parse(to);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		for(int i =0 ; i < list.size();i++) {
			if(list.get(i).getAccount().getId()==id){
				if(list.get(i).getCreated().compareTo(fromD)==1 && list.get(i).getCreated().compareTo(toD)==-1) {
					if(list.get(i).getType().equals("�ĺ�")) {sumeat += list.get(i).getPrice();}
					else if(list.get(i).getType().equals("�ְź�")) {sumliving += list.get(i).getPrice();}
					else if(list.get(i).getType().equals("�Ǻ��̿��")) {sumcloth += list.get(i).getPrice();}
					else if(list.get(i).getType().equals("�����")) {sumtransfer += list.get(i).getPrice();}
					else if(list.get(i).getType().equals("��ȭ��Ȱ��")) {sumculture += list.get(i).getPrice();}
					else if(list.get(i).getType().equals("�������")) {sumevent += list.get(i).getPrice();}
					else if(list.get(i).getType().equals("��Ÿ����")) {sumelse += list.get(i).getPrice();}
					else if(list.get(i).getType().equals("����")) {sumincome += list.get(i).getPrice();}
					
				}
				}}
		al.add(sumeat);al.add(sumliving);al.add(sumcloth);al.add(sumtransfer);al.add(sumculture);al.add(sumevent);al.add(sumelse);al.add(sumincome);
		al.add(sumeat/list.size());al.add(sumliving/list.size());al.add(sumcloth/list.size());al.add(sumtransfer/list.size());
		al.add(sumculture/list.size());al.add(sumevent/list.size());al.add(sumelse/list.size());al.add(sumincome/list.size());
		int sumoutcome =0;
		System.out.println("�׸� �� �ݾ�");
		System.out.println("  �ĺ�   �ְź�   �Ǻ��̿��   �����   ��ȭ���Һ�   �������  ��Ÿ����   ����");
		for(int i=0;i<al.size()/2;i++) { 
			System.out.printf("  %d  ",al.get(i));
			sumoutcome += al.get(i);
			}
		sumoutcome= sumoutcome - al.get(al.size()/2-1);
		System.out.println();
		System.out.println("�׸� 1ȸ ��� ��� �ݾ�");
		System.out.println("  �ĺ�   �ְź�   �Ǻ��̿��   �����   ��ȭ���Һ�   �������  ��Ÿ����   ����");
		for(int i=al.size()/2;i<al.size();i++) System.out.printf("  %d  ",al.get(i));
		System.out.println();
		System.out.println("������Ժ���");
		if(sumincome==0) {
			System.out.println("100:0�Դϴ�.");
		}else {
			System.out.println((sumoutcome/sumincome*100)+":"+(100-(sumoutcome/sumincome*100)));
		}
		
		
		System.out.println("��Ӻм� �Ͻðڽ��ϱ�? 1.�� 2.�����޴���");
		int choose = AccountFuction.sc.nextInt();
		if (choose ==1) {
			ServiceIntro(id);
		}else if(choose ==2 ) {
			AccountFuction af = new AccountFuction();
			af.AccountPurpose(id);
		}else {
			System.out.println("�߸��Է��ϼż� ���񽺼��ø޴��� ���ư��ϴ�.");
			ServiceIntro(id);
		}

	
}
	
	
	
	@SuppressWarnings({ "null", "deprecation" })
	@Override
	public void Service2(int id) {

		int income[] = new int[12];
		int outcome[] = new int[12];

		List<String> list = new ArrayList<String>();
		AccountItemDao dao2 = null;
		try {
			dao2 = new AccountItemDaoImple();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<AccountItem> list1 = dao2.selectAll();
		Calendar cl = Calendar.getInstance();
		for(int i=0;i<income.length;i++) {
			income[i]=0;
			outcome[i]=0;
		}
		for(int i=0; i<list1.size();i++) {
			if(cl.getTime().getYear()==list1.get(i).getCreated().getYear() && id==list1.get(i).getAccount().getId()) {
				for(int j = 0 ;j<=11; j++) {
					if(list1.get(i).getCreated().getMonth()+1==j+1 && list1.get(i).getType().equals("����")) {
						income[j] += list1.get(i).getPrice();
					}else if(list1.get(i).getCreated().getMonth()+1==j+1) {
						outcome[j] += list1.get(i).getPrice();
					}
				}
			}
		}
		
		for(int i=0;i<income.length;i++) {
			if(income[i]==0 && outcome[i]==0) {
				list.add("��������");
			}else if(income[i]==0) {
				list.add("���;���");
			}else if(outcome[i]==0) {
				list.add("�������");
			}else {
				list.add(outcome[i]/income[i]+"%");
			}


		}
		System.out.println("�ݳ� �ſ�������");
		for(int i=0; i<=11; i++) {
			System.out.printf("  %d��      ",i+1);
		}
		System.out.println();
		for(int i=0; i<=11; i++) {
			System.out.printf("%s  ",list.get(i));
		}
		System.out.println();
		System.out.println("�� ���̽��ϴ�.");
		
		// TODO Auto-generated method stub
		System.out.println("��Ӻм� �Ͻðڽ��ϱ�? 1.�� 2.�����޴���");
		int choose = AccountFuction.sc.nextInt();
		if (choose ==1) {
			ServiceIntro(id);
		}else if(choose ==2 ) {
			AccountFuction af = new AccountFuction();
			af.AccountPurpose(id);
		}else {
			System.out.println("�߸��Է��ϼż� ���񽺼��ø޴��� ���ư��ϴ�.");
			ServiceIntro(id);
		}
		
	}
	
	@Override
	public void Service3(int id) {
		System.out.println("�����ǥ�� �Է����ּ���.(�����Է�, ���� ����)");
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		AccountItemDao dao2 = null;
		try {
			dao2 = new AccountItemDaoImple();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int income = 0;int outcome = 0;
		Long max = null;Long min=null;
		int aveincome = 0; int aveoutcome =0;
		List<AccountItem> list1 = dao2.selectAll();
		for(int i=0;i<list1.size();i++) {
			if(list1.get(i).getAccount().getId()==id) {
				if(list1.get(i).getType().equals("����")) {
					income+=list1.get(i).getPrice();
				}else {
					outcome+=list1.get(i).getPrice();
				}
			
				max = list1.get(i).getCreated().getTime();
				min = list1.get(i).getCreated().getTime();
				if(max<list1.get(i).getCreated().getTime()) {
					max = list1.get(i).getCreated().getTime();
				}
				if(min>list1.get(i).getCreated().getTime()) {
					min = list1.get(i).getCreated().getTime();
				} 
			}
		}
		System.out.println("��ǥ���� "+income/outcome*100+"% �޼��ϼ̽��ϴ�.");
		if(income/outcome*100>=100) {
			System.out.println("��ǥ�� �޼��ϼ̽��ϴ�.");
		}else {
			System.out.println(target-(income-outcome)+"���� �� �����ؾ��մϴ�.");
			aveincome=(int) (income/((max-min)*1000*60*60*24*30+1));// 0���� ������ ������� +1			
			aveoutcome = (int) (outcome/((max-min)*1000*60*60*24*30+1));// 0���� ������ ������� +1			
			System.out.println("�ſ� ������վ��� "+aveincome+"���Դϴ�.");
			System.out.println("�ſ� ������վ��� "+aveoutcome+"���Դϴ�.");
			if(income==0) {
				System.out.println("������ �����ϴ�. ������ �ø�����");
			}else {
			System.out.println((target-(income-outcome))/((aveincome-aveoutcome)*1000*60*60*24*30+1)+"�� �����ϼž��մϴ�.");}// 0���� ������ ������� +1
		}
		System.out.println("��Ӻм� �Ͻðڽ��ϱ�? 1.�� 2.�����޴���");
		int choose = AccountFuction.sc.nextInt();
		if (choose ==1) {
			ServiceIntro(id);
		}else if(choose ==2 ) {
			AccountFuction af = new AccountFuction();
			af.AccountPurpose(id);
		}else {
			System.out.println("�߸��Է��ϼż� ���񽺼��ø޴��� ���ư��ϴ�.");
			ServiceIntro(id);
		}
			
		}
		
	@Override
	public void ServiceIntro(int id) {
		// TODO Auto-generated method stub
		System.out.println("�м��޴��� �������ּ���");
		System.out.println("1.�Ⱓ ���� �м�");
		System.out.println("2.���� ���� ��");
		System.out.println("3.�����ǥȮ��");
		System.out.println("4.�����޴���");
		int choose= AccountFuction.sc.nextInt();
		if(choose==1) {
			try {
				Service1(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(choose == 2) {
			Service2(id);
		}else if(choose == 3) {
			Service3(id);
		}else if(choose == 4) {
			AccountFuction af = new AccountFuction();
			af.AccountPurpose(id);	
		}else {
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
			ServiceIntro(id);
		}
	}

}
