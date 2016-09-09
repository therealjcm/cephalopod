package strangeways.cephalopod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import strangeways.cephalopod.item.ItemMgr;
import strangeways.cephalopod.proxy.CommonProxy;
import strangeways.cephalopod.tab.CreativeTabTutorial;

@Mod(modid = MainMod.MODID, version = MainMod.VERSION, name = MainMod.NAME)
public class MainMod
{
    public static final String MODID = "cephalopod";
    public static final String VERSION = "1.0.0";
    public static final String NAME = "Cephalopod Conspiracy";

    @SidedProxy(clientSide = "strangeways.cephalopod.proxy.ClientProxy",
            serverSide = "strangeways.cephalopod.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static MainMod instance;

    public static CreativeTabTutorial tabTutorial;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        tabTutorial = new CreativeTabTutorial(CreativeTabs.getNextID(), "tab_tutorial");
        ItemMgr.preInit();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }

}
