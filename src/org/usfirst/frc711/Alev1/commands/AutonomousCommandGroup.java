package org.usfirst.frc711.Alev1.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommandGroup extends CommandGroup {
	public AutonomousCommandGroup() {
		addSequential(new DriveForwardCommand(100));
		addSequential(new StopCommand());
	}

}
