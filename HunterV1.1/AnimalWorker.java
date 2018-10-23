/**
 * Class AnimalWorker
 * 
 *  This is a Thread which iterates over the Animal array and randomly moves the 
 *  animals and calls the run method of animals if the hunter is in view.
 *
 */

 import animal.extras.*;
 import animal.exceptions.*;

public class AnimalWorker extends Thread
{
    private Forest forest;
    private Hunter hunter;

    AnimalWorker(Hunter phunter , Forest pforest)
    {
        this.hunter = phunter;
        this.forest = pforest;
    }

    public void run()
    {
        int randx , randy;
   

        while(true)
        {
            if(this.hunter.getArrows() <= 0 || this.forest.getCurrentAnimalCount() <= 0)
            {
               Thread.currentThread().stop();
            }

           

            for(Animal a : this.forest.getAnimals())
            {
                if(a != null)
                {
                    randx = Rand.randNumber(0 , this.forest.getPosX());
                    randy = Rand.randNumber(0 , this.forest.getPosY());
     
                    a.setDestination(randx,randy);
    
                    Console.log(a.getId(),":" , a.getType() ,": Strength ->" , a.getStrength() ,  " Moving From (" , a.getCoordinates() , ") to {" , randx ,":",randy , "}");
                    Console.newLine();
    
                    a.walk();
    
                    Console.sleep(800);

                    if(Rand.randNumber(1,4) > 1)
                    {
                       // a.makeSound();
                    }
    
                    if(a.view(this.hunter))
                    {
                        a.run();
                    }
    
    
                }
            }
        }
    }
}
