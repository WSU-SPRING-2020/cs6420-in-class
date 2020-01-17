package uf;

public class WeightedQuickUF extends QuickUF {
  protected int[] sz;
  public WeightedQuickUF(int N) {
    super(N);
    sz = new int[N];
    for (int i = 0; i < N; i++) {
      sz[i] = 1;
    }
  }

  @Override
  public boolean union(int p, int q){
    int pRoot = find(p);
    int qRoot = find(q);
    if (pRoot == qRoot) return false;

    if(sz[pRoot] < sz[qRoot]){
      id[pRoot] = qRoot;
      sz[qRoot] += sz[pRoot];
    }else{
      id[qRoot] = pRoot;
      sz[pRoot] += sz[qRoot];
    }

    count--;
    return true;
  }
}
