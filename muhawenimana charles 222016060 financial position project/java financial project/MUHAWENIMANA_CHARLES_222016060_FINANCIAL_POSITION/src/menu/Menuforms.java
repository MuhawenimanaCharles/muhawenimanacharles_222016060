package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Dddddd.Assetsform;
import Eeeeeee.Expensesform;
import Ggggg.IncomesForm;
import Hhhhhh.LoanForm;
import Jjjjjjjjjj.TransactionForm;
import bbbbbbb.Accounts;
import bbbbbbb.AccountsForm;

public class Menuforms extends JFrame implements ActionListener{

	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu Accountsmenu;
    private JMenu Assetsmenu;
    private JMenu Expensesmenu;
    private JMenu incomesmenu;
    private JMenu Loanmenu;
    private JMenu Transactionmenu;
    private JMenu Logoutmenu;
    


	public Menuforms() {
		// TODO Auto-generated constructor stub
	}
    
    private JMenuItem AccountsItem;
    private JMenuItem AssetsItem;
    private JMenuItem ExpensesItem;
    private JMenuItem incomesItem;
    private JMenuItem LoanItem;
    private JMenuItem TransactionItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    public Menuforms(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard for financial_position");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        Accountsmenu = new JMenu("Accounts");
        Assetsmenu = new JMenu("Assets");
        Expensesmenu= new JMenu("Expenses");
        incomesmenu = new JMenu("incomes");
        Loanmenu = new JMenu("Loan");
        Transactionmenu = new JMenu("Transaction");
        Logoutmenu = new JMenu("Logout");
        		

        // Create menu items
        menuBar.add(Accountsmenu);
        AccountsItem = new JMenuItem("AccountsForm");
        AccountsItem.addActionListener(this);
        
        menuBar.add(Assetsmenu);
        AssetsItem = new JMenuItem("AssetsForm");
        AssetsItem.addActionListener(this);
        
        menuBar.add(Expensesmenu);
        ExpensesItem = new JMenuItem("ExpensesForm");
        ExpensesItem.addActionListener(this);
        
        menuBar.add(incomesmenu);
        incomesItem = new JMenuItem("incomesForm");
        incomesItem.addActionListener(this);
        
        menuBar.add(Loanmenu);
        LoanItem = new JMenuItem("LoanForm");
        LoanItem.addActionListener(this);
        
        menuBar.add(Transactionmenu);
        TransactionItem = new JMenuItem("TransactionForm");
        TransactionItem.addActionListener(this);
        
        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        Accountsmenu.add(AccountsItem);
        Assetsmenu.add(AssetsItem);
        Expensesmenu.add(ExpensesItem);
        incomesmenu.add(incomesItem);
        Loanmenu.add(LoanItem);
        Transactionmenu.add(TransactionItem);
        
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu bar
        // Set menu bar to frame
        setJMenuBar(menuBar);

        new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the image
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\user\\Desktop\\Screenshot 2024-02-18 234414.png");
                // Draw the image
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };



        // Initialize dashboard panel
        JPanel dashboardPanel1 = new JPanel();
        dashboardPanel1.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " financial position");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel1.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel1);

        setVisible(true);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AccountsItem) {
            new AccountsForm();
        
        } else if (e.getSource() == AssetsItem) {
            new Assetsform();
        
        } else if (e.getSource() == ExpensesItem) {
            new Expensesform();
       
        } else if (e.getSource() == incomesItem) {
           new IncomesForm();
        
        } else if (e.getSource() == LoanItem) {
           new LoanForm();
           
        } else if (e.getSource() == TransactionItem) {
               new TransactionForm();
           
       
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menuforms("TO PROJECT"));
    }
}


