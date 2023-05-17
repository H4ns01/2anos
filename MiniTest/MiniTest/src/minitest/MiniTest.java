/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minitest;

import javax.swing.SwingUtilities;

/**
 *
 * @author Hans Langa
 */
public class MiniTest {

   

 public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                telap calc = new telap();
                calc.setVisible(true);
            }
        });
                }
}
