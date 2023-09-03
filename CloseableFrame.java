package edu.skidmore.cs226s23.lunarlander;

/**
* Christine Reilly
* CS226
*
* Adapted from assignment by Stuart Reges
*/
// Class CloseableFrame provides a variant of JFrame that includes
// a window listener that closes the window and exits the
// current application when the user selects the close button.

import javax.swing.*;
import java.awt.event.*;

public class CloseableFrame extends JFrame
{
	public CloseableFrame()
	{
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
}
