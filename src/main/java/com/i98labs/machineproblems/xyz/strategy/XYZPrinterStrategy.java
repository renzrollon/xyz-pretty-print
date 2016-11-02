package com.i98labs.machineproblems.xyz.strategy;

import com.i98labs.machineproblems.xyz.type.XYZRequest;

import static com.i98labs.machineproblems.xyz.utils.StringUtils.padLeft;

/**
 * Created by renz on 10/31/16.
 */
public abstract class XYZPrinterStrategy {

    public abstract void prettyPrint(XYZRequest request);

    public static XYZPrinterStrategy createHorizontalXYZPrinter() {
        return new XYZHorizontalPrinter();
    }

    public static XYZPrinterStrategy createVerticalXYZPrinter() {
        return new XYZVerticalPrinter();
    }

    protected CharLinePrinterStrategy xPrinter = CharLinePrinterStrategy.createXPrinter();
    protected CharLinePrinterStrategy yPrinter = CharLinePrinterStrategy.createYPrinter();
    protected CharLinePrinterStrategy zPrinter = CharLinePrinterStrategy.createZPrinter();

    protected void printXYZCharLine(char xyzChar, int lineSize, int lineIndex, boolean withLineBreak) {
        switch (xyzChar) {
            case 'x' : {
                xPrinter.printCharLine(lineSize, lineIndex);
                break;
            }
            case 'y' : {
                yPrinter.printCharLine(lineSize, lineIndex);
                break;
            }
            case 'z' : {
                zPrinter.printCharLine(lineSize, lineIndex);
                break;
            }
        }

        if(withLineBreak) {
            System.out.println();
        }
    }

}

class XYZHorizontalPrinter extends XYZPrinterStrategy {

    @Override
    public void prettyPrint(XYZRequest request) {
        final int lineSize = request.getXyzSize();
        for(int lineIndex = 1; lineIndex <= lineSize; lineIndex++) {
            for(int charIndex = 0; charIndex < request.getXyzStringLength(); charIndex++) {
                char currentChar = request.getXyzChar(charIndex);
                printXYZCharLine(currentChar, lineSize, lineIndex, false);
                if(charIndex<request.getXyzStringLength()-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

class XYZVerticalPrinter extends XYZPrinterStrategy{

    @Override
    public void prettyPrint(XYZRequest request) {
        final int lineSize = request.getXyzSize();
        for(int charIndex = 0; charIndex < request.getXyzStringLength(); charIndex++) {
            char currentChar = request.getXyzChar(charIndex);
            for (int lineIndex = 1; lineIndex <= lineSize; lineIndex++) {
                printXYZCharLine(currentChar, lineSize, lineIndex, true);
            }

            if(charIndex<request.getXyzStringLength()-1) {
                System.out.println(padLeft("", lineSize, ' '));
            }
        }
    }
}

