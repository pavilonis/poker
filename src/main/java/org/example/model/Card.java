package org.example.model;

public class Card implements Comparable<Card> {

   private final Rank rank;
   private final char suit;

   public Card(String card) {
      this.rank = extractCardRank(card);
      this.suit = card.charAt(1);
   }

   @Override
   public int compareTo(Card other) {
      return this.rank.compareTo(other.rank);
   }

   public Rank getRank() {
      return rank;
   }

   public char getSuit() {
      return suit;
   }

   private Rank extractCardRank(String card) {
      char rankChar = card.charAt(0);
      if (Character.isDigit(rankChar)) {
         int numericValue = Character.getNumericValue(rankChar);
         return Rank.valueOf(numericValue);
      }
      switch (rankChar) {
         case 'T':
            return Rank.TEN;
         case 'J':
            return Rank.JACK;
         case 'Q':
            return Rank.QUEEN;
         case 'K':
            return Rank.KING;
         case 'A':
            return Rank.ACE;
         default:
            throw new RuntimeException("Not expected card rank: " + rankChar);
      }
   }

   /**
    * Used for debug
    */
   @Override
   public String toString() {
      return "Card{" +
            "rank=" + rank +
            ", suit=" + suit +
            '}';
   }
}
