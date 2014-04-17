package io;

import java.util.ArrayList;
import java.util.List;


/** This class contains all the experiment parameters and their default values
 * @author eferrante
 *
 */
public class Configuration {
	public static String expFileName = "experiment.xml";
	public static int numberOfParticles = 91;
	public static int randomSeed = 1;
	
	public static List<String> unrecognizedCLIParameters = new ArrayList<String>();
	public static List<String> unrecognizedXMLParameters;
	
	public static void printParameters(){
		System.out.println("Experiment file name: " + expFileName);
		System.out.println("Number of particles: " + numberOfParticles);
		System.out.println("Random seed: " + randomSeed);
		
		System.out.print("The following arguments were not recognized from command line: ");
		for (final String unrecogPar : unrecognizedCLIParameters) {
			System.out.print("'" + unrecogPar + "' ");
		}
		System.out.println("\n");
		
		System.out.print("The following arguments were not recognized from XML: ");
		for (final String unrecogPar : unrecognizedXMLParameters) {
			System.out.print("'" + unrecogPar + "' ");
		}
		System.out.println("\n");
	}
	
}
