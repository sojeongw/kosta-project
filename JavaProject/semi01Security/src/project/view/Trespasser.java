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
		     JOptionPane.showMessageDialog(null, "ħ���� ����!");

		      // OK button event
		      System.out.println("ok event");
		         
		         // ok ������ ������� �̵�
		      
		      ctrl.RandomInv();
		      setVisible(false);
		      
		   } // end of constructor



}