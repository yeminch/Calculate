package myc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyCalculate {
	private JFrame jf;
	private JPanel jp1, jp2;
	private JTextField jtf;
	private JButton[] jbs;
	private JButton c_jbs;
	private String str0 = "0";
	private String flag=null;
	private double s1 = 0.0;
	private double s2 = 0.0;

	public MyCalculate() {
		jf = new JFrame("我的计算器");
		jp1 = new JPanel();
		jtf = new JTextField(14);
		jbs = new JButton[16];
		c_jbs = new JButton("C");
		String s = "123+456-789*0.=/";
		for (int i = 0; i < jbs.length; i++) {
			jbs[i] = new JButton(s.substring(i, i + 1));
		}
		init();
		doit();
	}

	private void init() {
		jp1.setLayout(new FlowLayout());
		jp1.add(jtf);
		jp1.add(c_jbs);
		jtf.setEditable(true);

		jtf.setText("0");
		jp2 = new JPanel();
		jp2.setLayout(new GridLayout(4, 4));
		for (int i = 0; i < jbs.length; i++) {
			jp2.add(jbs[i]);
		}
		jf.add(jp1, BorderLayout.NORTH);
		jf.add(jp2, BorderLayout.CENTER);
	}

	public void showMe() {
		jf.setVisible(true);
		jf.setSize(276, 210);
		// jf.pack(); //自动匹配大小
		jf.setLocation(200, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFontAndColor();
	}

	private void setFontAndColor() {
		// 设置字体和颜色
		Font f = new Font("楷体", Font.BOLD, 14);
		jtf.setFont(f);
		Color c = new Color(128, 198, 077);
		c_jbs.setBackground(c);
		jp1.setBackground(Color.DARK_GRAY);
		for (int i = 0; i < jbs.length; i++) {
			jbs[i].setBackground(Color.gray);
		}
	}

	public void doit() {	
		c_jbs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = e.getActionCommand();
				if (str.equals("C")) {
					str0 = "0";
					s1 = 0.0;
					s2 = 0.0;
					flag=null;
					jtf.setText(str0);
				}
			}
		});
		for (int i = 0; i < jbs.length; i++) {
			jbs[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 拿到按钮上的名字
					String str = e.getActionCommand();
					if (str.equals("+")) {
						s2=s1;
						s1=0.0;
						str0 = "0";
						flag="+";
						s1=s2+s1;
					} else if (str.equals("-")) {
						s2=s1;
						s1=0.0;
						str0 = "0";
						flag="-";
						s1=s2-s1;
					} else if (str.equals("*")) {
						s2=s1;
						s1=0.0;
						str0 = "0";
						flag="*";
						s1=s2*s1;
					} else if (str.equals("/")) {
						s2=s1;
						s1=0.0;
						str0 = "0";
						flag="/";
						s1=s2/s1;
					} else if (str.equals("=")) {
						if(flag.equals("+")){
							s1=s2+s1;
						}else if(flag.equals("-")){
							s1=s2-s1;
						}else if(flag.equals("*")){
							s1=s2*s1;
						}else if(flag.equals("/")){
							s1=s2/s1;
						}else{
						}
						flag=null;
						str0 ="0";
					} else {
						str0 = str0 + str;
						s1=Double.parseDouble(str0);
					}
					jtf.setText(s1+"");
				}
			});
		}

	}
}



//
////采用字符串数组方法
//public class MyCalculate implements ActionListener{
//	private JFrame jf;
//	private JPanel jp1, jp2;
//	private JTextField jtf;
//	private JButton[] jbs;
//	private JButton c_jbs;
////	private double s2 = 0.0;
//
//	public MyCalculate() {
//		jf = new JFrame("我的计算器");
//		jp1 = new JPanel();
//		jtf = new JTextField(14);
//		jbs = new JButton[16];
//		c_jbs = new JButton("C");
//		String s = "123+456-789*0.=/";
//		for (int i = 0; i < jbs.length; i++) {
//			jbs[i] = new JButton(s.substring(i, i + 1));
//		}
//		init();
//		doit();
//	}
//
//	private void init() {
//		jp1.setLayout(new FlowLayout());
//		jp1.add(jtf);
//		jp1.add(c_jbs);
//		jtf.setEditable(true);
//
//		jtf.setText("0");
//		jp2 = new JPanel();
//		jp2.setLayout(new GridLayout(4, 4));
//		for (int i = 0; i < jbs.length; i++) {
//			jp2.add(jbs[i]);
//		}
//		jf.add(jp1, BorderLayout.NORTH);
//		jf.add(jp2, BorderLayout.CENTER);
//	}
//
//	public void showMe() {
//		jf.setVisible(true);
//		jf.setSize(276, 210);
//		// jf.pack(); //自动匹配大小
//		jf.setLocation(200, 200);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setFontAndColor();
//	}
//
//	private void setFontAndColor() {
//		// 设置字体和颜色
//		Font f = new Font("楷体", Font.BOLD, 14);
//		jtf.setFont(f);
//		Color c = new Color(128, 198, 077);
//		c_jbs.setBackground(c);
//		jp1.setBackground(Color.DARK_GRAY);
//		for (int i = 0; i < jbs.length; i++) {
//			jbs[i].setBackground(Color.gray);
//		}
//	}
//
//	public void doit() {	
//		c_jbs.addActionListener(this);
//		for(int i = 0; i < jbs.length; i++){
//			jbs[i].addActionListener(this);
//		}
//	}
////	@Override
//	String s1,s2,s3="";
//	public void actionPerformed(ActionEvent e) {
//		String s = e.getActionCommand();
//			if ("0123456789".indexOf(s)!=-1) {
//				jtf.setText(jtf.getText()+s);
//				s1=jtf.getText();
//			}else if("+-*/".indexOf(s)!=-1){
//				jtf.setText("");
//				s2=s;
//				s3=s1;
//			}else if("=".equals(s)){
//				double result=0.0;
//				if(s2.equals("+")){
//					result=Double.parseDouble(s3)+Double.parseDouble(s1);
//				}else if(s2.equals("-")){
//					
//				}else if(s2.equals("*")){
//					
//				}else if(s2.equals("/")){
//					
//				}
//			}else if(".".equals(s)){
//				
//			}else{
//				jtf.setText("0");
//				s1="";s2="";s3="";
//			}
//	}
//}
