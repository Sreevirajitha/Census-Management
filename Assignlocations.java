package Census;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("serial")
public class Assignlocations extends JFrame {
	@SuppressWarnings("rawtypes")
	Assignlocations(){
        setSize(3200,1600);
        
        JLabel J1 = new JLabel("Teacher_ID ");
        J1.setFont(new Font(Font.SERIF, Font.BOLD ,20));
        J1.setBounds(550,100,200,30);
        J1.setVisible(true);
        add(J1);
        setLayout(null);
        
        final JTextField textField1 = new JTextField(30);
        textField1.setBounds(700,100,200,30);
        textField1.setVisible(true);
        add(textField1);
        setVisible(true);
        
        JLabel J2 = new JLabel("Street ");
        J2.setFont(new Font(Font.SERIF, Font.BOLD ,20));
        J2.setBounds(550,150,200,30);
        J2.setVisible(true);
        add(J2);
        setLayout(null);
        
        final JTextField textField2 = new JTextField(30);
	    textField2.setBounds(700,150,200,30);
	    textField2.setVisible(true);
	    add(textField2);
	    setVisible(true);
        
        JLabel J3 = new JLabel("City");
	    J3.setFont(new Font(Font.SERIF, Font.BOLD ,20));
	    J3.setBounds(550,200,200,30);
	    J3.setVisible(true);
	    add(J3);
	    setLayout(null);
	    
	    final JTextField textField3 = new JTextField(30);
	    textField3.setBounds(700,200,200,30);
	    textField3.setVisible(true);
	    add(textField3);
	    setVisible(true);
	    
        JLabel J4 = new JLabel("District ");
	    J4.setFont(new Font(Font.SERIF, Font.BOLD ,20));
	    J4.setBounds(550,250,200,30);
	    J4.setVisible(true);
	    add(J4);
	    setLayout(null);
	    
	    final JTextField textField4 = new JTextField(30);
	    textField4.setBounds(700,250,200,30);
	    textField4.setVisible(true);
	    add(textField4);
	    setVisible(true);
	    
	    JLabel J5 = new JLabel("State ");
	    J5.setFont(new Font(Font.SERIF, Font.BOLD ,20));
	    J5.setBounds(550,300,200,30);
	    J5.setVisible(true);
	    add(J5);
	    setLayout(null);
	    
	    String[] states = {"Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttarakhand","Uttar Pradesh"};
        @SuppressWarnings("unchecked")
		final
		JComboBox cb = new JComboBox(states);
        cb.setBounds(700,300,200,30);
        cb.setVisible(true);
        add(cb);
        setLayout(null);
        
        JLabel J11 = new JLabel("Country ");
	    J11.setFont(new Font(Font.SERIF, Font.BOLD ,20));
	    J11.setBounds(550,350,200,30);
	    J11.setVisible(true);
	    add(J11);
	    setLayout(null);
	    
	    String[] country = {"India"};
        @SuppressWarnings("unchecked")
		final
		JComboBox cb1 = new JComboBox(country);
        cb1.setBounds(700,350,200,30);
        cb1.setVisible(true);
        add(cb1);
        setLayout(null);
	   
	    JLabel J7 = new JLabel("Pincode ");
	    J7.setFont(new Font(Font.SERIF, Font.BOLD ,20));
	    J7.setBounds(550,400,200,30);
	    J7.setVisible(true);
	    add(J7);
	    setLayout(null);
	    
	    final JTextField textField7 = new JTextField(30);
	    textField7.setBounds(700,400,200,30);
	    textField7.setVisible(true);
	    add(textField7);
	    setVisible(true);
	    
	    /*JLabel J8= new JLabel("E-ID ");
	    J8.setFont(new Font(Font.SERIF, Font.BOLD ,20));
	    J8.setBounds(550,450,200,30);
	    J8.setVisible(true);
	    add(J8);
	    setLayout(null);
	    
	    final JTextField textField8 = new JTextField(30);
	    textField8.setBounds(700,450,200,30);
	    textField8.setVisible(true);
	    add(textField8);
	    setVisible(true);*/
	    
	    JButton SaveButton = new JButton("Save Details");
	    SaveButton.setFont(new Font(Font.SERIF, Font.BOLD ,20));
	    SaveButton.setBounds(500, 550, 200, 31);
        add(SaveButton);
        
        final JButton AssigntoTeacher = new JButton("Assign to Teacher");
        AssigntoTeacher.setFont(new Font(Font.SERIF, Font.BOLD ,20));
        AssigntoTeacher.setBounds(780, 550, 200, 33);
        add(AssigntoTeacher);
        
        SaveButton.setForeground(Color.white);
        SaveButton.setBackground(Color.black);
        
        AssigntoTeacher.setForeground(Color.white);
        AssigntoTeacher.setBackground(Color.black);
        
        SaveButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(null,"Are you sure you want to Save details ?","Warning",JOptionPane.QUESTION_MESSAGE);
        		
        	}
        });
        
        AssigntoTeacher.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        		if(e.getSource() == AssigntoTeacher) {
        		Connection connect = ConnectDB.getConnection();
     		   
        		try {
        		Statement st = connect.createStatement();
        		String sql = "insert into LOCATION_ASSIGNED (employee_id ,street ,city ,district ,state ,country ,pincode) values('"+textField1.getText()+"','"+textField2.getText()+"','"+textField3.getText()+"','"+textField4.getText()+"','"+cb.getSelectedItem()+"','"+cb1.getSelectedItem()+"','"+textField7.getText()+"')";
        		st.execute(sql);

        		} catch (SQLException e1) {
        		// TODO Auto-generated catch block
        				e1.printStackTrace();
        				}
        			JOptionPane.showMessageDialog(null,"Assigned Location Successfully");
        			}
        	}
       });
        
        /*(employee_id ,street ,city ,district ,state ,country ,pincode) Icon icon = new ImageIcon("C:\\Users\\SREE VIRAJITHA\\Downloads\\Census-Duty-Management-main\\Grp-17 CensusDuty Management System\\back arrow.jpeg");*/
        JButton backButton = new JButton("BACK");
        
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
        
        ImageIcon bg = new ImageIcon("C:\\Users\\SREE VIRAJITHA\\Downloads\\Census-Duty-Management-main\\Background images\\emblem.png");
        Image i = bg.getImage();
        Image tem_img = i.getScaledInstance(150, 120, Image.SCALE_SMOOTH);
        bg = new ImageIcon(tem_img);
        JLabel background1 = new JLabel("", bg, JLabel.CENTER);
        background1.setBounds(10, 20, 120, 120);
        
        /*ImageIcon bg1 = new ImageIcon("C:\\Users\\dell\\Dropbox\\My PC (DESKTOP-EJPRT30)\\Downloads\\sw.png");
        Image i1 = bg1.getImage();
        Image tem_img2 = i1.getScaledInstance(400, 130, Image.SCALE_SMOOTH);
        bg = new ImageIcon(tem_img);
        JLabel background2 = new JLabel("", bg1, JLabel.CENTER);
        background2.setBounds(1110, 5, 480, 152);*/
        
        
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
		Assignlocations obj = new Assignlocations();
	}

}
