package frc.robot.commands.auto.AutoFunctions;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.WaitCommand;

import frc.robot.subsystems.DriveBase;


public class DriveStraight extends WaitCommand {
  // Encoder leftEncoder = new Encoder(4,5); 
  // Encoder rightEncoder = new Encoder(5);


  private final DriveBase driveSubsystem;

  double speed = 0;
  boolean isXAxis = true;

  public DriveStraight(DriveBase driveSubsystem, double time, double speed, boolean isXAxis) {
    super(time);
    this.driveSubsystem = driveSubsystem;
    this.speed = MathUtil.clamp(speed, -1, 1);
    this.isXAxis = isXAxis;
    addRequirements(this.driveSubsystem);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
      super.execute();
      if (this.isXAxis){
        driveSubsystem.drive(- speed, 0, 0);
      }
      else{
        driveSubsystem.drive(0, - speed, 0);

      }
  }

  @Override
  public void end(boolean interupted){
    super.end(interupted);
    driveSubsystem.drive(0,0,0);
  }
}
