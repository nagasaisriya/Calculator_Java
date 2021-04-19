import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.applet.*;
/*
<applet code="Calculator" width=300 height =200>
</applet>
*/

public class Calculator extends JApplet implements ActionListener{
String msg=" ";
int v1,v2,result;
char op;
JButton[] b=new JButton[10];
JTextField t1;
JButton ad,sub,mul,div,mod,clr,eq;
public void init(){
setBackground(Color.pink);
setLayout(new GridLayout(5,4));

//setSize(800,800);
//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
t1=new JTextField(10);
for(int i=0;i<10;i++)
{b[i]=new JButton(""+i);}
ad=new JButton("+");
sub=new JButton("-");
mul=new JButton("*");
div=new JButton("/");
mod=new JButton("%");
clr=new JButton("clr");
eq=new JButton("=");
add(t1);
for(int i=0;i<10;i++)
{
add(b[i]);
}
add(ad);
add(sub);
add(mul);
add(div);
add(mod);
add(clr);
add(eq);
for(int i=0;i<10;i++)
{b[i].addActionListener(this);}
ad.addActionListener(this);
sub.addActionListener(this);
mul.addActionListener(this);
div.addActionListener(this);
mod.addActionListener(this);
clr.addActionListener(this);
eq.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
 String str=ae.getActionCommand();
 char ch=str.charAt(0);
 if(Character.isDigit(ch))
 {t1.setText(t1.getText()+str);}
 else if(str.equals("+"))
 {v1=Integer.parseInt(t1.getText());
  op='+';
  t1.setText("");}
else if(str.equals("-"))
 {v1=Integer.parseInt(t1.getText());
  op='-';
  t1.setText("");
 }
else if(str.equals("*"))
 {v1=Integer.parseInt(t1.getText());
  op='*';
  t1.setText("");
 }
else if(str=="/")
 {v1=Integer.parseInt(t1.getText());
  op='/';
  t1.setText("");
 }
else if(str.equals("%"))
 {v1=Integer.parseInt(t1.getText());
  op='%';
  t1.setText("");
 }
else if(str.equals("="))
{
  v2=Integer.parseInt(t1.getText());
  if(op=='+')
   {result=v1+v2;}
  else if(op=='-')
   {result=v1-v2;}
  else if(op=='*')
   {result=v1*v2;}
  else if(op=='/')
  {
   try{
      result=v1/v2;
      } 
   catch(ArithmeticException e)
   {JOptionPane.showMessageDialog(this,"Division by zero error");
   }
  }
  else if(op=='%')
  {
  if(v2!=0)
  {result=v1%v2;}
  }
  t1.setText(String.valueOf(result));
}
if(str.equals("clr"))
  { t1.setText("");}
}
}