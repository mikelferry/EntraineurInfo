package com.example.pasquierase;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import metier.LireFichier;
import metier.Question;
import metier.QuestionFactory;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class JeuActivity extends Activity implements RadioGroup.OnCheckedChangeListener{

	//appele lorsque l'activité est créée
	String choix;
	String chapitre=new String();
	String chaine=null;
	String[] chaineFichier=null;
	InputStream ins;
	List<Question> questions20;
	Question q;
	int hasard;
	int points=0, repJuste;
	
	//les widgets
	TextView question, bonfau, numQuestion;
	RadioGroup rep;
	RadioButton rp1;
	RadioButton rp2;
	RadioButton rp3;
	Button btnValiderRep, questionSuivante;
	Resources res;
	
	int questionCourante = 0;
	String[] propositions;
	int checkedIndex = -1;
	String aleatoire = null;
	String reponse=null;
	
			@Override
			protected void onCreate(Bundle savedInstanceState) {
				
				super.onCreate(savedInstanceState);
				setContentView(R.layout.jeu);
				
				//les widgets de notre ecran
				question = (TextView)findViewById(R.id.question);
				numQuestion = (TextView)findViewById(R.id.numQuestion);
				bonfau = (TextView)findViewById(R.id.bonfaux);
				rep = (RadioGroup)findViewById(R.id.reponses);
				rp1 = (RadioButton)findViewById(R.id.rep1);
				rp2 = (RadioButton)findViewById(R.id.rep2);
				rp3 = (RadioButton)findViewById(R.id.rep3);
				btnValiderRep = (Button)findViewById(R.id.repondre);
				questionSuivante = (Button)findViewById(R.id.suivant);
				questionSuivante.setText("Question Suivante>>>");
				
				questions20 = new ArrayList<Question>();
				
				//on cache le bouton suivant pour l'afficher apres avoir clique sur valider
				questionSuivante.setVisibility(questionSuivante.INVISIBLE);
				res = getResources();
				
			    rep.setOnCheckedChangeListener( this );
			 
				
				//le code se met ici
				chapitre = getIntent().getStringExtra("choix");
				//afficheToast(chapitre);
				
				if(chapitre==null){
					afficheToast("Chapitre nul. Vueillez Choisir Un autre SVP");
				}
				else{
						switch(chapitre){
							case "00":{afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.sixieme_hist_info);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									//mais avant cela on doit viderr s'il existe des question d'une precedante partie
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} 
							break;
							
							case "10":{
								afficheToast("vous avez choisi: Histoire Info de la classe de : Sixieme"); ins=res.openRawResource(R.raw.sixieme_env_info);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "20":{
								afficheToast("vous avez choisi: Environnement Info de la classe de : Sixieme"); ins=res.openRawResource(R.raw.sixieme_bur);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "30":{
								afficheToast("vous avez choisi: Bureautique de la classe de : Sixieme"); ins=res.openRawResource(R.raw.sixieme_bur);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "40":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "50":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "01":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "11":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "21":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "31":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "41":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "51":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "02":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "22":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "32":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "42":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "52":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "03":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "23":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "33":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "43":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "53":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "04":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "14":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "24":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "34":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "44":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "54":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "05":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "15":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "25":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "35":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "45":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "55":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "06":{
								afficheToast("vous avez choisi: Env Informatique de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_env_mat);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "16":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_prog_web);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "26":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_bd);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "36":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_res);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "46":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_rep_info);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							case "56":{
								afficheToast("vous avez choisi: Réseaux de la classe de : Terminale"); ins=res.openRawResource(R.raw.terminal_bur);chaine = LireFichier.lireFichier(ins);chaineFichier = chaine.split(":");
								try {
									//on recupere les 20 questions
									questions20 = QuestionFactory.creer20Questions(chaineFichier);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} break;
							default: afficheToast("Choix Inconnu SVP");
						}//fin switch
					//on fait les traitements
					
					//[le probleme est dans ce bloc ci]
					numQuestion.setText("Question N°: "+1+"/20");
					numQuestion.setTextColor(Color.RED);
					question.setTextColor(Color.BLUE);
					q=questions20.get(questionCourante);
					question.setText(q.getLibelle());
					rp1.setText(q.getReponses()[0]);
					rp2.setText(q.getReponses()[1]);
					rp3.setText(q.getReponses()[2]);
					repJuste = q.getNumRepJuste();
					
					//clic sur le boutton valider
					btnValiderRep.setOnClickListener( new OnClickListener() {
			             @SuppressWarnings("static-access")
						public void onClick( View view ) { 
			            	  if(checkedIndex==-1){
			            		  afficheToast("Cocher une proposition");
			            	  }
			            	  else{
			            		  btnValiderRep.setVisibility(btnValiderRep.INVISIBLE); //Invisible=4 visible=0
			            		  //btnValiderRep.setText("");
			            		  //questionSuivante.setText("Question Suivante");
			            		  questionSuivante.setVisibility(questionSuivante.VISIBLE);
			            		  
			            		  reponse = ""+((RadioButton) findViewById(checkedIndex)).getText();
			            		  //parceque cela derangeait sans mettre ce if ci
			            		  if(repJuste==1){
				            		  if(reponse.equals(q.getReponses()[0])){
				            			  points++;
				            			  afficheToast("Bonne Reponse");
				            			  bonfau.setText("Bonne Reponse");
				            			  bonfau.setTextColor(Color.GREEN);
				            			  //((TextView)(RadioButton) findViewById(checkedIndex)).setTextColor(Color.GREEN);
				            		  }
				            		  else{
				            			  afficheToast("Mauvaise Reponse!");
				            			  bonfau.setText("Mauvaise Reponse!  la bonne reponse etait: \n"+q.getReponses()[0]);
				            			  bonfau.setTextColor(Color.RED);
				            			  //((TextView)(RadioButton) findViewById(checkedIndex)).setTextColor(Color.RED);
				            		  }
			            		  }
			            		  else{
			            			  //afficheToast(q.getReponses()[repJuste-1]);
			            			  //afficheToast(""+repJuste);
				            		  if(reponse.equals(q.getReponses()[repJuste-1])){
				            			  points++;
				            			  afficheToast("Bonne Reponse");
				            			  bonfau.setText("Bonne Reponse");
				            			  bonfau.setTextColor(Color.GREEN);
				            			  //((TextView)(RadioButton) findViewById(checkedIndex)).setTextColor(Color.GREEN);
				            		  }
				            		  else{
				            			  afficheToast("Mauvaise Reponse!");
				            			  bonfau.setText("Mauvaise Reponse! la bonne reponse etait: \n"+q.getReponses()[repJuste-1]);
				            			  bonfau.setTextColor(Color.RED);
				            			  //((TextView)(RadioButton) findViewById(checkedIndex)).setTextColor(Color.RED);
				            		  }
			            		  }
			            	  }
			              }//fin public void
			        });
					
					//on clique sur le bouton suivant
					questionSuivante.setOnClickListener( new OnClickListener() {
			             public void onClick( View view ) { 
			            	 	questionCourante++;
			            	 	btnValiderRep.setVisibility(btnValiderRep.VISIBLE); //Invisible=4 visible=0
			            	 	questionSuivante.setVisibility(questionSuivante.INVISIBLE);
			            	 	
			            	 	//si on n'est pas encore a la 20e question
			            	 	if(questionCourante<20){
			            	 		rep.clearCheck(); //on décoche ce qui était coché
				            		  question.setText("");
				  					  rp1.setText("");
				  					  rp2.setText("");
				  					  rp3.setText("");
				  					  bonfau.setText("");
				  					//((TextView)(RadioButton) findViewById(checkedIndex)).setTextColor(Color.BLACK);
				            		  raffraichiEcran(questionCourante);
			            	 	}
			            	 	else{
			            	 		Intent i = new Intent(JeuActivity.this, ResultatActivity.class);
			            	 		i.putExtra("POINTS", points);
			            	 		startActivityForResult(i,30);
			            	 		questions20.clear();
			            	 		//finish();
			            	 	}
			            		  
			            }
			        });
					
				}//fin else
			}
			
			//lorsque l'activité a termine son cycle de vie
			//on fait les nettoyage et les vidange (de la memoire utilisé)
			@Override
			protected void onDestroy() {
				//le code se met ici avant destroy()
				//questions20.clear();
				super.onDestroy();
			}
			
			//lorsque l'activité démarre
			@Override
			protected void onStart() {
				super.onStart();
				//le code se met ici apres start()
			}
			
			//lorsque l'activité passe en arrière Plan
				@Override
				protected void onStop() {
					//le code se met ici avant onStop()
					super.onStop();
				}
				
			//lorsque l'activité revient de la veille
				@Override
				protected void onRestart() {
					super.onRestart();
					//le code se met ici
				}
				
			//lorsque l'activité va en pause
				@Override
				protected void onPause(){
					//le code ici
					super.onPause();
				}
				
			//lorsque l'activité revient de la pause
				@Override
				protected void onResume(){
					super.onResume();
					//le code ici
				}
				
			//sauvegarder les donnée importantes
				@Override
				protected void onSaveInstanceState(Bundle savedInstanceState){
					//le code ici
					super.onSaveInstanceState(savedInstanceState);
				}
				
			//apres onCreate on recharge les données
				@Override
				protected void onRestoreInstanceState(Bundle savedInstanceState){
					super.onRestoreInstanceState(savedInstanceState);
					//le code ici
				}
			
				//permet d'afficher les toast
				public void afficheToast(String text)
				   {
				      Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
				   }

				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					checkedIndex = checkedId;
				}
				
				//on rafraichie l'ecran de jeu
				public void raffraichiEcran(int index){
					q=questions20.get(index);
					checkedIndex = -1;
					numQuestion.setText("Question N°: "+(index+1)+"/20");
					numQuestion.setTextColor(Color.RED);
					question.setText(q.getLibelle());
					rp1.setText(q.getReponses()[0]);
					rp2.setText(q.getReponses()[1]);
					rp3.setText(q.getReponses()[2]);
					repJuste = q.getNumRepJuste();
				}
				
				
				protected void onActivityResult (int requestCode, int resultCode, Intent data) {
				      // on récupère le statut de retour de l'activité 2 c'est à dire l'activité numéro 1000
				      if(requestCode==30){
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
				
}
