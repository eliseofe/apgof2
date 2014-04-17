package io;

import gems.cli.*;

/**
 * This class is responsible for command line argument passing.
 * 
 * @author eferrante
 * 
 */
public class CLIParser {

	private static final CliOption EXPERIMENT_FILE = new CliOption("expfile", CliOptionType.SINGLE);
	private static final CliOption NUMBER_OF_PARTICLES = new CliOption("npart", CliOptionType.SINGLE);
	private static final CliOption RANDOM_SEED = new CliOption("seed", CliOptionType.SINGLE);

	private static final CliOptions OPTIONS = new CliOptions();
	static {
		OPTIONS.add(NUMBER_OF_PARTICLES);
		OPTIONS.add(RANDOM_SEED);
		OPTIONS.add(EXPERIMENT_FILE);
	}

	public static void parseCLIParameters(String[] args, boolean parseAll) {

		final CliActuators actuators = new CliParserImpl("-", "--").parse(args, OPTIONS);

		final CliActuator expFileActuator = actuators.getActuatorById(EXPERIMENT_FILE.getId());
		final CliActuator nPartActuator = actuators.getActuatorById(NUMBER_OF_PARTICLES.getId());
		final CliActuator rSeedActuator = actuators.getActuatorById(RANDOM_SEED.getId());

		if (expFileActuator != null) {
			Configuration.expFileName = expFileActuator.getValue();
		} else {
			System.out.println("[ERROR] Experiment file name NOT provided.");
			System.out.println("Correct syntax:");
			System.out.println("Apgof -expfile <experiment.xml> <optional arguments>");
			System.exit(-1);
		}

		if (parseAll) {
			if (nPartActuator != null) {
				Configuration.numberOfParticles = handleInt(nPartActuator.getValue(), actuators, Configuration.numberOfParticles);
			}

			if (rSeedActuator != null) {
				Configuration.randomSeed = handleInt(rSeedActuator.getValue(), actuators, Configuration.randomSeed);
			}

			Configuration.unrecognizedCLIParameters = actuators.getRests();
			
			System.out.println("After CLI");			
			Configuration.printParameters();
		}

	}
	
	private static int handleInt(String argument, CliActuators actuators, int defaultValue) {
		int result = defaultValue;
		try {
			result = Integer.parseInt(argument);
		} catch (NumberFormatException e) {
			actuators.addRest(argument);
		}
		return result;
	}
}
