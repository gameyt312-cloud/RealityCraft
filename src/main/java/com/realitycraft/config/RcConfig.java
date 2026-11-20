package com.realitycraft.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.realitycraft.RealityCraft;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public final class RcConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public boolean enabled = true;
    public String graphicsPreset = "ULTRA";

    public static RcConfig load() {
        Path configPath = FabricLoader.getInstance().getConfigDir().resolve("realitycraft.json");

        if (Files.exists(configPath)) {
            try {
                return GSON.fromJson(Files.readString(configPath, StandardCharsets.UTF_8), RcConfig.class);
            } catch (Exception exception) {
                RealityCraft.LOGGER.error("Failed to load RealityCraft configuration", exception);
            }
        }

        RcConfig config = new RcConfig();
        config.save();
        return config;
    }

    public void save() {
        Path configPath = FabricLoader.getInstance().getConfigDir().resolve("realitycraft.json");

        try {
            Files.createDirectories(configPath.getParent());
            Files.writeString(configPath, GSON.toJson(this), StandardCharsets.UTF_8);
        } catch (Exception exception) {
            RealityCraft.LOGGER.error("Failed to save RealityCraft configuration", exception);
        }
    }
}
