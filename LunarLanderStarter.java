package edu.skidmore.cs226s23.lunarlander;

/**
* Christine Reilly
* CS226

* Adapted from assignment by Stuart Reges
*/
public class LunarLanderStarter
{
	public static void main(String[] args)
	{
    // Game settings
    int initialAltitude = 1000; // meters
    int initialVelocity = 40; // meters/second
    int initialFuel = 25; // number of thrusts available
    int gravity = 2; // gravitational acceleration in meters/second/second
    int thrust = 4; // thrust acceleration in meters/second/second
    int safeLanding = 4; // speed at which lander can safely land

		LunarLanderFrame f = new LunarLanderFrame(initialAltitude, initialVelocity,
                          initialFuel, gravity, thrust, safeLanding);
    f.setVisible(true);
	}
}
