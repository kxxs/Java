import java.sql.*;

public class StudentOperator {

	// 添加一个学生，如果成功，则返回0，否则返回-1
	public static int addStudent(Student s, Statement stmt) throws Exception {
		// 首先查找该学号的学生是否存在，如果存在，则不能添加
		int err = 0;
		ResultSet rs = stmt.executeQuery("SELECT * FROM Student"); // 查询表
		while (rs.next()) {
			if (rs.getString("number").equals(s.number))
				err = -1;
		}

		if (err == 0) {
			String SQLOrder = "INSERT INTO Student VALUES(" + s.name + ",'" + s.number + "'," + s.sex + ")";
			stmt.executeUpdate(SQLOrder);
		}
		return err;
	}

	// 添加一个学生及其成绩
	public static int addStudent(Student s, Score score, Statement stmt) throws Exception {
		// 首先查找该学号的学生是否存在，如果存在，则不能添加
		int err = 0;
		ResultSet rs = stmt.executeQuery("SELECT * FROM Student"); // 查询表
		while (rs.next()) {
			if (rs.getString("number").equals(s.number))
				err = -1;
		}

		if (err == 0) {
			String SQLOrder = "INSERT INTO Student VALUES(" + s.name + ",'" + s.number + "'," + s.sex + ")";
			stmt.executeUpdate(SQLOrder);
			SQLOrder = "INSERT INTO Score VALUES(" + score.number + ",'" + score.chinese + "'," + score.math + ",'"
					+ score.english + ",'" + score.IT + ",'" + score.politics + ")";
			stmt.executeUpdate(SQLOrder);
		}
		return err;
	}

	// 根据学号删除一个学生
	public static int removeStudent(String number, Statement stmt) throws Exception {
		// 首先删除学生 ......
		// 其次在Score表中查找是否有该学生的成绩，如果有，也删除
	}

	// 根据s的学号，修改该学生的信息
	public static int updateStudent(Student s, Statement stmt) throws Exception {

	}

	// 显示Student表中所有记录
	public static void showStudents(Statement stmt) throws Exception {

	}
}
