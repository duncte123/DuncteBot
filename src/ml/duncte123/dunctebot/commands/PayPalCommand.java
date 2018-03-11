package ml.duncte123.dunctebot.commands;

import ml.duncte123.dunctebot.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class PayPalCommand implements Command {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		if(args.length < 1){
			event.getChannel().sendMessage("not enough args.\nUsage: `/donate (ammount)`").queue();
			return false;
		}
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		String ammountString = "";
		for(String arg: args){
			ammountString += arg;
		}
		event.getChannel().sendMessage("Here's the link to donate to me.\nhttps://paypal.me/duncte123/" + ammountString).queue();

	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return "Generates a paypal.me link";
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		// TODO Auto-generated method stub

	}

}
