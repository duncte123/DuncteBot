package ml.duncte123.dunctebot.commands;

import ml.duncte123.dunctebot.Command;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class SetGameCommand implements Command {
	
	private String game = "";

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		
		if(args.length < 1){
			event.getChannel().sendMessage("Not enough args.\nUse `/setgame [game]`").queue();
			return false;
		}
		
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		for(String arg: args){
			this.game += arg + " ";
		}
		event.getJDA().getPresence().setGame(Game.of(game.trim()));
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return "sets the game";
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		if(!success){ return; }
		event.getChannel().sendMessage("Game has been set to `" + game + "`.").queue();
		game = "";
	}

}
