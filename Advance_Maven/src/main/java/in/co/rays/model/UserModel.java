package in.co.rays.model;


import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.co.rays.bean.UserBean;

public class UserModel {

	public int nextPk() throws Exception {
		int pk = 0;
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select max(id) from user");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);

		}
		return pk + 1;

	}

	public void add(UserBean bean) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		PreparedStatement ps = conn.prepareStatement("insert into user values (?, ?, ?, ?, ?, ?, ?)");
		ps.setInt(1, nextPk());
		ps.setString(2, bean.getName());
		ps.setString(3, bean.getLogin());
		ps.setString(4, bean.getPassword());
		ps.setString(5, bean.getConfirmPassword());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		ps.setLong(7, bean.getMobileNo());

		int i = ps.executeUpdate();
		

	}

	public UserBean authenticate(UserBean bean) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from user where login = ? and password = ?");
		ps.setString(1, bean.getLogin());
		ps.setString(2, bean.getPassword());
		ResultSet rs = ps.executeQuery();
		UserBean bean1 = null;
		while (rs.next()) {
			bean1 = new UserBean();
			bean1.setId(rs.getInt(1));
			bean1.setName(rs.getString(2));
			bean1.setLogin(rs.getString(3));
			bean1.setPassword(rs.getString(4));
			bean1.setConfirmPassword(rs.getString(5));
			bean1.setDob(rs.getDate(6));
			bean1.setMobileNo(rs.getLong(7));

		}
		return bean1;

	}
}
