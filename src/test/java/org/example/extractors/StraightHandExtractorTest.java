package org.example.extractors;

import org.example.model.CombinationType;
import org.example.model.Hand;
import org.junit.Test;

import static org.example.PokerService.parseCards;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class StraightHandExtractorTest {

   private final StraightHandExtractor testObject = new StraightHandExtractor();

   @Test
   public void shouldExtractFlushCombinationHand() {
      Hand result = testObject.apply(parseCards("5C 6C 7S 8H 9H"));
      assertThat(result.getCombinationType(), is(CombinationType.STRAIGHT));
   }

   @Test
   public void shouldNotExtractTwoPair() {
      Hand result = testObject.apply(parseCards("5C 6C 7S 8H 10H"));
      assertThat(result, is(nullValue()));
   }

}