import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.border.*;
 
 
public class clientPage extends JFrame implements ActionListener
{
    JLabel lbl,la1,pw_la,pw2_la,id_la,la_name;
    JLabel birthLa,sexLabel,rcLabel;
    JTextField id_field,name_field,birth_field;
    JPasswordField passwd,passwd2;
    JPanel namePanel,idPanel,paPanel,pa2Panel,loginPanel;
    JPanel birthPanel, sexPanel,rcPanel,imPanel;
    JButton submitB,idB,cancelB,imgB;
    JLabel content;
    JCheckBox male,female;
    
    String fname;
    Image img;
    
    String id;
    String[] ccString = {"선택안함","손양원","열송학사", "장기려", "카이퍼", "카마이클","토레이"};
    JComboBox rcComboBox;
    TableName user;
	private String test_id;
	//Vector<String> confirm = new Vector<String>();
    String repw_confirm;
	String name_confirm, pw_confirm, id_confirm = null, birth_confirm = null, rc_confirm = null;
	int sex_confirm = 0;
	int count;
   
    public clientPage(String id,int count)
    {
          super( "clientPage" );
          setLocation(500,300);
          Color b=new Color(250, 218, 16); 
          Color c=new Color(63, 36, 29);
          getContentPane().setBackground(b);
          this.id = id;
          this.count = count;
          TableNameDAO a = new TableNameDAO();
          a.tableSelect();
          user = a.Clientlist.get(count);
          System.out.println(user.id.toString() + user.name.toString());
          // FlowLayout사용
          setLayout( new FlowLayout(FlowLayout.LEFT));
          // Border로 영역 생성
          EtchedBorder eborder =  new EtchedBorder();
          // 레이블 생성     
          lbl = new JLabel( "                     회원정보                    " );
          // 레이블에 영역 만들기
          lbl.setBorder(eborder);
          // 레이블 추가
          add( lbl );
          fname = a.Clientlist.get(count).getFname();
          System.out.println(fname);
          imPanel = new JPanel();
          
          try {
        	  File source = new File(fname);
        	  img = ImageIO.read(source);   	  
          }catch(IOException e) {
          }
          AbstractBorder brdrLeft = new TextBubbleBorder(Color.BLACK,2,8,16);
          Image changeImg = img.getScaledInstance(100,100,Image.SCALE_SMOOTH);
          JLabel imgLabel = new JLabel(new ImageIcon(changeImg));
          imgLabel.setBorder(brdrLeft);
          imgB = new JButton("사진선택");
          imPanel.setBackground(b);
          imPanel.add(imgLabel);
          imPanel.add(imgB);
          imgB.addActionListener(this);
          add(imPanel);
          
          // id패널과 pw 패널생성
          idPanel = new JPanel();
          idPanel. setBackground(b);
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
          la_name = new JLabel("이름                ");
          id_la = new JLabel("아이디             ");
          pw_la = new JLabel("비밀번호          ");
          pw2_la = new JLabel("비밀번호 확인   ");
          birthLa = new JLabel("생일(YYMMDD)");
          sexLabel = new JLabel("성별                  ");
          rcLabel = new JLabel("RC                   ");
          
          // id텍스트필드와 pw텍스트 필드 선언
          id_field = new JTextField(user.id.toString(),10);
          id_field.setForeground(c);
          name_field = new JTextField(user.name.toString(),10);
          name_field.setForeground(c);
          if(a.Clientlist.get(count).getBirth()!= null)
        	  birth_field = new JTextField(a.Clientlist.get(count).getBirth(),10);
          else  birth_field = new JTextField(10);
          birth_field.setForeground(c);
          passwd = new JPasswordField(user.pw.toString(),10);
      
          passwd.setForeground(c);
          passwd2 = new JPasswordField(10);
          passwd2.setForeground(c);
          rcComboBox = new JComboBox(ccString);
          
       //   rcComboBox.setSelectedIndex(3);
          //System.out.println(a.Clientlist.get(count).getRc());
          if(a.Clientlist.get(count).getRc()!= null)
        	  rcComboBox.setSelectedItem(a.Clientlist.get(count).getRc());
          
          if(a.Clientlist.get(count).getSex() == 1) {
        	  male = new JCheckBox("남자",true);
          }
          else {
        	  male = new JCheckBox("남자");
          }
          if(a.Clientlist.get(count).getSex() == 2) {
        	  female = new JCheckBox("여자",true);
          }
          else {
        	  female = new JCheckBox("여자");
          }
        	 
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

          cancelB = new JButton("취소");
          submitB = new JButton("수정");
          loginPanel.add( submitB );
          loginPanel.add(cancelB);
          loginPanel. setBackground(b);
          add(namePanel);
          add(idPanel);
          add(paPanel);
          add(pa2Panel);
          add(birthPanel);
          add(sexPanel);
          add(rcPanel);
          add(loginPanel);
          content = new JLabel();
          
          idB.addActionListener(this);
          submitB.addActionListener(this);
          cancelB.addActionListener(this);
          
          JScrollPane s= new JScrollPane(content);
          add(s);
          setSize( 350,  500 );
          setVisible(true);
          //setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    // JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== submitB) {
			 TableNameDAO a = new TableNameDAO();
	          a.tableSelect();
			if(id_confirm == null) {
				JOptionPane.showMessageDialog(null, "중복 확인해주세요.");
				return;
			} //id
			name_confirm = name_field.getText(); //name
			pw_confirm = passwd.getText();
			//System.out.println("pw = "+pw);
			repw_confirm = passwd2.getText();
			//System.out.println("pw2 = "+re_pw);
			if(!pw_confirm.equals(repw_confirm)) {
				JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요.");
				pw_confirm = null;
				return;
			}//pw
			String tempRc = rcComboBox.getSelectedItem().toString();
			if(male.isSelected()) {
				if(female.isSelected()) {
					JOptionPane.showMessageDialog(null, "성별을 확인해주세요.");
					return;
				}	//남,여 둘 다 체크한 경우
				else sex_confirm = 1;
			}
			else if(female.isSelected()) {
				sex_confirm = 2;
			}
			else {
				sex_confirm = 0;
			}
			birth_confirm= birth_field.getText();
			if(birth_confirm.equals("")) {
				birth_confirm = null;
				//null 넣기
			}
			else if(birth_confirm.length() != 6) {
				//System.out.println(birth_confirm.length());
				birth_confirm = null;
				JOptionPane.showMessageDialog(null, "생일 형식이 잘못되었습니다.");
				return;
			}
			if(tempRc.equals("선택안함")) rc_confirm = null;
			else {
				rc_confirm = tempRc;
			}		
			if(!name_confirm.equals(a.Clientlist.get(count).getName())){
				 a.tableUpdate(id,0,name_confirm);
			}
			if(!pw_confirm.equals(a.Clientlist.get(count).getPw())){
				 a.tableUpdate(id,1,pw_confirm);
			}
			if(!id_confirm.equals(a.Clientlist.get(count).getId())){
				 a.tableUpdate(id,2,id_confirm);
			}
			System.out.println(birth_confirm);
			System.out.println(a.Clientlist.get(count).getBirth());
			if(birth_confirm == null) a.tableUpdate(id,3,null);
			else if(!birth_confirm.equals(a.Clientlist.get(count).getBirth())){
				 a.tableUpdate(id,3,birth_confirm);
			}
//			System.out.println(rc_confirm);
//			System.out.println(a.Clientlist.get(count).getRc());
			if(rc_confirm == null) a.tableUpdate(id,4,null);
			else if(!rc_confirm.equals(a.Clientlist.get(count).getRc())){
				 a.tableUpdate(id,4,rc_confirm);
			}
			if(a.Clientlist.get(count).getSex()!= sex_confirm) {
				a.tableUpdate(id,sex_confirm);
			}
			JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.");
			
		}
		//내 정보 띄우는 창 + 수정까지 만들기 
		//안보이게 하고 창 띄우기
		//수정되습니다.
		
