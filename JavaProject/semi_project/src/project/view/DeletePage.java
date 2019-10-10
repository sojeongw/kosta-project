package project.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import project.model.RoomDAO;
import project.model.RoomDAOimpl;
import project.model.RoomVO;


public class DeletePage extends JFrame {
	
   public DeletePage(RoomVO vo) {
      
	   RoomDAO rDAO = new RoomDAOimpl();
	   
      // constructor test
      System.out.println("Delete Page...");
      
      
      // button setting
      int input = JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?", 
                     "Delete Page", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

      // OK button event
      if(input == JOptionPane.OK_OPTION)
      {
         System.out.println("delete event");
         
         rDAO.delete(vo.getR_num());
         
         setVisible(false);
         new CautionPage2();
      }
      
      // CANCEL button event
      if(input == JOptionPane.CANCEL_OPTION)
      {
         System.out.println("cancel event");
         
         // cancel ������ update �ϴ� â���� �̵�
         setVisible(false);
         
         new MenuPage(vo);
      }


   } // end of constructor

} // end of class
