package com.realitycraft;

import com.realitycraft.config.RcConfig;
import net.fabricmc.api.ModInitializer;
import org.slf4.Logger;
import org.slf4.LoggerFactory;

public final class RealityCraft implements ModInitializer {
    public static final String MOD_ID = "realitycraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static RcConfig config;

    @Override
    public void onInitialize() {
        LOGGER.info("RealityCraft RC Core starting");
        config = RcConfig.load();
        LOGGER.info("RealityCraft RC Core ready (Phase 1)");
    }

    public static RcConfig getConfig() {
        return config;
    }
}
