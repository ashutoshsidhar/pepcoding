public class l001{
    public static int floodfill(,int sr ,int sc,int dr,int dc,int[][] dir,String[] Sdir,boolean[][] vis,String psf){
        if(sr = dr && sc == dc){
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        vis[sr][sc] = true;
        for(int d = 0; d < dir.length;d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(r >=0 && c >=0 && r <= dr && c <= dc && !vis[r][c] ){
                count += floodfill(r,c,dr,dc,dir,Sdir,vis,psf + Sdir[d] + " ");
            }
        }
        vis[sr][sc] = false;
        return count;
    }
    public static class pathPair{
        int len = 0;
        String psf ="";
        int count = 0;

        pathPair(int len,String psf,int count){
            this.len =len;
            this.psf = psf;
            this.count = count;
        }
    }
    public static int floodfill_LongestPath(,int sr ,int sc,int dr,int dc,int[][] dir,String[] Sdir,boolean[][] vis){
        if(sr = dr && sc == dc){
            return new pathPair(0, "", 1);
        }
        vis[sr][sc] = true;
        pathPair myAns = new pathPair(0, "", 0);
        for(int d = 0; d < dir.length;d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(r >=0 && c >=0 && r <= dr && c <= dc && !vis[r][c] ){
                pathPair recAns = floodfill_LongestPath(r,c,dr,dc,dir,Sdir,vis);
                if(recAns.len + 1 > myAns.len){
                    myAns.len = recAns.len + 1;
                    myAns.psf = Sdir[d] + recAns.psf;
                }
            }
        }
        vis[sr][sc] = false;
        return myAns;
    }
}