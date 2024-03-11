package Eeeeeee;

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

import ccccccccc.Assets;

public class Expensesform implements ActionListener {
	
	JFrame frame;
	JLabel expense_id_lb=new JLabel("expense_id");
	JLabel account_id_lb=new JLabel("account_id");
	JLabel amount_lb=new JLabel("amount");
	JLabel expense_date_lb=new JLabel("expense_date");
	

	JTextField expense_id_txf=new JTextField();
	JTextField account_id_txf=new JTextField();
	JTextField amount_txf=new JTextField();
	JTextField expense_date_txf=new JTextField();

//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public Expensesform() {
		createForm();
		ActionEvent();
		setLocationandSize();
		setFontforall();
		addcomponentforFrame();

	}
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		//genderBox.addActionListener(this);
	}
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("expenses form");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.green);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		
	}


	private void setLocationandSize() {
		expense_id_lb.setBounds(10, 10, 100, 30);
		account_id_lb.setBounds(10, 50, 100, 30);
		amount_lb.setBounds(10, 90, 100, 30);
		expense_date_lb.setBounds(10, 130, 120, 30);
		
		expense_id_txf.setBounds(160, 10, 130, 30);
		account_id_txf.setBounds(160, 50, 130, 30);
		amount_txf.setBounds(160, 90, 130, 30);
		expense_date_txf.setBounds(160, 130, 130, 30);
		
      //Buttons CRUD
		insert_btn.setBounds(10,250, 85, 30);
		Read_btn.setBounds(100,250, 85, 30);
		update_btn.setBounds(190,250, 85, 30);
		delete_btn.setBounds(280,250, 85, 30);
		table.setBounds(400, 10, 600, 240);
		

	}
	private void setFontforall() {
		Font font = new Font("Times New Roman", Font.BOLD, 20);

		expense_id_lb.setFont(font);
		account_id_lb.setFont(font);
		amount_lb.setFont(font);
		expense_date_lb.setFont(font);
		

		expense_id_txf.setFont(font);
		account_id_txf.setFont(font);
		amount_txf.setFont(font);
		expense_date_txf.setFont(font);
		
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addcomponentforFrame() {
		frame.add(expense_id_lb);
		frame.add(account_id_lb);
		frame.add(amount_lb);
		frame.add(expense_date_lb);
		
		frame.add(expense_id_txf);
		frame.add(account_id_txf);
		frame.add(amount_txf);
		frame.add(expense_date_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add(table);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Expenses es=new Expenses();
		if(e.getSource()==insert_btn) {
			es.setAccount_id(account_id_txf.getText());
			es.setAmount(amount_txf.getText());
			es.setExpense_date(expense_date_txf.getText());
			es.insertData();
			
		}
		
		else if (e.getSource() == Read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("expense_id");
            model.addColumn("account_id");
            model.addColumn("amount");
            model.addColumn("expenses_date");
           
            ResultSet resultSet =Expenses.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_btn) {
	    	int id=Integer.parseInt(expense_id_txf.getText());
				es.setAccount_id(account_id_txf.getText());
				es.setAmount(amount_txf.getText());
				es.setExpense_date(expense_date_txf.getText());
				es.update(id);	
	    }
	  else {
			int id=Integer.parseInt(expense_id_txf.getText());
			es.delete(id);}

	  }
		
		public static void main(String[] args) {
			Expensesform stf=new Expensesform();

}

	
		}

		
	
