import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class OnlineTest extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    OnlineTest(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            //System.out.println("correct ans="+count);  
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: Which racer holds the record for the most Grand Prix wins?");  
            jb[0].setText("Lewis Hamilton");jb[1].setText("Micheal Schumacher");jb[2].setText("Nikki Lauda");jb[3].setText("Aryton Senna");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: Which boxer was known as “The Greatest” and “The People’s Champion”?");  
            jb[0].setText("Mike Tyson");jb[1].setText("Muhammad Ali");jb[2].setText("Floyd Mayweather");jb[3].setText("Manny Pacquiao");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: What is often seen as the smallest unit of memory?");  
            jb[0].setText("MegaByte");jb[1].setText("Gigabyte");jb[2].setText("Kilobyte");jb[3].setText("Terabyte");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: What is the symbol for potassium?");  
            jb[0].setText("K");jb[1].setText("Na");jb[2].setText("O");jb[3].setText("Pt");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: Which planet has the most gravity?");  
            jb[0].setText("Earth");jb[1].setText("Saturn");jb[2].setText("Mars");jb[3].setText("Jupiter");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: What name does deer meat go by?");  
            jb[0].setText("Venison");jb[1].setText("Veal");jb[2].setText("Beef");jb[3].setText("Calamari");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: Which kind of alcohol is Russia is notoriously known for? ");  
            jb[0].setText("Beer");jb[1].setText("Rum");jb[2].setText("Vodka");  
                        jb[3].setText("Tequila");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: What is your body’s largest organ?");  
            jb[0].setText("Heart");jb[1].setText("Lungs");jb[2].setText("Kidney");  
                        jb[3].setText("Skin");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: Which element is said to keep bones strong?");  
            jb[0].setText("Sodium");jb[1].setText("Barium");jb[2].setText("Calcium");jb[3].setText("Potassium");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: Which infinity stone was located on Vormir?");  
            jb[0].setText("Soul Stone");jb[1].setText("Space Stone");jb[2].setText("Mind Stone");  
                        jb[3].setText("Power Stone");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[0].isSelected());  
        if(current==1)  
            return(jb[1].isSelected());  
        if(current==2)  
            return(jb[2].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[3].isSelected());  
        if(current==5)  
            return(jb[0].isSelected());  
        if(current==6)  
            return(jb[2].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[2].isSelected());  
        if(current==9)  
            return(jb[0].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new OnlineTest("Online Test Of Java");  
    }  
}  
