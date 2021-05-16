package org.example.extractors;

import org.example.model.CombinationType;

public class ThreeOfAKindHandExtractor extends RankGroupsHandExtractor {

   public ThreeOfAKindHandExtractor() {
      super(3);
   }

   @Override
   public CombinationType getCombinationType() {
      return CombinationType.THREE_OF_A_KIND;
   }
}
