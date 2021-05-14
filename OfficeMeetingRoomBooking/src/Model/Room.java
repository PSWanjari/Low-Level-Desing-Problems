package Model;

import Enums.RoomStatus;

public class Room {
	private int id;
	private String RoomName;
	private RoomStatus status;
	public Room(int id, String roomName, RoomStatus status) {
		super();
		this.id = id;
		RoomName = roomName;
		this.status = status;
	}
	public RoomStatus getStatus() {
		return status;
	}
	public void setStatus(RoomStatus status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setRoomName(String roomName) {
		RoomName = roomName;
	}
	public String getRoomName() {
		return RoomName;
	}
	@Override
	public String toString() {
		return " [id=" + id + ", RoomName=" + RoomName + ", status=" + status + "]";
	}
	
	
}
