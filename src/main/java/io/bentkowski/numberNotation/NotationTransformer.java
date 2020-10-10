package io.bentkowski.numberNotation;

import java.util.Stack;


public class NotationTransformer {

    private int number;

    private int notationSystem;
    private int position;
    private Stack<char[][]> output;
    private int sum;

    public NotationTransformer(int number) {
        this.number = number;
        output = new Stack<char[][]>();
    }

    public Stack<char[][]> transformNumber() {

        notationSystem = (int) Math.log(number);
        int megaSum = 0;
        while (notationSystem >= 2) {
            position = (int) Math.floor(Math.log(number) / Math.log(notationSystem));
            char[][] result = new char[position + 1][notationSystem];
            sum = 0;
            output.add(disassemble(number, result));
            System.out.println(notationSystem + ": " + sum);
            notationSystem--;
            megaSum += sum;
        }

        System.out.println(megaSum);
        return output;
    }

    private char[][] disassemble(int number, char[][] result) {
        int radix = (int) Math.pow(notationSystem, position);
        int factorAtPosition = (int) Math.floor(number / radix);

        for (; factorAtPosition > 0; --factorAtPosition) {
            result[position][factorAtPosition] = '.';
            sum++;
        }

        number = number % radix;
        --position;
        while (position >= 0)
            return disassemble(number, result);
        return result;
    }
}
