package me.Cooper.Portfollio;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by natha_000 on 2/14/2015.
 */
public class Main extends JavaPlugin implements Listener {

    public final Logger logger = Logger.getLogger("Minecraft");
    public void onEnable(){

        PluginDescriptionFile pdf = getDescription();
        getLogger().info(pdf.getName() + " has been enabled!");

    }

    public void openOnlinePlayersMenu(Player p){

        Inventory players = Bukkit.createInventory(null,9, ChatColor.RED + "Online Players");

        for(Player all : Bukkit.getOnlinePlayers()){

            ItemStack heads = new ItemStack(Material.SKULL_ITEM,1,(byte)3);
            SkullMeta headsm = (SkullMeta) heads.getItemMeta();
            String headname = all.getName().toString();
            headsm.setOwner(headname);
            headsm.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + all.getName());
            ArrayList lore = new ArrayList();
            if(all.isOp()){

                lore.add(ChatColor.RED + "Is " + ChatColor.RED + "" + ChatColor.BOLD + "OP!");

            }
            lore.add(ChatColor.AQUA + "----------------------");
            headsm.setLore(lore);
            heads.setItemMeta(headsm);

            players.addItem(heads);
        }

        p.openInventory(players);

    }
    public void openSpecialBlocksMenu(Player p){




    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        Player p = (Player) sender;
        if(commandLabel.equalsIgnoreCase("online")){
            openOnlinePlayersMenu(p);
        }else if(commandLabel.equalsIgnoreCase("specialblocks")){
            ItemStack test = new ItemStack(Material.HUGE_MUSHROOM_1,1);
            p.getInventory().addItem(test);

        }
        return false;
    }

}
