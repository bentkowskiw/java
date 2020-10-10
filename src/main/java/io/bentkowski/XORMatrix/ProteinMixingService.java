package io.bentkowski.XORMatrix;


import org.springframework.stereotype.Service;

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

@Service
public class ProteinMixingService {


        public static final int Nmax = (int) (1e6 + 2);

        public static int[][] dp = new int[2][Nmax];





        public ProteinMixingResultDTO xor(char[] inputSequence, int K)
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

            char[] result = new char[N];
            for (int i = 0; i < N; ++i)
            {
                result[i] = (char)(dp[tip][i] + 'A');

            }
            System.out.print(new String(result));
            ProteinMixingResultDTO resultBean = new ProteinMixingResultDTO();
            resultBean.setResult(result);
            return resultBean;
        }
    }



