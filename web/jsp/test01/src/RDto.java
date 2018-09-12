

public class RDto {

	//방 
	int Rnum;
	String Rid;
	String Roomname;
	String position;
	public RDto(int Rnum, String Rid, String Roomname, String position) 
	{
		this.Rnum = Rnum;
		this.Rid = Rid;
		this.Roomname = Roomname;
	}

	public int getRnum() {
		return Rnum;
	}

	public void setRnum(int rnum) {
		Rnum = rnum;
	}

	public String getRid() {
		return Rid;
	}

	public void setRid(String rid) {
		Rid = rid;
	}

	public String getRoomname() {
		return Roomname;
	}

	public void setRoomname(String roomname) {
		Roomname = roomname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
