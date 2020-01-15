package uf;

public class QuickUF extends UF {

  public QuickUF(int N) {
    super(N);
  }

  @Override
  public int find(int p) {
    while (p != id[p]){
      p = id[p];
    }

    return p;
  }

  @Override
  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    if (pRoot == qRoot) return;
    id[pRoot] = qRoot;
    count--;
  }
}
