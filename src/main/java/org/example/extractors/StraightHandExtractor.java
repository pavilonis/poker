package org.example.extractors;

import org.example.model.Card;
import org.example.model.Rank;
import org.example.model.CombinationType;
import org.example.model.Hand;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class StraightHandExtractor implements Function<List<Card>, Hand> {

   @Override
   public Hand apply(List<Card> cards) {
      return isStraight(cards)
            ? new Hand(CombinationType.STRAIGHT, cards, List.of(cards), List.of())
            : null;
   }

   private boolean isStraight(List<Card> cards) {
      List<Rank> ranks = cards.stream()
            .map(Card::getRank)
            .sorted()
            .collect(toList());

      int rankCounter = ranks.get(0).getRankValue();
      for (Rank rank : ranks) {
         if (rankCounter != rank.getRankValue()) {
            return false;
         }
         rankCounter++;
      }
      return true;
   }
}
