package quizGame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/* 화면 Page 4- 퀴즈 게임 진행  */
public class OnGame extends JFrame implements ActionListener {

	ImageIcon wrongImage = new ImageIcon(Main.class.getResource("../images/chinaNo.jpg"));
	ImageIcon correctImage = new ImageIcon(Main.class.getResource("../images/chinaOK.jpg"));
	ImageIcon testImage = new ImageIcon(Main.class.getResource("../images/shrekMain.jpg"));
	ImageIcon emptyImage = new ImageIcon(Main.class.getResource("../images/empty.png"));

	String name;
	private String bogi[][];
	private JTextArea quizbox;
	private JButton bu1, bu2, bu3, bu4;
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel = new JPanel();
	JPanel user = new JPanel();
	JPanel panellow;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label0;
	private JLabel label = new JLabel(emptyImage);
    int status[] = { 0, 0, 0, 0 };
	int g;
	boolean flag;

	public OnGame(int genre) throws Exception {
		this.bogi = database.get_Database(genre);
		g = genre;
		quizbox = new JTextArea(7, 85);

		String quiz = setQuiz(status[genre]);
		// setLayout(null);

		Font font = new Font("휴먼엑스포", Font.BOLD, 17);

		quizbox.setText(quiz);
		quizbox.setFont(font);
		quizbox.setEditable(false);
		quizbox.setLineWrap(true);
		String btext[] = new String[5];

		for (int i = 0; i < bogi[0].length; i++) {
			btext[i] = bogi[status[2]][i];
		}

		bu1 = new JButton(btext[0]);
		bu2 = new JButton(btext[1]);
		bu3 = new JButton(btext[2]);
		bu4 = new JButton(btext[3]);
		bu1.addActionListener((ActionListener) this);
		bu2.addActionListener((ActionListener) this);
		bu3.addActionListener((ActionListener) this);
		bu4.addActionListener((ActionListener) this);

		panel.add(new JLabel(testImage));
		panel.setLayout(new BorderLayout());
		panel1.add(quizbox);

		panel2.add(bu1);
		panel2.add(bu2);
		panel2.add(bu3);
		panel2.add(bu4);
		panel3.add(label);
		
		panellow = new JPanel();
		label0 = new JLabel("[[ 사용자 상태 표시창 ]]");
		label1 = new JLabel("현재 퀴즈 번호 : " + Integer.toString(Main.Now_QuizNum) + "번");
		label2 = new JLabel("현재 점수 : " + Integer.toString(Main.Game_Score) + "점");
		label3 = new JLabel("남은 퀴즈 : " + Integer.toString(Main.Remain_Question) + "개");
		label4 = new JLabel("남은 기회 : " + Integer.toString(Main.Life_Remain) + "개");
		panellow.setLayout(new GridLayout(0, 1));
		panellow.add(label0);
		panellow.add(label1);
		panellow.add(label2);
		panellow.add(label3);
		panellow.add(label4);
		// panel4.add(user1);
		panel.add(panel1, BorderLayout.NORTH);
		panel.add(panel2, BorderLayout.CENTER);
		panel.add(panellow, BorderLayout.WEST);
		panel.add(panel3, BorderLayout.SOUTH);
		// panel.add(panel4, BorderLayout.WEST);
		
		add(panel);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Quiz Game: Page 4- Quiz Challenge");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setVisible(true);

		
	}

	public void actionPerformed(ActionEvent e) {
		// 사용자가 누른 버튼을 감지
		JButton d = (JButton) e.getSource();
		System.out.println("액션 리스너 동작 확인!!");

		// 사용자가 선택한 번호
		int su = Integer.parseInt("" + d.getText().charAt(0));
		// 정답의 번호가 됨
		int ans = Integer.parseInt(bogi[status[g]][4]);

		// 정답과 입력을 비교
		if (su == ans) {
			status[g]++;
			Main.Remain_Question--;
			Main.Now_QuizNum = status[g]+1;
			System.out.println("정답!! 다음 단계로 넘어갑니다");
			correctAnswer();

			try {
				Thread.sleep(300);
			} catch (Exception ee) {
			}
			if (status[g] > 9) {
				quizbox.setText("퀴즈가 끝났습니다 축하합니다");
				try {
					Thread.sleep(2000);
				} catch (Exception ee) {
				}
				dispose();
				getContentPane().add(new gameEnding(1));
			}
			// 업데이트
			resetText(status[g]);
		} else if (su != ans) {
			wrongAnswer();
			System.out.println("틀렸습니다! 현재 라이프: " + Main.Life_Remain);
			if (Main.Life_Remain <= 0) {
				end_Game(0);
			}
		}
		label1.setText("현재 퀴즈 번호 : " + Integer.toString(Main.Now_QuizNum) + "번");
		label2.setText("현재 점수 : " + Integer.toString(Main.Game_Score) + "점");
		label3.setText("남은 퀴즈 : " + Integer.toString(Main.Remain_Question) + "개");
		label4.setText("남은 기회 : " + Integer.toString(Main.Life_Remain) + "개");

	}

	void wrongAnswer() {

		Main.Life_Remain--;
		Main.Game_Score -= 2;
		panel3.removeAll();
		label = new JLabel(wrongImage);
		panel3.add(label);
		setVisible(true);
		quizbox.repaint();

	}

	void correctAnswer() {
		Main.Game_Score += 10;
		panel3.removeAll();
		label = new JLabel(correctImage);
		panel3.add(label);
		setVisible(true);
		quizbox.repaint();

	}

	void end_Game(int x) {
		quizbox.setText("라이프가 0이 되어 사망하였습니다!");

		try {
			Thread.sleep(2000);
		} catch (Exception ee) {
		}
		dispose();
		getContentPane().add(new gameEnding(x));

	}

	// 저장된 배열에서 문제에 해당하는 보기를 업데이트한다
	void resetText(int n) {
		// 보기를 재설정 해주는 메소드
		try {
			String t = setQuiz(n);
			quizbox.setText(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String btext[] = new String[5];

		for (int i = 0; i < bogi[0].length; i++) {
			btext[i] = bogi[status[g]][i];
		}
		bu1.setText(btext[0]);
		bu2.setText(btext[1]);
		bu3.setText(btext[2]);
		bu4.setText(btext[3]);
		flag = true;
	}

	// 문제를 txt파일을 통해 추출한다
	String setQuiz(int num) {
		String text = "";
		ArrayList<Character> a = new ArrayList<>();
		Character[] array;

		try {
			FileReader fr = new FileReader("quiz_" + g + "_" + num + ".txt");
			int ch;

			while ((ch = fr.read()) != -1) {
				a.add((char) (ch));
			}
		} catch (Exception e) {
			e.getStackTrace();
		}

		array = a.toArray(new Character[a.size()]);

		for (int i = 0; i < a.size(); i++) {
			text = text + array[i];
		}

		return text;
	}

}
