package me.akhalef.service;

import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {
    @Override
    public void process() {
        System.out.println("Processing...");
    }

    @Override
    public double compute() {
        double data = Math.random() * 100;
        System.out.println("Computing: " + data);
        return data;
    }
}
