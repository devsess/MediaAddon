package dev.mythic.media.listener;

import dev.mythic.media.MediaPlugin;
import dev.mythic.media.utils.ColorUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class ChatListener implements Listener {

    private final MediaPlugin plugin;

    public ChatListener(MediaPlugin plugin){
        this.plugin = plugin;
    }


    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();
        String message = e.getMessage();
        boolean url_checker = false;

        if(player.hasMetadata("newURL")){
            e.setCancelled(true);

            if (message.equals("CANCEL")){
                player.removeMetadata("newURL", plugin);
                plugin.getMediaHandler().getMediaMenu().selectionMenu(player);
                plugin.getMediaHandler().getVariant().remove(player.getUniqueId());
                return;
            }

            for (String startWith : plugin.getConfig().getStringList("URL_CHECKER.URLS")){

                if (message.startsWith(startWith)){
                    url_checker = true;
                    break;
                }
            }

            if (url_checker){
                player.removeMetadata("newURL", plugin);
                plugin.getMediaHandler().getMediaMenu().confirmMenu(player);
                plugin.getMediaHandler().getUrls().put(player.getUniqueId(), message);
            }else {
                player.sendMessage(ColorUtil.translate(plugin.getConfig().getString("URL_CHECKER.ERROR")));
            }
        }
    }
}
