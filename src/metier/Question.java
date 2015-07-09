package metier;

import java.util.Arrays;

public class Question {
	
	private String libelle;
	private String[] reponses;
	private int numRepJuste;
	
	public Question(String libelle, String[] reponses, int numRepJuste) {
		super();
		this.libelle = libelle;
		this.reponses = reponses;
		this.numRepJuste = numRepJuste;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String[] getReponses() {
		return reponses;
	}

	public void setReponses(String[] reponses) {
		this.reponses = reponses;
	}

	public int getNumRepJuste() {
		return numRepJuste;
	}

	public void setNumRepJuste(int numRepJuste) {
		this.numRepJuste = numRepJuste;
	}

	@Override
	public String toString() {
		return "Question [libelle=" + libelle + ", reponses="
				+ Arrays.toString(reponses) + ", numRepJuste=" + numRepJuste
				+ "]";
	}
	
	
	
	

}
