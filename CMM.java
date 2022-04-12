import java.util.*;

public class CMM {
    public static int MatrixChain(int[][] matrix_sizes) {
        int length = matrix_sizes.length;
        int[][] C = new int[length][length];

        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                C[i][j] = Integer.MAX_VALUE/2;
            }
        }

        for(int i = 0; i < length; i++){
            for(int j = 0; j < length-i; j++){
                int a = j;
                int b = j+i;

                if(a == b)
                    C[a][b] = 0;
                else{
                    for(int k = a; k < b; k++){
                        C[a][b] = min(C[a][b], C[a][k] + C[k+1][b] + matrix_sizes[a][0] * matrix_sizes[k][1] * matrix_sizes[b][1]);
                    }
                }
            }
        }
        return C[0][length-1];
    }

    public static int min(int a, int b){
        return a < b ? a : b;
    }

    public static void main(String[] args) {
        int[][] matrix_sizes = {
                {10, 20, 5, 15},
                {20, 5, 15, 30}
        };
        System.out.printf("최소 연산 횟수 :" + MatrixChain(matrix_sizes));
    }
}

