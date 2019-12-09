package com.thoughtworks.service.impl;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.thoughtworks.service.impl.RoverOperation;
import com.thoughtworks.model.RoverPosition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@RunWith(JUnitPlatform.class)
@DisplayName("Rover operation testing")
public class RoverOperationTest {
	private static final Logger log = LogManager.getLogger(RoverOperationTest.class);
	private RoverOperation rover;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		log.info("@BeforeEach: setUp()");
		rover = new RoverOperation(5, 5);
	}

	@AfterEach
	public void tearDown() throws Exception {
		log.info("@AfterEach: tearDown()");
		rover = null;
	}
	
	
	@Test
	@DisplayName("Testing First input position.")
	public void findPositionTest1() {
		RoverPosition positionActual = rover.getPlateauPosition(1, 2, 'N', getOrdertoMove1());
		RoverPosition positionExpected = new RoverPosition(1,3,'N');
		log.info("Actual "+positionActual.toString());
		log.info("Expected "+positionExpected.toString());
		assertEquals(positionExpected.getX_coord(), positionActual.getX_coord(), "x coordinate");
		assertEquals(positionExpected.getY_coord(), positionActual.getY_coord(), "y coordinate");
		assertEquals(positionExpected.getFacing(), positionActual.getFacing(), "Facing");
	}
	
	@Test
	@DisplayName("Testing Second input position.")
	public void findPositionTest2() {
		log.info("Testing Second input position.");
		RoverPosition positionActual = rover.getPlateauPosition(3, 3, 'E', getOrdertoMove2());
		RoverPosition positionExpected = new RoverPosition(5,1,'E');
		assertEquals(positionExpected.getX_coord(), positionActual.getX_coord(), "x coordinate");
		assertEquals(positionExpected.getY_coord(), positionActual.getY_coord(), "y coordinate");
		assertEquals(positionExpected.getFacing(), positionActual.getFacing(), "Facing");
	}
	
	@Test
	@DisplayName("Provided wrong facing")
	public void invalit() {
		log.info("Testing Second input position.");
		assertThrows(IllegalArgumentException.class,() -> rover.getPlateauPosition(7, 3, 'T', getOrdertoMove2()), "Invalit facing");
	}
	
	@Test
	@DisplayName("Rover Moving Operation")
	public void moveRoverTest() {
		RoverPosition roverPostionActual = rover.getRoverMovie(1, 3, 'N');
		RoverPosition roverPositionExpected = new RoverPosition(1,4,'N');
		assertEquals(roverPositionExpected.getX_coord(), roverPostionActual.getX_coord(), "x coordinate");
		assertEquals(roverPositionExpected.getY_coord(), roverPostionActual.getY_coord(), "y coordinate");
		assertEquals(roverPositionExpected.getFacing(), roverPostionActual.getFacing(), "Facing");
		
	}
	
	public char[] getOrdertoMove1() {
		return "LMLMLMLMM".toCharArray();
	}
	
	public char[] getOrdertoMove2() {
		return "MMRMMRMRRM".toCharArray();
	}
}
