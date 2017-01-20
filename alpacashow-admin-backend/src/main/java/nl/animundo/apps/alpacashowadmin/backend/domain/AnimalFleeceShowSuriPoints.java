package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnimalFleeceShowSuriPoints {
    private static Logger logger = LoggerFactory.getLogger(ShowEventAnimal.class);

    private String showEventKey;
    private int startNumber;
    private float finessAndHandle; // 20
    private float uniformityOfMicron; //10
    private float uniformityOfLenght; // 10
    private float uniformityOfColor; // 5
    private float styleAndCharacter; // 10
    private float desity; // 5
    private float lusture; // 15
    private float lackOfGuardHair; // 5
    private float lackOfImpurities; // 5
    private float cleanFleeceWeight; // 15
    private float total; // 100



    public AnimalFleeceShowSuriPoints(final String showEventKey, final int startNumber, final float finessAndHandle, final float uniformityOfMicron,
                                      final float uniformityOfLenght, final float uniformityOfColor, final float styleAndCharacter, final float desity,
                                      final float lusture, final float lackOfGuardHair, final float lackOfImpurities, final float cleanFleeceWeight, final float total) {
        this.showEventKey = showEventKey;
        this.startNumber = startNumber;
        this.finessAndHandle = finessAndHandle;
        this.uniformityOfMicron = uniformityOfMicron;
        this.uniformityOfLenght = uniformityOfLenght;
        this.uniformityOfColor = uniformityOfColor;
        this.styleAndCharacter = styleAndCharacter;
        this.desity = desity;
        this.lusture = lusture;
        this.lackOfGuardHair = lackOfGuardHair;
        this.lackOfImpurities = lackOfImpurities;
        this.cleanFleeceWeight = cleanFleeceWeight;
        this.total = total;
    }

    public String getShowEventKey() {
        return showEventKey;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public float getFinessAndHandle() {
        return finessAndHandle;
    }

    public void setFinessAndHandle(float finessAndHandle) {
        this.finessAndHandle = finessAndHandle;
    }

    public float getUniformityOfMicron() {
        return uniformityOfMicron;
    }

    public void setUniformityOfMicron(float uniformityOfMicron) {
        this.uniformityOfMicron = uniformityOfMicron;
    }

    public float getUniformityOfLenght() {
        return uniformityOfLenght;
    }

    public void setUniformityOfLenght(float uniformityOfLenght) {
        this.uniformityOfLenght = uniformityOfLenght;
    }

    public float getUniformityOfColor() {
        return uniformityOfColor;
    }

    public void setUniformityOfColor(float uniformityOfColor) {
        this.uniformityOfColor = uniformityOfColor;
    }

    public float getStyleAndCharacter() {
        return styleAndCharacter;
    }

    public void setStyleAndCharacter(float styleAndCharacter) {
        this.styleAndCharacter = styleAndCharacter;
    }

    public float getDesity() {
        return desity;
    }

    public void setDesity(float desity) {
        this.desity = desity;
    }

    public float getLusture() {
        return lusture;
    }

    public void setLusture(float lusture) {
        this.lusture = lusture;
    }

    public float getLackOfGuardHair() {
        return lackOfGuardHair;
    }

    public void setLackOfGuardHair(float lackOfGuardHair) {
        this.lackOfGuardHair = lackOfGuardHair;
    }

    public float getLackOfImpurities() {
        return lackOfImpurities;
    }

    public void setLackOfImpurities(float lackOfImpurities) {
        this.lackOfImpurities = lackOfImpurities;
    }

    public float getCleanFleeceWeight() {
        return cleanFleeceWeight;
    }

    public void setCleanFleeceWeight(float cleanFleeceWeight) {
        this.cleanFleeceWeight = cleanFleeceWeight;
    }

    public float getTotal() {
        total = finessAndHandle +
                uniformityOfMicron +
                uniformityOfLenght +
                uniformityOfColor +
                styleAndCharacter +
                desity +
                lusture +
                lackOfGuardHair +
                lackOfImpurities +
                cleanFleeceWeight;
        return total;
    }
}
