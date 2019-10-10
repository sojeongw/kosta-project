package project.view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import project.control.FireSMS;
import project.control.InvSMS;
import project.control.RoomCtrl;
import project.control.RoomCtrlImpl;
import project.model.RoomDAO;
import project.model.RoomDAOimpl;
import project.model.RoomVO;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class HomePage extends JFrame {

   RoomVO vo = new RoomVO();
   RoomDAO rDAO = new RoomDAOimpl();
   RoomCtrl rCNT;

   // 버튼, 패널 생성 //
   protected JButton room_1 = new JButton("1번방");
   protected JButton room_2 = new JButton("2번방");
   protected JButton room_3 = new JButton("3번방");
   protected JButton room_4 = new JButton("4번방");
   protected JButton room_5 = new JButton("5번방");
   protected JButton room_6 = new JButton("6번방");
   protected JButton room_7 = new JButton("7번방");
   protected JButton room_8 = new JButton("8번방");
   private final JButton room_9 = new JButton("9번방");
   private final JButton room_10 = new JButton("10번방");
   private final JButton room_11 = new JButton("11번방");
   private final JButton room_12 = new JButton("12번방");
   private final JButton room_13 = new JButton("13번방");
   private final JButton room_14 = new JButton("14번방");
   private final JButton room_15 = new JButton("15번방");
   private final JButton room_16 = new JButton("16번방");
   private final JButton room_17 = new JButton("17번방");
   private final JButton room_18 = new JButton("18번방");
   protected final JButton fire = new JButton("화재");
   protected final JButton invasion = new JButton("침입");
   private final JButton list = new JButton("목록");
   private final JButton exit_btn = new JButton("종료");
   private final JPanel panel = new JPanel();
   private final JPanel panel_1 = new JPanel();

   
   public HomePage() {
      Container con = getContentPane();
      
      // 크기 조정 //
      room_1.setBounds(1, 1, 100, 150);	
      room_2.setBounds(111, 1, 100, 150);
      room_3.setBounds(221, 1, 100, 150);
      room_4.setBounds(331, 1, 100, 150);
      room_5.setBounds(441, 1, 100, 150);
      room_6.setBounds(551, 1, 100, 150);
      room_7.setBounds(661, 1, 100, 150);
      room_8.setBounds(111, 160, 100, 150);
      room_9.setBounds(221, 160, 100, 150);
      room_10.setBounds(331, 160, 100, 150);
      room_11.setBounds(441, 160, 100, 150);
      room_12.setBounds(551, 160, 100, 150);
      room_13.setBounds(661, 160, 100, 150);
      room_14.setBounds(221, 320, 100, 150);
      room_15.setBounds(331, 320, 100, 150);
      room_16.setBounds(441, 320, 100, 150);
      room_17.setBounds(551, 320, 100, 150);
      room_18.setBounds(661, 320, 100, 150);
      

      room_1.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            vo.setR_num(1);		// num에 1번을 넣어준다.
            vo = rDAO.selectOne(vo);	// select에 vo 값을 넣어줌
            if (vo.getR_name() == null) {		// 만약 name에 null 값이 들어왔다면 아직 정의되지 않은것
               vo.setR_num(1);		// 방번호를 알기위해 값이 없어도 1번을 넣어줌
            }
            new MenuPage(vo);		// MenuPage 로 이동
         }
      });

      room_2.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            vo.setR_num(2);
            vo = rDAO.selectOne(vo);
            if (vo.getR_name() == null) {		
                vo.setR_num(2);		
             }
            new MenuPage(vo);
         }
      });
      

      room_3.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {

            vo.setR_num(3);
            vo = rDAO.selectOne(vo);
            if (vo.getR_name() == null) {
               vo.setR_num(3);
            }
            new MenuPage(vo);

         }
      });

      room_4.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            vo.setR_num(4);
            vo = rDAO.selectOne(vo);
            if (vo.getR_name() == null) {
               vo.setR_num(4);
            }
            new MenuPage(vo);

         }
      });

      room_5.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            vo.setR_num(5);
            vo = rDAO.selectOne(vo);
            if (vo.getR_name() == null) {
               vo.setR_num(5);
            }
            new MenuPage(vo);
         }
      });

      room_6.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            vo.setR_num(6);
            vo = rDAO.selectOne(vo);
            if (vo.getR_name() == null) {
               vo.setR_num(6);
            }
            new MenuPage(vo);
         }
      });

      room_7.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            vo.setR_num(7);
            vo = rDAO.selectOne(vo);
            if (vo.getR_name() == null) {
               vo.setR_num(7);
            }
            new MenuPage(vo);
         }
      });

      room_8.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            vo.setR_num(8);
            vo = rDAO.selectOne(vo);
            if (vo.getR_name() == null) {
               vo.setR_num(8);
            }
            new MenuPage(vo);
         }
      });
      
      room_9.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            vo.setR_num(9);
            vo = rDAO.selectOne(vo);
            if (vo.getR_name() == null) {
               vo.setR_num(9);
            }
            new MenuPage(vo);
         }
      });
      
      room_10.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            vo.setR_num(10);
            vo = rDAO.selectOne(vo);
            if (vo.getR_name() == null) {
               vo.setR_num(10);
            }
            new MenuPage(vo);
         }
      });
      
      room_11.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            vo.setR_num(11);
            vo = rDAO.selectOne(vo);
            if (vo.getR_name() == null) {
               vo.setR_num(11);
            }
            new MenuPage(vo);
         }
      });
      
      
      room_12.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            vo.setR_num(12);
            vo = rDAO.selectOne(vo);
            if (vo.getR_name() == null) {
               vo.setR_num(12);
            }
            new MenuPage(vo);
         }
      });
      
      
      room_13.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            vo.setR_num(13);
            vo = rDAO.selectOne(vo);
            if (vo.getR_name() == null) {
               vo.setR_num(13);
            }
            new MenuPage(vo);
         }
      });
      
      room_14.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            vo.setR_num(14);
            vo = rDAO.selectOne(vo);
            if (vo.getR_name() == null) {
               vo.setR_num(14);
            }
            new MenuPage(vo);
         }
      });
      
      room_15.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            vo.setR_num(15);
            vo = rDAO.selectOne(vo);
            if (vo.getR_name() == null) {
               vo.setR_num(15);
            }
            new MenuPage(vo);
         }
      });
      
      room_16.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            vo.setR_num(16);
            vo = rDAO.selectOne(vo);
            if (vo.getR_name() == null) {
               vo.setR_num(16);
            }
            new MenuPage(vo);
         }
      });
      
      room_17.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            vo.setR_num(17);
            vo = rDAO.selectOne(vo);
            if (vo.getR_name() == null) {
               vo.setR_num(17);
            }
            new MenuPage(vo);
         }
      });
      
      room_18.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            vo.setR_num(18);
            vo = rDAO.selectOne(vo);
            if (vo.getR_name() == null) {
               vo.setR_num(18);
            }
            new MenuPage(vo);
         }
      });
      

      list.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {

            new SelectPage();
         }
      });

      fire.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
        	rCNT = new RoomCtrlImpl();
            rCNT.RandomFire();			// fire를 랜덤돌림
            //new FireSMS();			// sms 페이지로 이동
            int fire_num = rCNT.FireDetect();		// FireDetect 로 화재 방 찾음
            System.out.println(fire_num);
            switch (fire_num) {						// 방 번호별로 빨간색 만듦			
            case 1:
               room_1.setBackground(Color.RED);
               break;
            case 2:
               room_2.setBackground(Color.RED);
               break;
            case 3:
               room_3.setBackground(Color.RED);
               break;
            case 4:
               room_4.setBackground(Color.RED);
               break;
            case 5:
               room_5.setBackground(Color.RED);
               break;
            case 6:
               room_6.setBackground(Color.RED);
               break;
            case 7:
               room_7.setBackground(Color.RED);
               break;
            case 8:
               room_8.setBackground(Color.RED);
               break;
            case 9:
               room_9.setBackground(Color.RED);
               break;
            case 10:
               room_10.setBackground(Color.RED);
               break;
            case 11:
               room_11.setBackground(Color.RED);
               break;
            case 12:
               room_12.setBackground(Color.RED);
               break;
            case 13:
               room_13.setBackground(Color.RED);
               break;
            case 14:
               room_14.setBackground(Color.RED);
               break;
            case 15:
               room_15.setBackground(Color.RED);
               break;
            case 16:
               room_16.setBackground(Color.RED);
               break;
            case 17:
               room_17.setBackground(Color.RED);
               break;
            case 18:
               room_18.setBackground(Color.RED);
               break;
            }

            new AlertPage(fire_num);		// AlertPage 로 들어감
            switch (fire_num) {				// 0.5초 후 원래 색으로 돌아옴
            case 1:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_1.setBackground(Color.getColor("Panel.background"));
               }

               break;
            case 2:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_2.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 3:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_3.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 4:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_4.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 5:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_5.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 6:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_6.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 7:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_7.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 8:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_8.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 9:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_9.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 10:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_10.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 11:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_11.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 12:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_12.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 13:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_13.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 14:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_14.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 15:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_15.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 16:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_16.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 17:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_17.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 18:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_18.setBackground(Color.getColor("Panel.background"));
               }
               break;
            }
         }
      });

      invasion.addActionListener(new ActionListener() {		// 화재와 똑같음
         @Override
         public void actionPerformed(ActionEvent e) {
            rCNT = new RoomCtrlImpl();
        	rCNT.RandomInv();
           // new InvSMS();
            int inv_num = rCNT.InvDetect();
            System.out.println(inv_num);
            switch (inv_num) {
            case 1:
               room_1.setBackground(Color.ORANGE);
               break;
            case 2:
               room_2.setBackground(Color.ORANGE);
               break;
            case 3:
               room_3.setBackground(Color.ORANGE);
               break;
            case 4:
               room_4.setBackground(Color.ORANGE);
               break;
            case 5:
               room_5.setBackground(Color.ORANGE);
               break;
            case 6:
               room_6.setBackground(Color.ORANGE);
               break;
            case 7:
               room_7.setBackground(Color.ORANGE);
               break;
            case 8:
               room_8.setBackground(Color.ORANGE);
               break;
            }

            new AlertPage2(inv_num);
            switch (inv_num) {
            case 1:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_1.setBackground(Color.getColor("Panel.background"));
               }

               break;
            case 2:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_2.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 3:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_3.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 4:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_4.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 5:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_5.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 6:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_6.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 7:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_7.setBackground(Color.getColor("Panel.background"));
               }
               break;
            case 8:
               try {
                  TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e1) {
                  e1.printStackTrace();
               } finally {
                  room_8.setBackground(Color.getColor("Panel.background"));
               }
               break;
            }
         }
      });
      getContentPane().setLayout(null);
      
      // 버튼 생성 //
      con.add(room_1);
      con.add(room_2);
      con.add(room_3);
      con.add(room_4);

      con.add(panel);
      
      // 패널 생성 //
      panel.setBounds(784, 1, 200, 150);
      panel.setLayout(new GridLayout(2, 1, 10, 10));
      panel_1.setBounds(784, 161, 288, 70);

      // 버튼 생성 //
      panel.add(fire);
      panel.add(invasion);

      panel_1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
      panel_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
      getContentPane().add(panel_1);

      list.setBounds(new Rectangle(0, 0, 200, 70));
      list.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      panel_1.setLayout(null);
      list.setAlignmentX(Component.RIGHT_ALIGNMENT);
      list.setHorizontalTextPosition(SwingConstants.CENTER);
      list.setPreferredSize(new Dimension(45, 45));

      panel_1.add(list);
      
      
      con.add(room_5);
      con.add(room_6);
      con.add(room_7);
      con.add(room_8);
      con.add(room_9);
      con.add(room_10);
      con.add(room_11);
      con.add(room_12);
      con.add(room_13);
      con.add(room_14);
      con.add(room_15);
      con.add(room_16);
      con.add(room_17);
      con.add(room_18);

      
      exit_btn.addActionListener(new ActionListener() {		// 시스템 종료
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
      });
      
      
      exit_btn.setPreferredSize(new Dimension(45, 45));
      exit_btn.setHorizontalTextPosition(SwingConstants.CENTER);
      exit_btn.setBounds(new Rectangle(0, 0, 200, 70));
      exit_btn.setAlignmentX(1.0f);
      exit_btn.setBounds(784, 400, 200, 70);
      
      getContentPane().add(exit_btn);
      
      JLabel lblProduc = new JLabel("produced by Team2");
      lblProduc.setBounds(12, 487, 129, 15);
      getContentPane().add(lblProduc);

      setTitle("방 목록");
      setBounds(0, 0, 1000, 550);
      setVisible(true);
   }
}