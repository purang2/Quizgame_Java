package quizGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/* 화면 Page 1- 시작 화면*/
public class QuizGame extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon startButtonImage = new ImageIcon(Main.class.getResource("../images/sijak.png"));
	private ImageIcon quitButtonImage = new ImageIcon(Main.class.getResource("../images/jongryo.png"));

	private Image introBackground = new ImageIcon(Main.class.getResource("../images/turtle1re.jpg")).getImage();

	private JButton startButton = new JButton(startButtonImage);
	private JButton quitButton = new JButton(quitButtonImage);
    
	public QuizGame() {

		setTitle(" Quiz Game : Page 1- Start");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);// 사이즈 고정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);

		startButton.setBounds(40, 200, 339, 130);
		
		
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}			
				dispose();
				getContentPane().add(new startGame());

			}
		});

		quitButton.setBounds(40, 350, 239, 123);
		
		quitButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {					}
			public void mouseReleased(MouseEvent e) {					}
			
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				
				dispose();
			}
		});
		
		add(startButton);
		add(quitButton);
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
		
	}

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		//this.repaint();
	}
}
