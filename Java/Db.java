package com.cathaybk.practice.nt50354.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Db {
	public static final String CONN_URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	public static final String QUERY = "select * from STUDENT.CARS where MANUFACTURER = ? and TYPE = ?";
	public static final String INSERT = "insert into STUDENT.CARS (MANUFACTURER, TYPE, MIN_PRICE, PRICE) values (?, ?, ?, ?)";
	public static final String UPDATE = "update STUDENT.CARS set  MIN_PRICE= ? , PRICE=? where MANUFACTURER = ? and TYPE=?";
	public static final String DELETE = "DELETE FROM STUDENT.CARS WHERE MANUFACTURER = ? and TYPE=?";

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(CONN_URL, "student", "student123456");
				PreparedStatement pstmt = conn.prepareStatement("select * from STUDENT.CARS");) {
			ResultSet rs = pstmt.executeQuery();
			List<Map<String, String>> carslist = new ArrayList<>();
			while (rs.next()) {
				Map<String, String> carsMap = new HashMap<>();
				carsMap.put("MANUFACTURER", rs.getString("MANUFACTURER"));
				carsMap.put("TYPE", rs.getString("TYPE"));
				carsMap.put("MIN_PRICE", rs.getString("MIN_PRICE"));
				carsMap.put("PRICE", rs.getString("PRICE"));
				carslist.add(carsMap);
			}
			for (Map<String, String> list : carslist) {
				System.out.println(list);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Scanner scanner = new Scanner(System.in);
		System.out.println("請選擇以下指令輸入:select、insert、update、delete");
		String instruction = scanner.next();

		if ("select".equals(instruction)) {
			doQuery();
		} else if ("insert".equals(instruction)) {
			doInsert();
		} else if ("update".equals(instruction)) {
			doUpdate();
		} else {
			doDelete();
		}
		scanner.close();

	}

	public static void doQuery() {
		try (Connection conn = DriverManager.getConnection(CONN_URL, "student", "student123456");
				PreparedStatement pstmt = conn.prepareStatement(QUERY);) {
			conn.setAutoCommit(false);
			Scanner qScanner = new Scanner(System.in);
			System.out.println("請輸入製造商:");
			String m = qScanner.next();
			System.out.println("請輸入類型:");
			String t = qScanner.next();
			pstmt.setString(1, m);
			pstmt.setString(2, t);
			ResultSet rs = pstmt.executeQuery();
			StringBuilder sb = new StringBuilder();
			sb.append("查詢結果： ");
			while (rs.next()) {
				sb.append("製造商： ").append(rs.getString("MANUFACTURER")).append("，型號：").append(rs.getString("TYPE"))
						.append("，售價：").append(rs.getString("PRICE")).append("，底價：").append(rs.getString("MIN_PRICE"));
			}
			System.out.println(sb.toString());
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void doInsert() {
		try (Connection conn = DriverManager.getConnection(CONN_URL, "student", "student123456");) {
			try {
				PreparedStatement pstmt = conn.prepareStatement(INSERT);
				{
					conn.setAutoCommit(false);
					Scanner iScanner = new Scanner(System.in);
					System.out.println("請輸入製造商:");
					String m = iScanner.next();
					System.out.println("請輸入類型:");
					String t = iScanner.next();
					System.out.println("請輸入底價:");
					int mp = iScanner.nextInt();
					System.out.println("請輸入售價:");
					int p = iScanner.nextInt();
					pstmt.setString(1, m);
					pstmt.setString(2, t);
					pstmt.setInt(3, mp);
					pstmt.setInt(4, p);
					pstmt.executeUpdate();
					conn.commit();
					System.out.println("新增成功");
				}
			} catch (Exception e) {
				System.out.println("新增失敗，原因：" + e.getMessage());
				try {
					conn.rollback();
				} catch (SQLException sqle) {
					System.out.println("rollback 失敗，原因：" + sqle.getMessage());
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public static void doUpdate() {
		try (Connection conn = DriverManager.getConnection(CONN_URL, "student", "student123456");) {
			try {
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);
				{
					conn.setAutoCommit(false);
					Scanner uScanner = new Scanner(System.in);
					System.out.println("請輸入底價:");
					String mp = uScanner.next();
					System.out.println("請輸入售價:");
					String p = uScanner.next();
					System.out.println("請輸入製造商:");
					String m = uScanner.next();
					System.out.println("請輸入類型:");
					String t = uScanner.next();
					pstmt.setString(1, mp);
					pstmt.setString(2, p);
					pstmt.setString(3, m);
					pstmt.setString(4, t);
					pstmt.executeUpdate();
					conn.commit();
					System.out.println("修改成功");
				}
			} catch (Exception e) {
				System.out.println("修改失敗，原因：" + e.getMessage());
				try {
					conn.rollback();
				} catch (SQLException sqle) {
					System.out.println("rollback 失敗，原因：" + sqle.getMessage());
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public static void doDelete() {
		try (Connection conn = DriverManager.getConnection(CONN_URL, "student", "student123456");) {
			try {
				PreparedStatement pstmt = conn.prepareStatement(DELETE);
				{
					conn.setAutoCommit(false);
					Scanner dScanner = new Scanner(System.in);
					System.out.println("請輸入製造商:");
					String m = dScanner.next();
					System.out.println("請輸入類型:");
					String t = dScanner.next();
					pstmt.setString(1, m);
					pstmt.setString(2, t);
					pstmt.executeUpdate();
					conn.commit();
					System.out.println("刪除成功");
				}
			} catch (Exception e) {
				System.out.println("刪除失敗，原因：" + e.getMessage());
				try {
					conn.rollback();

				} catch (SQLException sqle) {
					System.out.println("rollback 失敗，原因：" + sqle.getMessage());
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
