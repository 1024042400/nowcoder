

public class _1PrintMatrix {
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        if(mat == null || n<=0 || m<=0){
            return new int[0];
        }
        int[] ret = new int[n*m];
        int s1 = 0,s2 = 0,e1 = n-1,e2 = m-1;
        int index = 0;
        while( s1 <= e1 && s2 <= e2) {
            if (s1 == e1){
                while(s2 <= e2) {
                    ret[index++] = mat[s1][s2++];
                }
            } else if(s2 == e2) {
                while(s1 <= e1) {
                    ret[index++] = mat[s1++][s2];
                }
            } else{
                index = addPrint(mat,ret,s1++,s2++,e1--,e2--,index);
            }
        }

        return ret;
    }

    private int addPrint(int[][] mat,int[] ret,int s1,int s2,int e1,int e2,int index) {
        int tmp = s2;
        while(tmp <= e2) {
            ret[index++] = mat[s1][tmp++];
        }
        tmp = s1+1;
        while(tmp <= e1) {
            ret[index++] = mat[tmp++][e2];
        }
        tmp = e2-1;
        while(tmp >= s2) {
            ret[index++] = mat[e1][tmp--];
        }
        tmp = e1-1;
        while(tmp > s1) {
            ret[index++] = mat[tmp--][s2];
        }
        return index;
    }
    public static void main(String[] args) {
        System.out.println("hello");
        _1PrintMatrix clazz = new _1PrintMatrix();
        int[][] matrix = new int[3][4];
        matrix[0] = new int []{1,2,3,4};
//        matrix[1] = new int []{5,6,7,8};
//        matrix[2] = new int []{9,10,11,12};
//        matrix[3] = new int []{13,14,15,16};
        int[] a = clazz.clockwisePrint(matrix,1,4);
        System.out.println(a);

        for(int i=0;i<a.length;i++) {
            System.out.println(a[i]);
        }
    }
}

