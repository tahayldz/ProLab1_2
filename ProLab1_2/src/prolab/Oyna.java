package prolab;

import java.util.ArrayList;


public class Oyna {
        static Listeleme liste=new Listeleme();
        static Oyuncu bilgisayar = new Pc("00","Bilgisayar");
        static Oyuncu kullanici = new Kullanici("11","Kullanici");
       static int userSkor=0,pcSkor=0;
        public static void vsSkor(int userSecim, int pcSecim) {
        	 	
        	int oyuncuKarti=Listeleme.oyuncuKart.get(userSecim).hasarPuaniGoster(); 
            int pcKarti=Listeleme.pcKart.get(pcSecim).hasarPuaniGoster();
            
             
            
            if(oyuncuKarti>pcKarti) {
                
            	Oyuncu.skor=Oyuncu.skor+5;
            	
                              
           }
                          
            else if(pcKarti>oyuncuKarti) {
           	  
            	
               Pc.skor=Pc.skor+5;
             
             
           }
           
            else {
            	Pc.skor=Pc.skor+0;
            	Oyuncu.skor=Oyuncu.skor+0;
            }
              	
        }
        
        public static int kartCekUser(ArrayList<Pokemon> pokes) {        	
        	
        	int random = (int)(Math.random()*10);
             	
                if(Listeleme.pokes.get(random).kartDestedeMi==true) {
                	
                   return Oyna.kartCekUser(Listeleme.pokes);
                }
                   Listeleme.pokes.get(random).kartDestedeMi=true;

                   

        
                return random  ;      
        
        }
        
        public static int kartCekPc(ArrayList<Pokemon> pokes) {
            
           int random = (int)(Math.random()*10);
        	
           if(Listeleme.pokes.get(random).kartDestedeMi==true) {
        	     
        	     return Oyna.kartCekPc(Listeleme.pokes);
           }
              Listeleme.pokes.get(random).kartDestedeMi=true;                        
            return random;
        }
        
        public static void sifirla() {
        	Listeleme.pokes.clear();
        	Listeleme.oyuncuKart.clear();
        	Listeleme.pcKart.clear();
        	Pc.skor=0;
        	Oyuncu.skor=0;

	    	
        }


}