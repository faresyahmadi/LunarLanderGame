package edu.skidmore.cs226s23.lunarlander;

/**
* Christine Reilly
* CS226
*
* Adapted from assignment by Stuart Reges
*/
// Class LunarLanderFrame provides the user interface for a lunar landing
// simulation.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LunarLanderFrame extends CloseableFrame
{
  private LunarLander myLander;   // lander to query
  private LunarInfoPanel myInfo;  // info panel
  private LunarPicture myPicture; // picture panel
  private Timer myTimer;          // timer

	public LunarLanderFrame(int alt, int vel, int f, int grav, int t, int safe)
	{
		// create frame and lander
		setSize(300, 500);
		setTitle("CS226 Lunar Lander");
		Container contentPane = getContentPane();
		myLander = new LunarLander(alt, vel, f, grav, t, safe);
		// myLander.reset();

		// create and add info panel on bottom
		myInfo = new LunarInfoPanel(myLander);
		contentPane.add(myInfo, "South");

		// create and add lander picture
		myPicture = new LunarPicture(myLander);
		contentPane.add(myPicture, "Center");

		// create and add reset/thrust buttons at the top
		JPanel buttons = createButtonPanel();
		contentPane.add(buttons, "North");

		// create a timer and start it
		addTimer();
		myTimer.start();
	}

	private JPanel createButtonPanel()
	// post: creates and returns a panel with buttons for resetting the
	//       simulation and for applying thrust
	{
		JPanel buttons = new JPanel();

/*
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				myLander.reset();
        myTimer.restart();
				myInfo.update();
				myPicture.update();
			}
		});
		buttons.add(reset);
*/

		JButton thrust = new JButton("Thrust");
		thrust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				myLander.thrust();
			}
		});
		buttons.add(thrust);
		return buttons;
	}

	private void addTimer()
	// post: creates a timer that calls the lander's tick
	//       method and updates the displays
	{
		ActionListener updater = new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				myLander.tick();
				myInfo.update();
				myPicture.update();
				if (myLander.getAltitude() <= 0)
					myTimer.stop();
			}
		};
		myTimer = new Timer(1000, updater);
	}

 }
