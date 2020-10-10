package io.bentkowski.numberNotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class NotationTransformerTest {

    private int number =655615145;


    @Test
    void transformNumber() {
        NotationTransformer transformer = new NotationTransformer(number);
        Stack<char[][]> result = transformer.transformNumber();
        int notation = (int) Math.log(number);
        for (char[][] value : result) {
            System.out.println(notation+" :");
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++)
                    System.out.print(value[i][j]);
                System.out.println("");
            }


            //System.out.println("");
            notation--;
        }

    }
}