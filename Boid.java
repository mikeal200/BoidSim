import java.util.ArrayList;

public class Boid {
	public Vector2D position;
	Vector2D velocity;
  	Vector2D acceleration;
  	float r;
  	float maxforce;    // Maximum steering force
  	float maxspeed;    // Maximum speed
	
	public Boid(double x, double y) {
		acceleration = new Vector2D(0, 0);
		position = new Vector2D(x, y);	
	}

	public void run(ArrayList<Boid> boids) {
		
	}
}
