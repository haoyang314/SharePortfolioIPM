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

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author perussel
 */
public class ActionCompliquee extends Action {

    private HashMap<ActionSimple, Proportion> tblComposition;

    public ActionCompliquee(String nom) {
        super(nom);
        this.tblComposition = new HashMap<>();
    }
    
    
    @Override
    public float valeur(Jour j) {
        float total;
        
        total = 0;
        
         // parcours des clefs
        for(Map.Entry<ActionSimple, Proportion> act : this.tblComposition.entrySet()) {
            total = total + 
                    (act.getKey().valeur(j) * this.tblComposition.get(act).getPourcentage());
        }
        return total;
    }
    
    public void enrgProportion(ActionSimple as, float pourcentage) {
        if(this.tblComposition.containsKey(as))
            this.tblComposition.remove(as);
           
        this.tblComposition.put(as, new Proportion(pourcentage));
    }
    
    @Override
    public String toString() {
        return this.getNom() +"=>" + this.tblComposition.toString(); 
    }
    private class Proportion {

        private float pourcentage;

        /**
         * Get the value of pourcentage
         *
         * @return the value of pourcentage
         */
        public float getPourcentage() {
            return pourcentage;
        }

        public Proportion(float pourcentage) {
            this.pourcentage = pourcentage;
        }

        @Override
        public String toString() {
            return NumberFormat.getPercentInstance().format(pourcentage);
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.tblComposition);
        return hash;
    }
    
    
    
}
