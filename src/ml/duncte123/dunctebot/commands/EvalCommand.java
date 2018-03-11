package ml.duncte123.dunctebot.commands;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import ml.duncte123.dunctebot.Command;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class EvalCommand implements Command {
	
    private ScriptEngine engine;
    
    @Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		return true;
	}

    @Override
    public void  action(String[] args, MessageReceivedEvent e) {
    	String arguments = "";
    	for(String arg: args){
    		arguments += arg+" ";
    	}
    	
    	engine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            engine.eval("var imports = new JavaImporter(" +
                    "java.io," +
                    "java.lang," +
                    "java.util," +
                    "Packages.net.dv8tion.jda.core," +
                    "Packages.net.dv8tion.jda.core.entities," +
                    "Packages.net.dv8tion.jda.core.entities.impl," +
                    "Packages.net.dv8tion.jda.core.managers," +
                    "Packages.net.dv8tion.jda.core.managers.impl," +
                    "Packages.net.dv8tion.jda.core.utils);");
        }
        catch (ScriptException ex) {
            ex.printStackTrace();
        }

        try {
            engine.put("event", e);
            engine.put("message", e.getMessage());
            engine.put("channel", e.getChannel());
            engine.put("args", args);
            engine.put("jda", e.getJDA());
            if (e.isFromType(ChannelType.TEXT)) {
                engine.put("guild", e.getGuild());
                engine.put("member", e.getMember());
            }

            Object out = engine.eval(
                    "(function() {" +
                        "with (imports) {" +
                            arguments.trim() +
                        "}" +
                    "})();");
            e.getChannel().sendMessage(out == null ? "Executed without error." : out.toString()).queue();
        }
        catch (ScriptException e1)
        {
            e.getChannel().sendMessage(e1.getMessage()).queue();
        }
    }

    @Override
    public String help() {
        return "Takes Java or Javascript and executes it.";
    }


	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		
	}
}
