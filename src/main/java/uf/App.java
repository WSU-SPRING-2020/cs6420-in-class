package uf;

import java.util.Scanner;
import common.StopWatch;

public class App {
  private static class Algorithm {
    String name;
    UFable impl;
    long runningTime;

    public Algorithm(String name, UFable impl) {
      this.name = name;
      this.impl = impl;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(App.class.getClassLoader().getResourceAsStream("tinyUF.txt"));
    int n = in.nextInt();
    Algorithm[] algorithms = { new Algorithm("UF", new UF(n)), new Algorithm("QU", new QuickUF(n)),
        new Algorithm("WQ", new WeightedQuickUF(n)), new Algorithm("PC", new PCWQuickUF(n)) };

    for (int i = 0; i < algorithms.length; i++) {
      StopWatch sw = new StopWatch();
      while (in.hasNext()) {
        int p = in.nextInt();
        int q = in.nextInt();

        if (!algorithms[i].impl.connected(p, q)) {
          algorithms[i].impl.union(p, q);
        }
      }

      algorithms[i].runningTime = sw.elapsedTime();
    }

    System.out.printf("Algorithms Components RunningTime\n");
    for (Algorithm a : algorithms) {
      System.out.printf("%9s%11s%12d\n", a.name, a.impl.componentsCount(), a.runningTime);
    }

    in.close();
  }
}
