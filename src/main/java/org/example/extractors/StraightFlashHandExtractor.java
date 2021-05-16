package org.example.extractors;

import org.example.model.Card;
import org.example.model.CombinationType;
import org.example.model.Hand;

import java.util.List;
import java.util.function.Function;

public class StraightFlashHandExtractor implements Function<List<Card>, Hand> {

   private final StraightHandExtractor straightHandExtractor = new StraightHandExtractor();
   private final FlushHandExtractor flushHandExtractor = new FlushHandExtractor();

   @Override
   public Hand apply(List<Card> cards) {
      Hand flushHand = flushHandExtractor.apply(cards);
      if (flushHand == null) {
         return null;
      }
      return straightHandExtractor.apply(flushHand.getCards()) == null
            ? null
            : new Hand(CombinationType.STRAIGHT_FLUSH, cards, List.of(cards), List.of());
   }
}
