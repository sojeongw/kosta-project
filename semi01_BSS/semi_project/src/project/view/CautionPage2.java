package project.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

///// ������ �Ϸ���� �� /////
public class CautionPage2 extends JFrame {


   public CautionPage2() {
      
      // button setting
     JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�");

      // OK button event
      System.out.println("ok event");
         
         // ok ������ ������� �̵�
//         new SelectPage();
         setVisible(false);
      
   } // end of constructor

} // end of class
