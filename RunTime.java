import java.io.IOException;
import javax.swing.*;


public class RunTime {

	public static void main(String[] args) throws IOException{
		JFrame window = new JFrame ("BouncingBabies");
        BouncingBabies game = new BouncingBabies();
        window.add(game);
        window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setSize(500, 400);
      //this for the action listener
        Timer t = new Timer(30, game);
        t.start();
        //for the mouse motion
       // window.addMouseMotionListener(game);
        window.addKeyListener(game);
        
	}

}
