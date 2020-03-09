package prolab;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PCvsPC extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	static Listeleme liste = new Listeleme();
	  static Pc Pc1 = new Pc("001122","pc1");
	  static Pc Pc2 = new Pc("001122","pc2");
   
    public PCvsPC() {
        initComponents();
    }
                  
    private void initComponents() {
          
        liste.listeleme();
        
    	jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        userskor = new javax.swing.JLabel();
        pcskor = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        
    	javax.swing.JLabel pc1[] = new javax.swing.JLabel[3];
    	javax.swing.JLabel pc2[] = new javax.swing.JLabel[3];
    	
        for(int i=0;i<3;i++) {
        	pc1[i]=new JLabel();
        	pc2[i]=new JLabel();
        }
        
        for(int i=0;i<3;i++) {
            pc1[i].setText("oyuncu"+i);
            pc1[i].setPreferredSize(new java.awt.Dimension(150, 300));
            pc2[i].setText("bilgisayar"+i);
            pc2[i].setPreferredSize(new java.awt.Dimension(150, 300));
        }
        jLabel6.setText("jLabel6");
        jLabel6.setPreferredSize(new java.awt.Dimension(150, 300));
        jLabel9.setText("jLabel9");
        jLabel9.setPreferredSize(new java.awt.Dimension(150, 300));
            
        jButton1.setText("Kart Dağıt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
                for(int i=0; i<3;i++) {
                	ImageIcon iconPc1 = new ImageIcon(Listeleme.oyuncuKart.get(i).img);
                	pc1[i].setIcon(iconPc1);
                	ImageIcon iconPc2 = new ImageIcon(Listeleme.pcKart.get(i).img);
                	pc2[i].setIcon(iconPc2);
                	
                			}               
            }

			private void jButton1ActionPerformed(ActionEvent evt) {
			}
        }); 
        
        
        jButton3.setText("Kart Çek");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            protected void jButton3ActionPerformed(ActionEvent evt) {
				int sayac=0;
				for(int i=0; i<10;i++) {
					if(Listeleme.pokes.get(i).kartDestedeMi!=false) {
						sayac++;
					}
				}
				if(sayac==10) {
					JOptionPane.showMessageDialog(rootPane, "Çekilecek kart kalmadı!");
				}
        		
        	}
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
                
                
                
                
               
               for(int i=0;i<3;i++) {
               	if(pc1[i].isVisible()==false) {
               		int userSayi = Oyna.kartCekUser(Listeleme.pokes);
                    Listeleme.oyuncuKart.add(Listeleme.pokes.get(userSayi));
                    ImageIcon iconPc1 = new ImageIcon(Listeleme.pokes.get(userSayi).img);
               		pc1[i].setIcon(iconPc1);
               		pc1[i].setVisible(true);
               	}
               	
               
               	                	
               }

               for(int i=0;i<3;i++) {

                    if(pc2[i].isVisible()==false) {
                     int pcSayi = Oyna.kartCekPc(Listeleme.pokes);
                 	 Listeleme.pcKart.add(Listeleme.pokes.get(pcSayi));
                     ImageIcon iconPc2 = new ImageIcon(Listeleme.pokes.get(pcSayi).img);
                   	 pc2[i].setIcon(iconPc2);
                   	 pc2[i].setVisible(true);
                    }
                    

               }
                
                
            }
        });
          
        userskor.setText("PC1 SKOR:  "+0);
        pcskor.setText("PC2 SKOR : "+0);
        
        
       
        jButton2.setText("Oyna");
        jButton2.addMouseListener(new MouseAdapter() {
			private void oyuncuActionPerformed(MouseEvent e) {
				int sayac=0;
				for(int i=0; i<3;i++) {
					if(pc1[i].isVisible()==false) {
						sayac++;
					}
				}
				String[] args = {};
				if(sayac==3) {
					int answer = JOptionPane.showConfirmDialog(rootPane, "OYUN BİTTİ! \n YENİDEN OYNAMAK İSTER MİSİNİZ?");
				    if (answer == JOptionPane.YES_OPTION) {
				    	Oyna.sifirla();
				     AnaSinif.main(args);
				    } else if (answer == JOptionPane.NO_OPTION) {
				       
				}
				}
				
			}
            public void mouseClicked(MouseEvent e) {
            	
            	int pc1Secim = Pc1.KartSec(Listeleme.oyuncuKart);
            	int pc2Secim = Pc2.KartSec(Listeleme.pcKart);
            	Oyna.vsSkor(pc1Secim, pc2Secim);
                  
      		  userskor.setText("PC1 SKOR:  "+Oyuncu.skor);  
  	        pcskor.setText("PC2 SKOR : "+Pc.skor);
  	         
      		       		
                jLabel9.setIcon(pc1[pc1Secim].getIcon());                 
                Listeleme.oyuncuKart.remove(pc1Secim);
                pc1[pc1Secim].setIcon(null);
                
                for(int i=0;i<3;i++) {
                pc1[i].setVisible(false);
                }
                
                for(int i=0;i<Listeleme.oyuncuKart.size();i++) {
              	  ImageIcon iconOyuncu = new ImageIcon(Listeleme.oyuncuKart.get(i).img);
              		  pc1[i].setIcon(iconOyuncu);
              	      pc1[i].setVisible(true);
                }
                 
                jLabel6.setIcon(pc2[pc2Secim].getIcon());
                pc2[pc2Secim].setIcon(null);
                Listeleme.pcKart.remove(pc2Secim);
                
                for(int i=0;i<3;i++) {
                pc2[i].setVisible(false);
                }
                for(int i=0;i<Listeleme.pcKart.size();i++) {
              	  ImageIcon iconBilgisayar = new ImageIcon(Listeleme.pcKart.get(i).img);
              		  pc2[i].setIcon(iconBilgisayar);
              	      pc2[i].setVisible(true);
                }
                 
                oyuncuActionPerformed(e);             
            }
        });
        

        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pc1[0], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 446, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userskor, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pcskor, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pc2[0], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pc2[1], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(pc2[2], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pc1[1], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pc1[2], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(365, 365, 365)
                        .addComponent(jButton1)))
                .addGap(221, 221, 221))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pc2[2], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pc2[1], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pc2[0], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jButton3)))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pcskor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(userskor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pc1[1], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pc1[0], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pc1[2], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(118, 118, 118))
        );
        
        pack();
    }                    




	public static void goster() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PCvsPC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PCvsPC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PCvsPC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PCvsPC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PCvsPC().setVisible(true);
            }
        });
    }
              
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel6;
   
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel pcskor;
    private javax.swing.JLabel userskor;
    
             
}