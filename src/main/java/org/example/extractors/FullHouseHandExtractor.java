package org.example.extractors;

import org.example.model.Card;
import org.example.model.CombinationType;
import org.example.model.Hand;
import org.example.model.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;

public class FullHouseHandExtractor implements Function<List<Card>, Hand> {

   @Override
   public Hand apply(List<Card> cards) {
      Map<Rank, List<Card>> groupedCards = cards.stream()
            .collect(groupingBy(Card::getRank));

      boolean hasThree = false;
      boolean hasTwo = false;
      List<List<Card>> groups = new ArrayList<>();
      for (List<Card> group : groupedCards.values()) {
         if (group.size() == 3) {
            groups.add(group);
            hasThree = true;

         } else if (group.size() == 2) {
            groups.add(group);
            hasTwo = true;
         }
      }

      return hasThree && hasTwo
            ? new Hand(CombinationType.FULL_HOUSE, cards, groups, List.of())
            : null;
   }
}
