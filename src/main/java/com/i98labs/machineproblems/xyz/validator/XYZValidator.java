package com.i98labs.machineproblems.xyz.validator;

/**
 * Created by renz on 10/31/16.
 */
public class XYZValidator implements Validator<String[]> {

    private final static String ALLOWED_XYZ_STRING_REGEX = "[xyzXYZ]*";

    public void validate(String[] input) throws IllegalArgumentException {

        String xyzString = input[0];
        if(!xyzString.matches(ALLOWED_XYZ_STRING_REGEX)) {
            throw new IllegalArgumentException("Args[0] must only contains xyzXYZ characters.");
        }
        int oddSize = Integer.valueOf(input[1]);
        if(oddSize < 0 || oddSize%2 == 0) {
            throw new IllegalArgumentException("Args[1] must be an odd positive integer.");
        }

        String orientation = input[2];
        if(!("h".equalsIgnoreCase(orientation) || "v".equalsIgnoreCase(orientation))) {
            throw new IllegalArgumentException("Args[2] must be h or v only.");
        }
    }
}
