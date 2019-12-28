import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.border.*;
import javax.swing.filechooser.FileSystemView;
 
 
public class SignUpPage extends JFrame  implements ActionListener
{
    JLabel lbl,la1,pw_la,pw2_la,id_la,la_name;
    JLabel birthLa,sexLabel,rcLabel;
    JTextField id_field,name_field,birth_field;
    JPasswordField passwd,passwd2;
    JPanel namePanel,idPanel,paPanel,pa2Panel,loginPanel;
    JPanel birthPanel, sexPanel,rcPanel,imPanel;
    JButton submitB,idB,imgB;
    JLabel content;
    JCheckBox male,female;
    String test_id= null,id= null, name = null;
    String re_pw = null, pw = null;
    String birth = null, rc = null;
    String fname = "./image/origin.jpg";
    Image img;
    int sex = 0;
    JComboBox rcComboBox;
    JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    int returnValue ;
    String[] ccString = {"선택안함","손양원","열송학사", "장기려", "카이퍼", "카마이클","토레이"};
   
    
    public SignUpPage(String fname)
    {
          super( "Sign Up" );
          this.fname = fname;
          Color b=new Color(250, 218, 16); 
          Color c=new Color(63, 36, 29);
          getContentPane().setBackground(b);
          setLocation(500,300);
          // FlowLayout사용
          setLayout( new FlowLayout(FlowLayout.LEFT));
          // Border로 영역 생성
          EtchedBorder eborder =  new EtchedBorder();
          // 레이블 생성     
          lbl = new JLabel( "                     *이 붙은 것은 필수입력요소입니다.                    " );
          // 레이블에 영역 만들기
          lbl.setBorder(eborder);
          // 레이블 추가
          add( lbl );
          
          try {
        	  File source = new File(fname);
        	  img = ImageIO.read(source);   	  
          }catch(IOException e) {
          }
          AbstractBorder brdrLeft = new TextBubbleBorder(Color.BLACK,2,8,16);
          Image changeImg = img.getScaledInstance(100,100,Image.SCALE_SMOOTH);
          JLabel imgLabel = new JLabel(new ImageIcon(changeImg));
          imgLabel.setBounds(100,70,300,200);
          imgLabel.setBorder(brdrLeft);
          
          // id패널과 pw 패널생성
          idPanel = new JPanel();
          idPanel. setBackground(b);


          imPanel = new JPanel();
          imPanel.setBackground(b);
          
          imgB = new JButton("사진선택");
          
          imPanel.add(imgLabel);
          imPanel.add(imgB);
          imgB.addActionListener(this);
          imPanel.setForeground(b);
          add(imPanel);
          paPanel = new JPanel();
          paPanel. setBackground(b);
          pa2Panel = new JPanel();
          pa2Panel. setBackground(b);
          namePanel = new JPanel();
          namePanel. setBackground(b);
          birthPanel = new JPanel();
          birthPanel. setBackground(b);
          sexPanel = new JPanel();
          sexPanel. setBackground(b);
          rcPanel = new JPanel();
          rcPanel. setBackground(b);
         
          idB = new JButton("중복확인");
          la_name = new JLabel("이름*                ");
          id_la = new JLabel("아이디*             ");
          pw_la = new JLabel("비밀번호*          ");
          pw2_la = new JLabel("비밀번호 확인*   ");
          birthLa = new JLabel("생일(YYMMDD)");
          sexLabel = new JLabel("성별                  ");
          rcLabel = new JLabel("RC                   ");
          
          // id텍스트필드와 pw텍스트 필드 선언
          id_field = new JTextField(10);
          id_field.setForeground(c);
          name_field = new JTextField(10);
          name_field.setForeground(c);
          birth_field = new JTextField(10);
          birth_field.setForeground(c);
          passwd = new JPasswordField(10);
          passwd.setForeground(c);
          passwd2 = new JPasswordField(10);
          passwd2.setForeground(c);
          rcComboBox = new JComboBox(ccString);
          
          male = new JCheckBox("남자");
          
          female = new JCheckBox("여자");
          
          namePanel.add(la_name);//name
          namePanel.add(name_field);//name
          
          idPanel.add(id_la);//id
          idPanel.add(id_field);//id
          idPanel.add(idB);//id
          
          paPanel.add( pw_la );//pw
          paPanel.add( passwd );//pw
          
          pa2Panel.add(pw2_la);//re-pw
          pa2Panel.add( passwd2);//re-pw
          
          birthPanel.add(birthLa);
          birthPanel.add(birth_field);
          
          sexPanel.add(sexLabel);
          sexPanel.add(male);
          sexPanel.add(female);
          
          rcPanel.add(rcLabel);
          rcPanel.add(rcComboBox);
          // 로그인과 회원가입을 위한 패널 생성
          
          
          loginPanel = new JPanel();
          submitB = new JButton("제출");
          loginPanel.add( submitB );
          loginPanel. setBackground(b);
          
          add(namePanel);
          add(idPanel);
          add(paPanel);
          add(pa2Panel);
          add(birthPanel);
          add(sexPanel);
          add(rcPanel);
          idB.addActionListener(this);
          submitB.addActionListener(this);
          add(loginPanel);
          setSize( 350, 500 );
          setVisible(true);
          //setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    
    public SignUpPage()
    {
          super( "Sign Up" );
          Color b=new Color(250, 218, 16); 
          Color c=new Color(63, 36, 29);
          getContentPane().setBackground(b);
          setLocation(500,300);
          // FlowLayout사용
          setLayout( new FlowLayout(FlowLayout.LEFT));
          // Border로 영역 생성
          EtchedBorder eborder =  new EtchedBorder();
          // 레이블 생성     
          lbl = new JLabel( "                     *이 붙은 것은 필수입력요소입니다.                    " );
          // 레이블에 영역 만들기
          lbl.setBorder(eborder);
          // 레이블 추가
          add( lbl );
          
          try {
        	  File source = new File(fname);
        	  img = ImageIO.read(source);   	  
          }catch(IOException e) {
          }
          AbstractBorder brdrLeft = new TextBubbleBorder(Color.BLACK,2,8,16);
          Image changeImg = img.getScaledInstance(100,100,Image.SCALE_SMOOTH);
          JLabel imgLabel = new JLabel(new ImageIcon(changeImg));
          imgLabel.setBounds(100,70,300,200);
          imgLabel.setBorder(brdrLeft);
          // id패널과 pw 패널생성
          idPanel = new JPanel();
          idPanel. setBackground(b);
          imPanel = new JPanel();
          imgB = new JButton("사진선택");
          
          imPanel.add(imgLabel);
          imPanel.add(imgB);
          imgB.addActionListener(this);
          imPanel.setBackground(b);
          add(imPanel);
          paPanel = new JPanel();
          paPanel. setBackground(b);
          pa2Panel = new JPanel();
          pa2Panel. setBackground(b);
          namePanel = new JPanel();
          namePanel. setBackground(b);
          birthPanel = new JPanel();
          birthPanel. setBackground(b);
          sexPanel = new JPanel();
          sexPanel. setBackground(b);
          rcPanel = new JPanel();
          rcPanel. setBackground(b);
         
          idB = new JButton("중복확인");
          la_name = new JLabel("이름*                ");
          id_la = new JLabel("아이디*             ");
          pw_la = new JLabel("비밀번호*          ");
          pw2_la = new JLabel("비밀번호 확인*   ");
          birthLa = new JLabel("생일(YYMMDD)");
          sexLabel = new JLabel("성별                  ");
          rcLabel = new JLabel("RC                   ");
          
          // id텍스트필드와 pw텍스트 필드 선언
          id_field = new JTextField(10);
          id_field.setForeground(c);
          name_field = new JTextField(10);
          name_field.setForeground(c);
          birth_field = new JTextField(10);
          birth_field.setForeground(c);
          passwd = new JPasswordField(10);
          passwd.setForeground(c);
          passwd2 = new JPasswordField(10);
          passwd2.setForeground(c);
          rcComboBox = new JComboBox(ccString);
          
          male = new JCheckBox("남자");
          
          female = new JCheckBox("여자");
          
          namePanel.add(la_name);//name
          namePanel.add(name_field);//name
          
          idPanel.add(id_la);//id
          idPanel.add(id_field);//id
          idPanel.add(idB);//id
          
          paPanel.add( pw_la );//pw
          paPanel.add( passwd );//pw
          
          pa2Panel.add(pw2_la);//re-pw
          pa2Panel.add( passwd2);//re-pw
          
          birthPanel.add(birthLa);
          birthPanel.add(birth_field);
          
          sexPanel.add(sexLabel);
          sexPanel.add(male);
          sexPanel.add(female);
          
          rcPanel.add(rcLabel);
          rcPanel.add(rcComboBox);
          // 로그인과 회원가입을 위한 패널 생성
          
          
          loginPanel = new JPanel();
          submitB = new JButton("제출");
          loginPanel.add( submitB );
          loginPanel. setBackground(b);
          
          add(namePanel);
          add(idPanel);
          add(paPanel);
          add(pa2Panel);
          add(birthPanel);
          add(sexPanel);
          add(rcPanel);
          idB.addActionListener(this);
          submitB.addActionListener(this);
          add(loginPanel);
          setSize( 350, 500 );
          setVisible(true);
          //setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			//생일 형식 안맞으면 경고
			// TODO Auto-generated method stub
			
			if(e.getSource()== submitB) {
				
				String tempRc = rcComboBox.getSelectedItem().toString();
				name = name_field.getText();
				System.out.println(name);
				
				if(id == null) {
					JOptionPane.showMessageDialog(null, "중복 확인해주세요.");
					return;
				}//id
				pw = passwd.getText();
				//System.out.println("pw = "+pw);
				re_pw = passwd2.getText();
				//System.out.println("pw2 = "+re_pw);
				if(!pw.equals(re_pw)) {
					JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요.");
					pw = null;
					return;
				}//pw
				if(name.equals("") || pw==null || pw.equals("")) {
				name = null;
				JOptionPane.showMessageDialog(null, "필수 항목을 입력해주세요.");
				return;
				//null 넣기
			}//name
				
				if(male.isSelected()) {
					if(female.isSelected()) {
						JOptionPane.showMessageDialog(null, "성별을 확인해주세요.");
						return;
					}	//남,여 둘 다 체크한 경우
					else sex = 1;
				}
				else if(female.isSelected()) {
					sex = 2;
				}
				
				//System.out.println("sex = " + sex);
				birth= birth_field.getText();
				if(birth.equals("")) {
					birth = null;
					//null 넣기
				}
				else if(birth.length() != 6) {
					System.out.println(birth.length());
					birth = null;
					JOptionPane.showMessageDialog(null, "생일 형식이 잘못되었습니다.");
					return;
				}
				//System.out.println("name = " + name);
				if(tempRc.equals("선택안함")) rc = null;
				else {
					rc = tempRc;
				}
				System.out.println(name + pw + id);
				
				if(name != null && pw!= null && id != null) {
					TableNameDAO t = new TableNameDAO();
					System.out.println("sda"+fname);
						t.tableInsert(name,pw,id,birth,sex,rc,fname); 
						JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
						 dispose();
						return;
				}
			}
			if(e.getSource()== idB) {
				TableNameDAO a = new TableNameDAO();
				a.tableSelect();
				test_id = id_field.getText();
				if(a.idVector.contains(test_id)) {
					id = null;
					JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다.");
					return;
				}
				else {
					JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
				}
				id = test_id;
			}
			if(e.getSource() == imgB) {
				 returnValue = jfc.showOpenDialog(null);
					if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = jfc.getSelectedFile();
					System.out.println(selectedFile.getAbsolutePath());
					fname = selectedFile.getAbsolutePath();
					try {
 					img = ImageIO.read(new File(selectedFile.getAbsolutePath()));
 				}catch(IOException e1) {
 					JOptionPane.showMessageDialog(null, "Fail");
 				}
					//repaint();
					dispose();
					SignUpPage ne = new SignUpPage(fname);
				} //L
			}
		}
}