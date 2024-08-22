package net.neocosmic.neolanguagescommon;

import lombok.Getter;
import net.neocosmic.neolanguagescommon.database.Database;

import java.util.function.Consumer;

@Getter
public final class NLCommon {
    @Getter
    private static NLCommon instance;
    private final Database database;

    private NLCommon(String host, String port, String user, String password) {
        instance = this;

        this.database = new Database(
                host,
                port,
                user,
                password
        );
    }

    public static NLCommon init(String host, String port, String user, String password) {
        return new NLCommon(host, port, user, password);
    }
}
