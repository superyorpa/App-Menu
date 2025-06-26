/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author radit
 */

package aplikasimenu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class MainClass extends JWindow{
    private Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();
    private JLabel labelLogo = new JLabel(new ImageIcon("C:/Users/user/Documents/campus/semester-4/apache-netbeans.png"));
    private JProgressBar barisProgres = new JProgressBar();
    private int time = 0;
    private Timer timer;

    public MainClass() { 
        Color warna = Color.blue;

        barisProgres.setValue(0);
        barisProgres.setPreferredSize(new Dimension(100, 15));
        barisProgres.setBackground(Color.white);
        barisProgres.setForeground(Color.red);
        barisProgres.setStringPainted(true);
        barisProgres.setBorder(new LineBorder(warna, 1));
        labelLogo.setBorder(new LineBorder(warna, 1));

        getContentPane().add(labelLogo, BorderLayout.NORTH);
        getContentPane().add(barisProgres, BorderLayout.CENTER);

        timer = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                time++;
                barisProgres.setValue(time);
                if (barisProgres.getPercentComplete() == 1.0) {
                    timer.stop();
                    setVisible(false);
                    
                    SwingUtilities.invokeLater(() -> {
                        new FormLogin().setVisible(true);
                    });
                }
            }
        });
        
        timer.start();
        pack();
        setLocation(dimensi.width / 2 - getWidth() / 2, dimensi.height / 2 - getHeight() / 2);
        setVisible(true);
    }
 
    public static void main(String[] args) { 
        new MainClass();
    }
}