import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.imageio.ImageIO;

public class Firemen implements Game {
	Image firemen;
	private int firemenX=300;
    private int firemenY= 500;
    KeyEvent movement; //command design pattern
    
    //class constructor
    public Firemen() throws IOException{
    	this.firemen = ImageIO.read(getClass().getResource("firemen.png"));
    	
    }

	//modify firemen movement
	public void move() {
		
	}
	
	public void transmute(KeyEvent movement){
		if (movement.getKeyCode()== KeyEvent.VK_LEFT){
            firemenX=150;
        }
        if (movement.getKeyCode()== KeyEvent.VK_DOWN){
            firemenX=300;
        }
        if (movement.getKeyCode()== KeyEvent.VK_RIGHT){
            firemenX=420;
        }
		
	}

	//paint firemen image
	public void paintComponent(Graphics g) {
		g.drawImage(firemen, firemenX, firemenY, null);
		
	}
	
}
