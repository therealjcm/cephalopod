package strangeways.cephalopod.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import strangeways.cephalopod.MainMod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jasonm on 9/6/2016.
 *
 * Static methods and data structures to initialize and register the Item instances in the mod
 */
public class ItemMgr {
    private static Map<String, Item> modItems;

    public static void preInit()
    {
        modItems = new HashMap<>();
        modItems.put("tutorial_item", new ModItem("tutorial_item"));
        modItems.put("sword_of_tides", new ModWeaponItem(Item.ToolMaterial.IRON, "sword_of_tides"));

        registerItems();
    }

    public static void registerItems()
    {
        modItems.forEach((name, item) -> {
            GameRegistry.register(item, new ResourceLocation(MainMod.MODID, name));
        });
    }

    public static void registerRenders()
    {
        modItems.forEach((name, item) -> {
            registerRender(name, item);
        });
    }

    private static void registerRender(String name, Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().
                register(item, 0, new ModelResourceLocation(MainMod.MODID + ":" + name, "inventory"));
    }

    private static void registerModel(String name, Item item)
    {
        ModelLoader.setCustomModelResourceLocation(
                item, 0, new ModelResourceLocation(MainMod.MODID + ":" + name, "inventory"));
    }

    public static void registerModels()
    {
    }
}
