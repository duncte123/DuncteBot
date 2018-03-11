package ml.duncte123.dunctebot.commands;

import java.awt.Color;

import ml.duncte123.dunctebot.Command;
import ml.duncte123.dunctebot.DuncteBot;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HelpCommand implements Command {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		EmbedBuilder eb = new EmbedBuilder()
				.setColor(Color.RED)
				.setTitle("My Commands")
				.addBlankField(false);
		for(String cmd: DuncteBot.commands.keySet()){
			if(!DuncteBot.commands.get(cmd).help().equals(null) || !DuncteBot.commands.get(cmd).help().equals("")){
				eb.addField("/"+cmd, DuncteBot.commands.get(cmd).help(), false);
			}
		}
		event.getChannel().sendMessage(eb.build()).queue();
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return "Shows you the help";
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		return;
	}

}
