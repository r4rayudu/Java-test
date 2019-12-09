package com.thoughtworks.model;

public class RoverPosition {
	Integer x_coord, y_coord;
	char facing;

	public RoverPosition(Integer x_coord, Integer y_coord, char facing) {
		this.x_coord = x_coord;
		this.y_coord = y_coord;
		this.facing = facing;
	}

	public Integer getX_coord() {
		return x_coord;
	}

	public void setX_coord(Integer y_coord) {
		this.x_coord = y_coord;
	}

	public Integer getY_coord() {
		return y_coord;
	}

	public void setY_coord(Integer y_coord) {
		this.y_coord = y_coord;
	}

	public char getFacing() {
		return facing;
	}

	public void setFacing(char facing) {
		this.facing = facing;
	}

	@Override
	public String toString() {
		return "Position [x_coord=" + x_coord + ", y_coord=" + y_coord + ", facing=" + facing + "]";
	}
	
}