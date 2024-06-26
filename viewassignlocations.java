package Census;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class viewassignlocations extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	viewassignlocations(){
        setSize(3200,1600);
        
        JLabel J1 = new JLabel("Teacher_ID ");
        J1.setFont(new Font(Font.SERIF, Font.BOLD ,25));
        J1.setBounds(550,300,200,30);
        J1.setVisible(true);
        add(J1);
        setLayout(null);
        
        final JTextField textField1 = new JTextField(30);
        textField1.setBounds(700,300,200,30);
        textField1.setVisible(true);
        add(textField1);
        setVisible(true);
        
        JButton view = new JButton("View");
        view.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		Connection connect = ConnectDB.getConnection();
        		PreparedStatement p;
        		String teacher_id = textField1.getText(); 
        		if (teacher_id.equals("")){
        	        JOptionPane.showMessageDialog(null, "Please enter teacher_id ");
        	    }
        		else{
        			try {
        		
        		String sql = "select* from location_assigned where EMPLOYEE_ID =  '"+teacher_id+"';";
        		p = connect.prepareStatement(sql);
        		ResultSet rs = p.executeQuery(); 
        		rs.next();
        		JOptionPane.showMessageDialog(null,rs.getString("street"), "LOCATION_ASSIGNED", JOptionPane.INFORMATION_MESSAGE);
        		JOptionPane.showMessageDialog(null,rs.getString("city"), "LOCATION_ASSIGNED", JOptionPane.INFORMATION_MESSAGE);
        		JOptionPane.showMessageDialog(null,rs.getString("district"), "LOCATION_ASSIGNED", JOptionPane.INFORMATION_MESSAGE);
        		JOptionPane.showMessageDialog(null,rs.getString("state"), "LOCATION_ASSIGNED", JOptionPane.INFORMATION_MESSAGE);
        		JOptionPane.showMessageDialog(null,rs.getString("country"), "LOCATION_ASSIGNED", JOptionPane.INFORMATION_MESSAGE);
        		}

        		catch (Exception f) { 
        		System.out.println(f.getMessage());
        	}
        }
      }
   });
        view.setBounds(710,385,150,40);
        add(view);
        view.setForeground(Color.white);
        view.setBackground(Color.black);
        
        JButton backButton = new JButton("BACK");
        
        backButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		new Teacher().setVisible(true);
        		dispose();
        	}
        });
        backButton.setBounds(35,150,100,40);
        add(backButton);
        backButton.setBackground(Color.white);
        /*backButton.setOpaque(false);*/
        
        ImageIcon bg = new ImageIcon("C:\\Users\\SREE VIRAJITHA\\Downloads\\Census-Duty-Management-main\\Background images\\emblem.png");
        Image i = bg.getImage();
        Image tem_img = i.getScaledInstance(150, 120, Image.SCALE_SMOOTH);
        bg = new ImageIcon(tem_img);
        JLabel background1 = new JLabel("", bg, JLabel.CENTER);
        background1.setBounds(10, 20, 120, 120);
        
        /*ImageIcon bg1 = new ImageIcon("C:\\\\Users\\\\dell\\\\Dropbox\\\\My PC (DESKTOP-EJPRT30)\\\\Downloads\\\\sw.png");
        Image i1 = bg1.getImage();
        Image tem_img2 = i1.getScaledInstance(400, 130, Image.SCALE_SMOOTH);
        bg = new ImageIcon(tem_img);
        JLabel background2 = new JLabel("", bg1, JLabel.CENTER);
        background2.setBounds(1120, 5, 480, 152);*/
        
        
        ImageIcon background_image = new ImageIcon("C:\\Users\\SREE VIRAJITHA\\Downloads\\Census-Duty-Management-main\\Grp-17 CensusDuty Management System\\white_bg.png");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1920,1080, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0,1920,800);
        
        /*add(background2);*/
        add(background1);
        add(background);
        backButton.setBorderPainted(false);
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		viewassignlocations obj = new viewassignlocations();
	}

}
