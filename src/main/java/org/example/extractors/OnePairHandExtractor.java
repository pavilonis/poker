package org.example.extractors;

import org.example.model.CombinationType;

public class OnePairHandExtractor extends RankGroupsHandExtractor {

   public OnePairHandExtractor() {
      super(2);
   }

   @Override
   public CombinationType getCombinationType() {
      return CombinationType.ONE_PAIR;
   }

}
