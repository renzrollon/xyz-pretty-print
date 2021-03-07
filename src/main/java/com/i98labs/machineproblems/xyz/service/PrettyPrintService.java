package com.i98labs.machineproblems.xyz.service;

/**
 * Created by renz on 10/31/16.
 */
@FunctionalInterface
public interface PrettyPrintService<T> {
    void prettyPrint(T input);
}
