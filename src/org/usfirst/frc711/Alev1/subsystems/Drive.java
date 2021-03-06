// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc711.Alev1.subsystems;

import org.usfirst.frc711.Alev1.RobotMap;
import org.usfirst.frc711.Alev1.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Drive extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_TalonSRX talonSRX1 = RobotMap.driveTalonSRX1;
    private final WPI_TalonSRX talonSRX2 = RobotMap.driveTalonSRX2;
    private final WPI_TalonSRX talonSRX3 = RobotMap.driveTalonSRX3;
    private final SpeedControllerGroup left = RobotMap.driveLeft;
    private final WPI_TalonSRX talonSRX4 = RobotMap.driveTalonSRX4;
    private final WPI_TalonSRX talonSRX5 = RobotMap.driveTalonSRX5;
    private final WPI_TalonSRX talonSRX6 = RobotMap.driveTalonSRX6;
    private final SpeedControllerGroup right = RobotMap.driveRight;
    private final DoubleSolenoid doubleSolenoid = RobotMap.driveDoubleSolenoid;
    private final PIDController DrivepIDController1 = RobotMap.drivePIDController1;
    private final Encoder indexedEncoder1 = RobotMap.driveQuadratureEncoder1;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new DriveCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public int getLeftSpeed(){
    	return talonSRX1.getSensorCollection().getPulseWidthVelocity();
    }
    public int getRightSpeed(){
    	return talonSRX6.getSensorCollection().getPulseWidthVelocity();
    }
    public int getLeftPosition(){
    	return talonSRX1.getSensorCollection().getPulseWidthPosition();
    }
    public int getRightPosition(){
    	return talonSRX6.getSensorCollection().getPulseWidthPosition();
    }
    
    public void driveDistanceCount(int countGoalLeft, int countGoalRight){
    	int currentCountLeft = talonSRX1.getSensorCollection().getPulseWidthPosition();
    	int currentCountRight = talonSRX6.getSensorCollection().getPulseWidthPosition();
    	double leftVelocity = 0;
    	double rightVelocity = 0;
    	if (currentCountLeft < countGoalLeft)  {
    		leftVelocity = 0.3;
       	}
    	else if (currentCountLeft > countGoalLeft)  {
    		leftVelocity = 0;
       	}
     	if (currentCountRight > countGoalRight)  {
    		rightVelocity = 0.3;
       	}
    	else if (currentCountRight < countGoalRight)  {
    		rightVelocity = 0;
       	}
    	left.set(leftVelocity);
    	right.set(rightVelocity);
    	
    }
    
   
    
    public void takeJoystickInputs(Joystick joystick){
    	double xValue = joystick.getX(Joystick.Hand.kLeft);
    	double yValue = joystick.getY(Joystick.Hand.kRight);
    	final double deadbandThreshold = 0.1; 
    	if ((xValue < deadbandThreshold) & (xValue > 0)) {
    		xValue = 0;
    	}
    	else if ((xValue > -deadbandThreshold) & (xValue < 0)) {
    		xValue = 0;
    	}
    	else if (xValue > 0)
    	{
    		xValue = xValue - deadbandThreshold;
    	}
    	else if (xValue < 0)
    	{
    		xValue = xValue + deadbandThreshold;
    	}
    	if ((yValue < deadbandThreshold) & (yValue > 0)) {
    		yValue = 0;
    	}
    	else if ((yValue > -deadbandThreshold) & (yValue < 0)) {
    		yValue = 0;
    	}
    	else if (yValue > 0)
    	{
    		yValue = yValue - deadbandThreshold;
    	}
    	else if (yValue < 0)
    	{
    		yValue = yValue + deadbandThreshold;
    	}
    	left.set(xValue);
    	right.set(yValue);
    	
    }

    
    public void stop (){
    	left.set(0);
    	right.set(0);
    }
    
    public void shift (int shiftState){
    	if (shiftState == 0) {
    		doubleSolenoid.set(DoubleSolenoid.Value.kOff);
    	}
    	else if (shiftState == 1) {
    		doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    	}
    	else if (shiftState == 2) {
    		doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    	}
    
    }

}

