import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BouncingBabies extends JComponent implements ActionListener,
KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Class Instances
	Image fireTruck;
	Image fireHouse;
	private int fireHouseX=0;
    private int fireHouseY=0;
    private int fireTruckX=590;
    private int fireTruckY=480;
    Babies b;
    Flame f;
    Firemen m;
    
    // class constructor
    public BouncingBabies() throws IOException {
        this.fireHouse = ImageIO.read(getClass().getResource("fh5.png"));
        this.fireTruck = ImageIO.read(getClass().getResource("samu10.png"));
        b = new Babies();
        f = new Flame();
        m = new Firemen();
    
    }
    
    // Dimensions of screen
    public Dimension getPreferredSize(){
        return new Dimension(800,600);
    }
    
    // screen of graphics
    protected void paintComponent(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(0, 0, 800, 600);
        //
        g.drawImage(fireHouse, fireHouseX, fireHouseY, null);
        g.drawImage(fireTruck,fireTruckX,fireTruckY,null);
        b.paintComponent(g);
        f.paintComponent(g);
        m.paintComponent(g);
        g.setColor(Color.white);
        
    }
    
    //perform action
    public void actionPerformed(ActionEvent ae){
    	b.move();
    	f.move();
    	repaint();
    }

	//invoker method
	public void keyPressed(KeyEvent e) {
		m.transmute(e);
		repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		
	}
	
}
