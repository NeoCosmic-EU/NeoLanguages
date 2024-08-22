package net.neocosmic.neolanguagesvelocity;

import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.proxy.ProxyServer;
import net.neocosmic.neolanguagescommon.NLCommon;
import net.neocosmic.neolanguagesvelocity.listeners.GeneralListener;

public class NeoLanguagesVelocity {

    private final ProxyServer proxyServer;
    private final String host, port, username, password;

    public NeoLanguagesVelocity(ProxyServer proxyServer, String host, String port, String username, String password) {
        this.proxyServer = proxyServer;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        NLCommon nlCommon = NLCommon.init(
                host, port, username, password
        );

        proxyServer.getEventManager().register(this, new GeneralListener(nlCommon));
    }
}
