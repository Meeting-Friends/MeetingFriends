package meet.service;

import java.util.List;

import meet.model.domain.dto.Room;

public interface RoomService {

	List<Room> getMemberList();

	void insertRoom(Room room);

	Room getRoom(String id);

	void updateRoom(Room room);

	void deleteRoom(Room room);
}
