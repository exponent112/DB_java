import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; /*Database Access Object입니다.*/
import java.util.Vector; 
public class TableNameDAO { 
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";// jdbc 드라이버 주소 
	static final  String DB_URL = "jdbc:mysql://localhost/JDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	// DB 접속 주소 
	//localhost는 접속하려는 데이터베이스 주소를 입력하시면 됩니다. localhost를 사용하면 됩니다. 
	//3306은 데이터베이스에 접속할때 사용하는 포터번호입니다. 설치할때 설정한 포트번호를 사용합니다. 
	//databasename에는 접속하려는 database의 name을 입력해줍니다. 
	static final String USERNAME = "root"; 
	// DB ID 
	static final String PASSWORD = "dev"; 
	// DB Password 
	private Connection conn = null; 
	private Statement stmt = null;
	private ResultSet rs = null; //데이터베이스 접속을 확인합니다. 
	
	public static Vector<String> idVector = new Vector<String>();
	public Vector<TableName> Clientlist = new Vector<TableName>();
	
	
	public TableNameDAO(){ // DB 접속 
		System.out.print("DatabaseName 데이터베이스 접속 : "); 
		try { Class.forName(JDBC_DRIVER); 
		conn = DriverManager.getConnection(DB_URL,USERNAME,"dev"); 
		if (conn != null){System.out.println("성공");
		} else{System.out.println("실패");} } 
		catch (ClassNotFoundException e) { 
			System.out.println("Class Not Found Exection"); 
			e.printStackTrace(); } 
		catch (SQLException e) { 
			System.out.println("SQL Exception"); 
			e.printStackTrace(); } }
	//UserDAO 
	// 데이터베이스에 데이터를 Insert하는 Method입니다. 
	
	public void tableInsert(String name,String pw,String id,String birth,int sex,String rc,String fname){ 
		TableName tn = new TableName(name,pw,id,birth,sex,rc,fname); 
		String query;
		//외부에서 매개변수로 데이터를 받아 Qurey문을 만들어 줍니다. 
		if(sex == 0) {
			query = "insert into user (name, pw, id, birth, sex, rc, fname)" + " values ('" + tn.name + "', '" + tn.pw + "', '" + tn.id 
					+ "', '" + tn.birth + "', " + "null" + ", '" + tn.rc +"', '" +tn.fname +"');"; 
		}
		else {
			query = "insert into user (name, pw, id, birth, sex, rc, fname)" + " values ('" + tn.name + "', '" + tn.pw + "', '" + tn.id 
					+ "', '" + tn.birth + "', '" + tn.sex + "', '" + tn.rc +"', '" +tn.fname +"');"; 
		}
	
		System.out.println(query); // Qurey문 확인 
		try { // 데이터베이스에 접속합니다. 
			Class.forName(JDBC_DRIVER); 
			conn = DriverManager.getConnection(DB_URL,USERNAME,"dev"); 
			stmt = conn.createStatement(); //데이터베이스에 query문을 넘길 Statement를 만들어줍니다. 
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery("SELECT * from user");
			pst.executeUpdate(query); // query를 실행시킵니다. 
			stmt.close(); 
			conn.close(); } 
		catch (ClassNotFoundException e) { 
			System.out.println("Class Not Found Exection"); } 
		catch (SQLException e) { 
			System.out.println("SQL Exception : " + e.getMessage()); } } 
	
	
	public void tableDelete(String id){ 
		//외부에서 매개변수로 데이터를 받아 Qurey문을 만들어 줍니다. 
		String query = "delete from user where id='" + id + "';"; 
		System.out.println(query); // Qurey문 확인 
		try { // 데이터베이스에 접속합니다. 
			Class.forName(JDBC_DRIVER); 
			conn = DriverManager.getConnection(DB_URL,USERNAME,"dev"); 
			stmt = conn.createStatement(); //데이터베이스에 query문을 넘길 Statement를 만들어줍니다. 
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery("SELECT * from user");
			pst.executeUpdate(query); // query를 실행시킵니다. 
			stmt.close(); 
			conn.close(); } 
		catch (ClassNotFoundException e) { 
			System.out.println("Class Not Found Exection"); } 
		catch (SQLException e) { 
			System.out.println("SQL Exception : " + e.getMessage()); } } 
	
