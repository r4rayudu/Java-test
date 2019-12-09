package com.thoughtworks.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.thoughtworks.model.RoverPosition;

public class RoverOperation {
	private Logger logger = LogManager.getLogger(getClass());
	private int roverXend, roverYend;
	public static final char NORTH = 'N';
	public static final char SOUTH = 'S';
	public static final char EAST = 'E';
	public static final char WEST = 'W';
	public static final char LEFT = 'L';
	public static final char RIGHT = 'R';
	public static final char MOVE = 'M';
	
	public RoverOperation(int roverXend, int roverYend) {
		this.roverXend = roverXend;
		this.roverYend = roverYend;
	}

	public RoverPosition getPlateauPosition(Integer x_coord, Integer y_coord, char facing, char control[]) {
		if (!Character.toString(facing).matches("^[NSEW]*$")) {
			logger.error("Invalid Facing");
	         throw new IllegalArgumentException("Invalid Facing");
	    }
		RoverPosition plateauPosition;
		plateauPosition = new RoverPosition(x_coord, y_coord, facing);
		for (int i = 0; i < control.length; i++) {
			if (!Character.toString(facing).matches("^[LRM]*$")) {
				logger.error("Invalid control commend");
		        throw new IllegalArgumentException("Invalid control commend");
		    }
			if (plateauPosition.getFacing() == NORTH && control[i] == LEFT) {
				plateauPosition.setFacing(WEST);
			}

			else if (plateauPosition.getFacing() == WEST && control[i] == LEFT) {
				plateauPosition.setFacing(SOUTH);
			}

			else if (plateauPosition.getFacing() == SOUTH && control[i] == LEFT) {
				plateauPosition.setFacing(EAST);
			}

			else if (plateauPosition.getFacing() == EAST && control[i] == LEFT) {
				plateauPosition.setFacing(NORTH);
			}

			else if (plateauPosition.getFacing() == NORTH && control[i] == RIGHT) {
				plateauPosition.setFacing(EAST);
			}

			else if (plateauPosition.getFacing() == EAST && control[i] == RIGHT) {
				plateauPosition.setFacing(SOUTH);
			}

			else if (plateauPosition.getFacing() == SOUTH && control[i] == RIGHT) {
				plateauPosition.setFacing(WEST);
			}

			else if (plateauPosition.getFacing() == WEST && control[i] == RIGHT) {
				plateauPosition.setFacing(NORTH);
			}
			if (control[i] == MOVE) {
				plateauPosition = getRoverMovie(plateauPosition.getX_coord(), plateauPosition.getY_coord(), plateauPosition.getFacing());
			}
		}
		return plateauPosition;
	}

	RoverPosition getRoverMovie(Integer x_coord, Integer y_coord, char facing) {
		if (facing == NORTH && y_coord < roverYend) {
			y_coord++;
		} else if (facing == SOUTH && y_coord > 0 ) {
			y_coord--;
		} else if (facing == EAST && x_coord < roverXend) {
			x_coord++;
		} else if (facing == WEST && x_coord > 0) {
			x_coord--;
		}
		return new RoverPosition(x_coord, y_coord, facing);
	}

}
