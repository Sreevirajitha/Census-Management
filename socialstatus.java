package Census;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.JTableHeader;
class socialst extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	socialst()
	{
		try {
			Connection conn = ConnectDB.getConnection();
			String houseno = JOptionPane.showInputDialog("P_id ");
			String userentry=houseno;
			
		     
			String query = "SELECT p_id FROM social_status where p_id='"+houseno+"';";
		  
		      Statement stm = conn.createStatement();
		      ResultSet res = stm.executeQuery(query);
		      if (res.next()) {
		      String house= res.getString("P_id");
		      
		      
			    if (house.equalsIgnoreCase(userentry))
			    {
			    	String q = "SELECT count(p_id) FROM social_status where p_id='"+houseno+"';";
					  
				      Statement st = conn.createStatement();
				      ResultSet r = st.executeQuery(q);
				      int row = 0;
				      if (r.next()) {
					      String rows= r.getString("count");
					      row=Integer.parseInt(rows);  
					      }
				     
				      
			    	String query1 = "SELECT * FROM social_status where p_id='"+userentry+"';";
					  
				      Statement stm1 = conn.createStatement();
				      ResultSet res1 = stm1.executeQuery(query1);
			    	
				      String columns[] = {"P_ID", "RELIGION", "STATUS","INCOME"};
	   			      
   			          String data[][] = new String[row][4];
   			          int i = 0;
   			     
   			           while (res1.next()) {
   			  
   			              String P_ID= res1.getString("P_ID");
   			              String RELIGION = res1.getString("RELIGION");
   			              String STATUS = res1.getString("STATUS");  			            
   			              String INCOME = res1.getString("INCOME");
   			        
   			        
   			              data[i][0] = P_ID + "" ;
   			              data[i][1] = RELIGION ;
   			              data[i][2] = STATUS ; 			          
   			              data[i][3] = INCOME ;
   			        
   			              i++;
   			      }
   			      
   			      DefaultTableModel model = new DefaultTableModel(data, columns);
   			      JTable table = new JTable(model);
   			      table.setBounds(500,10,1600,1200);
   			      table.setRowHeight(40);
   			      
   			      table.getColumnModel().getColumn(0).setPreferredWidth(35);
   			      table.getColumnModel().getColumn(1).setPreferredWidth(100);
   			      table.getColumnModel().getColumn(2).setPreferredWidth(35);
   			      table.getColumnModel().getColumn(3).setPreferredWidth(38);
   			      
   			
   			      
   			      table.setShowGrid(true);
   			      table.setShowVerticalLines(true);
			      
			      JScrollPane pane = new JScrollPane(table);
			      //JPanel panel = new JPanel();
			      //panel.setBounds(0,0,1600,1200);
			      //panel.setSize(1600,1200);
			      //panel.add(pane);
			      table.setBackground(new Color(152,251,152));
			      table.setForeground(Color.black);
			      JTableHeader tableHeader = table.getTableHeader();
			      
			      tableHeader.setBackground(new Color(255,165,0));
			      tableHeader.setForeground(Color.black);
			      
			      add(pane);
			      setSize(1500, 400);
			      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			      setVisible(true);}}
			    else
				{
			    	JOptionPane.showMessageDialog(null,"Invalid ");
				}
			   
		      
		}
		catch (Exception ex)
	      {
	    	  System.out.println(ex);
	      }
	
		
	
	}
public class SocialStatus {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new socialst();
	}
}
}
		
