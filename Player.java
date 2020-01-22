import java.util.ArrayList;
import java.util.Random;
/**
 * @author Thomas Latawiec
 * @version 1-15-20
 */
public class Player
{
    private ArrayList<Card> hand = new ArrayList<Card>();
    private ArrayList<Card> winPile = new ArrayList<Card>();
    private static Random gen = new Random();

    public Player(Card[] dealt)
    {
        for(Card c : dealt) {
            hand.add(c);
        }
    }

    public Card playCard()
    {
        if(!hand.isEmpty())
            return hand.remove(0);
        else if(hand.isEmpty() && !winPile.isEmpty()) {
            redistribute();
            return hand.remove(0);
        }        
        else 
            return null;        
    }

    public void addWinings(ArrayList<Card> x) //add playPile into win pile
    {
        while(x.size() > 0) {       
            winPile.add(x.remove(0));
        }
    }

    public void redistribute() //shuffle winpile and redistribute back into winner's hand
    {
        {
            System.out.println("Shuffling cards...");
            Card[] temp = new Card[winPile.size()];

            for(int i = 0; winPile.size() > 0; i++) {
                temp[i] = winPile.remove(gen.nextInt(winPile.size()));
            }

            for(int i = 0; i < temp.length; i++) {
                hand.add(temp[i]);
            }
        }
    }

    public boolean hasCards()
    {
        return !hand.isEmpty() || !winPile.isEmpty();
    }
    
    public int getHandSize()
    {
        return hand.size();
    }
    
    public int getWinPileSize()
    {
        return winPile.size();
    }

    public String toString()
    {
        String result = "";
        for(Card c : hand) {
            result += c + "\n";
        }
        return result;
    }
}
