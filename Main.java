import java.awt.*;
import java.awt.event.*;
import java.util.Random;

@SuppressWarnings("serial")
public class Main extends Frame {
	public Flock flock = new Flock();


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
		//flock.addBoid(new Boid(2, 2));
		//flock.addBoid(new Boid(50, 60));
		addBoids();
	}

	public void addBoids() {
		Random rand = new Random();

		for(int i = 0; i < 5; i++) {
			Boid boid = new Boid(i * 2, i * 2);
			flock.addBoid(boid); 
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
	       	g.setColor(Color.blue);
		g.drawRect(75, 75, 300, 200);
		for(Boid b : flock.boids) {
		
			g.drawRect((int)b.position.x, (int)b.position.y, 20, 20);
		}
	//	flock.run();
	}
}



