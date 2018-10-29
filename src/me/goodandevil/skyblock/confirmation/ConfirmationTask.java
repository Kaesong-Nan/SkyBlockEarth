package me.goodandevil.skyblock.confirmation;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.goodandevil.skyblock.Main;
import me.goodandevil.skyblock.playerdata.PlayerData;
import me.goodandevil.skyblock.playerdata.PlayerDataManager;

public class ConfirmationTask extends BukkitRunnable {

	@Override
	public void run() {
		PlayerDataManager playerDataManager = ((PlayerDataManager) Main.getInstance(Main.Instance.PlayerDataManager));
		
		for (Player all : Bukkit.getOnlinePlayers()) {
			if (playerDataManager.hasPlayerData(all)) {
				PlayerData playerData = playerDataManager.getPlayerData(all);
				
				if (playerData.getConfirmationTime() > 0) {
					playerData.setConfirmationTime(playerData.getConfirmationTime() - 1);
				}
			}
		}
	}
}