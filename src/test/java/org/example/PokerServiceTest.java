package org.example;

import org.example.model.Player;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PokerServiceTest {

   private final PokerService testObject = new PokerService();

   @Test
   public void playerAShouldWin() {
      Player winner = testObject.processGame("KH KS 5C 7S 7C QH QS 5C 7S 7C");
      assertThat(winner, is(Player.A));
   }

   @Test
   public void playerBShouldWin() {
      Player winner = testObject.processGame("TH TS 5C 7S 7C QH QS 5C 7S 7C");
      assertThat(winner, is(Player.B));
   }

   @Test
   public void fullHouseTest() {
      Player winner = testObject.processGame("TH TS TD 7S 7C 5S QH QS QC 5C");
      assertThat(winner, is(Player.B));
   }
}