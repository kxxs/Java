import java.sql.*;

public class Test {
	public static void main(String[] args) throws Exception {
		String DBDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
		String connectionStr = "jdbc:odbc:exp10";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		// 加载驱动器 
		Class.forName(DBDriver); 
		//连接数据库 
		con = DriverManager.getConnection(connectionStr, "Test", "1234");
		//创建Statement对象 
		stmt = con.createStatement(); 
		Student s1 = new Student("A", "201", 'M');
		StudentOperator.addStudent(s1, stmt);
		System.out.println("After add s1:");
		StudentOperator.showStudents(stmt);
		Student s2 = new Student("B", "202", 'F');
		StudentOperator.addStudent(s2, stmt);
		System.out.println("After add s2:");
		StudentOperator.showStudents(stmt);
		StudentOperator.removeStudent(s1.number, stmt);
		System.out.println("After remove s1:");
		StudentOperator.showStudents(stmt);
		s2.name = "C";
		StudentOperator.updateStudent(s2, stmt);
		System.out.println("After update s2:");
		StudentOperator.showStudents(stmt);
		Score score1 = new Score("202", 90, 89, 88, 87, 86);
		ScoreOperator.addScore(score1, stmt);
		System.out.println("After add score1:");
		ScoreOperator.showScores(stmt);
		score1.chinese = 95;
		ScoreOperator.updateScore(score1, stmt);
		System.out.println("After update score1:");
		ScoreOperator.showScores(stmt);
		ScoreOperator.deleteScore(score1.number, stmt);
		System.out.println("After delete score1:");
		ScoreOperator.showScores(stmt);
		stmt.close(); // 关闭语句 con.close(); //关闭连接 } }
	}
}
