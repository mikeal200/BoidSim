import java.util.ArrayList;

public class Flock {
        public ArrayList<Boid> boids = new ArrayList<>(); 
	public Main m;

	public Flock() {
		//boids = new ArrayList<Boid>();
	}

	public void run() {
		for(Boid b : boids) {
			b.run(boids);
		}	
	}

	public void addBoid(Boid b) {
		boids.add(b);
	}

	public void render() {
	}
}	
