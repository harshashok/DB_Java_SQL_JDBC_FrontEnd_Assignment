package assignment2;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


class LoginPanel extends JPanel{
	/**
	 * HAR: LoginPanel has JButtons for login, signup, password, field.
	 */
	private static final long serialVersionUID = 1L;
	JTextField username;
	JPasswordField password;
	JButton login;
	JButton signup;
	private String UserName;
	static boolean signedOn = false;

	public void disablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].disable();
		}
	}

	public void enablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].enable();
		}
	}

	LoginPanel(){
		this.setBounds(810, 30, 250, 100);
		this.setLayout(new GridLayout(3,2));
		this.add(new Label("UserName: "));
		username = new JTextField();
        this.add(username);
		this.add(new Label("Password: "));
		password = new JPasswordField();
        this.add(password);
        login = new JButton("Login");
        signup = new JButton("Signup");
        this.add(login);
        this.add(signup);
	}
	public String getUserName(){
		return UserName;
	}
	public void setUserName(String user){
		UserName=user;
	}
}

class SignupPanel extends JPanel{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JButton login;
	JButton signup;
	JPasswordField password;
	JPasswordField password2;

	JTextField country;
	JTextField state;
	JTextField city;
	JTextField email;
	JTextField birthday;
	JTextField fname;
	JTextField lname;
	JTextField str_no;
	JTextField str_address;
	JTextField zip;

	public void disablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].disable();
		}
		disableButton();
	}

	public void enablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].enable();
		}
		enableButton();
	}

	SignupPanel(){
		this.setBounds(810, 150, 250, 300);
		this.setLayout(new GridLayout(11,2));
		this.add(new Label("Email: "));
		email = new JTextField();
        this.add(email);
		this.add(new Label("Password: "));
		password = new JPasswordField();
        this.add(password);
		this.add(new Label("ReEnter Password: "));
		password2 = new JPasswordField();
        this.add(password2);
		this.add(new Label("First Name: "));
		fname = new JTextField();
        this.add(fname);
		this.add(new Label("Last Name: "));
		lname = new JTextField();
        this.add(lname);
		this.add(new Label("City: "));
		city = new JTextField();
        this.add(city);
		this.add(new Label("Birthday : "));
		birthday = new JTextField();
        this.add(birthday);
		this.add(new Label("strNo : "));
		str_no = new JTextField();
        this.add(str_no);
		this.add(new Label("strAdress : "));
		str_address = new JTextField();
        this.add(str_address);
        this.add(new Label("Zip : "));
		zip = new JTextField();
        this.add(zip);
        this.add(new Label(""));
        signup = new JButton("signup");
        this.add(signup);
        disablePanel();
	}

	public void disableButton(){
		signup.setEnabled(false);
	}
	public void enableButton(){
		signup.setEnabled(true);
	}
}

class SqlPanel extends JPanel{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextArea SQLArea = null;
	JScrollPane scrollPane = null;
	JLabel showLabel;
	SqlPanel(){
		setInputArea();
	}

	public void disablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].disable();
		}
	}

	public void enablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].enable();
		}
	}

	private void setInputArea(){
		setBounds(0, 495,810, 150);
		SQLArea = new JTextArea(6,68);
		SQLArea.setLineWrap(true);
		scrollPane = new JScrollPane(SQLArea);
		this.add(scrollPane);
	}
}

class PopUp extends JFrame{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextField txtfield;
	JButton btn1;
	String lbltext;
	JLabel label;
	String FriendType[] = { "Normal Friend", "Close Friend", "Family" };
	

	PopUp(String text,int mode){
		this.lbltext = text;
		 this.setSize(300, 120);
		 this.setResizable(false);
		setLayout(new FlowLayout());
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((width-this.getWidth())/2,(height-this.getHeight())/2);
		label = new JLabel(text);
		add(label);
        btn1 = new JButton("OK");
        add(btn1);

	}
}


class Frame0 extends JFrame{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextField txtfield;
	JButton btn1;
	String lbltext;
	JLabel label;
	String FriendType[] = { "Normal Friend", "Close Friend", "Family" };
	JComboBox combo;

	Frame0(String text,int mode){
		this.lbltext = text;
		 this.setSize(300, 120);
		 this.setResizable(false);
		setLayout(new FlowLayout());
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((width-this.getWidth())/2,(height-this.getHeight())/2);
		label = new JLabel(text);
		add(label);
		txtfield = new JTextField(10);
        add(txtfield);
        combo= new JComboBox(FriendType);
        if(mode==1)
        	add(combo);
        btn1 = new JButton("OK");
        add(btn1);

	}
}

class Frame1 extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextField txtfield;
	JButton btn1;
	JButton btn2;
	String lbltext0;
	String lbltext1;
	JLabel lbl0;
	JLabel lbl1;
	JTextArea textArea = null;

	Frame1(String text0, String text1) {
		this.lbltext0 = text0;
		this.lbltext1 = text1;
		this.setResizable(false);
		setLayout(null);
		 this.setSize(300, 256);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((width-this.getWidth())/2,(height-this.getHeight())/2);
		lbl0 = new JLabel(text0);
		add(lbl0);
		lbl0.setBounds(10, 10, 70, 30);

		txtfield = new JTextField(10);
		add(txtfield);
		txtfield.setBounds(85, 10, 150, 30);

		lbl1 = new JLabel(text1);
		add(lbl1);
		lbl1.setBounds(10, 45, 70, 30);

		textArea = new JTextArea(8, 10);
		textArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		this.add(scrollPane);
		scrollPane.setBounds(85,55,180,90);

		btn1 = new JButton("OK");
		btn1.setBounds(90,165,90, 30);
		add(btn1);

	}
}


class Frame2 extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextField txtfield;
	JButton btn1;
	JButton btn2;
	String lbltext0;
	JLabel lbl0;

	Frame2(String text0) {
		this.setResizable(false);
		this.lbltext0 = text0;
        this.setSize(300, 150);
        this.setResizable(false);
		setLayout(null);

		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((width-this.getWidth())/2,(height-this.getHeight())/2);
		lbl0 = new JLabel(text0);
		add(lbl0);
		lbl0.setBounds(10, 10, 70, 30);

		txtfield = new JTextField(10);
		add(txtfield);
		txtfield.setBounds(85, 10, 100, 30);

		btn1 = new JButton("Decline");
		btn2 = new JButton("Accept ALL");

		btn1.setBounds(190,10,90, 30);
		btn2.setBounds(70,60,150, 30);
		add(btn1);
		add(btn2);

	}
}


class Frame3 extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextField []txtfield;
	JButton btn1;
	JLabel []lbl;
	Frame3(String text0) {
		this.setResizable(false);
		this.setTitle(text0);
        this.setSize(1000, 70);
        this.setResizable(false);
		setLayout(new GridLayout(1,9));

		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((width-this.getWidth())/2,(height-this.getHeight())/2);
		lbl = new JLabel[4];
		for(int i=0;i<4;i++)
			lbl[i] = new JLabel();
		lbl[0].setText("topleft x:");
		lbl[1].setText("topleft y:");
		lbl[2].setText("bottomright x:");
		lbl[3].setText("bottomright y:");

		txtfield = new JTextField[4];
		for(int i=0;i<4;i++)
			txtfield[i] = new JTextField();

		btn1 = new JButton("search");
		for(int i=0;i<4;i++)
		{
			add(lbl[i]);
			add(txtfield[i]);
		}
		add(btn1);
	}
}


class PostandSearchPanel extends JPanel{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextArea textArea = null;
	JScrollPane scrollPane = null;

	JTextField text;
	JLabel showLabel;
	JButton []buttons;

	public void disableButton(){
		for(int i=0;i<buttons.length;i++)
			buttons[i].setEnabled(false);
	}

	public void enableButton(){
		for(int i=0;i<buttons.length;i++)
			buttons[i].setEnabled(true);
	}

	PostandSearchPanel(){
		setLayout(null);
		this.setBounds(0, 10,780, 120);
        setInputArea();

		buttons = new JButton[2];
		buttons[0]= new JButton("Post");
		buttons[1]= new JButton("Search For Friend");

		text  = new JTextField(15);
		text.setLocation(10,3);
		text.setText("");
		text.setBounds(460, 40, 150, 25);
		buttons[0].setBounds(380,40,60,25);
		buttons[1].setBounds(620,40,130,25);

		
		this.add(buttons[0]);
		this.add(text);
		this.add(buttons[1]);

	}
	public void disablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].disable();
		}
		disableButton();
	}

	public void clearPanel(){
		text.setText("");
	    textArea.setText("");
	}

	public  void enablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].enable();
		}
		enableButton();
	}

	public void setInputArea(){
		textArea = new JTextArea(4,30);
		textArea.setLineWrap(true);
		textArea.setBounds(10, 10, 360, 90);
		this.add(textArea);
	}
 }

class ResultPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea resultArea;
	JScrollPane scrollPane = null;
	ResultPanel(){
		setResultArea();
	}

	public void setResultArea(){
		resultArea = new JTextArea(10,30);
		resultArea.setLineWrap(true);
		resultArea.setBounds(10, 140,750, 250);

		scrollPane = new JScrollPane(resultArea);
		add(scrollPane);

	}
}

class ButtonPanel extends JPanel{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextArea textArea = null;
	JScrollPane scrollPane = null;
	JLabel showLabel;
	JButton []buttons;

	ButtonPanel(){
	  this.setBounds(10, 415, 770, 40);
	 	buttons = new JButton[8];
		this.setLayout(new GridLayout(2,4));
        for(int i=0;i<8;i++){
        	buttons[i]= new JButton();
        	this.add(buttons[i]);
        }
        buttons[0].setText("Add Friend");
        buttons[1].setText("List all posts");
        buttons[2].setText("List all comments on a post");
        buttons[3].setText("Comment on A post");
        buttons[4].setText("List all events");
        buttons[5].setText("Friend request");   
        buttons[6].setText("Find nearest friend");
        buttons[7].setText("Range query");

	}

	public void disableButton(){
		for(int i=0;i<buttons.length;i++)
			buttons[i].setEnabled(false);
	}

	public void enableButton(){
		for(int i=0;i<buttons.length;i++)
			buttons[i].setEnabled(true);
	}

	public void disablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].disable();
		}
		disableButton();
	}

	public void enablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
			comps[i].enable();
		}
		enableButton();
	}
}


class MainFrame extends JFrame{
	/**
	 *
	 */
	
	private static final long serialVersionUID = 1L;
	JLabel LogoLabel;
	JButton notifyButton;
	LoginPanel loginPanel;
	SignupPanel signUpPanel;
	SqlPanel sqlPanel;
	ButtonPanel buttonPanel;
	PostandSearchPanel postandsearch;
	ResultPanel resultPanel;
	static Connection conn=null;                                  // changed to static.
	ArrayList<String> requester = new ArrayList<String>();
	ArrayList<String> Relation= new ArrayList<String>();
	int countrequest=0;
	JTextArea resultArea = null;
	JScrollPane scrollPane = null;
	int trigger = 0;
	JLabel showLabel;
	int hasRequest = 0;
	StringBuffer SQLOut = new StringBuffer ();
	MainFrame(){
		setResizable(false);
		setLayout(null);
		setSize(1100, 700);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((width-1100)/2,(height-700)/2);
		setTitle("This is GUI for database homework");
		setNotifyLabel();
		SetLogo();
		setLoginPanel();
		setSignupPanel();
		setSqlPanel();
		setButtonPanel();
		setPostandSearchPanel();
		setResultPanel();
		postandsearch.disablePanel();
		buttonPanel.disablePanel();
	}

	public void disableResult(){
    	resultArea.setText("");
    	resultArea.setEditable(false);
    	resultArea.setEnabled(false);
    	scrollPane.setEnabled(false);
	}

	public void setResultPanel(){
		resultArea = new JTextArea(10,30);
		resultArea.setLineWrap(true);
		scrollPane = new JScrollPane(resultArea);
		add(scrollPane);
		scrollPane.setBounds(10, 140,770, 250);
	}

	public void SetLogo(){
	Image image;
	try {
		image = ImageIO.read(new File("usc_viterbi_logo.jpg"));
		ImageIcon icon = new ImageIcon(image);
		LogoLabel = new JLabel();
		LogoLabel.setIcon(icon);
		LogoLabel.setBounds(830,480,300,150);

		add(LogoLabel);
	} catch (IOException e) {
		e.printStackTrace();
	}  //this generates an image file

	}

	public void setNotifyLabel(){
		Image image;
		try {
			image = ImageIO.read(new File("notify.png"));
			ImageIcon icon = new ImageIcon(image);
			notifyButton = new JButton();
			notifyButton.setIcon(icon);
			notifyButton.setBounds(750,3,30,30);

			notifyButton.addActionListener(new ActionListener() {
	           
	            public void actionPerformed(ActionEvent e) {
	            	//TITLE: FRIEND REQUEST LIST.
	            	/*Press this notification button, you should list all the friend request on the ResultPanel*/
	            	/*the output format is like "... wants to add you as 'friend type'." */
	            	//TODO: Improve this...???
	            	Statement statement = null;
	            	ResultSet resultSet = null;
	            	String sql = null;
	            	String res = "\nFRIEND REQUESTS\n";
	            	       res = res+ "================\n";
	            	sql = "select * from fndrequest where friendid='"+loginPanel.getUserName()+"'";
	            	//SQL: SELECT FROM FRIEND REQUEST TABLE FOR USER.
	            	try {
						statement = conn.createStatement();
						resultSet = statement.executeQuery(sql);
						resultSet.next();
						if(resultSet.getRow() > 0){
							do{
            					System.out.println("DEBUG-FNDR: "+resultSet.getString("EMAILID"));
            					res = res + "\n" + resultSet.getString("EMAILID")+" wants to add you as a friend type "+resultSet.getString("FRIENDTYPE");
            					
            				}while(resultSet.next());
							res = res + "\n=========================================================\n";
						}
						resultArea.setText(res);
	            	}catch(SQLException se){
	            		se.printStackTrace();
	            	}
	            	
	            	
	            	
	            	
	            }
	        });

			add(notifyButton);
			notifyButton.setVisible(false);
		} catch (IOException e) {
			e.printStackTrace();
		}  //this generates an image file


	}

	public void setButtonPanel(){
		buttonPanel = new ButtonPanel();
		this.add(buttonPanel);

		buttonPanel.buttons[0].addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
            	final Frame0 frame=new Frame0("User Email",1);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);

