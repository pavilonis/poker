package org.example.extractors;

import org.example.model.CombinationType;

public class FourOfAKindHandExtractor extends RankGroupsHandExtractor {

   public FourOfAKindHandExtractor() {
      super(4);
   }

   @Override
   public CombinationType getCombinationType() {
      return CombinationType.FOUR_OF_A_KIND;
   }
}
