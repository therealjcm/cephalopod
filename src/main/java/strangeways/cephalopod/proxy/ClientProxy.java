package strangeways.cephalopod.proxy;

import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import strangeways.cephalopod.MainMod;
import strangeways.cephalopod.item.ItemMgr;

/**
 * Created by jasonm on 9/6/2016.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        // OBJLoader.INSTANCE.addDomain(MainMod.MODID);
        // ItemMgr.registerModels();
    }



    @Override
    public void init(FMLInitializationEvent event)
    {
        ItemMgr.registerRenders();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}
