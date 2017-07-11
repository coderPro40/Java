import java.awt.*;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Flame implements Game {
	Image flames;
	private int flamesX=40;
    private int flamesY=70;
    Random r = new Random();
    int timeUntilflamesmove = 30;
    
    //Class constructor
    public Flame() throws IOException{
    	this.flames = ImageIO.read(getClass().getResource("flame12.png"));
    	
    }

	//modify movement of flame
	public void move() {
		//timing for flame movement
		if (timeUntilflamesmove<=0){
	        flamesX= r.nextInt(50);
	        flamesY= r.nextInt(600);
	         timeUntilflamesmove=10;
	         }
	    else{
	            timeUntilflamesmove -=1 ;
	         }
		
	}

	//paint picture of flame
	public void paintComponent(Graphics g) {
		g.drawImage(flames, flamesX, flamesY, null);
		
	}
    
	
}
