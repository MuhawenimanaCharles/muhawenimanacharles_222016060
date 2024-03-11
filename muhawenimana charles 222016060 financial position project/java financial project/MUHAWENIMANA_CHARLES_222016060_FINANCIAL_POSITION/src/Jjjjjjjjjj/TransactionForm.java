package Jjjjjjjjjj;

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

import Fffffff.incomes;
import Iiiiiiiii.Transaction;


public class TransactionForm implements ActionListener {
	

	JFrame frame;
	JLabel transaction_id_lb=new JLabel("transaction_id");
	JLabel account_id_lb=new JLabel("account_id");
	JLabel amount_lb=new JLabel("amount");
	JLabel transaction_date_lb=new JLabel("transaction_date");
	

	JTextField transaction_id_txf=new JTextField();
	JTextField account_id_txf=new JTextField();
	JTextField amount_txf=new JTextField();
	JTextField transaction_date_txf=new JTextField();
	
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
	public TransactionForm() {
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
		frame.setTitle("Loan form");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.magenta);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		
	}


	private void setLocationandSize() {
		transaction_id_lb.setBounds(10, 10, 120, 30);
		account_id_lb.setBounds(10, 50, 100, 30);
		amount_lb.setBounds(10, 90, 100, 30);
		transaction_date_lb.setBounds(10, 130, 140, 40);
		
		transaction_id_txf.setBounds(180, 10, 130, 30);
		account_id_txf.setBounds(180, 50, 130, 30);
		amount_txf.setBounds(180, 90, 130, 30);
		transaction_date_txf.setBounds(180, 130, 130, 30);
		
	  //Buttons CRUD
		insert_btn.setBounds(10,250, 85, 30);
		Read_btn.setBounds(100,250, 85, 30);
		update_tbtn.setBounds(190,250, 85, 30);
		delete_btn.setBounds(280,250, 85, 30);
		table.setBounds(400, 10, 600, 240);

	}
	private void setFontforall() {
		Font font = new Font("Times New Roman", Font.BOLD, 20);

		transaction_id_lb.setFont(font);
		account_id_lb.setFont(font);
		amount_lb.setFont(font);
		transaction_date_lb.setFont(font);
		

		transaction_id_txf.setFont(font);
		account_id_txf.setFont(font);
		amount_txf.setFont(font);
		transaction_date_txf.setFont(font);
		
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addcomponentforFrame() {
		frame.add(transaction_id_lb);
		frame.add(account_id_lb);
		frame.add(amount_lb);
		frame.add(transaction_date_lb);
		
		frame.add(transaction_id_txf);
		frame.add(account_id_txf);
		frame.add(amount_txf);
		frame.add(transaction_date_txf);
		frame.add(table);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		Transaction it=new Transaction();
		if(e.getSource()==insert_btn) {
			it.setAccount_id(account_id_txf.getText());
			it.setAmount(amount_txf.getText());
			it.setTransaction_date(transaction_date_txf.getText());
			it.insertData();
			
		}
		
		else if (e.getSource() == Read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("transaction_id");
            model.addColumn("account_id");
            model.addColumn("amount");
            model.addColumn("transaction_date");
           
            ResultSet resultSet =Transaction.viewData();
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
	    else if (e.getSource()==update_tbtn) {
	    	int id=Integer.parseInt(transaction_id_txf.getText());
	    	it.setAccount_id(account_id_txf.getText());
			it.setAmount(amount_txf.getText());
			it.setTransaction_date(transaction_date_txf.getText());
			it.update(id);
	    }
	  else {
			int id=Integer.parseInt(transaction_id_txf.getText());
			it.delete(id);}
		
	}
		public static void main(String[] args) {
			TransactionForm stf=new TransactionForm();
		}
			

	}
