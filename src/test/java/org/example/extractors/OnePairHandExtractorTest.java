package org.example.extractors;

import org.example.model.CombinationType;
import org.example.model.Hand;
import org.junit.Test;

import static org.example.PokerService.parseCards;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OnePairHandExtractorTest {

   private final OnePairHandExtractor testObject = new OnePairHandExtractor();

   @Test
   public void shouldExtractOnePairCombinationHand() {
      Hand result = testObject.apply(parseCards("5C 5H AS 3S 9H"));
      assertThat(result.getCombinationType(), is(CombinationType.ONE_PAIR));
   }

}