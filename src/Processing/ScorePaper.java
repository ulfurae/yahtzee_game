package Processing;

import java.awt.Color;
import static Interface.YahtzeeWindow.*;

/**
 *
 * @author Úlfur Alexander Einarsson, uae3@hi.is
 * 29/03 2015
 * 
 * Lýsing:
 * Klasi sem Inniheldur fall sem reiknar út summu allra talna 
 * sem hafa verið skráðar í reitina á yahtzee-blaðinu og endurstillir reiti
 * á blaðinu
 * 
 */

public class ScorePaper {
    
    
    // leggur nýja útkomu við samtals summu allra reita og skrifar í totalTxt
    // @param newNumber : tala sem á að bætast við samtals summu
    public static void updateTotal(int newNumber) 
    {
        int total = Integer.parseInt(totalTxt.getText());       
        total = total + newNumber;
        totalTxt.setText(Integer.toString(total));
    }
    
    // fall sem núllstillir allar reiti og geri þá hvíta
    public static void resetTextFields() 
    {
        ones.setText("0");
        twos.setText("0");
        threes.setText("0");
        fours.setText("0");
        fives.setText("0");
        sixes.setText("0");
        same3.setText("0");
        same4.setText("0");
        same5.setText("0");
        smallstraight.setText("0");
        bigstraight.setText("0");
        chance.setText("0");
        totalTxt.setText("0");
        
        ones.setBackground(Color.white);
        twos.setBackground(Color.white);
        threes.setBackground(Color.white);
        fours.setBackground(Color.white);
        fives.setBackground(Color.white);
        sixes.setBackground(Color.white);
        same3.setBackground(Color.white);
        same4.setBackground(Color.white);
        same5.setBackground(Color.white);
        smallstraight.setBackground(Color.white);
        bigstraight.setBackground(Color.white);
        chance.setBackground(Color.white);
    }
        
}
