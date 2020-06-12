import java.util.ArrayList;

public class Flock {
        ArrayList<Boid> boids; 
	Main m;

	public Flock() {
		boids = new ArrayList<Boid>();
	}

	void run() {
		for(Boid b : boids) {
			b.run(boids);
		}	
	}

	void addBoid(Boid b) {
		boids.add(b);
	}

	void render() {
	}
}	
