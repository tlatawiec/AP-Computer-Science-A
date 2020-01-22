
/*
 * @author Thomas Latawiec
 * @version 1-10-20
 */
public class Card implements Comparable
{
    // instance variables - replace the example below with your own
    private int rank;
    private Suit suit;
    private boolean faceUp;

    public Card(int a, Suit b)
    {
        rank = a;
        suit = b;
    }

    public int getFaceValue(Card a) 
    {
        return rank;
    }
    //Comares rank value of two cards
    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        else if(!(other instanceof Card))
            return false;
        else {
            Card otherCard = (Card)other;
            return rank == otherCard.rank;
        }
    }

    public int compareTo(Object other) 
    {
        if(!(other instanceof Card))
            throw new IllegalArgumentException("Parameter must be a Card.");
        Card otherCard = (Card)other;
        return rank - otherCard.rank;//if positive, card is greater
    }

    public int getRank()
    {
        return rank;
    }

    public Suit getSuit() 
    {
        return suit;
    }

    public boolean isFaceUp() 
    {
        return faceUp;
    }

    public boolean isRed() 
    {
        return suit == Suit.heart || suit == Suit.diamond;
    }

    public void turn()
    {
        faceUp = !faceUp;
    }

    public String toString()
    {
        return rankToString() + " of " + suit;
    }

    private String rankToString()
    {
        if(rank == 11)
            return "Jack";
        else if(rank == 12)
            return "Queen";
        else if(rank == 13)
            return "King";
        else if(rank == 14)
            return "Ace";
        else
            return "" + rank;
    }
}
