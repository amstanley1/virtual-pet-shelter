package org.wecancodeit.virtualpetshelter;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetTest {

	VirtualPet pet;

	@Before
	public void setup() {
		pet = new VirtualPet("Horace", "A hippo", 8, 4, 7, 5);
	}

	@Test
	public void shouldBeAbleToCreateNewVirtualPet() {
		VirtualPet pet = new VirtualPet("Crookshanks", "a cat");
	}

	@Test
	public void shouldBeAbleToGetHungerLevel() {
		int hungerLevel = pet.getHungerLevel();
		assertTrue(hungerLevel == 8);
	}

	@Test
	public void shouldBeAbleToGetSleepinessLevel() {
		int sleepinessLevel = pet.getSleepinessLevel();
		assertTrue(sleepinessLevel == 7);
	}

	@Test
	public void shouldBeAbleToFeedPet() {

		int originalHungerLevel = pet.getHungerLevel();
		pet.feed(1);
		assertTrue((originalHungerLevel - 5) == (pet.getHungerLevel()));
	}

	@Test
	public void shouldBeAbleToGetBoredomLevel() {
		int boredomLevel = pet.getBoredomLevel();
		assertTrue(boredomLevel == 5);
	}

	@Test
	public void shouldBeAbleToPlayWithPet() {
		int originalBoredomLevel = pet.getBoredomLevel();
		pet.playWith();
		assertTrue(originalBoredomLevel - 3 == pet.getBoredomLevel());
	}

	@Test
	public void shouldBeAbleToMovePet() {
		int originalBoredomLevel = pet.getBoredomLevel();
		pet.move();
		assertTrue(originalBoredomLevel - 3 == pet.getBoredomLevel());
	}

	@Test
	public void tickMethodShouldIncrementAndDecrementProperties() {
		int originalBoredomLevel = pet.getBoredomLevel();
		int originalThirstLevel = pet.getThirstLevel();
		int originalHungerLevel = pet.getHungerLevel();
		int originalSleepinessLevel = pet.getSleepinessLevel();
		pet.tick();
		assertTrue(originalBoredomLevel + 1 == pet.getBoredomLevel());
		assertTrue(originalThirstLevel + 1 == pet.getThirstLevel());
		assertTrue(originalHungerLevel + 1 == pet.getHungerLevel());
		assertTrue(originalSleepinessLevel + 1 == pet.getSleepinessLevel());
	}

	@Test
	public void shouldBeAbleToGetName() {
		String name = pet.getName();
		assertTrue(name.equals("Horace"));
	}

	@Test
	public void shouldBeAbleToGetDescription() {
		String name = pet.getDescription();
		assertTrue(name.equals("A hippo"));
	}

	@Test
	public void shouldBeAbleToGetThirstLevel() {
		int thirstLevel = pet.getThirstLevel();
		assertTrue(thirstLevel == 4);
	}

	@Test
	public void shouldBeAbleToWaterPet() {
		int originalThirstLevel = pet.getThirstLevel();
		pet.water();
		assertTrue(originalThirstLevel - 4 == pet.getThirstLevel());
	}
}
