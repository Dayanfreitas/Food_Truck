package com.catolicasc.foodtruck;
/*https://www.devmedia.com.br/forum/jframe-abrir-jinternalframe/568591*/
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		desktopPane = new JDesktopPane();
		
		desktopPane.setBounds(0, 0, 684, 640);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 20, 700, 700);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		
		JMenu menuTelas = new JMenu("Telas");
		menuBar.add(menuTelas);
		
		JMenuItem opUser = new JMenuItem("Usuários");
		
		opUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JUser user = new JUser();
				desktopPane.add(user);
				user.setVisible(true);
			}
			
		});
		
		menuTelas.add(opUser);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(desktopPane);
	}

}
