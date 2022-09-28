package oochess.app.discordintegration;

import net.padroesfactory.Channel;
import net.padroesfactory.Discord4JMock;

public class Discord4JAdapter implements MsgSenderMethod{

	@Override
	public void sendMessage(String username, String message) {
		String token = MyConfiguration.getString("DISCORD_TOKEN");
		Discord4JMock disc = new Discord4JMock(token);
		Channel ch = disc.getChannel(username);
		ch.sendMessage(message);
	}

}
