import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;

/*
I had a lot of fun making doing this project
this idea came to me when I graduated HS and I didn't
know what to write for my senior quote and something
like this would've been cool. Im sure there was but I didn't
know. The code is no where near good but it was a good learning
experience and this is my first time using GUI's.
Any improvement tips and feedback is more than welcome!
 */


public class MainSeniorHelper implements ActionListener {

    /*
    Global Vars that will be accessible
    To the GUI method
    There is also an Array of "Option"
    the idea is to be able to add more specific
    Types of Quote Options
     */



    private static JLabel label;
    private static JComboBox choice;
    private static JLabel password;
    private static JButton button;
    private static JLabel success;
    private static JTextField name;
    private static JTextField year;
    private static JLabel usrName;
    private static JLabel yearEntry;
    private static JLabel displayYr;
    private static JLabel displayMessage;

   final static String[] option = {"Senior Quote"};



   /*
   Main Calls the GUI Method and
   Displays it
    */

    public static void main(String[] args)  {

        GUI();

    }

    /*
    generate methods reads from A file I made
    That is filled with random quotes that I like
    I instantiated a while loop
    that reads from the file and outputs
    random quotes
     */

    /*
    while loop goes through the file to count
    how many lines are in the file
    then uses that num to use as a base for the
    randomized var
     */




    static public String generate() throws IOException {

        int totalLines = 0;
        File file = new File("randomQuotes.txt");

        BufferedReader br = null;

        br = new BufferedReader(new FileReader(file));

        while ((br.readLine()) != null) {
            totalLines++;
        }
        br.close();

        br = new BufferedReader(new FileReader(file));

        Random random = new Random();
        int randomInt = random.nextInt(totalLines);
        int count = 0;
        String gen;
        while ((gen = br.readLine()) != null) {
            if (count == randomInt) {
                br.close();
                return gen;
            }
            count++;
        }
        br.close();

        return "gen";



    }




    /*
    GUI Method was made in a separate makes the
    frame panels,buttons and texts found in my GUI
     */


    public static void GUI() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);
        label = new JLabel("Type:");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);


        choice = new JComboBox(option);
        choice.setBounds(100, 20, 165, 25);
        panel.add(choice);


        password = new JLabel("Name");
        password.setBounds(10, 50, 80, 25);
        panel.add(password);

        name = new JTextField();
        name.setBounds(100, 50, 165, 25);
        panel.add(name);

        yearEntry = new JLabel("Year of Grad");
        yearEntry.setBounds(10, 80, 80, 25);
        panel.add(yearEntry);

        year = new JTextField();
        year.setBounds(100, 80, 165, 25);
        panel.add(year);

        button = new JButton("Generate");
        button.setBounds(5, 110, 80, 25);
        button.addActionListener(new MainSeniorHelper());
        panel.add(button);


        success = new JLabel();
        success.setBounds(10, 140, 1000, 25);
        panel.add(success);

        usrName = new JLabel("");
        usrName.setBounds(10, 170, 1000, 25);
        panel.add(usrName);

        displayYr = new JLabel("");
        displayYr.setBounds(10, 190, 1000, 25);
        panel.add(displayYr);

        displayMessage = new JLabel("");
        displayMessage.setBounds(10,230,1000,25);
        panel.add(displayMessage);


        frame.setVisible(true);


    }





    /*
    This method is for when there's an action(buttonPressed)
    and in this i have it take inputs print them out
    along with calling generate() which will
    generate a random quote
     */

    public void actionPerformed(ActionEvent e) {
        String user = name.getText();
        String yr = year.getText();


        try {
            success.setText(generate());
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        usrName.setText("Thank You " + user);
        displayYr.setText("And Congratulations Class of " + yr + "!");
        displayMessage.setText("You Can Hit GENERATE Again to Get New Quote!");


    }


}



