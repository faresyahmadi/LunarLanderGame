package edu.skidmore.cs226s23.lunarlander;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
* Unit tests for the LunarLander class.
*
* @author Christine Reilly
* Copyright 2022 Christine F. Reilly
*/
class LunarLanderTests {

  /**
  * The accessor methods should return the values set by the constructor.
  */
  @Test
  @DisplayName("testAccessors")
  void testAccessors() {
    LunarLander l = new LunarLander(100, 50, 30, 3, 4, 10);

    assertEquals(50, l.getVelocity(), "velocity should be 50");
    assertEquals(100, l.getAltitude(), "altitude should be 100");
    assertEquals(30, l.getFuel(), "fuel should be 30");
    assertEquals(10, l.getSafeLanding(), "safe landing should be 10");
  } // end testAccessors

  /**
  * The thrust method should not alter the values returned by accessor methods.
  */
  @Test
  @DisplayName("testThrust")
  public void thrustDoesNotAlterValues() {
    LunarLander l = new LunarLander(100, 50, 30, 3, 4, 10);

    l.thrust();

    assertEquals(50, l.getVelocity(), "velocity should be 50");
    assertEquals(100, l.getAltitude(), "altitude should be 100");
    assertEquals(30, l.getFuel(), "fuel should be 30");
    assertEquals(10, l.getSafeLanding(), "safe landing should be 10");
  } // end thrustDoesNotAlterValues

  /**
  * When the thrust method has not been called, the tick method should result in:
  * velocity = velocity + gravitationalAcceleration
  * altitude = altitude - velocity
  * no change in fuel or safe landing
  */
  @Test
  @DisplayName("testTickNoThrust")
  public void tickNoThrust() {
    LunarLander l = new LunarLander(100, 50, 30, 3, 4, 10);

    l.tick();

    assertEquals(53, l.getVelocity(), "velocity should be 53");
    assertEquals(47, l.getAltitude(), "altitude should be 47");
    assertEquals(30, l.getFuel(), "fuel should be 30");
    assertEquals(10, l.getSafeLanding(), "safe landing should be 10");
  } // end tickNoThrust

  /**
  * When the thrust method has been called once then the tick method is called,
  * the result should be:
  * velocity = velocity + gravitationalAcceleration - thrustAcceleration
  * altitude = altitude - velocity
  * fuel = fuel - 1
  * no change in safe landing
  */
  @Test
  @DisplayName("thrustThenTick")
  public void thrustThenTick() {
    LunarLander l = new LunarLander(100, 50, 30, 3, 4, 10);

    l.thrust();
    l.tick();

    assertEquals(49, l.getVelocity(), "velocity should be 49");
    assertEquals(51, l.getAltitude(), "altitude should be 51");
    assertEquals(29, l.getFuel(), "fuel should be 29");
    assertEquals(10, l.getSafeLanding(), "safe landing should be 10");
  } // end thrustThenTick

  /**
  * Make sure thrust counter is reset after each tick.
  */
  @Test
  @DisplayName("thrustCountIsReset")
  public void thrustCountIsReset() {
    LunarLander l = new LunarLander(100, 50, 30, 3, 4, 10);

    l.thrust();
    l.tick();
    l.thrust();
    l.tick();

    assertEquals(48, l.getVelocity(), "velocity should be 48");
    assertEquals(3, l.getAltitude(), "altitude should be 3");
    assertEquals(28, l.getFuel(), "fuel should be 28");
    assertEquals(10, l.getSafeLanding(), "safe landing should be 10");
  } // end thrustCountIsReset

  /**
  * Make sure to not use more fuel than available.
  * Fuel is third paramteter to the constructor.
  */
  @Test
  @DisplayName("useAllFuel")
  public void useAllFuel() {
    LunarLander l = new LunarLander(100, 50, 3, 3, 4, 10);

    // Lander has 3 units of fuel
    // Call the thrust method 4 times
    l.thrust();
    l.thrust();
    l.thrust();
    l.thrust();

    // Call the tick method
    l.tick();

    // Check the LunarLander's state
    // fuel should be 0
    // Velocity should have had 3 engine thrusts applied
    // velocity = velocity + gravitationalAcceleration - (3*thrustAcceleration)
    // = 50 + 3 - (3 * 4)
    // Altitude should be 100 - 41
    // safe landing should not change
    assertEquals(41, l.getVelocity(), "velocity should be 41");
    assertEquals(59, l.getAltitude(), "altitude should be 59");
    assertEquals(0, l.getFuel(), "fuel should be 0");
    assertEquals(10, l.getSafeLanding(), "safe landing should be 10");
  } // end useAllFuel

  /**
  * Altitude should not be negative after a tick.
  */
  @Test
  @DisplayName("altitudeNotNegative")
  public void altitudeNotNegative() {
    LunarLander l = new LunarLander(50, 100, 30, 3, 4, 10);

    l.tick();

    assertEquals(103, l.getVelocity(), "velocity should be 103");
    assertEquals(0, l.getAltitude(), "altitude should be 0");
    assertEquals(30, l.getFuel(), "fuel should be 30");
    assertEquals(10, l.getSafeLanding(), "safe landing should be 10");
  } // end altitudeNotNegative


} // end LunarLanderTests class
