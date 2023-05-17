/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minitest;



/**
 *
 * @author Hans Langa
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class telap extends JFrame{

  
    
    private JTextField a1;
    private JTextField a2;
    private JLabel rs;
     private JLabel hsc;
     private List<String> hist;


public  telap(){
//fechar o tela
   
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //titulo
    setTitle(" Calculadora");
  setSize(300,300);
  
setLayout(new FlowLayout());

//Codigo para centralizar o jFrame
setLocationRelativeTo(null);

//Codigo de painel

    JPanel fundo=new JPanel();
    fundo.setSize(200,300);
    fundo.setBackground(Color.red);


a1=new JTextField(60);
a2=new JTextField(60);


   rs=new JLabel("=");
   hsc=new JLabel("Historico");
  
   hsc.setLocation(200, 500);
   
   //Botoes para realizar as operacoes
   
   JButton mais=new JButton("+");
   JButton menos=new JButton("-");
   JButton vezes=new JButton("*");
   JButton divisao=new JButton("/");
   JButton exp = new JButton("^");
   JButton resto=new JButton("%");
   JButton divI=new JButton("?");
   JButton fat=new JButton("!");
   
  
   
   //Adicionar os labels,botoes... a ajnela
   //Adicionamos com o nome da varivel
   
   add(fundo);
   add(a1);
   add(a2);
   add(mais);
   add(menos);
   add(vezes);
   add(divisao);
   add(exp);
   add(resto);
   add(divI);
   add(fat);
    add(rs);
   add(hsc);



hist=new ArrayList();


// Lista de eventos para os btns

mais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               operacao("+");
            }
        });

        // accao  para o botão de subtração
        menos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacao("-");
            }
        });

        // accao  para o botão de multiplicação
        vezes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacao("*");
            }
        });

        // accao  para o botão de divisão
        divisao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacao("/");
            }
        });

        // accao  para o botão de exponenciação
        exp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacao("^");
            }
        });

        // accao para o botão de resto da divisão
        resto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacao("%");
            }
        });

       
        divI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacao("?");
            }
        });

        // Event listener para o botão de fatorial
        fat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacao("!");
            }
        });
        
    }



  private double fat(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fat(n - 1);
    }
  
  
    private void updatehist() {
        StringBuilder historyText = new StringBuilder("<html>Historico:<br>");
        for (String operation : hist) {
            historyText.append(operation).append("<br>");
        }
        historyText.append("</html>");
       hsc.setText(historyText.toString());
    }
  
  
  
  
  
private void operacao(String op){
   
   try{ 

double nu1=Double.parseDouble(a1.getText());
double nu2=Double.parseDouble(a2.getText());
   
   double r=0;
   
    switch (op) {
        
        case "+":
            r=nu1+nu2;
          //  System.out.println(r);
            break;
    
        case "-":
            r=nu1-nu2;
            break;
        
        case "*":
            r=nu1*nu2;
            break;
            
        case "/":
            
            //Codigo para verificar se o denominador e diferente de zero
            
            
            if(nu2!=0){
                r=nu1/nu2;
                break;
            }
            else{
       JOptionPane.showMessageDialog(this, "O denominador deve ser diferente de zero","Math Error",JOptionPane.ERROR_MESSAGE);
          return;
            }
            
            
         case "^":
             //MAth.pow e co cod para fazer elevacaoi
                    r = Math.pow(nu1, nu2);
                    break;
                case "%":
                    r = nu1 % nu2;
                    break;
                case "?":
                    r = Math.floorDiv((long) nu1, (long) nu2);
                    break;
                case "!":
                    r = fat((int) nu1);
                    break;
            }
 
    rs.setText("Resultado: " + r);
    
    
      String operation = nu1 + " " + op + " " + nu2 + " = " + r;
            hist.add(operation);

            // Verificar o tamanho do histórico
            if (hist.size() > 10) {
                hist.remove(0); // Remover accoes depois de 10
            }

            // Atualizar historico
            updatehist();
    
   
} catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Insira valores validos");
        }

}

 
   




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