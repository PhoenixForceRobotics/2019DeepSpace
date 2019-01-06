package frc.controllers;
/*
This code is sourced from Team 319.  They offered up use of code in Chief Delphi
forums.  The repo this was extracted from is https://github.com/team2097/BobBuilder.

There is no obvious license file but want to retain pointers to them.

 */
import frc.controllers.BobXboxController.XboxAxis;

import edu.wpi.first.wpilibj.Joystick;

public class BobTriggers {
	Joystick controller;

	public BobTriggers(Joystick controller) {
		this.controller = controller;
	}

	public double getLeft() {
		return this.controller.getRawAxis(XboxAxis.LEFT_TRIGGER.value);
	}

	public double getRight() {
		return this.controller.getRawAxis(XboxAxis.RIGHT_TRIGGER.value);
	}

	public double getTwist() {
		return -getLeft() + getRight();
	}
}
