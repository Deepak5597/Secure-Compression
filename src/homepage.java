import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import java.awt.List;
import java.awt.Choice;
import javax.swing.JTextArea;


public class homepage{

	private JFrame frame;
	String file_path="";
	String dir="";
	String cName="";
	JPanel homepage = new JPanel();
	JPanel newuser = new JPanel();
	JPanel olduser = new JPanel();
	JPanel main = new JPanel();
	JPanel change_password = new JPanel();
	JPanel file_choosing = new JPanel();
	private JTextField name_field;
	private JPasswordField enter_password_field;
	private JPasswordField reenter_password_field;
	private JPasswordField enter_password;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField file_name_field;
    String user_name_string;
	//labels start
    JLabel old_status = new JLabel("");
	JLabel error1 = new JLabel("Something Wrong \nHappened");
	JLabel enterpassword = new JLabel("Enter Pasword");
	JLabel reenterpassword = new JLabel("Re-Enter Password");
	JLabel status = new JLabel("");
	JLabel error7 = new JLabel("Incorrect Password");
	JLabel user_name = new JLabel("User  name");
	JLabel change_password_status = new JLabel("");
	JLabel error_label = new JLabel("Something went wrong");
	JButton DirectoryTryAgain = new JButton("Try again");
	private JTextField CompressionName;
	JLabel TextDirectoryAlreadyExist = new JLabel("Directory already exist ");
	JLabel print_compression_ratio = new JLabel("?\r\n");
	JPanel ratio_showing = new JPanel();
	JPanel view_files = new JPanel();
	JTextArea text_data = new JTextArea();
//	JScrollPane scroll=new JScrollPane(text_data);

//labels ends
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage window = new homepage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public homepage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 360, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		Image img1=new ImageIcon(this.getClass().getResource("/raw/gonew.png")).getImage();
		homepage.setBackground(new Color(0, 0, 128));
		homepage.setForeground(new Color(240, 248, 255));

	    
		frame.getContentPane().add(homepage, "name_481459934571363");
		homepage.setLayout(null);
	    final Image error_image=new ImageIcon(this.getClass().getResource("/raw/incorrect.png")).getImage();
		Image img=new ImageIcon(this.getClass().getResource("/raw/mls.png")).getImage();
		Image img3=new ImageIcon(this.getClass().getResource("/raw/passwordbox.jpg")).getImage();
		Image img4=new ImageIcon(this.getClass().getResource("/raw/correct.png")).getImage();
		Image img5=new ImageIcon(this.getClass().getResource("/raw/compress.png")).getImage();
		Image img6=new ImageIcon(this.getClass().getResource("/raw/view.png")).getImage();
		Image img7=new ImageIcon(this.getClass().getResource("/raw/changepassword.png")).getImage();
		Image img8=new ImageIcon(this.getClass().getResource("/raw/logout.png")).getImage();
		Image img9=new ImageIcon(this.getClass().getResource("/raw/oldpasswordbox.jpg")).getImage();
		Image img10=new ImageIcon(this.getClass().getResource("/raw/goicon.png")).getImage();
		JLabel go_button = new JLabel("");
		go_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File f=new File("C://compression//password.txt");
				if(f.exists()){
					try{
						user_name_string=new String(Files.readAllBytes(Paths.get("C://compression//name.txt")));
					/*BufferedReader br=new BufferedReader(new FileReader("C://compression//name.txt"));
						while((br.readLine())!=null){
							
							user_name_string.append(br.readLine());
							System.out.println(user_name_string);
						}*/
						user_name.setText(user_name_string);
					}catch(Exception e2)
					{
						e2.printStackTrace();
					}
					homepage.setVisible(false);
					olduser.setVisible(true);
					error7.setVisible(false);
				}
				else{
					try {
						File f1=new File("C://compression");
						File f2=new File("C://compression//name.txt");
						f1.mkdir();
						f.createNewFile();
						homepage.setVisible(false);
						newuser.setVisible(true);
						error1.setVisible(false);
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		go_button.setBounds(74, 283, 189, 49);
		go_button.setIcon(new ImageIcon(img1));
		homepage.add(go_button);
		
		JLabel main_image = new JLabel("");
		main_image.setBounds(22, 64, 300, 251);
		main_image.setVerticalAlignment(SwingConstants.BOTTOM);
		homepage.add(main_image);

		main_image.setIcon(new ImageIcon(img));
		
		JLabel titlebar = new JLabel("        Welcome to Secure Compression");
		titlebar.setForeground(new Color(255, 255, 255));
		titlebar.setFont(new Font("Tahoma", Font.BOLD, 16));
		titlebar.setBounds(0, 0, 390, 48);
		homepage.add(titlebar);
		
		
		newuser.setBackground(new Color(0, 0, 128));
		frame.getContentPane().add(newuser, "name_484220144900456");
		newuser.setLayout(null);
		//status label starts
		status.setBounds(38, 11, 66, 76);
		status.setIcon(new ImageIcon(img4));
		newuser.add(status);
	//status label ends	
		//error1 label start
		error1.setHorizontalAlignment(SwingConstants.CENTER);
		error1.setFont(new Font("Tahoma", Font.BOLD, 11));
		error1.setForeground(Color.RED);
		error1.setBackground(Color.WHITE);
		error1.setBounds(121, 11, 181, 20);
		newuser.add(error1);
		//error2 label ends
		JLabel name = new JLabel("Enter Your Name");
		name.setFont(new Font("Tahoma", Font.BOLD, 11));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(131, 73, 126, 14);
		newuser.add(name);
		
		name_field = new JTextField();
		name_field.setBounds(124, 92, 133, 20);
		newuser.add(name_field);
		name_field.setColumns(10);
		
	//enter password label starts	
		
		enterpassword.setHorizontalAlignment(SwingConstants.CENTER);
		enterpassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		enterpassword.setBounds(100, 165, 133, 14);
		newuser.add(enterpassword);
		
		enter_password_field = new JPasswordField();
		enter_password_field.setText("");
		enter_password_field.setBounds(100, 184, 124, 20);
		newuser.add(enter_password_field);
		//enter password label ends		
		
		//re-enter password label starts	
		
		reenterpassword.setHorizontalAlignment(SwingConstants.CENTER);
		reenterpassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		reenterpassword.setBounds(124, 253, 133, 14);
		newuser.add(reenterpassword);
		
		reenter_password_field = new JPasswordField();
		reenter_password_field.setBounds(124, 272, 133, 20);
		newuser.add(reenter_password_field);
		//re-enter password label ends	
		JLabel passwordbox = new JLabel("");
		passwordbox.setBounds(0, 0, 345, 311);
		newuser.add(passwordbox);
		
		passwordbox.setIcon(new ImageIcon(img3));
		
		JLabel setpassword = new JLabel("Set Password");
		setpassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//check password
	            String user=name_field.getText().toString();		
				String pass1=enter_password_field.getText().toString();
				String pass2=reenter_password_field.getText().toString(); 
				if(!((pass1.equals(""))||(pass2.equals("")))){
					if(pass1.equals(pass2)){
						try{
							BufferedWriter bw=new BufferedWriter(new FileWriter("C://compression//password.txt"));
							bw.write(pass1);
							bw.close();
							BufferedWriter bw1=new BufferedWriter(new FileWriter("C://compression//name.txt"));
							bw1.write(user);
							bw1.close();
						}catch(Exception e1){
							System.out.println(e1); 
						}
					main.setVisible(true);
					newuser.setVisible(false);					
				}	
 					else{
						newuser.setVisible(true);
						main.setVisible(false);
						status.setIcon(new ImageIcon(error_image));
						error1.setText("Password didn't match.");
						error1.setVisible(true);
					}
				}
				else{
					newuser.setVisible(true);
					main.setVisible(false);
					status.setIcon(new ImageIcon(error_image));
					error1.setText("Some Field is Empty");
					error1.setVisible(true);
				}
			}
		});
		
		setpassword.setHorizontalAlignment(SwingConstants.CENTER);
		setpassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		setpassword.setForeground(Color.WHITE);
		setpassword.setBounds(0, 311, 345, 50);
		newuser.add(setpassword);
		//old user panel
		frame.getContentPane().add(olduser, "name_484260837710882");

		olduser.setLayout(null);
		error7.setHorizontalAlignment(SwingConstants.CENTER);
		
		//eror7 label start
		error7.setFont(new Font("Tahoma", Font.BOLD, 14));
		error7.setForeground(Color.RED);
		error7.setBounds(107, 40, 210, 26);
		olduser.add(error7);
		
		
		user_name.setHorizontalAlignment(SwingConstants.CENTER);
		user_name.setForeground(Color.BLUE);
		user_name.setFont(new Font("Tahoma", Font.BOLD, 14));
		user_name.setBounds(125, 145, 134, 26);
		olduser.add(user_name);
		//error7 label ends
		JLabel enter_password_label = new JLabel("Enter Password");
		enter_password_label.setFont(new Font("Tahoma", Font.BOLD, 11));
		enter_password_label.setHorizontalAlignment(SwingConstants.CENTER);
		enter_password_label.setBounds(99, 222, 120, 14);
		olduser.add(enter_password_label);
		
		enter_password = new JPasswordField();
		enter_password.setBounds(97, 239, 131, 20);
		olduser.add(enter_password);
		
		JLabel error3 = new JLabel("Welcome");
		error3.setHorizontalAlignment(SwingConstants.CENTER);
		error3.setFont(new Font("Tahoma", Font.BOLD, 11));
		error3.setBounds(125, 120, 134, 26);
		olduser.add(error3);
		
		
		old_status.setBounds(34, 62, 63, 77);
		old_status.setIcon(new ImageIcon(img4));
		olduser.add(old_status);
		
		JLabel oldbox = new JLabel("");
		oldbox.setBounds(0, 0, 344, 305);
		olduser.add(oldbox);
		oldbox.setIcon(new ImageIcon(img9));
		
		JButton btnReadyToGo = new JButton("Ready To Go");
		btnReadyToGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		     String hh=enter_password.getText();
		     if(!(hh.equals(""))){
		     try {
				String hh1=new String(Files.readAllBytes(Paths.get("C://compression//password.txt")));
				if(hh.equals(hh1)){
					newuser.setVisible(false);
					main.setVisible(true);
					olduser.setVisible(false);
				}
				else
				{
					old_status.setIcon(new ImageIcon(error_image));
					error7.setText("Incorrect Password");
					error7.setVisible(true);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
		     else{
		    	    old_status.setIcon(new ImageIcon(error_image));
					error7.setText("Some field is empty.");
					error7.setVisible(true);
		     }
			}
		});
		btnReadyToGo.setForeground(Color.GRAY);
		btnReadyToGo.setBackground(new Color(0, 0, 128));
		btnReadyToGo.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReadyToGo.setBounds(89, 300, 155, 39);
		olduser.add(btnReadyToGo);
	
		change_password.setForeground(new Color(255, 255, 255));
		
		
		//Change Password
		
		frame.getContentPane().add(change_password, "name_516650837011973");
		change_password.setLayout(null);
		
		
		error_label.setHorizontalAlignment(SwingConstants.CENTER);
		error_label.setForeground(Color.RED);
		error_label.setFont(new Font("Tahoma", Font.BOLD, 14));
		error_label.setBounds(102, 37, 208, 27);
		change_password.add(error_label);
		
		JLabel lblNewLabel = new JLabel("Enter New Password");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(126, 124, 134, 14);
		change_password.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(126, 142, 125, 20);
		change_password.add(passwordField);
		
		JLabel lblReenterPassword = new JLabel("Re-Enter Password");
		lblReenterPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblReenterPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReenterPassword.setBounds(102, 217, 125, 14);
		change_password.add(lblReenterPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(102, 236, 125, 20);
		change_password.add(passwordField_1);
		
		
		change_password_status.setBounds(35, 57, 64, 80);
		change_password_status.setIcon(new ImageIcon(img4));
		change_password.add(change_password_status);
		
		JLabel mainbox = new JLabel("");
		mainbox.setBounds(0, 0, 344, 298);
		change_password.add(mainbox);
		mainbox.setIcon(new ImageIcon(img9));
		
		JButton changepass = new JButton("Change Password");
		changepass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String pp1=passwordField.getText();
			String pp2=passwordField_1.getText();
			if(!((pp1.equals(""))||(pp2.equals("")))){
				   if(pp1.equals(pp2)){
					   try {
						BufferedWriter bff=new BufferedWriter(new FileWriter("C://compression//password.txt"));
						bff.write(pp1);
						bff.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					  olduser.setVisible(true);
					  enter_password.setText("");
					  main.setVisible(false);
					  change_password.setVisible(false);
				   }else{
					   change_password_status.setIcon(new ImageIcon(error_image));
					   error_label.setText("Password didn't match");
				   }
			}else{
				change_password_status.setIcon(new ImageIcon(error_image));
				error_label.setText("Some field is empty");
				error_label.setVisible(true);
			}
		 }
		});
		changepass.setBackground(new Color(0, 0, 128));
		changepass.setFont(new Font("Tahoma", Font.BOLD, 16));
		changepass.setBounds(69, 301, 191, 38);
		change_password.add(changepass);
		main.setBackground(Color.WHITE);
		
		
		frame.getContentPane().add(main, "name_484281069135298");
		main.setLayout(null);
		
		JLabel compress = new JLabel("");
		compress.setForeground(Color.BLACK);
		compress.setBackground(Color.DARK_GRAY);
		compress.setBounds(37, 11, 110, 118);
		compress.setIcon(new ImageIcon(img5));
		main.add(compress);
		
		JLabel view = new JLabel("");
		view.setBackground(Color.GREEN);
		view.setBounds(208, 11, 103, 118);
		view.setIcon(new ImageIcon(img6));
		main.add(view);
		
		JLabel changepassword = new JLabel("");
		changepassword.setBounds(37, 184, 110, 118);
		changepassword.setIcon(new ImageIcon(img7));
		main.add(changepassword);
		
		JLabel logout = new JLabel("");
		logout.setBounds(208, 184, 110, 118);
		logout.setIcon(new ImageIcon(img8));
		main.add(logout);
		
		JButton compress_button = new JButton("Compress\r\n File");
		compress_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				file_choosing.setVisible(true);
				DirectoryTryAgain.setVisible(false);
				TextDirectoryAlreadyExist.setVisible(false);
				file_name_field.setText("");
				CompressionName.setText("");
				
			}
		});
		compress_button.setFont(new Font("Tahoma", Font.BOLD, 11));
		compress_button.setBounds(23, 140, 123, 23);
		main.add(compress_button);
		/*
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY );
		fc.setAcceptAllFileFilterUsed(false);
		int val=fc.showOpenDialog(null);
		if(val==JFileChooser.APPROVE_OPTION) {
			file_name_field.setText(fc.getSelectedFile().toString());
			 like=file_name_field.getText();*/
		
		JButton view_button = new JButton("View Files");
		view_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser1=new JFileChooser();
				chooser1.setCurrentDirectory(new java.io.File("C:\\compression\\"));
				chooser1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    chooser1.setAcceptAllFileFilterUsed(false);
			    int abc=chooser1.showOpenDialog(null);
			    if(abc== JFileChooser.APPROVE_OPTION){
			    	dir=chooser1.getSelectedFile().toString();
			        System.out.println(dir);
			        main.setVisible(false);
			        file_choosing.setVisible(false);
			        view_files.setVisible(true);
			        change_password.setVisible(false);
			        homepage.setVisible(false);
			        ratio_showing.setVisible(false);
			        
			
			//Decoding Starts
			        
			        StringTokenizer st=new StringTokenizer(dir,"\\");
					String name1="";
					while(st.hasMoreTokens()){
						name1=st.nextToken();
					}
					System.out.println(name1);
					String decode_file_path="C://Compression//"+name1+"//"+name1+"_finaloutput.txt";
					String show_file_path="C://Compression//"+name1+"//"+name1+"_decode_final_output.txt";
					DHuffman dfff=new DHuffman();
					dfff.decode(decode_file_path,show_file_path);
					System.out.println("decoded final output  file is::: "+decode_file_path+" successfully created.");
					try{
						DecompressionWithSecurity dws=new DecompressionWithSecurity();
						String h=dws.decode(show_file_path, cName);
						text_data.setText(h);
					}catch(Exception e7){
						e7.printStackTrace();
					}
					
			    }
			     else
			    {
			    	System.out.println("no Selection");
			    }
			    
	//Decoding Ends
			    
			}
		});
		view_button.setFont(new Font("Tahoma", Font.BOLD, 11));
		view_button.setBounds(201, 140, 110, 23);
		main.add(view_button);
		
		JButton btnNewButton_2 = new JButton("Change Password");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				error_label.setVisible(false);
				change_password.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(23, 312, 137, 23);
		main.add(btnNewButton_2);
		
		JButton logout_button = new JButton("Logout");
		logout_button.setFont(new Font("Tahoma", Font.BOLD, 11));
		logout_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		logout_button.setBounds(201, 312, 110, 23);
		main.add(logout_button);
		
		
		frame.getContentPane().add(file_choosing, "name_418132202711671");
		file_choosing.setLayout(null);
		
		file_name_field = new JTextField();
		file_name_field.setBounds(10, 131, 193, 23);
		file_choosing.add(file_name_field);
		file_name_field.setColumns(10);
	
		JButton file_choose = new JButton("Choose File");
		file_choose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser();
				
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY );
				fc.setAcceptAllFileFilterUsed(false);
				int val=fc.showOpenDialog(null);
				if(val==JFileChooser.APPROVE_OPTION) {
					file_name_field.setText(fc.getSelectedFile().toString());
					 file_path=file_name_field.getText();
					 }

			}
		});
		file_choose.setBounds(213, 131, 121, 23);
		file_choosing.add(file_choose);
		
		JButton start_process = new JButton("Save And Compress");
		start_process.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
					 //checking existence of directory
					 String cname=CompressionName.getText().toString();
					 String path1="C://compression//"+cname;
					 System.out.println(path1);
					 File f = new File(path1);
					 if (f.exists() && f.isDirectory()) {
					   TextDirectoryAlreadyExist.setVisible(true);
					   DirectoryTryAgain.setVisible(true);
					 }
					 else
					 {
						 f.mkdir();
					 }
