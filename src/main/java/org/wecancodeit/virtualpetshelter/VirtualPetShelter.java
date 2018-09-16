package org.wecancodeit.virtualpetshelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



public class VirtualPetShelter {
	String name;
	Map<String, VirtualPet> pets;
	
	public Collection<VirtualPet> getAllPets() {
		return pets.values();
	}
	
	public String getName() {
		return name;
		
	}
	
	public VirtualPetShelter(String name) {
		this.name = name;
		pets = new HashMap<String, VirtualPet>();
	}

	public void addPet(String name, String description, int hungerLevel, int thirstLevel, int sleepinessLevel, int boredomLevel) {
		VirtualPet pet = new VirtualPet(name, description, hungerLevel, thirstLevel, sleepinessLevel, boredomLevel);
		pets.put(name,  pet);
		
	}
	
	public void addPet(String name, String description) {
		VirtualPet pet = new VirtualPet(name, description);
		pets.put(name,  pet);
		
	}

	public void removePet(String name) {
		pets.remove(name);
	}
	
	public VirtualPet getPet(String name) {
		return pets.get(name);
	}

	public void feedAllPets(int userSelectedFood) {
		Collection<VirtualPet> petsCollection = pets.values();
		for (VirtualPet pet : petsCollection) {
			pet.feed(userSelectedFood);
		}
	}
	
	public void waterAllPets() {
		Collection<VirtualPet> petsCollection = pets.values();
		for (VirtualPet pet : petsCollection) {
			pet.water();
		}
	}

	public void playWithPet(String name) {
		pets.get(name).playWith();
	}

	public void movePet(String name) {
		pets.get(name).move();
	}

	public void tickAll() {
		Collection<VirtualPet> petsCollection = pets.values();
		for (VirtualPet pet : petsCollection) {
			if (pet.getIsAsleep()) {
				pet.wake();
			}
			pet.tick();
		}
		
	}
	
	public void printStats() {
		String statsString = String.format("%-10s%-10s%-10s%-10s%-12s%-10s%-10s%n", "Name", "|Hunger", "|Thirst", "|Boredom", "|Sleepiness", "|Location", "|State" );
		statsString += String.format("%-10s%-10s%-10s%-10s%-12s%-10s%-10s%n", "----------", "|---------", "|---------", "|---------", "|-----------", "|---------", "|---------" );

		Collection<VirtualPet> petsCollection = pets.values();
		String formatString = "";
		String contentString = "";
			for (VirtualPet pet : petsCollection) {
				
				
				
				System.out.format("%-10s%-10s%-10s%-10s%-12s", pet.getName(), "|" + pet.getHungerLevel(), "|" + pet.getThirstLevel(),"|" + pet.getBoredomLevel(), "|" + pet.getSleepinessLevel());
				
				if (pet.getIsInPasture()) {
					System.out.format("%-10s", "|Pasture");
				} else {
					System.out.format("%-10s", "|Barn");
				}
				if (pet.getIsAsleep()) {
					System.out.format("%-10s%n", "|Asleep");

				} else {
					System.out.format("%-10s%n", "|Awake");

				}
					
			}

	}
	
	public String printNamesAndDescriptions() {
		Collection<VirtualPet> petsCollection = pets.values();
		String petsString = "";
		for (VirtualPet pet : petsCollection) {
			petsString += String.format("%-10s%-50s%n", pet.getName(), "|" + pet.getDescription());
		}
		return petsString;
	}

	public boolean hasPet(String name) {
		VirtualPet pet = pets.get(name);
		boolean hasPet;
	 	if (pet == null) {
			hasPet = false;
		}
		else {
			hasPet = true;
		}
		
		return hasPet;
		
	}
}
