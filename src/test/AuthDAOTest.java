package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bean.UserInfoBean;
import common.ProductException;
import dao.AuthDAO;

class AuthDAOTest {

	@Test
	void test() throws ProductException {
		UserInfoBean uib =new UserInfoBean();
		uib.setUserID("tm001");
		uib.setPassword("tm001");
		
		AuthDAO adao=new AuthDAO();
		adao.getUserInfo(uib);
		
		assertEquals("戸松太郎", uib.getUserName());
	}
}
