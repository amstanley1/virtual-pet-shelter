package org.wecancodeit.virtualpetshelter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class VirtualPetShelterTest {
	VirtualPetShelter petShelter;
	
	@Before
	public void setup() {
		petShelter = new VirtualPetShelter("My Test Pet Shelter");
	}
	
	@Test
	public void shouldBeAbleToCreateNewPetShelter() {
		VirtualPetShelter shelter = new VirtualPetShelter("My Test Pet Shelter");
	}
	
	@Test
	public void shouldBeAbleToGetAllPets() {
		Collection<VirtualPet> petsList = petShelter.getAllPets();
		assertTrue(petsList.isEmpty());
	}
	
	@Test
	public void shouldBeAbleToGetName() {
		assertTrue(petShelter.getName().equals("My Test Pet Shelter"));
	}
	
	@Test
	public void shouldBeAbleToAddPetToVirtualPetShelter() {
		petShelter.addPet("Horace", "A hippo", 5, 4, 6, 7);
		petShelter.addPet("Helga", "A horse", 4, 5, 3, 8);
		boolean containsPet = false;
		for (VirtualPet pet : petShelter.getAllPets()) {
			if (pet.getName().equals("Helga")) {
				containsPet = true;
			} 
		}
		assertTrue(containsPet);
	}
	
	@Test
	public void shouldBeAbleToRemovePet() {
		petShelter.addPet("Horace", "A hippo", 5, 4, 6, 7);
		petShelter.addPet("Helga", "A horse", 4, 5, 3, 8);
		petShelter.removePet("Helga");
		boolean containsPet = false;
		for (VirtualPet pet : petShelter.getAllPets()) {
			if (pet.getName().equals("Helga")) {
				containsPet = true;
			} 
		}
		assertFalse(containsPet);
	}
	
	@Test
	public void shouldBeAbleToGetPet() {
		petShelter.addPet("Horace", "A hippo", 5, 4, 6, 7);
		petShelter.addPet("Helga", "A horse", 4, 5, 3, 8);
		VirtualPet helga = petShelter.getPet("Helga");
		boolean containsPet = false;
		assertTrue(helga.getName().equals("Helga"));
	}
	
	@Test
	public void shouldBeAbleToFeedAllPets() {
		petShelter.addPet("Horace", "A hippo", 5, 4, 6, 7);
		petShelter.addPet("Helga", "A horse", 4, 5, 3, 8);
		int horaceHungerLevelBefore = petShelter.getPet("Horace").getHungerLevel();
		int helgaHungerLevelBefore = petShelter.getPet("Helga").getHungerLevel();
		petShelter.feedAllPets(2);
		int horaceHungerLevelAfter = petShelter.getPet("Horace").getHungerLevel();
		int helgaHungerLevelAfter = petShelter.getPet("Helga").getHungerLevel();
		assertTrue(helgaHungerLevelAfter == helgaHungerLevelBefore - 3);
		assertTrue(horaceHungerLevelAfter == horaceHungerLevelBefore - 3);		
	}
	
	@Test
	public void shouldBeAbleToWaterAllPets() {
		petShelter.addPet("Horace", "A hippo", 5, 4, 6, 7);
		petShelter.addPet("Helga", "A horse", 4, 5, 3, 8);
		int horaceThirstLevelBefore = petShelter.getPet("Horace").getThirstLevel();
		int helgaThirstLevelBefore = petShelter.getPet("Helga").getThirstLevel();
		petShelter.waterAllPets();
		int horaceThirstLevelAfter = petShelter.getPet("Horace").getThirstLevel();
		int helgaThirstLevelAfter = petShelter.getPet("Helga").getThirstLevel();
		assertTrue(helgaThirstLevelAfter == helgaThirstLevelBefore - 4);
		assertTrue(horaceThirstLevelAfter == horaceThirstLevelBefore - 4);		
	}
	
	@Test
	public void shouldBeAbleToPlayWithPet() {
		petShelter.addPet("Horace", "A hippo", 5, 4, 6, 7);
		petShelter.addPet("Helga", "A horse", 4, 5, 3, 8);
		int horaceBoredomLevelBefore = petShelter.getPet("Horace").getBoredomLevel();
		int horaceSleepinessLevelBefore = petShelter.getPet("Horace").getSleepinessLevel();
		petShelter.playWithPet("Horace");
		int horaceBoredomLevelAfter = petShelter.getPet("Horace").getBoredomLevel();
		int horaceSleepinessLevelAfter = petShelter.getPet("Horace").getSleepinessLevel();
		assertTrue(horaceBoredomLevelAfter == horaceBoredomLevelBefore - 3);
		assertTrue(horaceSleepinessLevelAfter == horaceSleepinessLevelBefore + 2);	
	}
	
	@Test
	public void shouldBeAbleToMovePet() {
		petShelter.addPet("Horace", "A hippo", 5, 4, 6, 7);
		petShelter.addPet("Helga", "A horse", 4, 5, 3, 8);
		int helgaBoredomLevelBefore = petShelter.getPet("Helga").getBoredomLevel();
		petShelter.movePet("Helga");
		int helgaBoredomLevelAfter = petShelter.getPet("Helga").getBoredomLevel();
		assertTrue(helgaBoredomLevelAfter == helgaBoredomLevelBefore - 3);
	}
	
	@Test
	public void tickMethodShouldIncrementAndDecrementPropertiesForAllPets() {
		petShelter.addPet("Horace", "A hippo", 5, 4, 6, 7);
		petShelter.addPet("Helga", "A horse", 4, 5, 3, 8);
		int horaceBoredomLevelBefore = petShelter.getPet("Horace").getBoredomLevel();
		int horaceSleepinessLevelBefore = petShelter.getPet("Horace").getSleepinessLevel();
		int horaceHungerLevelBefore = petShelter.getPet("Horace").getHungerLevel();
		int horaceThirstLevelBefore = petShelter.getPet("Horace").getThirstLevel();
		int helgaBoredomLevelBefore = petShelter.getPet("Helga").getBoredomLevel();
		int helgaSleepinessLevelBefore = petShelter.getPet("Helga").getSleepinessLevel();
		int helgaThirstLevelBefore = petShelter.getPet("Helga").getHungerLevel();
		int helgaHungerLevelBefore = petShelter.getPet("Helga").getThirstLevel();
		petShelter.tickAll();
		int horaceBoredomLevelAfter = petShelter.getPet("Horace").getBoredomLevel();
		int horaceSleepinessLevelAfter = petShelter.getPet("Horace").getSleepinessLevel();
		int horaceHungerLevelAfter = petShelter.getPet("Horace").getHungerLevel();
		int horaceThirstLevelAfter = petShelter.getPet("Horace").getThirstLevel();
		int helgaBoredomLevelAfter = petShelter.getPet("Helga").getBoredomLevel();
		int helgaSleepinessLevelAfter = petShelter.getPet("Helga").getSleepinessLevel();
		int helgaThirstLevelAfter = petShelter.getPet("Helga").getHungerLevel();
		int helgaHungerLevelAfter = petShelter.getPet("Helga").getThirstLevel();
		assertTrue(horaceBoredomLevelAfter == horaceBoredomLevelBefore + 1);
		assertTrue(horaceSleepinessLevelAfter == horaceSleepinessLevelBefore + 1);
		assertTrue(horaceThirstLevelAfter == horaceThirstLevelBefore + 1);
		assertTrue(horaceHungerLevelAfter == horaceHungerLevelBefore + 1);
		assertTrue(helgaBoredomLevelAfter == helgaBoredomLevelBefore + 1);
		assertTrue(helgaSleepinessLevelAfter == helgaSleepinessLevelBefore + 1);
		assertTrue(helgaThirstLevelAfter == helgaThirstLevelBefore + 1);
		assertTrue(helgaHungerLevelAfter == helgaHungerLevelBefore + 1);
	}
	
	public void shouldBeAbleToCheckIfHasPet() {
		petShelter.addPet("Horace", "A hippo", 5, 4, 6, 7);
		petShelter.addPet("Helga", "A horse", 4, 5, 3, 8);
		assertTrue(petShelter.hasPet("Horace"));
		assertFalse(petShelter.hasPet("Holly"));
	}
	

}
