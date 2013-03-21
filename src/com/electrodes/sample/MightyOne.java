/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.electrodes.sample;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author Chris
 */
public class MightyOne {
    public Victor leftDrive = new Victor(1);
    public Victor rightDrive = new Victor(2);
    public Victor shooter1 = new Victor(3);
    public Victor shooter2 = new Victor(4);
    public Servo feederServo = new Servo(5);
    
    private float shooterPower = 0;
    
    public void setShooter(float power){
        shooterPower = power;
        shooter1.set(power);
        shooter2.set(power);
    }
    
    public void fireFrisbee(){
        feederServo.set(1);
        Timer.delay(1);
        feederServo.set(0);
        Timer.delay(1);
    }
}
