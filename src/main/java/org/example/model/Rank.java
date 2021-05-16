package org.example.model;

import java.util.stream.Stream;

public enum Rank implements Comparable<Rank> {

   ONE(1),
   TWO(2),
   THREE(3),
   FOUR(4),
   FIVE(5),
   SIX(6),
   SEVEN(7),
   EIGHT(8),
   NINE(9),
   TEN(10),
   JACK(11),
   QUEEN(12),
   KING(13),
   ACE(14);

   private final int rankValue;

   Rank(int rankValue) {
      this.rankValue = rankValue;
   }

   public static Rank valueOf(int rank) {
      // Looping through values for simplicity. Switch statement could be used for better performance
      return Stream.of(values())
            .filter(value -> value.rankValue == rank)
            .findFirst()
            .orElseThrow();
   }

   public int getRankValue() {
      return rankValue;
   }
}
