package quizGame;
import java.util.*;

public class userProfile {
	public static int num=0; //num =현재 문제 
    public static int life=10;
    public static final int life_max=10;
    public static int count=0;
	public static String[] quiz_Database= {
			"자바를 창시한 사람은 누구입니까?"
			,"경북대 최고의 맛집은 어디입니까?"
			,"중국어로 xingbake는 무슨 의미입니까?"
			, "경북대 개교기념일은 언제입니까?"
			," '까르보나라'의 어원은?"
			};
	
	static int max_quiz_length=5;
	
	static boolean[] isCorrect=new boolean[max_quiz_length];
		
	static String[][] quiz_Bogi= 
		{
				{"리오넬 고슬링","제임스 고슬링",	"아이엠 고슬링","로베르토 고슬링"}
				,{"브리또","공대식당","맘스터치","유낭"}
				,{"비속어 단어","스타벅스","바퀴벌레","고양이"}
				,{"1월 1일","5월 28일","6월 1일","12월 25일"}
				,{"불가사리","숯","크림","계란 노른자"}
				};		
	static int[] quiz_Ans= {2,2,2,2,2};
	
	static int[]  cnt =new int[max_quiz_length];
  	
	static void startQuiz(int num) {
		System.out.println("퀴즈를 시작함\n");	
	}
	
	static void getQuiz(int num) {
		if(cnt[num]==0) 
		{
		
		System.out.println("\n\n\n\n\n------문제 "+(num+1)+"번 -------");
		System.out.println(quiz_Database[num]+"\n");
		int n=quiz_Bogi[num].length;
		for(int i=1;i<=n;i++) {
			System.out.println("("+i+")"+quiz_Bogi[num][i-1]);
		}
		System.out.print("\n\n\n\n\n\n\n");
	}
	}
	static void runQuiz(int num) {
		cnt[num]++;userProfile.count++;
		Scanner sc=new Scanner(System.in);

		System.out.println("정답을 입력하세요: ");
		int ans=sc.nextInt();
		if(ans==quiz_Ans[num]) {
			System.out.println("정답입니다 다음 문제로 넘어갑니다 !");
			isCorrect[num]=true;  
		}
		else {
	        userProfile.life--;
			System.out.println("틀렸습니다. 정답을 다시 입력하세요.");
		}
	}
	
			
	static void goNext(int num) {
   //문제 정답인 경우 num을 증가시킨다  
		
		if(life<0) System.out.print("목숨은 음수일 수 없죠.\n당신은 사망하셨습니다.");
	    if(isCorrect[num]==true)userProfile.num++;
	}
  	
	static void getProfile(int num) {
		System.out.println("-------상태판--------");
		System.out.println("\n\n\n시도 횟수:"+count);
		System.out.println("남은 목숨:("+life+"/"+life_max+")\n");
		System.out.println("남은 문제:("+(max_quiz_length-num)+"/"+max_quiz_length+")\n");	
		System.out.println("-------------------");
		
	}
	
	static void getGrade() {
		if(userProfile.life>0)System.out.println("살아 남으셨습니다.\n수고 하셨습니다\n");
		if(userProfile.life>=9)System.out.println("당신의 등급 :A");
		else if(userProfile.life>=7)System.out.println("당신의 등급: B");
		else if(userProfile.life>=5)System.out.println("당신의 등급: C");
		else System.out.println("당신의 등급: F");
	}
	static boolean reGame() {
		Scanner sc=new Scanner(System.in);
		System.out.println("게임을 다시 하시겠습니까?(yes:0)/(no:1)");
		int n=sc.nextInt();
		if(n==0) return false;
		else {
			System.out.println("게임이 종료됩니다.");
			return true;
		}
		
	}
	
	
	static void initialSet() {
		userProfile.num=0;
		userProfile.life=10;
	   userProfile.count=0;
	   for(int i=0;i<max_quiz_length;i++)
		   cnt[i]=0;
			
	}
	public static void main(String[] args) {
        
		while(true) {
	        initialSet();
	        
		   startQuiz(num);
		while(num<max_quiz_length) {
		
			getQuiz(num);	
			runQuiz(num);
			getProfile(num);
			goNext(num);
			if(life<0) break;
		
		}
		System.out.println("다음 문제가 없습니다 \n");
		getGrade();
     
		if(reGame()==true) {
			break;
		}
	}
	}
}