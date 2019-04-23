package tradebot.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;

import tradebot.bot.TradeBot;


public class Main {

	private static String TRADEBOT_TOKEN = "NTY5NzU0NDI2NTAwMTg2MTIz.XL20yw.KTeEzho3KEaJ_bZno1h5YGP14dU";
	private static DiscordApi api;
	
	static final Logger logger = LogManager.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		FallbackLoggerConfiguration.setDebug(true);
		
		api = new DiscordApiBuilder().setToken(TRADEBOT_TOKEN).login().join();
		
		TradeBot bot = TradeBot.createTradeBot(api);
		

		//Print invite link
		System.out.println("Invite link for TradeBot: " + api.createBotInvite());
	}

}
