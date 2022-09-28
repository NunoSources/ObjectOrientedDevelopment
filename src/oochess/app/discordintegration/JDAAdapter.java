package oochess.app.discordintegration;

import com.chavetasfechadas.JDAMock;
import com.chavetasfechadas.JDAMockBuilder;

public class JDAAdapter implements MsgSenderMethod{

	@Override
	public void sendMessage(String username, String message) {
		JDAMockBuilder jda = new JDAMockBuilder();
		JDAMock jdaSend = jda.build();
		jdaSend.sendMessage(username, message);
	}
	
}
