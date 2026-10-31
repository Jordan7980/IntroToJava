import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class ContactBookManager extends JFrame {
    private JTable contactTable;
    private DefaultTableModel tableModel;
    
    private static final String DEFAULT_DIR = System.getProperty("user.dir");

    private JTextField nameField;
    private JTextField amountField;
    private JList<Expense> expenseList;
    private DefaultListModel<Expense> expenseListModel;

    public ContactBookManager() {
        super("Contact Book Manager");
        
        // Table Model and JTable
        String[] columnNames = {"Name", "Street", "City", "State", "Phone", "Email"};
        tableModel = new DefaultTableModel(columnNames, 0);
        contactTable = new JTable(tableModel);

        setTitle("Expense Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 650);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        openMenuItem.addActionListener(e -> loadContacts());
        exitMenuItem.addActionListener(e -> System.exit(0));

        fileMenu.add(openMenuItem);
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        JPanel fieldPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        fieldPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        nameField = new JTextField(15);
        amountField = new JTextField(10);

        fieldPanel.add(new JLabel("Expense Name:", SwingConstants.CENTER));
        fieldPanel.add(nameField);
        fieldPanel.add(new JLabel("Expense Amount:", SwingConstants.CENTER));
        fieldPanel.add(amountField);

        JButton addButton = new JButton("Add Expense");
        addButton.addActionListener(e -> addExpense());
        JPanel addButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addButtonPanel.add(addButton);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(fieldPanel, BorderLayout.CENTER);
        topPanel.add(addButtonPanel, BorderLayout.SOUTH);
        add(topPanel, BorderLayout.NORTH);

        expenseListModel = new DefaultListModel<>();
        expenseList = new JList<>(expenseListModel);
        expenseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(expenseList), BorderLayout.CENTER);

        JButton deleteButton = new JButton("Delete Selected Item");
        deleteButton.addActionListener(e -> deleteSelectedExpense());
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(deleteButton);
        add(bottomPanel, BorderLayout.SOUTH);

    }

    private void showADialog() {
    	JOptionPane.showMessageDialog(this, "This is a dialog you can use for messages!");
    }

    private void addExpense() {
        String name = nameField.getText().trim();
        String amountText = amountField.getText().trim();

        if(name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter an expense name!",
                    "Missing expense name", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try{
            double amount = Double.parseDouble(amountText);
            expenseListModel.addElement(new Expense(name, amount));
            nameField.setText("");
            amountField.setText("");
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this,
                    "\"" + amountText + "\" is not a valid amount.\n"
                    + "The amount must be a number, like 25 or 19.99\n"
                    + "(no letters, dollar signs, or commas).",
                    "Invalid expense amount", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void deleteSelectedExpense() {
        int index = expenseList.getSelectedIndex();
        try{
            expenseListModel.remove(index);
        }catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(this,
                    "No expense is selected.\nClick an expense in the list first the press Delete",
                    "Nothing Selected",  JOptionPane.WARNING_MESSAGE);
        }
    }
    
    // Saves contacts to a CSV file
    private void saveContacts() {
    	JFileChooser chooser = new JFileChooser(DEFAULT_DIR);
    	int returnVal = chooser.showSaveDialog(this);
    	if(returnVal == JFileChooser.APPROVE_OPTION) {
    		String fileName = chooser.getSelectedFile().getName();
	        
    	}
    	return;
    }

    // Loads contacts from a CSV file
    private void loadContacts() {
    	JFileChooser chooser = new JFileChooser(DEFAULT_DIR);
    	int returnVal = chooser.showOpenDialog(this);
    	if(returnVal == JFileChooser.APPROVE_OPTION) {
	        String fileName = chooser.getSelectedFile().getName();

            File file = chooser.getSelectedFile();
            int badlines = 0;


            try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                String line;
                while((line = reader.readLine()) != null){
                    if(line.trim().isEmpty()){
                        continue;
                    }
                    String[] parts = line.split("\t");
                    if(parts.length != 2){
                        badlines++;
                        continue;
                    }
                    try{
                        String name = parts[0].trim();
                        double amount = Double.parseDouble(parts[1].trim().replace(",", ""));
                        expenseListModel.addElement(new Expense(name, amount));
                    }catch(NumberFormatException ex){
                        badlines++;
                    }
                }
            }catch(IOException ex){
                JOptionPane.showMessageDialog(this,
                        "Could not read " + fileName + ":\n" + ex.getMessage(),
                        "File Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if(badlines > 0){
                JOptionPane.showMessageDialog(this,
                        badlines + " line(s) in " + fileName + " were skipped because\n"
                                + "they were not in the form: name, amount",
                        "Some Lines Skipped", JOptionPane.WARNING_MESSAGE);
            }
    	}
    	return;
    }

    public static void main(String[] args) {
    	JFrame frame = new JFrame("Contact Book Manager");
        frame.setVisible(true);

        frame.dispose();
        SwingUtilities.invokeLater(() -> {
            ContactBookManager app = new ContactBookManager();
            app.setLocationRelativeTo(null);
            app.setVisible(true);
        });
    }
}
