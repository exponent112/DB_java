public class TableName { 
	/*데이터베이스에 속성부분을 변수로 만들어 줍니다.*/ 
	String name = null;
	String pw = null;
	String id = null;
	String birth = null;
	String fname = null;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	int sex = 0;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getRc() {
		return rc;
	}
	public void setRc(String rc) {
		this.rc = rc;
	}
	String rc;
	/*생성자입니다.*/ 
	public TableName() {}
	public TableName(String name,String pw,String id,String birth,int sex,String rc,String fname)
	{
		super(); 
		this.name =  name;
		this.pw =  pw;
		this.id =  id;
		this.birth =  birth;
		this.sex = sex;
		this.rc =  rc;
		this.fname = fname;
		} 
	/*각 변수에 getter와 setter입니다.*/ 
	
}

