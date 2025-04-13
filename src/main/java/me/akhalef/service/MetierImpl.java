package me.akhalef.service;

import me.akhalef.aspect.Log;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {
    @Override
    @Log
    public void process() {
        System.out.println("Processing...");
    }

    @Override
    @Log
    public double compute() {
        double data = Math.random() * 100;
        System.out.println("Computing: " + data);
        return data;
    }
}
