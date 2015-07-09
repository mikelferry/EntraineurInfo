package com.example.pasquierase;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ChoixChapActivity extends ListActivity{
	int classe=0;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//le code se met ici
		int position = 0;
		position = getIntent().getIntExtra("CHOIXNIV", position);
		
		if(position == 6){
			String[] niv = new String[]{"Environnement Materiel et Logiciel", "Programmation Web",
					"Base de données", "Réseaux Informatiques",
					"Representation de l\'information", "Bureautique"};
			ArrayAdapter <String> adapter = 
					new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, niv);
			this.setListAdapter(adapter);
			classe = 6;
		}
		
		if(position == 5){
			String[] niv = new String[]{"Environnement Materiel et Logiciel", "Algorithmique", 
					"Le HTLM", "Le CSS", "Infographie", "Bureautique"};
			ArrayAdapter <String> adapter = 
					new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, niv);
			this.setListAdapter(adapter);
			classe = 5;
		}
		
		if(position == 4){
			String[] niv = new String[]{"Environnement Materiel et Logiciel", "Maintenance", 
					"Bureautique"};
			ArrayAdapter <String> adapter = 
					new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, niv);
			this.setListAdapter(adapter);
			classe = 4;
		}
		
		if(position == 3){
			String[] niv = new String[]{"Environnement Materiel et Logiciel", "Systèmes de Numération", 
					"Codage de l'information", "Les unites de mesure en informatique", 
					"Le trensfert des données", "Bureautique"};
			ArrayAdapter <String> adapter = 
					new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, niv);
			this.setListAdapter(adapter);
			classe = 3;
		}
		
		if(position == 2){
			String[] niv = new String[]{"Environnement Materiel et Logiciel", "Introduction aux Réseaux informatiques",
					"Bureautique"};
			ArrayAdapter <String> adapter = 
					new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, niv);
			this.setListAdapter(adapter);
			classe = 2;
		}
		
		if(position == 1){
			String[] niv = new String[]{"Environnement Materiel et Logiciel", "Systèmes d'exploitation", 
					"Maintenance de Base d'un ordinateur", "Organisation des données dans un support de stockage"};
			ArrayAdapter <String> adapter = 
					new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, niv);
			this.setListAdapter(adapter);
			classe = 1;
		}
		
		if(position == 0){
			String[] niv = new String[]{"L'histoire de l'informatique", "Environnement Materiel et Logiciel", 
					"Bureautique"};
			ArrayAdapter <String> adapter = 
					new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, niv);
			this.setListAdapter(adapter);
			classe = 0;
		}
		
	}
	
	//quand on clic sur un element de la liste qu'est-ce qui se passe
	  @Override
	  public void onListItemClick(ListView list, View view,
	                             int position, long id) {
		  
		Intent i=new Intent(this, JeuActivity.class);
		String choix = position+Integer.toString(classe);
		i.putExtra("choix", choix); //putExtra(uneClé, valeur a envoyer)
		startActivityForResult(i, 20);   
	  }
	  
	  protected void onActivityResult (int requestCode, int resultCode, Intent data) {
	      // on récupère le statut de retour de l'activité 2 c'est à dire l'activité numéro 1000
	      if(requestCode==20){
	    	  if(resultCode==4){
	    		  
	    		  setResult(4);
	    		  finish();
	    	  }
	    	  if(resultCode==3){
	    		  
	    		  setResult(3);
	    		  finish();
	    	  }
	      }
	      super.onActivityResult (requestCode, resultCode, data);
	   }
	
	public void afficheToast(String text)
	   {
	      Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	   }
}
