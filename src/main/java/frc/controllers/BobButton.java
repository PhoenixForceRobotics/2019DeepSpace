package frc.controllers;
/*
This code is sourced from Team 319.  They offered up use of code in Chief Delphi
forums.  The repo this was extracted from is https://github.com/team2097/BobBuilder.

There is no obvious license file but want to retain pointers to them.

 */
import frc.controllers.BobXboxController.XboxButton;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class BobButton extends JoystickButton {

	public BobButton(GenericHID joystick, int buttonNumber) {
		super(joystick, buttonNumber);
	}

	public BobButton(XboxController joystick, XboxButton button) {
		super(joystick, button.value);
	}

	public BobButton(BobXboxController joystick, XboxButton button) {
		super(joystick, button.value);
	}

}
