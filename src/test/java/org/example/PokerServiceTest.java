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

   @Test
   public void highCardWinForPlayerB() {
      Player winner = testObject.processGame("8C TS KC 9H 4S 7D 2S 5D 3S AC");
      assertThat(winner, is(Player.B));
   }

   @Test
   public void twoPairsWinForPlayerA() {
      Player winner = testObject.processGame("5C AD 5D AC 9C 7C 5H 8D TD KS");
      assertThat(winner, is(Player.A));
   }

   @Test
   public void oneHigherPairWinForPlayerB() {
      Player winner = testObject.processGame("TH 8H 5C QS TC 9H 4D JC KS JS");
      assertThat(winner, is(Player.B));
   }

   @Test
   public void twoPairsWinForPlayerB() {
      Player winner = testObject.processGame("7C 5H KC QH JD AS KH 4C AD 4S");
      assertThat(winner, is(Player.B));
   }

   @Test
   public void oneHigherPairWinForPlayerA() {
      Player winner = testObject.processGame("5H KS 9C 7D 9H 8D 3S 5D 5C AH");
      assertThat(winner, is(Player.A));
   }

}