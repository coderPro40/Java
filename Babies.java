import java.awt.*;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Babies implements Game{
	Image babyImage;
	private Baby[] babies = new Baby[10];
    int timeUntilNextBaby= 50;
    int droppedBabies= 0;
    int savedBabies= 0;
    Random r = new Random();
    
    //class constructor
    public Babies() throws IOException{
    	this.babyImage = ImageIO.read(getClass().getResource("Baby2.png"));
    	babies[1]= new Baby();
    }

	//modify movement of babies
	public void move() {
		//timing for when next baby is tossed
		if (timeUntilNextBaby<=0){
	        tossNewBaby();
	        timeUntilNextBaby= r.nextInt(100);}
	        
	        else{
	            timeUntilNextBaby -=1 ;
	        }
	        
	        for (int i = 0; i < 10; i++){
	            if (babies[i]== null){
	                continue;}
	        //drop babies
	        babies[i].X +=3;
	        babies[i].Y = (int) (babies[i].Y+ babies[i].ySpeed);
	        babies[i].ySpeed+=1;
	        /**if (babies[i].Y>= 550){
	        	//bounce baby on firemen net
	            if((babies[i].X + babies[i].babyWidth >= firemenX) && (firemenX +150 >= babies[i].X)){
	                makeTheBabyBounce(i);
	                
	            }else{
	                droppedBabies +=1;
	                //tossNewBaby();
	                //empty slot of the previous baby so it can be reuse
	                babies[i]= null;
	                continue;
	                
	            }
	        }
	        
	        //store number of saved babies
	        if (babies[i].X >= 600){
	            savedBabies+=1;
	            babies[i]=null;
	            continue;
	        }*/
	        }
		
	}

	//paints picture of babies
	public void paintComponent(Graphics g) {
		for (int i = 0; i < 10; i++){
            //if there is no baby, skip below but if there is execute code
            if (babies[i]== null){
                continue;}
            g.drawImage(babyImage, babies[i].X, babies[i].Y, null);
        }
		//string for displaying scores
		g.drawString("saved: "+ savedBabies, 500, 20);
        g.drawString("dropped: "+ droppedBabies, 500, 40);
		
	} 
	
	//put a new baby in empty slot in our case in building
    private void tossNewBaby(){
        for (int i = 0; i < 10; i++){
            if (babies[i]== null){
                babies[i]= new Baby();
                break;
            }
        }
    }
    
    //code for making babies bounce
    private void makeTheBabyBounce(int i) {
        babies[i].ySpeed= -0.9 * Math.abs(babies[i].ySpeed);
    }
	
}
