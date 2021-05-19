package org.example.extractors;

import org.example.model.Hand;
import org.junit.Test;

import static org.example.PokerService.parseCards;
import static org.example.model.CombinationType.FLUSH;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class FlushHandExtractorTest {

   private final FlushHandExtractor testObject = new FlushHandExtractor();

   @Test
   public void shouldExtract() {
      Hand result = testObject.apply(parseCards("5C 2C AC 4C 9C"));
      assertThat(result.getCombinationType(), is(FLUSH));
   }

   @Test
   public void shouldNotExtract() {
      Hand result = testObject.apply(parseCards("5C 2C AC 4C 9D"));
      assertThat(result, is(nullValue()));
   }

}