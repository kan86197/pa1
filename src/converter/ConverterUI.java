package converter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ConverterUI extends JFrame {
	private JButton convertButton;
	private UnitConverter unitConverter;
	private UnitFactory unitFactory;
	private JTextField inputField;
	private JComboBox<Unit> inputUnitBox;
	private JLabel equalSign = new JLabel("=");
	private JTextField resultField;
	private JComboBox<Unit> resultUnitBox;
	private JRadioButton leftRadioButton;
	private JRadioButton rightRadioButton;
	private ButtonGroup radioGroup = new ButtonGroup();
	private JMenuBar menuBar;
	private JMenu menu;

	public ConverterUI(UnitConverter uc){
		this.unitConverter = uc;
		this.setTitle("Unit Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponent();
	}

	/**
	 * Initialize components in the UI
	 */
	private void initComponent(){
		
		JPanel contentPanel = new JPanel();
		convertButton = new JButton("Convert");
		inputField = new JTextField(10);
		inputUnitBox = new JComboBox<Unit>();
		resultField = new JTextField(10);
		resultUnitBox = new JComboBox<Unit>();
		leftRadioButton = new JRadioButton("Left-->Right");
		rightRadioButton = new JRadioButton("Right-->Left");
		radioGroup.add(leftRadioButton);
		radioGroup.add(rightRadioButton);
		Container con1 = new Container();
		Container con2 = new Container();


		menu = new JMenu("Units");
		menuBar = new JMenuBar();
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		UnitType [] unittypes = unitFactory.getInstance().getUnitTypes();
		for(UnitType utype : unittypes) {
			JMenuItem menuItem = new JMenuItem( utype.name() );
			// UnitAction is an ActionListener that is repsonsible for changing the type of unit.
			// It gets the units from the application and adds them to the JComboBoxes.
			menuItem.addActionListener( new UnitAction(utype) );
			menu.add( menuItem );
		}

		Unit [] lengths = unitConverter.getUnits();
		for(Unit u : lengths) inputUnitBox.addItem(u);
		for(Unit u : lengths) resultUnitBox.addItem(u);
		FlowLayout flow = new FlowLayout();
		con1.setLayout(flow);
		con2.setLayout(flow);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		contentPanel.add(con1);
		con1.add(inputField);
		con1.add(inputUnitBox);
		con1.add(equalSign);
		con1.add(resultField);
		con1.add(resultUnitBox);
		con1.add(convertButton);
		contentPanel.add(con2);

		con2.add(leftRadioButton);
		con2.add(rightRadioButton);
		this.add(contentPanel);
		resultField.setEditable(false);



		KeyListener listener = new ConvertButtonListener();
		ActionListener leftRadioListener = new LeftRadioButtonListener();
		ActionListener rightRadioListener = new RightRadioButtonListener();
		convertButton.addActionListener((ActionListener) listener);
		inputField.addKeyListener(listener);
		resultField.addKeyListener(listener);
		leftRadioButton.addActionListener(leftRadioListener);
		rightRadioButton.addActionListener(rightRadioListener);
		this.pack();
		setVisible(true);
	}

	
	
	class UnitAction implements ActionListener{
		private UnitType uType;
		
		public UnitAction(UnitType uType) {
			this.uType = uType;
		}
		
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Unit[] unit = uType.getValue(); 
			inputUnitBox.removeAllItems();
			resultUnitBox.removeAllItems();
			for(Unit u : unit) inputUnitBox.addItem(u);
			for(Unit u : unit) resultUnitBox.addItem(u);
		}
		
	}
	
	
	class LeftRadioButtonListener implements ActionListener{
		/**
		 * Make the left textfield editable
		 */
		public void actionPerformed( ActionEvent event){
			inputField.setEditable(true);
			resultField.setEditable(false);
		}
	}

	class RightRadioButtonListener implements ActionListener{
		/**
		 * Make the right textfield editable
		 */
		public void actionPerformed( ActionEvent event){
			inputField.setEditable(false);
			resultField.setEditable(true);
		}
	}

	/**
	 * 
	 * @author Kan
	 * ActionListener and KeyListener for convert button and textfields
	 *
	 */
	class ConvertButtonListener implements KeyListener, ActionListener{

		public void actionPerformed( ActionEvent event){

			//System.out.println("actionPerformed: input=" + s);
			if(leftRadioButton.isSelected()){
				String s = inputField.getText().trim();
				if( s.length() > 0){
					try{
						double value = Double.valueOf(s);
						double result = unitConverter.convert(value,(Unit) inputUnitBox.getSelectedItem(),(Unit) resultUnitBox.getSelectedItem());
						//String resultString = String.format("%.2f", result);
						resultField.setText(Double.toString(result));

					}catch(NumberFormatException e){
						
						System.out.println("Input is not a number");
					}
				}
			}	else if( rightRadioButton.isSelected()){
				String s = resultField.getText().trim();
				if( s.length() > 0){
					try{
						double value = Double.valueOf(s);
						double result = unitConverter.convert(value,(Unit) resultUnitBox.getSelectedItem(),(Unit) inputUnitBox.getSelectedItem());
						//String resultString = String.format("%.2f", result);
						inputField.setText(Double.toString(result));

					}catch(NumberFormatException e){
						System.out.println("Input is not a number");
					}
				}
			}
		}
		@Override
		public void keyPressed(KeyEvent arg0) {

		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			if(leftRadioButton.isSelected()){
				String s = inputField.getText().trim();
				if( s.length() > 0){
					try{
						double value = Double.valueOf(s);
						double result = unitConverter.convert(value,(Unit) inputUnitBox.getSelectedItem(),(Unit) resultUnitBox.getSelectedItem());
						//String resultString = String.format("%.2f", result);
						inputField.setForeground(Color.BLACK);
						resultField.setText(Double.toString(result));

					}catch(NumberFormatException e){
						inputField.setForeground(Color.RED);
					}
				}
			}	else if( rightRadioButton.isSelected()){
				String s = resultField.getText().trim();
				if( s.length() > 0){
					try{
						double value = Double.valueOf(s);
						double result = unitConverter.convert(value,(Unit) resultUnitBox.getSelectedItem(),(Unit) inputUnitBox.getSelectedItem());
						//String resultString = String.format("%.2f", result);
						inputField.setForeground(Color.BLACK);
						inputField.setText(Double.toString(result));

					}catch(NumberFormatException e){
						//System.out.println("Input is not a number");
						resultField.setForeground(Color.RED);
					}
				}
			}

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}
	}
}
