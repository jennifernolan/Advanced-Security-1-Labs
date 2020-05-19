//Jennifer Nolan_C16517636_Lab1
import java.util.*;
// provides the button and text areas
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//class extends jframe for UI format and implements ActionListener for when buttons are pressed
public class Calculator extends JFrame implements ActionListener{
	
	//create a display for the calculator
	private JFrame frame;
	private JTextField text;
	
	//use array to store values needed to perform arithmetic
	ArrayList<String> num = new ArrayList<String>();
	char symbol = '0';
	
	public Calculator() {
		
		//creating a frame
		frame = new JFrame("Calc");
		frame.setSize(300, 300);
		
		//main panel that will hold both button and textfield sub panels (laid out vertically)
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		
		//creating a text field
		text = new JTextField();
		//text field is not editable i.e. no input output from keyboard
		text.setEditable(false);
		text.setPreferredSize(new Dimension(280,20));
		
		//create text field panel with padding - holds textfield
		JPanel textPan = new JPanel(new FlowLayout(SwingConstants.LEADING, 10, 10));
		textPan.add(text);
		
		//array to set up number buttons 
		JButton[] numbers = new JButton[10];
		
		//fill button array with numbers
		for(int i = 0; i < 10; i++)
		{
			numbers[i] = new JButton(Integer.toString(i));
		}
		
		//Setup arithemtic numbers
		JButton clear = new JButton("C");
		JButton multi = new JButton("*");
		JButton add = new JButton("+");
		JButton minus = new JButton("-");
		JButton divide = new JButton("/");
		JButton equals = new JButton("=");
		JButton decimal = new JButton(".");
		
		//Add the actionlistener to the buttons
		for(int i = 0; i < 10; i++)
		{
			numbers[i].addActionListener(this);
		}
		clear.addActionListener(this);
		multi.addActionListener(this);
		add.addActionListener(this);
		minus.addActionListener(this);
		divide.addActionListener(this);
		equals.addActionListener(this);
		decimal.addActionListener(this);
		
		//panel to display arithmetic buttons
		JPanel buttonPanel = new JPanel();
		//layout buttons in grid form and add padding around them to seperate
		buttonPanel.setLayout(new GridLayout(4,4,4,4));
		
		//add buttons to sub panel
		for(int i = 0; i < 10; i++)
		{
			buttonPanel.add(numbers[i]);
		}
		
		buttonPanel.add(clear);
		buttonPanel.add(multi);
		buttonPanel.add(add);
		buttonPanel.add(minus);
		buttonPanel.add(divide);
		buttonPanel.add(equals);
		buttonPanel.add(decimal);
		
		//add subpanels to main panel
		main.add(textPan);
		main.add(buttonPanel);
		
		//Display the window
		frame.add(main);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent action) {
		//used to allow for multiple digits and if total from previous equation added to array for further equation
		String num1 = text.getText();
		//store the name of the event
		String event = action.getActionCommand();
		
		if(event.charAt(0) >= '0' && event.charAt(0) <= '9' || event.charAt(0) == '.') {
			//take in multiple digits
			num1 = num1.concat(action.getActionCommand());
			//show the text in the text field
			text.setText(num1);
		} else if (event.charAt(0) == '+' || event.charAt(0) == '-' || event.charAt(0) == '*'|| event.charAt(0) == '/'){
			//to identify the symbol entered to know which function to go to later
			symbol = event.charAt(0);
			num.add(num1);
			text.setText("");
		} // when equals is hit go to function to perform arithmetic 
		else if (event.charAt(0) == '=') {
			if(symbol == '+') {
				num.add(num1);
				addition(num);
			} else if(symbol == '-') {
				num.add(num1);
				subtraction(num);
			} else if(symbol == '*') {
				num.add(num1);
				multiplication(num);
			} else if(symbol == '/') {
				num.add(num1);
				division(num);
			}
		} else if (event.charAt(0) == 'C') {
			//if clear is selected change variables back to empty
			num.clear();
			symbol = '0';
			text.setText("");
		}
	}
	
	//function for divison
	public void division(ArrayList<String> array) {
		text.setText("");
		float sum = 1;
		int count = 0;
		
		for(String value: array) {
			//if in the first element in the array, divide the first entered number by one to recieve the entered number as the new sum
			if(count == 0) {
				sum = Float.parseFloat(value) / sum;
				count ++;
			} else {
				sum = sum / Float.parseFloat(value);
			}
		}
		
		//print the total of the sum
		String total = Float.toString(sum);
		//clear array for any other arithmetic
		num.clear();
		text.setText(total);
	}
	
	//function for multiplication
	public void multiplication (ArrayList<String> array) {
		text.setText("");
		//set the sum to one so the first element in the array multiplied by one equals makes the first element the new sum
		float sum = 1;
		
		for(String value: array) {
			sum = sum * Float.parseFloat(value);
		}
		
		String total = Float.toString(sum);
		//clear array for any other arithmetic
		num.clear();
		text.setText(total);
	}
	
	//function for subtraction
	public void subtraction(ArrayList<String> array) {
		text.setText("");
		float sum = 0;
		int count = 0;
		
		for(String value: array) {
			//if in the first element in the array, subtract the sum from the first entered number to recieve the entered number as the new sum
			if(count == 0) {
				sum = Float.parseFloat(value) - sum;
				count ++;
			} else {
				sum = sum - Float.parseFloat(value);
			}
		}
		
		String total = Float.toString(sum);
		//clear array for any other arithmetic
		num.clear();
		text.setText(total);
	}
	
	//function for addition
	public void addition(ArrayList<String> array) {
		text.setText("");
		float sum = 0;
		
		for(String value: array) {
			sum = sum + Float.parseFloat(value);
		}
		
		String total = Float.toString(sum);
		//clear array for any other arithmetic
		num.clear();
		text.setText(total);
	}
	
	//main function for display for the calculator
	public static void main(String[] args) {
		Calculator calc = new Calculator();
	}
}