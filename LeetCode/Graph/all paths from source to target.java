class Solution 
{
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) 
    {
        boolean[] visited = new boolean[graph.length];
        List<List<Integer>> fs = new ArrayList<>();
        marimo(graph,0,graph.length-1,visited,fs,new ArrayList<Integer>());
        return fs;
    }
    public void marimo(int[][] graph, int cur, int des, boolean[] visited, List<List<Integer>> fs, List<Integer> ds)
    {
        if(cur==des)
        {
            List<Integer> l1 = new ArrayList<>();
            l1.addAll(ds);
            // THE ABOVE TWO LINES OF CODE IS VERY IMPORTANT AS OTHERVISE YOULL GET EMPTY RESULTS IN ALL QUESTIONS THAT USE LIST.ADD AND LIST.REMOVE WHILE BACKTRACKING
          
            l1.add(cur);
            fs.add(l1);
            return;
        }
        visited[cur] = true;
        List<Integer> l1 = ds;
        l1.add(cur);
        for(int i=0; i<graph[cur].length; i++)
        {
            marimo(graph,graph[cur][i],des,visited,fs,l1);
            visited[graph[cur][i]]=false;
        }
        l1.remove(l1.size()-1);
        return;
    }
}
