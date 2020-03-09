package prolab;

import java.util.ArrayList;

public class Listeleme {
	static ArrayList<Pokemon> pokes = new ArrayList<Pokemon>();
	static ArrayList<Pokemon> oyuncuKart = new ArrayList<Pokemon>();
	static ArrayList<Pokemon> pcKart = new ArrayList<Pokemon>(); 
        public void listeleme() {
    		
            
        	
        		
            pokes.add(new Charmander("Charmander","Ates" , getClass().getResource("charmanders.jpg") ));
    		pokes.add(new Pikachu("Pikachu","Elektrik",getClass().getResource("pikachu.jpg")));
    		pokes.add(new Bulbasaur("Bulbasaur","Cim",getClass().getResource("bulbasaur.jpg")));
    		pokes.add(new Squirtle("Squirtle","Su",getClass().getResource("squirtle.jpg")));
    		pokes.add(new Zubat("Zubat","Hava",getClass().getResource("zubat.jpg")));
    		pokes.add(new Psyduck("Psyduck","Su",getClass().getResource("psyduck.jpg")));
    		pokes.add(new Snorlax("Snorlax","Normal",getClass().getResource("Snorlax.jpg")));
    		pokes.add(new Butterfree("Butterfree","Hava",getClass().getResource("butterfree.jpg")));
    		pokes.add(new Jigglypuff("Jigglypuff","Ses",getClass().getResource("jiglypuf.jpg")));
    		pokes.add(new Meowth("Meowth","Normal",getClass().getResource("meowth.jpg")));

    		
    		    
    		
    		
    		for(int i=0; i<3; i++) {	
    					
    				int sayi = (int)(Math.random()*pokes.size());
    		    
    		   
    		    if(pokes.get(sayi).kartDestedeMi==true) {
    		    	i--;
    		    	continue;
    		    }
    		    oyuncuKart.add(pokes.get(sayi));
    		    pokes.get(sayi).kartDestedeMi=true;					
    		}
    		
    		for(int i=0; i<3; i++) {	
    					
    				int sayi = (int)(Math.random()*pokes.size());
    		    
    		   
    		    if(pokes.get(sayi).kartDestedeMi==true) {
    		    	i--;
    		    	continue;
    		    }
    		    pcKart.add(pokes.get(sayi));
    		    pokes.get(sayi).kartDestedeMi=true;	
    		    
    		    
    		}
    		

    		
    		
    		
             
        }
}
