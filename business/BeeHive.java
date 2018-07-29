/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.QueenBee;
import entity.Bee;
import entity.WorkerBee;
import entity.Drone;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author hp
 */
public class BeeHive {
    private ArrayList<Bee> listBee;

    public void init() {
        //create list of 10 bees  of Queen, Drone and Worker types
        //in each bee, type and health attributes are randomly chosen
        this.listBee = new ArrayList<>();
        //your code
        listBee = randomBees(listBee);
    }

    public ArrayList<Bee> getAllBees() {
        return listBee;
    }

    //attach all bees
    public void attackBees() {
        //your code
        for(int i=0;i<this.listBee.size();i++)
        {    
            listBee.get(i).damage();
        }
    }
    public ArrayList<Bee> randomBees( ArrayList<Bee> listBee){
        boolean isThereQueen = false;
        int r;
        for(int i = 0;i<10;i++){
            r = (int)(Math.random()*100);
            if(r <= 33){
            	if(!isThereQueen){
                    listBee.add(new QueenBee());
                    isThereQueen = true;
                }
            	else {
            		i-=1;
            	}
            }else if(r <=66){
                listBee.add(new WorkerBee());
            }else{
            	listBee.add(new Drone());
            }

        }
        return listBee;
    }
}
