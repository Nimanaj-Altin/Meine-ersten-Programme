package rechner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rechner implements ActionListener{
    
    JFrame frame;
    JTextField textfeld;
    JButton [] numberKnopf = new JButton[10];
    JButton [] funktionsKnöpfe = new JButton[13];
    JButton addKnopf, subKnopf, mulKnopf, divKnopf;
    JButton dezimalKnopf, gleichKnopf, löschenKnopf, leerenKnopf, negetivKnopf;
    JButton eulerscheZahl, pi, xHochZwei, wurzel;
    JPanel panel;
    
    Font schriftart = new Font("Arial", Font.BOLD,30);
    
    double num1 =0, num2 =0, ergebnis=0;
    char operator;
    
    Rechner(){
        
        frame = new JFrame("Rechner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(625, 550);
        frame.setLayout(null);
        
        textfeld = new JTextField();
        textfeld.setBounds(50,25,500,50);
        textfeld.setFont(schriftart);
        textfeld.setEditable(false);
        
        addKnopf            = new JButton("+");
        subKnopf            = new JButton("-");
        mulKnopf            = new JButton("*");
        divKnopf            = new JButton("/");
        
        dezimalKnopf        = new JButton(".");
        gleichKnopf         = new JButton("=");
        löschenKnopf        = new JButton("CC");
        leerenKnopf         = new JButton("C");
        negetivKnopf        = new JButton("+/−");
        
        eulerscheZahl       = new JButton("e");
        pi                  = new JButton("π");
        xHochZwei           = new JButton("x²");
        wurzel              = new JButton("√");
        
        funktionsKnöpfe[0]  = addKnopf;
        funktionsKnöpfe[1]  = subKnopf;
        funktionsKnöpfe[2]  = mulKnopf;
        funktionsKnöpfe[3]  = divKnopf;

        funktionsKnöpfe[4]  = dezimalKnopf;               
        funktionsKnöpfe[5]  = gleichKnopf;
        funktionsKnöpfe[6]  = löschenKnopf;
        funktionsKnöpfe[7]  = leerenKnopf;
        funktionsKnöpfe[8]  = negetivKnopf;
        
        funktionsKnöpfe[9]  = eulerscheZahl;
        funktionsKnöpfe[10] = pi;
        funktionsKnöpfe[11] = xHochZwei;
        funktionsKnöpfe[12] = wurzel;
        
        for(int i=0; i<13; i++){
            funktionsKnöpfe[i].addActionListener(this);
            funktionsKnöpfe[i].setFont(schriftart);
            funktionsKnöpfe[i].setFocusable(false);
        }
        
        for (int i=0; i<10; i++){
            numberKnopf[i] = new JButton(String.valueOf(i));
            numberKnopf[i].addActionListener(this);
            numberKnopf[i].setFont(schriftart);
            numberKnopf[i].setFocusable(false);
        }
        
        negetivKnopf.setBounds  (   50,    430,     166,    50);
        löschenKnopf.setBounds  (   216,   430,     166,    50);
        leerenKnopf.setBounds   (   382,   430,     166,    50);
        
        panel = new JPanel();
        panel.setBounds         (   50,    100,    500,    300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.GRAY);
        
        panel.add(numberKnopf[1]);
        panel.add(numberKnopf[2]);
        panel.add(numberKnopf[3]);
        panel.add(addKnopf);
        panel.add(subKnopf);
        
        panel.add(numberKnopf[4]);
        panel.add(numberKnopf[5]);
        panel.add(numberKnopf[6]);
        panel.add(mulKnopf);
        panel.add(divKnopf);
        
        panel.add(numberKnopf[7]);
        panel.add(numberKnopf[8]);
        panel.add(numberKnopf[9]);        
        panel.add(pi);
        panel.add(eulerscheZahl);
        
        panel.add(dezimalKnopf);
        panel.add(numberKnopf[0]);
        panel.add(gleichKnopf);
        panel.add(xHochZwei);
        panel.add(wurzel);
                
        frame.add(panel);
        frame.add(negetivKnopf);
        frame.add(löschenKnopf);
        frame.add(leerenKnopf);
        frame.add(textfeld);
        frame.setVisible(true);
    }
    public static void main(String args[]){
        
        Rechner rechner = new Rechner();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<10;i++){
            if(e.getSource()== numberKnopf[i]){
                textfeld.setText(textfeld.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()== dezimalKnopf){
            textfeld.setText(textfeld.getText().concat("."));
        }
        if(e.getSource()== addKnopf){
            num1 = Double.parseDouble(textfeld.getText());
            operator ='+';
            textfeld.setText("");
        }
        if(e.getSource()== subKnopf){
            num1 = Double.parseDouble(textfeld.getText());
            operator ='-';
            textfeld.setText("");
        }
        if(e.getSource()== mulKnopf){
            num1 = Double.parseDouble(textfeld.getText());
            operator ='*';
            textfeld.setText("");
        }
        if(e.getSource()== divKnopf){
            num1 = Double.parseDouble(textfeld.getText());
            operator ='/';
            textfeld.setText("");
        }
        if(e.getSource()== gleichKnopf){
            num2 = Double.parseDouble(textfeld.getText());
            
            switch(operator){
            case'+':
                ergebnis = num1+num2;
                break;
            case'-':
                ergebnis = num1-num2;
                break;
            case'*':
                ergebnis = num1*num2;
                break;
            case'/':
                ergebnis = num1/num2;
                break;
            }
            textfeld.setText(String.valueOf(ergebnis));
            num1 = ergebnis;
        }
        if(e.getSource()== löschenKnopf){
            textfeld.setText("");
        }
        if(e.getSource()== leerenKnopf){
            String string = textfeld.getText();
            textfeld.setText("");
            for(int i=0; i<string.length()-1 ;i++){
                textfeld.setText(textfeld.getText()+string.charAt(i));
            }
        }
        if(e.getSource()== negetivKnopf){
            double temp = Double.parseDouble(textfeld.getText());
            temp*=-1;
            textfeld.setText(String.valueOf(temp));
        }
        if(e.getSource()== eulerscheZahl){
            textfeld.setText(textfeld.getText().concat("2.7183"));
        }
        if(e.getSource()== pi){
            textfeld.setText(textfeld.getText().concat("3.1416"));
        }
        if(e.getSource()== xHochZwei){
            double zahl1 = Double.parseDouble(textfeld.getText());
            double hochZahl = zahl1 * zahl1;
            textfeld.setText(String.valueOf(hochZahl));
        }
        if(e.getSource()== wurzel){
            double wurzel1 = Math.sqrt(Double.parseDouble(textfeld.getText()));
            textfeld.setText(String.valueOf(wurzel1));
        }
    }
}