package org.example.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;

public class Hand implements Comparable<Hand> {

   private final CombinationType combinationType;
   private final List<Card> cards;
   private final List<List<Card>> cardsCombinationGrouped;
   private final List<Card> cardsUnused;

   public Hand(CombinationType combinationType, List<Card> cards,
               List<List<Card>> cardsCombinationGrouped, List<Card> cardsUnused) {

      this.combinationType = combinationType;
      this.cards = cards;
      this.cardsCombinationGrouped = cardsCombinationGrouped;
      this.cardsUnused = cardsUnused;
   }

   @Override
   public int compareTo(Hand that) {
      int result = this.combinationType.compareTo(that.combinationType);
      if (result != 0) {
         return result;
      }

      if (combinationType == CombinationType.FULL_HOUSE) {
         return compareCombinationGroups(this.cardsCombinationGrouped, that.cardsCombinationGrouped);
      }

      result = compareCards(flatten(this.cardsCombinationGrouped), flatten(that.cardsCombinationGrouped));
      if (result != 0) {
         return result;
      }
      return compareCards(this.cardsUnused, that.cardsUnused);
   }

   private int compareCombinationGroups(List<List<Card>> groups1, List<List<Card>> groups2) {
      List<List<Card>> sortedGroups1 = new ArrayList<>(groups1);
      sortedGroups1.sort((c1, c2) -> Integer.compare(c2.size(), c1.size()));

      for (List<Card> group1 : sortedGroups1) {
         List<Card> relatedGroup2 = groups2.stream()
               .filter(group2 -> group2.size() == group1.size())
               .findFirst()
               .orElseThrow();

         int result = compareCards(group1, relatedGroup2);
         if (result != 0) {
            return result;
         }
      }
      return 0;
   }

   private int compareCards(List<Card> group1, List<Card> group2) {
      List<Card> group1Sorted = new ArrayList<>(group1);
      List<Card> group2Sorted = new ArrayList<>(group2);
      group1Sorted.sort(reverseOrder());
      group2Sorted.sort(reverseOrder());
      for (int i = 0; i < group1.size(); i++) {
         Card card1 = group1Sorted.get(i);
         Card card2 = group2Sorted.get(i);
         int result = card1.compareTo(card2);
         if (result != 0) {
            return result;
         }
      }
      return 0;
   }

   private List<Card> flatten(List<List<Card>> listGroups) {
      return listGroups.stream()
            .flatMap(Collection::stream)
            .collect(toList());
   }

   public List<Card> getCards() {
      return cards;
   }

   public CombinationType getCombinationType() {
      return combinationType;
   }

   /**
    * Used for debug
    */
   @Override
   public String toString() {
      return "Hand{" +
            "combinationType=" + combinationType +
            ", cardsCombinationGrouped=" + cardsCombinationGrouped +
            '}';
   }
}
