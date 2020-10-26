package quizGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/* 화면 Page 2 -장르 선택*/
public class startGame extends JFrame {

	private Image screenImage2;
	private Graphics screenGraphic2;
	private ImageIcon startButtonImage = new ImageIcon(Main.class.getResource("../images/start_small.png"));
	private Image selectBackground = new ImageIcon(Main.class.getResource("../images/turtle2re.jpg")).getImage();

	public startGame() {
		setTitle("Quiz Game : Page 2- select Genre");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);

		String[] genre = { "영화", "중국어", "자바", "상식" };
		JComboBox genreBox = new JComboBox(genre);
		genreBox.setSelectedIndex(0);
		JButton startButton = new JButton(startButtonImage);

		startButton.setBounds(500, 500, 176, 56);
        
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
				int k=genreBox.getSelectedIndex();
				
				dispose();
				try {	
					getContentPane().add(new sideScene(k));					
				} catch (Exception e3) {
					e3.printStackTrace();
				}

			}
		});

		setLayout(null);

		add(genreBox);
		add(startButton);
		
		genreBox.setSize(100, 30);
		genreBox.setLocation(600, 130);
		
		JLabel start1 = new JLabel();
		start1.setHorizontalAlignment(JLabel.CENTER);
	
		setVisible(true);
	}


	public void paint(Graphics g) {
		screenImage2 = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic2 = screenImage2.getGraphics();
		screenDraw(screenGraphic2);
		g.drawImage(screenImage2, 0, 0, null);

	}

	public void screenDraw(Graphics g) {
		g.drawImage(selectBackground, 0, 0, null);
	}
}
