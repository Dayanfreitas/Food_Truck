package com.catolicasc.foodtruck;
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
/**
*
* @author dayanfreitas
*/
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
					frame.setTitle("Food Truck");
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
		desktopPane = new JDesktopPane();;
		desktopPane.setBounds(0, 0, 700, 700);
		
		//JUserList listUsers= new JUserList();
		//desktopPane.add(listUsers);
		//listUsers.setVisible(true);
		
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

				JUserList listUsers = new JUserList();
				desktopPane.add(listUsers);
				listUsers.setVisible(true);

			}
			
		});
		
		menuTelas.add(opUser);
		
		JMenuItem opProdutos = new JMenuItem("Produtos");
		opProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 JProductList JlistProducts = new JProductList();
				 desktopPane.add(JlistProducts);
				 JlistProducts.setVisible(true);
				
			}
		});
		menuTelas.add(opProdutos);
		
		JMenuItem opClientes = new JMenuItem("Clientes");
		opClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JCustomersList jCustomersList = new JCustomersList();
				desktopPane.add(jCustomersList);
				jCustomersList.setVisible(true);
			}
		});
		menuTelas.add(opClientes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(desktopPane);
	}
}
