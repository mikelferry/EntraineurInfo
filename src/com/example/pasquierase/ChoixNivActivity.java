package com.example.pasquierase;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ChoixNivActivity extends ListActivity{
	
	//appele lorsque l'activit� est cr��e
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//le code se met ici
		
		//on gere la liste des niveaux
		//setContentView(R.layout.choixniv);
		String[] niv = new String[]{"Sixi�me", "Cinqui�me",
				"Quatri�me", "Troisi�me", "Seconde", "Premi�re", "Terminale"};
		ArrayAdapter <String> adapter = 
				new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, niv);
		this.setListAdapter(adapter);
	}
		
	//lorsque l'activit� a termine son cycle de vie
	//on fait les nettoyage et les vidange (de la memoire utilis�)
	@Override
	protected void onDestroy() {
		//le code se met ici avant destroy()
		super.onDestroy();
	}
	
	//lorsque l'activit� d�marre
	@Override
	protected void onStart() {
		super.onStart();
		//le code se met ici apres start()
	}
	
	//lorsque l'activit� passe en arri�re Plan
		@Override
		protected void onStop() {
			//le code se met ici avant onStop()
			super.onStop();
		}
		
	//lorsque l'activit� revient de la veille
		@Override
		protected void onRestart() {
			super.onRestart();
			//le code se met ici
		}
		
	//lorsque l'activit� va en pause
		@Override
		protected void onPause(){
			//le code ici
			super.onPause();
		}
		
	//lorsque l'activit� revient de la pause
		@Override
		protected void onResume(){
			super.onResume();
			//le code ici
		}
		
	//sauvegarder les donn�e importantes
		@Override
		protected void onSaveInstanceState(Bundle savedInstanceState){
			//le code ici
			super.onSaveInstanceState(savedInstanceState);
		}
		
	//apres onCreate on recharge les donn�es
		@Override
		protected void onRestoreInstanceState(Bundle savedInstanceState){
			super.onRestoreInstanceState(savedInstanceState);
			//le code ici
		}
		
	//quand on clic sur un element de la liste qu'est-ce qui se passe
		  @Override
		  public void onListItemClick(ListView list, View view,
		                             int position, long id) {
			 //la position des items de la liste va de 0 � n
				 //Toast.makeText(ChoixNivActivity.this, "VOUS ETES EN TERMINAL: CHOISIR UN CHAPITRE", Toast.LENGTH_LONG).show();
				Intent i=new Intent(this, ChoixChapActivity.class);
				i.putExtra("CHOIXNIV", position); //putExtra(uneCl�, valeur a envoyer)
				startActivityForResult(i, 10); 
				
		    
		  }
		  
		  protected void onActivityResult (int requestCode, int resultCode, Intent data) {
		      // on r�cup�re le statut de retour de l'activit� 2 c'est � dire l'activit� num�ro 1000
		      if(requestCode==10){
		    	  if(resultCode==4){
		    		  setResult(4);
		    		  finish();
		    	  }
		    	  if(resultCode==3){
		    		  
		    		  setResult(3);
		    		  finish();
		    	  }
		    	  //dans le cas ou c'est 4 depuis la classe ResultActivity on sort pas d'ici
		      }
		      super.onActivityResult (requestCode, resultCode, data);
		   }
	
}
