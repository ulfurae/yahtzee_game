package Processing;

import Interface.YahtzeeWindow;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

/**
 * 
 * @author Úlfur Alexander Einarsson, uae3@hi.is
 * 29/03 2015
 * 
 * Lýsing á forriti:
 * Þetta forrit er einfaldur Yahtzee leikur.
 * Í honum er hægt að kasta fimm teningum, taka frá teninga sem þú 
 * villt geyma og skrifa á blað  hvernig þú villt skrá útkomunar sem 
 * þú færð í hverju kasti. Forritið reiknar síðan út hvað þú hefur 
 * fengið samtals úr öllum köstum sem þú hefur skráð.
 * 
 */

public class YahtzeeGame {
    
   //int array sem innihaldur útkomur teninganna fimm
   private static final int [] dice = new int [5];
   // int sem segir hversu oft er búið að kasta í hverri umferð
   public static int count = 0;
   // int sem segir hversu margar umferðir er búið að kasta
   public static int roundsCount = 0;
   
   // ArrayListi sem inniheldur gildi teningakastanna
   public static ArrayList<String> allDiceList = new ArrayList<>();
    // ArrayListar sem innihald gildi og nöfn teninga sem hafa verið valdir
   public static ArrayList<String> dicePickedNameList = new ArrayList<>();
   public static ArrayList<String> dicePickedList = new ArrayList<>();
   
   // ný slóð fyrir myndirnar af teningunum
    private static ImageIcon newPic; 
    // boolean breyta sem segir til um hvort sé búið að skrá stig í reit
   private static boolean scorePicked = false;
   
   // Boolean breytur sem innihalda upplýsingar um hvort teningur hafi
   // verið valinn eða ekki.
   public static Boolean dice1Picked = false;
   public static Boolean dice2Picked = false;
   public static Boolean dice3Picked = false;
   public static Boolean dice4Picked = false;
   public static Boolean dice5Picked = false;
   
   // main fall býr til nýtt tilvik af YahtzeeWindow og nýjan leik
   public static void main(String args[]) {
       
        new YahtzeeWindow().setVisible(true);
        
        newGame();
    }
    
   // fall sem endurstillir allar breytur og viðmótshluti
    public static void newGame() {
        ScorePaper.resetTextFields();
        YahtzeeWindow.resetDicePics();
        YahtzeeWindow.resetMarkedDice();
        count=0;
        roundsCount=0;
        YahtzeeWindow.throwBtn.setLabel("Kasta teningum");
        YahtzeeWindow.roundsCountLbl.setText("Ýttu á 'Kasta teningum' til að byrja!");
        YahtzeeWindow.gameOverTxt.setText("");
        YahtzeeWindow.throwBtn.setEnabled(true);
    }
    
    // athugað hvaða teningar hafa verið valdir og hversu oft hefur verið 
    // kastað og throwAllDice() keyrt til að gefa teningum ný gildi
    // @param dicePic1-dicePic5 : myndir í viðmótinu sem fá nýtt útlit
    public static void newThrow(JLabel dicePic1, JLabel dicePic2, 
            JLabel dicePic3, JLabel dicePic4, JLabel dicePic5) 
    {
        resetDicePicked();
        
        // ef count er minna en 3 er athugað hvaða teningar eru valdir og 
        // dice1-5Picked gert true ef teningur er valinn. Síðan er 
        // throwAlldice() fallið keyrt til að fá ný gildi fyrir teningana 
        // sem eru ekki valdir og count hækkað um einn.
        if (count < 3)
        {
            if(dicePickedNameList.contains("d1")) dice1Picked = true;
            if(dicePickedNameList.contains("d2")) dice2Picked = true;
            if(dicePickedNameList.contains("d3")) dice3Picked = true;
            if(dicePickedNameList.contains("d4")) dice4Picked = true;
            if(dicePickedNameList.contains("d5")) dice5Picked = true;
            
            throwAllDice(dicePic1,dicePic2,dicePic3,dicePic4,dicePic5);          
            count++;
        }
        scorePicked = false;  
    }
    
