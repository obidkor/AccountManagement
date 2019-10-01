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
		System.out.println("기간을 정해주세요 양식: yyyy-mm-dd");
		System.out.print("기간1(from) : ");
		String from = AccountFuction.sc.nextLine();
		System.out.print("기간2(to) : ");
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
					if(list.get(i).getType().equals("식비")) {sumeat += list.get(i).getPrice();}
					else if(list.get(i).getType().equals("주거비")) {sumliving += list.get(i).getPrice();}
					else if(list.get(i).getType().equals("의복미용비")) {sumcloth += list.get(i).getPrice();}
					else if(list.get(i).getType().equals("교통비")) {sumtransfer += list.get(i).getPrice();}
					else if(list.get(i).getType().equals("문화생활비")) {sumculture += list.get(i).getPrice();}
					else if(list.get(i).getType().equals("경조사비")) {sumevent += list.get(i).getPrice();}
					else if(list.get(i).getType().equals("기타지출")) {sumelse += list.get(i).getPrice();}
					else if(list.get(i).getType().equals("수입")) {sumincome += list.get(i).getPrice();}
					
				}
				}}
		al.add(sumeat);al.add(sumliving);al.add(sumcloth);al.add(sumtransfer);al.add(sumculture);al.add(sumevent);al.add(sumelse);al.add(sumincome);
		al.add(sumeat/list.size());al.add(sumliving/list.size());al.add(sumcloth/list.size());al.add(sumtransfer/list.size());
		al.add(sumculture/list.size());al.add(sumevent/list.size());al.add(sumelse/list.size());al.add(sumincome/list.size());
		int sumoutcome =0;
		System.out.println("항목별 총 금액");
		System.out.println("  식비   주거비   의복미용비   교통비   문화생할비   경조사비  기타지출   수입");
		for(int i=0;i<al.size()/2;i++) { 
			System.out.printf("  %d  ",al.get(i));
			sumoutcome += al.get(i);
			}
		sumoutcome= sumoutcome - al.get(al.size()/2-1);
		System.out.println();
		System.out.println("항목별 1회 평균 사용 금액");
		System.out.println("  식비   주거비   의복미용비   교통비   문화생할비   경조사비  기타지출   수입");
		for(int i=al.size()/2;i<al.size();i++) System.out.printf("  %d  ",al.get(i));
		System.out.println();
		System.out.println("지출수입비율");
		if(sumincome==0) {
			System.out.println("100:0입니다.");
		}else {
			System.out.println((sumoutcome/sumincome*100)+":"+(100-(sumoutcome/sumincome*100)));
		}
		
		
		System.out.println("계속분석 하시겠습니까? 1.예 2.상위메뉴로");
		int choose = AccountFuction.sc.nextInt();
		if (choose ==1) {
			ServiceIntro(id);
		}else if(choose ==2 ) {
			AccountFuction af = new AccountFuction();
			af.AccountPurpose(id);
		}else {
			System.out.println("잘못입력하셔서 서비스선택메뉴로 돌아갑니다.");
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
					if(list1.get(i).getCreated().getMonth()+1==j+1 && list1.get(i).getType().equals("수입")) {
						income[j] += list1.get(i).getPrice();
					}else if(list1.get(i).getCreated().getMonth()+1==j+1) {
						outcome[j] += list1.get(i).getPrice();
					}
				}
			}
		}
		
		for(int i=0;i<income.length;i++) {
			if(income[i]==0 && outcome[i]==0) {
				list.add("내역없음");
			}else if(income[i]==0) {
				list.add("수익없음");
			}else if(outcome[i]==0) {
				list.add("지출없음");
			}else {
				list.add(outcome[i]/income[i]+"%");
			}


		}
		System.out.println("금년 매월수입의");
		for(int i=0; i<=11; i++) {
			System.out.printf("  %d월      ",i+1);
		}
		System.out.println();
		for(int i=0; i<=11; i++) {
			System.out.printf("%s  ",list.get(i));
		}
		System.out.println();
		System.out.println("를 쓰셨습니다.");
		
		// TODO Auto-generated method stub
		System.out.println("계속분석 하시겠습니까? 1.예 2.상위메뉴로");
		int choose = AccountFuction.sc.nextInt();
		if (choose ==1) {
			ServiceIntro(id);
		}else if(choose ==2 ) {
			AccountFuction af = new AccountFuction();
			af.AccountPurpose(id);
		}else {
			System.out.println("잘못입력하셔서 서비스선택메뉴로 돌아갑니다.");
			ServiceIntro(id);
		}
		
	}
	
	@Override
	public void Service3(int id) {
		System.out.println("저축목표를 입력해주세요.(숫자입력, 단위 제외)");
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
				if(list1.get(i).getType().equals("수입")) {
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
		System.out.println("목표까지 "+income/outcome*100+"% 달성하셨습니다.");
		if(income/outcome*100>=100) {
			System.out.println("목표를 달성하셨습니다.");
		}else {
			System.out.println(target-(income-outcome)+"원을 더 저축해야합니다.");
			aveincome=(int) (income/((max-min)*1000*60*60*24*30+1));// 0으로 나누는 오류대비 +1			
			aveoutcome = (int) (outcome/((max-min)*1000*60*60*24*30+1));// 0으로 나누는 오류대비 +1			
			System.out.println("매월 수입평균액은 "+aveincome+"원입니다.");
			System.out.println("매월 지출평균액은 "+aveoutcome+"원입니다.");
			if(income==0) {
				System.out.println("수익이 없습니다. 수익을 늘리세요");
			}else {
			System.out.println((target-(income-outcome))/((aveincome-aveoutcome)*1000*60*60*24*30+1)+"월 저축하셔야합니다.");}// 0으로 나누는 오류대비 +1
		}
		System.out.println("계속분석 하시겠습니까? 1.예 2.상위메뉴로");
		int choose = AccountFuction.sc.nextInt();
		if (choose ==1) {
			ServiceIntro(id);
		}else if(choose ==2 ) {
			AccountFuction af = new AccountFuction();
			af.AccountPurpose(id);
		}else {
			System.out.println("잘못입력하셔서 서비스선택메뉴로 돌아갑니다.");
			ServiceIntro(id);
		}
			
		}
		
	@Override
	public void ServiceIntro(int id) {
		// TODO Auto-generated method stub
		System.out.println("분석메뉴를 선택해주세요");
		System.out.println("1.기간 지출 분석");
		System.out.println("2.월별 지출 비교");
		System.out.println("3.저축목표확인");
		System.out.println("4.상위메뉴로");
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
			System.out.println("잘못입력하셨습니다.");
			ServiceIntro(id);
		}
	}

}
