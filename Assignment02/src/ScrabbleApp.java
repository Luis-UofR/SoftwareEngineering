import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ScrabbleApp {

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private ScrambleWords createPerms;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScrabbleApp window = new ScrabbleApp();
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
	public ScrabbleApp() {
		createPerms = new ScrambleWords();
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

		JLabel lblNewLabel = new JLabel("Enter 7 Scrabble tiles:");
		lblNewLabel.setBounds(10, 11, 184, 14);
		frame.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(204, 6, 220, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Generate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generatePermutations();
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
	 * Show all permutations of 7 letters, validate input, displays results or
	 * error.
	 */
	private void generatePermutations() {
		String input = textField.getText().trim();
		textArea.setText("");

		if (input.length() != 7) {
			textArea.setText("You must enter exactly 7 letters.");
			return;
		}
		if (!input.matches("[a-zA-Z]+")) {
			textArea.setText("Only alphabet letters are allowed.");
			return;
		}

		List<String> permutations = createPerms.createPerms(input.toCharArray());
		textArea.append("Permutations:\n");
		for (String perm : permutations) {
			textArea.append(perm + "\n");
		}
	}
}
