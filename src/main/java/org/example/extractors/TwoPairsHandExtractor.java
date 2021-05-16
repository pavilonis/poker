package org.example.extractors;

import org.example.model.CombinationType;

public class TwoPairsHandExtractor extends RankGroupsHandExtractor {

   public TwoPairsHandExtractor() {
      super(2, 2);
   }

   @Override
   public CombinationType getCombinationType() {
      return CombinationType.TWO_PAIRS;
   }
}
