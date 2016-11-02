package com.i98labs.machineproblems.xyz.validator;

/**
 * Created by renz on 10/31/16.
 */
public interface Validator<T> {

    void validate(T object) throws IllegalArgumentException;
}
