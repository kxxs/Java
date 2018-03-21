package useSQL;

import java.sql.*;

public class UseSQL2 {
	// 输出查询结果
	private static void showRs(ResultSet rs) throws SQLException {
		ResultSetMetaData data = rs.getMetaData();// 获取rs的列名称、属性等信息

		String columnName = "";
		for (int i = 1; i <= data.getColumnCount(); i++) {
			columnName += data.getColumnName(i) + "\t\t";// 将各个列名用字符串拼接起来
		}
		System.out.println(columnName);// 输出所有列的列名名

		while (rs.next()) {
			String columnValue = "";
			for (int i = 1; i <= data.getColumnCount(); i++) {
				columnValue += rs.getString(i) + "\t\t";// 将每一行的各列用字符串拼接
			}
			System.out.println(columnValue);// 输出每一行
		}
		System.out.println("\n");
	}

	// 输出一张表的所有行、所有列
	private static void showTable(Statement stmt, String table) throws SQLException {
		System.out.println(table + "表的信息如下");
		ResultSet rs = stmt.executeQuery("Select * From " + table);// 用select语句获得查询结果
		showRs(rs);
	}

	public static void main(String[] args) {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// 装载驱动器
			Connection con = DriverManager.getConnection("jdbc:odbc:TEST", "Test", "1234");// 连接数据库
			Statement stmt = con.createStatement();// 创建Statement对象
			ResultSet rs = null;// 查询结果

			// 删除已有的五张表，程序在运行前在数据库已经建了表
			String tableName[] = { "department", "student", "teacher", "course", "selection" };
			for (String str : tableName) {
				stmt.executeUpdate("drop table " + str);
			}
			System.out.println("删除表\n\n");

			// 建五张表，分别为department、student、teacher、course、selection
			stmt.executeUpdate("create table department(dNumber int primary key,dName varchar(255))");
			stmt.executeUpdate(
					"create table teacher(tNumber int primary key,teacherName varchar(255) not null,sex varchar(20),dNumber int)");
			stmt.executeUpdate(
					"create table student(sNumber int primary key,sName varchar(255) not null,sex varchar(20),dNumber int)");
			stmt.executeUpdate(
					"create table course(cNumber int primary key,cName varchar(255) ,credit int,tNumber int)");
			stmt.executeUpdate(
					"create table selection(sNumber int ,cNumber int ,grade varchar(255),primary key(sNUmber,cNumber))");

			// 给department表添加数据
			stmt.executeUpdate("INSERT INTO department VALUES (0, 'Computer');");
			stmt.executeUpdate("INSERT INTO department VALUES (1, 'Precision Instrument');");
			stmt.executeUpdate("INSERT INTO department VALUES (2, 'Mathematics');");

			// 给student表添加数据
			stmt.executeUpdate("INSERT INTO student VALUES (233, 'Li Si', 'Male', 1)");
			stmt.executeUpdate("INSERT INTO student VALUES (666, 'Wang Wu', 'Female', 2)");
			stmt.executeUpdate("INSERT INTO student VALUES (1000, 'AAA', 'Male', 0);");

			// 给teacher表添加数据
			stmt.executeUpdate("INSERT INTO teacher VALUES (0, 'Zheng Li', 'Female', 0);");
			stmt.executeUpdate("INSERT INTO teacher VALUES (1, 'Math Teacher', 'Male', 2);");

			// 给course表添加数据
			stmt.executeUpdate("INSERT INTO course VALUES (740123, 'java', 3, 0);");
			stmt.executeUpdate("INSERT INTO course VALUES (123, 'Math', 5, 1);");

			// 给选课表添加数据
			stmt.executeUpdate("INSERT INTO selection VALUES (233, 740123, '');");
			stmt.executeUpdate("INSERT INTO selection VALUES (233, 123, '');");
			stmt.executeUpdate("INSERT INTO selection VALUES (666, 740123, 'A');");
			stmt.executeUpdate("INSERT INTO selection VALUES (1000, 123, '');");

			for (String str : tableName) {// 使用增强for循环遍历每个表
				showTable(stmt, str);
			}

			// 将Wang Wu的名字改为Wang Si
			stmt.executeUpdate("UPDATE student SET sName = 'Wang Si' WHERE sName='Wang Wu'");
			System.out.println("将Wang Wu姓名改为Wang Si后");
			showTable(stmt, "student");

			// 用带参数的SQL语句，将Wang Si性别设为Male
			PreparedStatement pstmt = con.prepareStatement("UPDATE student SET sex=? WHERE sName=?");
			pstmt.setString(1, "Male");
			pstmt.setString(2, "Wang Si");
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("通过PreparedStatement将Wang Si性别设为Male");
			showTable(stmt, "student");

			// 查找最大系号，Max为SQL函数
			rs = stmt.executeQuery("SELECT Max(dNumber)  FROM department WHERE (((department.[dNumber]) Is Not Null))");
			String str = "最大系号为";
			while (rs.next())
				str += rs.getString(1);
			System.out.println(str + "\n\n");

			// 查找学号在0到700之间的学生信息，输出学号、姓名、性别、所属系号、系名,按学号降序排列
			rs = stmt.executeQuery(
					"SELECT student.sNumber, student.sName, student.sex,  student.dNumber, department.dName FROM department INNER JOIN student ON department.dNumber = student.dNumber WHERE (((student.sNumber) Between 0 And 700)) ORDER BY student.sNumber DESC");
			System.out.println("查找学号在0到700之间的学生信息，输出学号、姓名、性别、所属系号、系名");
			showRs(rs);

			// 查找名字像'%Li%'的学生，%可实现模糊匹配
			rs = stmt.executeQuery("SELECT sNumber, sName, sex ,  dNumber   FROM student WHERE sName like '%Li%'");
			System.out.println("查找名字像'%Li%'的学生，输出学号，性别，系号");
			showRs(rs);

			// 查找Zheng Li老师开的课
			rs = stmt.executeQuery(
					"SELECT course.cNumber, course.cName FROM course, teacher WHERE (((course.tNumber)=teacher.tNumber) And ((teacher.teacherName)='Zheng Li'))");
			System.out.println("查找Zheng Li老师开的课，输出课程号，课程名");
			showRs(rs);

			// 查找选Zheng Li老师课的学生（方法1）
			rs = stmt.executeQuery(
					"SELECT student.sNumber, student.sName   FROM teacher INNER JOIN (student INNER JOIN (course INNER JOIN selection ON course.cNumber = selection.cNumber) ON student.sNumber = selection.sNumber) ON teacher.tNumber = course.tNumber WHERE (((teacher.teacherName)='Zheng Li') AND ((teacher.tNumber)=[course].[tNumber]) AND ((selection.sNumber)=[student].[sNumber]) AND ((course.cNumber)=[selection].[cNumber]))");
			System.out.println("查找选Zheng Li老师课的学生（方法1）,输出学号、姓名");
			showRs(rs);

			// 查找选Zheng Li老师课的学生（方法2），查询语句可以包含子查询，in是集合运算符
			rs = stmt.executeQuery(
					"SELECT student.sNumber, student.sName  FROM student, selection WHERE student.sNumber=selection.sNumber and selection.cNumber  in (SELECT course.cNumber  FROM course, teacher WHERE (((course.tNumber)=teacher.tNumber) And ((teacher.teacherName)='Zheng Li'));)");
			System.out.println("查找选Zheng Li老师课的学生（方法2）,输出学号、姓名");
			showRs(rs);

			// 删除学生AAA
			stmt.executeUpdate("DELETE * FROM student WHERE sName='AAA'");
			System.out.println("删除学生AAA后");
			showTable(stmt, "student");
			
			stmt.close();//关闭语句
			con.close();//关闭连接
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
