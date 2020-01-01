package net.blay09.mods.waystones;

import net.blay09.mods.waystones.api.IWaystone;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraftforge.common.util.Constants;

@Deprecated
public class PlayerWaystoneData {

    private final IWaystone[] entries;
    private final long lastFreeWarp;
    private final long lastWarpStoneUse;

    public PlayerWaystoneData(IWaystone[] entries, long lastFreeWarp, long lastWarpStoneUse) {
        this.entries = entries;
        this.lastFreeWarp = lastFreeWarp;
        this.lastWarpStoneUse = lastWarpStoneUse;
    }

    public IWaystone[] getWaystones() {
        return entries;
    }

    public long getLastFreeWarp() {
        return lastFreeWarp;
    }

    public long getLastWarpStoneUse() {
        return lastWarpStoneUse;
    }

    public void store(ServerPlayerEntity player) {
        PlayerWaystoneHelper.store(player, entries, lastFreeWarp, lastWarpStoneUse);
    }

    public static PlayerWaystoneData fromPlayer(PlayerEntity player) {
        CompoundNBT tagCompound = PlayerWaystoneHelper.getWaystonesTag(player);
        ListNBT tagList = tagCompound.getList(PlayerWaystoneHelper.WAYSTONE_LIST, Constants.NBT.TAG_COMPOUND);
        IWaystone[] entries = new IWaystone[tagList.size()];
        for (int i = 0; i < entries.length; i++) {
            // TODO entries[i] = IWaystone.read(tagList.getCompound(i));
        }
        long lastFreeWarp = tagCompound.getLong(PlayerWaystoneHelper.LAST_FREE_WARP);
        long lastWarpStoneUse = tagCompound.getLong(PlayerWaystoneHelper.LAST_WARP_STONE_USE);
        return new PlayerWaystoneData(entries, lastFreeWarp, lastWarpStoneUse);
    }

}
