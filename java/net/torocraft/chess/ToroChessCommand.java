package net.torocraft.chess;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.torocraft.chess.gen.CheckerBoardGenerator;
import net.torocraft.chess.gen.ChessGameGenerator;

public class ToroChessCommand extends CommandBase {

	@Override
	public String getName() {
		return "torochess";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "commands.chesscreate.usage";
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 2;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		createChessGame(sender);
		//createChessBoard(sender);
	}

	@SuppressWarnings("unused")
	private void createChessBoard(ICommandSender sender) {
		BlockPos pos = sender.getPosition();
		new CheckerBoardGenerator(sender.getEntityWorld(), pos).generate();
	}

	private void createChessGame(ICommandSender sender) {
		BlockPos pos = sender.getPosition();
		new ChessGameGenerator(sender.getEntityWorld(), pos).generate();
	}
	

}
