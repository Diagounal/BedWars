package misat11.bw.commands;

import static misat11.lib.lang.I18n.i18n;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import misat11.bw.Main;
import misat11.bw.api.Game;

public class AutojoinCommand extends BaseCommand {
	
	public AutojoinCommand() {
		super("autojoin", null, false);
	}

	@Override
	public boolean execute(CommandSender sender, List<String> args) {
		Player player = (Player) sender;
		if (Main.isPlayerInGame(player)) {
			player.sendMessage(i18n("you_are_already_in_some_game"));
			return true;
		}
		
		Game game = Main.getInstance().getFirstWaitingGame();
		if (game == null) {
			player.sendMessage(i18n("there_is_no_empty_game"));
		} else {
			game.joinToGame(player);
		}
		return true;
	}

	@Override
	public void completeTab(List<String> completion, CommandSender sender, List<String> args) {
		// Nothing to add.
	}

}