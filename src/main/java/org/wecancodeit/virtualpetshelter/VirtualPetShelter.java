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
			pet.tick();
		}
		
	}
	
	public String printStats() {
		System.out.println("Name     |Hunger |Thirst |Boredom |Sleepiness");
		System.out.println("---------|-------|-------|--------|----------");
		Collection<VirtualPet> petsCollection = pets.values();
		for (VirtualPet pet : petsCollection) {
			System.out.println("     |Hunger |Thirst |Boredom |Sleepiness");
		}
		return "";
	}
}
