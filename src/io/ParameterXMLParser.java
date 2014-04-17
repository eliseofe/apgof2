package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;

public class ParameterXMLParser {

	private static Document doc;
	private static List<String> incorrectParameters;

	public static void initializeDocument(String xmlFilename) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		try {
			doc = builder.parse(xmlFilename);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		incorrectParameters = new ArrayList<String>();

	}

	public static void parseParameters() {
		Element root = doc.getDocumentElement();

		NodeList seedNode = root.getElementsByTagName("random_seed");
		Configuration.randomSeed = handleInt(seedNode, Configuration.randomSeed);

		NodeList numParticlesNode = root.getElementsByTagName("num_particles");
		Configuration.numberOfParticles = handleInt(numParticlesNode, Configuration.numberOfParticles);

		// String sPeriodidArenaSize = root.getElementsByTagName("periodic_arena_size").item(0).getTextContent();
		// flock.setL(Integer.parseInt(sPeriodidArenaSize));
		//
		// String sPeriodidArenaConstr = root.getElementsByTagName("periodic_arean_constraint_type").item(0).getTextContent();
		// flock.setPeriodicArenaConstraintType(Integer.parseInt(sPeriodidArenaConstr));
		//
		// String sInitAlign= root.getElementsByTagName("initial_alignment_type").item(0).getTextContent();
		// flock.setInitialAlignmentType(Integer.parseInt(sInitAlign));
		//
		// String sPertAlign= root.getElementsByTagName("perturb_initial_alignment").item(0).getTextContent();
		// flock.setPerturbInitialAlignment(Boolean.parseBoolean(sPertAlign));
		//
		// String sPertPlac = root.getElementsByTagName("perturb_initial_placement").item(0).getTextContent();
		// flock.setPerturbInitialPlacement(Boolean.parseBoolean(sPertPlac));
		//
		// String sLatticeElongation = root.getElementsByTagName("lattice_elongation").item(0).getTextContent();
		// flock.setLatticeElongation(Integer.parseInt(sLatticeElongation));
		//
		// String sPolydisp = root.getElementsByTagName("polydisperse").item(0).getTextContent();
		// flock.setPolydisperse(Boolean.parseBoolean(sPolydisp));
		//
		// String sBiasForwardSpeed = root.getElementsByTagName("bias_forward_speed").item(0).getTextContent();
		// flock.setU(100.0 * Double.parseDouble(sBiasForwardSpeed));
		//
		// String sEtaVicsek = root.getElementsByTagName("eta_vicsek").item(0).getTextContent();
		// flock.setEtaVicsek(Double.parseDouble(sEtaVicsek));
		//
		// String sEtaChate = root.getElementsByTagName("eta_chate").item(0).getTextContent();
		// flock.setEtaChate(Double.parseDouble(sEtaChate));
		//
		// String sRadius = root.getElementsByTagName("radius").item(0).getTextContent();
		// flock.setRadius(Double.parseDouble(sRadius));
		//
		// String sParticleGenerationMethod = root.getElementsByTagName("particle_generation_method").item(0).getTextContent();
		// flock.setParticleGenerationMethod(Integer.parseInt(sParticleGenerationMethod));
		//
		// String sInitialRotation = root.getElementsByTagName("initial_swarm_rotation").item(0).getTextContent();
		// flock.setSwarmInitialRotation(Math.toRadians(Double.parseDouble(sInitialRotation)));
		//
		//
		// String sPotentialFunction = root.getElementsByTagName("potential_function").item(0).getTextContent();
		// flock.setPotentialFunction(Integer.parseInt(sPotentialFunction));
		//
		// String sCristianoMaxForce = root.getElementsByTagName("cristian_max_force").item(0).getTextContent();
		// flock.setCristianoMaxForce(Double.parseDouble(sCristianoMaxForce));
		//
		// String sAlpha = root.getElementsByTagName("alpha_lennard").item(0).getTextContent();
		// flock.setAlpha(Double.parseDouble(sAlpha));
		//
		// String sDDes = root.getElementsByTagName("desired_distance").item(0).getTextContent();
		// flock.setDDes(Double.parseDouble(sDDes));
		//
		// String sEpsilon = root.getElementsByTagName("epsilon_lennard").item(0).getTextContent();
		// flock.setEpsilon(Double.parseDouble(sEpsilon));
		//
		// String sLinearDamping = root.getElementsByTagName("linear_damping").item(0).getTextContent();
		// flock.setInvk(Double.parseDouble(sLinearDamping));
		//
		// String sAngularDamping = root.getElementsByTagName("angular_damping").item(0).getTextContent();
		// flock.setInvk3(Double.parseDouble(sAngularDamping));
		//
		// String sDeltaT = root.getElementsByTagName("delta_t").item(0).getTextContent();
		// flock.setDtALI(Double.parseDouble(sDeltaT));
		//
		// String sMaxFSpeed = root.getElementsByTagName("max_forward_speed").item(0).getTextContent();
		// flock.setMaxSpeed(Double.parseDouble(sMaxFSpeed));
		//
		// String sMaxASpeed = root.getElementsByTagName("max_angular_speed").item(0).getTextContent();
		// flock.setMaxOmega(Math.toRadians(Double.parseDouble(sMaxASpeed)));
		//
		// String sVicNType = root.getElementsByTagName("vicsek_noise_type").item(0).getTextContent();
		// flock.setVicsekNoiseType(Integer.parseInt(sVicNType));
		//
		// String sNoiseDistribution = root.getElementsByTagName("noise_distribution").item(0).getTextContent();
		// flock.setNoiseDistribution(Integer.parseInt(sNoiseDistribution));
		//
		// String sIntegrationMethod = root.getElementsByTagName("integration_method").item(0).getTextContent();
		// flock.setIntegrationMethod(Integer.parseInt(sIntegrationMethod));
		//
		// String sDetectConv= root.getElementsByTagName("detect_convergence").item(0).getTextContent();
		// flock.setDetectConvergence(Boolean.parseBoolean(sDetectConv));
		//
		// String sVisualEnabled = root.getElementsByTagName("visualization_enabled").item(0).getTextContent();
		// flock.setVisualizationEnabled(Boolean.parseBoolean(sVisualEnabled));
		//
		// String sStatEn = root.getElementsByTagName("statistics_enabled").item(0).getTextContent();
		// flock.setStatsEnabled(Boolean.parseBoolean(sStatEn));
		//
		// String sStatFile = root.getElementsByTagName("statistics_file").item(0).getTextContent();
		// flock.setsStatsFilename(sStatFile);
		//
		// String sSaveState = root.getElementsByTagName("save_state").item(0).getTextContent();
		// flock.setSaveState(Boolean.parseBoolean(sSaveState));
		//
		// String sLoadState = root.getElementsByTagName("load_state").item(0).getTextContent();
		// flock.setLoadState(Boolean.parseBoolean(sLoadState));
		//
		// String sSaveStateFilename = root.getElementsByTagName("save_state_file_name").item(0).getTextContent();
		// flock.setsSaveStateFilename(sSaveStateFilename);
		//
		// String sLoadStateFilename = root.getElementsByTagName("load_state_file_name").item(0).getTextContent();
		// flock.setsLoadStateFilename(sLoadStateFilename);

		Configuration.unrecognizedXMLParameters = incorrectParameters;

		System.out.println("After XML");
		Configuration.printParameters();

	}

	private static int handleInt(NodeList node, int defaultValue) {
		int result = defaultValue;
		if (node.item(0) != null) {
			String sParameter = node.item(0).getTextContent();
			try {
				result = Integer.parseInt(sParameter);
			} catch (NumberFormatException e) {
				incorrectParameters.add(sParameter);
			}
		}
		return result;
	}

}
