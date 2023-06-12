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
        if (validateInputStringIsNotNull(color)){
            blocks = getBlocks();
            if (validateInputListIsNotNullOrEmpty(blocks)) {
                return Optional.empty();
            }
            throw new IllegalArgumentException("Color is null");
        }
        return blocks.stream().filter(b -> b.getColor().equals(color)).findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if (validateInputStringIsNotNull(material)){
            blocks = getBlocks();
            if (validateInputListIsNotNullOrEmpty(blocks)){
                return new ArrayList<>();
            }
            throw new IllegalArgumentException("Material is null");
        }
        return blocks.stream().filter(b -> b.getMaterial().equals(material)).toList();
    }

    @Override
    public int count() {
        blocks = getBlocks();
        if (validateInputListIsNotNullOrEmpty(blocks))
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

    private boolean validateInputStringIsNotNull(String inputData){
        return inputData == null;
    }

    private boolean validateInputListIsNotNullOrEmpty(List<Block> inputList){
        return inputList == null || inputList.isEmpty();
    }
}
