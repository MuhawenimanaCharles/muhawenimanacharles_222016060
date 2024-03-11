package Dddddd;

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

public class Assetsform implements ActionListener {
	JFrame frame;
	JLabel asset_id_lb=new JLabel("asset_id");
	JLabel account_id_lb=new JLabel("account_id");
	JLabel asset_name_lb=new JLabel("asset_name");
	JLabel value_lb=new JLabel("value");
	

	JTextField asset_id_txf=new JTextField();
	JTextField account_id_txf=new JTextField();
	JTextField asset_name_txf=new JTextField();
	JTextField value_txf=new JTextField();

   
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
	public Assetsform() {
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
		frame.setTitle("assets form");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		
	}


	private void setLocationandSize() {
		asset_id_lb.setBounds(10, 10, 100, 30);
		account_id_lb.setBounds(10, 50, 100, 30);
		asset_name_lb.setBounds(10, 90, 100, 30);
		value_lb.setBounds(10, 130, 100, 30);
		
		asset_id_txf.setBounds(160, 10, 130, 30);
		account_id_txf.setBounds(160, 50, 130, 30);
		asset_name_txf.setBounds(160, 90, 130, 30);
		value_txf.setBounds(160, 130, 130, 30);
		
        //Buttons CRUD
		insert_btn.setBounds(10,250, 85, 30);
		Read_btn.setBounds(100,250, 85, 30);
		update_tbtn.setBounds(190,250, 85, 30);
		delete_btn.setBounds(280,250, 85, 30);
		table.setBounds(400, 10, 600, 240);

	}
	private void setFontforall() {
		Font font = new Font("Times New Roman", Font.BOLD, 20);

		asset_id_lb.setFont(font);
		account_id_lb.setFont(font);
		asset_name_lb.setFont(font);
		value_lb.setFont(font);
		

		asset_id_txf.setFont(font);
		account_id_txf.setFont(font);
		asset_name_txf.setFont(font);
		value_txf.setFont(font);
		
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addcomponentforFrame() {
		frame.add(asset_id_lb);
		frame.add(account_id_lb);
		frame.add(asset_name_lb);
		frame.add(value_lb);
		
		frame.add(asset_id_txf);
		frame.add(account_id_txf);
		frame.add(asset_name_txf);
		frame.add(value_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Assets as=new Assets();
		if(e.getSource()==insert_btn) {
			as.setAccount_id(account_id_txf.getText());
			as.setAsset_name(asset_name_txf.getText());
			as.setValue(value_txf.getText());
			as.insertData();
			
		}
		else if (e.getSource() == Read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("asset_id");
            model.addColumn("account_id");
            model.addColumn("asset_name");
            model.addColumn("value");
           
            ResultSet resultSet =Assets.viewData();
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
			int id=Integer.parseInt(asset_id_txf.getText());
			as.setAccount_id(account_id_txf.getText());
			as.setAsset_name(asset_name_txf.getText());
			as.setValue(value_txf.getText());
			as.update(id);	
	    }
	  else {
			int id=Integer.parseInt(asset_id_txf.getText());
			as.delete(id);}

	  }
		


		public static void main(String[] args) {
			Assetsform stf=new Assetsform();


	}
		}
