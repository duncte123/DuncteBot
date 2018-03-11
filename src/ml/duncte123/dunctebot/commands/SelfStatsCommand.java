package ml.duncte123.dunctebot.commands;

import java.awt.Color;

import ml.duncte123.dunctebot.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDAInfo;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class SelfStatsCommand implements Command {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		User u = event.getJDA().getSelfUser();
		EmbedBuilder eb = new EmbedBuilder().setDescription("Some stats about me")
				.setColor(Color.RED)
				.addField("Username + Discriminator", u.getName() + "#" + u.getDiscriminator(), false)
				.addField("Lib Version", "JDA: " + JDAInfo.VERSION, false);
		
		event.getChannel().sendMessage(eb.build()).queue();

	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return "Shows some stats about me.";
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		// TODO Auto-generated method stub

	}

}