                frame.btn1.addActionListener(new ActionListener() {
                    
                    public void actionPerformed(ActionEvent e) {      
                    	//TITLE: SEND FRIEND REQUEST.
    	            	/*Press this add friend button, input user Email information, press OK, you should be able to send friend request*/
    	            	/*After press ok, you should also pop up a standard dialog box to show the request send status <succeed or failed>*/
                    	String fndName = frame.txtfield.getText();
                    	Statement statement = null;
                    	ResultSet resultSet = null;
                    	String sql = null;
                    	boolean reqSucess = true;
                    	System.out.println("loginPanel.getUserName() == fndName" + loginPanel.getUserName()+" == "+fndName);                  
                    	if(fndName.equals(loginPanel.getUserName())){
                    		reqSucess = false;
                    		//PopUp. Friend can't be yourself.
                    		final PopUp popup =new PopUp(" You can't try to friend yourself!!",1);
				                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				                popup.setVisible(true);
				                popup.btn1.addActionListener(new ActionListener() {
				                    
				                    public void actionPerformed(ActionEvent e) {
  				                    	popup.dispose();     				                       				                
				                    }
				                });
                    	}else{                    		                    	
                    	
                    	
                    	/*SQL TO CHECK IF USERNAME EXISTS */
                    	sql = "SELECT * FROM MEMBERS WHERE EMAIL='"+fndName+"'";
                    	System.out.println(sql);  
                    	sqlPanel.SQLArea.setText(sql);
                    	try {
    						statement = conn.createStatement();
    						resultSet = statement.executeQuery(sql);
    						resultSet.next();
    							if(resultSet.getRow() == 0){
    								System.out.println("DEBUG: Username Does Not exist!");  
    								reqSucess = false;
    								frame.dispose();
    								//PopUp: Username doesn't exist.
    								final PopUp popup =new PopUp("Username does not exists!",1);
     				                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
     				                popup.setVisible(true);
     				                popup.btn1.addActionListener(new ActionListener() {
     				                    
     				                    public void actionPerformed(ActionEvent e) {
          				                    	popup.dispose();     				                       				                
     				                    }
     				                });
    								}
    							if(reqSucess){
    								/*SQL TO CHECK IF ALREADY A FRIEND*/
    								sql = "SELECT * FROM FRIENDSHIP WHERE EMAILID='"+loginPanel.getUserName()+"' AND FRIENDID='"+fndName+"'";
    								sqlPanel.SQLArea.setText(sql);
    								resultSet = statement.executeQuery(sql);
    	    						resultSet.next();
    	    							if(resultSet.getRow() > 0){
    	    								System.out.println("DEBUG-REQ: User already a friend !");  
    	    								reqSucess = false;
    	    								frame.dispose();
    	    								//PopUp: User already a friend
    	    								final PopUp popup =new PopUp("User already a friend!",1);
    	     				                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    	     				                popup.setVisible(true);
    	     				                popup.btn1.addActionListener(new ActionListener() {
    	     				                    
    	     				                    public void actionPerformed(ActionEvent e) {
    	          				                    	popup.dispose();     				                       				                
    	     				                    }
    	     				                });
    	    							}
    							}
    							/*SQL TO CHECK IF ALREADY REQUESTED FOR FRIENDSHIP*/
    							sql = "SELECT * FROM FNDREQUEST WHERE EMAILID='"+loginPanel.getUserName()+"' AND FRIENDID='"+fndName+"'";
    							sqlPanel.SQLArea.setText(sql);
								resultSet = statement.executeQuery(sql);
	    						resultSet.next();
	    							if(resultSet.getRow() > 0){
	    								System.out.println("DEBUG-REQ: User already has been sent a friend request !");  
	    								reqSucess = false;
	    								frame.dispose();
	    								//PopUp: Request already sent.
	    								final PopUp popup =new PopUp(" Friend Request already sent!",1);
	     				                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	     				                popup.setVisible(true);
	     				                popup.btn1.addActionListener(new ActionListener() {
	     				                    
	     				                    public void actionPerformed(ActionEvent e) {
	          				                    	popup.dispose();     				                       				                
	     				                    }
	     				                });
	    								}
	    							/*SQL TO CHECK IF IF USER HAS SENT A FRIEND REQUEST*/
	    							sql = "SELECT * FROM FNDREQUEST WHERE EMAILID='"+fndName+"' AND FRIENDID='"+loginPanel.getUserName()+"'";
	    							sqlPanel.SQLArea.setText(sql);
									resultSet = statement.executeQuery(sql);
		    						resultSet.next();
		    							if(resultSet.getRow() > 0){
		    								System.out.println("DEBUG-REQ: User already has sent a friend request !");  
		    								reqSucess = false;
		    								frame.dispose();
		    								//PopUp: Request already sent.
		    								final PopUp popup =new PopUp(" Friend Request already sent by the user. Just accept the request in the requests tab!",1);
		     				                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		     				                popup.setVisible(true);
		     				                popup.btn1.addActionListener(new ActionListener() {
		     				                    
		     				                    public void actionPerformed(ActionEvent e) {
		          				                    	popup.dispose();     				                       				                
		     				                    }
		     				                });
		    								}	
                    		}catch(SQLException se){
                    			System.out.println("SQLERROR");
                    			se.printStackTrace();
                    		}
                    	//SQL: CHECK IF USER IS FRIENDING HIMSELF.
                    	System.out.println("loginPanel.getUserName() == fndName" + loginPanel.getUserName()+" == "+fndName);                    	
                    	
                    	
                    	if(reqSucess){
                    		//PopUp: Success!!
                    		System.out.println("DEBUG-REQ: REQUEST SUCCESS!");  
                    		frame.dispose();
							//PopUp: Request sent successful.
							final PopUp popup =new PopUp(" Friend Request Sent!",1);
				                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				                popup.setVisible(true);
				                popup.btn1.addActionListener(new ActionListener() {
				                    
				                    public void actionPerformed(ActionEvent e) {
  				                    	popup.dispose();     				                       				                
				                    }
				                });
                    		
                    		/*SQL TO ADD TO FREINDREQUEST DATABASE*/
                    		String type = frame.combo.getSelectedItem().toString();
                    		System.out.println("DEBUG-REQ: COMBO "+type);  
                    		String query = "insert into FNDREQUEST (emailid, friendid, friendtype) values('"
						            + loginPanel.getUserName() + "','" + fndName + "','"+ type +"')";
                    		sqlPanel.SQLArea.setText(sql);
                    		
                    		try {
								statement.execute(query);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
                    	}else{
                    		//PopUp: Failure!!
                    		System.out.println("DEBUG-REQ: REQUEST FAILED!");  
                    		sqlPanel.SQLArea.setText(sql);
                    		final PopUp popup =new PopUp(" Friend Request Failed!",1);
				                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				                popup.setVisible(true);
				                popup.btn1.addActionListener(new ActionListener() {
				                    
				                    public void actionPerformed(ActionEvent e) {
  				                    	popup.dispose();     				                       				                
				                    }
				                });
                    	}
                    	
                    	
                    	
                    	
                    	System.out.println("FNDName: "+ fndName);
                    	
                    	}
                    }
                });
                
            }
        });
		buttonPanel.buttons[1].addActionListener(new ActionListener() {
          
            public void actionPerformed(ActionEvent e) {
            	//TITLE: LIST POST VISIBLE.
            	/*Press this list all post button, you should be able to list all the post which are visible to you*/
            	/*You can define the output format*/
            	Statement statement = null;
            	ResultSet resultSet = null;
            	String res = "Posts for you: \n";
            	/*String sql = "select distinct pst.postid, pst.note, iss.sender, pst.datetime from post pst, issuespost iss,";
            					sql = sql +	" (select p.postid, i.sender, p.note from post p, issuespost i where i.postid=p.postid and i.sender='"+loginPanel.getUserName()+"') prv0,";
            					sql = sql +	" (select p.postid, i.sender, p.note from post p, issuespost i where i.postid=p.postid and p.privacylevel = 2) prv2,";
            					sql = sql +	" (select p.postid, i.sender, p.note from post p, issuespost i, friendship f where i.postid=p.postid";
            					sql = sql +	" and p.privacylevel = 1 and ((i.sender=f.friendid and f.emailid='"+loginPanel.getUserName()+"') or (i.sender=f.emailid and f.friendid='"+loginPanel.getUserName()+"'))) prv1";
            					sql = sql +	" where (pst.postid=prv0.postid and iss.postid=prv0.postid) or (pst.postid=prv1.postid and iss.postid=prv1.postid)";
            					sql = sql +	" or (pst.postid=prv2.postid and iss.postid=prv2.postid)";
            	System.out.println(sql);*/
            	String sql = "select distinct pst.postid, pst.note, iss.sender, pst.datetime from post pst, issuespost iss, friendship f";
            	 sql = sql + " where (pst.privacylevel = 0 and iss.sender='"+loginPanel.getUserName()+"' and iss.postid=pst.postid)";
            	 sql = sql + " or    (pst.privacylevel = 1 and f.emailid='"+loginPanel.getUserName()+"' and (f.friendid=iss.sender and iss.postid=pst.postid))";
            	 sql = sql + " or    (pst.privacylevel = 1 and f.friendid='"+loginPanel.getUserName()+"' and (f.emailid=iss.sender and iss.postid=pst.postid))";
            	 sql = sql + " or    (pst.privacylevel = 2 and pst.postid=iss.postid)";
            	sqlPanel.SQLArea.setText(sql);
            	
            	try {
					statement = conn.createStatement();
					resultSet = statement.executeQuery(sql);
					resultSet.next();
					
					if(resultSet.getRow() > 0){
						do{
							res = res + "\nPOSTID: "+resultSet.getString("POSTID");
							res = res + "\nNOTE: "+resultSet.getString("NOTE");
							res = res + "\nSENDER: "+resultSet.getString("SENDER");
							res = res + "\nTIMESAMP: "+resultSet.getString("DATETIME");
							res = res + "\n===========";
							//res = res + "\nTIMESAMP: "+resultSet.getString("DATETIME");
						}while(resultSet.next());
						
					}
					
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
            	resultArea.setText(res);

            }
        });

		buttonPanel.buttons[2].addActionListener(new ActionListener() {
          
            public void actionPerformed(ActionEvent e) {
            	final Frame0 frame=new Frame0("Post ID: ",2);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
                frame.btn1.addActionListener(new ActionListener() {
                 
                    public void actionPerformed(ActionEvent e) {
                    	//TITLE: LIST COMMENTS ON POST.
    	            	/*Press this List Comments Button, input Post ID, press OK, you should be able to list all the comment about this post*/
                    	String text = frame.txtfield.getText();
                    	int pid = Integer.parseInt(text);
                    	Statement statement = null;
                    	ResultSet resultSet = null;
                    	boolean resultFlag = false;
                    	String res ="COMMENTS on post "+pid;
                    	res += "\n====================";
                    	/*
                    	String sql = "select fin.postid from post fin where fin.postid="+pid+" and fin.postid in (";
                    	sql += " select distinct pst.postid from post pst, issuespost iss,";
                    	sql += " (select p.postid, i.sender, p.note from post p, issuespost i where i.postid=p.postid and i.sender='"+loginPanel.getUserName()+"') prv0,";
                    	sql += " (select p.postid, i.sender, p.note from post p, issuespost i where i.postid=p.postid and p.privacylevel = 2) prv2,";
                    	sql += " (select p.postid, i.sender, p.note from post p, issuespost i, friendship f where i.postid=p.postid";
                    	sql += " and p.privacylevel = 1 and ((i.sender=f.friendid and f.emailid='"+loginPanel.getUserName()+"') or (i.sender=f.emailid and f.friendid='"+loginPanel.getUserName()+"'))) prv1";
                    	sql += " where (pst.postid=prv0.postid and iss.postid=prv0.postid)";
                    	sql += " or (pst.postid=prv1.postid and iss.postid=prv1.postid)";
                    	sql += " or (pst.postid=prv2.postid and iss.postid=prv2.postid)  )";
                    	*/
                    	String sql = "select distinct p.postid from post p where p.postid="+pid+" and p.postid in (";
                    	sql = sql + " select pst.postid from post pst, issuespost iss, friendship f";
                   	 	sql = sql + " where (pst.privacylevel = 0 and iss.sender='"+loginPanel.getUserName()+"' and iss.postid=pst.postid)";
                   	 	sql = sql + " or    (pst.privacylevel = 1 and f.emailid='"+loginPanel.getUserName()+"' and (f.friendid=iss.sender and iss.postid=pst.postid))";
                   	 	sql = sql + " or    (pst.privacylevel = 1 and f.friendid='"+loginPanel.getUserName()+"' and (f.emailid=iss.sender and iss.postid=pst.postid))";
                   	 	sql = sql + " or    (pst.privacylevel = 2 and pst.postid=iss.postid))";
                    	System.out.println(sql);
                    	sqlPanel.SQLArea.setText(sql);
                    	
                    	try {
                    		statement = conn.createStatement();
							resultSet = statement.executeQuery(sql);
							resultSet.next();
							if(resultSet.getRow() > 0){
									System.out.println("POSTIDOUT: "+resultSet.getString("POSTID"));
									resultFlag = true;
							}else{
								//PopUp: Not authorised to see this post.
								System.out.println("Not authorized to see this post");
								final PopUp popup =new PopUp(" Not authorized to see this post",1);
 				                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
 				                popup.setVisible(true);
 				                popup.btn1.addActionListener(new ActionListener() {
 				                    
 				                    public void actionPerformed(ActionEvent e) {
      				                    	popup.dispose();     				                       				                
 				                    }
 				                });
							}
						} catch (SQLException e1) {
							
							e1.printStackTrace();
						}

                    	if(resultFlag){
                    		sql = "select * from leavescomment where pid="+pid;
                    		try {
                        		statement = conn.createStatement();
    							resultSet = statement.executeQuery(sql);
    							sqlPanel.SQLArea.setText(sql);
    							resultSet.next();
    							if(resultSet.getRow() > 0){
    									do{
    										res = res + "\nPOSTER: "+resultSet.getString("MID");
        									//res = res + "\nDATETIME: "+resultSet.getString("DATETIME");
        									res = res + "\nCOMMENT: "+resultSet.getString("TEXT");
        									res = res + "\n===============";
    									}while(resultSet.next());
    									
    							}else{    								
    								System.out.println("No Comments on this post");
    								resultArea.setText("No Comments on this post");
    							}
    						} catch (SQLException e1) {    							
    							e1.printStackTrace();
    						}
                    		resultArea.setText(res);
                    	}
                    	frame.dispose();
                    }
                });
                //
            }
        });
		
		buttonPanel.buttons[3].addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
            	final Frame1 frame=new Frame1("Post ID: ","Content: ");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
                frame.btn1.addActionListener(new ActionListener() {
                    
                    public void actionPerformed(ActionEvent e) {
                    	//TITLE: COMMENT ON A POST.
    	            	/*Press this Comment Button, input Post ID, and comment, press OK, you should be able to comment on this post*/
                    	/*After press ok, you should also pop up a standard dialog box to show the comment's status <succeed or failed>*/
                    	Statement statement = null;
                    	ResultSet resultSet = null;
                    	String text = frame.txtfield.getText();                    	
                    	int pid = Integer.parseInt(text);
                    	boolean resultFlag = false;
                    	int sequenceNumber = 0;
                    	/*
                    	String sql = "select fin.postid from post fin where fin.postid="+pid+" and fin.postid in (";
                    	sql += " select distinct pst.postid from post pst, issuespost iss,";
                    	sql += " (select p.postid, i.sender, p.note from post p, issuespost i where i.postid=p.postid and i.sender='"+loginPanel.getUserName()+"') prv0,";
                    	sql += " (select p.postid, i.sender, p.note from post p, issuespost i where i.postid=p.postid and p.privacylevel = 2) prv2,";
                    	sql += " (select p.postid, i.sender, p.note from post p, issuespost i, friendship f where i.postid=p.postid";
                    	sql += " and p.privacylevel = 1 and ((i.sender=f.friendid and f.emailid='"+loginPanel.getUserName()+"') or (i.sender=f.emailid and f.friendid='"+loginPanel.getUserName()+"'))) prv1";
                    	sql += " where (pst.postid=prv0.postid and iss.postid=prv0.postid)";
                    	sql += " or (pst.postid=prv1.postid and iss.postid=prv1.postid)";
                    	sql += " or (pst.postid=prv2.postid and iss.postid=prv2.postid)  )";
                    	*/
                    	String sql = "select distinct p.postid from post p where p.postid="+pid+" and p.postid in (";
                    	sql = sql + " select pst.postid from post pst, issuespost iss, friendship f";
                   	 	sql = sql + " where (pst.privacylevel = 0 and iss.sender='"+loginPanel.getUserName()+"' and iss.postid=pst.postid)";
                   	 	sql = sql + " or    (pst.privacylevel = 1 and f.emailid='"+loginPanel.getUserName()+"' and (f.friendid=iss.sender and iss.postid=pst.postid))";
                   	 	sql = sql + " or    (pst.privacylevel = 1 and f.friendid='"+loginPanel.getUserName()+"' and (f.emailid=iss.sender and iss.postid=pst.postid))";
                   	 	sql = sql + " or    (pst.privacylevel = 2 and pst.postid=iss.postid))";
                   	 	
                    	sqlPanel.SQLArea.setText(sql);
                    	String cmt = frame.textArea.getText();
                    	
                    	try {
                    		statement = conn.createStatement();
							resultSet = statement.executeQuery(sql);
							resultSet.next();
							if(resultSet.getRow() > 0){
									System.out.println("POSTIDOUT: "+resultSet.getString("POSTID"));
									resultFlag = true;
							}else{
								//PopUp: Not auth to comment.
								System.out.println("Not authorized to comment on this post");
								final PopUp popup =new PopUp(" Not authorized to comment on this post",1);
 				                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
 				                popup.setVisible(true);
 				                popup.btn1.addActionListener(new ActionListener() {
 				                    
 				                    public void actionPerformed(ActionEvent e) {
      				                    	popup.dispose();     				                       				                
 				                    }
 				                });
								
							}
						} catch (SQLException e1) {							
							e1.printStackTrace();
						}
                    	
                    	if(resultFlag){
                    		//Comment on post.
                    		try{
                    			statement = conn.createStatement();
                    			sql = "SELECT SEQ_CMNT.NEXTVAL FROM DUAL";
                    			resultSet = statement.executeQuery(sql);
                    			System.out.println("DEBUG-CMNT SQL: "+sql);
                    			resultSet.next();
                    			sequenceNumber = Integer.parseInt(resultSet.getString("NEXTVAL"));
                    			System.out.println("DEBUG-CMNT SEQ: "+sequenceNumber);
                			
                    			//SQL: INSERT INTO LEAVESCOMMENT.
                    			sql = "Insert into leavescomment (commentid, pid, mid, datetime, text) values("+sequenceNumber+", "+pid+", '"+loginPanel.getUserName()+"', CURRENT_TIMESTAMP,'"+cmt+"')";
                    			System.out.println("DEBUG-CMNT SQL: "+sql);
                    			statement.executeQuery(sql);
                    			frame.dispose();
                    			
                    			//PopUp: SUCCESS!
                    			final PopUp popup =new PopUp("SUCCESS! Comment posted!",1);
 				                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
 				                popup.setVisible(true);
 				                popup.btn1.addActionListener(new ActionListener() {
 				                    
 				                    public void actionPerformed(ActionEvent e) {
      				                    	popup.dispose();     				                       				                
 				                    }
 				                });
                    		}catch(SQLException se){
                    			se.printStackTrace();
                    		}
                    	}

                    }
                });
            }
        });
		
		buttonPanel.buttons[4].addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	/*Press this List all event Button, you should be able to list all available event*/
            	Statement statement = null;
            	ResultSet resultSet = null;
            	String sql = "select * from event where starttime > CURRENT_TIMESTAMP";
            	sqlPanel.SQLArea.setText(sql);
            	String res = "\nCURRENT EVENTS\n";
            	res += "=====================";
            	try{
            		  statement = conn.createStatement();
            		  resultSet = statement.executeQuery(sql);
            		  resultSet.next();
            		  if(resultSet.getRow() > 0){
            			  do{
            				  res += "\nEVENT TITLE: "+resultSet.getString("TITLE");
            				  res += "\nSTARTTIME: "+resultSet.getString("STARTTIME");
            				  res += "\nDURATION: "+resultSet.getString("DURATION");
            				  res += "\nDESCRIPTION: "+resultSet.getString("DESCRIPTION");            				  
            				  
            				  
            			  }while(resultSet.next());            		 
            			  }
            		  resultArea.setText(res);
            	}catch(SQLException se){
            		se.printStackTrace();
            	}
            	
            }
        });


		buttonPanel.buttons[5].addActionListener(new ActionListener() {
           
        public void actionPerformed(ActionEvent e) {
        	final Frame2 frame=new Frame2("Decline: ");
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);

            frame.btn1.addActionListener(new ActionListener() {
               
                public void actionPerformed(ActionEvent e) {
                	//TITLE: DELCINE FRIEND REQUEST.
                	/*Press this decline Button, you should be able to decline friend request*/
                	/*You could decline one at a time, or decline many at a time. e.g. using comma to separate each request*/
                	/*pop up a standard dialog box to show <succeed or failed>*/
                	Statement statement = null;
                	ResultSet resultSet = null;
                	String sql = "";
                	//SQL: REMOVE DECLINED USERS FROM REQUEST QUEUE.
                	String declinedUsers = frame.txtfield.getText();
                	for(String item : declinedUsers.split(",")){
                		System.out.println(item);
                		sql = "delete from fndrequest where emailid='"+item+"' and friendid='"+loginPanel.getUserName()+"'";
                		hasRequest -=1;
                		System.out.println(sql);
                		try{
                			statement = conn.createStatement();
                			statement.addBatch(sql);
                		}catch(SQLException se){
                			se.printStackTrace();
                		}                		
                	}
                	try {
						statement.executeBatch();
					} catch (SQLException e1) {					
						e1.printStackTrace();
					}
                	      frame.dispose();          	
                }
            });


            frame.btn2.addActionListener(new ActionListener() {
           
                public void actionPerformed(ActionEvent e) {
                	//TITLE: ACCEPT FRIEND REQUESTS.
                	/*Press this accept all Button, you should be able to accept all friend request and add this information into friend relationship table*/
                	/*pop up a standard dialog box to show <succeed or failed>*/
                	//SQL: ADD REQUEST QUEUE TO FRIENDSHIP LIST.
                	Statement statement = null;
                	ResultSet resultSet = null;
                	String sql = "";
                	
                	sql = "SELECT * FROM FNDREQUEST WHERE FRIENDID='"+loginPanel.getUserName()+"'";
                	System.out.println(sql);
                	try{
            			statement = conn.createStatement();
            			resultSet = statement.executeQuery(sql);
            			resultSet.next();
            		 
                       if(resultSet.getRow() > 0){
                    	   do{
                    		   String mailid = resultSet.getString("EMAILID");
                    		   sql = "insert into friendship (emailid, friendid, friendtype) values ('"+loginPanel.getUserName()+"','"+resultSet.getString("EMAILID")+"','"+resultSet.getString("FRIENDTYPE")+"')";
                    		   System.out.println(sql);
                    		   statement.executeQuery(sql);                    		   
                    		       
                    		  sql = "delete from fndrequest where emailid='"+mailid+"' and friendid='"+loginPanel.getUserName()+"'";
                    		   System.out.println(sql);
                    		   statement.executeQuery(sql);
                    		   hasRequest-=1;
                    	   }while(resultSet.next());
                		
                       }

                	}catch(SQLException se){
            			se.printStackTrace();
            		}     
                	System.out.println("hasRequests: "+hasRequest);
                	if(hasRequest == 0){
                		notifyButton.setVisible(false);
                	}
                	frame.dispose();
                }
            });

        }
		});

		buttonPanel.buttons[6].addActionListener(new ActionListener() {
         
            public void actionPerformed(ActionEvent e) {
            	/*Fill this function*/  
            	/*Press this Button, you should be able list the information(including address information) about your friend who live nearest to you*/
            	/*This is a spatial query*/
            	Statement statement = null;
            	ResultSet resultSet = null;
            	String res = "RESULT: \n";
            	String sql = "select g1.aid, mdsys.sdo_nn_distance(1) dist, m.email, m.fname, m.lname from members m, friendship f, livesin l, geoaddress g1"; 
            			 sql += " where l.aid = g1.aid and l.email = m.email and ((f.emailid = m.email and f.friendid='"+loginPanel.getUserName()+"')";
            					 sql += " or (f.friendid = m.email and f.emailid='"+loginPanel.getUserName()+"'))"; 
            							 sql += " and sdo_nn ( g1.geopoints, ( select g2.geopoints from geoaddress g2, livesin l2"; 
            									 sql += " where l2.email = '"+loginPanel.getUserName()+"' and l2.aid = g2.aid ),1 ) = 'TRUE' and ROWNUM = 1";
            	try{
            			statement = conn.createStatement();
            			resultSet = statement.executeQuery(sql);
            		    resultSet.next();            		    
            		    sqlPanel.SQLArea.setText(res);
            		    if(resultSet.getRow() > 0){
            		    	res = res + "\nEMAIL: "+resultSet.getString("EMAIL");
            		    	res = res + "\nAID:   "+resultSet.getString("AID");
            		    	res = res + "\nFNAME: "+resultSet.getString("FNAME");
            		    	res = res + "\nLNAME: "+resultSet.getString("LNAME");
            		    	int aid = Integer.parseInt(resultSet.getString("AID"));
            		    	sql = "select  a1.aid, a1.streetno, a1.streetname, a1.city,cf.state, cf.country from address a1, cityinfo cf where a1.aid='"+aid+"' and a1.city=cf.city";
            		    	resultSet = statement.executeQuery(sql);
            		    	resultSet.next();
            		    	res = res + "\nSTREETNO: "+resultSet.getString("STREETNO");
            		    	res = res + "\nSTREETNAME: "+resultSet.getString("STREETNAME");
            		    	res = res + "\nCITY: "+resultSet.getString("CITY");
            		    	res = res + "\nSTATE: "+resultSet.getString("STATE");
            		    	res = res + "\nCOUNTRY: "+resultSet.getString("COUNTRY");   
            		    	System.out.println(res);
            		    	
            		    	resultArea.setText(res);
            		    }else{
            		    	System.out.println("ERRROR!");
            		    }
            		}catch(SQLException se){
            			se.printStackTrace();
            		}
            	
            }
        });
		buttonPanel.buttons[7].addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
            	final Frame3 frame=new Frame3("Please input coordinate: ");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);

                frame.btn1.addActionListener(new ActionListener() {
                  
                    public void actionPerformed(ActionEvent e) {
                    	/*Fill this function*/
                    	/*Press this Button, input left top corner coordinate and right down corner coordinate*/ 
                    	/*press ok, you should be able list the information(including address information) about your friend who lives in this area. Close query window*/
                    	/*This is a spatial query*/
                    	int a = Integer.parseInt(frame.txtfield[0].getText());
                    	int b = Integer.parseInt(frame.txtfield[1].getText());
                    	int c = Integer.parseInt(frame.txtfield[2].getText());
                    	int d = Integer.parseInt(frame.txtfield[3].getText());
                    	
                    	Statement statement = null;
                    	ResultSet resultSet, resultSet1 = null;
                    	String res = "RESULT: \n";
                    	/*
                    	 * String query = "select m.email, m.fname, m.lname, a1.id,a1.streetno, a1.streetaddr, a1.city "+ " from member m, address a1, livesin l, friendship f "+ " 
                    	 * where m.email = l.memberid "+ " and l.addressid = a1.id " + " and sdo_inside( a1.latlong, sdo_geometry (2003, null, null, sdo_elem_info_array(1,1003,3), 
                    	 * sdo_ordinate_array("+x1+","+y1+","+x2+","+y2+")))='TRUE' "+ " and ((f.user1 = m.email and f.user2 = 'angelina@csci585.edu <mailto:angelina@csci585.edu>') 
                    	 * or (f.user2 = m.email and f.user1 = '"+username+"')) ";
                    	 */
                    	String sql = "select m.email, m.fname, m.lname, a1.aid"; 
                    			 sql += " from members m, geoaddress a1, livesin l, friendship f where m.email = l.email";
                    			 sql += " and l.aid = a1.aid and sdo_inside( a1.geopoints, sdo_geometry (2003, null, null, sdo_elem_info_array(1,1003,3),";
                    			 sql += " sdo_ordinate_array("+a+","+b+","+c+","+d+")))='TRUE' and ((f.emailid = m.email and f.friendid = '"+loginPanel.getUserName()+"')"; 
                    			 sql += " or (f.friendid = m.email and f.emailid = '"+loginPanel.getUserName()+"'))";
                    			 
                    			 sqlPanel.SQLArea.setText(sql);
                    			 try{
                         			statement = conn.createStatement();
                         			resultSet = statement.executeQuery(sql);
                         		    resultSet.next();            		    
                         		    sqlPanel.SQLArea.setText(res);
                         		    if(resultSet.getRow() > 0){
                         		    	do{
                         		    	res = res + "\nEMAIL: "+resultSet.getString("EMAIL");
                         		    	res = res + "\nAID:   "+resultSet.getString("AID");
                         		    	res = res + "\nFNAME: "+resultSet.getString("FNAME");
                         		    	res = res + "\nLNAME: "+resultSet.getString("LNAME");
                         		    	int aid = Integer.parseInt(resultSet.getString("AID"));
                         		    	sql = "select  a1.aid, a1.streetno, a1.streetname, a1.city,cf.state, cf.country from address a1, cityinfo cf where a1.aid='"+aid+"' and a1.city=cf.city";
                         		    	resultSet1 = statement.executeQuery(sql);
                         		    	resultSet1.next();
                         		    	res = res + "\nSTREETNO: "+resultSet1.getString("STREETNO");
                         		    	res = res + "\nSTREETNAME: "+resultSet1.getString("STREETNAME");
                         		    	res = res + "\nCITY: "+resultSet1.getString("CITY");
                         		    	res = res + "\nSTATE: "+resultSet1.getString("STATE");
                         		    	res = res + "\nCOUNTRY: "+resultSet1.getString("COUNTRY");
                         		    	}while(resultSet.next());
                         		    	System.out.println(res);
                         		    	resultArea.setText(res);
                         		    	
                         		    	
                         		    }else{
                         		    	
                         		    	System.out.println("SPATIAL NULL! ERRROR!");
                         		    }
                         		}catch(SQLException se){
                         			se.printStackTrace();
                         		}
                    	
                    	
                    }
                });
            }
        });
		
	}

	public void setPostandSearchPanel(){
		postandsearch = new PostandSearchPanel();
		this.add(postandsearch);
		final StringBuffer result= new StringBuffer();


		postandsearch.buttons[0].addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) { 
            	//TITLE: CREATE A POST.
            	/*Press this Button, you should be able post the information written in the textArea*/
            	/*pop up a standard dialog box to show <succeed or failed>*/
            	String postText = postandsearch.textArea.getText();
            	Statement statement = null;
            	ResultSet resultSet = null;
            	String sql = null;
            	int sequenceNumber = 0;
            	//SQL: TO RETURN SEQVAL AND USE IT.
            	try {
        			statement = conn.createStatement();
        			sql = "SELECT SEQ_POST.NEXTVAL FROM DUAL";
        			resultSet = statement.executeQuery(sql);
        			System.out.println("DEBUG-SPOSTSRC SQL: "+sql);
        			resultSet.next();
        			sequenceNumber = Integer.parseInt(resultSet.getString("NEXTVAL"));
        			System.out.println("DEBUG-SPOSTSRC SEQ: "+sequenceNumber);
        			
        			//SQL: INSERT INTO ISSUESPOST.
        			sql = "Insert into issuespost (postid, sender) values("+sequenceNumber+", '"+loginPanel.getUserName()+"')";
        			System.out.println("DEBUG-SPOSTSRC SQL: "+sql);
        			statement.executeQuery(sql);
        			
        			//SQL: INSERT INTO POST.
        			sql = "Insert into post (postid, datetime, note, privacylevel) values("+sequenceNumber+", CURRENT_TIMESTAMP, '"+postText+"', 0)";
        			System.out.println("DEBUG-SPOSTSRC SQL: "+sql);
        			statement.executeQuery(sql);
        			//PopUp: Sucess posting.
        			final PopUp popup =new PopUp("SUCESS! Posted on wall!",1);
		                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		                popup.setVisible(true);
		                popup.btn1.addActionListener(new ActionListener() {
		                    
		                    public void actionPerformed(ActionEvent e) {
			                    	popup.dispose();     				                       				                
		                    }
		                });
            	}catch(SQLException se){
            		final PopUp popup =new PopUp(" FAILURE! Could not post on wall!",1);
		                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		                popup.setVisible(true);
		                popup.btn1.addActionListener(new ActionListener() {
		                    
		                    public void actionPerformed(ActionEvent e) {
			                    	popup.dispose();     				                       				                
		                    }
		                });
            		se.printStackTrace();
            	}
            	
            	
            	
            	
            	
            	
            	
            	
            }
        });


		postandsearch.buttons[1].addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {  
            	//TITLE: SEARCH FND FUNCTION.
            	/*Press this Button, you should be able search user information, list the information on the result panel*/
            	/*The search should based on email, first name or last name*/
            	//TODO: Fname, Lname SQL Implementation.Full SQL thing.
            	Statement statement = null;
            	ResultSet resultSet = null;
            	String sql = null;
            	String res = "RESULT: \n";
            	result.append(res);
            	String searchText = postandsearch.text.getText();
            	if(searchText.isEmpty()){
            		//PopUp: empty field.
            		System.out.println("Empty field not allowed");
            		final PopUp popup =new PopUp(" Empty field not allowed in search function",1);
		                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		                popup.setVisible(true);
		                popup.btn1.addActionListener(new ActionListener() {
		                    
		                    public void actionPerformed(ActionEvent e) {
			                    	popup.dispose();     				                       				                
		                    }
		                });
            		
            	}else{            		
            		System.out.println("DEBUG-SFORFND: "+ searchText);
            		try {
            			statement = conn.createStatement();
            			sql = "select m1.email, m1.fname, m1.lname, ad.streetno, ad.streetname, ad.city, ct.state, ct.country from members m1,livesin lv, address ad, cityinfo ct, (select m.email from members m, friendship f where ((f.friendid=m.email and f.emailid='"+loginPanel.getUserName()+"') or (f.friendid='"+loginPanel.getUserName()+"' and f.emailid=m.email))and (lower(m.fname) like '%"+searchText+"%' or lower(m.lname) like '%"+searchText+"%' or lower (m.email) like '%"+searchText+"%')  ) frnds where m1.email= frnds.email and m1.email=lv.email and lv.aid=ad.aid and ad.city=ct.city";
            			System.out.println("DEBUG-SFORFND SQL: "+sql);
            			resultSet = statement.executeQuery(sql);
            			sqlPanel.SQLArea.setText(sql);
            			resultSet.next();
            			System.out.println("ROW: "+ resultSet.getRow());
            			if(resultSet.getRow() > 0){
            				do{
            					System.out.println("DEBUG-SFORFND: "+resultSet.getString("EMAIL"));
            					res = res + "\nEMAIL: "+resultSet.getString("EMAIL");
            					res = res + "\nFNAME: "+resultSet.getString("FNAME");
            					res = res + "\nLNAME: "+resultSet.getString("LNAME");
            					res = res + "\nSTREETNO: "+resultSet.getString("STREETNO");
            					res = res + "\nSTNAME: "+resultSet.getString("STREETNAME");
            					res = res + "\nCITY: "+resultSet.getString("CITY");
            					res = res + "\nSTATE: "+resultSet.getString("STATE");
            					res = res + "\nCOUNTRY: "+resultSet.getString("COUNTRY");
            					res = res + "\n=========================================================\n";
            				}while(resultSet.next());
            			}
            		}catch(SQLException se){
            			se.printStackTrace();
            		}
            		System.out.println(result);
            		resultArea.setText(res);
            		}
            	}
        	});
		}
	public void setSQLOutput(StringBuffer sb)
	{
		sqlPanel.SQLArea.setText(sb.toString());
		sqlPanel.SQLArea.setEnabled(true);
	}
	public void setSqlPanel(){
		sqlPanel = new SqlPanel();
		this.add(sqlPanel);
		showLabel = new JLabel("The corresponding SQL :");
		showLabel.setBounds(20, 470, 200, 20);
		this.add(showLabel);
	}

	public void setLoginPanel(){
		loginPanel = new LoginPanel();
		this.add(loginPanel);

		loginPanel.signup.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
		        signUpPanel.enablePanel();
		        
		        
		        
		        
		        
			}
        });
        loginPanel.login.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {  
            	//TITLE LOGIN AUTHENTICATION.
            	/*Press this Button, you should be able match the user information. If valid, keep the user email information(but can't modified) and clear the password*/
            	
            	/*
            	 * 1. Login: Check username exists x
            	 * 2. Login: Check password matches, setusername x
            	 * 3. Login: If matches disable login, sign up and give logout label. x
            	 */
            	String user = loginPanel.username.getText();
            	char[] pwd = loginPanel.password.getPassword();
            	Statement statement = null;
            	String sql = null;
            	ResultSet resultSet = null;
            	boolean signedOn = false;
            	
            	
                
                if(loginPanel.signedOn){
                	loginPanel.login.setText("Login");
                	loginPanel.password.setText("");
                	loginPanel.username.setText("");
                	LoginPanel.signedOn = false;
                	System.out.println("DEBUG: Logged Out...");
                	//Disable all newly enabled panels.
                	
                	notifyButton.setVisible(false);
                	sqlPanel.SQLArea.setText("");
                	postandsearch.textArea.setText("");
                	resultArea.setText("");
                	
                	sqlPanel.disablePanel();
					buttonPanel.disablePanel();
					postandsearch.disablePanel();
					loginPanel.signup.setEnabled(true);
					loginPanel.username.setEditable(true);
					
					
                	
                }else{
                		System.out.println("DEBUG-LOGIN: Login Authentication...");
                		try {
                				statement = conn.createStatement();
                				System.out.println("DEBUG: CreateStatement After!");
                		} catch (SQLException e1) {
                			e1.printStackTrace();
                		}
                
                		sql = "SELECT EMAIL, PASSWORD FROM MEMBERS WHERE EMAIL='"+user+"'";
                		System.out.println("DEBUG_SQL: "+ sql);
               
                		try {
                				resultSet = statement.executeQuery(sql);
                				resultSet.next();
                				int rows = resultSet.getRow();
                				if(rows == 0){
                					System.out.println("DEBUG-LOGIN: No username exists!Would you like to sign up?");  
                					 signUpPanel.enablePanel();
                					 
                					//PopUp: No user exists
                					 final PopUp popup =new PopUp("Username does not exists!Would you like to sign up?",1);
     				                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
     				                popup.setVisible(true);
     				                popup.btn1.addActionListener(new ActionListener() {
     				                    
     				                    public void actionPerformed(ActionEvent e) {
     				                    	String temp = loginPanel.username.getText();
     				                    	loginPanel.password.setText("");
     				                    	popup.dispose();
     				                    	signUpPanel.email.setText(temp);
     				                    	
     				                    }
     				                });
                					 
                				}else{
                					System.out.println("DEBUG: username exists!!!");
                					char[] tempPass = resultSet.getString("PASSWORD").toCharArray();
                					boolean match = Arrays.equals(pwd,tempPass);
                					if(match){
                								System.out.println("DEBUG: Password Matches!");
                								loginPanel.setUserName(user);											
                								pwd = null;
                								loginPanel.signedOn = true;
                								loginPanel.login.setText("Logout");                							
                								
                								Statement fndStat = conn.createStatement();                	
                								sql = "select count(*) as cnt from fndrequest where friendid='"+loginPanel.getUserName()+"' group by friendid";                								                								
                								ResultSet res = fndStat.executeQuery(sql);                								
                								res.next();
                								if(res.getRow() > 0){
                									String num = res.getString("CNT");
                									hasRequest = Integer.parseInt(num);
                								}
                								
                								if(hasRequest > 0){
                									notifyButton.setVisible(true);	
                								}
                								
                								
                							
                								sqlPanel.enablePanel();
                								buttonPanel.enablePanel();
                								postandsearch.enablePanel();
                								loginPanel.username.setEditable(false);
                								loginPanel.signup.setEnabled(false);
                								signUpPanel.disablePanel();
                								sqlPanel.SQLArea.append(sql);
                								//resultPanel.enable();    what ???
                								
                								//PopUp: Logged In
                								final PopUp popup =new PopUp("SUCCESS! Logged In!",1);
                				                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                				                popup.setVisible(true);
                				                
                				                popup.btn1.addActionListener(new ActionListener() {
                				                    
                				                    public void actionPerformed(ActionEvent e) {
                				                    	loginPanel.password.setText("");
                				                    	popup.dispose();
                				                    	
                				                    }
                				                });
                								
								
                							}else{
                								System.out.println("DEBUG: ERROR!Password is incorrect!");                					
                								//PopUp: Incorrect Password.
                								final PopUp popup =new PopUp("Password is incorrect!",1);
                				                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                				                popup.setVisible(true);
                				                popup.btn1.addActionListener(new ActionListener() {
                				                    
                				                    public void actionPerformed(ActionEvent e) {
                				                    	loginPanel.password.setText("");
                				                    	
                				                    	popup.dispose();
                				                    	
                				                    }
                				                });
                				                
                							}
                				}
                			} catch (SQLException e1) {
                					e1.printStackTrace();
                				}
                		}
            	
            	
            	System.out.println(loginPanel.getUserName());
            	
            	/*at the same time, you should scan the friend request table, to determine whether current logged in user has friend request, if has, set notification icon*/
            	/*If invalid, you should pop up a dialog box to notify user, then enable signup panel for user to register*/
            	/*After logged in, you should change this button's function as logout which means disable all the panel, return to the original state*/
            }

           });
   

	}

	public void setSignupPanel(){

		signUpPanel = new SignupPanel();
		this.add(signUpPanel);
		signUpPanel.signup.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {  
            	//TITLE: SIGNUP PANEL.
            	/*Press this signup button, you should be able check whether current account is existed. If existed, pop up an error, if not check input validation(You can design this part according to your database table's restriction) create the new account information*/
            	/*pop up a standard dialog box to show <succeed or failed>*/
            	
		       //Get all field info
		        String email = signUpPanel.email.getText();
		        char[] password = signUpPanel.password.getPassword();
		        char[] password2 = signUpPanel.password2.getPassword();
		        String fname = signUpPanel.fname.getText();
		        String lname = signUpPanel.lname.getText();		        
		        String strNo = signUpPanel.str_no.getText();
		        
		        String strAddress = signUpPanel.str_address.getText();
		        String city =  signUpPanel.city.getText();
		        String zip = signUpPanel.zip.getText();
		        String birthday = signUpPanel.birthday.getText();
		        
		        boolean clearedForInsert = true;
		        
		        int intStrNo = 0;
		        int zipCode = 0;
		        
		        Date bday, after, before;
		        
		        Statement statement = null;
		        ResultSet resultSet = null;
		        System.out.println("DEBUG: In signup panel.");
		        String sql = "SELECT EMAIL, PASSWORD FROM MEMBERS WHERE EMAIL='"+email+"'";	
		        System.out.println(sql);		        		        
		        try {
						statement = conn.createStatement();
						resultSet = statement.executeQuery(sql);
						resultSet.next();
						
						
						if(resultSet.getRow() > 0 && clearedForInsert){
        					System.out.println("DEBUG-SIGNUP: Username Exists. Use a different email.");  
        					 signUpPanel.enablePanel();
        					 signUpPanel.email.setText("");
        					 clearedForInsert = false;
        					//PopUp: user exists. use different one.
        					 final PopUp popup =new PopUp("Username Exists. Use a different email.!",1);
				                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				                popup.setVisible(true);
				                popup.btn1.addActionListener(new ActionListener() {
				                    
				                    public void actionPerformed(ActionEvent e) {				               
				                    	popup.dispose();
				                    	
				                    }
				                });
						}
						else if(email.isEmpty()){
							System.out.println("DEBUG-SIGNUP: Username UNsafe!.");
							clearedForInsert = false;
							final PopUp popup =new PopUp("Username can't be empty!",1);
			                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			                popup.setVisible(true);
			                popup.btn1.addActionListener(new ActionListener() {
			                    
			                    public void actionPerformed(ActionEvent e) {				               
			                    	popup.dispose();
			                    	
			                    }
			                });
						}else{
							System.out.println("DEBUG-SIGNUP: Username safe!.");
						}
						
						if(password.length == 0 && clearedForInsert){
							System.out.println("DEBUG-SIGNUP: passwords fields can't be empty!.");
							clearedForInsert = false;
							final PopUp popup =new PopUp("Password's fields can't be empty!",1);
			                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			                popup.setVisible(true);
			                popup.btn1.addActionListener(new ActionListener() {
			                    
			                    public void actionPerformed(ActionEvent e) {				               
			                    	popup.dispose();
			                    	
			                    }
			                });
						}
						
						if((Arrays.equals(password,password2) == true) && clearedForInsert){
							System.out.println("DEBUG-SIGNUP: passwords are matching!.");
						}else if(clearedForInsert){
							System.out.println("DEBUG-SIGNUP: Passwords Don't Match.");
							//PopUp: Pwd dont match.
							final PopUp popup =new PopUp("Passwords Don't match!",1);
			                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			                popup.setVisible(true);
			                popup.btn1.addActionListener(new ActionListener() {
			                    
			                    public void actionPerformed(ActionEvent e) {				               
			                    	popup.dispose();
			                    	
			                    }
			                });
							signUpPanel.password.setText("");
							signUpPanel.password2.setText("");
							clearedForInsert = false;
						}
						
						if(clearedForInsert){
							try{
								intStrNo = Integer.parseInt(strNo);
							}catch(NumberFormatException e1){
								System.out.println("DEBUG-SIGNUP: Street Number is not a number or bad format.");
								clearedForInsert = false;
								signUpPanel.str_no.setText("");
							//PopUp: Number bad format.
								final PopUp popup =new PopUp("Street Number is not a number or bad format!",1);
				                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				                popup.setVisible(true);
				                popup.btn1.addActionListener(new ActionListener() {
				                    
				                    public void actionPerformed(ActionEvent e) {				               
				                    	popup.dispose();
				                    	
				                    }
				                });
							}
						}
						
						
						if(clearedForInsert){
							
							SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
							sdf.setLenient(false);
							
							try {
								after = sdf.parse("01/01/1888");
								before = sdf.parse("11/08/2013");
								sdf.setLenient(false);		
								bday = (Date) sdf.parse(birthday);
								
								if(bday.after(after) && bday.before(before)){
									//System.out.println(bday.
									System.out.println("DEBUG-SIGNUP: Date Verified!!");
								}else{
									clearedForInsert = false;
									System.out.println("DEBUG-SIGNUP: Date not of proper format or out of range.");
									//PopUp: Date format wrong.
									final PopUp popup =new PopUp("Date not of proper format or out of range!",1);
					                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					                popup.setVisible(true);
					                popup.btn1.addActionListener(new ActionListener() {
					                    
					                    public void actionPerformed(ActionEvent e) {				               
					                    	popup.dispose();
					                    	
					                    }
					                });
									
								}
							} catch (ParseException e1) {
								System.out.println("DEBUG-SIGNUP: ERROR! Date not of proper format.");
								clearedForInsert = false;
								final PopUp popup =new PopUp("Date not of proper format!",1);
				                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				                popup.setVisible(true);
				                popup.btn1.addActionListener(new ActionListener() {
				                    
				                    public void actionPerformed(ActionEvent e) {				               
				                    	popup.dispose();
				                    	
				                    }
				                });
							}
							
							if(clearedForInsert){
								try{
									zipCode = Integer.parseInt(zip);
								}catch(NumberFormatException e1){
									System.out.println("DEBUG-SIGNUP: ZipCode is not a number or bad format.");
									clearedForInsert = false;
									signUpPanel.str_no.setText("");
								//PopUp: ZipCode.
									final PopUp popup =new PopUp("ZipCode is not a number or bad format!",1);
					                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					                popup.setVisible(true);
					                popup.btn1.addActionListener(new ActionListener() {
					                    
					                    public void actionPerformed(ActionEvent e) {				               
					                    	popup.dispose();
					                    	
					                    }
					                });
								}
							}
							
							
							
							
							
						}
						
						if((email.isEmpty() || fname.isEmpty() || lname.isEmpty() || strNo.isEmpty() || strAddress.isEmpty() || city.isEmpty() || zip.isEmpty() || birthday.isEmpty()) && clearedForInsert){
							System.out.println("DEBUG-SIGNUP: NULL VALUES FOUND. FEILDS CAN'T BE EMPTY");
							//TODOD: JFrame PopUp.
							final PopUp popup =new PopUp("FIELDS CAN'T BE EMPTY!",1);
			                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			                popup.setVisible(true);
			                popup.btn1.addActionListener(new ActionListener() {
			                    
			                    public void actionPerformed(ActionEvent e) {				               
			                    	popup.dispose();
			                    	
			                    }
			                });
							clearedForInsert = false;
						}
						
						
						System.out.println(email);
						System.out.println(password);
						System.out.println(fname);
						System.out.println(lname);
						System.out.println(intStrNo);
						System.out.println(strAddress);
						System.out.println(city);
						System.out.println(zip);
						System.out.println(birthday);
						int aid = 1;
						String pwd = new String(password);
						if(clearedForInsert){
							statement = conn.createStatement();
							    String query = "insert into members (email, fname, lname, password, birthday) values('"
							            + email + "','" + fname + "','"+ lname +"','"+ pwd +"',TO_DATE('"+ birthday +"','MM-DD-YYYY'))";
							    System.out.println(query);
							    statement.addBatch(query);
							    //statement.execute(query);
							    query = "insert into livesin (email, aid) values('"
							            + email + "','" + aid +"')";
							    statement.addBatch(query);
							    //statement.execute(query);
							    
							statement.executeBatch();
							statement.close();
							
							signUpPanel.email.setText("");
							signUpPanel.fname.setText("");
							signUpPanel.lname.setText("");
							signUpPanel.password.setText("");
							signUpPanel.password2.setText("");
							signUpPanel.birthday.setText("");
							signUpPanel.city.setText("");
							signUpPanel.str_no.setText("");
							signUpPanel.str_address.setText("");
							signUpPanel.zip.setText("");
							final PopUp popup =new PopUp("Congrats! You have been signed in!",1);
			                popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			                popup.setVisible(true);
			                popup.btn1.addActionListener(new ActionListener() {
			                    
			                    public void actionPerformed(ActionEvent e) {				               
			                    	popup.dispose();
			                    	
			                    }
			                });
						}
						
						
					} catch (SQLException e1) {					
					e1.printStackTrace();
				}
		        
            	
            	
            }
        });

		signUpPanel.disablePanel();

	}


}


