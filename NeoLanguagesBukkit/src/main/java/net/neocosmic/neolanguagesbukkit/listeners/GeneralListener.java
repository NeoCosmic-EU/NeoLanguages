package net.neocosmic.neolanguagesbukkit.listeners;

import net.neocosmic.neolanguagescommon.NLCommon;
import net.neocosmic.neolanguagescommon.utils.PlayerCache;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import java.util.UUID;

public class GeneralListener implements Listener {

    private final NLCommon instance;

    public GeneralListener(NLCommon instance) {
        this.instance = instance;
    }

    @EventHandler
    public void preLoginEvent(AsyncPlayerPreLoginEvent e) {
        UUID uuid = e.getUniqueId();

        instance.getDatabase().getPlayerLanguage(uuid.toString())
                .whenComplete((language, throwable) -> {
                    if (throwable != null) {
                        throwable.printStackTrace();
                        return;
                    }

                    PlayerCache.setPlayerLanguage(uuid, language, false);
                });
    }

}
