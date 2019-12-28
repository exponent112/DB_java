
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.*;
 
public class mainPage extends JFrame implements ActionListener
{
    JLabel lbl;
    JPanel idPanel,paPanel;
    JButton b1,b2,b3;
    clientPage c ;
    String id = null;
    int count;
    LoginPage login;
 
    public mainPage(String id,int count)
    {
          super( "mainPage" );
          this.id = id;
          this.count = count;
          
         
          Color b=new Color(63, 36, 29);
          getContentPane().setBackground(b);
          setLocation(500,300);
          System.out.println(count);
          // FlowLayout사용
          setLayout( new FlowLayout() );
          // Border로 영역 생성
          EtchedBorder eborder =  new EtchedBorder();
          // 레이블 생성     
          lbl = new JLabel( "       원하시는 행동을 골라주세요.     " );
          lbl.setForeground(Color.WHITE);
          Color c=new Color(63, 36, 29);
          
          // 레이블에 영역 만들기
          lbl.setBorder(eborder);
          // 레이블 추가
          add( lbl );
          // id패널과 pw 패널생성
          idPanel = new JPanel();
          idPanel. setBackground(b);
          paPanel = new JPanel();
          paPanel. setBackground(b);
          b1 = new JButton("내 정보 확인/수정");
          b2 = new JButton("회원탈퇴");
          b3 = new JButton("로그아웃");
          
          b1.addActionListener(this);
          b2.addActionListener(this);
          b3.addActionListener(this);
          
          idPanel.add(b1);
          paPanel.add(b2);
          paPanel.add(b3);
          // 로그인과 회원가입을 위한 패널 생성
          add(idPanel);
          add(paPanel);
          setSize( 350, 400);
          setVisible(true);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== b1) {
			System.out.println(id + count);
			c = new clientPage(id,count);
		}
		//내 정보 띄우는 창 + 수정까지 만들기
		else if(e.getSource()== b2){
			TableNameDAO a = new TableNameDAO();
			int result = JOptionPane.showConfirmDialog(null,"정말 탈퇴하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
			if(result ==JOptionPane.YES_OPTION ) {
				a.tableDelete(id);
				JOptionPane.showMessageDialog(null, "탈퇴되었습니다.");
				dispose();
				login = new LoginPage();
			}
		}
		else if(e.getSource()== b3){
			LoginPage login = new LoginPage();
			dispose();
		}
	}
	
}