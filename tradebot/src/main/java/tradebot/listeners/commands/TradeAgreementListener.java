package tradebot.listeners.commands;

import java.util.NoSuchElementException;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import com.vdurmont.emoji.EmojiParser;

import tradebot.enums.Channel;
import tradebot.enums.Command;
import tradebot.traderequest.TradeRequest;
import tradebot.traderequest.TradeRequestCache;
import tradebot.utils.TradeUtil;

public class TradeAgreementListener implements MessageCreateListener {

	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		if (!event.getMessage().getAuthor().isBotUser()
				&& event.getMessage().getContent().startsWith(Command.TRADE_AGREEMENT.getCommand())) {
			TradeRequest request = null;
			try {
				request = TradeRequestCache
						.getTradeRequestById(Long.valueOf(event.getMessageContent().substring(6).trim()));
				org.javacord.api.entity.channel.Channel tradeVoteChannel = event.getApi()
						.getChannelById(Channel.BOT_TEST.getChannelId().toString()).get();

				if (request.getTeamBUser().equals(event.getMessageAuthor().getDisplayName())) {
					request.setAgreed(true);
					EmbedBuilder embedTradeRequest = new EmbedBuilder().setTitle("Trade Request #" + request.getId())
							.addField(request.getTeamAUser() + " send ",
									TradeUtil.getOfferListAsString(request.getTeamAOffer()))
							.addField("\u200B", "\u200B").addField(request.getTeamBUser() + " send ",
									TradeUtil.getOfferListAsString(request.getTeamBOffer()));

					tradeVoteChannel.asTextChannel().get()
						.sendMessage(embedTradeRequest)
						.thenAccept(message -> {
							message.addReactions(EmojiParser.parseToUnicode(":thumbsup:"),
												EmojiParser.parseToUnicode(":thumbsdown:"),
												EmojiParser.parseToUnicode(":shrug:"));
							message.addReactionAddListener(new TradeVoteListener());
						});
				}

			} catch (NoSuchElementException nosuchelement) {
				// TODO log something here and eat the command instead of responding, should
				// return and short-circuit execution
			} catch (NumberFormatException numberformat) {
				// TODO log and eat
			}
		}
	}

}
