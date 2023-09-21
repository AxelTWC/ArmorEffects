package axeltwc.armoreffects;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
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
            ItemStack helmet = new ItemStack(Material.LEATHER_HELMET,1);
            LeatherArmorMeta meta = (LeatherArmorMeta) helmet.getItemMeta();
            if(isWearingCustomArmor(player) == false){

                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1728000, 2));
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1728000, 0));
            }
            else{
                player.removePotionEffect(PotionEffectType.SPEED);
                player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
            }
        } else {
            // Remove the effects
            player.removePotionEffect(PotionEffectType.SPEED);
            player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
        }
        // Check if the player is wearing full Chain armor
        if (isWearingFullChainArmor(player)) {
            // Give the player effects with infinite duration
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1728000, 0));
            player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 1728000, 0));
        } else {
            // Remove the effects
            player.removePotionEffect(PotionEffectType.REGENERATION);
            player.removePotionEffect(PotionEffectType.WATER_BREATHING);
        }
        // Check if the player is wearing full Gold armor
        if (isWearingFullGoldArmor(player)) {
            // Give the player effects with infinite duration
            player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1728000, 4));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1728000, 0));
        } else {
            // Remove the effects
            player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
            player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
        }
        // Check if the player is wearing full Iron armor
        if (isWearingFullIronArmor(player)) {
            // Give the player effects with infinite duration
            player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1728000, 0));
        } else {
            // Remove the effects
            player.removePotionEffect(PotionEffectType.FAST_DIGGING);
        }
    }

    private boolean isWearingCustomArmor(Player player) {
        ItemStack helmet = player.getInventory().getHelmet();
        ItemStack chestplate = player.getInventory().getChestplate();
        ItemStack leggings = player.getInventory().getLeggings();
        ItemStack boots = player.getInventory().getBoots();

        // Define the names of your custom armor items
        String customHelmetName = "§fEmerald Helmet";
        String customChestplateName = "§fEmerald Chestplate";
        String customLeggingsName = "§fEmerald Leggings";
        String customBootsName = "§fEmerald Boots";

        // Check if all armor pieces have the expected custom names
        boolean hasCustomHelmet = helmet != null && helmet.hasItemMeta() && helmet.getItemMeta().hasDisplayName() && helmet.getItemMeta().getDisplayName().equals(customHelmetName);
        boolean hasCustomChestplate = chestplate != null && chestplate.hasItemMeta() && chestplate.getItemMeta().hasDisplayName() && chestplate.getItemMeta().getDisplayName().equals(customChestplateName);
        boolean hasCustomLeggings = leggings != null && leggings.hasItemMeta() && leggings.getItemMeta().hasDisplayName() && leggings.getItemMeta().getDisplayName().equals(customLeggingsName);
        boolean hasCustomBoots = boots != null && boots.hasItemMeta() && boots.getItemMeta().hasDisplayName() && boots.getItemMeta().getDisplayName().equals(customBootsName);

        // Return true if all armor pieces have the expected custom names
        return hasCustomHelmet && hasCustomChestplate && hasCustomLeggings && hasCustomBoots;
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
