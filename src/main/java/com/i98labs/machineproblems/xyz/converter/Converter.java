package com.i98labs.machineproblems.xyz.converter;


/**
 * Created by renz on 10/31/16.
 */
public interface Converter<S,T> {
     T convert(S input) throws IllegalArgumentException;
}
