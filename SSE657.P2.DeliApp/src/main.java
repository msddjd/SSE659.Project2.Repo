import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Panel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class main {

	private JFrame frmDeliTrainingApplication;
	
	//Loading Images into an Array
	int index = 0;
	File picFolder = new File( main.class.getResource("/ProductImages/UncensoredImages/").getPath() );
    File [] images = picFolder.listFiles();
    
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
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
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDeliTrainingApplication = new JFrame();
		frmDeliTrainingApplication.getContentPane().setBackground(Color.WHITE);
		frmDeliTrainingApplication.setTitle("Deli Training Application - Learning Mode");
		frmDeliTrainingApplication.setBounds(100, 100, 637, 682);
		frmDeliTrainingApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDeliTrainingApplication.getContentPane().setLayout(null);
		
		final JLabel ProductImage = new JLabel("");
		ProductImage.setBounds(10, 11, 600, 600);
		ProductImage.setIcon(new ImageIcon(main.class.getResource("/ProductImages/UncensoredImages/BBeefBologna.jpg")));
		frmDeliTrainingApplication.getContentPane().add(ProductImage);
		
		final JComboBox difficultyBox = new JComboBox();
		difficultyBox.setToolTipText("Testing Mode Difficulty");
		difficultyBox.setModel(new DefaultComboBoxModel(new String[] {"Easy", "Hard"}));
		difficultyBox.setSelectedIndex(0);
		difficultyBox.setBounds(397, 617, 93, 22);
		frmDeliTrainingApplication.getContentPane().add(difficultyBox);
		
		
		Button TestingButton = new Button("Testing Mode");
		TestingButton.setBounds(509, 617, 102, 22);
		TestingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				testing window2 = new testing( difficultyBox.getSelectedIndex());
				window2.frmDeliTrainingApplication.setExtendedState(JFrame.MAXIMIZED_BOTH);
				window2.frmDeliTrainingApplication.setVisible(true);				
				frmDeliTrainingApplication.dispose();				
			}
		});
		frmDeliTrainingApplication.getContentPane().add(TestingButton);
		
		Button NextButton = new Button("Next");
		NextButton.setBounds(179, 617, 70, 22);
		NextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(index<images.length-1)
			    {	
					index++;
			    	ProductImage.setIcon(new ImageIcon(images[index].getPath()));
			    }
			}
		});
		frmDeliTrainingApplication.getContentPane().add(NextButton);
		
		Button PrevButton = new Button("Previous");
		PrevButton.setBounds(65, 617, 70, 22);
		PrevButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index>0)
				{
					index--;
					ProductImage.setIcon(new ImageIcon(images[index].getPath()));
			    }
			}
		});
		frmDeliTrainingApplication.getContentPane().add(PrevButton);
		
		
		
	}	
}
