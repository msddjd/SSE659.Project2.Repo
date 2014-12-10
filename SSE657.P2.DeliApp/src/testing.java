import java.awt.EventQueue;

import javax.print.DocFlavor.URL;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.zip.ZipInputStream;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;


public class testing {

	protected JFrame frmDeliTrainingApplication;	
	Random generator = new Random(System.currentTimeMillis());
    int max = 0, rand_product = 0, rand_product2 = 0, rand_option = 0, score = 0, questions = 1, difficulty = 0;
    String name = "", name2 = "", type = "", type2 = "";
    GameEngine Engine = new GameEngine();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testing window = new testing();
					window.frmDeliTrainingApplication.setExtendedState(JFrame.MAXIMIZED_BOTH);
					window.frmDeliTrainingApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public testing() {		
		loadProducts();
		pickProducts();
		initializeTesting();	
		
	}
	
	public testing(int difficulty){ //Constructor passing in level of difficulty
		this.difficulty = difficulty;
		loadProducts();
		pickProducts();
		initializeTesting();		
	}
	
	private void loadProducts() {		 		
		
		//Convert All Censored Beef Pictures into Beef Product Objects Objects		
		File Folder = new File( testing.class.getResource("/ProductImages/CensoredImages/Meats/Beef/").getPath() );
	    File [] beefs = Folder.listFiles();	
	    
		
	    for(int index = 0; index < beefs.length; index++) {
	    	Map<String, String> properties = new HashMap<String, String>();	    	
	    	name = beefs[index].getName();
			properties.put("name", name);
			properties.put("type", "Beef");
			Engine.getProducts().add(new Product(properties));			
	    }
	    
	  //Convert All Censored Bologna Pictures 	
	  		Folder = new File( testing.class.getResource("/ProductImages/CensoredImages/Meats/Bologna/").getPath() );
	  	    File [] bolognas = Folder.listFiles();
	  	    for(int index = 0; index < bolognas.length; index++) {
	  	    	Map<String, String> properties = new HashMap<String, String>();
	  	    	name = bolognas[index].getName();
	  			properties.put("name", name);
	  			properties.put("type", "Bologna");
	  			Engine.getProducts().add(new Product(properties));			
	  	    }
	  	    
	  	  //Convert All Censored Chicken Pictures 	
	  		Folder = new File( testing.class.getResource("/ProductImages/CensoredImages/Meats/Chicken/").getPath() );
	  	    File [] chickens = Folder.listFiles();
	  	    for(int index = 0; index < chickens.length; index++) {
	  	    	Map<String, String> properties = new HashMap<String, String>();
	  	    	name = chickens[index].getName();
	  			properties.put("name", name);
	  			properties.put("type", "Chicken");
	  			Engine.getProducts().add(new Product(properties));			
	  	    }
	  	    
	  	  //Convert All Censored Ham Pictures 	
	  		Folder = new File( testing.class.getResource("/ProductImages/CensoredImages/Meats/Ham/").getPath() );
	  	    File [] hams = Folder.listFiles();
	  	    for(int index = 0; index < hams.length; index++) {
	  	    	Map<String, String> properties = new HashMap<String, String>();
	  	    	name = hams[index].getName();
	  			properties.put("name", name);
	  			properties.put("type", "Ham");
	  			Engine.getProducts().add(new Product(properties));			
	  	    }
	  	    
	  	    //Convert All Censored Italian Pictures 	
		  		Folder = new File( testing.class.getResource("/ProductImages/CensoredImages/Meats/Italian/").getPath() );
		  	    File [] italians = Folder.listFiles();
		  	    for(int index = 0; index < italians.length; index++) {
		  	    	Map<String, String> properties = new HashMap<String, String>();
		  	    	name = italians[index].getName();
		  			properties.put("name", name);
		  			properties.put("type", "Italian");
		  			Engine.getProducts().add(new Product(properties));			
		  	    }
		  	    
		  	   //Convert All Censored Turkey Pictures 	
		  		Folder = new File( testing.class.getResource("/ProductImages/CensoredImages/Meats/Turkey/").getPath() );
		  	    File [] turkeys = Folder.listFiles();
		  	    for(int index = 0; index < turkeys.length; index++) {
		  	    	Map<String, String> properties = new HashMap<String, String>();
		  	    	name = turkeys[index].getName();
		  			properties.put("name", name);
		  			properties.put("type", "Turkey");
		  			Engine.getProducts().add(new Product(properties));			
		  	    }
		  	    
		  	  //Convert All Censored Wurst Pictures 	
		  		Folder = new File( testing.class.getResource("/ProductImages/CensoredImages/Meats/Wurst/").getPath() );
		  	    File [] wursts = Folder.listFiles();
		  	    for(int index = 0; index < wursts.length; index++) {
		  	    	Map<String, String> properties = new HashMap<String, String>();
		  	    	name = wursts[index].getName();
		  			properties.put("name", name);
		  			properties.put("type", "Wurst");
		  			Engine.getProducts().add(new Product(properties));			
		  	    }
	  	    
	  	    
	    
	    //Convert All Censored Cheese Pictures into Cheese Product Objects
	    File cheeseFolder = new File( testing.class.getResource("/ProductImages/CensoredImages/Cheeses/").getPath() );
	    File [] cheeses = cheeseFolder.listFiles();
	    
	    for(int index = 0; index < cheeses.length; index++) {
	    	Map<String, String> properties = new HashMap<String, String>();
	    	name = cheeses[index].getName();	    	
			properties.put("name", name);
			properties.put("type", "Cheese");
			Engine.getProducts().add(new Product(properties));			
	    }   

	    	    
	}
	

