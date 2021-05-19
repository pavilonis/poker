package org.example;

import org.example.model.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

   public static void main(String[] args) {
      Map<Player, Long> result = new PokerService().processGameStream(getLinesStream());

      System.out.println("Game results:");
      System.out.println("Player A " + result.getOrDefault(Player.A, 0L));
      System.out.println("Player B " + result.getOrDefault(Player.B, 0L));
   }

   private static Stream<String> getLinesStream() {
      Path path = Paths.get("input.txt");
      try {
         return Files.lines(path);
      } catch (IOException e) {
         e.printStackTrace();
         return Stream.empty();
      }
   }
}
