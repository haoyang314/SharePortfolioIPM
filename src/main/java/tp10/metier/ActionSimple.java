/*
 * Copyright 2022 haoya.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tp10.metier;

import java.util.HashMap;

/**
 *
 * les actions simples sont des actions !
 *   heritage --&gt donc (i) concretiser la methode abstraire 'valeur'
 *                  et (ii) def d'un constructeur cohérent avec le constructeur 
 *                                   parent
 */
public class ActionSimple extends Action {
    
    // Table de hachage contenant les cours indexés par des jours
    private HashMap<Jour, Cours> tblCours;
    
    // Constructeur cohérent avec le constructeur parent
    public ActionSimple(String nom) {
        super(nom); // c'est d'abord 1 action !
        this.tblCours = new HashMap<Jour, Cours>();
    }
    
    public void enrgCours(Jour j, float px) {
        /* création d'un objet Cours associé au prix
         *    puis ajout dans la table en indexant par le jour
         */        
        if(this.tblCours.containsKey(j) == true)
            this.tblCours.remove(j);
        
        this.tblCours.put(j, new Cours(px));
            
        
    }
    
    @Override
    public float valeur(Jour j) {
        // A FAIRE !
        if(this.tblCours.get(j) != null)
            return this.tblCours.get(j).getValeur();
        else
            return 0; // cours nul si pas de pas de cours
    }
   /* classee privée !! 
    *   la classe n'est accessible que depuis la classe englobante
    */
    
    private class Cours {

        private float valeur;

        /**
         * Get the value of valeur
         *
         * @return the value of valeur
         */
        public float getValeur() {
            return valeur;
        }

        public Cours(float valeur) {
            this.valeur = valeur;
        }        
    }
    
    
}
