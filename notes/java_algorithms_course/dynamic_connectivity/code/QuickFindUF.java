public class QuickFindUF {
    private int[] id;
    public QuickFindUF(int N) {
        id = new Int[N];
        for (int i=0; i<N; i++){
            id[i] = i; //set id of each object to itself (N array accesses)
        }
    }
    public boolean connected(int p, int q) {
        return id[p] = id[q];
    }
    public void union(int p, int q) {
        for (int i=0;i<id.length; i++) {
            int pid = id[p];
            int qid = id[q];
            if(id[i] == pid) {
                id[i] = qid;
            }
        }
    }
}