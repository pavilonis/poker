package org.example.extractors;

import org.example.model.Hand;
import org.junit.Test;

import static org.example.PokerService.parseCards;
import static org.example.model.CombinationType.TWO_PAIRS;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class TwoPairsHandExtractorTest {

   private final TwoPairsHandExtractor testObject = new TwoPairsHandExtractor();

   @Test
   public void shouldExtract() {
      Hand result = testObject.apply(parseCards("5C 5H AS 2S 2H"));
      assertThat(result.getCombinationType(), is(TWO_PAIRS));
   }

   @Test
   public void shouldNotExtract() {
      Hand result = testObject.apply(parseCards("TH 8H 5C QS TC"));
      assertThat(result, is(nullValue()));
   }

}