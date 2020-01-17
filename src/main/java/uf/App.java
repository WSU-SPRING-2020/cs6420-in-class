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
    String[] inputFiles = { 
      "tinyUF.txt", 
      "mediumUF.txt"
    };

    StringBuilder report = new StringBuilder();
    report.append("       Input       N  Algorithm  Components  Time(millisecs)\n");
    report.append("=".repeat(60) + '\n');
    for (String inputFile : inputFiles) {
      Scanner in = new Scanner(App.class.getClassLoader().getResourceAsStream(inputFile));
      int n = in.nextInt();
      Algorithm[] algorithms = { 
        new Algorithm("UF", new UF(n)), 
        new Algorithm("QU", new QuickUF(n)),
        new Algorithm("WQ", new WeightedQuickUF(n)), 
        new Algorithm("PC", new PCWQuickUF(n)) 
      };
      in.close();

      for (Algorithm a : algorithms) {
        in = new Scanner(App.class.getClassLoader().getResourceAsStream(inputFile));
        n = in.nextInt();
        StopWatch sw = new StopWatch();
        while (in.hasNext()) {
          int p = in.nextInt();
          int q = in.nextInt();

          a.impl.union(p, q);
        }
        a.runningTime = sw.elapsedTime();
        in.close();
        report.append(String.format("%12s %7d %10s %11s %16d\n", inputFile, n, a.name, a.impl.componentsCount(), a.runningTime));
      }
    }

    System.out.println(report);
  }
}
