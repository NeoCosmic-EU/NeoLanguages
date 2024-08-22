package net.neocosmic.neolanguagescommon.repository;


import net.neocosmic.neolanguagescommon.language.PlayerLanguage;
import net.neocosmic.neolanguagescommon.utils.PlayerCache;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

//                                       The message key enum
public abstract class MessagesRepository<T extends Enum<?>> {

    private final HashMap<T, HashMap<PlayerLanguage, String>> messages = new HashMap<>();
    private final HashMap<T, HashMap<PlayerLanguage, List<String>>> listMessages = new HashMap<>();

    protected void addMessage(PlayerLanguage language, T key, String message) {
        messages.computeIfAbsent(key, k -> new HashMap<>()).put(language, message);
    }

    protected void addListMessage(PlayerLanguage language, T key, List<String> message) {
        if (message.size() == 1) {
            addMessage(language, key, message.get(0));
            return;
        }

        listMessages.computeIfAbsent(key, k -> new HashMap<>()).put(language, message);
    }

    public String getMessage(PlayerLanguage language, T key) {
        return messages.get(key).get(language);
    }

    public List<String> getListMessage(PlayerLanguage language, T key) {
        return listMessages.get(key).get(language);
    }

    public String getMessage(UUID uuid, T key) {
        return getMessage(PlayerCache.getPlayerLanguage(uuid), key);
    }

    public List<String> getListMessage(UUID uuid, T key) {
        return getListMessage(PlayerCache.getPlayerLanguage(uuid), key);
    }

}
