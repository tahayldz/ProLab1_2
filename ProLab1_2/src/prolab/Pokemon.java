package prolab;


abstract public class Pokemon {
	public boolean kartKullanildimi=false;
	public boolean kartDestedeMi=false;
	public java.net.URL img;
	public String pokemonAdi;
	public String pokemonTip;


	public String getPokemonAdi() {
		return pokemonAdi;
	}

	public void setPokemonAdi(String pokemonAdi) {
		this.pokemonAdi = pokemonAdi;
	}

	public String getPokemonTip() {
		return pokemonTip;
	}

	public void setPokemonTip(String pokemonTip) {
		this.pokemonTip = pokemonTip;
	}
	
	public java.net.URL getImg() {
		return img;
	}

	public void setImg(java.net.URL img) {
		this.img = img;
	}

	
	public Pokemon(String pokemonAdi, String pokemonTip, java.net.URL img) {
        setPokemonAdi(pokemonAdi);
        setPokemonTip(pokemonTip);
        setImg(img);		
	}


	abstract public int hasarPuaniGoster();
	
	public String toString() {
		
		return "Pokemon: " + this.pokemonAdi +"\n Tip: "+ this.pokemonTip+"\n hasar: "+this.hasarPuaniGoster();
	}
    


	
}

class Charmander extends Pokemon {
	
	private int hasarPuani = 60;
	public static boolean kartKullanildimi=false;
	public static boolean kartDestedeMi=false;
	
	public int getHasarPuani() {
		return hasarPuani;
	}

	public void setHasarPuani(int hasarPuani) {
		this.hasarPuani = hasarPuani;
	}

	public int hasarPuaniGoster() {
		return hasarPuani;
	}

    
	public Charmander(String pokemonAdi, String pokemonTip, java.net.URL img) {
		super(pokemonAdi,pokemonTip,img);
	}

}

class Pikachu extends Pokemon {
	

	private int hasarPuani = 40;
	public static boolean kartKullanildimi=false;
	public static boolean kartDestedeMi=false;
	
	public int getHasarPuani() {
		return hasarPuani;
	}

	public void setHasarPuani(int hasarPuani) {
		this.hasarPuani = hasarPuani;
	}

	public int hasarPuaniGoster() {
		return hasarPuani;
	}

	public Pikachu(String pokemonAdi, String pokemonTip, java.net.URL img) {
		super(pokemonAdi,pokemonTip,img);
	}

}

class Bulbasaur extends Pokemon {

	private int hasarPuani = 50;
	public static boolean kartKullanildimi=false;
	public static boolean kartDestedeMi=false;

	public int getHasarPuani() {
		return hasarPuani;
	}

	public void setHasarPuani(int hasarPuani) {
		this.hasarPuani = hasarPuani;
	}

	public int hasarPuaniGoster() {
		return hasarPuani;
	}

    
		public Bulbasaur(String pokemonAdi, String pokemonTip, java.net.URL img) {
			super(pokemonAdi,pokemonTip,img);
		}

}

class Squirtle extends Pokemon {
	
	private int hasarPuani = 30;
	public static boolean kartKullanildimi=false;
	public static boolean kartDestedeMi=false;

	public int getHasarPuani() {
		return hasarPuani;
	}

	public void setHasarPuani(int hasarPuani) {
		this.hasarPuani = hasarPuani;
	}

	public int hasarPuaniGoster() {
		return hasarPuani;
	}

    
	public Squirtle(String pokemonAdi, String pokemonTip, java.net.URL img) {
		super(pokemonAdi,pokemonTip,img);
	}

}

class Zubat extends Pokemon {

	private int hasarPuani = 50;
	public static boolean kartKullanildimi=false;
	public static boolean kartDestedeMi=false;

	public int getHasarPuani() {
		return hasarPuani;
	}

	public void setHasarPuani(int hasarPuani) {
		this.hasarPuani = hasarPuani;
	}

	public int hasarPuaniGoster() {
		return hasarPuani;
	}

     
	public Zubat(String pokemonAdi, String pokemonTip, java.net.URL img) {
		super(pokemonAdi,pokemonTip,img);
	}

}

class Psyduck extends Pokemon {

	private int hasarPuani = 20;
	public static boolean kartKullanildimi=false;
	public static boolean kartDestedeMi=false;

	public int getHasarPuani() {
		return hasarPuani;
	}

	public void setHasarPuani(int hasarPuani) {
		this.hasarPuani = hasarPuani;
	}

	public int hasarPuaniGoster() {
		return hasarPuani;
	}

    
	public Psyduck(String pokemonAdi, String pokemonTip, java.net.URL img) {
		super(pokemonAdi,pokemonTip,img);
	}

}

class Snorlax extends Pokemon {

	private int hasarPuani = 30;
	public static boolean kartKullanildimi=false;
	public static boolean kartDestedeMi=false;

	public int getHasarPuani() {
		return hasarPuani;
	}

	public void setHasarPuani(int hasarPuani) {
		this.hasarPuani = hasarPuani;
	}

	public int hasarPuaniGoster() {
		return hasarPuani;
	}

	public Snorlax(String pokemonAdi, String pokemonTip, java.net.URL img) {
		super(pokemonAdi,pokemonTip,img);
	}



}

class Butterfree extends Pokemon {

	
	
	
	private int hasarPuani = 10;
	public static boolean kartKullanildimi=false;
	public static boolean kartDestedeMi=false;

	public int getHasarPuani() {
		return hasarPuani;
	}

	public void setHasarPuani(int hasarPuani) {
		this.hasarPuani = hasarPuani;
	}

	public int hasarPuaniGoster() {
		return hasarPuani;
	}

	public Butterfree(String pokemonAdi, String pokemonTip, java.net.URL img) {
		super(pokemonAdi,pokemonTip,img);
	}



}

class Jigglypuff extends Pokemon {

	private int hasarPuani = 70;
	public static boolean kartKullanildimi=false;
	public static boolean kartDestedeMi=false;

	public int getHasarPuani() {
		return hasarPuani;
	}

	public void setHasarPuani(int hasarPuani) {
		this.hasarPuani = hasarPuani;
	}

	public int hasarPuaniGoster() {
		return hasarPuani;
	}

	public Jigglypuff(String pokemonAdi, String pokemonTip, java.net.URL img) {
		super(pokemonAdi,pokemonTip,img);
	}



}

class Meowth extends Pokemon {

	private int hasarPuani = 40;
	public static boolean kartKullanildimi=false;
	public static boolean kartDestedeMi=false;

	public int getHasarPuani() {
		return hasarPuani;
	}

	public void setHasarPuani(int hasarPuani) {
		this.hasarPuani = hasarPuani;
	}

	public int hasarPuaniGoster() {
		return hasarPuani;
	}
     
	public Meowth(String pokemonAdi, String pokemonTip, java.net.URL img) {
		super(pokemonAdi,pokemonTip,img);
	}



}