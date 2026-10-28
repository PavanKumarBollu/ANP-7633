
package org.anudip.service;

import org.anudip.model.Trainer;

public class TrainerService {

    private final Trainer[] trainers;
    private int trainerCount;

    public TrainerService(int capacity) {
        trainers = new Trainer[capacity];
        trainerCount = 0;
    }

    public int getTrainerCount() {
        return trainerCount;
    }

    // Get a trainer using its position in the array
    public Trainer getTrainerAt(int index) {
        if (index < 0 || index >= trainerCount) {
            return null;
        }
        return trainers[index];
    }

    public boolean registerTrainer(Trainer trainer) {

        if (trainer == null) {
            return false;
        }

        if (trainer.getUserId() <= 0) {
            return false;
        }

        if (trainer.getName() == null ||
            trainer.getName().trim().isEmpty()) {
            return false;
        }

        if (trainer.getPhoneNumber() == null ||
            trainer.getPhoneNumber().trim().isEmpty()) {
            return false;
        }

        if (trainerCount >= trainers.length) {
            return false;
        }

        if (searchTrainerById(trainer.getUserId()) != null) {
            return false;
        }

        trainers[trainerCount] = trainer;
        trainerCount++;

        System.out.println("Trainer registered successfully.");
        return true;
    }

    public Trainer searchTrainerById(int trainerId) {

        for (int i = 0; i < trainerCount; i++) {
            if (trainers[i].getUserId() == trainerId) {
                return trainers[i];
            }
        }

        return null;
    }

    public void dispalyAllTrainers() {

        if (trainerCount == 0) {
            System.out.println("No trainers registered.");
            return;
        }

        for (int i = 0; i < trainerCount; i++) {
            System.out.println("\nTrainer " + (i + 1));
            trainers[i].displayDetails();
        }

        System.out.println("Total trainers: " + trainerCount);
    }
}