class ConnectDB{

	public static Connection openConnection(){
       
		//HARSHA: Connectiion on/off.
		Connection conn = null;
		String URL = "jdbc:oracle:thin:harsha/qwerty@localhost:1521:orcl1";
		try {
				conn = DriverManager.getConnection(URL);
			System.out.println("Connection Successful!");
		} catch (SQLException e) {		
			System.out.println("ERROR opening DB");
			e.printStackTrace();
		}
		
    
		return conn;
	}
	public static void closeConnection(Connection conn)
	{
		
		try {
			conn.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}

	}
}
public class Assignment2 {
	/**
	 * @param args
	 * @throws SQLException 
	 */
	
	static Connection conn;
	
	public static void main(String[] args) throws SQLException {
    	MainFrame frame = new MainFrame();
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	conn = ConnectDB.openConnection();
    	MainFrame.conn = conn; 
    	/*TEST CODE ONY!!!!!/////////////////////////////////////////
    	 //STEP 1: Execute a query
        System.out.println("Creating statement...");
        Statement stmt = null;
        ResultSet rs = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//STEP 2: Create and Execute SQL Statement.
        String sql;
        sql = "SELECT CITY, STATE FROM CITYINFO";
        try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        //STEP 3: Parse Result.
        while(rs.next()){
            //Retrieve by column name
           
            String first = rs.getString("city");
            String last = rs.getString("state");

            //Display values
            System.out.print("City: " + first);
            System.out.println("          State: " + last);
         }
         //STEP 4: Clean-up environment.
         rs.close();
         stmt.close();
    	*//////////////////////////////////////////////////////////////
    	//ConnectDB.closeConnection(conn);
    	
    	
	}
}
