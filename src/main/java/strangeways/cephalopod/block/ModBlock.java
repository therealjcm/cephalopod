package strangeways.cephalopod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
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

    @Override
    public boolean addDestroyEffects(World world, BlockPos pos, ParticleManager manager)
    {
        TextComponentString msg = new TextComponentString(TextFormatting.DARK_GREEN +
                "addDestroyEffects");
        if (world.isRemote)
        {
            msg.appendText("-remote");
        }
        world.playerEntities.stream().forEach((player) -> player.addChatComponentMessage(msg));
        // EntityPlayer player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10f, true);
        // player.addChatComponentMessage(msg);
        return super.addDestroyEffects(world, pos, manager);
    }
}
