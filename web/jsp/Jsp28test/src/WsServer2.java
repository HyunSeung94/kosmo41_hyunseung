
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Scanner;

/*
 * sessions가 각 호출 시 마다 생성되므로 static으로 정해 줘야 한다.
 * 브라우져가 websocket을 지원해야 한다.
 * 웹 소켓 연결 후 별도 close 동작 없이 브라우져를 닫을 경우 자동으로 onClose가 호출 된다.
 * 
 */
@ServerEndpoint("/websocketendpoint2")
public class WsServer2 {

	private static final java.util.Set<Session> sessions = java.util.Collections
			.synchronizedSet(new java.util.HashSet<Session>());
	private static final java.util.Map<String, Session> clientMap = java.util.Collections
			.synchronizedMap(new java.util.HashMap<String, Session>());

	String ID, msg, check;
	String toname;
	int checkin = 0; // 접속자 알림
	int order = 0; // 명령문
	int to = 0; // 귓속말 고정

	public void list(Session session, String message) {
		Iterator<String> it = clientMap.keySet().iterator();
		String msg = "현재 전체 접속자 [";
		while (it.hasNext()) {
			msg = msg + (String) it.next() + ",";
		}
		msg = msg.substring(0, msg.length() - 1) + "]"; // -1은 , 를 없애기위해서
		System.out.println(msg);
		try {
			final Basic basic = session.getBasicRemote();
			basic.sendText(msg);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public void to(Session session, String message) {
		String toname, tomsg;

		Iterator<String> it = clientMap.keySet().iterator();

		StringTokenizer t1 = new StringTokenizer(message);
		ID = t1.nextToken(); // 내아이디
		System.out.println("아이디: " + ID);
		check = t1.nextToken(); // 아이디 : 메세지
		System.out.println("아이디메세지 나눔: " + check);
		msg = t1.nextToken(); // 메세지
		System.out.println("메세지: " + msg);
		toname = t1.nextToken(); // 받는사람
		System.out.println("메세지: " + msg);
		tomsg = t1.nextToken();
		System.out.println("귓속말 메세지: " + msg + "아이디: " + ID + "받는사람: " + toname);

		try {
			Session pr = (Session) clientMap.get(toname);// toname (귓 받는사람)
			pr.getBasicRemote().sendText(ID + "(귓속말): " + tomsg); // (귓하는사람 + 귓속말 + 내용)

		} catch (Exception e) {
			System.out.println("귓속말을 할수가 없습니다." + e);
		}

	}

	public void sendMsg(Session session, String message, String toname) {
		System.out.println("귓속말 발견!!!");
		Iterator<String> it = clientMap.keySet().iterator();
		StringTokenizer t1 = new StringTokenizer(message);

		try {
			Session pr = (Session) clientMap.get(toname);// toname (귓 받는사람)
			pr.getBasicRemote().sendText(ID + "(귓속말): " + message); // (귓하는사람 + 귓속말 + 내용)

		} catch (Exception e) {
			System.out.println("예외:" + e);
		}
	}

	@OnOpen
	public void onOpen(Session session) {
		System.out.println("Open session id: " + session.getId());

		try {
			final Basic basic = session.getBasicRemote();
			basic.sendText("0 Connection Established");
			checkin++;

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		sessions.add(session);

	}

	@OnClose
	public void onClose(Session session) {
		System.out.println("Session " + session.getId() + " has ended");
		checkin++;
		if (checkin == 1) {
			sendAllSessionToMessage(session, ID + "님이 퇴장하셨습니다.");
			clientMap.remove(ID, session);
			checkin--;
		}
		sessions.remove(session);

	}

	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("checkin: " + checkin);

		if (checkin == 0) {

			StringTokenizer t1 = new StringTokenizer(message);
			ID = t1.nextToken(); // 아이디
			System.out.println("아이디: " + ID);
			check = t1.nextToken(); // 아이디 : 메세지
			System.out.println("아이디메세지 나눔: " + check);
			msg = t1.nextToken(); // 메세지
			System.out.println("메세지: " + msg);
			System.out.println("Message from " + session.getId() + " : " + message);

			if (msg.charAt(0) == '/') {
				order++;
			}

			/*------명령어-------명령어------명령어-------명령어------명령어-------명령어------명령어-------명령어------명령어-------명령어*/

			if (msg.equals("/alllist")) {
				list(session, msg);

			} else if (msg.equals("/w")) {
				to(session, message);
			} else if (msg.equals("/to")) {
				int count = 0;
				for (int i = 0; i < message.length(); i++) {
					if (message.substring(i, i + 1).equals(" ")) {
						count++;
					}
				}
			}

			if (to % 2 != 0) {
				message = "/to" + toname + msg;
				sendMsg(session, message, toname);
			}
			// else if () {
			//
			// }

		}

		if (order == 0) {

			if (checkin != 1) {
				sendAllSessionToMessage(session, message);
			} else if (checkin == 1) {
				StringTokenizer t1 = new StringTokenizer(message);
				ID = t1.nextToken(); // 아이디
				System.out.println("아이디: " + ID);
				sendAllSessionToMessage(session, ID + "님이 입장하셨습니다.");
				clientMap.put(ID, session);
				checkin--;
			}
			order = 0;
		}

		try {
			final Basic basic = session.getBasicRemote();
			basic.sendText("to : " + message);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	/*
	 * 모든 사용자에게 메시지를 전달한다.
	 */

	private void sendAllSessionToMessage(Session self, String message) {
		try {
			for (Session session : WsServer2.sessions) {
				if (!self.getId().equals(session.getId()))

					if (checkin != 1) {
						session.getBasicRemote().sendText("All : " + message);
					} else if (checkin == 1) {
						session.getBasicRemote().sendText("공지: " + message);
					}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OnError
	public void onError(Throwable e, Session session) {
	}

}
