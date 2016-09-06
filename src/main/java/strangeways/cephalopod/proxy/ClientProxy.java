package strangeways.cephalopod.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by jasonm on 9/6/2016.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        System.out.println("XXX client pre");
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        System.out.println("XXX client init");
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        System.out.println("XXX client post");
    }
}
