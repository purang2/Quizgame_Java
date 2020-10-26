package quizGame;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/* 화면 Page 5 - 게임이 끝났을 때 (슈렉 + 다시 시작 가능 )*/
public class gameEnding extends JFrame {

	int number;
	private Image screenImage2;
	private Graphics screenGraphic2;
	private ImageIcon restartButtonImage = new ImageIcon(Main.class.getResource("../images/restart.png"));
	private Image Background_win = new ImageIcon(Main.class.getResource("../images/shrekMain_win.jpg")).getImage();
	private Image Background_fail = new ImageIcon(Main.class.getResource("../images/shrekMain_fail.jpg")).getImage();

	
	public void initialize() {
		Main.Now_QuizNum = 1;
		Main.Game_Score = 0;
		Main.Remain_Question = 10;
		Main.Life_Remain = 10;	
	}
	public void writeResult() throws IOException {
		FileWriter out = new FileWriter("Lank.txt");
		out.write("최고 점수는" + Main.Game_Score + "입니다.");
        out.flush();
	}

	public gameEnding(int n) {
		number = n;
		setTitle("Quiz Game: Page 5- The End of This Game");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);

		JButton restartButton = new JButton(restartButtonImage);

		restartButton.setBounds(500, 500, 176, 56);

		restartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				restartButton.setIcon(restartButtonImage);
				restartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				restartButton.setIcon(restartButtonImage);
				restartButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				dispose();
				initialize();
				getContentPane().add(new QuizGame());

			}
		});
		
		
		/*
		try {
	          FileReader in  = new FileReader("Lank2.txt");
	          int r;
	          String last = "";
	          while((r = in.read()) != -1) {
	             last = last+Integer.toString(in.read()); 
	          }
	          if(Integer.parseInt(last) < Main.Game_Score) {
	            FileWriter out = new FileWriter("Lank.txt");
	            FileWriter out2 = new FileWriter("Lank2.txt");
	               out2.write((int)Main.Game_Score);
	               out2.flush();
	               out.write("최고 점수는"+Main.Game_Score+"입니다.");
	               out.flush();
	          }
	          
		}catch(Exception e) {}  
	       */     
		setLayout(null);

		add(restartButton);
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
		if (number == 1)
			g.drawImage(Background_win, 0, 0, null);
		else
			g.drawImage(Background_fail, 0, 0, null);
	}
}
