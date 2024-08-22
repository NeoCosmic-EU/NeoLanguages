package net.neocosmic.neolanguagesvelocity.listeners;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.LoginEvent;
import com.velocitypowered.api.proxy.Player;
import lombok.RequiredArgsConstructor;
import net.neocosmic.neolanguagescommon.NLCommon;
import net.neocosmic.neolanguagescommon.utils.PlayerCache;

import java.util.UUID;


@RequiredArgsConstructor
public class GeneralListener {

    private final NLCommon instance;

    @Subscribe
    public void onPlayerPreLogin(LoginEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();

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
