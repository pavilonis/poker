package org.example.extractors;

import org.example.model.Card;
import org.example.model.CombinationType;
import org.example.model.Hand;
import org.example.model.Rank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;

public abstract class RankGroupsHandExtractor implements Function<List<Card>, Hand> {

   private final List<Integer> groupSizesToFind;

   public RankGroupsHandExtractor(Integer... groupSizesToFind) {
      this.groupSizesToFind = List.of(groupSizesToFind);
   }

   @Override
   public Hand apply(List<Card> cards) {

      Map<Rank, List<Card>> groupedCards = cards.stream()
            .collect(groupingBy(Card::getRank));

      List<List<Card>> cardGroups = new ArrayList<>(groupedCards.values());
      List<Integer> groupSizesNotFound = new ArrayList<>(groupSizesToFind);
      List<Card> unusedCards = new ArrayList<>(cards);
      List<List<Card>> usedCardGroups = new ArrayList<>();

      for (Integer sizeToFind : groupSizesToFind) {
         if (groupSizesNotFound.contains(sizeToFind)) {
            for (List<Card> group : List.copyOf(cardGroups)) {
               if (sizeToFind.equals(group.size())) {
                  cardGroups.remove(group);
                  groupSizesNotFound.remove(sizeToFind);
                  unusedCards.removeAll(group);
                  usedCardGroups.add(group);
               }
            }
         }
      }

      return usedCardGroups.size() == groupSizesToFind.size()
            ? new Hand(getCombinationType(), cards, usedCardGroups, unusedCards)
            : null;
   }

   public abstract CombinationType getCombinationType();
}
