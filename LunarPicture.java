package edu.skidmore.cs226s23.lunarlander;

/**
* Christine Reilly
* CS226

* Adapted from assignment by Stuart Reges
*/

// Class LunarPicture displays a graphical view of the lunar
// lander's current altitude

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LunarPicture extends JPanel
{
  private LunarLander myLander; // lander to query
  private int initialAltitude;

  public static final int BASE_HEIGHT = 20; // base height of 3 subfigures of lander
  public static final int BASE_WIDTH = 60;  // base width of lander figure

	public LunarPicture(LunarLander lander)
	// post: LunarPicture constructed with given lander object
	{
		myLander = lander;
    this.initialAltitude = lander.getAltitude();
	}

	public void update()
	// post: picture is redrawn to account for current lander state
	{
		repaint();
	}

	public void paintComponent(Graphics g)
	// post: lander is drawn
	{
		super.paintComponent(g);
		setBackground(Color.darkGray);
		g.setColor(Color.magenta);
		int altitude = myLander.getAltitude();
		if (altitude <= 0 && myLander.getVelocity() > myLander.getSafeLanding()) {
			Font f = new Font("Serif", Font.BOLD, Math.min(48, getHeight()));
			g.setFont(f);
			g.drawString("CRASH!", (getWidth() - g.getFontMetrics().stringWidth("CRASH!"))/2, (getHeight() + f.getSize())/2);
		} else {
			altitude = Math.max(0, altitude);
			int verticalSpace = getHeight() - 3 * BASE_HEIGHT - 4;
			int lowerLeftX = (getWidth() - BASE_WIDTH)/2;
			int lowerLeftY = 3 * BASE_HEIGHT + (this.initialAltitude - myLander.getAltitude()) * verticalSpace/this.initialAltitude + 2;
			// draw legs
			g.drawLine(lowerLeftX, lowerLeftY, lowerLeftX, lowerLeftY - BASE_HEIGHT);
			g.drawLine(lowerLeftX + BASE_WIDTH - 1, lowerLeftY, lowerLeftX + BASE_WIDTH - 1, lowerLeftY - BASE_HEIGHT);
			// draw struts
			g.drawLine(lowerLeftX - 3, lowerLeftY, lowerLeftX + 3, lowerLeftY);
			g.drawLine(lowerLeftX + BASE_WIDTH - 4, lowerLeftY, lowerLeftX + BASE_WIDTH + 2, lowerLeftY);
			// draw middle
			g.fillRect(lowerLeftX, lowerLeftY - 2 * BASE_HEIGHT, BASE_WIDTH, BASE_HEIGHT);
			// draw top
			g.fillOval(lowerLeftX, lowerLeftY - 3 * BASE_HEIGHT, BASE_WIDTH, BASE_HEIGHT);
		}
	}

}
