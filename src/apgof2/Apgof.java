package apgof2;

import io.CLIParser;
import io.Configuration;
import io.ParameterXMLParser;

/** APGoF 2 - The best simulator ever
 * @author eferrante
 *
 */
public class Apgof {

	public static void main(String[] args) {
		CLIParser.parseCLIParameters(args,false);
		ParameterXMLParser.initializeDocument(Configuration.expFileName);
		ParameterXMLParser.parseParameters();
		CLIParser.parseCLIParameters(args,true);
	}

}
