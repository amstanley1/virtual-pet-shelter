package org.wecancodeit.virtualpetshelter;

public class VirtualPet {

	// Fields for name, description, hunger level, sleepiness level, boredom level,
	// state of sleep, and location
	private String name;
	private String description;
	private int hungerLevel;
	private int sleepinessLevel;
	private int boredomLevel;
	private int thirstLevel;
	private boolean isAsleep;
	private boolean isInPasture;
	private boolean hasRunAway;

	// Getters
	public boolean getIsAsleep() {
		return isAsleep;
	}

	public boolean getIsInPasture() {
		return isInPasture;
	}

	public boolean getHasRunAway() {
		return hasRunAway;
	}

	public int getHungerLevel() {
		return hungerLevel;
	}

	public int getSleepinessLevel() {
		return sleepinessLevel;
	}

	public int getBoredomLevel() {
		return boredomLevel;
	}

	public int getThirstLevel() {
		return thirstLevel;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	// Constructors
	public VirtualPet(String name, String description, int hungerLevel, int thirstLevel, int sleepinessLevel,
			int boredomLevel) {
		this.name = name;
		this.description = description;
		this.hungerLevel = hungerLevel;
		this.sleepinessLevel = sleepinessLevel;
		this.boredomLevel = boredomLevel;
		this.thirstLevel = thirstLevel;
	}

	public VirtualPet(String name, String description) {
		this(name, description, 5, 5, 5, 5);
	}

	// Feed Pet, lowers hunger level depending on user selected food number
	public void feed(int userSelectedFood) {
		switch (userSelectedFood) {
		case 1:
			if (hungerLevel < 5) {
				hungerLevel = 0;
			} else {
				hungerLevel -= 5;
			}
			break;
		case 2:
			if (hungerLevel < 3) {
				hungerLevel = 0;
			} else {
				hungerLevel -= 3;
			}
			break;
		case 3:
			if (hungerLevel < 1) {
				hungerLevel = 0;
			} else {
				hungerLevel -= 1;
			}
			break;
		}
	}

	// Give pet water
	public void water() {
		thirstLevel -= 4;
	}

	// Play with pet, lowers boredom level
	public void playWith() {
		if (boredomLevel < 3) {
			boredomLevel = 0;
		} else {
			boredomLevel -= 3;
		}
		if (sleepinessLevel > 8) {
			sleepinessLevel = 10;
		} else {
			sleepinessLevel += 2;
		}
	}

	// move pet to pasture if in barn, or to barn if in pasture by toggling the
	// boolean isInPasture property
	public void move() {
		if (isInPasture) {
			isInPasture = false;
			if (boredomLevel > 8) {
				boredomLevel = 10;
			} else {
				boredomLevel += 2;
			}
		} else {
			if (boredomLevel < 3) {
				boredomLevel = 0;
			} else {
				boredomLevel -= 3;
			}
			isInPasture = true;
		}
	}

	// makes time pass, raises pet's needs, if pet sleepiness level is above 8 it
	// will
	// go to sleep, if it's hunger level is above 8, it will run away.
	public void tick() {
		if (hungerLevel < 10) {
			hungerLevel++;
		}
		if (thirstLevel < 10) {
			thirstLevel++;
		}
		if (boredomLevel < 10) {
			boredomLevel++;
		}
		sleepinessLevel++;
		if (sleepinessLevel > 8) {
			this.sleep();
		}
	}

	// sleep method, lowers sleepiness level, sets boolean isAsleep
	// to true
	public void sleep() {
		sleepinessLevel -= 5;
		isAsleep = true;
	}

	// wake method, sets boolean isAsleep to false
	public void wake() {
		isAsleep = false;
	}
}
