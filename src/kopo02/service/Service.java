package kopo02.service;

import java.util.ArrayList;
import java.util.Date;
//import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import kopo02.domain.Account;

public interface Service {

	
	
	void ServiceIntro(int id);
	//기간 지출 분석
	void Service1(int id) throws SQLException;

	//월별 지출비교
	void Service2(int id);
	
	//저축목표확인
	void Service3(int id);
}
