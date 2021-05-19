package org.example.extractors;

import org.example.model.Hand;
import org.junit.Test;

import static org.example.PokerService.parseCards;
import static org.example.model.CombinationType.ROYAL_FLUSH;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class RoyalFlushHandExtractorTest {

   private final RoyalFlushHandExtractor testObject = new RoyalFlushHandExtractor();

   @Test
   public void shouldExtract() {
      Hand result = testObject.apply(parseCards("TS JS QS KS AS"));
      assertThat(result.getCombinationType(), is(ROYAL_FLUSH));
   }

   @Test
   public void shouldNotExtract() {
      Hand result = testObject.apply(parseCards("TS JS QS KS AC"));
      assertThat(result, is(nullValue()));
   }
}