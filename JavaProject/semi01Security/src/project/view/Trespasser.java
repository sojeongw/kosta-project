package project.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import project.control.RoomCtrl;
import project.control.RoomCtrlImpl;
import project.model.RoomDAO;
import project.model.RoomDAOimpl;
import project.model.RoomVO;

public class Trespasser extends JFrame {

	RoomCtrl ctrl = new RoomCtrlImpl();

	   public Trespasser() {
           
		      
		      // button setting
		     JOptionPane.showMessageDialog(null, "침입자 감지!");

		      // OK button event
		      System.out.println("ok event");
		         
		         // ok 누르면 목록으로 이동
		      
		      ctrl.RandomInv();
		      setVisible(false);
		      
		   } // end of constructor



}