import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class calculatorpt1 {

	
	
	//making a JFrame with a title
	private JFrame frame = new JFrame("Calculator");
	
	//textArea
	JTextArea txtScreen = new JTextArea(5,20);
	
	//panels to add on the JFrame
	private JPanel panelNums, panelFunctions, panelNumberMode, layoutPanel;
	
	//buttons and labels to display hex,binary,octal
	private JButton hexLab = new JButton("HEX");
	private JLabel hexValue = new JLabel("0");
	
	private JButton octLab = new JButton("OCT");
	private JLabel octValue = new JLabel("0");
	
	private JButton binLab = new JButton("BIN");
	private JLabel binValue = new JLabel("0");
	
	private JButton decLab = new JButton("DEC");
	private JLabel decValue = new JLabel("0");
	
	
    //equals button
	private JButton btnEqual = new JButton("=");
	
	//holds the first number
	String strNum1 ="";
	//holds the second num
	String strNum2 ="";
	//gets the expression in the textscreen
	String statement[];
	
	//after converting to int
	int num1=0;
	int num2 =0;
	int totalvalue =0;
	String strTotal;
	
	
	
	//conversion functoni from decimal to hex,dec
	public void conversion(int totalvalue) {
		
		//Converts decimal to hex, oct, bin 
		hexValue.setText(Integer.toHexString(totalvalue));
		
		decValue.setText(Integer.toString(totalvalue));
		
		octValue.setText(Integer.toOctalString(totalvalue));
		
		binValue.setText(Integer.toBinaryString(totalvalue));
		
		
		//Converts hex, oct, bin to decimal
		/*
		hexValue.setText(Integer.parseInt(txtScreen.getText(),  16)+ "");
		
		octValue.setText(Integer.parseInt(txtScreen.getText(),  8)+ "");
		
		binValue.setText(Integer.parseInt(txtScreen.getText(),  2)+ "");

		decValue.setText(Integer.parseInt(txtScreen.getText(),  10)+ "");
		*/
	}
	
	//code from the textbook
	public Integer precedence(String str)
	{
		Stack<Integer> operandStack = new Stack<>();
		
		Stack<Character> operatorStack = new Stack<>();
		
		str= space(str);
		
		
		String[] tokens = str.split(" ");
		
		for(String token: tokens)
		{
			if (token.length() == 0)
			{
				continue;
			}
			else if (token.charAt(0) == '+' || token.charAt(0) == '-')
			{
				while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-' || operatorStack.peek() == '*' || operatorStack.peek() == '/')) 
				{	
					processOperator(operandStack, operatorStack);
				}
				
				operatorStack.push(token.charAt(0));
			}
			else if (token.charAt(0) == '*' || token.charAt(0) == '/') 
			{ 
				while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/'))
				{
						processOperator(operandStack, operatorStack);
				}
				
				operatorStack.push(token.charAt(0));
				
			}
			else if (token.trim().charAt(0) == '(')
			{
				operatorStack.push('('); 
			}
			else if (token.trim().charAt(0) == ')')
			{
				while (operatorStack.peek() != '(')
				{
					processOperator(operandStack, operatorStack);
				}
				
				operatorStack.pop(); 
			}
			else 
			{
				operandStack.push(new Integer(token));
			}
	
		}
		
		while (!operatorStack.isEmpty())
		{
			processOperator(operandStack, operatorStack);
		}
		
		
		return operandStack.pop(); 
	}
	
	
	//Do the calculation from the stack
	public static void processOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		
		char op = operatorStack.pop();
	    int op1 = operandStack.pop();
		int op2 = operandStack.pop();
		
		if (op == '+') 
		{
			operandStack.push(op2 + op1);
		}
		else if (op == '-') 
		{
			operandStack.push(op2 - op1);
		}
		else if (op == '*') 
		{
			operandStack.push(op2 * op1);
		}
		else if (op == '/') 
		{
			operandStack.push(op2 / op1);
		}
		
	}
	
	
	//add spaces in expression to push into stack
	public static String space(String s) {
		String result = "";
		for(int i =0; i<s.length(); i++) {
			if(s.charAt(i) == '(' || s.charAt(i)== ')' || s.charAt(i)== '+' ||s.charAt(i) =='-'||  s.charAt(i)== '*'|| s.charAt(i)== '/') {
				result += " " + s.charAt(i) + " ";
			}
			else 
			{
				result += s.charAt(i);
			}
		}
		return result;
	}

	//flag variable to call the parantheses
	boolean parentheses = false; 
	
	
	//JButtons for  numbers and etc
	private JButton arr = new JButton("\u2191");
	private JButton plus_minus = new JButton("\u00B1");
	private JButton backSpace = new JButton("\u232B");
	private JButton btn0 = new JButton("0");
	private JButton btn1 = new JButton("1");
	private JButton btn2 = new JButton("2");
	private JButton btn3 = new JButton("3");
	private JButton btn4 = new JButton("4");
	private JButton btn5 = new JButton("5");
	private JButton btn6 = new JButton("6");
	private JButton btn7 = new JButton("7");
	private JButton btn8 = new JButton("8");
	private JButton btn9 = new JButton("9");

	
	//Alphabetic buttons
	private JButton btnA = new JButton("A");
	private JButton btnB = new JButton("B");
	private JButton btnC = new JButton("C");
	private JButton btnD = new JButton("D");
	private JButton btnE = new JButton("E");
	private JButton btnF = new JButton("F");


	//ICON Buttons above 
	private JButton btnMOD = new JButton("MOD");
	private JButton btnCE = new JButton("CE");
	private JButton btnClear = new JButton("C");
	
	//operation buttons
	private JButton btnDIV = new JButton("\u00F7");
	private JButton btnMULT = new JButton("\u2715");
	private JButton btnADD = new JButton("+");
	private JButton btnSUB = new JButton("-");

	//Parentheses
	private JButton btnLeftPar = new JButton("(");
	private JButton btnRightPar = new JButton(")");
	
	//period button
	private JButton period = new JButton(".");
	
	
	//misc icons
	private JButton btnLSH = new JButton("LSH");
	private JButton btnRSH = new JButton("RSH");
	private JButton btnOR = new JButton("OR");
	private JButton btnXor = new JButton("Xor");
	private JButton btnNot = new  JButton("NOT");
	private JButton btnAND = new JButton("And");
	private JButton KB1 = new JButton("\uE75f");
	private JButton KB2 = new JButton("::");
	private JButton btnWord = new JButton("Word");
	private JButton btnWORD = new JButton("");
	
	
	
	private JButton btnMS = new JButton("MS");
	private JButton btnM_ = new JButton("M+");
	
	

	
	//empty panel
	


	

	//add layout panel to main panel(in-between two other panels)
	//mainpanel.add
	
	
	
	
	
	public calculatorpt1() {
		
		//Clear button, sets everything to zero
		btnClear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				num1 = 0; 
				num2 = 0; 
				txtScreen.setText("");
				hexValue.setText("");
				binValue.setText("");
				octValue.setText("");
				decValue.setText("");
			
			}
		}
		);
		
		
		//backSpace button
		backSpace.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				StringBuilder str = new StringBuilder(txtScreen.getText());
				//deletes one character on the textScreen
				str.deleteCharAt(txtScreen.getText().length()-1);
				strTotal = str.toString();
				txtScreen.setText(strTotal);
				
			}
		});
		
		
		btnCE.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {
				StringBuilder str = new StringBuilder(txtScreen.getText());
				str.deleteCharAt(txtScreen.getText().length()-1);
				strTotal = str.toString();
				txtScreen.setText(strTotal);
			}
		});
		
		
		//Appends all the buttons
		btn0.setSize(30, 30);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("0");
			}
			});
		
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("1");
			}
			});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("2");
			}
			});
		
		
		arr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("\u2191");
				
			}
			});
		
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("3");
			}
			});
		
		
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("4");
			}
			});
		
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("5");
			}
			});
		
		
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("6");
			}
			});
		
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("7");
			}
			});
		

		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("8");
			}
			});
		
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("9");
			}
			});
		
		
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("A");
			}
			});

		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("B");
			}
			});
		
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("C");
			}
			});
	
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("D");
			}
			});
		
		
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("E");
			}
			});
	
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("F");
			}
			});
		
		
	
		btnMOD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("MOD");
			}
			});		
	
		btnDIV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("/");
			}
			});
		
		
		btnMULT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("*");
			}
			});
		
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("+");
			}
			});
	
		btnSUB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("-");
			}
			});
		
		btnLeftPar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append("(");
				parentheses = true; 
				
			}
			});
		
		btnRightPar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append(")");
				parentheses = true; 
		
			}
			});
		
		period.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtScreen.append(".");
			}
			});
		
		

		
		//EQUALS BUTTON CONTAINS ALL THE OPERATIONS
		
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtScreen.getText().contains("*")) {
					
					if (parentheses == true)
					{
						String value = txtScreen.getText();
						Integer result = precedence(value);
						conversion(result);
						parentheses = false; 
					}
					else 
					{
						statement = txtScreen.getText().split("\\*");
						strNum1 =statement[0];
						strNum2 =statement[1];
						
				
						num1 = Integer.parseInt(strNum1);
						num2 = Integer.parseInt(strNum2);
						
						totalvalue = num1*num2;
						
						conversion(totalvalue);
	
						
						strTotal =Integer.toString(totalvalue);
						txtScreen.setText(strTotal);
					}
				}
				else if(txtScreen.getText().contains("+")) {
					
					if (parentheses == true )
					{
						String value = txtScreen.getText(); 
						Integer result = precedence(value); 
						conversion(result);
						parentheses = false;
					}
					else 
					{
						statement = txtScreen.getText().split("\\+");
						strNum1 =statement[0];
						strNum2 =statement[1];
						

						num1 = Integer.parseInt(strNum1);
						num2 = Integer.parseInt(strNum2);
						
						totalvalue = num1+num2;
						
						conversion(totalvalue);
	
	
						strTotal =Integer.toString(totalvalue);
						txtScreen.setText(strTotal);
					}
				}
				else if(txtScreen.getText().contains("-")) {
					
					if (parentheses == true )
					{
						String value = txtScreen.getText(); 
						Integer result = precedence(value);
						conversion(result);
						parentheses = false;
					}
					else 
					{
						statement = txtScreen.getText().split("\\-");
						strNum1 =statement[0];
						strNum2 =statement[1];
					
						num1 = Integer.parseInt(strNum1);
						num2 = Integer.parseInt(strNum2);
						
						totalvalue = num1-num2;
						
						conversion(totalvalue);
	
						strTotal =Integer.toString(totalvalue);
						txtScreen.setText(strTotal);
					}
				}
				else if(txtScreen.getText().contains("/"))
				{
					if (parentheses == true )
					{
						String value = txtScreen.getText(); 
						Integer result = precedence(value);
						conversion(result); 
						parentheses = false;
					}
					else
					{
						statement = txtScreen.getText().split("\\/");
						strNum1 =statement[0];
						strNum2 =statement[1];
						
						num1 = Integer.parseInt(strNum1);
						num2 = Integer.parseInt(strNum2);
						
						totalvalue = (num1)/(num2);
						conversion(totalvalue);
	
						strTotal =Integer.toString(totalvalue);
						txtScreen.setText(strTotal);
					}
					
				}else if(txtScreen.getText().contains("MOD"))
				{
					statement = txtScreen.getText().split("MOD");
					strNum1 =statement[0];
					strNum2 =statement[1];
					
					num1 = Integer.parseInt(strNum1);
					num2 = Integer.parseInt(strNum2);
					totalvalue= num1 % num2;
					strTotal =Integer.toString(totalvalue);
					txtScreen.setText(strTotal);
				}else if(txtScreen.getText().contains("\u2191")) {
					statement = txtScreen.getText().split("\u2191");
					strNum1 =statement[0];
					strNum2 =statement[1];
					
					num1 = Integer.parseInt(strNum1);
					num2 = Integer.parseInt(strNum2);
					totalvalue= (int) Math.pow(num1, num2);
					strTotal =Integer.toString(totalvalue);
					txtScreen.setText(strTotal);
				}else if(txtScreen.getText().contains("."))
				{
					txtScreen.setText(txtScreen.getText() + ".");
				}
				
				
				}
			
			});
		
		//ALL THE LAYOUT STUFF
		//Used flow layout and grid layout
		
		//initialized the JPanels
		panelNums = new JPanel();
		panelFunctions = new JPanel();
		layoutPanel = new JPanel();
		panelNumberMode = new JPanel();
		
		//set layout  Panel to BorderLayout
		layoutPanel.setLayout( new BorderLayout());
		JPanel mainPanel = new JPanel();
		
		//add the mainPanel to the frame
		frame.add(mainPanel);
		
		//The panel with the main buttons is GridLayout
		panelFunctions.setLayout(new GridLayout(7,7,2,2));
		//
		mainPanel.add(panelNums, BorderLayout.WEST);
		panelNums.add(txtScreen);

		mainPanel.add(layoutPanel);
		mainPanel.add(panelFunctions);
		
		panelNumberMode.setLayout(new GridLayout(4,2));
		
		
		//sets a layout panel to align panel Number Mode to left
		layoutPanel.add(panelNumberMode, BorderLayout.EAST);
		
		
		//add hex, dec, bin, octal buttons and labels to the panelNumberMode
		panelNumberMode.add(hexLab);
		panelNumberMode.add(hexValue);
		panelNumberMode.add(decLab);
		panelNumberMode.add(decValue);
		panelNumberMode.add(octLab);
		panelNumberMode.add(octValue);
		panelNumberMode.add(binLab);
		panelNumberMode.add(binValue);
		
		
		//Add in order of what you want to display becasue it is in gridLayout
		panelFunctions.add(KB1);
		panelFunctions.add(KB2);
		panelFunctions.add(btnWORD);
		panelFunctions.add(btnWord);
		panelFunctions.add(btnMS);
		panelFunctions.add(btnM_);
		panelFunctions.add(btnLSH);
		panelFunctions.add(btnRSH);
		panelFunctions.add(btnOR);
		panelFunctions.add(btnXor);
		panelFunctions.add(btnNot);
		panelFunctions.add(btnAND);
		panelFunctions.add(arr);
		panelFunctions.add(btnMOD);
		panelFunctions.add(btnCE);
		panelFunctions.add(btnClear);
		panelFunctions.add(backSpace);
		panelFunctions.add(btnDIV);
		panelFunctions.add(btnA);
		panelFunctions.add(btnB);
		panelFunctions.add(btn7);
		panelFunctions.add(btn8);
		panelFunctions.add(btn9);
		panelFunctions.add(btnMULT);
		panelFunctions.add(btnC);
		panelFunctions.add(btnD);
		panelFunctions.add(btn4);
		panelFunctions.add(btn5);
		panelFunctions.add(btn6);
		panelFunctions.add(btnSUB);
		panelFunctions.add(btnE);
		panelFunctions.add(btnF);
		panelFunctions.add(btn1);
		panelFunctions.add(btn2);
		panelFunctions.add(btn3);
		panelFunctions.add(btnADD);
		panelFunctions.add(btnLeftPar);
		panelFunctions.add(btnRightPar);
		panelFunctions.add(plus_minus);
		panelFunctions.add(btn0);
		panelFunctions.add(period);
		panelFunctions.add(btnEqual);

		btnWORD.setEnabled(false);




		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);;
		
		frame.setResizable(false);
		frame.setSize(450, 400);
				
	}
	
	
	public static void main (String args[]) {
		
		new calculatorpt1();
		
		
	}
}






