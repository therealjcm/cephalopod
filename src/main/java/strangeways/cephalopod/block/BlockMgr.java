package strangeways.cephalopod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import strangeways.cephalopod.MainMod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jasonm on 9/9/2016.
 */
public class BlockMgr {
    private static Map<String, Block> modBlocks;

    public static void preInit()
    {
        modBlocks = new HashMap<>();
        modBlocks.put("tutorial_block", new ModBlock(Material.ROCK, "tutorial_block"));

        registerBlocks();
    }

    private static void registerBlocks()
    {
        modBlocks.forEach((name, block) -> registerBlock(name, block));
    }

    private static void registerBlock(String name, Block block)
    {
        GameRegistry.register(block, new ResourceLocation(MainMod.MODID, name));
        GameRegistry.register(new ItemBlock(block), new ResourceLocation(MainMod.MODID, name));
    }

    public static void registerRenders()
    {
        modBlocks.forEach((name, block) -> registerRender(name, block));
    }

    private static void registerRender(String name, Block block)
    {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().
                register(item, 0, new ModelResourceLocation(MainMod.MODID + ":" + name, "inventory"));
    }
}
