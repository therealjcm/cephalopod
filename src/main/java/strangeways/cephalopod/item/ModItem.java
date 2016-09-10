package strangeways.cephalopod.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import strangeways.cephalopod.MainMod;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by jasonm on 9/6/2016.
 */
public class ModItem extends Item {
    public ModItem(String name)
    {
        setUnlocalizedName(name);
        setCreativeTab(MainMod.tabTutorial);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World world,
                                                    EntityPlayer player, EnumHand hand)
    {
        TextComponentString msg = new TextComponentString(TextFormatting.GOLD +
                "onItemRightClick");
        if (world.isRemote)
        {
            msg.appendText("-remote");
        }

        player.addChatComponentMessage(msg);
        System.out.println("Make stdout sing!");
        return super.onItemRightClick(itemStackIn, world, player, hand);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip,
                               boolean advanced)
    {
        TextComponentString msg = new TextComponentString(TextFormatting.BLUE +
                "addInformation");
        player.addChatComponentMessage(msg);
        tooltip.add(TextFormatting.GRAY + "" + TextFormatting.ITALIC + "happy");
        super.addInformation(stack, player, tooltip, advanced);
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world,
                                      BlockPos pos, EnumHand hand, EnumFacing facing, float hitX,
                                      float hitY, float hitZ)
    {
        TextComponentString msg = new TextComponentString(TextFormatting.WHITE +
                "onItemUse");
        if (world.isRemote)
        {
            msg.appendText("-remote");
        }
        player.addChatComponentMessage(msg);
        return super.onItemUse(stack, player, world, pos, hand, facing, hitX, hitY, hitZ);
    }

    @Nullable
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entityLiving)
    {
        System.out.println("onItemUseFinish");
        TextComponentString msg = new TextComponentString(TextFormatting.RED +
                "onItemUseFinish");
        if (world.isRemote)
        {
            msg.appendText("-remote");
        }
        EntityPlayer player = (EntityPlayer) entityLiving;
        player.addChatComponentMessage(msg);
        return super.onItemUseFinish(stack, world, entityLiving);
    }

    @Override
    public EnumActionResult onItemUseFirst(ItemStack stack, EntityPlayer player, World world,
                                           BlockPos pos, EnumFacing side, float hitX, float hitY,
                                           float hitZ, EnumHand hand)
    {
        TextComponentString msg = new TextComponentString(TextFormatting.DARK_GREEN +
                "onItemUseFirst");
        if (world.isRemote)
        {
            msg.appendText("-remote");
        }
        player.addChatComponentMessage(msg);
        return super.onItemUseFirst(stack, player, world, pos, side, hitX, hitY, hitZ, hand);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase entityLiving,
                                     int timeLeft)
    {
        System.out.println("onPlayerStoppedUsing");
        TextComponentString msg = new TextComponentString(TextFormatting.RED +
                "onPlayerStoppedUsing");
        if (world.isRemote)
        {
            msg.appendText("-remote");
        }
        EntityPlayer player = (EntityPlayer) entityLiving;
        player.addChatComponentMessage(msg);
        super.onPlayerStoppedUsing(stack, world, entityLiving, timeLeft);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
