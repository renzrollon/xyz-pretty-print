package com.i98labs.machineproblems.xyz;


import com.i98labs.machineproblems.xyz.converter.Converter;
import com.i98labs.machineproblems.xyz.converter.XYZConverter;
import com.i98labs.machineproblems.xyz.service.PrettyPrintService;
import com.i98labs.machineproblems.xyz.service.XYZPrinterService;
import com.i98labs.machineproblems.xyz.type.XYZRequest;

/**
 * This simple application prints the letters X,Y and Z.
 * 
 * The program should accepts a sequence of XYZ letters, size, and orientation as its parameter.
 * 
 * The size should be any odd number starting at 3.
 * 
 * The orientation can be (h)orizontal or (v)ertical 
 */
public class App {

    private static PrettyPrintService<XYZRequest> printerService = new XYZPrinterService();
    private static Converter<String[], XYZRequest> converter = new XYZConverter();

	/**
	 * The main method which prints the XYZ
	 * 
	 * @param args
	 * args[0] - a sequence of X,Y,Z characters e.g. xxxyyyzzz
	 * args[1] - odd number size, starting from 3
	 * args[2] - h for Horizontal, v for Vertical
	 */
    public static void main( String[] args ) {
        XYZRequest request = converter.convert(args);
        printerService.prettyPrint(request);
    }
}
