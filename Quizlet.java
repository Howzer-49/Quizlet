/*This is a simple quiz project made by Nandish Panchal and Nishit Thakkar
the code itself isnt very long nor is it very confusing 
also it does not rely heavily on OOP concepts but rather it 
depends on in depth knowledge about the language itself as well as its packages
*/
import java.awt.event.*;
import javax.swing.*;

/*We are using the above packages in order to create a window based application
java.awt is used to develop GUI's or window based applications, but it is heavily platform dependent
java.awt.event is used solely to make up for its backward compability 
javax.swing is similar to java.awt but unlike it java swing provides platform independent and lightweight components
*/

class Quizlet extends JFrame implements ActionListener { 
    /*JLabel sets a display area for a short text string or an image or both
    JRadioButton is an implementation of a radio button - an item that can be selected or deselected and that displays its state to the user
    JButton is an implementation of a "push" button
    ButtonGroup is used to create a multiple-exclusion scope for a set of buttons
    */
    JLabel l;
    JRadioButton jb[] = new JRadioButton[5];
    JButton b1, b2;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];
    /*The constructor creates the window along with the buttons to be used during execution 
    We create an object of the JLabel class followed by using another function from the swing package which 
    adds a specified component to the container
    next we create an object of the class ButtonGroup and again add it to the container in a sequential manner
    */
    Quizlet(String s) {
        super(s);
        l = new JLabel();
        add(l);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        /*Here we introduce two new buttons 'Next' and 'Bookmark'
        and we subsequently add them to the list
        */
        b1 = new JButton("Next");
        b2 = new JButton("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);
        add(b2);
        set();
        //These are all the visual parameters and their boundaries
        l.setBounds(30, 40, 450, 20);
        jb[0].setBounds(50, 80, 100, 20);
        jb[1].setBounds(50, 110, 100, 20);
        jb[2].setBounds(50, 140, 100, 20);
        jb[3].setBounds(50, 170, 100, 20);
        b1.setBounds(100, 240, 100, 30);
        b2.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }
    /*actionPerformed checks what action has been performed and how to deal with it
    ActionEvent is invoked whenever a button is pressed and therefore it keeps track on what is pressed
    */
    public void actionPerformed(ActionEvent e) {
        //the first if block pertains to the next button and the corresponding action
        if (e.getSource() == b1) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 9) {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        //second if block comes into action whenever the bookmark button is pressed and its subsequent actions
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        //This keeps track of all the bookmarks at the end and creates buttons for them to get back to the question
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }
        //result is the last button to be active in the application and is used to exit the application
        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            // We have used JOptionPane to create a result window which shows the result
            // In essence it is similar to System.out.println("correct ans="+count);
            // However we have used a window to make it seem more user friendly
            JOptionPane.showMessageDialog(this, "Total correct ans =" + count);
            System.exit(0);
        }
    }
/*The following function is the qustionaire part of the program
where answers are set to a corresponding button and later we check if the answer is correct
*/
    void set() {
        jb[4].setSelected(true);
        if (current == 0) {
            l.setText("Que1: Which country won the 2014 FIFA World Cup?");
            jb[0].setText("Italy");
            jb[1].setText("Brazil");
            jb[2].setText("Spain");
            jb[3].setText("Germany");
        }
        if (current == 1) {
            l.setText("Que2: Which boxer was known as “The Greatest” and “The People’s Champion”?");
            jb[0].setText("Mike Tyson");
            jb[1].setText("Muhammad Ali");
            jb[2].setText("Floyd Mayweather");
            jb[3].setText("Manny Pacquiao");
        }
        if (current == 2) {
            l.setText("Que3: What is often seen as the smallest unit of memory?");
            jb[0].setText("MegaByte");
            jb[1].setText("Gigabyte");
            jb[2].setText("Kilobyte");
            jb[3].setText("Terabyte");
        }
        if (current == 3) {
            l.setText("Que4: What is the symbol for potassium?");
            jb[0].setText("K");
            jb[1].setText("Na");
            jb[2].setText("O");
            jb[3].setText("Pt");
        }
        if (current == 4) {
            l.setText("Que5: Which planet has the most gravity?");
            jb[0].setText("Earth");
            jb[1].setText("Saturn");
            jb[2].setText("Mars");
            jb[3].setText("Jupiter");
        }
        if (current == 5) {
            l.setText("Que6: What name does deer meat go by?");
            jb[0].setText("Venison");
            jb[1].setText("Veal");
            jb[2].setText("Beef");
            jb[3].setText("Calamari");
        }
        if (current == 6) {
            l.setText("Que7: Which kind of alcohol is Russia is notoriously known for? ");
            jb[0].setText("Beer");
            jb[1].setText("Rum");
            jb[2].setText("Vodka");
            jb[3].setText("Tequila");
        }
        if (current == 7) {
            l.setText("Que8: What is your body’s largest organ?");
            jb[0].setText("Heart");
            jb[1].setText("Lungs");
            jb[2].setText("Kidney");
            jb[3].setText("Skin");
        }
        if (current == 8) {
            l.setText("Que9: Which element is said to keep bones strong?");
            jb[0].setText("Sodium");
            jb[1].setText("Barium");
            jb[2].setText("Calcium");
            jb[3].setText("Potassium");
        }
        if (current == 9) {
            l.setText("Que10: Which infinity stone was located on Vormir?");
            jb[0].setText("Soul Stone");
            jb[1].setText("Space Stone");
            jb[2].setText("Mind Stone");
            jb[3].setText("Power Stone");
        }
        l.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            jb[j].setBounds(50, 80 + i, 200, 20);
    }
    /* Here the code checks for the correct answer in the form of if statements
    isSelected() returns the state of the button, i.e, if jb[3] has been clicked then
    it returns true otherwise it is false
    the below button states are the answers for the questions
    */ 
    boolean check() {
        if (current == 0)
            return (jb[3].isSelected());
        if (current == 1)
            return (jb[1].isSelected());
        if (current == 2)
            return (jb[2].isSelected());
        if (current == 3)
            return (jb[0].isSelected());
        if (current == 4)
            return (jb[3].isSelected());
        if (current == 5)
            return (jb[0].isSelected());
        if (current == 6)
            return (jb[2].isSelected());
        if (current == 7)
            return (jb[3].isSelected());
        if (current == 8)
            return (jb[2].isSelected());
        if (current == 9)
            return (jb[0].isSelected());
        return false;
    }

    public static void main(String s[]) {
        new Quizlet("A small quiz");
    }
}
