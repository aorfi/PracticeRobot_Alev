// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc711.Alev1.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc711.Alev1.Robot;

/**
 *
 */
public class DriveForwardCommand extends Command {
	private int m_targetdelta;
	private int m_targetL; 
	private int m_targetR; 

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public DriveForwardCommand(int targetdelta) {
    	m_targetdelta = targetdelta;
    	
    	

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	m_targetL = (Robot.drive.getLeftPosition() + m_targetdelta);
    	m_targetR = (Robot.drive.getRightPosition() - m_targetdelta);
    }
    	

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	System.out.println("delta" + m_targetdelta);
    	System.out.println("targetL"+m_targetL);
    	System.out.println("targetR"+m_targetR);
    	Robot.drive.driveDistanceCount( m_targetL, m_targetR);
    }
    
    

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	if ((Robot.drive.getLeftPosition() > m_targetL) & (Robot.drive.getRightPosition() > m_targetR)){
    		return true;
    	}
        return false;
    }
    	

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	new StopCommand().start();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
