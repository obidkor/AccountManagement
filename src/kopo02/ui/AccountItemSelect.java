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
		System.out.println("검색어를 입력해주세요");
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
		System.out.println("일련번호   계좌코드   내역상세     일시                  금액     유형    지출형태");
		for(int i = 0;i<itemlist.size();i++) {
			if(itemlist.get(i).getAccount().getId()==id &&
					itemlist.get(i).getTitle().trim().contains(title)) {
				System.out.printf("%3d  %5d %8s %s %10s %5s %5s\n",
									itemlist.get(i).getId(),itemlist.get(i).getAccount().getId(),itemlist.get(i).getTitle(),
									sdf.format((Date)(itemlist.get(i).getCreated())),df.format(itemlist.get(i).getPrice()),
									itemlist.get(i).getType(),itemlist.get(i).getPayment());
			}
		}
		
		System.out.println("계속 검색 하시겠습니까? 1.예 2.상위메뉴로");
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
	System.out.println("시간 2개를 입력해주세요.(두 시간사이의 결과를 보여줍니다. 양식 : yyyy-mm-dd)");
	System.out.print("기간1 : ");
	String from = AccountFuction.sc.nextLine();
	System.out.print("기간2 : ");
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
	
	System.out.println("일련번호    계좌코드    내역상세         일시              금액        유형         지출형태");
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
	
	System.out.println("계속 검색 하시겠습니까? 1.예 2.상위메뉴로");
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
	System.out.println("금액 두개를 입력해주세요.(두 금액사이의 내역을 보여줍니다.)");
	System.out.print("금액1 : ");
	int fromprice = AccountFuction.sc.nextInt();
	System.out.print("금액2 : ");
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
	System.out.println("일련번호    계좌코드    내역상세         일시              금액        유형         지출형태");
	for(int i = 0;i<itemlist.size();i++) {
		if(itemlist.get(i).getAccount().getId()==id &&
				itemlist.get(i).getPrice()>=fromprice && itemlist.get(i).getPrice()<=toprice) {
			System.out.printf("%3d    %3d   %-8.8s   %-10s %10s %5s %5s\n",
								itemlist.get(i).getId(),itemlist.get(i).getAccount().getId(),itemlist.get(i).getTitle(),
								sdf.format((Date)(itemlist.get(i).getCreated())),df.format(itemlist.get(i).getPrice()),
								itemlist.get(i).getType(),itemlist.get(i).getPayment());
		}
	}
	
	System.out.println("계속 검색 하시겠습니까? 1.예 2.상위메뉴로");
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
	System.out.println("검색어를 입력해주세요");
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
	System.out.println("일련번호    계좌코드    내역상세     일시             금액        유형         지출형태");
	for(int i = 0;i<itemlist.size();i++) {
		if(itemlist.get(i).getAccount().getId()==id &&
				itemlist.get(i).getType().contains(type)) {
			System.out.printf("%3d     %3d %8s %s %10s %5s %5s\n",
								itemlist.get(i).getId(),itemlist.get(i).getAccount().getId(),itemlist.get(i).getTitle(),
								sdf.format((Date)(itemlist.get(i).getCreated())),df.format(itemlist.get(i).getPrice()),
								itemlist.get(i).getType(),itemlist.get(i).getPayment());
		}
	}
	
	System.out.println("계속 검색 하시겠습니까? 1.예 2.상위메뉴로");
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
	System.out.println("검색어를 입력해주세요");
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
	System.out.println("일련번호    계좌코드    내역상세     일시             금액        유형         지출형태");
	for(int i = 0;i<itemlist.size();i++) {
		if(itemlist.get(i).getAccount().getId()==id &&
				itemlist.get(i).getPayment().contains(payment)) {
			System.out.printf("%3d   %3d %8s %s %10s %5s %5s\n",
								itemlist.get(i).getId(),itemlist.get(i).getAccount().getId(),itemlist.get(i).getTitle(),
								sdf.format((Date)(itemlist.get(i).getCreated())),df.format(itemlist.get(i).getPrice()),
								itemlist.get(i).getType(),itemlist.get(i).getPayment());
		}
	}
	
	System.out.println("계속 검색 하시겠습니까? 1.예 2.상위메뉴로");
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
	System.out.println("일련번호    계좌코드    내역상세     일시             금액        유형         지출형태");
	for(int i = 0;i<itemlist.size();i++) {
			System.out.printf("%3d   %3d %8s %s %10s %5s %5s\n",
								itemlist.get(i).getId(),itemlist.get(i).getAccount().getId(),itemlist.get(i).getTitle(),
								sdf.format((Date)(itemlist.get(i).getCreated())),df.format(itemlist.get(i).getPrice()),
								itemlist.get(i).getType(),itemlist.get(i).getPayment());
		
	}
	
	System.out.println("계속 검색 하시겠습니까? 1.예 2.상위메뉴로");
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
