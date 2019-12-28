import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class ManagerPage2 extends JFrame  implements ActionListener{
    JLabel id_la, rcLabel,lbl;
    JPanel tablepanel = new JPanel();
    JPanel Menupanel = new JPanel();
    JTable table;
    JScrollPane scroll;
    String [] title = {"아이디", "이름", "비밀 번호","생일","성별","RC"};
    Object data [][];
    DefaultTableModel model;
    
    JLabel idla, benLabel;
    JTextField id_field,benfield;
    JButton benB,idB,reB;
    clientPage c;
    String id,ben;
    
    
    public ManagerPage2() {
        super( "Manager" );
        // FlowLayout사용
		TableNameDAO a = new TableNameDAO();
		model = new DefaultTableModel(title,0){ 
	    	public boolean isCellEditable(int i, int c){ 
	    		return false; 
	    		} 
	    	};
		a.tableSelect();
        setLocation(500,300);

        idla = new JLabel("회원 정보 수정");
        benLabel = new JLabel("회원 강제 탈퇴  ");
        id_field = new JTextField(10);
        benfield = new JTextField(10);
        idB =new JButton("검색");
        benB = new JButton("탈퇴");
        reB = new JButton("새로고침");
        idB.addActionListener(this);
        benB.addActionListener(this);
        reB.addActionListener(this);
        setLayout( new FlowLayout());

        tablepanel.setSize(600,300);
        
        // Border로 영역 생성
        EtchedBorder eborder =  new EtchedBorder();
        lbl = new JLabel( "회원명단" );
        // 레이블에 영역 만들기
        lbl.setBorder(eborder);
        // 레이블 추가
        add( lbl );
        data = new String [a.Clientlist.size()][6];
        for(int i =0;i<a.Clientlist.size();i++) {
        	data[i][0] = a.Clientlist.get(i).getId();
        	data[i][1] = a.Clientlist.get(i).getName();
        	data[i][2] = a.Clientlist.get(i).getPw();
        	data[i][3] = a.Clientlist.get(i).getBirth();
        	if(a.Clientlist.get(i).getSex()==0)
        		data[i][4] = null;
        	else if(a.Clientlist.get(i).getSex()==1)
        		data[i][4] = "남자";
        	else
        		data[i][4] = "여자";
        	data[i][5] =a.Clientlist.get(i).getRc();
        	System.out.println("id"+a.Clientlist.get(i).getId());
            model.addRow(data[i]);
        }
   
        //table = new JTable(data,title);
        table = new JTable(model);
        scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(500,250));
       // scroll.setSize(400, 200);
        tablepanel.add(scroll,BorderLayout.CENTER);
        Menupanel.add(idla);
        Menupanel.add(id_field);
        Menupanel.add(idB);
        Menupanel.add(benLabel);
        Menupanel.add(benfield);
        Menupanel.add(benB);
        Menupanel.add(reB);
        add(tablepanel);
        add(Menupanel);
        pack();
        setSize( 700, 400 );
        setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== idB) {
			TableNameDAO a = new TableNameDAO();
			a.tableSelect();
			int count = 0;
				id = id_field.getText();
				for(TableName A: a.Clientlist) {
					if(A.getId().equals(id)) {
						break;
					}//id가 존재
					count ++;
				}
				c = new clientPage(id,count);
			}
			//내 정보 띄우는 창 + 수정까지 만들기 
			else if(e.getSource()== benB){
				ben = benfield.getText();
				if(ben.equals("manager")) {
					JOptionPane.showMessageDialog(null, "관리자는 탈퇴가 불가능합니다.");
					return;
				}
				TableNameDAO a = new TableNameDAO();
				a.tableDelete(ben);
				int result = JOptionPane.showConfirmDialog(null,"정말 탈퇴시키겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
				if(result ==JOptionPane.YES_OPTION ) {
					a.tableDelete(id);
					JOptionPane.showMessageDialog(null, "탈퇴되었습니다.");
					dispose();
					ManagerPage2 an = new ManagerPage2();
				}
			    
			}//탈퇴 class 만들기
			else if(e.getSource() == reB) {
				dispose();
				ManagerPage2 an = new ManagerPage2();
		}
	}

}
