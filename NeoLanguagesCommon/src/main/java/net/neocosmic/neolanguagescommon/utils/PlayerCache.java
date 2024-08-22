package net.neocosmic.neolanguagescommon.utils;

import lombok.experimental.UtilityClass;
import net.neocosmic.neolanguagescommon.NLCommon;
import net.neocosmic.neolanguagescommon.language.PlayerLanguage;

import java.util.HashMap;
import java.util.UUID;

@UtilityClass
public class PlayerCache {

    public final HashMap<UUID, PlayerLanguage> playerLanguages = new HashMap<>();

    public PlayerLanguage getPlayerLanguage(UUID player) {
        if (!playerLanguages.containsKey(player)) {
            playerLanguages.put(player, PlayerLanguage.getDefault());
        }

        return playerLanguages.get(player);
    }

    public void setPlayerLanguage(UUID player, PlayerLanguage language, boolean shouldUpdateIntoDB) {
        playerLanguages.put(player, language);

        if (shouldUpdateIntoDB) {
            NLCommon.getInstance().getDatabase().setPlayerLanguage(player.toString(), language);
        }
    }

}
