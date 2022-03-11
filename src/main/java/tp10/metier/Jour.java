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

/**
 *
 * @author perussel
 */
public class Jour {

    private int noJour;

    /**
     * Get the value of noJour
     *
     * @return the value of noJour
     */
    public int getNoJour() {
        return noJour;
    }

    public Jour(int noJour) {
        this.noJour = noJour;
    }

    @Override
    public String toString() {
        return "Jour " + noJour;
    }

    /* redefinition de l'egalité (pour la hasmap!)
     *  initialement definie dans la classe Object
     *   
     *    2 jours indetiques ssi noJour identiques
     */
    @Override
    public boolean equals(Object o) {
        Jour jourAComparer;
        
        jourAComparer = (Jour)o; // "cast" de 'o' en Jour
        if(this.getNoJour() == jourAComparer.getNoJour()) // == car int est primitif
            return true;
        else 
            return false;
    }
    
    @Override
    public int hashCode() {
        return this.getNoJour();
    }
}
