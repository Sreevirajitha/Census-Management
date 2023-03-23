package Census;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTeachers extends JFrame {
    AddTeachers(){
        setSize(3200,1600);
        
        JLabel J1 = new JLabel("Teacher_ID ");
        J1.setFont(new Font(Font.SERIF, Font.BOLD ,20));
        J1.setBounds(550,150,200,30);
        J1.setVisible(true);
        add(J1);
        setLayout(null);
        
        final JTextField textField1 = new JTextField(30);
        textField1.setBounds(700,150,200,30);
        textField1.setVisible(true);
        add(textField1);
        setVisible(true);
        
        JLabel J2 = new JLabel("Name ");
        J2.setFont(new Font(Font.SERIF, Font.BOLD ,20));
        J2.setBounds(550,250,200,30);
        J2.setVisible(true);
        add(J2);
        setLayout(null);
        
        final JTextField textField2 = new JTextField(30);
        textField2.setBounds(700,250,200,30);
        textField2.setVisible(true);
        add(textField2);
        setVisible(true);
        
        /*JLabel J3 = new JLabel("LastName ");
        J3.setFont(new Font(Font.SERIF, Font.BOLD ,20));
        J3.setBounds(550,250,200,30);
        J3.setVisible(true);
        add(J3);
        setLayout(null);
        
        final JTextField textField3 = new JTextField(30);
        textField3.setBounds(700,250,200,30);
        textField3.setVisible(true);
        add(textField3);
        setVisible(true);*/
        
        JLabel J4 = new JLabel("Designation ");
        J4.setFont(new Font(Font.SERIF, Font.BOLD ,20));
        J4.setBounds(550,300,200,30);
        J4.setVisible(true);
        add(J4);
        setLayout(null);
        
        final JTextField textField4 = new JTextField(30);
        textField4.setBounds(700,300,200,30);
        textField4.setVisible(true);
        add(textField4);
        setVisible(true);
        
        JLabel J5 = new JLabel("Dept_id ");
        J5.setFont(new Font(Font.SERIF, Font.BOLD ,20));
        J5.setBounds(550,350,200,30);
        J5.setVisible(true);
        add(J5);
        setLayout(null);
        
        final JTextField textField5 = new JTextField(30);
        textField5.setBounds(700,350,200,30);
        textField5.setVisible(true);
        add(textField5);
        setVisible(true);
        
        JLabel J6 = new JLabel("Salary ");
        J6.setFont(new Font(Font.SERIF, Font.BOLD ,20));
        J6.setBounds(550,400,200,30);
        J6.setVisible(true);
        add(J6);
        setLayout(null);
        
        final JTextField textField6 = new JTextField(30);
        textField6.setBounds(700,400,200,30);
        textField6.setVisible(true);
        add(textField6);
        setVisible(true);
        
        JLabel J7 = new JLabel("Position ");
        J7.setFont(new Font(Font.SERIF, Font.BOLD ,20));
        J7.setBounds(550,450,200,30);
        J7.setVisible(true);
        add(J7);
        setLayout(null);
        
        final JTextField textField7 = new JTextField(30);
        textField7.setBounds(700,450,200,30);
        textField7.setVisible(true);
        add(textField7);
        setVisible(true);
        
       /* JLabel J8 = new JLabel("Location_Assg ");
        J8.setFont(new Font(Font.SERIF, Font.BOLD ,20));
        J8.setBounds(550,500,200,30);
        J8.setVisible(true);
        add(J8);
        setLayout(null);
        
        final JTextField textField8 = new JTextField(30);
        textField8.setBounds(700,500,200,30);
        textField8.setVisible(true);
        add(textField8);
        setVisible(true);*/
        
        JCheckBox b = new JCheckBox("ConfirmDetails");
        b.setBounds(700, 590, 200, 30);
        b.setVisible(true);
        add(b);
        
        final JButton add = new JButton("AddTeacher");
        add.setBounds(650, 640, 200, 30);
        add(add);
        add.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (e.getSource() == add){
        			Connection connect = ConnectDB.getConnection();
        		   
        				try {
							Statement st = connect.createStatement();
							String sql = "insert into TEACHER (TEACHER_ID,Name,DESIGNATION,DEPT_ID,SALARY,POSITION) values('"+textField1.getText()+"','"+textField2.getText()+"','"+textField4.getText()+"','"+textField5.getText()+"','"+textField6.getText()+"','"+textField7.getText()+/**/"')";
							st.execute(sql);
							String sql1 = "insert into login (username,password) values('"+textField2.getText()+"','"+textField1.getText()+"')";
							st.execute(sql1);
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        				JOptionPane.showMessageDialog(null,"Teacher Added Successfully");        			
        		}
        	}
        });
        
        /*Icon icon = new ImageIcon("C:\\Users\\VEMU ABHINAV\\Downloads\\Census-Duty-Management-main\\Grp-17 CensusDuty Management System\\back arrow.jpeg");*/
        JButton backButton = new JButton("Back");
        
        backButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		new Admin().setVisible(true);
        		dispose();
        	}
        });
        backButton.setBounds(35,150,100,40);
        add(backButton);
        backButton.setBackground(Color.white);
        /*backButton.setOpaque(false);*/
      
        	//background
      		ImageIcon bg = new ImageIcon("C:\\Users\\VEMU ABHINAV\\Downloads\\Census-Duty-Management-main\\Background images\\emblem.png");
              Image i = bg.getImage();
              Image tem_img = i.getScaledInstance(150, 120, Image.SCALE_SMOOTH);
              bg = new ImageIcon(tem_img);
              JLabel background1 = new JLabel("", bg, JLabel.CENTER);
              background1.setBounds(10, 20, 120, 120);
              
             /* ImageIcon bg1 = new ImageIcon("C:\\Users\\dell\\Dropbox\\My PC (DESKTOP-EJPRT30)\\Downloads\\sw.png");
              Image i1 = bg1.getImage();
              bg = new ImageIcon(tem_img);
              JLabel background2 = new JLabel("", bg1, JLabel.CENTER);
              background2.setBounds(1110, 5, 480, 152);*/
              
              
              ImageIcon background_image = new ImageIcon("C:\\Users\\VEMU ABHINAV\\Downloads\\Census-Duty-Management-main\\Grp-17 CensusDuty Management System\\white_bg.png");
              Image img = background_image.getImage();
              Image temp_img = img.getScaledInstance(1920,1080, Image.SCALE_SMOOTH);
              background_image = new ImageIcon(temp_img);
              JLabel background = new JLabel("", background_image, JLabel.CENTER);
              background.setBounds(0, 0,1920,800);
              
              /*add(background2);*/
              add(background1);
              add(background);

              add.setForeground(Color.white);
              add.setBackground(Color.black);
              /*backButton.setBorderPainted(false);*/
              
    }
public static void main(String args[]){
        AddTeachers obj = new AddTeachers();
    
        }
    }
