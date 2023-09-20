package dev.mythic.media;

import dev.mythic.media.commands.MediaCommand;
import dev.mythic.media.handler.MediaHandler;
import dev.mythic.media.listener.ChatListener;
import dev.mythic.media.utils.ColorUtil;
import dev.mythic.media.utils.spigui.SpiGUI;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
@Getter
public final class MediaPlugin extends JavaPlugin {


    public SpiGUI spiGUI;
    private MediaHandler mediaHandler;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.spiGUI = new SpiGUI(this);
        this.mediaHandler = new MediaHandler(this);
        this.getCommand("media").setExecutor(new MediaCommand(this));

        Bukkit.getPluginManager().registerEvents(new ChatListener(this), this);
        Bukkit.getConsoleSender().sendMessage(ColorUtil.translate("&4========&c==================&4========"));
        Bukkit.getConsoleSender().sendMessage(ColorUtil.translate("&4&l&nMedia Addon"));
        Bukkit.getConsoleSender().sendMessage(ColorUtil.translate(""));
        Bukkit.getConsoleSender().sendMessage(ColorUtil.translate("&c&l♥ &cAuthor: &fssnowk"));
        Bukkit.getConsoleSender().sendMessage(ColorUtil.translate("&c&l♥ &cVersion: &f"+getDescription().getVersion()));
        Bukkit.getConsoleSender().sendMessage(ColorUtil.translate(""));
        Bukkit.getConsoleSender().sendMessage(ColorUtil.translate("&4========&c==================&4========"));
    }

    @Override
    public void onDisable() {

    }





}
