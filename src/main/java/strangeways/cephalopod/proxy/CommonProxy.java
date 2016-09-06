package strangeways.cephalopod.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by jasonm on 9/6/2016.
 */
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event)
    {
        System.out.println("XXX common pre");
    }

    public void init(FMLInitializationEvent event)
    {
        System.out.println("XXX common init");
    }

    public void postInit(FMLPostInitializationEvent event)
    {
        System.out.println("XXX common post");
    }
}
