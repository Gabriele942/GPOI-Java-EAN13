/**
 * @author Gabriele Spica
 * @version:
 * @since 10/05/2023
*/
public class EAN13 {
    
    private String codice;

    /** 
     * @param c variabile che indica il codice a 13 cifre da analizzare
    */

    

   
    public void setCodice(String c){

        /**Funzione che ci permette di impostare la variabile c con un valore a nostro inserimento */
        codice = c;
    }

    public String getCodice(){

        /** Funzione che ci permette di ricevere il codice precedentemente inserito in stampa
         */
        return codice;
    }


    /**
     * @return
     */
    public boolean verificaCodice(){

        /** Funzione che ci permette di verificare che il codice ha tutti i prerequisiti per essere validi */

        // Verifica se l'attributo codice è vuoto o nullo
        if (codice.equals(null) || codice == ""){
            throw new NullPointerException("Il codice EAN-13 risulta vuoto o nullo");
        }

        // Verifica se la lunghezza dell'attributo codice è di 13
        if(codice.length() != 13) {
            return false;
        }
        
        // Implementazione dell'algoritmo di calcolo della cifra di controllo
        int somma = 0;
        int cifra;
        
        for(int i = 0; i < codice.length() - 1; i++) {   
            cifra = Character.getNumericValue(codice.charAt(i));
            
            if(i % 2 == 0) {
                somma += cifra * 1;  
            } else {
                somma += cifra * 3; 
            }
        }
        
        // Calcola la cifra di controllo
        int cifraDiControllo = (10 - (somma % 10));

        // Confronta la cifra di controllo con quella contenuta nel codice EAN13 (ultima cifra)
        return cifraDiControllo == Character.getNumericValue(codice.charAt(12)); 
    }


}
