package me.nick1666.shaddy.events;

import me.nick1666.shaddy.items.ItemManager;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static me.nick1666.shaddy.items.ItemManager.TestTube;

public class TestTubeNade implements Listener {
    @EventHandler
    public void onTestTubeThrow(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action a = e.getAction();
        boolean isRightClick = a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK);
        if(!isRightClick) return;

        ItemStack item = e.getItem();
        assert item != null;

        if(!item.asQuantity(1).equals(TestTube)) return;

        Location loc = p.getEyeLocation().add(p.getLocation().getDirection());
        Snowball snowball = p.getWorld().spawn(loc, Snowball.class);
        snowball.setItem(item);
        snowball.setVelocity(p.getLocation().getDirection().multiply(5));

        // decrease the number of test tubes the player is holding
        item.setAmount(item.getAmount() - 1);
    }

    @EventHandler
    public void onTestTubeHit(ProjectileHitEvent e) {
        Projectile p = e.getEntity();
        if(p instanceof Snowball) {
            Snowball snowball = (Snowball)p;
            ItemStack item = snowball.getItem();
            if(item.equals(TestTube)) {
                Location loc = e.getHitBlock() == null ? e.getHitEntity().getLocation() : e.getHitBlock().getLocation();
                loc.getWorld().createExplosion(loc, 3, true, true);
            }
        }
    }
}
