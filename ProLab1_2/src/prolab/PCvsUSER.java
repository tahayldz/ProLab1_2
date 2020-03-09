package prolab;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PCvsUSER extends javax.swing.JFrame {
      
	private static final long serialVersionUID = 1L;
	static Listeleme liste = new Listeleme();
	  static Kullanici user = new Kullanici("001122","taha");
	  static Pc pc = new Pc("001122","pc");
   
    public PCvsUSER() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        
    	javax.swing.JLabel oyuncu[] = new javax.swing.JLabel[3];
    	javax.swing.JLabel bilgisayar[] = new javax.swing.JLabel[3];
    	
        for(int i=0;i<3;i++) {
        	oyuncu[i]=new JLabel();
        	bilgisayar[i]=new JLabel();
        }
        
        for(int i=0;i<3;i++) {
            oyuncu[i].setText("oyuncu"+i);
            oyuncu[i].setPreferredSize(new java.awt.Dimension(150, 300));
            bilgisayar[i].setText("bilgisayar"+i);
            bilgisayar[i].setPreferredSize(new java.awt.Dimension(150, 300));
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
                	ImageIcon iconOyuncu = new ImageIcon(Listeleme.oyuncuKart.get(i).img);
                	oyuncu[i].setIcon(iconOyuncu);
                	ImageIcon iconBilgisayar = new ImageIcon(Listeleme.pcKart.get(i).img);
                	bilgisayar[i].setIcon(iconBilgisayar);
                	
                			}               
            }

			private void jButton1ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				
			}
        }); 
        
        

        jButton2.setText("Kart Çek");
        jButton2.addMouseListener(new MouseAdapter() {
            
        	

			private void jButton2ActionPerformed(MouseEvent e) {
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
        	
        	
        	public void mouseClicked(MouseEvent e) {                           	
        		 jButton2ActionPerformed(e); 
        		for(int i=0;i<3;i++) {

                	if(oyuncu[i].isVisible()==false) {
                		int userSayi = Oyna.kartCekUser(Listeleme.pokes);
                        Listeleme.oyuncuKart.add(Listeleme.pokes.get(userSayi));
                		ImageIcon iconOyuncu = new ImageIcon(Listeleme.pokes.get(userSayi).img);
                		oyuncu[i].setIcon(iconOyuncu);
                		oyuncu[i].setVisible(true);
                		
                	}

                
                	                	
                }

                for(int i=0;i<3;i++) {
                	 
                     if(bilgisayar[i].isVisible()==false) {
                    	 int pcSayi = Oyna.kartCekPc(Listeleme.pokes);
                    	 Listeleme.pcKart.add(Listeleme.pokes.get(pcSayi));
                    	 ImageIcon iconBilgisayar = new ImageIcon(Listeleme.pokes.get(pcSayi).img);
                    	 bilgisayar[i].setIcon(iconBilgisayar);
                    	 bilgisayar[i].setVisible(true);
                    	 
                     }
                }

                
             
            }

        });
           
        

            userskor.setText("USER SKOR:  "+0);
	        pcskor.setText("PC SKOR : "+0);
	        

        oyuncu[0].addMouseListener(new MouseAdapter(){
        	
			private void oyuncuActionPerformed(MouseEvent e) {
				int sayac=0;
				for(int i=0; i<3;i++) {
					if(oyuncu[i].isVisible()==false) {
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
        		
                int userSecim = 0;

    		  
        		
        	  int pcSecim = pc.KartSec(Listeleme.pcKart);

    		  
        	  Oyna.vsSkor(userSecim, pcSecim);
    		 
    		
    		  userskor.setText("USER SKOR:  "+Oyuncu.skor);  
	        pcskor.setText("PC SKOR : "+Pc.skor);
	         
    		       		
              jLabel9.setIcon(oyuncu[userSecim].getIcon());                 
              Listeleme.oyuncuKart.remove(userSecim);
              oyuncu[userSecim].setIcon(null);
              
              for(int i=0;i<3;i++) {
              oyuncu[i].setVisible(false);
              }
              
              for(int i=0;i<Listeleme.oyuncuKart.size();i++) {
            	  ImageIcon iconOyuncu = new ImageIcon(Listeleme.oyuncuKart.get(i).img);
            		  oyuncu[i].setIcon(iconOyuncu);
            	      oyuncu[i].setVisible(true);
              }
               
              jLabel6.setIcon(bilgisayar[pcSecim].getIcon());
              bilgisayar[pcSecim].setIcon(null);
              Listeleme.pcKart.remove(pcSecim);
              
              for(int i=0;i<3;i++) {
              bilgisayar[i].setVisible(false);
              }
              for(int i=0;i<Listeleme.pcKart.size();i++) {
            	  ImageIcon iconBilgisayar = new ImageIcon(Listeleme.pcKart.get(i).img);
            		  bilgisayar[i].setIcon(iconBilgisayar);
            	      bilgisayar[i].setVisible(true);
              }


              oyuncuActionPerformed(e);
                }
        	
            
        });
        
        oyuncu[1].addMouseListener(new MouseAdapter(){
			private void oyuncuActionPerformed(MouseEvent e) {
				int sayac=0;
				for(int i=0; i<3;i++) {
					if(oyuncu[i].isVisible()==false) {
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
				      rootPane.setVisible(false);
				}
				}
				
			}
        	public void mouseClicked(MouseEvent e) {
        		
        		
              int userSecim = 1;

      		
        	  int pcSecim = pc.KartSec(Listeleme.pcKart);

    		  
        	  Oyna.vsSkor(userSecim, pcSecim);
    		 
    		
    		  userskor.setText("USER SKOR:  "+Oyuncu.skor);  
	        pcskor.setText("PC SKOR : "+Pc.skor);
	         
    		       		
              jLabel9.setIcon(oyuncu[userSecim].getIcon());                 
              Listeleme.oyuncuKart.remove(userSecim);
              oyuncu[userSecim].setIcon(null);
              
              for(int i=0;i<3;i++) {
              oyuncu[i].setVisible(false);
              }
              
              for(int i=0;i<Listeleme.oyuncuKart.size();i++) {
            	  ImageIcon iconOyuncu = new ImageIcon(Listeleme.oyuncuKart.get(i).img);
            		  oyuncu[i].setIcon(iconOyuncu);
            	      oyuncu[i].setVisible(true);
              }
               
              jLabel6.setIcon(bilgisayar[pcSecim].getIcon());
              bilgisayar[pcSecim].setIcon(null);
              Listeleme.pcKart.remove(pcSecim);
              
              for(int i=0;i<3;i++) {
              bilgisayar[i].setVisible(false);
              }
              for(int i=0;i<Listeleme.pcKart.size();i++) {
            	  ImageIcon iconBilgisayar = new ImageIcon(Listeleme.pcKart.get(i).img);
            		  bilgisayar[i].setIcon(iconBilgisayar);
            	      bilgisayar[i].setVisible(true);
              }
   
              oyuncuActionPerformed(e);
              
                }
            
        });
        oyuncu[2].addMouseListener(new MouseAdapter(){
			private void oyuncuActionPerformed(MouseEvent e) {
				int sayac=0;
				for(int i=0; i<3;i++) {
					if(oyuncu[i].isVisible()==false) {
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
				      rootPane.setVisible(false);
				}
				}
				
			}
        	public void mouseClicked(MouseEvent e) {
        		
                  int userSecim = 2;           

          		
            	  int pcSecim = pc.KartSec(Listeleme.pcKart);

        		  
            	  Oyna.vsSkor(userSecim, pcSecim);
        		 
        		
        		  userskor.setText("USER SKOR:  "+Oyuncu.skor);  
    	        pcskor.setText("PC SKOR : "+Pc.skor);
    	         
        		       		
                  jLabel9.setIcon(oyuncu[userSecim].getIcon());                 
                  Listeleme.oyuncuKart.remove(userSecim);
                  oyuncu[userSecim].setIcon(null);
                  
                  for(int i=0;i<3;i++) {
                  oyuncu[i].setVisible(false);
                  }
                  
                  for(int i=0;i<Listeleme.oyuncuKart.size();i++) {
                	  ImageIcon iconOyuncu = new ImageIcon(Listeleme.oyuncuKart.get(i).img);
                		  oyuncu[i].setIcon(iconOyuncu);
                	      oyuncu[i].setVisible(true);
                  }
                   
                  jLabel6.setIcon(bilgisayar[pcSecim].getIcon());
                  bilgisayar[pcSecim].setIcon(null);
                  Listeleme.pcKart.remove(pcSecim);
                  
                  for(int i=0;i<3;i++) {
                  bilgisayar[i].setVisible(false);
                  }
                  for(int i=0;i<Listeleme.pcKart.size();i++) {
                	  ImageIcon iconBilgisayar = new ImageIcon(Listeleme.pcKart.get(i).img);
                		  bilgisayar[i].setIcon(iconBilgisayar);
                	      bilgisayar[i].setVisible(true);
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
                        .addComponent(oyuncu[1], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(563, Short.MAX_VALUE)
                                .addComponent(bilgisayar[0], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bilgisayar[2], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bilgisayar[1], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userskor, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pcskor, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(oyuncu[2], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(oyuncu[0], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(365, 365, 365)
                        .addComponent(jButton1)))
                .addGap(221, 221, 221))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bilgisayar[2], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bilgisayar[1], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bilgisayar[0], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pcskor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(userskor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oyuncu[2], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oyuncu[1], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oyuncu[0], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            java.util.logging.Logger.getLogger(PCvsUSER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PCvsUSER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PCvsUSER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PCvsUSER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PCvsUSER().setVisible(true);
            }
        });
    }

                  
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public javax.swing.JLabel oyuncu[];
    public javax.swing.JLabel bilgisayar[];
    private javax.swing.JLabel jLabel6;

    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel pcskor;
    private javax.swing.JLabel userskor;
    
                 
}