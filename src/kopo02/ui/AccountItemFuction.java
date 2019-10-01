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
		System.out.println("수입지출 유형을 입력해 주세요");
		System.out.println("1.식비/2.주거비/3.의복미용비/4.교육교양비/5.문화생활비/6.경조사비" + 
				"7.기타/8.수입/9.이전메뉴(숫자입력)");
		int typetmp = AccountFuction.sc.nextInt();
		if (typetmp==9) {
			AccountFuction af = new AccountFuction();
			af.AccountPurpose(id);
		}else if(typetmp >= 10) {
			System.out.println("다시 입력하세요");
		}
		String typeList[] = new String[8];
		typeList = "식비/주거비/의복미용비/교육교양비/문화생활비/경조사비/기타/수입".split("/"); 
		AccountItemDao dao2 = null;
		try {
			dao2 = new AccountItemDaoImple();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("금액을 써주세요");
		int price = AccountFuction.sc.nextInt();
		AccountFuction.sc.nextLine();
		System.out.println("명목을 적어주세요");
		String title = AccountFuction.sc.nextLine();
		if(typetmp !=8 && typetmp !=9 ) {
			System.out.println("지출형태를 적어주세요. 1.카드2.현금3.계좌  (한글로입력)");
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
			System.out.println("입력완료되었습니다.");
			AccountItem accitem1 = dao2.selectOne(dao2.selectAll().get(dao2.selectAll().size()-1).getId());//select id는 무엇을 기준으로 해야하는가?
			DecimalFormat df = new DecimalFormat("###,###,###,###");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("일련번호   계좌코드   내역상세     일시                  금액     유형    지출형태");
			System.out.printf("%3d %6d %8s %s %10s %5s %5s\n",accitem1.getId(),accitem1.getAccount().getId(),accitem1.getTitle(),
					sdf.format((Date)(accitem1.getCreated())),df.format(accitem1.getPrice()),
					accitem1.getType(),accitem1.getPayment());
			System.out.println("계속입력하시겠습니까?");
			System.out.println("1.계속 2.상위메뉴로");
			int choose = AccountFuction.sc.nextInt();
			if(choose ==1) {
				AccountItemCreate(id);
			}else if(choose ==2){
				AccountFuction af = new AccountFuction();
				af.AccountPurpose(id);
			}else {
				System.out.println("다시 입력하세요");
			}
			
			}
		
	}

	public void AccountItemSelect(int id) {
		System.out.println("검색유형을 선택해주세요.");
		System.out.println("1.내역상세 2.일시 3.금액  4.지출유형 5.지출형태 6.전체내역 7.이전메뉴로");
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
			System.out.println("다시 입력하세요");
			AccountItemSelect(id);
		}
	}
	
	public void AccountItemUpdate(int id) {
		System.out.println("수정할 내역의 일련번호를 입력해주세요. 상위메뉴로  돌아가시려면 0번을 입력하세요");
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
			System.out.println("입력하신 일련번호는 해당계좌에는 없는 일련번호입니다.");
			AccountItemUpdate(id);
			}
			}catch(NullPointerException e) {
				System.out.println("입력하신 일련번호는 없는 일련번호입니다.");
				AccountItemUpdate(id);
			}
			try {
				dao2 = new AccountItemDaoImple();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("바꿀내용을 선택해주세요. 1.내역상세 2.금액 3.유형 4.지출형태");
			int choose = AccountFuction.sc.nextInt();
			if(choose==1) {
				AccountFuction.sc.nextLine();
				System.out.println("바꿀 내역상세를 입력하세요");
				title = AccountFuction.sc.nextLine();
//				AccountItem accitem = dao2.selectOne(itemid);
				accitem.setTitle(title);
				dao2.update(itemid, accitem);
			}else if(choose ==2){
				System.out.println("바꿀 금액을 입력하세요");
				price = AccountFuction.sc.nextInt();
				accitem.setPrice(price);
				dao2.update(itemid, accitem);
			}else if(choose ==3){
				AccountFuction.sc.nextLine();
				System.out.println("바꿀 유형을 입력하세요\n식비/주거비/의복미용비/교육교양비/문화생활비/경조사비/기타/수입");
				type = AccountFuction.sc.nextLine();
				accitem.setType(type);
				dao2.update(itemid, accitem);
			}else if(choose ==4){
				AccountFuction.sc.nextLine();
				System.out.println("바꿀 지출형태를 입력하세요\n카드/현금/계좌이체");
				payment = AccountFuction.sc.nextLine();
				accitem.setPayment(payment);
				dao2.update(itemid, accitem);
			}
			DecimalFormat df = new DecimalFormat("###,###,###,###");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("수정되었습니다.");
			accitem = dao2.selectOne(itemid);
			System.out.println("일련번호    계좌코드    내역상세    일시             금액            유형   지출형태");
			System.out.printf("%3d %3d %8s %s %10s %5s %5s\n",accitem.getId(),accitem.getAccount().getId(),accitem.getTitle(),
															sdf.format((Date)(accitem.getCreated())),df.format(accitem.getPrice()),
															accitem.getType(),accitem.getPayment());
			System.out.println("계속 수정하시겠습니까? 1.예 2.상위메누로");
			int choose2 = AccountFuction.sc.nextInt();
			if (choose2 == 1) {
				AccountItemUpdate(id);
			}else if(choose2 ==2) {
				AccountFuction af = new AccountFuction();
				af.AccountPurpose(id);
			}else {
				System.out.println("다시입력하세요");
				AccountItemUpdate(id);
			}
		}
	}
	
	
	public void AccountItemDelete(int id) {
		System.out.println("삭제할 내역의 일련번호를 입력해주세요.(0번은 상위메뉴로)");
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
		System.out.println("삭제되었습니다.");
		System.out.println("계속 삭제하시겠습니까? 1.예  2.상위메뉴로");
		int choose = AccountFuction.sc.nextInt();
		if(choose == 1) {
			AccountItemDelete(id);
		}else if(choose ==2) {
			AccountFuction af = new AccountFuction();
			af.AccountPurpose(id);
		}
		
		
	}
	
	

}
