package org.example.extractors;

import org.example.model.Hand;
import org.junit.Test;

import static org.example.PokerService.parseCards;
import static org.example.model.CombinationType.FULL_HOUSE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class FullHouseHandExtractorTest {

   private final FullHouseHandExtractor testObject = new FullHouseHandExtractor();

   @Test
   public void shouldExtract() {
      Hand result = testObject.apply(parseCards("5C 5H 5S 7D 7H"));
      assertThat(result.getCombinationType(), is(FULL_HOUSE));
   }

   @Test
   public void shouldNotExtract() {
      Hand result = testObject.apply(parseCards("5C 5H 5S 7D 8H"));
      assertThat(result, is(nullValue()));
   }

}