import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Results extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Results frame = new Results();
					frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public Results() {
		setTitle("Test Results");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 230, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main window = new main();				
				window.frmDeliTrainingApplication.setVisible(true);	
				Results.this.dispose();
			}
		});
		contentPane.add(btnOk, BorderLayout.SOUTH);
		
		JLabel information = new JLabel("Test Results Were");
		contentPane.add(information, BorderLayout.CENTER);
	}
	
	public Results(int score, int total_questions) {
		setTitle("Test Results");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main window = new main();				
				window.frmDeliTrainingApplication.setVisible(true);	
				Results.this.dispose();
			}
		});
		contentPane.add(btnOk, BorderLayout.SOUTH);
		
		JLabel information = new JLabel("Results: "+score+"/"+total_questions+"   Grade: "+ (int)((float) score/total_questions*100.00) +"%");
		contentPane.add(information, BorderLayout.CENTER);
	}

}