    // throwDice() keyrt fimm sinum og útliti og ToolTip-texta teningamyndanna
    // breytt út frá útkomunum og skrifar þær í allDiceList
    // @param dice1-dice5 : myndir sem að uppfærast með nýju útliti
    private static void throwAllDice(JLabel dice1, JLabel dice2, JLabel dice3, 
            JLabel dice4, JLabel dice5) 
    {
        // í hverri lykkju keyrist fallið throwDice() og útkoman skráð í 
        // breytunrnar dice[0-5]
        for(int i = 0; i < dice.length; i++)
        {
            dice[i] = Dice.throwDice();
        }
        
        // gildi breytanna dice[0-5] sett í slóð teningamyndanna.
        // fyrst athugað hvort að dice1Picked - dice5Picked sé false til að 
        // athuga hvort að teningurinn hafi verið valinn eða ekki.
        if(dice1Picked==false) {
            // toolTip myndarinnar gefið gildi nýs tenings
            dice1.setToolTipText(Integer.toString(dice[0]));
            // imageIcon fær nýja slóð sem vísar í rétta mynd af nýjum tening
            newPic = new ImageIcon(YahtzeeGame.class.getResource("/Interface/dice" + dice[0] + ".png"));
            dice1.setIcon(newPic);
        }
        if(dice2Picked==false) {
            dice2.setToolTipText(Integer.toString(dice[1]));
            newPic = new ImageIcon(YahtzeeGame.class.getResource("/Interface/dice" + dice[1] + ".png"));
            dice2.setIcon(newPic);
        }
        if(dice3Picked==false) {
            dice3.setToolTipText(Integer.toString(dice[2]));
            newPic = new ImageIcon(YahtzeeGame.class.getResource("/Interface/dice" + dice[2] + ".png"));
            dice3.setIcon(newPic);
        }
        if(dice4Picked==false) {
            dice4.setToolTipText(Integer.toString(dice[3]));
            newPic = new ImageIcon(YahtzeeGame.class.getResource("/Interface/dice" + dice[3] + ".png"));
            dice4.setIcon(newPic);
        }
        if(dice5Picked==false) {
            dice5.setToolTipText(Integer.toString(dice[4]));
            newPic = new ImageIcon(YahtzeeGame.class.getResource("/Interface/dice" + dice[4] + ".png"));
            dice5.setIcon(newPic);
        } 
        
        allDiceList.clear();
            
        // allDiceList uppfært með nýju gildum teninganna
        allDiceList.add(dice1.getToolTipText());
        allDiceList.add(dice2.getToolTipText());
        allDiceList.add(dice3.getToolTipText());
        allDiceList.add(dice4.getToolTipText());
        allDiceList.add(dice5.getToolTipText());
        
    }
    
    // reiknar útkomu teninganna fyrir það textasvið sem er valið á blaðinu
    // uppfærir reit og ástand leiksins
    // @param number : talan sem á að reikna og fara í field
    // @param field : textasvið sem á að uppfæra með number 
    public static void calculateDice(int number, JFormattedTextField field)
    {       
        int sum = 0;
        
        if(field.getBackground()!=Color.green && scorePicked==false) 
        {
            String[] diceArray = allDiceList.toArray(new String[allDiceList.size()]);
        
            if(number == 333 | number == 4444 | number == 55555) 
                sum = calculateSame345(number);

        
            else if (number == 12345) {
                if (allDiceList.contains("1") && allDiceList.contains("2")
                && allDiceList.contains("3") && allDiceList.contains("4")
                && allDiceList.contains("5"))
                    sum = 15;
                else sum = 0;
            }
            else if (number == 23456) {
                if (allDiceList.contains("2") && allDiceList.contains("3")
                && allDiceList.contains("4") && allDiceList.contains("5")
                && allDiceList.contains("6"))
                    sum = 20;
                else sum = 0;
            }
            else
            {
                int i = 0;
                while(i < diceArray.length)
                {
                    if(diceArray[i].equals(Integer.toString(number))) {
                        sum = sum + number;
                    }          
                    else if(number==666) {
                        sum = sum + Integer.parseInt(diceArray[i]);
                    }
                    i++;
                }
            }  
            // réttur reitur og ástand leiks upfært
            updateScore(sum, field);        
        }      
    }
    
    // Útkoma teningakasts sett í réttan reit og samtal allra reita uppfært.
    // Ástand leiksins breitt í að scorePicked sé true og reitur gerður grænn. 
    // Athugað hvort leikur sé búinn.
    // @param sum : útkoma sem á að fara í reitinn
    // @param field : reitur sem á að skriafa útkomu í 
    private static void updateScore(int sum, JFormattedTextField field)
    {
        field.setText(Integer.toString(sum));
        field.setBackground(Color.green);
        
        ScorePaper.updateTotal(sum);
        
        scorePicked = true;
            
        // texti throwBtn breytt og hann gerður virkur aftur fyrir nýtt
        // tenningakast
        YahtzeeWindow.throwBtn.setLabel("Kasta nýrri umferð");
        YahtzeeWindow.throwBtn.setEnabled(true);
            
        // ef count er ekki -1, þ.e.a.s það er ekki búið að kasta þrisvar,
        // er count endurstillt í 0 fyrir nýja umferð
        if(count!=-1) count = 0;
        
        if (roundsCount==12)
            gameFinished();
    }
    
