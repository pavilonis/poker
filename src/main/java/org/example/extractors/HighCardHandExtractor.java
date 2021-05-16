package org.example.extractors;

import org.example.model.Card;
import org.example.model.CombinationType;
import org.example.model.Hand;

import java.util.List;
import java.util.function.Function;

public class HighCardHandExtractor implements Function<List<Card>, Hand> {
   @Override
   public Hand apply(List<Card> cards) {
      return new Hand(CombinationType.HIGH_CARD, cards, List.of(), cards);
   }
}
