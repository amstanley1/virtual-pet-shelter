package org.wecancodeit.virtualpetshelter;

import java.util.Scanner;




public class VirtualPetShelterApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Emboldened by your recent success in taking care of a stray horse,"
				+ " you decide to help other horses in need by starting a horse shelter.");
		System.out.println("What will you name your horse shelter?");
		String name = input.nextLine();
		VirtualPetShelter horseShelter = new VirtualPetShelter(name);
		System.out.println("Welcome to " + horseShelter.getName());
		int userSelection = 0;
		while (userSelection != 8) {
			
			//Print all the horses' stats
			System.out.println();
			System.out.println("Stats for your horses:");
			System.out.println(horseShelter.printStats());
			System.out.println();
			
			//List options and ask user to select one
			System.out.println("1. Take in a new horse");
			System.out.println("2. Adopt out a horse");
			System.out.println("3. Feed the horses");
			System.out.println("4. Water the horses");
			System.out.println("5. Play with a horse");
			System.out.println("6. Move a horse to the barn or pasture.");
			System.out.println("7. Do nothing.");
			System.out.println("8. Quit the game.");
			System.out.println("What number do you want to select?");
			userSelection = input.nextInt();
			input.nextLine();
			
			//Take action depending on user selected option
			if (userSelection == 1) {
				System.out.println("Enter the new horse's name");
				String newHorseName = input.nextLine();
				System.out.println("Enter a description for the new horse");
				String newHorseDescription = input.nextLine();
				horseShelter.addPet(newHorseName, newHorseDescription);
				System.out.println(newHorseName + " is now part of the shelter.");
				System.out.println("Press enter to continue");
				input.nextLine();
			} else if (userSelection == 2) {
				System.out.println(horseShelter.printNamesAndDescriptions());
				System.out.println("Enter the name of the horse that will be adopted out.");
				String horseToBeAdoptedOut = input.nextLine();
				if (horseShelter.hasPet(horseToBeAdoptedOut)) {
					horseShelter.removePet(horseToBeAdoptedOut);
					System.out.println(horseToBeAdoptedOut + " has been adopted.");
				} else {
					System.out.println("That horse is not in the shelter.");
				}
				
				System.out.println("Press enter to continue");
				input.nextLine();
			} else if (userSelection == 3) {
				System.out.println("1. Apples");
				System.out.println("2. Carrots");
				System.out.println("3. Hay");
				System.out.println("What number would you like to select?");
				int userSelectedFood = input.nextInt();
				input.nextLine();
				horseShelter.feedAllPets(userSelectedFood);
				System.out.println("You fed the horses");
				if (userSelectedFood == 1) {
					System.out.println("They ate all the apples.");
				} else if (userSelectedFood == 2) {
					System.out.println("They ate some of the carrots.");
				} else if (userSelectedFood == 3) {
					System.out.println("They ate a little bit of the hay.");
				}
				System.out.println("Press enter to continue");
				input.nextLine();

			} else if (userSelection == 4) {
				horseShelter.waterAllPets();
				System.out.println("You've watered all the horses.");
				System.out.println("Press enter to continue");
				input.nextLine();
			}
			else if (userSelection == 5) {
				System.out.println(horseShelter.printNamesAndDescriptions());
				System.out.println("Enter the name of the horse you'd like to play with.");
				String horseToPlayWith = input.nextLine();
				if (horseShelter.hasPet(horseToPlayWith)) {
					horseShelter.playWithPet(horseToPlayWith);
					System.out.println("You played with " + horseToPlayWith + ". " + horseToPlayWith + " is less bored now, but more tired." );
				} else {
					System.out.println("That horse is not in the shelter.");
				}
				
				System.out.println("Press enter to continue");
				input.nextLine();
			} else if (userSelection == 6) {
				System.out.println(horseShelter.printNamesAndDescriptions());
				System.out.println("Enter the name of the horse you'd like to move.");
				String horseToMove = input.nextLine();
				if (horseShelter.hasPet(horseToMove)) {
					if (horseShelter.getPet(horseToMove).getIsInPasture()) {
						System.out.println("You put " + horseToMove + " in the barn.");
						horseShelter.movePet(horseToMove);
					} else {
						System.out.println("You put " + horseToMove + " in the pasture.");
						horseShelter.movePet(horseToMove);
					}
				} else {
					System.out.println("That horse is not in the shelter.");
				}
				System.out.println("Press enter to continue");
				input.nextLine();
			}
			
			//call tick method to pass time in the game
			horseShelter.tickAll();

		}
		
		System.out.println("You have quit the game. Goodbye.");
		
		input.close();
	}
}
