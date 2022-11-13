/*
    Simple backport of new minecraft features to mc 1.12.2
    Copyright (C) 2022 WolodiaM

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

// Java package
package my.wolodiam.simplebackport.utils.registry;
// Import Java classes
import java.util.ArrayList;
// Import minecraft forge classes
import net.minecraftforge.client.event.*;
import net.minecraftforge.event.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.eventhandler.*;
// Import minecraft classes
import net.minecraft.block.Block;
import net.minecraft.item.Item;
// Import mod classes
import my.wolodiam.simplebackport.utils.*;
import my.wolodiam.simplebackport.mc1_20.blocks.signs.*;
import my.wolodiam.simplebackport.utils.registry.data.BlockRegistryType;

@Mod.EventBusSubscriber(modid = DATA.MODID)
public class BlockRegister {
    /*
     *      1.20
     * oak_hanging_sign_top_full
     * oak_hanging_sign_side
     * dark_oak_hanging_sign_top_full
     * dark_oak_hanging_sign_side
     * spruce_hanging_sign_top_full
     * spruce_hanging_sign_side
     * birch_hanging_sign_top_full
     * birch_hanging_sign_side
     * acacia_hanging_sign_top_full
     * acacia_hanging_sign_side
     * jungle_hanging_sign_top_full
     * jungle_hanging_sign_side
     */
    public static ArrayList<BlockRegistryType> BLOCKS = new ArrayList<BlockRegistryType>();
    public static Block OAK_HANGING_SIGN_TOP_FULL;
    public static Block OAK_HANGING_SIGN_SIDE;
    public static Block SPRUCE_HANGING_SIGN_TOP_FULL;
    public static Block SPRUCE_HANGING_SIGN_SIDE;
    public static Block BIRCH_HANGING_SIGN_TOP_FULL;
    public static Block BIRCH_HANGING_SIGN_SIDE;
    public static Block DARK_OAK_HANGING_SIGN_TOP_FULL;
    public static Block DARK_OAK_HANGING_SIGN_SIDE;

    public static Block get(String id) {
        for (BlockRegistryType data : BLOCKS) {
            if (data.id == id) {
                return data.block;
            }
        }
        return null;
    }

    public static void init() {
        BLOCKS.add(new BlockRegistryType(new OakHangingSignTopFullBlock("oak_hanging_sign_top_full"), "oak_hanging_sign_top_full"));
        BLOCKS.add(new BlockRegistryType(new OakHangingSignSideBlock("oak_hanging_sign_side"), "oak_hanging_sign_side"));
        BLOCKS.add(new BlockRegistryType(new SpruceHangingSignTopFullBlock("spruce_hanging_sign_top_full"), "spruce_hanging_sign_top_full"));
        BLOCKS.add(new BlockRegistryType(new SpruceHangingSignSideBlock("spruce_hanging_sign_side"), "spruce_hanging_sign_side"));
        BLOCKS.add(new BlockRegistryType(new BirchHangingSignTopFullBlock("birch_hanging_sign_top_full"), "birch_hanging_sign_top_full"));
        BLOCKS.add(new BlockRegistryType(new BirchHangingSignSideBlock("birch_hanging_sign_side"), "birch_hanging_sign_side"));
        BLOCKS.add(new BlockRegistryType(new DarkOakHangingSignTopFullBlock("dark_oak__hanging_sign_top_full"), "dark_oak__hanging_sign_top_full"));
        BLOCKS.add(new BlockRegistryType(new DarkOakHangingSignSideBlock("dark_oak_hanging_sign_side"), "dark_oak_hanging_sign_side"));
        BLOCKS.add(new BlockRegistryType(new AcaciaHangingSignTopFullBlock("acacia_hanging_sign_top_full"), "acacia_hanging_sign_top_full"));
        BLOCKS.add(new BlockRegistryType(new AcaciaHangingSignSideBlock("acacia_hanging_sign_side"), "acacia_hanging_sign_side"));
        BLOCKS.add(new BlockRegistryType(new JungleHangingSignTopFullBlock("jungle_hanging_sign_top_full"), "jungle_hanging_sign_top_full"));
        BLOCKS.add(new BlockRegistryType(new JungleHangingSignSideBlock("jungle_hanging_sign_side"), "jungle_hanging_sign_side"));
        OAK_HANGING_SIGN_TOP_FULL      = get("oak_hanging_sign_top_full");
        OAK_HANGING_SIGN_SIDE          = get("oak_hanging_sign_side");
        SPRUCE_HANGING_SIGN_TOP_FULL   = get("spruce_hanging_sign_top_full");
        SPRUCE_HANGING_SIGN_SIDE       = get("spruce_hanging_sign_side");
        BIRCH_HANGING_SIGN_TOP_FULL    = get("birch_hanging_sign_top_full");
        BIRCH_HANGING_SIGN_SIDE        = get("birch_hanging_sign_side");
        DARK_OAK_HANGING_SIGN_TOP_FULL = get("dark_oak__hanging_sign_top_full");
        DARK_OAK_HANGING_SIGN_SIDE     = get("dark_oak_hanging_sign_side");
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        for (BlockRegistryType data : BLOCKS) {
            event.getRegistry().registerAll(data.block);
        }
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {

    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {

    }
}