	public void tableUpdate(String id,int choice,String change){ 
		//String name,String pw,String id,String birth,int sex,String rc
		String value;
		if(choice == 0) value = "name";
		else if(choice == 1) value = "pw";
		else if(choice == 2) value = "id";
		else if(choice == 3) value = "birth";
		else if(choice == 4) value = "rc";
		else value = "fname";
		String query;
		
		//외부에서 매개변수로 데이터를 받아 Qurey문을 만들어 줍니다.
		
		query = "update user set " + value + "='"  +change+ "' where id='" + id + "';";
	
		System.out.println(query); // Qurey문 확인
		try { // 데이터베이스에 접속합니다. 
			Class.forName(JDBC_DRIVER); 
			conn = DriverManager.getConnection(DB_URL,USERNAME,"dev"); 
			stmt = conn.createStatement(); //데이터베이스에 query문을 넘길 Statement를 만들어줍니다. 
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery("SELECT * from user");
			pst.executeUpdate(query); // query를 실행시킵니다. 
			stmt.close(); 
			conn.close(); } 
		catch (ClassNotFoundException e) { 
			System.out.println("Class Not Found Exection"); } 
		catch (SQLException e) { 
			System.out.println("SQL Exception : " + e.getMessage()); } } 
	
	public void tableUpdate(String id,int sex){ 
		String query;
		if(sex == 0) {
			query = "update user set sex =" +null+ " where id='" + id + "';";
		}
		else
			query = "update user set sex ='" +sex+ "' where id='" + id + "';";
		System.out.println(query); // Qurey문 확인 
		try { // 데이터베이스에 접속합니다. 
			Class.forName(JDBC_DRIVER); 
			conn = DriverManager.getConnection(DB_URL,USERNAME,"dev"); 
			stmt = conn.createStatement(); //데이터베이스에 query문을 넘길 Statement를 만들어줍니다. 
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery("SELECT * from user");
			pst.executeUpdate(query); // query를 실행시킵니다. 
			stmt.close(); 
			conn.close(); } 
		catch (ClassNotFoundException e) { 
			System.out.println("Class Not Found Exection"); } 
		catch (SQLException e) { 
			System.out.println("SQL Exception : " + e.getMessage()); } } 
	
	
	public void tableSelect() { 
		String query = "SELECT * FROM user"; // table에 모든 레코드를 출력하는 query문입니다. 
		
		try { // 데이터베이스에 접속합니다. 
			Class.forName(JDBC_DRIVER); 
			conn = DriverManager.getConnection(DB_URL,"root",PASSWORD); 
			stmt = conn.createStatement(); //데이터베이스에 query문을 넘길 Statement를 만들어줍니다. 
			rs = stmt.executeQuery(query); // query를 실행시킵니다. 
			//executeQuery()와 executeUpdate()다른 상황에 사용하는 명령어입니다. 
			//executeUpdate() // INSERT, UPDATE, DELETE 문과 같은 형태에서 사용합니다.. 
			//executeQuery() //DDL문과 SELECT문에서 사용하시면 됩 니다. 
			//객체에서 위에서 부터 데이터를 출력합니다. 
			while (rs.next()){ 
				TableName tn = new TableName(); // TableName 객체를 만들어줍니다. 
				tn.setName(rs.getString("name")); 
				tn.setPw(rs.getString("pw")); 
				tn.setId(rs.getString("id")); 
				tn.setBirth(rs.getString("birth")); 
				tn.setSex(rs.getInt("sex"));
				tn.setRc(rs.getString("rc")); 
				tn.setFname(rs.getString("fname")); 
				idVector.add(tn.id);
				Clientlist.add(tn);
				} 
			stmt.close(); stmt.close(); conn.close(); } 
		catch (ClassNotFoundException e) { 
			System.out.println("Class Not Found Exection"); } 
		catch (SQLException e) { 
			System.out.println("SQL Exception : " + e.getMessage()); } } 
	}

