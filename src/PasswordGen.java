import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import static java.awt.BorderLayout.CENTER;

/**
 * Created by Adharsh on 8/15/2017.
 */
public class PasswordGen extends JFrame{
    public static void main(String args[]){
        //a string containing possible characters in the password
        final String alphabet = "0123456789" +//numbers
                "abcdefghijklmnopqrstuvwxyz" +//lowercase letters
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +//uppercase letters
                "!#$%&'()*+,-:;<=>?@[]^_`{}~";//special characters not including these characters . / \ " |
        final int alphaLength = alphabet.length();//length of alphabet

        int numOfChar;//number of characters in password
        int numOfPass;//number of passwords

        Scanner scanner = new Scanner(System.in);//for user input

        //get number of characters from user

        displayGUI();
        System.out.println("How many characters would you like your password(s) to be? : ");
        numOfChar = scanner.nextInt();

        //get number of passwords
        System.out.println("How many passwords would you like?: ");
        numOfPass = scanner.nextInt();

        //call generate password function
        if(numOfPass > 0 && numOfPass < 200) {
            if(numOfChar > 0 && numOfChar < 200){
                for (int i = 1; i <= numOfPass; i++) {
                    System.out.print("Password " + i + ": ");
                    generatePass(alphabet, alphaLength, numOfChar);
                    System.out.println();
                }
            }
            else {
                System.out.println("The value you provided for the number of characters is not correct");
            }
        }
        else {
            System.out.println("The value you provided for the number of passwords is not correct");
        }
    }
    static void displayGUI(){

        //Frame utilized for gui
        JFrame frame = new JFrame("Password Generation");//initialize the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set the frame to close

        //create panel and add to frame
        JPanel panel = new JPanel();
        frame.add(panel);

        //create and add label to panel
        JLabel optionLabel = new JLabel("Choose an option: ");
        optionLabel.setVisible(true);
        panel.add(optionLabel);

        //options for the drop down menu
        String [] options = {"-------------------------", "Option 1: Standard Password Generation", "Option 2: Keyword Encryption"};

        //create and add menu to panel
        JComboBox<String> menu = new JComboBox<String>(options);
        menu.setVisible(true);
        panel.add(menu);
        ActionListener menuAL = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

                }
        };

        //set frame location and size
        frame.setVisible(true);//interesting note: had to place this after the menu otherwise the menu would not appear
        frame.setSize(400,400);
        frame.setLocation(400,200);
    }
    static void generatePass(String alphabet, int length, int num){
        Random rand = new Random();//create a random

        for (int i = 0; i < num; i++) {
            System.out.print(alphabet.charAt(rand.nextInt(length)));//display a random character within the alphabet
        }

    }
}
