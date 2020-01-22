import java.util.ArrayList;
import java.util.Random;
/*
 * @author Thomas Latawiec
 * @version 1-14-20
 */
public class Deck
{
    private ArrayList<Card> cards;
    public static final int MAX_SIZE = 52;
    private static Random gen = new Random();
    
    public Deck()
    {
        reset();
    }
    
    public void reset()
    {
        cards = new ArrayList<Card>(52);
        addSuit(Suit.spade);
        addSuit(Suit.heart);
        addSuit(Suit.diamond);
        addSuit(Suit.club);
    }
    
    private void addSuit(Suit s)
    {
        for(int i = 2; i <= 14; i++) {
            cards.add(new Card(i, s));
        }
    }
    
    public boolean isEmpty()
    {
        return cards.isEmpty();
    }
    
    public int size() 
    {
        return cards.size();
    }
    
    public Card deal()
    {
        if(isEmpty()) 
            return null;
        else 
            return cards.remove(cards.size() - 1);
    }
    
    public Card[] deal(int num)
    {
        if(num > cards.size())
            return null;
        else {
            Card[] hand = new Card[num];
            for(int i = 0; i < hand.length; i++) {
                hand[i] = deal();
            }
            return hand;
        }
    }
    
    public void shuffleDeck()
    {
        Card[] temp = new Card[MAX_SIZE];
        
        for(int i = 0; i < MAX_SIZE; i++) {
            temp[i] = cards.remove(gen.nextInt(cards.size()));
        }
        
        for(int i = 0; i < MAX_SIZE; i++) {
            cards.add(temp[i]);
        }
    }
    
    public String toString() 
    {
        String result = "";
        for(Card c : cards)
            result += c + "\n";
        return result;
    }
}
