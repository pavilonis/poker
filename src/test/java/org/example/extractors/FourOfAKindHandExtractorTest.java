package org.example.extractors;

import org.example.model.Hand;
import org.junit.Test;

import static org.example.PokerService.parseCards;
import static org.example.model.CombinationType.FOUR_OF_A_KIND;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class FourOfAKindHandExtractorTest {

   private final FourOfAKindHandExtractor testObject = new FourOfAKindHandExtractor();

   @Test
   public void shouldExtract() {
      Hand result = testObject.apply(parseCards("5C 5H 5S 5D 9H"));
      assertThat(result.getCombinationType(), is(FOUR_OF_A_KIND));
   }

   @Test
   public void shouldNotExtract() {
      Hand result = testObject.apply(parseCards("5C 5H 5S 6D 9H"));
      assertThat(result, is(nullValue()));
   }

}