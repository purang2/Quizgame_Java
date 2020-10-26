package quizGame;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
/* 화면 Page 3-시작 전 인트로 +준비 화면 */
public class sideScene extends JFrame {
	int number;
	private Image screenImage2;
	private Graphics screenGraphic2;
	private Image Background_chinese = new ImageIcon(Main.class.getResource("../images/side_Chinesere.jpg")).getImage();
	private Image Background_movie= new ImageIcon(Main.class.getResource("../images/side_Moviere.jpg")).getImage();
	private Image Background_java= new ImageIcon(Main.class.getResource("../images/side_Javare.jpg")).getImage();
	private Image Background_common= new ImageIcon(Main.class.getResource("../images/side_Commonre.jpg")).getImage();
	
	public sideScene(int k) {
       number=k;
		setTitle("Quiz Game: Page 3- Are You Ready? :)");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
    
		try {
			Thread.sleep(1500);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		try {	
		    //dispose();
			getContentPane().add(new OnGame(number));
		}catch(Exception eee) {			}
		setVisible(true);
	}

	public void paint(Graphics g) {
		screenImage2 = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic2 = screenImage2.getGraphics();
		screenDraw(screenGraphic2);
		g.drawImage(screenImage2, 0, 0, null);

	}

	public void screenDraw(Graphics g) {
		if (number == 0)
			g.drawImage(Background_movie, 0, 0, null);
		if (number == 1)
			g.drawImage(Background_chinese, 0, 0, null);
		if (number == 2)
			g.drawImage(Background_java, 0, 0, null);
		if(number==3)
			g.drawImage(Background_common,0,0,null);
	}
}
