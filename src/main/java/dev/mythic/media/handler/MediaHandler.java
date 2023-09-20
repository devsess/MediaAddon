package dev.mythic.media.handler;

import dev.mythic.media.MediaPlugin;
import dev.mythic.media.menu.MediaMenu;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Getter
public class MediaHandler {

    private final Map<UUID, String> urls;

    private final MediaPlugin plugin;

    private final Map<UUID, String> variant;

    private final MediaMenu mediaMenu;

    public MediaHandler(MediaPlugin plugin){
        this.plugin = plugin;
        this.urls = new HashMap<>();
        this.variant = new HashMap<>();
        this.mediaMenu = new MediaMenu(plugin);
    }
}
