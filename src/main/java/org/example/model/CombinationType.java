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

   HIGH_CARD(new HighCardHandExtractor()),
   ONE_PAIR(new OnePairHandExtractor()),
   TWO_PAIRS(new TwoPairsHandExtractor()),
   THREE_OF_A_KIND(new ThreeOfAKindHandExtractor()),
   STRAIGHT(new StraightHandExtractor()),
   FLUSH(new FlushHandExtractor()),
   FULL_HOUSE(new FullHouseHandExtractor()),
   FOUR_OF_A_KIND(new FourOfAKindHandExtractor()),
   STRAIGHT_FLUSH(new StraightFlashHandExtractor()),
   ROYAL_FLUSH(new RoyalFlushHandExtractor());

   private final Function<List<Card>, Hand> handResolver;

   CombinationType(Function<List<Card>, Hand> handResolver) {
      this.handResolver = handResolver;
   }

   public Function<List<Card>, Hand> getHandResolver() {
      return handResolver;
   }
}
