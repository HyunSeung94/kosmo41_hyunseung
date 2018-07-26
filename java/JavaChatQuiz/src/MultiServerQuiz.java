import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class MultiServerQuiz {
	ServerSocket serverSocket = null;
	Socket socket = null;
	Map<String, PrintWriter> clientMap;


	// 생성자
	public MultiServerQuiz() {
		// 클라이언트의 출력스트림을 저장할 해쉬맵 생성
		clientMap = new HashMap<String, PrintWriter>();
		// 해쉬맵 동기화 설정.
		Collections.synchronizedMap(clientMap);
	}

	public void init() {
		try {
			serverSocket = new ServerSocket(9999); // 9999포트로 서버소켓 객체 생성
			System.out.println("서버가 시작되었습니다.");

			while (true) {
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + ":" + socket.getPort());

				Thread msr = new MultiServerT(socket); // 쓰레드 생성.
				msr.start(); // 쓰레드 시동.
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 접속자 리스트 보내기
	public void list(PrintWriter out) {

		// 출력스트림을 순차적으로 얻어와서 해당 메세지를 출력한다.
		Iterator<String> it = clientMap.keySet().iterator();
		String msg = "현재 접속자 [";
		while (it.hasNext()) {
			msg = msg + (String) it.next() + ",";
		}
		msg = msg.substring(0, msg.length() - 1) + "]"; //-1은 , 를 없애기위해서 
		out.println(msg);
	}

	// 귓속말
	public void to(String name, String s) {
		System.out.println("귓속말 발견!!!");
		
		Iterator<String> it = clientMap.keySet().iterator();
				
			StringTokenizer t1 = new StringTokenizer(s);
			int nTmp1 = s.indexOf(" ");
			String strTmp1 = s.substring(nTmp1 + 1);
			t1.nextToken();
			String strTmp2 = t1.nextToken();
			nTmp1 = strTmp1.indexOf(" ");
			String strTmp3 = strTmp1.substring(nTmp1 + 1);
			
//			System.out.println("strTmp1: " + strTmp1);
//			System.out.println("strTmp2: " + strTmp2);
//			System.out.println("strTmp3: " + strTmp3);  출력확인용		
			try {
			 PrintWriter pr = (PrintWriter) clientMap.get(strTmp2); //strTmp2 (귓 받는사람)
			 pr.println(name +" (귓속말): "+strTmp3); // (귓하는사람 + 귓속말 + 내용)
			 }catch(Exception e) {
			 System.out.println("귓속말을 할수가 없습니다."+e);
			 }

		

	}

	// 접속된 모든 클라이언트들에게 메세지를 전달
	public void sendAllMsg(String user, String msg) {

		// 출력스트림을 순차적으로 얻어와서 해당 메세지를 출력한다.
		Iterator<String> it = clientMap.keySet().iterator();

		while (it.hasNext()) {
			try {
				PrintWriter it_out = (PrintWriter) clientMap.get(it.next());
				if (user.equals(" "))
					it_out.println(msg);
				else
					it_out.println("[" + user + "]" + msg);
			} catch (Exception e) {
				System.out.println("예외:" + e);
			}
		}
	}
	
	public void sendMsg( String user, String msg,String A) {
		System.out.println("귓속말 발견!!!");
		Iterator<String> it = clientMap.keySet().iterator();
		

//		int nTmp1 = msg.indexOf(" ");
//		String strTmp1 = msg.substring(nTmp1 + 1);
//		System.out.println(strTmp1);
//		System.out.println(user);


		if(!msg.equals("//to")) {
			try {
				PrintWriter it_out = (PrintWriter) clientMap.get(A);
					it_out.println(user + "(고정 귓속말): " + msg);
			} catch (Exception e) {
				System.out.println("예외:" + e);
			}
		}
		

		   
	}

	public static void main(String[] args) {
		// 서버 객체생성
		MultiServerQuiz ms = new MultiServerQuiz();
		ms.init();

	}

	//////////////////////////////////////////////////////////////////////////
	// 내부 클래스
	// 클라이언트로부터 읽어온 메시지를 다른 클라이언트(socket)에 보내는 역할을 하는 메서드
	class MultiServerT extends Thread {
		Socket socket;
		PrintWriter out = null;
		BufferedReader in = null;

		// 생성자.
		public MultiServerT(Socket socket) {
			this.socket = socket;
			try {
				out = new PrintWriter(socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (Exception e) {
				System.out.println("예외:" + e);
			}
		}

		// 쓰레드를 사용하기 위해서 run()메서드 재정의

		@Override
		public void run() {
			String name = ""; // 클라이언트로부터 받은 이름을 저장할 변수
			try {
				name = in.readLine(); // 클라이언트에서 처음으로 보내는 메세지는
										// 클라이언트가 사용할 이름이다.

				sendAllMsg("", name + "님이 입장하셨습니다.");
				// 현재 객체가 가지고있는 소켓을 제외하고 다른 소켓(클라이언트)들에게 접속을 알림.
				clientMap.put(name, out); // 해쉬맵에서 키를 name으로 출력 스트림 객체를 저장.
				System.out.println("현재 접속자 수는 " + clientMap.size() + "명 입니다.");

				// 입력스트림이 null이 아니면 반복

				String s = "";
				while (in != null) {
					s = in.readLine();

					if (s.indexOf("/r") >= 0) {
						to(name,s);
					}
					else if(s.indexOf("/to")>= 0){				
						int nTmp1 = s.indexOf(" ");
						String strTmp1 = s.substring(nTmp1 + 1);
						String A = strTmp1;
						while(!s.equals("//to")) {
							
						s = in.readLine();
						sendMsg(name,s,A);
					   }
					} else if (s.equals("/list")) {
						list(out);
					} else if (s.equals("q") || s.equals("Q")) {
						break;
					} else {
						System.out.println("[" + name + "]" + s);
						sendAllMsg(name, s);
					}

				}

				// System.out.println("Bye....");
			} catch (Exception e) {
				System.out.println("예외:" + e);
			} finally {
				// 예외가 발생할때 퇴장. 해쉬맵에서 해당 데이터 제거
				// 보통 종료하거나 나가면 java.net.SocketException: 예외발생
				clientMap.remove(name);
				sendAllMsg("", "[" + name + "]" + "님이 퇴장하셨습니다.");
				System.out.println("현재 접속자 수는 " + clientMap.size() + "명 입니다.");
				try {
					in.close();
					out.close();
					socket.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
}
