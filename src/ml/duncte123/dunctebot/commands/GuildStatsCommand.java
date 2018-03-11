package ml.duncte123.dunctebot.commands;

import java.awt.Color;

import ml.duncte123.dunctebot.Command;
import ml.duncte123.dunctebot.DuncteBot;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class GuildStatsCommand implements Command {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		event.getChannel().sendMessage((new EmbedBuilder())
				.addField("Guild Owner", event.getGuild().getOwner().getEffectiveName(), false)
				.addField("Total Members", event.getGuild().getMembers().size() + "", false)
				.addField("Verification Level", DuncteBot.verificationLvlToName(event.getGuild().getVerificationLevel()), false)
				.addField("Guild Name", event.getGuild().getName(), false)
				.addField("Guild Creation Time", event.getGuild().getCreationTime() + "", false)
				.addField("Guild Region", event.getGuild().getRegion().getName(), false)
				.setThumbnail(event.getGuild().getIconUrl())
				.setColor(Color.red)
				.build()).queue();
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return "Show some stats";
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		return;
	}

}
