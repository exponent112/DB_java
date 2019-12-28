import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.border.*;
 
public class LoginPage extends JFrame implements ActionListener
{
    JLabel lbl,la1,la2,la3;
    String fname = "./image/image1.jpg";
    JTextField id;
    JPasswordField passwd;
    JPanel idPanel,paPanel,loginPanel;
    JButton b1,b2;
    String client_id,client_pw;
    JPanel imgPanel;
    Image img;
    SignUpPage b;
    mainPage c ;
    ManagerPage2 m;
 
    public LoginPage()
    {
          super( "Data Base" );
          // FlowLayout사용
          Color c=new Color(63, 36, 29); 
          Color b=new Color(250, 218, 16); 
          setLocation(500,300);
          getContentPane().setBackground(b);
          setLayout( new FlowLayout() );
          // Border로 영역 생성
          EtchedBorder eborder =  new EtchedBorder();
          idPanel = new JPanel();
          try {
        	  File source = new File(fname);
        	  img = ImageIO.read(source);   	  
          }catch(IOException e) {
          }
          Image changeImg = img.getScaledInstance(180,100,Image.SCALE_SMOOTH);
          JLabel imgLabel = new JLabel(new ImageIcon(changeImg));
          imgLabel.setBounds(100,70,300,200);
//          
          
          imgPanel = new JPanel();
          imgPanel.add(imgLabel);
          imgPanel. setBackground(b);
       
          idPanel. setBackground(b);
          paPanel = new JPanel();
          paPanel. setBackground(b);
          add(imgPanel);
          la3 = new JLabel("아이디");
          la3.setForeground(c);
          la2 = new JLabel("패스워드");
          la2.setForeground(c);
          // id텍스트필드와 pw텍스트 필드 선언
          id = new JTextField(10);
          passwd = new JPasswordField(10);
          idPanel.add(la3);
          idPanel.add(id);
          paPanel.add( la2 );
          paPanel.add( passwd );
          // 로그인과 회원가입을 위한 패널 생성
          loginPanel = new JPanel();
          b1 = new JButton("로그인");
          b2 = new JButton("회원가입");
          loginPanel.add( b1 );
          loginPanel.add( b2 );
          loginPanel. setBackground(b);
          add(imgPanel);
          add(idPanel);
          add(paPanel);
          add(loginPanel);
          b1.addActionListener(this);
          b2.addActionListener(this);
          pack();
          setSize( 350,400 );
          setVisible(true);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    class imagePan extends JPanel{
    	public Image img;
    	
    	
    	imagePan(Image img){
    		this.img = img;
    		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
    		setLayout(null);
    	}
    	imagePan(){
    	}
    	public void paintComponent(Graphics g) {
           //  ImageIcon image = new ImageIcon(name);
             g.drawImage(img,0,0,null);

    	}

    }
    




//처: https://ddo-o.tistory.com/49 [공순이의 블로그]

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		if(e.getSource()== b1) {
			TableNameDAO a = new TableNameDAO();
			a.tableSelect();
			boolean ID = false,PW = false;
			client_id = id.getText();
			client_pw = passwd.getText();
//			System.out.println(client_id + client_pw);
			if(client_id.equals("manager")&&client_pw.equals("manager123")) {
				m = new ManagerPage2();
				 dispose();
			}
			else {
				int count = 0;
				for(TableName A: a.Clientlist) {
					if(A.getId().equals(client_id)) {
						ID = true;
						if(A.getPw().equals(client_pw)){
							PW = true;
							break;
						}//pw맞춤
					}//id가 존재
					count ++;
				}
				if(ID && PW) {
					System.out.println(client_id);
					c = new mainPage(client_id,count);
					 dispose();
				}
				else if(ID) {
					  JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요.");
				}
				else {
					  JOptionPane.showMessageDialog(null, "등록되지 않은 회원입니다.");
				}
			}
		
		}
		//탈퇴 -> 로그인 페이지 열기
		else if(e.getSource()== b2){
			//SignUpPage
			b = new SignUpPage();
		}
	}
}