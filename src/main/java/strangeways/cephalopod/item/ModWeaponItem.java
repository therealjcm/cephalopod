package strangeways.cephalopod.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import strangeways.cephalopod.MainMod;

/**
 * Created by jasonm on 9/7/2016.
 */
public class ModWeaponItem extends ItemSword {
    public ModWeaponItem(ToolMaterial material, String name)
    {
        super(material);
        setUnlocalizedName(name);
        setCreativeTab(MainMod.tabTutorial);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, IBlockState state, BlockPos pos,
                                    EntityLivingBase entityLiving)
    {
        return true;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        if (target.isInWater())
        {
            Vec3d v = target.getPositionVector();
            World world = attacker.getEntityWorld();
            EntityLightningBolt bolt = new EntityLightningBolt(world, v.xCoord, v.yCoord, v.zCoord, true);
            world.addWeatherEffect(bolt);
            target.attackEntityFrom(DamageSource.lightningBolt, 10.0F);
            return true;
        }
        return super.hitEntity(stack, target, attacker);
    }
}
