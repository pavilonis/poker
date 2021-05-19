package org.example.extractors;

import org.example.model.Hand;
import org.junit.Test;

import static org.example.PokerService.parseCards;
import static org.example.model.CombinationType.STRAIGHT_FLUSH;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class StraightFlashHandExtractorTest {

   private final StraightFlashHandExtractor testObject = new StraightFlashHandExtractor();

   @Test
   public void shouldExtract() {
      Hand result = testObject.apply(parseCards("2S 3S 4S 5S 6S"));
      assertThat(result.getCombinationType(), is(STRAIGHT_FLUSH));
   }

   @Test
   public void shouldNotExtract() {
      Hand result = testObject.apply(parseCards("3S 3S 4S 5S 6S"));
      assertThat(result, is(nullValue()));
   }
}