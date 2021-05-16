package org.example.extractors;

import org.example.model.Card;
import org.example.model.Rank;
import org.example.model.CombinationType;
import org.example.model.Hand;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.toSet;

public class RoyalFlushHandExtractor implements Function<List<Card>, Hand> {

   private final FlushHandExtractor flushHandExtractor = new FlushHandExtractor();

   private final Set<Rank> royalRanks =
         EnumSet.of(Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING, Rank.ACE);

   @Override
   public Hand apply(List<Card> cards) {
      Hand flushHand = flushHandExtractor.apply(cards);
      return flushHand == null || !allRoyal(flushHand.getCards())
            ? null
            : new Hand(CombinationType.ROYAL_FLUSH, cards, List.of(cards), List.of());
   }

   private boolean allRoyal(List<Card> cards) {
      Set<Rank> ranks = cards.stream()
            .map(Card::getRank)
            .collect(toSet());

      return ranks.containsAll(royalRanks);
   }
}
