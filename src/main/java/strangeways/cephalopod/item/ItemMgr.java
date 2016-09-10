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
    private static Map<String, Item> jsonModItems;
    private static Map<String, Item> objModItems;

    public static void preInit()
    {
        jsonModItems = new HashMap<>();
        objModItems = new HashMap<>();

        jsonModItems.put("tutorial_item", new ModItem("tutorial_item"));
        jsonModItems.put("sword_of_tides", new ModWeaponItem(Item.ToolMaterial.IRON, "sword_of_tides"));

        registerItems();
    }

    private static void registerItems()
    {
        jsonModItems.forEach((name, item) -> {
            GameRegistry.register(item, new ResourceLocation(MainMod.MODID, name));
        });
        objModItems.forEach((name, item) -> {
            GameRegistry.register(item, new ResourceLocation(MainMod.MODID, name));
        });
    }

    public static void registerJsonModels()
    {
        jsonModItems.forEach((name, item) -> {
            registerJsonModel(name, item);
        });
    }

    private static void registerJsonModel(String name, Item item)
    {
        System.out.printf("DEBUG: json model(%s)\n", name);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().
                register(item, 0, new ModelResourceLocation(MainMod.MODID + ":" + name, "inventory"));
    }

    public static void registerObjModels()
    {
        objModItems.forEach((name, item) -> {
            registerObjModel(name, item);
        });
    }

    private static void registerObjModel(String name, Item item)
    {
        System.out.printf("DEBUG: obj model(%s)\n", name);
        ModelLoader.setCustomModelResourceLocation(
                item, 0, new ModelResourceLocation(MainMod.MODID + ":" + name, "inventory"));
    }
}
