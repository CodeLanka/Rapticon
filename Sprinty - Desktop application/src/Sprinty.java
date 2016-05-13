import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.LayoutStyle.ComponentPlacement;


public class Sprinty extends JFrame {

	private JPanel contentPane;
	private JTextField copies;
	
	
	private  JLabel viewLable;
	
	
	protected String picOne = "C:\\Users\\Dulika Ranasinge\\Downloads\\13113268_1695182490734514_2084951148_o.jpg";
	protected String picTwo = "C:\\Users\\Dulika Ranasinge\\Downloads\\13210964_1695182444067852_880975833_o.jpg";
	protected String picThree = "C:\\Users\\Dulika Ranasinge\\Downloads\\13113268_1695182490734514_2084951148_o.jpg";
	protected String picFour = "C:\\Users\\Dulika Ranasinge\\Downloads\\1.jpg";
	private JTable table;
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
					Sprinty frame = new Sprinty();
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
	public Sprinty() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0,0,screenSize.width, screenSize.height);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setLayout(null);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setForeground(new Color(255, 255, 255));
		lblSize.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblSize.setBackground(new Color(0, 0, 0));
		lblSize.setBounds(791, 400, 89, 28);
		panel.add(lblSize);
		
		JLabel lblScaling = new JLabel("Scaling");
		lblScaling.setForeground(new Color(255, 255, 255));
		lblScaling.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblScaling.setBackground(new Color(0, 0, 0));
		lblScaling.setBounds(791, 274, 89, 28);
		panel.add(lblScaling);
		
		JLabel lblView = new JLabel("VIEW");
		lblView.setIcon(new ImageIcon("E:\\Company\\GIO HACK\\Desktop App\\Sprinty\\src\\External Libraries\\2.jpg"));
		lblView.setBounds(27, 161, 687, 463);
		panel.add(lblView);
		
          
		

	   
          
          
		
		
		
		
		//view label to show photos
		
		
		

        
      
		
		JList list = new JList();
		list.setBackground(Color.PINK);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(73, 601, 89, -111);
		panel.add(list);
		
		copies = new JTextField();
		copies.setBounds(932, 470, 89, 20);
		panel.add(copies);
		copies.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dulika Ranasinge\\Downloads\\4 (2).gif"));
		lblNewLabel.setBounds(791, 56, 244, 71);
		panel.add(lblNewLabel);
		
		
		
		//combo box
		String [] msg = {"Landscape","Portraight"};
		JComboBox ori = new JComboBox(msg);
		ori.setBounds(932, 337, 89, 20);
		panel.add(ori);
		
		//combo box
		String [] msg2 = {"one","two"};
		JComboBox printer = new JComboBox(msg2);
		printer.setBounds(932, 226, 89, 20);
		panel.add(printer);
		
		JLabel lblcopies = new JLabel("Copies");
		lblcopies.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblcopies.setForeground(new Color(255, 255, 255));
		lblcopies.setBackground(new Color(0, 0, 0));
		lblcopies.setBounds(791, 462, 89, 28);
		panel.add(lblcopies);
		
		JLabel orientation = new JLabel("Orientation");
		orientation.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		orientation.setForeground(new Color(248, 248, 255));
		orientation.setBackground(new Color(0, 0, 0));
		orientation.setBounds(791, 325, 120, 38);
		panel.add(orientation);
		
		JLabel lblSelectPrinter = new JLabel("Printer");
		lblSelectPrinter.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblSelectPrinter.setForeground(new Color(255, 255, 255));
		lblSelectPrinter.setBackground(new Color(0, 0, 0));
		lblSelectPrinter.setBounds(791, 219, 89, 28);
		panel.add(lblSelectPrinter);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(Desktop.isDesktopSupported())
				{
				  try {
					Desktop.getDesktop().browse(new URI("http://rapticon.esy.es/Sprinty/files.php"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPrint.setBounds(861, 586, 89, 38);
		panel.add(btnPrint);
		
		JButton btnNewButton = new JButton("P \n R \n I \n N \n T");
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setBounds(27, 56, 196, 71);
		panel.add(btnNewButton);
		
		JButton btnAccount = new JButton("E D I T");
		btnAccount.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnAccount.setBackground(Color.BLUE);
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAccount.setBounds(273, 56, 196, 71);
		panel.add(btnAccount);
		
		JButton btnAccount_1 = new JButton("A C C O U N T ");
		btnAccount_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnAccount_1.setBackground(Color.BLUE);
		btnAccount_1.setBounds(518, 56, 196, 71);
		panel.add(btnAccount_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\Company\\GIO HACK\\Desktop App\\Sprinty\\src\\External Libraries\\logo.jpg"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)))
					.addGap(28)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1073, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 703, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE)))
					.addGap(26))
		);
		
		
		//combo box
		String [] msg3 = {"fit to ","shrink to"};
		JComboBox scaling = new JComboBox(msg3);
		scaling.setBounds(932, 281, 89, 20);
		panel.add(scaling);
		
		
		//combo box
		String [] msg4 = {"4x4","5x7"}; 
		JComboBox size = new JComboBox(msg4);
		size.setBounds(932, 407, 89, 20);
		panel.add(size);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dulika Ranasinge\\Desktop\\WDF_901313.jpg"));
		lblNewLabel_1.setBounds(-94, 0, 1180, 703);
		panel.add(lblNewLabel_1);
		
		String User1 = null;
		String image1 = null;
		String image2 = null;
		
		table_1 = new JTable();
		table_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"USER", "ITEM"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setColumnHeaderView(table_1);
		contentPane.setLayout(gl_contentPane);
	}
	
	static String convertStreamToString(java.io.InputStream is) {
	    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
	    return s.hasNext() ? s.next() : "";
	}
}
