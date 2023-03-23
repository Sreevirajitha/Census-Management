package Census;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class login extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	login() {
    	final JTextField textField1;
    	
        JLabel l = new JLabel("");
        l.setBounds(80, 10, 1200, 100);
        l.setFont(new Font(Font.SERIF, Font.BOLD, 62));
        
        JPanel p = new JPanel();
        p.setBounds(550, 240, 446, 340);
        p.setBackground(new Color(255,255,255,200));
        p.setLayout(null);
        
        JLabel s = new JLabel("Sign In");
        s.setBounds(160, 0, 200, 50);
        s.setFont(new Font(Font.SERIF, Font.BOLD, 34));
        s.setForeground(Color.black);
        s.setVisible(true);
        
        JLabel b1 = new JLabel("Username:");
        b1.setBounds(20, 30, 200, 100);
        b1.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        b1.setVisible(true);
        
        textField1 = new JTextField(30);
        textField1.setBounds(140, 68, 200, 30);
        
        JLabel b2 = new JLabel("Password:");
        b2.setBounds(20, 80, 200, 100);
        b2.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        b2.setVisible(true);
        
        final JPasswordField value = new JPasswordField();
        value.setBounds(140, 120, 200, 30);
        
        final JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(100, 220, 100, 38);
        p.add(loginButton);
        
        final JButton resetButton = new JButton("RESET");
        resetButton.setBounds(250,220, 100, 38);
        p.add(resetButton);
        
        final JCheckBox b = new JCheckBox("Show Password");
        b.setBounds(140, 170, 200, 30);
        b.setFont(new Font(Font.SERIF, Font.BOLD, 18));
        value.setEchoChar('•');
        
        JLabel l1=new JLabel("CENSUS DUTY MANAGEMENT SYSTEM");
		l1.setBounds(190,20,1200,100);
		l1.setForeground(Color.white);
		l1.setFont(new Font(Font.SERIF, Font.BOLD,  59));
		
		//background
				ImageIcon bg = new ImageIcon("");
		        Image i = bg.getImage();
		        Image tem_img = i.getScaledInstance(150, 120, Image.SCALE_SMOOTH);
		        bg = new ImageIcon(tem_img);
		        JLabel background1 = new JLabel("", bg, JLabel.CENTER);
		        background1.setBounds(10, 20, 120, 120);
		        
		        bg = new ImageIcon(tem_img);
		        JLabel background2 = new JLabel("", bg, JLabel.CENTER);
		        background2.setBounds(1270, 5, 350, 150);

		        ImageIcon background_image = new ImageIcon("C:\\Users\\VEMU ABHINAV\\Downloads\\Census-Duty-Management-main\\Grp-17 CensusDuty Management System\\wallhaven-43pov6_1920x1080.png");
		        Image img = background_image.getImage();
		        Image temp_img = img.getScaledInstance(1535, 850, Image.SCALE_SMOOTH);
		        background_image = new ImageIcon(temp_img);
		        JLabel background = new JLabel("", background_image, JLabel.LEFT);
		        background.setBounds(0, 0, 1600, 1200);
		        
        
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(b.isSelected()) {
                    value.setEchoChar((char)0);
                }else {
                    value.setEchoChar('•');
                }

            }
        });
        
        resetButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if 	(e.getSource() == resetButton) {
            			textField1.setText("");
            			value.setText("");
            	}
        	}
        });
        
        loginButton.addActionListener(new ActionListener() {
    
            public void actionPerformed(ActionEvent e) {
            	
                if(loginButton.isValid()){
                	Connection connect = ConnectDB.getConnection();
            		   
                	try {
        	        	String username = textField1.getText();
						@SuppressWarnings("deprecation")
						String password = value.getText();
        	        	
        	        	Statement stm = connect.createStatement();
        	        	
        	        	String sql = "select * from login where username = '"+username+"' and password= '"+password+"'";
        	        	ResultSet rs = stm.executeQuery(sql);
        	        	
        	        	if(rs.next()) {
        	        		dispose();
        	        		if(username.startsWith("T")) {
        	        			//jb.show();
        	        			new Teacher().setVisible(true);
        	        		}
        	        		else if (username.startsWith("A")) {
        	        			new Admin().setVisible(true);
        	        			
        	        		}
        	        		else if (username.startsWith("U")){
        	        			new User().setVisible(true);
        	        		}
        	        		
                            
        	        	}else {
        	        		JOptionPane.showMessageDialog(null,"Invalid username or password","Alert",JOptionPane.WARNING_MESSAGE);
        	        		textField1.setText("");
        	        		value.setText("");
        	        	}
        	        	
                	}catch(Exception a){
                		System.out.println(a.getMessage());
                		
                	}
                	
                }
            }
        });
        setSize(1600, 1200);
        add(p);
        add(l);
        add(l1);
       add(background2);
        add(background1);
        
        add(background);
        p.add(s);
        p.add(b1);
        p.add(b2);
        p.add(textField1);
        p.add(value);
        
        p.add(b);
        setVisible(true);
        setLayout(null);
     }
}

public class CENSUS {

    public static void main(String[] args) {
        new login();
        
        // TODO Auto-generated method stub

    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		new login();
	}

}
