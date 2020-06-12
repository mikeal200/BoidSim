import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main extends Frame {
	Flock flock;


	public static void main(String args[]) {
		new Main();
	}

	public Main (){
		super("Boid Simulation");
		setSize(400, 400);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose(); 
				System.exit(0);
			}       	
		});

		Random rand = new Random();

		for(int i = 0; i < 5; i++) {
			flock.addBoid(new Boid(rand.nextInt(400), rand.nextInt(400)));
		}
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
	       	g2d.setColor(Color.blue);
		g2d.drawRect(75, 75, 300, 200);	
		flock.run();
	}
}



