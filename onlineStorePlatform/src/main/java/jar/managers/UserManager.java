package jar.managers;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import jar.user.User;

@Service
public interface UserManager {
	public boolean isRegisterd(User user) throws SQLException;
	public boolean addUser(User user) throws SQLException;
}