    private static void gameFinished()
    {
        String outcome = YahtzeeWindow.totalTxt.getText();
        YahtzeeWindow.gameOverTxt.setText("Til Hamingju! Þú fékkst " + outcome
        + " stig!");
        YahtzeeWindow.throwBtn.setEnabled(false);
        YahtzeeWindow.roundsCountLbl.setText("Leikur búinn");
        
    }
    
    // fall sem reiknar út summu teninga ef að það eru 3,4 eða 5 eins
    public static int calculateSame345(int number) {
        
        // til að athuga hvort að teningakast innihaldi 3 eða 4 eins tölur
        // er útkoma teninganna flokkuð í 6 fylki sem innihalda eina
        // tölu hvert um sig. Stærð fylkjann er síðan athuguð til þess að sjá
        // hvort að einhver tala sé með 3 eða fleirri eins
        
        // listinn með útkomu teningakastsinns settur í strengjafylki
        String[] temp = allDiceList.toArray(new String[allDiceList.size()]);
        // fylki sem munu innihalda eina tölu hvert fyrir sig
        ArrayList<String> t1 = new ArrayList<>();
        ArrayList<String> t2 = new ArrayList<>();
        ArrayList<String> t3 = new ArrayList<>();
        ArrayList<String> t4 = new ArrayList<>();
        ArrayList<String> t5 = new ArrayList<>();
        ArrayList<String> t6 = new ArrayList<>();
            
        int i=0;
        while(i < temp.length)
        {    
            // ef að temp inniheldur einhverja af tölunum 1-6 er talan sett í
            // rétt fylki
            if(temp[i].equals("1")) t1.add(temp[i]);
            if(temp[i].equals("2")) t2.add(temp[i]);
            if(temp[i].equals("3")) t3.add(temp[i]);
            if(temp[i].equals("4")) t4.add(temp[i]);
            if(temp[i].equals("5")) t5.add(temp[i]);
            if(temp[i].equals("6")) t6.add(temp[i]);    
            i++;
        }
            
        int sumDice = 0;
        
        // athugað hvort að eitthvert fylkjanna innihaldi 3 eða fleirri stök
        // ef fylki inniheldur 3 eða fleirri stök er summa þessa fylkis reiknuð
        // og vistuð í sumDice
        if(number == 333)
        {
            if(t1.size()>=3) sumDice = 1*3;
            if(t2.size()>=3) sumDice = 2*3;
            if(t3.size()>=3) sumDice = 3*3;
            if(t4.size()>=3) sumDice = 4*3;
            if(t5.size()>=3) sumDice = 5*3;
            if(t6.size()>=3) sumDice = 6*3;
        }
        
        // athugað hvort að eitthvert fylkjanna innihaldi 4 eða fleirri stök
        // ef fylki inniheldur 4 eða fleirri stök er summa þessa fylkis reiknuð
        // og vistuð í sumDice
        if(number == 4444)
        {
            if(t1.size()>=4) sumDice = 1*4;
            if(t2.size()>=4) sumDice = 2*4;
            if(t3.size()>=4) sumDice = 3*4;
            if(t4.size()>=4) sumDice = 4*4;
            if(t5.size()>=4) sumDice = 5*4;
            if(t6.size()>=4) sumDice = 6*4;
        }
        
        // athugað hvort að eitthvert fylkjanna innihaldi 5 stök og sumDice
        // gert 50 ef svo er
        if(number == 55555)
        {
            if(t1.size()==5 | t2.size()==5 | t3.size()==5 | t4.size()==5 | 
                    t5.size()==5 | t6.size()==5)
                sumDice = 50;
        }
        
        return sumDice;
    }

    // núllstillir dice1-5Picked breyturnar
    private static void resetDicePicked() {
        dice1Picked = false; 
        dice2Picked = false;
        dice3Picked = false;
        dice4Picked = false;
        dice5Picked = false;
    }
    
}
