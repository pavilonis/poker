package org.example.extractors;

import org.example.model.CombinationType;
import org.example.model.Hand;
import org.junit.Test;

import static org.example.PokerService.parseCards;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FlushHandExtractorTest {

   private final FlushHandExtractor testObject = new FlushHandExtractor();

   @Test
   public void shouldExtractFlushCombinationHand() {
      Hand result = testObject.apply(parseCards("5C 2C AC 4C 9C"));
      assertThat(result.getCombinationType(), is(CombinationType.FLUSH));
   }

}