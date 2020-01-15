package uf;

public class PCWQuickUF extends WeightedQuickUF {
  public PCWQuickUF(int N) {
    super(N);
  }

  @Override
  public int find(int p) {
    while (p != id[p]) {
      id[p] = id[id[p]];  // path compression by halving
      p = id[p];
    }
    return p;
  }
}
