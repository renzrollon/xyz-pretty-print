package com.i98labs.machineproblems.xyz.strategy;

import static com.i98labs.machineproblems.xyz.utils.StringUtils.padLeft;
import static com.i98labs.machineproblems.xyz.utils.StringUtils.padLeftAndRight;
import static com.i98labs.machineproblems.xyz.utils.StringUtils.padRight;

/**
 * Created by renz on 10/31/16.
 */
public abstract class CharLinePrinterStrategy {

    public void printCharLine(int lineSize, int lineIndex) {
        String initialLineString = "*";
        printCustom(initialLineString, lineSize, lineIndex);
    }

    protected abstract void printCustom(String currentString, int lineSize, int lineIndex);

    public static CharLinePrinterStrategy createXPrinter() {
        return new XLinePrinter();
    }

    public static CharLinePrinterStrategy createYPrinter() {
        return new YLinePrinter();
    }

    public static CharLinePrinterStrategy createZPrinter() {
        return new ZLinePrinter();
    }
}

abstract class XYLinePrinter extends CharLinePrinterStrategy {

    protected void printPaddedLeftAndRight(String origString, int padCount, char padChar) {
        System.out.print(padLeftAndRight(origString, padCount, padChar));
    }

    protected int calculatePadCount(int lineSize, int middleLineIndex,
                                    int distanceOfCurrentLineToMiddleLine, int numOfSpaceChars) {
        int padCount = lineSize - middleLineIndex;
        if(distanceOfCurrentLineToMiddleLine > 0) {
            padCount = (lineSize - numOfSpaceChars - 2) / 2;
        }
        return padCount;
    }

    protected void printCustom(String currentString, int lineSize, int lineIndex) {
        int middleLineIndex = (lineSize + 2 - 1) / 2;
        int distanceOfCurrentLineToMiddleLine = middleLineIndex - lineIndex;
        if(isX()) {
            distanceOfCurrentLineToMiddleLine = Math.abs(distanceOfCurrentLineToMiddleLine);
        }
        int numOfSpaceChars = (2 * distanceOfCurrentLineToMiddleLine) - 1;

        if(numOfSpaceChars > 0) {
            for(int i=0; i<numOfSpaceChars; i++) {
                currentString += " ";
            }
            currentString += "*";
        }
        int padCount = calculatePadCount(lineSize, middleLineIndex, distanceOfCurrentLineToMiddleLine, numOfSpaceChars);
        printPaddedLeftAndRight(currentString, padCount, ' ');
    }

    protected abstract boolean isX();
}

class XLinePrinter extends XYLinePrinter{

    @Override
    protected boolean isX() {
        return true;
    }
}

class YLinePrinter extends XYLinePrinter {

    @Override
    protected boolean isX() {
        return false;
    }
}

class ZLinePrinter extends CharLinePrinterStrategy {

    @Override
    protected void printCustom(String currentString, int lineSize, int lineIndex) {
        if(lineIndex==1 || lineIndex==lineSize) {
            System.out.print(padRight(currentString, lineSize - 1, '*'));
        } else {
            int padLeftNum = lineSize - lineIndex;
            int padRightNum = lineSize - padLeftNum - 1;
            String leftPadded = padLeft(currentString, padLeftNum, ' ');
            System.out.print(padRight(leftPadded, padRightNum, ' '));
        }
    }
}