import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics2D;

import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Room extends JPanel implements ActionListener {
	private final int const_RoomWidth = 640;
	private final int const_RoomHeight = 640;
	private final int const_Unit = 32;
	private final int const_Positions = (int)((const_RoomWidth * const_RoomHeight) / const_Unit);
	private int glb_Steps = 256;
	
	private int[] glb_GridX = new int[const_Positions];
	private int[] glb_GridY = new int[const_Positions];
	private int glb_SnakeLength;
	
	private int[] glb_Apple = new int[2];
	private int glb_Direction = 0;
	private int glb_Highscore = 0;
	private int glb_StepCount = 0;
	
	private boolean glb_Dead = false;
	private Timer glb_Timer;
	
	public Room() {
		initRoom();
	}
	
	public static void log(int type, String msg) {
		if(type == 0) System.out.println("INFO: " + msg);
	}
	
	private void initRoom() {
		log(0, "Initializing room...");
		
		addKeyListener(new TAdapter());
		setBackground(Color.DARK_GRAY);
		setFocusable(true);
		setPreferredSize(new Dimension(const_RoomWidth, const_RoomHeight));
		initGame();
	}
	
	private void initGame() {
		log(0, "Hello!");
		glb_SnakeLength = 2;
		
		for(int i = 0; i < glb_SnakeLength; i = i + 1) {
			glb_GridX[i] = (int)(Math.floor(const_RoomWidth / const_Unit) / 2 * (i+1) * const_Unit);
			glb_GridY[i] = (int)(Math.floor(const_RoomHeight / const_Unit) / 2 * const_Unit);
		}
		
		spawnApple();
		
		glb_Timer = new Timer(glb_Steps, this);
		glb_Timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Draw(g);
	}
	
	private void Draw(Graphics g) {
		log(0, "Drawing game");
		if (!glb_Dead) {
			
			g.setColor(Color.RED);
			g.fillRect(glb_Apple[0], glb_Apple[1], const_Unit, const_Unit);
			
			for(int i = 0; i < glb_SnakeLength; i = i + 1) {
				if (i == 0) g.setColor(Color.RED); 
				else g.setColor(Color.GREEN); 
				
				g.fillRect(glb_GridX[i], glb_GridY[i], const_Unit, const_Unit);
			}
			
			g.setColor(Color.BLACK);
			for(int i = 0; i < (int)Math.floor(const_RoomWidth / const_Unit); i = i + 1) {
				g.drawLine(i * const_Unit, 0, i * const_Unit, const_RoomHeight);
				g.drawLine((i + 1) * const_Unit - 1, 0, (i + 1) * const_Unit - 1, const_RoomHeight);
			}
			
			for(int i = 0; i < (int)Math.floor(const_RoomWidth / const_Unit); i = i + 1) {
				g.drawLine(0, i * const_Unit, const_RoomWidth, i * const_Unit);
				g.drawLine(0, (i + 1) * const_Unit - 1, const_RoomWidth, (i + 1) * const_Unit - 1);
			}
			
			if(glb_Direction == 0) DrawText(g, "Use WASD to begin!", const_RoomWidth / 2, const_RoomHeight / 2, 1);
			
			Toolkit.getDefaultToolkit().sync();
		} else {
			End(g);
		}		
	}
	
	private void DrawText(Graphics g, String message, int posX, int posY, int align) {
		String lines[] = message.split("\r\n");
		Font small = new Font("Palatino Linotype", Font.BOLD, 14);
		FontMetrics metr = getFontMetrics(small);
		
		g.setColor(Color.white);
		g.setFont(small);
		
		int max = lines.length;
		for(int i = 0; i < max; i = i + 1) {
			int posX2 = posX;
			
			switch(align) {
				case 0: break; // Left align
				case 1: posX2 = posX - (int)(metr.stringWidth(lines[i]) / 2); break; // Center
				case 2: posX2 = posX - metr.stringWidth(lines[i]); break; // Right align
			}
		
			posY = posY + (i * metr.getHeight());
			g.drawString(lines[i], posX2, posY);
		}
	}
	
	private void End(Graphics g) {
		log(0, "Game Over! Score: " + glb_SnakeLength);
		
		if(glb_SnakeLength > glb_Highscore) glb_Highscore = glb_SnakeLength;
		
		DrawText(g, "Game Over!\r\nScore: " + glb_SnakeLength + "\r\nHighscore: " + glb_Highscore + "\r\nPress ENTER to restart!", const_RoomWidth / 2, const_RoomHeight / 2, 1);
	}
	
	private void Step() {
		log(0, "Step...");
		for(int i = glb_SnakeLength; i > 0 && glb_Direction != 0; i = i - 1) {
			glb_GridX[i] = glb_GridX[(i - 1)];
			glb_GridY[i] = glb_GridY[(i - 1)];
		}
		
		if (glb_Direction == 1) glb_GridX[0] = glb_GridX[0] - const_Unit;
		if (glb_Direction == 2) glb_GridX[0] = glb_GridX[0] + const_Unit;
		if (glb_Direction == 3) glb_GridY[0] = glb_GridY[0] - const_Unit;
		if (glb_Direction == 4) glb_GridY[0] = glb_GridY[0] + const_Unit;
		
		log(0, "Snake pos: " + glb_GridX[0] + ", " + glb_GridY[0] + ";");
	}
	
	private void Collision() {
		log(0, "Checking collision...");
		
		if ((glb_GridX[0] == glb_Apple[0]) && (glb_GridY[0] == glb_Apple[1])) {
			glb_SnakeLength++;
			if(glb_SnakeLength % 4 == 0) glb_Steps = glb_Steps - 8;
			spawnApple();
		}
		
		for(int i = glb_SnakeLength; i > 0; i = i - 1) {
			if ((i > 4) && (glb_GridX[0] == glb_GridX[i]) && (glb_GridY[0] == glb_GridY[i])) {
				glb_Dead = true;
			}
		}
		
		if(glb_GridY[0] >= const_RoomHeight) glb_Dead = true;
		if(glb_GridY[0] < 0 || glb_GridX[0] < 0) glb_Dead = true;
		if(glb_GridX[0] >= const_RoomWidth) glb_Dead = true;
		
		if (glb_Dead) {
			log(0,"uh oh");
			glb_Timer.stop();
		}
		
		log(0, "End collision checking");
	}
	
	private void spawnApple() {
		log(0, "Spawning an Apple!");
		
		int pos = (int)Math.floor(Math.random() * (const_RoomWidth / const_Unit));
		glb_Apple[0] = (pos * const_Unit);
		
		pos = (int)Math.floor(Math.random() * (const_RoomHeight / const_Unit));
		glb_Apple[1] = (pos * const_Unit);
		log(0, "Apple position: " + glb_Apple[0] + ", " + glb_Apple[1] + ";");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		log(0, "Ticking room, time: " + glb_StepCount);
		
		if (!glb_Dead) {
			Collision();
			Step();
		}
		
		glb_StepCount = glb_StepCount + 1;
		repaint();
	}
	
	private class TAdapter extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			switch(key) {
				case KeyEvent.VK_A: if(glb_Direction != 2) glb_Direction = 1; break;
				case KeyEvent.VK_D: if(glb_Direction != 1) glb_Direction = 2; break;
				case KeyEvent.VK_W: if(glb_Direction != 4) glb_Direction = 3; break;
				case KeyEvent.VK_S: if(glb_Direction != 3) glb_Direction = 4; break;
			}
			
			if(key == KeyEvent.VK_ESCAPE) System.exit(0);
			
			if(key == KeyEvent.VK_ENTER && glb_Dead) {
				glb_Dead = false;
				glb_Direction = 0;
				glb_Steps = 256;
				initGame();
			}
		}
	}
}