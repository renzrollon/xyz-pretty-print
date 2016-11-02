package com.i98labs.machineproblems.xyz.converter;

import com.i98labs.machineproblems.xyz.type.XYZRequest;
import com.i98labs.machineproblems.xyz.validator.Validator;
import com.i98labs.machineproblems.xyz.validator.XYZValidator;

/**
 * Created by renz on 10/31/16.
 */
public class XYZConverter implements Converter<String[], XYZRequest> {

    public static final String DEFAULT_XYZ_STRING = "xyz";
    public static final int DEFAULT_XYZ_SIZE = 3;
    public static final boolean DEFAULT_IS_HORIZONTAL = true;
    public static final String HORIZONTAL_STRING = "h";

    private Validator<String[]> validator = new XYZValidator();

    public XYZRequest convert(String[] input) throws IllegalArgumentException {
        if(input==null || input.length==0){
            return new XYZRequest(DEFAULT_XYZ_STRING, DEFAULT_XYZ_SIZE, DEFAULT_IS_HORIZONTAL);
        }
        try {
            validator.validate(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }

        String xyzString = input[0].toLowerCase();
        int xyzSize = Integer.valueOf(input[1]);
        boolean isHorizontal = HORIZONTAL_STRING.equalsIgnoreCase(input[2]);

        return new XYZRequest(xyzString, xyzSize, isHorizontal);
    }
}
