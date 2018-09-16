package org.wecancodeit.virtualpetshelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



public class VirtualPetShelter {
	String name;
	Map<String, VirtualPet> pets;
	
	//Accessors
	public Collection<VirtualPet> getAllPets() {
		return pets.values();
	}
	
	public String getName() {
		return name;
		
	}
	
	public VirtualPet getPet(String name) {
		return pets.get(name);
	}
	
	//Constructor
	public VirtualPetShelter(String name) {
		this.name = name;
		pets = new HashMap<String, VirtualPet>();
	}
	
	//Add pet
	public void addPet(String name, String description, int hungerLevel, int thirstLevel, int sleepinessLevel, int boredomLevel) {
		VirtualPet pet = new VirtualPet(name, description, hungerLevel, thirstLevel, sleepinessLevel, boredomLevel);
		pets.put(name,  pet);
		
	}
	
	public void addPet(String name, String description) {
		VirtualPet pet = new VirtualPet(name, description);
		pets.put(name,  pet);
		
	}
	
	//Remove pet
	public void removePet(String name) {
		pets.remove(name);
	}
	
	
	//feed all pets
		public void feedAllPets(int userSelectedFood) {
		Collection<VirtualPet> petsCollection = pets.values();
		for (VirtualPet pet : petsCollection) {
			pet.feed(userSelectedFood);
		}
	}
	
	//water all pets
	public void waterAllPets() {
		Collection<VirtualPet> petsCollection = pets.values();
		for (VirtualPet pet : petsCollection) {
			pet.water();
		}
	}
	
	//Play with specific pet
	public void playWithPet(String name) {
		pets.get(name).playWith();
	}
	
	//Move pet to barn or pasture
	public void movePet(String name) {
		pets.get(name).move();
	}

	//call tick on all pets to move time in game
	public void tickAll() {
		Collection<VirtualPet> petsCollection = pets.values();
		for (VirtualPet pet : petsCollection) {
			if (pet.getIsAsleep()) {
				pet.wake();
			}
			pet.tick();
		}
		
	}
	
	//Return stats for each pet as a formatted String
	public String printStats() {
		String statsString = String.format("%-10s%-10s%-10s%-10s%-12s%-10s%-10s%n", "Name", "|Hunger", "|Thirst", "|Boredom", "|Sleepiness", "|Location", "|State" );
		statsString += String.format("%-10s%-10s%-10s%-10s%-12s%-10s%-10s%n", "----------", "|---------", "|---------", "|---------", "|-----------", "|---------", "|---------" );

		Collection<VirtualPet> petsCollection = pets.values();
			for (VirtualPet pet : petsCollection) {
				statsString += String.format("%-10s%-10s%-10s%-10s%-12s", pet.getName(), "|" + pet.getHungerLevel(), "|" + pet.getThirstLevel(),"|" + pet.getBoredomLevel(), "|" + pet.getSleepinessLevel());
				
				if (pet.getIsInPasture()) {
					statsString += String.format("%-10s", "|Pasture");
				} else {
					statsString += String.format("%-10s", "|Barn");
				}
				if (pet.getIsAsleep()) {
					statsString += String.format("%-10s%n", "|Asleep");

				} else {
					statsString += String.format("%-10s%n", "|Awake");

				}
					
			}
			return statsString;
	}
	
	//Return name and description for each pet as formatted String
	public String printNamesAndDescriptions() {
		Collection<VirtualPet> petsCollection = pets.values();
		String petsString = String.format("%-10s%-50s%n", "Name", "Description");
		for (VirtualPet pet : petsCollection) {
			petsString += String.format("%-10s%-50s%n", pet.getName(), "|" + pet.getDescription());
		}
		return petsString;
	}
	
	//Check of Map has specific pet
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
