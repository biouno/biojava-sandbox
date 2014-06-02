package org.biouno.biojava;

import java.awt.Canvas;

import org.biojava.bio.structure.Structure;
import org.biojava.bio.structure.align.gui.jmol.StructureAlignmentJmol;
import org.biojava3.structure.StructureIO;
import org.jmol.adapter.smarter.SmarterJmolAdapter;
import org.jmol.viewer.JmolConstants;
import org.jmol.viewer.Viewer;

public class ExportImages {

	public static void main3(String[] args) {
		// Create the objects
		java.awt.Canvas display = new Canvas();
		org.jmol.adapter.smarter.SmarterJmolAdapter adapter = new SmarterJmolAdapter();
		org.jmol.viewer.Viewer viewer = (Viewer) Viewer.allocateViewer(display,
				adapter, null, null, null, null, null);
		try {
			viewer.setScreenDimension(1, 1);
			viewer.scriptWait("load 'crystal.cif' {1 1 1};");
			// can do more scripting here...
			viewer.setScreenDimension(400, 400);

			// anti-aliasing enabled
			viewer.getGraphics3D().setWindowParameters(400, 400, true);

			// Create image
			viewer.getImageAs("PNG", 1, 400, 400, "image.png", null);
		} finally {
			// Ensure threads are stopped
			viewer.setModeMouse(JmolConstants.MOUSE_NONE);
		}
	}

	public static void main2(String[] args) {
		try {
			Structure struc = StructureIO.getStructure("4hhb");

			StructureAlignmentJmol jmolPanel = new StructureAlignmentJmol();

			jmolPanel.setStructure(struc);

			// send some commands to Jmol
			jmolPanel.evalString("select * ; color chain;");
			jmolPanel
					.evalString("select *; spacefill off; wireframe off; cartoon on;  ");
			jmolPanel
					.evalString("select ligands; cartoon off; wireframe 0.3; spacefill 0.5; color cpk;");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// Create the objects
		java.awt.Canvas display = new Canvas();
		org.jmol.adapter.smarter.SmarterJmolAdapter adapter = new SmarterJmolAdapter();
		org.jmol.viewer.Viewer viewer = (Viewer) Viewer.allocateViewer(display,
				adapter, null, null, null, null, null);
		try {
			viewer.setScreenDimension(1, 1);
			viewer.scriptWait("load 'crystal.cif' {1 1 1};");
			// can do more scripting here...
			viewer.setScreenDimension(400, 400);

			// anti-aliasing enabled
			viewer.getGraphics3D().setWindowParameters(400, 400, true);

			// Create image
			viewer.getImageAs("PNG", 1, 400, 400, "image.png", null);
		} finally {
			// Ensure threads are stopped
			viewer.setModeMouse(JmolConstants.MOUSE_NONE);
		}
	}

}
