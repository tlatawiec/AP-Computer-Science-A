import java.util.ArrayList;
/*
 * @author Thomas Latawiec
 * @version 1-10-20
 */
public class WarDriver
{
    private static int handCount;
    private static ArrayList<Card>playPile = new ArrayList<Card>(26);
    private static Player p1;
    private static Player p2;
    public static void main(String[] args)
    {
        Deck myDeck = new Deck();
        myDeck.shuffleDeck();
        p1 = new Player(myDeck.deal(26));
        p2 = new Player(myDeck.deal(26));
        while(p1.hasCards() && p2.hasCards())
            play();
        endGame();
        
        //System.out.println(p1);
    }

    private static void play() //plays the game
    {
        
        playPile.add(p1.playCard());
        playPile.add(p2.playCard());
        System.out.println(playPile.get(playPile.size()-2) + " vs " + playPile.get(playPile.size() - 1));
        if((playPile.get(playPile.size() - 2).compareTo(playPile.get(playPile.size() - 1)) < 0)) {
            System.out.println("Player 2 wins!");
            //System.out.println(playPile);
            p2.addWinings(playPile);
            handCount++;
        }
        else if((playPile.get(playPile.size() - 2).compareTo(playPile.get(playPile.size() - 1)) > 0)) {
            System.out.println("Player 1 wins!");
            //System.out.println(playPile);
            p1.addWinings(playPile);
            handCount++;
        } else {
            System.out.println("WAR");
            //System.out.println(playPile);
            play();
            handCount++;
        }
        
        System.out.println("P1 Hand: " + p1.getHandSize());
        System.out.println("P1 Win Pile: " + p1.getWinPileSize());
        System.out.println("P2 Hand: " + p2.getHandSize());
        System.out.println("P2 Win Pile: " + p2.getWinPileSize());
        System.out.println("Play Pile: " + playPile.size());
    }

    private static void endGame() //display game statistics
    {
        System.out.println("Number of hands played: " + handCount);
    }
}
