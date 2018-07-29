/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Random;

/**
 *
 * @author hp
 */
public class Bee {
    private String type;
    private byte health;
    private boolean alive;

    public Bee() {
        //init
        //your code
    	alive = true;
    	health = 100;
        
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte getHealth() {
        return health;
    }

    public void setHealth(byte health) {
        this.health = health;
        //update the alive status when the health value changed
        //your code
        isDead();
    }   
    
    public boolean isAlive(){
    	return this.alive;
    }  

    //attack this bee
    public void damage() {
        //your code
        if(health > 0){
            health -= (byte)(Math.random()*100);
            setHealth(health);
        }
        if(health <= 0){
            health = 0;
            alive = false;
        }
    }

    @Override
    public String toString() {
        String beeDetails ="Bee details";
        //your code
        if(isAlive()) {
        	beeDetails = this.type+"\t"+this.health+"\t"+"alive";
        }
        else {
        	beeDetails = this.type+"\t"+this.health+"\t"+"dead";
        }
        return beeDetails;
    }
    public void isDead() {
    	if(getType() == "Worker"){
            if (health< 70){
             alive = false;
            }else {
            	this.alive = true;
            } 
        } else if(getType() == "Drone"){
            if(health < 50){
                alive = false;
            }else {
            	this.alive = true;
            }
        } else if(getType() == "Queen"){
            if(health < 20){
                alive = false;
            }
            else {
            	this.alive = true;
            }
        }
    }
}