		else if(e.getSource()== idB){
			TableNameDAO a = new TableNameDAO();
			a.tableSelect();
			test_id = id_field.getText();
			if(a.idVector.contains(test_id)&&!user.id.toString().equals(test_id)) {
				JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다.");
				id_confirm = null;
				return;
			}//목록에 있고 자신의 아이디도 아닐 때,
			else {
				JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
			}
			id_confirm = test_id;
		}
		else if(e.getSource() == cancelB) {
			 dispose();
		}
		
	}
}

class TextBubbleBorder extends AbstractBorder {

    private Color color;
    private int thickness = 4;
    private int radii = 8;
    private int pointerSize = 7;
    private Insets insets = null;
    private BasicStroke stroke = null;
    private int strokePad;
    private int pointerPad = 4;
    private boolean left = true;
    RenderingHints hints;

    TextBubbleBorder(
            Color color) {
        this(color, 4, 8, 7);
    }

    TextBubbleBorder(
            Color color, int thickness, int radii, int pointerSize) {
        this.thickness = thickness;
        this.radii = radii;
        this.pointerSize = pointerSize;
        this.color = color;

        stroke = new BasicStroke(thickness);
        strokePad = thickness / 2;

        hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int pad = radii + strokePad;
        int bottomPad = pad + pointerSize + strokePad;
        insets = new Insets(pad, pad, bottomPad, pad);
    }

