package bbbbbbb;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AccountsForm implements ActionListener {

JFrame frame;
	JLabel Account_id_lb=new JLabel("Account_id");
	JLabel Account_name_lb=new JLabel("Account_name");
	JLabel balance_lb=new JLabel("balance");
	

	JTextField Account_id_txf=new JTextField();
	JTextField Account_name_txf=new JTextField();
	JTextField balance_txf=new JTextField();

   
	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_tbtn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public AccountsForm() {
		createForm();
		ActionEvent();
		setLocationandSize();
		setFontforall();
		addcomponentforFrame();

	}
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_tbtn.addActionListener(this);
		delete_btn.addActionListener(this);
		//genderBox.addActionListener(this);
	}
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("account form");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.RED);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		
	}


	private void setLocationandSize() {
		Account_id_lb.setBounds(10, 10, 100, 30);
		Account_name_lb.setBounds(10, 50, 130, 30);
		balance_lb.setBounds(10, 90, 100, 30);
		
		Account_id_txf.setBounds(160, 10, 130, 30);
		Account_name_txf.setBounds(160, 50, 130, 30);
		balance_txf.setBounds(160, 90, 130, 30);
		
        //Buttons CRUD
		insert_btn.setBounds(10,250, 85, 30);
		Read_btn.setBounds(100,250, 85, 30);
		update_tbtn.setBounds(190,250, 85, 30);
		delete_btn.setBounds(280,250, 85, 30);
		table.setBounds(400, 10, 600, 240);

	}
	private void setFontforall() {
		Font font = new Font("Times New Roman", Font.BOLD, 20);

		Account_id_lb.setFont(font);
		Account_name_lb.setFont(font);
		balance_lb.setFont(font);
		

		Account_id_txf.setFont(font);
		Account_name_txf.setFont(font);
		balance_txf.setFont(font);
		
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addcomponentforFrame() {
		frame.add(Account_id_lb);
		frame.add(Account_name_lb);
		frame.add(balance_lb);
		
		frame.add(Account_id_txf);
		frame.add(Account_name_txf);
		frame.add(balance_txf);
		frame.add(table);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Accounts ac=new Accounts();
		if(e.getSource()==insert_btn) {
			ac.setAccount_name(Account_name_txf.getText());
			ac.setBalance(balance_txf.getText());
			ac.insertData();
			
		}
		
		else if (e.getSource() == Read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("account_id");
            model.addColumn("account_name");
            model.addColumn("balance");
           
            ResultSet resultSet =Accounts.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    
		  else if (e.getSource()==update_tbtn) {
			int id=Integer.parseInt(Account_id_txf.getText());
			ac.setAccount_name(Account_name_txf.getText());
			ac.setBalance(balance_txf.getText());
			ac.update(id);	
	    }
	  else {
			int id=Integer.parseInt(Account_id_txf.getText());
			ac.delete(id);}

	  }

	public static void main(String[] args) {
		AccountsForm stf=new AccountsForm();
		System.out.println(stf);
	
	
		
	}

	

}

