package tradebot.listeners.commands;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import tradebot.enums.Command;
import tradebot.traderequest.TradeRequest;
import tradebot.traderequest.TradeRequestCache;
import tradebot.utils.TradeUtil;

public class TradeRequestListener implements MessageCreateListener {

	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		if (!event.getMessageAuthor().isBotUser() && event.getMessageContent().startsWith(Command.TRADE_REQUEST.getCommand())) {
			TradeRequest request = TradeUtil.createRequestFromMessage(event.getMessageContent());
			TradeRequestCache.addTradeRequestToCache(request);
			
			new MessageBuilder()
				.setEmbed(new EmbedBuilder()
						.setTitle("Trade Request #" + request.getId() + " created!")
						.addField("\u200B", "\u200B")
						.addField("<@" + request.getTeamAUser() + "> send ", TradeUtil.getOfferListAsString(request.getTeamAOffer()))
						.addField("\u200B", "\u200B")
						.addField("<@" + request.getTeamBUser() + "> send ", TradeUtil.getOfferListAsString(request.getTeamBOffer()))
						.addField("\u200B", "\u200B")
						.setFooter("Reminder! This trade will not be submitted for voting until both teams have agreed to the terms!")
						)
				.send(event.getChannel());
		}
	}
}
