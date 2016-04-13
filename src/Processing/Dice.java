package Processing;

/**
 *
 * @author Úlfur Alexander Einarsson, uae3@hi.is
 * 29/03 2015
 * 
 * Lýsing:
 * Klasi sem Inniheldur fall sem býr til radnom tölu á
 * bilinu 1 - 6.
 * 
 */

import java.util.Random;

public class Dice {

    // fall sem hægt er að kalla á og býr til random tölu
    // á bilinu 1 - 6
    public static int throwDice() 
    {
        // int sem býr til random tölu á bilinu 1 - 6
        int result = new Random().nextInt(6) + 1;
        
        // sendir breytuna result tilbaka
        return result;
    }
  
}
