package uf;

public interface UFable {
  public int componentsCount();
  public default boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public int find(int p);
  public void union(int p, int q);
}