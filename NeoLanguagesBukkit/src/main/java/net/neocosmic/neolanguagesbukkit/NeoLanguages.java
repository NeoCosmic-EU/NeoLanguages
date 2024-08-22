package net.neocosmic.neolanguagesbukkit;

import lombok.Getter;
import net.neocosmic.neolanguagesbukkit.listeners.GeneralListener;
import net.neocosmic.neolanguagescommon.NLCommon;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class NeoLanguages {

    @Getter
    private static NLCommon instance;


    private NeoLanguages(JavaPlugin javaPlugin, String host, String port, String user, String password) {
        instance = NLCommon.init(host, port, user, password);

        Bukkit.getPluginManager().registerEvents(new GeneralListener(instance), javaPlugin);
    }

}
