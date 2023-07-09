package DeckofCards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Card {
 private String face;
 private String suit;
 public Card(String face, String suit) {
 this.face = face;
 this.suit = suit;
 }
 // Getters for face and suit
 public String getFace() {
 return face;
 }
 public String getSuit() {
 return suit;
 }
 @Override
 public String toString() {
 return face + " of " + suit;
 }
 public static void main(String[] args) {
 List<Card> deck = new ArrayList<>();
 // Populate the deck with 52 cards
 String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
"Jack", "Queen", "King"};
 String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
 for (String suit : suits) {
 for (String face : faces) {
 deck.add(new Card(face, suit));
 }
 }
 // Shuffle the deck
 Collections.shuffle(deck);
 // Display the cards in the deck using an iterator
 System.out.println("Deck of Cards:");
 Iterator<Card> iterator = deck.iterator();
 while (iterator.hasNext()) {
 System.out.println(iterator.next());
 }
 // Draw a card from the deck
 Card drawnCard = deck.remove(0);
 System.out.println("\nDrawn Card: " + drawnCard);
 // Add the drawn card back to the deck
 deck.add(drawnCard);
 // Display the deck after drawing a card
 System.out.println("\nDeck of Cards after Drawing:");
 iterator = deck.iterator();
 while (iterator.hasNext()) {
 System.out.println(iterator.next());
 }
 }
}