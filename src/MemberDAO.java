import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class MemberDAO {
	Member m;
	String name,pw,id,birth;
	int sex;
	String rc,fname;
	
	public void make (String name,String pw,String id,String birth,int sex,String rc,String fname) {

			m = new Member();
		

			m.setName(name);
			m.setPw(pw);
			m.setId(id);
			m.setBirth(birth);
			if(sex == 0)m.setSex(null);
			else if(sex == 1)m.setSex("남자");
			else if(sex == 2)m.setSex("여자");
			m.setFname(fname);
			m.setRc(rc);

			

			

	BufferedImage bing;
	try {
		bing = ImageIO.read(getClass().getResourceAsStream(fname));
		m.setIco((new ImageIcon((Image)bing)));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	}
	
}
