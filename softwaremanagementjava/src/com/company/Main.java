package com.company;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("serial")
public class Main<radio> extends JFrame implements ActionListener{

    /**
     *
     */

    double szazalek = 0;

    String msg;
    JLabel f1;
    JLabel f2;
    JLabel a1;
    JLabel a2;
    JLabel sulykerdes;
    JButton b;
    JFrame cim;
    JRadioButton nogomb;
    JRadioButton ferfigomb;
    JRadioButton gyerekgomb;
    JRadioButton fiatalgomb;
    JRadioButton felnottgomb;
    JRadioButton idosgomb;
    JRadioButton aktivgomb;
    JRadioButton inaktivgomb;
    JTextField héjpörgönc;



    Main() throws InterruptedException {

        cim = new JFrame();
        cim.setForeground(Color.BLUE);
        cim.setFont(new Font("Ink Free", Font.PLAIN, 12));
        cim.setTitle("Mennyire eröltetheted a hátad?");
        cim.setBounds(100, 100, 450, 300);

        f1=new JLabel("Férfi vagy Nő vagy?");
        f1.setBounds(10,10,300,20);
        add(f1);
        ButtonGroup novagyferfi = new ButtonGroup();
        nogomb=new JRadioButton ("Nő");
        nogomb.setBounds(10,30,150,20);
        add(nogomb);
        ferfigomb=new JRadioButton("Férfi");
        ferfigomb.setBounds(10,50,150,20);
        add(ferfigomb);
        b=new JButton("Eredmény");
        b.setBounds(115,320,150,30);
        b.addActionListener(this);
        add(b);
        novagyferfi.add(ferfigomb);
        novagyferfi.add(nogomb);

        f2=new JLabel("Hány éves vagy?");
        f2.setBounds(230,10,300,20);
        add(f2);
        ButtonGroup kor = new ButtonGroup();
        gyerekgomb=new JRadioButton("0-14(Gyerek) "); //Gyerek
        gyerekgomb.setBounds(230,30,150,20);
        add(gyerekgomb);
        fiatalgomb=new JRadioButton("15-24(Fiatal) ");  //Fiatal
        fiatalgomb.setBounds(230,50,150,20);
        add(fiatalgomb);
        felnottgomb=new JRadioButton("25-54(Felnőtt) ");  //Felnőtt
        felnottgomb.setBounds(230,70,150,20);
        add(felnottgomb);
        idosgomb=new JRadioButton("55- (Idős)");  //Idős
        idosgomb.setBounds(230,90,150,20);
        add(idosgomb);
        kor.add(gyerekgomb);
        kor.add(felnottgomb);
        kor.add(fiatalgomb);
        kor.add(idosgomb);


        héjpörgönc = new JTextField();
        cim.getContentPane().add(héjpörgönc, BorderLayout.EAST);
        héjpörgönc.setBounds(230,170,150,50);
        add(héjpörgönc);


        a1= new JLabel("Aktív vagy sportban?");
        a1.setBounds(10,140,150,20);
        add(a1);
        ButtonGroup aktivvagynem = new ButtonGroup();
        aktivgomb=new JRadioButton("Igen");
        aktivgomb.setBounds(10,160,150,20);
        add(aktivgomb);
        inaktivgomb=new JRadioButton("Nem");
        inaktivgomb.setBounds(10,180,150,20);
        add(inaktivgomb);
        aktivvagynem.add(aktivgomb);
        aktivvagynem.add(inaktivgomb);


        sulykerdes = new JLabel("Hány kiló vagy?");
        sulykerdes.setBounds(230,140,150,20);
        add(sulykerdes);

        setBounds(500,500,400,400);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        b.addActionListener(this);


    }

    public void actionPerformed(ActionEvent e) {
        if (nogomb.isSelected()) {
            if (gyerekgomb.isSelected()) {
                szazalek = 7.56;
            }
            if (fiatalgomb.isSelected()) {
                if (aktivgomb.isSelected()) {
                    szazalek = 15;
                }
                if (inaktivgomb.isSelected()) {
                    szazalek = 13.5;
                }
            }
            if (felnottgomb.isSelected()) {
                if (aktivgomb.isSelected()) {
                    szazalek = 13.5;
                }
                if (inaktivgomb.isSelected()) {
                    szazalek = 12.15;
                }
            }
            if (idosgomb.isSelected()) {

                if (aktivgomb.isSelected()) {
                    szazalek = 10.8;
                }
                if (inaktivgomb.isSelected()) {
                    szazalek = 9.72;
                }
            }
        }
        if (ferfigomb.isSelected()) {
            if (gyerekgomb.isSelected()) {
                szazalek = 10.08;
            }

            if (fiatalgomb.isSelected()) {
                if (aktivgomb.isSelected()) {
                    szazalek = 20;
                }
                if (inaktivgomb.isSelected()) {
                    szazalek = 18;
                }
            }
            if (felnottgomb.isSelected()) {

                if (aktivgomb.isSelected()) {
                    szazalek = 18;
                }
                if (inaktivgomb.isSelected()) {
                    szazalek = 16.2;
                }
            }
            if (idosgomb.isSelected()) {

                if (aktivgomb.isSelected()) {
                    szazalek = 14.4;
                }
                if (inaktivgomb.isSelected()) {
                    szazalek = 12.96;
                }
            }
        }
        if (b.isEnabled()) {
            try {
                String suly = héjpörgönc.getText();
                int sulyszam = Integer.parseInt(suly);
                double eredmeny = (szazalek / 100) * sulyszam;
                JOptionPane.showMessageDialog(this,  eredmeny + " kg nehéz súllyal terhelheti a hátát");
            } catch (Exception i) {
                System.out.println(i + "Rossz a szövegmező tartalma!");
            }
        }
    }

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws InterruptedException {
        new Main();

    }




}
