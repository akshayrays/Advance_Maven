package in.co.rays.test;

import java.text.SimpleDateFormat;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class TestUserModel {
	public static void main(String[] args) throws Exception {
		//testAdd();
		testAuth();
	}

	private static void testAuth() throws Exception {
		UserBean bean = new UserBean();
		bean.setLogin("akshay@gmail.com");
		bean.setPassword("123");

		UserModel model = new UserModel();
		UserBean bean1 = model.authenticate(bean);

		if (bean1 != null) {
			System.out.println("User Valid");
			System.out.println(bean1.getName());
		} else {
			System.out.println("user Invalid");
		}

	}

	private static void testAdd() throws Exception {

		
		
		UserBean bean = new UserBean();

		SimpleDateFormat sdf = new SimpleDateFormat("MM-DD-yyy");

		bean.setName("Akshay");
		bean.setLogin("akshay@gmail.com");
		bean.setPassword("123");
		bean.setConfirmPassword("123");
		bean.setDob(sdf.parse("11-04-1995"));
		bean.setMobileNo(12345);

		UserModel model = new UserModel();

		model.add(bean);
		
		System.out.println("inserted");
	}

}
