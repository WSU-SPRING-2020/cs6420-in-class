package uf;

public class UF implements UFable{
  protected int[] id;
  protected int count;
  public UF(int N) {
    count = N;
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  @Override
  public int componentsCount() { return count; }

  @Override
  public int find(int p) {  return id[p];  }

  @Override
  public boolean union(int p, int q) {
    int pID = find(p);
    int qID = find(q);

    if (pID == qID) return false;
    for (int i = 0; i < id.length; i++) {
      if (id[i] == pID) id[i] = qID;
    }

    count--;
    return true;
  }

}