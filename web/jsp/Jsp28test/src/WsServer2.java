
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

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
	int checkin = 0; // 체크인 ==1 이면 공지 1이아니면 all메세지 
	int order = 0; // 명령문
	int to = 0; // 귓속말 고정
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DataSource dataSource = null;

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

	public int msgCheck(String msg) {

		if (msg.contains("시발") || msg.contains("병신") || msg.contains("멍청이") || msg.contains("프로젝트좋아")) {
			System.out.println("금칙어를 사용하신분이있습니다.");
			return 1;
		} else {
			return 2;
		}

	}
	
	public void sendMsg(Session session, String msg, String toname) {
		System.out.println("귓속말 발견!!!");
		Iterator<String> it = clientMap.keySet().iterator();

		try {
			Session pr = (Session) clientMap.get(toname);// toname (귓 받는사람)
			pr.getBasicRemote().sendText(ID + "(귓속말): " + msg); // (귓하는사람 + 귓속말 + 내용)

		} catch (Exception e) {
			System.out.println("예외:" + e);
		}
	}

	public void Dblogin(String ID) {

		try {
			String sql = "insert into chat (id,room) values(?,?)";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);
			pstmt.setString(2, "waitingroom");
			pstmt.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public void Dblogout(String ID) {

		try {
			String sql = "delete from chat where id = ? ";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);
			pstmt.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	@OnOpen
	public void onOpen(Session session) {
		System.out.println("Open session id: " + session.getId());

		try {
			// lookup 함수의 파라메터는 context.xml에 설정된
			// name(jdbc/Oracle11g)과 동일해야 한다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			// 접속 정보만 가지고 있음
		} catch (Exception e) {
			e.printStackTrace();
		}

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
			Dblogout(ID);
			sendAllSessionToMessage(session, ID + "님이 퇴장하셨습니다.");
			clientMap.remove(ID, session);
			checkin--;
		}
		sessions.remove(session);

	}

	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("checkin: " + checkin);
		System.out.println("order: "+order);
		if (checkin == 0) {

			StringTokenizer t1 = new StringTokenizer(message);
			ID = t1.nextToken(); // 아이디
			System.out.println("아이디: " + ID);
			check = t1.nextToken(); // 아이디 : 메세지
			System.out.println("아이디메세지 나눔: " + check);
			int nTmp1 = message.indexOf(" ");
			String strTmp = message.substring(nTmp1 + 1);
			System.out.println("1" + strTmp);
			nTmp1 = strTmp.indexOf(" ");
			strTmp = strTmp.substring(nTmp1 + 1);
			System.out.println("2" + strTmp);
			msg = strTmp;
			System.out.println("메세지: " + msg);
			System.out.println("Message from " + session.getId() + " : " + message);


			System.out.println("너왜안타니1 ");
			if (msg.indexOf("/") >= 0) {
				order++;
			}

			/*------명령어-------명령어------명령어-------명령어------명령어-------명령어------명령어-------명령어------명령어-------명령어*/

			// System.out.println("너왜안타니2 ");
			if (msg.equals("/alllist")) {
				list(session, msg);
				// System.out.println("너왜안타니3 ");
			} else if (msg.indexOf("/w") >= 0) {
				to(session, message);
				// System.out.println("너왜안타니4 ");
			} else if (msg.indexOf("/to") >= 0) {
				// System.out.println("너왜안타니6 ");
				int count = 0;
				to++;
				for (int i = 0; i < msg.length(); i++) {
					if (msg.substring(i, i + 1).equals(" ")) {
						count++;
					}
				}
				if (count == 1) {
					StringTokenizer t2 = new StringTokenizer(msg);
					t2.nextToken();
					toname = t2.nextToken();
				}
			} else if (to % 2 != 0) {
				order++;
				sendMsg(session, msg, toname);
			}

			// System.out.println("너왜안타니5 ");

		}

		// 메세지 출력
		if (order == 0) {

			 if (checkin != 1) {
				 if(msgCheck(msg) == 1) {
					 checkin++;
					 sendAllSessionToMessage(session, ID + "님이 금칙어를 사용했습니다.");
					 checkin=0;
				 } else {
				sendAllSessionToMessage(session, message);
				 }
			} else if (checkin == 1) {
				StringTokenizer t1 = new StringTokenizer(message);
				ID = t1.nextToken(); // 아이디
				System.out.println("아이디: " + ID);
				Dblogin(ID);
				System.out.println("666");
				sendAllSessionToMessage(session, ID + "님이 입장하셨습니다.");
				clientMap.put(ID, session);
				checkin--;
			}

		}
		order = 0;

		try {
			final Basic basic = session.getBasicRemote();
			basic.sendText("to : " + message);
		} catch (IOException ex) {
			System.out.println("오류1");
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
