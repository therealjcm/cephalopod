package strangeways.cephalopod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import strangeways.cephalopod.MainMod;

/**
 * Created by jasonm on 9/9/2016.
 */
public class ModBlock extends Block {
    public ModBlock(Material material, String name)
    {
        super(material);
        setUnlocalizedName(name);
        setCreativeTab(MainMod.tabTutorial);
        setHardness(10f);
    }
}
