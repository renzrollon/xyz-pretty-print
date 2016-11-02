package com.i98labs.machineproblems.xyz.type;

/**
 * Created by renz on 10/31/16.
 */
public class XYZRequest {

    private String xyzString;
    private int xyzSize;
    private boolean isHorizontal;

    public XYZRequest(String xyzString, int xyzSize, boolean isHorizontal) {
        this.xyzString= xyzString;
        this.xyzSize = xyzSize;
        this.isHorizontal = isHorizontal;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public void setIsHorizontal(boolean isHorizontal) {
        this.isHorizontal = isHorizontal;
    }

    public int getXyzSize() {
        return xyzSize;
    }

    public void setXyzSize(int xyzSize) {
        this.xyzSize = xyzSize;
    }

    public String getXyzString() {
        return xyzString;
    }

    public void setXyzString(String xyzString) {
        this.xyzString = xyzString;
    }

    public int getXyzStringLength() {
        return this.xyzString.length();
    }

    public char getXyzChar(int index) {
        return this.xyzString.charAt(index);
    }
}
