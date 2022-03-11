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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author haoya
 */
public class JourTest {
    
    public JourTest() {
    }

    @org.junit.jupiter.api.Test
    public void testSomeMethod() {
        Integer numJour = 3;
        Jour j1 = new Jour(3);
        
        Integer result = j1.getNoJour();
        Assertions.assertEquals(numJour,result, "L'entier pour créer un jour doit être le même que celui récupéré par la méthode getNbJour.");
    }
    
}
