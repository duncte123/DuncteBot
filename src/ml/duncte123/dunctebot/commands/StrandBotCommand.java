package ml.duncte123.dunctebot.commands;

import ml.duncte123.dunctebot.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class StrandBotCommand implements Command {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		event.getChannel().sendMessage("+8ball did Connor make you?").queue();
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return "Does Something";
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		return;
	}

}
