package org.example.model;

import org.example.extractors.FlushHandExtractor;
import org.example.extractors.FourOfAKindHandExtractor;
import org.example.extractors.FullHouseHandExtractor;
import org.example.extractors.HighCardHandExtractor;
import org.example.extractors.OnePairHandExtractor;
import org.example.extractors.RoyalFlushHandExtractor;
import org.example.extractors.StraightFlashHandExtractor;
import org.example.extractors.StraightHandExtractor;
import org.example.extractors.ThreeOfAKindHandExtractor;
import org.example.extractors.TwoPairsHandExtractor;

import java.util.List;
import java.util.function.Function;

public enum CombinationType {

   ROYAL_FLUSH(new RoyalFlushHandExtractor()),
   STRAIGHT_FLUSH(new StraightFlashHandExtractor()),
   FOUR_OF_A_KIND(new FourOfAKindHandExtractor()),
   FULL_HOUSE(new FullHouseHandExtractor()),
   FLUSH(new FlushHandExtractor()),
   STRAIGHT(new StraightHandExtractor()),
   THREE_OF_A_KIND(new ThreeOfAKindHandExtractor()),
   TWO_PAIRS(new TwoPairsHandExtractor()),
   ONE_PAIR(new OnePairHandExtractor()),
   HIGH_CARD(new HighCardHandExtractor());

   private final Function<List<Card>, Hand> handResolver;

   CombinationType(Function<List<Card>, Hand> handResolver) {
      this.handResolver = handResolver;
   }

   public Function<List<Card>, Hand> getHandResolver() {
      return handResolver;
   }
}
