package domain;

import interfaces.Block;
import interfaces.CompositeBlock;
import interfaces.Structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure, CompositeBlock {
    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        blocks = getBlocks();
        if (validateData(blocks)) {
            return Optional.empty();
        }
        return blocks.stream().filter(b -> b.getColor().equals(color)).findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        blocks = getBlocks();
        if (validateData(blocks)){
            return new ArrayList<>();
        }
        return blocks.stream().filter(b -> b.getMaterial().equals(material)).toList();
    }

    @Override
    public int count() {
        blocks = getBlocks();
        if (validateData(blocks))
            return 0;
        return blocks.size();
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public String getMaterial() {
        return null;
    }

    @Override
    public List<Block> getBlocks() {
        return null;
    }

    boolean validateData(List<Block> inputList){
        return inputList == null;
    }
}
