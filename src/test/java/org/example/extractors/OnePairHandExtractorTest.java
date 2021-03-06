package org.example.extractors;

import org.example.model.Hand;
import org.junit.Test;

import static org.example.PokerService.parseCards;
import static org.example.model.CombinationType.ONE_PAIR;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class OnePairHandExtractorTest {

   private final OnePairHandExtractor testObject = new OnePairHandExtractor();

   @Test
   public void shouldExtract() {
      Hand result = testObject.apply(parseCards("5C 5H AS 3S 9H"));
      assertThat(result.getCombinationType(), is(ONE_PAIR));
   }

   @Test
   public void shouldNotExtract() {
      Hand result = testObject.apply(parseCards("5C 2H AS 3S 9H"));
      assertThat(result, is(nullValue()));
   }

}