	private void initializeTesting() {
		/**
		 * Initialize the contents of the frame.
		 */
		
		frmDeliTrainingApplication = new JFrame();
		frmDeliTrainingApplication.getContentPane().setForeground(Color.WHITE);
		frmDeliTrainingApplication.getContentPane().setBackground(Color.WHITE);
		frmDeliTrainingApplication.setTitle("Deli Training Application - Testing Mode");
		frmDeliTrainingApplication.setBounds(100, 100, 1274, 688);
		frmDeliTrainingApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDeliTrainingApplication.getContentPane().setLayout(null);
		
		final JLabel Option1 = new JLabel("");
		final JLabel Option2 = new JLabel("");
		final JFormattedTextField QuestionText = new JFormattedTextField();
		final JFormattedTextField ScoreCounter = new JFormattedTextField();
		
		Option1.setBackground(Color.WHITE);
		Option1.setForeground(Color.WHITE);
		Option1.setFont(UIManager.getFont("Menu.font"));
		Option1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				updateScore(0);				
				pickProducts();
				updatePage(Option1,Option2,QuestionText,ScoreCounter);			
			}
		});
		Option1.setIcon(new ImageIcon(testing.class.getResource("/ProductImages/CensoredImages/Meats/Beef/BLondonBroilTopRound.jpg")));
		Option1.setBounds(0, 50, 600, 600);
		frmDeliTrainingApplication.getContentPane().add(Option1);
		
		
		QuestionText.setFont(new Font("Tahoma", Font.PLAIN, 19));
		QuestionText.setBorder(null);
		QuestionText.setSelectedTextColor(new Color(255, 255, 255));
		QuestionText.setSelectionColor(Color.WHITE);
		QuestionText.setForeground(Color.BLACK);
		QuestionText.setDisabledTextColor(Color.WHITE);
		QuestionText.setCaretColor(Color.WHITE);
		QuestionText.setBackground(new Color(255, 255, 255));
		QuestionText.setEditable(false);
		
		
		QuestionText.setBounds(10, 0, 600, 46);
		frmDeliTrainingApplication.getContentPane().add(QuestionText);
		
		
		Option2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				updateScore(1);
				pickProducts();
				updatePage(Option1,Option2,QuestionText,ScoreCounter);
			}
		});
		Option2.setIcon(new ImageIcon(testing.class.getResource("/ProductImages/CensoredImages/Cheeses/BWhiteAmericanCheese.jpg")));
		Option2.setBounds(648, 50, 600, 600);
		frmDeliTrainingApplication.getContentPane().add(Option2);
		
		QuestionText.setText("Which one is the "+ name.subSequence(0, name.indexOf('.')));		
		
		updatePage(Option1,Option2,QuestionText,ScoreCounter);
		
		
		ScoreCounter.setText("Score: 0");
		ScoreCounter.setSelectionColor(Color.WHITE);
		ScoreCounter.setSelectedTextColor(Color.WHITE);
		ScoreCounter.setForeground(Color.BLACK);
		ScoreCounter.setFont(new Font("Tahoma", Font.PLAIN, 19));
		ScoreCounter.setEditable(false);
		ScoreCounter.setDisabledTextColor(Color.WHITE);
		ScoreCounter.setCaretColor(Color.WHITE);
		ScoreCounter.setBorder(null);
		ScoreCounter.setBackground(Color.WHITE);
		ScoreCounter.setBounds(1140, 0, 108, 46);
		frmDeliTrainingApplication.getContentPane().add(ScoreCounter);
	}
	
	private void updatePage(JLabel Option1, JLabel Option2, JFormattedTextField QuestionText, JFormattedTextField ScoreCounter)
	{	
		rand_option = generator.nextInt((1+1));
		QuestionText.setText(questions+". Which one is the "+ name.subSequence(0, name.indexOf('.')));
		questions++;
		ScoreCounter.setText("Score: "+score);
		
		//Determine Where to display correct picture
		if(rand_option < 1) //then display correct picture in Option1 box
		{
			if(type.compareTo("Cheese")!=0)//Determine which folder correct picture is in
				Option1.setIcon(new ImageIcon(testing.class.getResource("/ProductImages/CensoredImages/Meats/"+type+"/"+name)));
			else
				Option1.setIcon(new ImageIcon(testing.class.getResource("/ProductImages/CensoredImages/Cheeses/"+name)));
			
			if(type2.compareTo("Cheese")!=0)//Determine which folder incorrect picture is in
				Option2.setIcon(new ImageIcon(testing.class.getResource("/ProductImages/CensoredImages/Meats/"+type2+"/"+name2)));
			else
				Option2.setIcon(new ImageIcon(testing.class.getResource("/ProductImages/CensoredImages/Cheeses/"+name2)));			
		}	
		else
		{
			if(type.compareTo("Cheese")!=0)//Determine which folder correct picture is in
				Option2.setIcon(new ImageIcon(testing.class.getResource("/ProductImages/CensoredImages/Meats/"+type+"/"+name)));
			else
				Option2.setIcon(new ImageIcon(testing.class.getResource("/ProductImages/CensoredImages/Cheeses/"+name)));
			
			if(type2.compareTo("Cheese")!=0)//Determine which folder incorrect picture is in
				Option1.setIcon(new ImageIcon(testing.class.getResource("/ProductImages/CensoredImages/Meats/"+type2+"/"+name2)));
			else
				Option1.setIcon(new ImageIcon(testing.class.getResource("/ProductImages/CensoredImages/Cheeses/"+name2)));
			
		}		
	}
	
	private void updateScore(int selection) {
		if(selection == rand_option)
		score++;		
	}
	
	private void pickProducts(){
		Product product1 = Engine.getUnpicked();
		Product product2;
		
		
		if(product1 == null)
			//No more unpicked products
			System.out.println("Finished");
		else
			{
				name = product1.properties.get("name");
				type = product1.properties.get("type");	
				
				if(difficulty == 0) //if easy
					{
						product2 = Engine.getProduct();						
						type2 = product2.properties.get("type");					
					}
				else
					{
						product2 = Engine.getProduct(type);
						type2 = type;
					}
				name2 = product2.properties.get("name");				
			}	  
	}
}
