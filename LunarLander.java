package edu.skidmore.cs226s23.lunarlander;

/**
* CS226 Homework Assignment 2
* Spring 2023
|
* @author Fares Yahmadi
*/
public class LunarLander {
  // declaring the instance variable 
  private int initi_alt;
  private int initi_vel;
  private int initi_fuel;
  private int grav_accel;
  private int thrust_accel;
  private int max_speed = 4;


  // this is the constructor intializes the instance variables
  public LunarLander (int a, int v, int f, int grav, int thrust, int max){
    this.initi_alt = a; 
    this.initi_vel = v;
    this.initi_fuel = f;
    this.grav_accel = grav; 
    this.thrust_accel = thrust; 
    this.max_speed = max;
  }  
  
  // return the altitude whenever called 
  public int getAltitude(){ 
    return this.initi_alt; 
  }
  // return the velocity whenever called
  public int getVelocity(){
    return this.initi_vel;  
  }
  // return the fuel whenever called
  public int getFuel () {
    return this.initi_fuel;
  }  
  // return the value of safe landing whenever called
  public int getSafeLanding () {
    return this.max_speed;
  }
  // calculates how many times the thrust button has been pressed between updates 
  public void thrust () {
    this.thrust_accel = this.thrust_accel + 1;
  }   

  // the void method updates the altitude, velocity, thrust acceleration and returns nothing 
  public void tick () { 
    //updating altitude 
    if (this.initi_alt < 0){
      throw new IllegalArgumentException("You have failed the mission!");
    }
      this.initi_alt = this.initi_alt - this.initi_vel;


    //updating velocity
      this.initi_vel = this.initi_vel + this.grav_accel;
      this.initi_vel = this.initi_vel - this.thrust_accel;


    //updating fuel 
    if (this.initi_fuel == 0) {
      throw new IllegalArgumentException("You are out of Fuel! ");
    }
    this.initi_fuel = this.initi_fuel - this.thrust_accel;

    // test thrust 
    this.thrust_accel = 0; 
  }
  // HW2: Write the code for this class

} // end of LunarLander class
