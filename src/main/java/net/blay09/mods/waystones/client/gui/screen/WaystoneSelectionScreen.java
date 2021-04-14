package net.blay09.mods.waystones.client.gui.screen;

import net.blay09.mods.waystones.api.IWaystone;
import net.blay09.mods.waystones.container.WaystoneSelectionContainer;
import net.blay09.mods.waystones.core.PlayerWaystoneManager;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

import java.util.List;

public class WaystoneSelectionScreen extends WaystoneSelectionScreenBase {

    public WaystoneSelectionScreen(WaystoneSelectionContainer container, PlayerInventory playerInventory, ITextComponent title) {
        super(container, playerInventory, title);
    }

    @Override
    protected List<IWaystone> getWaystones() {
        return PlayerWaystoneManager.getWaystones(playerInventory.player);
    }
}
