package com.example.gra_sieciowa;
import javafx.scene.shape.*;

public class Game {
    
    private void checkCollision(Shape block) {
        boolean isCollision = false;
        for(Shape static_bloc : ){ //array of objects
            // if(static_bloc != block){
                if(block.getBoundsInParent().intersects(static_bloc.getBoundsInParent())){
                    isCollision = true;
                }
            }
        }
        
        if(isCollision){
            //set fill transparent
            //counter++
        }else{
            
        }
        
        
    }

    
}
