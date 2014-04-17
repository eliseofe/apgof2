package apgof2;

import io.CLIParser;
import io.Configuration;
import io.ParameterXMLParser;

public class Apgof {

	public static void main(String[] args) {
		CLIParser.parseCLIParameters(args,false);
		ParameterXMLParser.initializeDocument(Configuration.expFileName);
		ParameterXMLParser.parseParameters();
		CLIParser.parseCLIParameters(args,true);
	}

}
