package kopo02.service;

import java.util.ArrayList;
import java.util.Date;
//import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import kopo02.domain.Account;

public interface Service {

	
	
	void ServiceIntro(int id);
	//�Ⱓ ���� �м�
	void Service1(int id) throws SQLException;

	//���� �����
	void Service2(int id);
	
	//�����ǥȮ��
	void Service3(int id);
}
