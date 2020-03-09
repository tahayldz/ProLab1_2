package prolab;
import java.util.*;

public abstract class Oyuncu {
	public static int skor=0;
	Random r = new Random();
    String oyuncuID;
    String oyuncuAdi;  

    public String getOyuncuID() {
    	return oyuncuID;
    }
    
    public void setOyuncuID(String oyuncuID) {
    	this.oyuncuID=oyuncuID;
    }
    
    public String getOyuncuAdi() {
    	return oyuncuID;
    }
    
    public void setOyuncuAdi(String oyuncuAdi) {
    	this.oyuncuAdi=oyuncuAdi;
    }
    
    public Oyuncu(String oyuncuId,String oyuncuAdi) {
    	setOyuncuID(oyuncuID);
    	setOyuncuAdi(oyuncuAdi);
    }
    
    public abstract int SkorGoster();

    public abstract void KartListe(ArrayList<Pokemon> pokes);
    public abstract int KartSec(ArrayList<Pokemon> pokes);



	

    
}

class Kullanici extends Oyuncu {
	public static int skor=0;

	 
	
	public int getSkor() {
		 return Kullanici.skor;
	 }
	 public void setSkor(int skor) {
		 Kullanici.skor=skor;
	 }
	 
	 public int SkorGoster() {

		 return Kullanici.skor;
	 }
	
	 
	 public Kullanici(String oyuncuID,String oyuncuAdi) {
		 super(oyuncuID,oyuncuAdi);
	 }


	@Override
	public void KartListe(ArrayList<Pokemon> oyuncuKart) {
	       System.out.println("elindeki kartlar:");
	       System.out.println(oyuncuKart);
		
	}

		@Override
		public int KartSec(ArrayList<Pokemon> pokes) {
	    
		 int hasar = pokes.get(0).hasarPuaniGoster();
		 return hasar;
		}
	

 }

class Pc extends Oyuncu {

	public static int skor=0;
	public int getSkor() {
		 return Pc.skor;
	 }
	 public void setSkor(int skor) {
		 Pc.skor=skor;
	 }
	 
	 public int SkorGoster() {

		 return Pc.skor;
	 }
	 
	 public Pc(String oyuncuID,String oyuncuAdi) {
		 super(oyuncuID,oyuncuAdi);
	 }

	 @Override
	 public void KartListe(ArrayList<Pokemon> pcKart) {
	       System.out.println("pc deki kartlar:");
	       System.out.println(pcKart);
		 }
	 public int KartSec(ArrayList<Pokemon> pcKart) {
		 Pc pc = new Pc("001122","taha");
		
       if(pcKart.size()==3) {
        int pcRandom= r.nextInt(3);
 		
 		 if(pcKart.get(pcRandom).kartKullanildimi==true) {
 			 return pc.KartSec(pcKart);
 		 }
     	 pcKart.get(pcRandom).kartKullanildimi=true;
        
        return pcRandom;
        }
       else if(pcKart.size()==2) {
    	   int pcRandom= r.nextInt(2);
    	   if(pcKart.get(pcRandom).kartKullanildimi==true) {
   			 return pc.KartSec(pcKart);
   		 }
       	 pcKart.get(pcRandom).kartKullanildimi=true;
          
          return pcRandom;
    	   
       }
       else {
    	   int pcRandom = 0;
    	   return pcRandom;
       } 
	 }
 }



