package me.akhalef.service;

import me.akhalef.aspect.Log;
import me.akhalef.aspect.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {
    @Override
    @Log
    @SecuredByAspect(roles = {"admin", "user"})
    public void process() {
        System.out.println("Processing...");
    }

    @Override
    @Log
    @SecuredByAspect(roles = {"admin"})
    public double compute() {
        double data = Math.random() * 100;
        System.out.println("Computing: " + data);
        return data;
    }
}
