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
package fr.ut1.miage;

import java.util.HashMap;

/**
 *
 * @author laurent
 */
public class Portefeuille {
    
    private HashMap<Action, LignePortefeuille> lignes;
    
    public Portefeuille() {
        this.lignes = new HashMap<Action, LignePortefeuille>();
    }
    
    public void acheter(Action action, int qte) {        
        if(this.lignes.get(action) == null)
            this.lignes.put(action, new LignePortefeuille(qte));
        else
           this.lignes.get(action).augmenter(qte); 
    }
    
    
    public void vendre(Action action, int qte) {        
        if(this.lignes.get(action) != null) { // si la ligne existe 
           this.lignes.get(action).diminuer(qte);  // la qte est modifiée
           
            if(this.lignes.get(action).getQte() == 0) // reste-il encore
                this.lignes.remove(action);  // des actions dans la ligne
        }
    }
    /* A améliorer car on suppose que chaque action est valorisable le jour j  
     *     calcul à bloquer si une action n'est pas quotée par exemple.
     */
    public float valeur(Jour j) {
        float valeurTotale;
        
        valeurTotale = 0;
        for(Action act : this.lignes.keySet()) {
            valeurTotale = valeurTotale + 
                    (this.lignes.get(act).getQte() * act.valeur(j));
        }        
        return valeurTotale;
    }
    
    
    @Override
    public String toString() {        
        return this.lignes.toString();
    }
    
    private class LignePortefeuille {
        private int qte;

        public int getQte() {
            return qte;
        }
        
        public void augmenter(int qteAAjouter) {
            if(qteAAjouter > 0)
                this.qte = this.qte + qteAAjouter;
        }
        
        public void diminuer(int qteASoustraire) {
            if(qteASoustraire <= this.qte && qteASoustraire > 0) {
                qte = qte - qteASoustraire;
            }
        }

        public LignePortefeuille(int qte) {
            this.qte = qte;
        }   
        
        @Override
        public String toString() {
            return Integer.toString(qte);
        }
    }
}
