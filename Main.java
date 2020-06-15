import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.Timer;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends JFrame {
	public Flock flock = new Flock();


	public static void main(String args[]) {
		new Main();	
	}

	public Main (){
		super("Boid Simulation");
		setSize(400, 400);
		getContentPane().setBackground(Color.BLACK);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose(); 
				System.exit(0);
			}       	
		});
		addBoids();
	}

	public void addBoids() {
		Random rand = new Random();

		for(int i = 0; i < 5; i++) {
			Boid boid = new Boid(i * 2, i * 2);
			flock.addBoid(boid); 
		}

		Timer timer = new Timer(16, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveBoids();
				repaint();
			}
		});
		timer.start();
	}

	public void moveBoids() {
		Vector2D v1 = new Vector2D(0, 0);
		Vector2D v2 = new Vector2D(0, 0);
		Vector2D v3 = new Vector2D(0, 0);

		for(Boid b : flock.boids) {
			v1 = cohesion(b);
			//v2 = seperation(b);
			b.velocity = b.velocity.getAdded(v1);
			b.position = b.position.getAdded(b.velocity);
		}
	}

	public Vector2D cohesion(Boid bCoh) {
		Vector2D pcJ = new Vector2D(0, 0);

		for(Boid b : flock.boids) {
			if(b != bCoh) {
				pcJ = pcJ.getAdded(b.position);
			}
		}

		pcJ = pcJ.getDivided(flock.boids.size() - 1);
		return(pcJ.getSubtracted(bCoh.position)).getDivided(100);
	}

	public void paint(Graphics g) {
		super.paint(g);
	       	g.setColor(Color.blue);
		g.drawRect(75, 75, 300, 200);
		for(Boid b : flock.boids) {	
			g.drawOval((int)b.position.x, (int)b.position.y, 20, 20);
		}
	//	flock.run();
	}
}



