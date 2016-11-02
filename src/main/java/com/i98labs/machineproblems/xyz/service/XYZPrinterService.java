package com.i98labs.machineproblems.xyz.service;

import com.i98labs.machineproblems.xyz.strategy.XYZPrinterStrategy;
import com.i98labs.machineproblems.xyz.type.XYZRequest;


/**
 * Created by renz on 10/31/16.
 */
public class XYZPrinterService implements PrettyPrintService<XYZRequest> {

    private XYZPrinterStrategy horizontalPrinter = XYZPrinterStrategy.createHorizontalXYZPrinter();

    private XYZPrinterStrategy verticalPrinter = XYZPrinterStrategy.createVerticalXYZPrinter();

    public void prettyPrint(XYZRequest request) {
        if(request.isHorizontal()) {
            horizontalPrinter.prettyPrint(request);
        } else {
            verticalPrinter.prettyPrint(request);
        }
    }
}
