package project.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

///// 삭제가 완료됐을 때 /////
public class CautionPage2 extends JFrame {


   public CautionPage2() {
      
      // button setting
     JOptionPane.showMessageDialog(null, "삭제되었습니다");

      // OK button event
      System.out.println("ok event");
         
         // ok 누르면 목록으로 이동
//         new SelectPage();
         setVisible(false);
      
   } // end of constructor

} // end of class
