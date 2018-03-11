package ml.duncte123.dunctebot.commands;

import ml.duncte123.dunctebot.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class PingCommand implements Command {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		event.getChannel().sendMessage("pong").queue();
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return "Pong";
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		return;
	}

}
