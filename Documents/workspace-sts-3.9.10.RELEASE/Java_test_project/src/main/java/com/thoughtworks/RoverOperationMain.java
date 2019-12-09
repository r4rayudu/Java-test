package com.thoughtworks;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.thoughtworks.service.impl.RoverOperation;
import com.thoughtworks.model.RoverPosition;

public class RoverOperationMain {
	private static Logger logger = LogManager.getLogger(RoverOperationMain.class);

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			logger.info("Enter x and y coordinates of the plateau.");
			Integer roverXend = scanner.nextInt();
			Integer roverYend = scanner.nextInt();
			logger.info(roverXend + " " + roverYend);
			RoverOperation roverOperation = new RoverOperation(roverXend, roverYend);

			logger.info("Enter x and y coordinates of the Rover position and facing Direction.");
			Integer x_coord = scanner.nextInt();
			Integer y_coord = scanner.nextInt();
			char facing = scanner.next().charAt(0);

			logger.info("Enter Rover moving operation control");
			char fistControl[] = scanner.next().toCharArray();
			RoverPosition plateauPosition = roverOperation.getPlateauPosition(x_coord, y_coord, facing, fistControl);
			logger.info(plateauPosition.getX_coord() + " " + plateauPosition.getY_coord() + " "
					+ plateauPosition.getFacing());
		} catch (InputMismatchException exception) {
			logger.error("Invalidate input please enter Integer value: " + exception);
		} catch (IllegalArgumentException exception) {
			logger.error("Invalidate input please enter correct facing and control commend"+exception);
		}
		finally {
			scanner.close();
		}

	}
}
