package org.example.extractors;

import org.example.model.Hand;
import org.junit.Test;

import static org.example.PokerService.parseCards;
import static org.example.model.CombinationType.THREE_OF_A_KIND;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class ThreeOfAKindHandExtractorTest {

   private final ThreeOfAKindHandExtractor testObject = new ThreeOfAKindHandExtractor();

   @Test
   public void shouldExtract() {
      Hand result = testObject.apply(parseCards("5C 5H 5S 2S 3H"));
      assertThat(result.getCombinationType(), is(THREE_OF_A_KIND));
   }

   @Test
   public void shouldNotExtract() {
      Hand result = testObject.apply(parseCards("5C 5H 4S 2S 3H"));
      assertThat(result, is(nullValue()));
   }

}