import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GoodPasswordApp {

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private CheckingPassword checkingPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoodPasswordApp window = new GoodPasswordApp();
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
	public GoodPasswordApp() {
		checkingPassword = new CheckingPassword();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter Password (8-12 characters):");
		lblNewLabel.setBounds(10, 11, 234, 14);
		frame.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(254, 6, 170, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Generate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkPasswordStrength();
			}
		});
		btnNewButton.setBounds(131, 42, 89, 23);
		frame.getContentPane().add(btnNewButton);

		textArea = new JTextArea();
		textArea.setBounds(20, 76, 404, 174);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(20, 76, 404, 174);
		frame.getContentPane().add(scrollPane);
	}

	/**
	 * Actually check the password
	 */
	private void checkPasswordStrength() {
		String password = textField.getText().trim();
		String result = checkingPassword.checkPasswordStrength(password);
		textArea.setText(result);
	}
}
