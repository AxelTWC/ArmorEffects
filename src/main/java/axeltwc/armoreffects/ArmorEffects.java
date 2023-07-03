package axeltwc.armoreffects;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import com.destroystokyo.paper.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArmorEffects extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onArmorChange(PlayerArmorChangeEvent event) {
        Player player = event.getPlayer();
        checkArmor(player);
    }
    private void checkArmor(Player player) {
        // Check if the player is wearing full leather armor
        if (isWearingFullLeatherArmor(player)) {
            // Give the player effects with infinite duration
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
        } else {
            // Remove the effects
            player.removePotionEffect(PotionEffectType.SPEED);
            player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
        }
        // Check if the player is wearing full Chain armor
        if (isWearingFullChainArmor(player)) {
            // Give the player effects with infinite duration
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, Integer.MAX_VALUE, 1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 0));
        } else {
            // Remove the effects
            player.removePotionEffect(PotionEffectType.REGENERATION);
            player.removePotionEffect(PotionEffectType.ABSORPTION);
            player.removePotionEffect(PotionEffectType.WATER_BREATHING);
        }
        // Check if the player is wearing full Gold armor
        if (isWearingFullGoldArmor(player)) {
            // Give the player effects with infinite duration
            player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 4));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 0));
        } else {
            // Remove the effects
            player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
            player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
        }
        // Check if the player is wearing full Iron armor
        if (isWearingFullIronArmor(player)) {
            // Give the player effects with infinite duration
            player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 0));
        } else {
            // Remove the effects
            player.removePotionEffect(PotionEffectType.FAST_DIGGING);
        }
    }
    private boolean isWearingFullLeatherArmor(Player player) {
        // Check if the player is wearing full leather armor
        return player.getInventory().getHelmet() != null && player.getInventory().getChestplate() != null &&
                player.getInventory().getLeggings() != null && player.getInventory().getBoots() != null &&
                player.getInventory().getHelmet().getType() == Material.LEATHER_HELMET &&
                player.getInventory().getChestplate().getType() == Material.LEATHER_CHESTPLATE &&
                player.getInventory().getLeggings().getType() == Material.LEATHER_LEGGINGS &&
                player.getInventory().getBoots().getType() == Material.LEATHER_BOOTS;
    }
    private boolean isWearingFullChainArmor(Player player) {
        // Check if the player is wearing full Chain armor
        return player.getInventory().getHelmet() != null && player.getInventory().getChestplate() != null &&
                player.getInventory().getLeggings() != null && player.getInventory().getBoots() != null &&
                player.getInventory().getHelmet().getType() == Material.CHAINMAIL_HELMET &&
                player.getInventory().getChestplate().getType() == Material.CHAINMAIL_CHESTPLATE &&
                player.getInventory().getLeggings().getType() == Material.CHAINMAIL_LEGGINGS &&
                player.getInventory().getBoots().getType() == Material.CHAINMAIL_BOOTS;
    }
    private boolean isWearingFullGoldArmor(Player player) {
        // Check if the player is wearing full Gold armor
        return player.getInventory().getHelmet() != null && player.getInventory().getChestplate() != null &&
                player.getInventory().getLeggings() != null && player.getInventory().getBoots() != null &&
                player.getInventory().getHelmet().getType() == Material.GOLDEN_HELMET &&
                player.getInventory().getChestplate().getType() == Material.GOLDEN_CHESTPLATE &&
                player.getInventory().getLeggings().getType() == Material.GOLDEN_LEGGINGS &&
                player.getInventory().getBoots().getType() == Material.GOLDEN_BOOTS;
    }
    private boolean isWearingFullIronArmor(Player player) {
        // Check if the player is wearing full Iron armor
        return player.getInventory().getHelmet() != null && player.getInventory().getChestplate() != null &&
                player.getInventory().getLeggings() != null && player.getInventory().getBoots() != null &&
                player.getInventory().getHelmet().getType() == Material.IRON_HELMET &&
                player.getInventory().getChestplate().getType() == Material.IRON_CHESTPLATE &&
                player.getInventory().getLeggings().getType() == Material.IRON_LEGGINGS &&
                player.getInventory().getBoots().getType() == Material.IRON_BOOTS;
    }
}