    TextBubbleBorder(
            Color color, int thickness, int radii, int pointerSize, boolean left) {
        this(color, thickness, radii, pointerSize);
        this.left = left;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return insets;
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        return getBorderInsets(c);
    }

    @Override
    public void paintBorder(
            Component c,
            Graphics g,
            int x, int y,
            int width, int height) {

        Graphics2D g2 = (Graphics2D) g;

        int bottomLineY = height - thickness - pointerSize;

        RoundRectangle2D.Double bubble = new RoundRectangle2D.Double(
                0 + strokePad,
                0 + strokePad,
                width - thickness,
                bottomLineY,
                radii,
                radii);

        Polygon pointer = new Polygon();

        if (left) {
            // left point
            pointer.addPoint(
                    strokePad + radii + pointerPad,
                    bottomLineY);
            // right point
            pointer.addPoint(
                    strokePad + radii + pointerPad + pointerSize,
                    bottomLineY);
            // bottom point
            pointer.addPoint(
                    strokePad + radii + pointerPad + (pointerSize / 2),
                    height - strokePad);
        } else {
            // left point
            pointer.addPoint(
                    width - (strokePad + radii + pointerPad),
                    bottomLineY);
            // right point
            pointer.addPoint(
                    width - (strokePad + radii + pointerPad + pointerSize),
                    bottomLineY);
            // bottom point
            pointer.addPoint(
                    width - (strokePad + radii + pointerPad + (pointerSize / 2)),
                    height - strokePad);
        }

        Area area = new Area(bubble);
        area.add(new Area(pointer));

        g2.setRenderingHints(hints);

        // Paint the BG color of the parent, everywhere outside the clip
        // of the text bubble.
        Component parent  = c.getParent();
        if (parent!=null) {
            Color bg = parent.getBackground();
            Rectangle rect = new Rectangle(0,0,width, height);
            Area borderRegion = new Area(rect);
            borderRegion.subtract(area);
            g2.setClip(borderRegion);
            g2.setColor(bg);
            g2.fillRect(0, 0, width, height);
            g2.setClip(null);
        }

        g2.setColor(color);
        g2.setStroke(stroke);
        g2.draw(area);
    }
}