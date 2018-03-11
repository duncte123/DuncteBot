package ml.duncte123.dunctebot;

import java.util.HashMap;
import java.util.Timer;

import ml.duncte123.dunctebot.commands.HelpCommand;
import ml.duncte123.dunctebot.commands.PayPalCommand;
import ml.duncte123.dunctebot.commands.PingCommand;
import ml.duncte123.dunctebot.commands.SetGameCommand;
import ml.duncte123.dunctebot.commands.UserStatsCommand;
import ml.duncte123.dunctebot.commands.GuildStatsCommand;
import ml.duncte123.dunctebot.utils.CommandParser;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Guild.VerificationLevel;

public class DuncteBot {
	
	public static JDA jda;
	public static final CommandParser parser = new CommandParser();
	public static HashMap<String, Command> commands = new HashMap<String, Command>();
	
	public static Timer timer = new Timer();
	
	public static String[] messages = {
			"#HYPESQUAD",
			"use /help"
	};
	public static int messageIndex = 0;
	
	public static void main(String[] args){
		
		try{
			jda = new JDABuilder(AccountType.BOT)
					.setAudioEnabled(false)
					.addEventListener(new Listener())
					.setToken("MjEwMzYzMTExNzI5NzkwOTc3.C3oSIA.b1i3o41B3cj7JQ8tPOqbyF8P26Y")
					.setGame(Game.of(messages[messageIndex]))
					.buildBlocking();
			jda.setAutoReconnect(true);
			setupCommands();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void updateStatus(){
		messageIndex++;
		if(messageIndex == messages.length){
			messageIndex = 0;
		}
		jda.getPresence().setGame(Game.of(messages[messageIndex]));
	}
	
	public static void setupCommands(){
		commands.clear();
		commands.put("ping", new PingCommand());
		commands.put("guild", new GuildStatsCommand());
		commands.put("help", new HelpCommand());
		commands.put("setgame", new SetGameCommand());
		commands.put("stats", new UserStatsCommand());
		commands.put("donate", new PayPalCommand());
	}
	
	public static void handleCommand(CommandParser.CommandContainer cmd){
		if(commands.containsKey(cmd.invoke)){
			boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);
			
			if(!safe){
				commands.get(cmd.invoke).executed(safe, cmd.event);
				return;
			}
			commands.get(cmd.invoke).action(cmd.args, cmd.event);
			commands.get(cmd.invoke).executed(safe, cmd.event);
		}
	}
	
	public static String verificationLvlToName(VerificationLevel lvl){
		if(lvl.equals(VerificationLevel.NONE)){
			return "none";
		}else if(lvl.equals(VerificationLevel.LOW)){
			return "Low";
		}else if(lvl.equals(VerificationLevel.MEDIUM)){
			return "Medium";
		}else if(lvl.equals(VerificationLevel.HIGH)){
			return "(╯°□°）╯︵ ┻━┻";
		}else if(lvl.equals(VerificationLevel.VERY_HIGH)){
			return "┻━┻彡 ヽ(ಠ益ಠ)ノ彡┻━┻";
		} 
		return "none";
	}
}
