package ml.duncte123.dunctebot.commands;

import java.awt.Color;

import ml.duncte123.dunctebot.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class UserStatsCommand implements Command {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		return (!event.getAuthor().isFake());
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		User u = event.getAuthor();
		for(String arg: args){
			if(args.length > 0 && !(arg.contains("@everyone") || arg.contains("@everyone"))){
				u = event.getMessage().getMentionedUsers().get(0);
			}
		}
		// TODO Auto-generated method stub
		EmbedBuilder eb = new EmbedBuilder().setDescription("User Data for _**" + u.getName() + "**_")
				.setColor(Color.RED)
				.addField("Username + Discriminator", u.getName()+"#"+u.getDiscriminator(), false);
		
		event.getChannel().sendMessage(eb.build()).queue();
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		// TODO Auto-generated method stub

	}

}
