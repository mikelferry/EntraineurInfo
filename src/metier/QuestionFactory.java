package metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class QuestionFactory {
	static Vector<Integer> aleas = new Vector<Integer>();
	static ArrayList<Question> questions20 = new ArrayList<Question>();
	public static ArrayList<Question> creer20Questions(String[] chaineFichier){
		int longueur=chaineFichier.length;//chaque ligne a 5 elements
		for ( int i = 0; i < 20; i++ ) {
        	//on construit la question
			construireQuestion(longueur, chaineFichier);
		}//fin for
		return questions20;
	}
	
	
	public static void construireQuestion(int longueur,String[] chaineFichier){
		for(int i=0; i<20;i++){
			int hasard;
			hasard = (int)(Math.random()*longueur);
			while ((hasard%5)!=0 || aleas.contains(hasard)){
				hasard = (int)(Math.random()*longueur);
			}
			//aleas.add(hasard);
			String[] reponses = new String[]{chaineFichier[hasard+2],chaineFichier[hasard+3],chaineFichier[hasard+4]};
			Question question = new Question(chaineFichier[hasard], reponses, Integer.parseInt(chaineFichier[hasard+1]));
			ajouterQuestion(question, longueur, chaineFichier);
		}	
	}
	
	public static void ajouterQuestion(Question question, int longueur, String[] chaineFichier){
		if(questions20.contains(question)) construireQuestion(longueur, chaineFichier);
		else questions20.add(question);
	}
}
