package org.example.extractors;

import org.example.model.Card;
import org.example.model.CombinationType;
import org.example.model.Hand;

import java.util.List;
import java.util.function.Function;

public class FlushHandExtractor implements Function<List<Card>, Hand> {

   @Override
   public Hand apply(List<Card> cards) {
      char suit = cards.get(0).getSuit();
      boolean sameSuits = cards.stream()
            .map(Card::getSuit)
            .allMatch(cardSuit -> cardSuit == suit);

      return sameSuits
            ? new Hand(CombinationType.FLUSH, cards, List.of(cards), List.of())
            : null;
   }
}
