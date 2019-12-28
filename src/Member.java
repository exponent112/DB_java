import javax.swing.ImageIcon;

public class Member {
	String name,pw,id,birth;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRc() {
		return rc;
	}

	public void setRc(String rc) {
		this.rc = rc;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public ImageIcon getIco() {
		return ico;
	}

	public void setIco(ImageIcon ico) {
		this.ico = ico;
	}

	String sex;
	String rc,fname;
	private ImageIcon ico;

	public Member(String name,String pw,String id,String birth,int sex,String rc, ImageIcon ico) {

		super();

		this.name = name;
		this.pw = pw;
		this.id = id;
		this.birth = birth;
		if(sex == 0)this.sex = null;
		else if(sex == 1)this.sex = "남자";
		else if(sex == 2)this.sex = "여자";
		else this.sex = "생일";
		this.rc = rc;
		this.ico = ico;

	}

	public Member() {

		// TODO Auto-generated constructor stub

	}


}
