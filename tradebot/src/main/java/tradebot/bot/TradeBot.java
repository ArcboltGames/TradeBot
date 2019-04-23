package tradebot.bot;

import org.javacord.api.DiscordApi;

import tradebot.listeners.commands.TradeAgreementListener;
import tradebot.listeners.commands.TradeRequestListener;
import tradebot.utils.TradeUtil;

public class TradeBot {
	private DiscordApi api;
	
	private TradeBot(DiscordApi api) {
		this.api = api;
	}
	
	public static TradeBot createTradeBot(DiscordApi api) {
		TradeBot bot = new TradeBot(api);
		
		TradeUtil.updateCurrentSeed();
		
		bot.setupCommandListeners();
		
		bot.setupHelperListeners();
		
		return bot;
	}
	
	private void setupCommandListeners() {
		api.addMessageCreateListener(new TradeRequestListener());
		api.addMessageCreateListener(new TradeAgreementListener());
	}
	
	private void setupHelperListeners() {
		
	}

}
