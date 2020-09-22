package bentkowski.XORMatrix;


/**
 * This class solves the problem o N iterations on abelan group transformations
 * this example solves the problem of applying XOR operations on numbers 0-3 or  letters
 * A-D
 * Results are inside matrix
 *              i n p u t
 *              A   B   C   D
 *  i
 *  n   A       A   B   C   D
 *  p   B       B   A   D   C
 *  u   C       C   D   A   B
 *  t   D       D   C   B   A
 */
public class ProteinMixingService {


        public static final int Nmax = (int) (1e6 + 2);

        public static int[][] dp = new int[2][Nmax];



        public static void main(String[] args)  {
            ProteinMixingService s = new ProteinMixingService();
            char[] seq = {'A','A','A','A','D','D','A','A','A','A'};
            s.xor(seq,100000000);
        }

        public char[] xor(char[] inputSequence, int K)
        {

            int tip = 0;
            int N = inputSequence.length;

            for (int i = 0; i < N; ++i)
            {
                char ch;

                ch = inputSequence[i];

                dp[tip][i] = ch - 'A';

            }



            for (int j = 0; (1 << j) <= K; ++j)
            {
                System.out.println(" j: "+j+" j<<: "+(1 << j));
                if (((1 << j) & K) != 0)
                {
                    for (int i = 0; i < N; ++i)
                    {
                        dp[tip ^ 1][i] = dp[tip][i] ^ dp[tip][(i + (1 << j)) % N];
                        System.out.print((char)(dp[tip][i] + 'A'));
                    }

                    tip ^= 1;
                    System.out.println(" j: "+j+" j<<: "+(1 << j));

                }
            }

            for (int i = 0; i < N; ++i)
            {
                System.out.print((char)(dp[tip][i] + 'A'));
            }

            return null;
        }
    }



