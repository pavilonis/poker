package org.example;

import org.example.model.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Main {

   public static void main(String[] args) {

      var service = new PokerService();

      List<Player> winners = getLinesStream()
            .map(service::processGame)
            .filter(Objects::nonNull)
            .collect(toList());

      Map<Player, Long> result = winners.stream()
            .collect(groupingBy(identity(), counting()));

      System.out.println("Game results:");
      System.out.println("Player A " + result.get(Player.A));
      System.out.println("Player B " + result.get(Player.B));
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
