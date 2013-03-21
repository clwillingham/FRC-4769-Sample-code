package com.electrodes.sample;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;

public class Main extends IterativeRobot {
    
    MightyOne robot = new MightyOne();
    XBoxJoystick xbox = new XBoxJoystick(1);
    
    public void robotInit() {
        //initialize robot (before game start)
    }
    
    public void autonomousInit(){
        //autonomous code
        robot.setShooter(1);
        Timer.delay(5);
        robot.fireFrisbee(); //yes a loop makes more sense but i'm being lazy :P
        robot.fireFrisbee();
        robot.fireFrisbee();
    }
    
    public void teleopPeriodic() {
        //teleop loop (called over and over until game ends)
        robot.leftDrive.set(calcLeftMotor());
        robot.rightDrive.set(calcRightMotor());
    }
    
     private double calcLeftMotor() {
            double z = xbox.getZ();
            if (z != 0.0) {
                    return z;
            }
            double x = xbox.getRightX();
            double y = xbox.getLeftY();
            if (x < 0) {
                    return y * (1 + x);
            } else {
                    return y;
            }
    }

    private double calcRightMotor() {
            double z = xbox.getZ();
            if (z != 0.0) {
                    return -z;
            }
            double x = xbox.getRightX();
            double y = xbox.getLeftY();
            if (x > 0) {
                    return y * (1 - x);
            } else {
                    return y;
            }
    }
    
}
