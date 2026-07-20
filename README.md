# Elastic Collision Simulation Project

Visual of Simulation
<br>
<img width="567" height="577" alt="image" src="https://github.com/user-attachments/assets/e81a60e9-f164-4cce-bfbc-deefc8c79e37" />

Features in Simulation
- Real time animation using a timer.
- 2D representation of collisions between balls.
- Final velocity is determined from derived momentum equation.
- Includes live velocity tracker from motion.
- Implementation of wall collision detection. 
- Usage of rectangle object are enhanced for contact between balls.

Physics Concepts in Simulation
- Conversation of Momentum (p): m1i + m2i = m1f + m2f.
- Elastic Collisions.

How it Works
- Initializes frame, final velocity, horizontal position, ball height properties for simulation modelling.
- Velocities are in same magnitude, but opposite in direction when making contact with the walls.
- Has animation with the use of Java Timer.
- Includes paint method that draws the balls in their updated positions.
- Velocity table of values is being displayed by classic print lines.
- Conditionals are implemented to check if balls are intersecting one another and used to change the value of the velocity using the derived momentum equations.
- Position of the balls are being updated from constant velocity variables declared.

Requirements
- Java (JDK or higher).
- IDE (e.g., VS Code, Eclipse, or IntelliJ).

How to Run
1) Copy the code into a Java file named "ElasticCollision.java".
2) Compile the program: "javac ElasticCollision.java".
3) Run the program: "java ElasticCollision".
