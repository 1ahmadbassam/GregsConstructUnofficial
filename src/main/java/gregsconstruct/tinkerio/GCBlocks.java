package gregsconstruct.tinkerio;

import mezz.jei.api.IModRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import tinker_io.TinkerIO;
import tinker_io.plugins.jei.smartOutput.SmartOutputRecipeCategory;

import javax.annotation.Nonnull;

public class GCBlocks {
    private static final String porcelainName = "smart_output_porcelain";
    public static final BlockSmartOutput smartOutputPorcelain = new BlockSmartOutput(porcelainName, TinkerIO.MOD_ID + ":" + porcelainName);
    private static final String scorchedName = "smart_output_scorched";
    public static final BlockSmartOutput smartOutputScorched = new BlockSmartOutput(scorchedName, TinkerIO.MOD_ID + ":" + scorchedName);

    private GCBlocks() {
    }

    public static void register(IForgeRegistry<Block> registry) {
        if (Loader.isModLoaded("tcomplement")) {
            if (Loader.isModLoaded("ceramics")) {
                registry.register(smartOutputPorcelain);
            }
            registry.register(smartOutputScorched);
        }
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        if (Loader.isModLoaded("tcomplement")) {
            if (Loader.isModLoaded("ceramics")) {
                registry.register(smartOutputPorcelain.createItemBlock());
            }
            registry.register(smartOutputScorched.createItemBlock());
        }
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels() {
        if (Loader.isModLoaded("tcomplement")) {
            if (Loader.isModLoaded("ceramics"))
                smartOutputPorcelain.registerItemModel(ItemBlock.getItemFromBlock(smartOutputPorcelain));
            smartOutputScorched.registerItemModel(ItemBlock.getItemFromBlock(smartOutputScorched));
        }
    }

    public static void loadJEI(@Nonnull IModRegistry registry) {
        if (Loader.isModLoaded("tinker_io") && Loader.isModLoaded("tcomplement")) {
            if (Loader.isModLoaded("ceramics"))
                registry.addRecipeCatalyst(new ItemStack(GCBlocks.smartOutputPorcelain), SmartOutputRecipeCategory.CATEGORY);
            registry.addRecipeCatalyst(new ItemStack(GCBlocks.smartOutputScorched), SmartOutputRecipeCategory.CATEGORY);
        }
    }
}
