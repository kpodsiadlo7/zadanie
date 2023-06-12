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
        return getBlockByColor(color);
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return getListOfBlocksByMaterial(material);
    }

    //Returns count of all elements in list of blocks
    @Override
    public int count() {
        return getCountOfAllElements();
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

    private Optional<Block> getBlockByColor(String color){
        if (validateInputStringIsNotNull(color)){
            blocks = getBlocks();
            if (validateInputListIsNotNullOrEmpty(blocks)) {
                return Optional.empty();
            }
            throw new IllegalArgumentException("Color is null");
        }
        return blocks.stream().filter(b -> b.getColor().equals(color)).findFirst();
    }

    private List<Block> getListOfBlocksByMaterial(String material){
        if (validateInputStringIsNotNull(material)){
            blocks = getBlocks();
            if (validateInputListIsNotNullOrEmpty(blocks)){
                return new ArrayList<>();
            }
            throw new IllegalArgumentException("Material is null");
        }
        return blocks.stream().filter(b -> b.getMaterial().equals(material)).toList();
    }

    private int getCountOfAllElements(){
        blocks = getBlocks();
        if (validateInputListIsNotNullOrEmpty(blocks))
            return 0;
        return blocks.size();
    }

    private boolean validateInputStringIsNotNull(String inputData){
        return inputData == null;
    }

    private boolean validateInputListIsNotNullOrEmpty(List<Block> inputList){
        return inputList == null || inputList.isEmpty();
    }
}
