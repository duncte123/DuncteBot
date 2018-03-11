package ml.duncte123.dunctebot;

import java.util.TimerTask;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Listener extends ListenerAdapter {
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event){

		if(event.isFromType(ChannelType.PRIVATE) && !event.getJDA().getSelfUser().getId().equals(event.getAuthor().getId()) ){
			System.out.println("User "+event.getMessage().getAuthor().getName()+"#"+event.getMessage().getAuthor().getDiscriminator()+", tried to do something in the pm-channel.\nThe message is: " + event.getMessage().getContent());
			return;
		}
		if(event.isFromType(ChannelType.PRIVATE)){
			// NO JUST NO, RETURN THAT SHIT
			return;
		}
		
		if(event.getMessage().getContent().equals("/shutdown") && event.getAuthor().getId().equals("191231307290771456")){
			DuncteBot.timer.cancel();
			event.getJDA().shutdown(true);
		}
		if(event.getMessage().getContent().equals("/reload") && event.getAuthor().getId().equals("191231307290771456")){
			DuncteBot.setupCommands();
			System.out.println("[RELOAD] success");
			event.getChannel().sendMessage("success").queue();
		}
		
		if(event.getMessage().getContent().startsWith("/") && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()){
			
			DuncteBot.handleCommand(DuncteBot.parser.parse(event.getMessage().getContent(), event));
			System.out.println("[Command] " + "User "+event.getMessage().getAuthor().getName()+"#"+event.getMessage().getAuthor().getDiscriminator()+" ran command "+ event.getMessage().getContent().toLowerCase().split(" ")[0]);
			return;
		}
		System.out.println("[Message] "+ "Message from user "+event.getMessage().getAuthor().getName()+"#"+event.getMessage().getAuthor().getDiscriminator()+": "+ event.getMessage().getContent());
		
	}
	
	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent event){
		event.getGuild().getPublicChannel().sendMessage("Welcome " + event.getMember().getAsMention() + ".\nNOW LEAVE!!!").queue();
	}
	
	@Override
	public void onReady(ReadyEvent event){
		System.out.println("Logged in as " + event.getJDA().getSelfUser().getName());
		TimerTask myTask = new TimerTask() {
		    @Override
		    public void run() {
		        DuncteBot.updateStatus();
		    }
		};

		DuncteBot.timer.schedule(myTask, 30*1000, 30*1000);
	}

}