//printing firststep file
//		    ProjectByt pb=new ProjectByt();
		    CompressFile sf=new CompressFile();
		    cName=CompressionName.getText().toString();
		    sf.Compress(file_path,cName);
//		    pb.FirstStep(file_path,waste);
//ends
		    
//printing Xor output		    
//		    Xor x_or=new Xor();
//		    x_or.getXorCode(waste);
//ends		    
		    
//printing last step
		    
//		    System.out.println("value of waste iss==="+waste);
		String first="C:\\compression\\"+cName+"\\"+cName+"_encode_xor_output.txt";
		String second="C:\\compression\\"+cName+"\\"+cName+"_finaloutput.txt";
		    DHuffman dff=new DHuffman();
		 double result=   dff.encode(first,second);
		 if(result<0){
			 result=result*(-1);
		 }
         String compression_ratio=(Double.toString(result));		
		 print_compression_ratio.setText(compression_ratio+" %");
//ends		    
		    file_choosing.setVisible(false);
            main.setVisible(false);
            ratio_showing.setVisible(true);
            //code here
			}catch(Exception e1)
			{
				e1.printStackTrace(); 
			}
		}
		});
		start_process.setBounds(84, 285, 169, 31);
		file_choosing.add(start_process);
		
		//directory exixst label text
		TextDirectoryAlreadyExist.setFont(new Font("Tahoma", Font.BOLD, 14));
		TextDirectoryAlreadyExist.setBounds(37, 54, 180, 23);
		file_choosing.add(TextDirectoryAlreadyExist);
		DirectoryTryAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				file_choosing.setVisible(true);
				TextDirectoryAlreadyExist.setVisible(false);
				DirectoryTryAgain.setVisible(false);
				CompressionName.setText(" ");   
			}
		});
		
		//directory try agian button
		DirectoryTryAgain.setBounds(227, 56, 89, 23);
		file_choosing.add(DirectoryTryAgain);
		
		JLabel lblNameForThe = new JLabel("Name for the compression");
		lblNameForThe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNameForThe.setBounds(75, 190, 193, 31);
		file_choosing.add(lblNameForThe);
		
		CompressionName = new JTextField();
		CompressionName.setBounds(75, 232, 193, 20);
		file_choosing.add(CompressionName);
		CompressionName.setColumns(10);
		
		frame.getContentPane().add(ratio_showing, "name_1294369383361713");
		ratio_showing.setLayout(null);
		
		JLabel congo_message = new JLabel("Congratulations Your text file is Multisecured ");
		congo_message.setFont(new Font("Tahoma", Font.BOLD, 14));
		congo_message.setBounds(10, 42, 324, 44);
		ratio_showing.add(congo_message);
		
		JLabel compression_ratio = new JLabel("Your Compression ratio was");
		compression_ratio.setFont(new Font("Tahoma", Font.BOLD, 14));
		compression_ratio.setBounds(75, 97, 232, 33);
		ratio_showing.add(compression_ratio);
		
		print_compression_ratio.setHorizontalAlignment(SwingConstants.CENTER);
		print_compression_ratio.setFont(new Font("Tahoma", Font.BOLD, 14));
		print_compression_ratio.setBounds(119, 147, 81, 33);
		ratio_showing.add(print_compression_ratio);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ratio_showing.setVisible(false);
			main.setVisible(true);
			file_choosing.setVisible(false);
			}
		});
		btnGoBack.setBounds(36, 250, 89, 23);
		ratio_showing.add(btnGoBack);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		btnLogout.setBounds(198, 250, 89, 23);
		ratio_showing.add(btnLogout);
		
		frame.getContentPane().add(view_files, "name_384209677058422");
		view_files.setLayout(null);
		
	
		text_data.setBounds(10, 11, 324, 305);
		
		//scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//view_files.add(scroll);		
		view_files.add(text_data);

		
		JButton close_file_button = new JButton("Close File");
		close_file_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			main.setVisible(true);
			view_files.setVisible(false);
			file_choosing.setVisible(false);
			}
		});
		close_file_button.setBounds(20, 327, 301, 23);
		view_files.add(close_file_button);
		
	
	}
}
